package coms.sakthi.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coms.sakthi.quiz.QuestionEntity.QuestionEntity;

@Repository
public interface QuestionDao extends JpaRepository<QuestionEntity,Integer> {

	List<QuestionEntity> findByCategory(String category);
	

}
