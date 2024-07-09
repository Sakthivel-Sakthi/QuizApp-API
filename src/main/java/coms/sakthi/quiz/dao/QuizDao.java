package coms.sakthi.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import coms.sakthi.quiz.Model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer>{

}
