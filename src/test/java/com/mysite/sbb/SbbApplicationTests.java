package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import java.util.List;
// import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.cglib.core.Local;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Transactional
	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		// @Transactional 메서드를 사용하지않으면 여기서 DB 세션이 종료

		List<Answer> answerList = q.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}
	// 답변 데이터 저장
	// @Autowired
	// private AnswerRepository answerRepository;

	// @Test 
	// void testJpa() {
	// 	Optional<Question> oq = this.questionRepository.findById(2);
	// 	assertTrue(oq.isPresent());
	// 	Question q = oq.get();

	// 	Answer a = new Answer();
	// 	a.setContent("네 자동으로 생성됩니다.");
	// 	a.setQuestion(q); // 어떤 질문의 답변인지 알기 위해서 Question 객체 필요
	// 	a.setCreateDate((LocalDateTime.now()));
	// 	this.answerRepository.save(a);
	// }

	// INSERT 확인
	// @Test
	// void testJpa() {
	// 	Question q1 = new Question();
	// 	q1.setSubject("sbb가 무엇인가요?");
	// 	q1.setContent("sbb에 대해서 알고 싶습니다.");
	// 	q1.setCreateDate(LocalDateTime.now());
	// 	this.questionRepository.save(q1);

	// 	Question q2 = new Question();
	// 	q2.setSubject("스프링부트 모델 질문입니다.");
	// 	q2.setContent("id는 자동으로 생성되나요?");
	// 	q2.setCreateDate(LocalDateTime.now());
	// 	this.questionRepository.save(q2);

	// findAll 확인
	// @Test
	// void testJpa() {
	// 	List<Question> all = this.questionRepository.findAll();
	// 	assertEquals(2, all.size());

	// 	Question q = all.get(0);
	// 	assertEquals("sbb가 무엇인가요?", q.getSubject());
	// }

	//findById 확인
	// @Test
	// void testJpa() {
	// 	// Optional로 리턴 타입을 지정하고 oq.isPresent()로 존재 유무 확인
	// 	Optional<Question> oq = this.questionRepository.findById(1);
	// 	if(oq.isPresent()) {
	// 		Question q = oq.get();
	// 		assertEquals("sbb가 무엇인가요?", q.getSubject());
	// 	}
	// }

	// 수정 확인
	// @Test
	// void testJpa() {
	// 	Optional<Question> oq = this.questionRepository.findById(1);
	// 	assertTrue(oq.isPresent());
	// 	Question q = oq.get();
	// 	q.setSubject("수정된 제목");
	// 	this.questionRepository.save(q);
	
	// 삭제 확인
	// @Test
	// void Jpa() {
	// 	assertEquals(2, this.questionRepository.count());
	// 	Optional<Question> oq = this.questionRepository.findById(1);
	// 	assertTrue(oq.isPresent());
	// 	Question q = oq.get();
	// 	this.questionRepository.delete(q);
	// 	assertEquals(1, this.questionRepository.count());
	// }
}
