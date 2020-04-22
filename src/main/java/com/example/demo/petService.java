package com.example.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.util.List;


@Service
public class petService {
    DataSource dataSource = new JdbcConfig().mysqlDataSource();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    private String emptyMessage = "The table is empty";
    private String queryAll = "SELECT * FROM pet";
    private String queryById ="SELECT * FROM pet WHERE id=?";
    private String addList = "INSERT pet(id,name,type, gender, price) VALUES (MID(UUID(),1,36),?,?,?,?)";
    private String updateListById ="UPDATE pet SET name=?,type=?,gender=?,price=? WHERE id=?";
    private String deleteListById ="DELETE FROM pet WHERE id=?";
    private String deleteAll = "TRUNCATE TABLE pet";

    public Object getEmptyMessage() {
        return emptyMessage;
    }
    public List<pet> getPet() {
        return jdbcTemplate.query(queryAll, new PetRowMapper());
    }
    public List<pet> getPetById(String id) {
        return jdbcTemplate.query(queryById, new PetRowMapper(), id);
    }
    public void createPet(pet pet) {
        jdbcTemplate.update(addList, pet.getName(),pet.getType(),pet.getGender(), pet.getPrice());
    }
    public void updatePet(pet pet, String id ) {
        jdbcTemplate.update(updateListById, pet.getName(),pet.getType(),pet.getGender(), pet.getPrice(),id);
    }
    public void deletePetById(String id) {
        jdbcTemplate.update(deleteListById, id);
    }
    public void deletePet() {
        jdbcTemplate.execute(deleteAll);
    }


}
