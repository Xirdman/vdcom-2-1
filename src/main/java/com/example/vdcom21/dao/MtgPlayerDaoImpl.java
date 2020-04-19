package com.example.vdcom21.dao;

import com.example.vdcom21.mapper.mtgPlayerRowMapper;
import com.example.vdcom21.model.MtgPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MtgPlayerDaoImpl implements MtgPlayerDao {
    private NamedParameterJdbcTemplate template;

    public MtgPlayerDaoImpl(@Autowired NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<MtgPlayer> getAllMtgPlayers() {
        return template.query("SELECT * FROM mtgplayers", new mtgPlayerRowMapper());
    }

    @Override
    public MtgPlayer getById(int id) {
        final String sqlQuery = "SELECT * FROM mtgplayers WHERE id=:id";
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);
        return template.queryForObject(sqlQuery, map, new mtgPlayerRowMapper());
    }

    @Override
    public boolean updateMtgPlayer(int id, String firstName, String lastName, String dciNumber) {
        final String sqlQuery = "Update mtgplayers set firstname =:firstName,lastname =:lastName,dcinumber =:dciNumber where id =:id";
        Map<String, Object> map = new HashMap<>();
        map.put("firstName", firstName);
        map.put("lastName", lastName);
        map.put("dciNumber", dciNumber);
        map.put("id", id);
        return template.execute(sqlQuery, map, preparedStatement -> preparedStatement.executeUpdate() > 0);
    }

    @Override
    public boolean deleteMtgPlayer(int id) {
        final String sqlQuery = "DELETE FROM mtgplayers WHERE id=:id";
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);
        return template.execute(sqlQuery, map, preparedStatement -> preparedStatement.executeUpdate() > 0);
    }

    @Override
    public boolean insertMtgPlayer(String firstName, String lastName, String dciNumber) {
        final String sqlQuery = "INSERT INTO mtgplayers (firstname,lastname,dcinumber) VALUES" +
                "(:firstName," +
                ":lastName," +
                ":dciNumber);";
        Map<String,String>map = new HashMap<>();
        map.put("firstName",firstName);
        map.put("lastName",lastName);
        map.put("dciNumber",dciNumber);
        return template.execute(sqlQuery,map,preparedStatement -> preparedStatement.executeUpdate()>0);
    }
}
