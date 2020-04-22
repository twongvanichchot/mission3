package com.example.demo;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PetRowMapper implements RowMapper<pet> {
    @Override
    public pet mapRow(ResultSet rs, int rowNum) throws SQLException{
        pet pet = new pet();
        pet.setId(rs.getString("id"));
        pet.setName(rs.getString("name"));
        pet.setType(rs.getString("type"));
        pet.setGender(rs.getString("gender"));
        pet.setPrice(rs.getDouble("price"));
        return pet;
    }
}
