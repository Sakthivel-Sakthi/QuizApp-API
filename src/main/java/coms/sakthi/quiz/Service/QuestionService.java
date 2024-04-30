package coms.sakthi.quiz.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import coms.sakthi.quiz.QuestionEntity.QuestionEntity;
import coms.sakthi.quiz.dao.QuestionDao;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<QuestionEntity>> getallquestions() {
		try {
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<QuestionEntity>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<String> addQuestion(QuestionEntity question) {
		try {
			questionDao.save(question);
			return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("ERROR: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<String> updateQuestion(Integer id, QuestionEntity updatedQuestion) {
		try {
			QuestionEntity existingQuestion = questionDao.findById(id).orElse(null);
			if (existingQuestion == null) {
				return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
			}
			BeanUtils.copyProperties(updatedQuestion, existingQuestion, "id");
			questionDao.save(existingQuestion);
			return new ResponseEntity<>("UPDATED", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("ERROR: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<String> deleteQuestion(Integer id) {
		try {
			if (!questionDao.existsById(id)) {
				return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
			}
			questionDao.deleteById(id);
			return new ResponseEntity<>("DELETED", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("ERROR: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	public ResponseEntity<List<QuestionEntity>> getQuestions(int page, int limit) {
//		try {
//			if (page > 0)
//				page -= 1;
//
//			Pageable pageableRequest = PageRequest.of(page, limit);
//			Page<QuestionEntity> questionsPage = questionDao.findAll(pageableRequest);
//			List<QuestionEntity> questions = new ArrayList<>();
//			for (QuestionEntity questionEntity : questionsPage.getContent()) {
//				QuestionEntity questionModel = new QuestionEntity();
//				BeanUtils.copyProperties(questionEntity, questionModel);
//				questions.add(questionModel);
//			}
//			return new ResponseEntity<>(questions, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
}
