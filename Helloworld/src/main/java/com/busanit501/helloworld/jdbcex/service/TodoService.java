package com.busanit501.helloworld.jdbcex.service;

import com.busanit501.helloworld.jdbcex.dao.TodoDAO;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.util.MapperUtil;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;

//설정1
@Log4j2
public enum TodoService {
    INSTANCE;
    //두가지가 필요한데 다른 클래스에 의존함
    //1) 모델매퍼 기능에 의존
    //2) DAo 기능에 의존

    private TodoDAO todoDAO;
    private ModelMapper modelMapper;

    //생성자 이용해서 초기화 하기
    TodoService(){
        todoDAO = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    //crud 기본 테스트
    //직접적인 디비 비즈니스로직은 DAO에 전부 다 있기 때문에
    //여기서는 기능 명세서(모음집)
    //DAO에 의존해서 이용하기

    //1 register(등록)
    //화면에서 등록된 내용이 -> DTO 박스에 담아서 -> 서비스계층에 전달
    public void register (TodoDTO todoDTO) throws SQLException {
        // DAO에서 작업할 때, DB에 직접적인 영향을 주는 객체를 만들었음
        // 그것이 바로 VO , 실제 비즈니스 로직에서만 사용
        // Servlet -> DTO 전달 받은 다음 -> DAO에 전달할 때, 다시 VO로 변환해야함
        // 변환하는 도구
        // 도구를 사요하지 않으면
//        TodoVO todoVO = new TodoVO();
//        todoVO.setTno(todoDTO.getTno());
//        todoVO.setTitle(todoDTO.getTitle());
//        todoVO.setDueDate(todoDTO.getDueDate());
//        todoVO.setFinished(todoDTO.isFinished()); 이렇게 하나하나 다 써야함

        //그치만 모델매퍼 사용시
        TodoVO todoVO = modelMapper.map(todoDTO,TodoVO.class); // todoDTO와 TodoVO를 일치 시켜주는거임= 코드 간결화 및 가독성
        //기존 로깅기록 출력
        //System.out.println("todoVO :" + todoVO);
        log.info("todoVO :" + todoVO);

        //DAO에 외주 맡기기
        todoDAO.insert(todoVO);

    }
}