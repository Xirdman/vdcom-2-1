package com.example.vdcom21.service;

import com.example.vdcom21.dao.MtgPlayerDao;
import com.example.vdcom21.model.MtgPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MtgPlayerServiceImpl implements MtgPlayerService{
    MtgPlayerDao mtgPlayerDao;
    public MtgPlayerServiceImpl(@Autowired MtgPlayerDao mtgPlayerDao){
        this.mtgPlayerDao = mtgPlayerDao;
    }

    @Override
    public List<MtgPlayer> getAllMtgPlayers() {
        return mtgPlayerDao.getAllMtgPlayers();
    }

    @Override
    public boolean updateMtgPlayer(int id,String firstname, String lastName, String dciNumber) {
        return mtgPlayerDao.updateMtgPlayer(id, firstname,lastName,dciNumber);
    }

    @Override
    public boolean deleteMtgPlayer(int id) {
        return mtgPlayerDao.deleteMtgPlayer(id);
    }

    @Override
    public boolean insertMtgPlayer(String firstname, String lastName, String dciNumber) {
        return mtgPlayerDao.insertMtgPlayer(firstname,lastName,dciNumber);
    }
}
