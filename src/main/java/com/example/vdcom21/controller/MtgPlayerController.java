package com.example.vdcom21.controller;

import com.example.vdcom21.model.MtgPlayer;
import com.example.vdcom21.service.MtgPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/mtg")
public class MtgPlayerController {
    private MtgPlayerService mtgPlayerService;

    public MtgPlayerController(@Autowired MtgPlayerService service) {
        mtgPlayerService = service;
    }

    @GetMapping("/get")
    public String getAllMtgPlayers() {
        String result = "";
        List<MtgPlayer> list = mtgPlayerService.getAllMtgPlayers();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            MtgPlayer player = (MtgPlayer) iterator.next();
            result+=player.getFirstName()+" "+player.getLastName()+" с dci Номером "+player.getDciNumber()+ "\n";
        }
        return result;
    }

    @DeleteMapping("/delete")
    public String deleteMtgPlayer(@RequestParam(value = "id") int id) {
        if (mtgPlayerService.deleteMtgPlayer(id)) {
            return "Клиент с id = " + id + " удален";
        } else {
            return "Клиент с id = " + id + "не удален";
        }
    }

    @PostMapping("/update")
    public String updateMtgPlayer(@RequestParam(value = "id") int id,
                                  @RequestParam(value = "fname") String fname,
                                  @RequestParam(value = "lname") String lname,
                                  @RequestParam(value = "dcinum") String dcinumber) {
        if (mtgPlayerService.updateMtgPlayer(id, fname, lname, dcinumber)) {
            return "Клиент с id = " + id + " обновлён";
        } else {
            return "Клиент с id = " + id + "не обновлён";
        }
    }

    @PostMapping("/add")
    public String addMtgPlayer(@RequestParam(value = "fname") String fname,
                               @RequestParam(value = "lname") String lname,
                               @RequestParam(value = "dcinum") String dcinumber) {
        if (mtgPlayerService.insertMtgPlayer(fname, lname, dcinumber)) {
            return "Клиент добавлен";
        } else {
            return "Клиент не добавлен";
        }
    }

    /**
     *
     * @param fileName name of the file to load
     */
    @GetMapping("/load")
    public void loadCsvFile(@RequestParam(defaultValue = "NewMtgPlayers.csv") String fileName){
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String[] array = line.split("-,-");
                mtgPlayerService.insertMtgPlayer(array[0],array[1],array[2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
