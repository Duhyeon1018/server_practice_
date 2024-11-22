package com.busanit501.helloworld.jdbcex;

import com.busanit501.helloworld.jdbcex.dto.TodoVO;
import org.junit.jupiter.api.Test;

public class VoTest {
    @Test
    public void test() {
        TodoVO todoVO = new TodoVO();
        //간단히 롬복 이용하면 메모리상에 , get, set, toString 등을 올려서 바로 소스코드를 사용가능함
        //@Data << 쓰면 됨. 그럼 가독성도 올라감
    }
}
