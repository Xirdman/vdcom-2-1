package com.example.vdcom21.dao;

import com.example.vdcom21.model.MtgPlayer;

import java.util.List;

public interface MtgPlayerDao {
    List<MtgPlayer> getAllMtgPlayers();

    MtgPlayer getById(int id);

    boolean updateMtgPlayer(int id, String firstName, String lastName, String dciNumber);

    boolean deleteMtgPlayer(int id);

    boolean insertMtgPlayer(String firstName, String lastName, String dciNumber);
}
