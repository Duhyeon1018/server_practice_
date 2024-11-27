package com.busanit501.helloworld.food.service;

import com.busanit501.helloworld.food.VO.FoodVO;
import com.busanit501.helloworld.food.dao.FoodDAO;
import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.util.MapperUtil;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

//설정1
@Log4j2
public enum FoodService {
    INSTANCE;
    //두가지가 필요한데 다른 클래스에 의존함
    //1) 모델매퍼 기능에 의존
    //2) DAo 기능에 의존

    private FoodDAO foodDAO;
    private ModelMapper modelMapper;

    //생성자 이용해서 초기화 하기
    FoodService() {
        foodDAO = new FoodDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    //crud 기본 테스트
    //직접적인 디비 비즈니스로직은 DAO에 전부 다 있기 때문에
    //여기서는 기능 명세서(모음집)
    //DAO에 의존해서 이용하기

    //1 register(등록)
    //화면에서 등록된 내용이 -> DTO 박스에 담아서 -> 서비스계층에 전달
    public void register(FoodDTO todoDTO) throws SQLException {
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
//        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class); // todoDTO와 TodoVO를 일치 시켜주는거임= 코드 간결화 및 가독성
//        //기존 로깅기록 출력
//        //System.out.println("todoVO :" + todoVO);
//        log.info("todoVO :" + todoVO);
//
//        //DAO에 외주 맡기기
//        foodDAO.insert(foodVO);

    } //register

    // 전체 조회
    public List<FoodDTO> listAll() throws SQLException {
        List<FoodVO> voList = FoodDAO.selectAll();
        log.info("voList : " + voList);

        List<FoodDTO> foodList = voList.stream().map(vo -> modelMapper.map(vo, FoodDTO.class))
                .collect(Collectors.toList());
        return foodList;
    }

    public FoodDTO get(Long tno) throws SQLException {
        log.info("tno : " + tno);
        ///  디비에서 하나 조회 결과 받았음.
        FoodVO foodVO = foodDAO.selectOne(tno);
        // VO -> DTO 변환 작업.
        FoodDTO foodDTO = modelMapper.map(foodVO,FoodDTO.class);
        return foodDTO;

    }
}
