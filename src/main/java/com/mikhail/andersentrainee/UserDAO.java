package com.mikhail.andersentrainee;

import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final UserDAO INCTANCE = new UserDAO();

    private static final String SQL_FIND_ALL = "SELECT" +
            " id, first_name, last_name, age" +
            " FROM user";

    private static final String SQL_SAVE = "INSERT INTO user (first_name, last_name, age)" +
            " VALUES (?, ?, ?)";


    @SneakyThrows
    public List<User> findAll() {
        try (Connection connection = ConnectionManager.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {


            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = User.builder()
                        .id(resultSet.getObject("id", Integer.class))
                        .firstName(resultSet.getObject("first_name", String.class))
                        .lastName(resultSet.getObject("last_name", String.class))
                        .age(resultSet.getObject("age", Integer.class))
                        .build();
                users.add(user);
            }
            return users;


        }
    }

    @SneakyThrows
    public void save(User entity) {
        try(Connection connection = ConnectionManager.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE)){
            preparedStatement.setObject(1, entity.getFirstName());
            preparedStatement.setObject(2, entity.getLastName());
            preparedStatement.setObject(3, entity.getAge());



            preparedStatement.executeUpdate();

            ResultSet genetatedKeys = preparedStatement.getGeneratedKeys();
            genetatedKeys.next();

            entity.setId(genetatedKeys.getObject(1, Integer.class));

        }

    }
    public static UserDAO getInctance (){
        return INCTANCE;
    }
}
