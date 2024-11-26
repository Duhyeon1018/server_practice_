package com.busanit501.helloworld.food.dao;

import com.busanit501.helloworld.jdbcex.dao.ConnectionUtil;
import com.busanit501.helloworld.food.VO.FoodVO;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO {

    //Todo 등록기능 추가하기
    //VO(Value Objcct, 실제 디비 컬럼과 일치)
    //서비스 계층에서 VO넘겨받은 데이터중에서 보여줄 데이터만 따로 분리해서
    //전달하는 용도로 사용하는 DTO입니다
    public void insert(FoodVO foodVO) throws SQLException {


        String sql = "insert into food_menu (title, dueDate, finished)" +
                "values (?, ?, ?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, foodVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(foodVO.getDueDate()));
        preparedStatement.setBoolean(3,foodVO.isFinished());
        preparedStatement.executeUpdate();

    } //insert

    //2
    // select , DB에서 전체 조회.
    public static List<FoodVO> selectAll() throws SQLException {
        String sql = "select * from food_menu";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        // 넘어온 데이터를 임시로 보관할 리스트 인스턴스 만들고,
        // 반복문 통해서, 넘어온 각행을 리스트에 요소로 하나씩 담기.
        List<FoodVO> list = new ArrayList<>();
        while (resultSet.next()) {
            FoodVO foodVO = FoodVO.builder()
                    .tno(resultSet.getLong("tno"))
                    .title(resultSet.getString("title"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build();
            list.add(foodVO);
        }
        return list;
    }

    //3, 하나 조회. 상세보기.
    public FoodVO selectOne(Long tno) throws SQLException {
        String sql = "select * from food_menu where tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);
        // 하나만 받아온 상태,
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        // 임시 TotoVO , 인스턴스 만들어서, 한행의 각 컬럼 4개를 담기.
        // 0행에서 -> 1행으로 조회를 해야하는데, 요게 누락됨.
        resultSet.next();
        FoodVO foodVO = FoodVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();
        return foodVO;
    }

    //수정
    // update,
    //화면에서 낱개로 넘어온 데이터는 DTO담아서 전달
    //서비스 계층에서 DTO -> VO(Value Object) 데이터베이스와 직접적인 연관
    //예시, VO클래스는 테이블과 컬럼이 동일
    //에시, DTO화면(출력에서 보여주고, 전달하고 싶은것만 골라서 사용할 수 있음)
    //화면에서 받아와서 테스트는 더미데이터 확인
    public void updateOne(FoodVO foodVO) throws SQLException {
        String sql = " update food_menu set title=?, dueDate=?, finished=?" +
                " where tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //화면에서 넘겨받은 변경할 데이터를 DTO ->VO 변환후에(서비스에서 할 예정.)
        //VO에서 꺼내서 DB로 연결하는 과정
        preparedStatement.setString(1, foodVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(foodVO.getDueDate()));
        preparedStatement.setBoolean(3, foodVO.isFinished());
        preparedStatement.setLong(4,foodVO.getTno() );
        preparedStatement.executeUpdate(); //처음에 테스트에서는 문제없지만 DB단에서 수정이 안되는 문제가 발생 -> 찾아본 결과
        // preparedStatement.executeUpdate << 이 코드를 빼먹었기 때문에 테스트에는 아무 문제 없었지만 DB단에서 수정이 안된 것.
    }

    //삭제.
    // delete,
    public void deleteFood(Long tno) throws SQLException {
        String sql = "delete from food_menu where tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection(); //연결하는거
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql); //일을 시키는게 prepare statement
        preparedStatement.setLong(1, tno); // 위에 tno =? << 이쪽에 넣는것이고, tno는 사실상 화면에서 받아오는거
        preparedStatement.executeUpdate(); //반영 exectute queary << 조회임
    }

    /// //////////////////////////////////////////////////////////////////////////////////////////////////////


    public String getTime() {
        String now = null;
        // hikariCP 이용해서,
        // 디비 연결하고,
        // sql 전달하고,
        // 결과값 받고,
        // 자원 반납
        // 자원 반납 하는 방법 2가지.
        //1)
        // try catch -> try with resource , 자동으로 자원 반납을 함.
        // autocloseable 인터페이스를 구현한 기능들만, 자동 반납.
        // 2) 애너테이션 이용해서, @cleanup , 이용하면, 간단히 자동 반납.
        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("select now()");
             ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            resultSet.next();
            now = resultSet.getString(1);

        } catch (Exception e) {
            e.printStackTrace();
        } //catch
        return now;
    } //getTime

    public String getTime2() throws SQLException {
        String now = null;
        // 자동으로 디비의 connection 반납하는 방법2
        // @Cleanup
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("select now()");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        now = resultSet.getString(1);
        return now;
    }


} //class

