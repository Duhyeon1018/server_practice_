package com.busanit501.helloworld.jdbcex.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//롬복 사용하기.
//@Getter
//@Setter
//@ToString
//사용용도 -> 직접적으로 DB에 반영하는 클래스 = VO(Value Object)
//그치만 DTO는 보여주고 싶은것만 보여주지만 VO는 전부 다 보여줌
@Data
@Builder
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 멤버의 파라미터로 다 이용한 생성자
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
