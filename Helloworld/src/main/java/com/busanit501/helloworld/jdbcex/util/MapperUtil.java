package com.busanit501.helloworld.jdbcex.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public enum MapperUtil {
    // final static 사용됨
    INSTANCE;
    // 외부 라이브러리 ModelMapper 를 가져올 것임
    private ModelMapper modelMapper;

    // 생성자이용해서, ModelMapper 설정
    MapperUtil() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()
                // VO <-> DTO 서로 변환 할 때 , 멤버의 일치성 여부를 확인하는 설정
                .setFieldMatchingEnabled(true)
                // 멤버 접근시 private 접근 지정자에 접근 가능하게 하는 설정
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                // 타입이 정확하게 일치하는지 여부를 꼼꼼하고 엄격하게
                .setMatchingStrategy(MatchingStrategies.STRICT);


        
    }
    public ModelMapper get() {
        return modelMapper;
    }
}
