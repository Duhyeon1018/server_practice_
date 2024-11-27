package com.busanit501.helloworld.food.VO;

import lombok.*;

import java.time.LocalDate;

//롬복 사용하기.
//@Getter
//@Setter
//@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FoodVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
