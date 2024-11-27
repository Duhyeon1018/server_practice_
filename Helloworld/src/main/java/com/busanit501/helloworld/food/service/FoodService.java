package com.busanit501.helloworld.food.service;

import com.busanit501.helloworld.food.VO.FoodVO;
import com.busanit501.helloworld.food.dao.FoodDAO;
import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.jdbcex.dao.TodoDAO;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.util.MapperUtil;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 설정1
@Log4j2
public enum FoodService {
    INSTANCE;
    // 2가지, 다른 클래스에 의존함.
    // 1) 모델 맵퍼 기능
    // 2) DAO 기능

    private FoodDAO foodDAO;
    private ModelMapper modelMapper;

    // 생성자 이용해서, 초기화하기.
    FoodService() {
        foodDAO = new FoodDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }


    //1
    // register
    // 화면에서 등록된 내용이 -> DTO 박스에 담아서-> 서비스 계층에 전달.
    public void register(FoodDTO foodDTO) throws SQLException {

        // 모델 맵퍼 이용시.
        FoodVO foodVO = modelMapper.map(foodDTO, FoodVO.class);
        // 기존 로깅 기록 출력
//        System.out.println("todoVo : "+ todoVO);
        log.info("foodVo : " + foodVO);

        // DAO 외주 맡기기,
        foodDAO.insert(foodVO);
    } // register

    //2
    // 전체 조회
    public List<FoodDTO> listAll() throws SQLException {
        List<FoodVO> voList = FoodDAO.selectAll();
        log.info("voList : " + voList);




        List<FoodDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, FoodDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    //3
    // 하나 조회, 상세보기.
    public FoodDTO get(Long tno) throws SQLException {
        log.info("tno : " + tno);
        ///  디비에서 하나 조회 결과 받았음.
        FoodVO foodVO = foodDAO.selectOne(tno);
        // VO -> DTO 변환 작업.
        FoodDTO foodDTO = modelMapper.map(foodVO,FoodDTO.class);
        return foodDTO;

    }

    //4 수정 기능
    public void update(FoodDTO foodDTO) throws SQLException {

        log.info("foodDTO : " + foodDTO);
        FoodVO foodVO = modelMapper.map(foodDTO, FoodVO.class);
        foodDAO.updateOne(foodVO);

    }

    //5 삭제 기능.
    public void delete(Long tno) throws SQLException {
        foodDAO.deleteFood(tno);
    }

}






