package com.example.vdcom21;

import com.example.vdcom21.controller.MtgPlayerController;
import com.example.vdcom21.dao.MtgPlayerDao;
import com.example.vdcom21.dao.MtgPlayerDaoImpl;
import com.example.vdcom21.model.MtgPlayer;
import com.example.vdcom21.service.MtgPlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
@TestPropertySource("/test.properties")
class Vdcom21ApplicationTests {
    @Mock
    MtgPlayerController controller;
    @Autowired
    MtgPlayerDaoImpl dao;

    @Test
    void addMtgPlayerTest() {
        Assert.isTrue(dao.insertMtgPlayer("test1", "test2", "123"), "");
    }

    @Test
    void insertMtgPlayerTest() {
        Assert.isTrue(dao.insertMtgPlayer("insertTestName", "insertTestLastName", "insertDci"), "");
    }

    @Test
    void deleteMtgPlayerTest() {
        dao.insertMtgPlayer("deletedName", "deletedLastName", "120123");
        List<MtgPlayer> list = dao.getAllMtgPlayers();
        Iterator<MtgPlayer> iterator = list.iterator();
        int i = 0;
        if (iterator.hasNext()) {
            MtgPlayer testDeletedPlayer = iterator.next();
            i = testDeletedPlayer.getId();
        }
        Assert.isTrue(dao.deleteMtgPlayer(i), "");
    }

    @Test
    void updateMtgPlayerTest() {
        dao.insertMtgPlayer("nameWaitingForUpdate", "lNameWaitingForUpdate", "unUpdated");
        List<MtgPlayer> list = dao.getAllMtgPlayers();
        Iterator<MtgPlayer> iterator = list.iterator();
        int i = 0;
        if (iterator.hasNext()) {
            MtgPlayer testDeletedPlayer = iterator.next();
            i = testDeletedPlayer.getId();
        }
        Assert.isTrue(dao.updateMtgPlayer(i, "updatedName", "updatedLastName", "updDci"), "");
    }

    @Test
    void readFromFileTest() {
        controller.loadCsvFile("test.csv");
    }

}
