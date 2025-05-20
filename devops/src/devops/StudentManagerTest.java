package student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentManagerTest {
	
	StudentManager studentManager;

	@BeforeEach
	void setUp() throws Exception {
		studentManager = new StudentManager();
		studentManager.addStudent("정민");
	}

	@Test
	void testAddStudent() {
		// 학생 추가에 대한 테스트
		assertTrue(studentManager.hasStudent("정민"));
	}
	
	@Test
	void testAddDuplicateStudent() {
		// 중복 추가에 대한 예외처리 확인
		assertThrows(IllegalArgumentException.class, () -> {
			studentManager.addStudent("정민");
		});
	}

	@Test
	void testRemoveStudent() {
		// 학생 제거에 대한 테스트
		studentManager.removeStudent("정민");
		assertFalse(studentManager.hasStudent("정민"));
	}
	
	@Test
	void testRemoveAbsentStudent() {
		// 존재하지 않는 학생에 대한 예외처리 확인 
		studentManager.removeStudent("정민");
		assertThrows(IllegalArgumentException.class, () -> {
			studentManager.removeStudent("정민");
		});
	}
	

	@Test
	void testHasStudent() {
		// 학생이 존재할 경우 조회 테스트
		assertTrue(studentManager.hasStudent("정민"));
	}
	
	@Test
	void testHasNotThatStudent() {
		// 학생이 존재하지 않을 경우 조회 테스트
		studentManager.removeStudent("정민");
		assertFalse(studentManager.hasStudent("정민"));
	}

}