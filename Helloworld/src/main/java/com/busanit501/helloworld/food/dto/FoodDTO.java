package com.busanit501.helloworld.food.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

//test 할 때 DATA ,BUILDER ALL, NO 다 넣어줘야함

public class FoodDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

    // 게터/세터/toString, 재정의.
    // 자바, 소스 -> 반자동으로 -> 롬복 라이브러리 사용법,

    public Long getTno() {
        return tno;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setTno(Long tno) {
        this.tno = tno;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "TodoDTO{" +
                "tno=" + tno +
                ", title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", finished=" + finished +
                '}';
    }

}
