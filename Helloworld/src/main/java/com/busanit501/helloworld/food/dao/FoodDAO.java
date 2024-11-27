package com.busanit501.helloworld.food.dao;

import com.busanit501.helloworld.food.VO.FoodVO;
import com.busanit501.helloworld.jdbcex.dao.ConnectionUtil;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO {

    public void insert(FoodVO foodVO) throws SQLException {

        String sql = "insert into food_menu (title, dueDate, finished) " +
                "values (?, ?, ?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, foodVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(foodVO.getDueDate()));
        preparedStatement.setBoolean(3, foodVO.isFinished());
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
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        FoodVO foodVO = FoodVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();
        return foodVO;
    }

    public void updateOne(FoodVO foodVO) throws SQLException {
        String sql = "update food_menu set title=?, dueDate=?, finished=?" +
                " where tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, foodVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(foodVO.getDueDate()));
        preparedStatement.setBoolean(3, foodVO.isFinished());
        preparedStatement.setLong(4,foodVO.getTno() );
        preparedStatement.executeUpdate();
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



} //class

