package coms.sakthi.quiz.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import coms.sakthi.quiz.QuestionEntity.QuestionEntity;
import coms.sakthi.quiz.Service.QuestionService;


@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;

	@GetMapping("allQuestions")
	public ResponseEntity<List<QuestionEntity>> getallquestions() {
		return questionService.getallquestions();
	}

	@GetMapping("category/{category}")
	public ResponseEntity<List<QuestionEntity>> getQuestionsByCategory(@PathVariable String category) {
		return questionService.getQuestionsByCategory(category);
	}

//	@GetMapping("/")
//
//	public ResponseEntity<List<QuestionEntity>> getQuestions(@RequestParam(value = "page", defaultValue = "0") int page,
//			@RequestParam(value = "limit", defaultValue = "25") int limit) {
//
//		List<QuestionEntity> returnValue = new ArrayList<QuestionEntity>();
//
//		List<QuestionEntity> users = questionService.getQuestions(page, limit);
//
//		for (QuestionEntity questionEntity : users) {
//			QuestionEntity questionModel = new QuestionEntity();
//			BeanUtils.copyProperties(questionEntity, questionModel);
//			returnValue.add(questionModel);
//		}
//
//		return returnValue;
//
//	}

	@PostMapping("addQuestion")
	public ResponseEntity<String> addQuestion(@RequestBody QuestionEntity question) {
		return questionService.addQuestion(question);
	}

	@PutMapping("updateQuestion/{id}")
	public ResponseEntity<String> updateQuestion(@PathVariable Integer id, @RequestBody QuestionEntity question) {
		return questionService.updateQuestion(id, question);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
		return questionService.deleteQuestion(id);

	}
}
