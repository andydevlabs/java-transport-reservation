package org.transportreservation.controller;

import org.springframework.web.bind.annotation.*;
import org.transportreservation.model.Bus;
import org.transportreservation.model.BusSeat;
import org.transportreservation.service.BusSeatService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class BusSeatController {
    private BusSeatService busSeatService;

    public BusSeatController(BusSeatService busSeatService) {
        this.busSeatService = busSeatService;
    }

    @PostMapping("/busSeat")
    public BusSeat addBusSeat(@RequestBody BusSeat busSeat) throws SQLException {
        return busSeatService.insertBusSeat(busSeat);
    }

    @GetMapping("/busSeat")
    public List<BusSeat> findAllBusSeat() throws SQLException {
        return busSeatService.getAll();
    }

    @GetMapping("/busSeat/search/{id}")
    public BusSeat findBusSeatById(@PathVariable int id) throws SQLException {
        return busSeatService.getById(id);
    }

    @PatchMapping("/busSeat/edit/{id}")
    public BusSeat updatePriceById(@PathVariable int id, @RequestBody double price) throws SQLException {
        return busSeatService.updatePriceById(id, price);
    }

    @DeleteMapping("/busSeat/{id}")
    public void deleteBusById(@PathVariable int id) throws SQLException {
        busSeatService.deleteById(id);
    }
}