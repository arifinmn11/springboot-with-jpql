package com.mitramandiri.backend.controllers;

import com.mitramandiri.backend.dao.PositionRepository;
import com.mitramandiri.backend.entities.Position;
import com.mitramandiri.backend.models.ResponseMessage;
import com.mitramandiri.backend.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PositionController {

    @Autowired
    private PositionService positionService;


    @GetMapping("/positions")
    public ResponseMessage<List<Position>> findAll(
//            @RequestParam String search
    ) {

        List<Position> positions = new ArrayList<>();

        for (Position position : positionService.findAll()) {
            positions.add(position);
        }

        return ResponseMessage.success(positions);
    }

    @GetMapping("/position/{id}")
    public ResponseMessage<?> findById(
            @PathVariable Integer id
    ) {

//        if(name != null || code != null){
//            List<Position> positions = positionService.findByNameContainingOrCodeContaining(name, code);

        Position positions = positionService.findById(id);

        return ResponseMessage.success(positions);
//        }

//        return ResponseMessage.success(null);
    }

}
