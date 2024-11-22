package com.busanit501.helloworld.jdbcex;

import com.busanit501.helloworld.jdbcex.dao.TodoDAO;
import com.busanit501.helloworld.jdbcex.dto.TodoVO;
import jdk.vm.ci.meta.Local;
import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;


public class TodoDAOTest {
    private TodoDAO todoDAO;

    @BeforeEach
    public void ready(){
        todoDAO = new TodoDAO();
    }

  @Test
    public void getTime(){
      System.out.println("sql 전달 후, 시간조회 확인용 " + todoDAO.getTime());
  }

    @Test
    public void getTime2() throws SQLException {
        System.out.println("sql 전달 후, 자동반납 @cleanup 확인" + todoDAO.getTime2());
    }

    @Test
    public void insertTest() throws SQLException {
        //원래 화면에서 데이터를 입력받아와서 모델에 담고,
        //모델에서 꺼내지만 임의로 더미데이터 사용함

        //1.기본 인스턴스 사용하는 방법
//        TodoVO todoVO = new TodoVO();
//        todoVO.setTitle("오늘 점심 뭐먹었나요?");
//        todoVO.setDueDate(LocalDate.of(2024, 12, 31));

        //2. Builder 패턴으로 인스턴스 만드는 방법
        //롬복에서 지원해주는 기능이라서 @Builder, TodoBO에 클래스 선언부에 작성
        TodoVO todoVO1 = TodoVO.builder()
                .title("샘플 디비 작성 테스트")
                        .dueDate(LocalDate.now())
                .build();

        todoDAO.insert(todoVO1);
    }
}
