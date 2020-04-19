package com.example.vdcom21.mapper;

import com.example.vdcom21.model.MtgPlayer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class mtgPlayerRowMapper implements RowMapper<MtgPlayer> {
    @Override
    public MtgPlayer mapRow(ResultSet resultSet, int i) throws SQLException {
        MtgPlayer player = new MtgPlayer();
        player.setId(resultSet.getInt("id"));
        player.setFirstName(resultSet.getString("firstname"));
        player.setLastName(resultSet.getString("lastname"));
        player.setDciNumber(resultSet.getString("dcinumber"));
        return player;
    }
}
