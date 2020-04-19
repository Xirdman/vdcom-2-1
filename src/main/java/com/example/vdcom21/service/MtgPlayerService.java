package com.example.vdcom21.service;

import com.example.vdcom21.model.MtgPlayer;

import java.util.List;

public interface MtgPlayerService {
    List<MtgPlayer> getAllMtgPlayers();
    boolean updateMtgPlayer(int id, String firstname, String lastName, String dciNumber);
    boolean deleteMtgPlayer(int id);
    boolean insertMtgPlayer(String firstname, String lastName, String dciNumber);

}
