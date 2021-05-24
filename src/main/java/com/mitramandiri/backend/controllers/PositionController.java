package com.mitramandiri.backend.controllers;

import com.mitramandiri.backend.entities.Position;
import com.mitramandiri.backend.models.PageList;
import com.mitramandiri.backend.models.PositionRequest;
import com.mitramandiri.backend.models.ResponseMessage;
import com.mitramandiri.backend.models.search.PositionSearch;
import com.mitramandiri.backend.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping("/positions")
    public ResponseMessage<Page<Position>> findAllWithPagination(
            Pageable pageable
    ) {

        Page<Position> positions = positionService.findAllPagination(pageable);

        return ResponseMessage.success(positions);
    }

    @GetMapping("/positions/all")
    public ResponseMessage<List<Position>> findAll() {

        List<Position> positions = positionService.findAllPosition();

        return ResponseMessage.success(positions);
    }

//    @PostMapping("/position")
//    public ResponseMessage<Position> insert(
//            PositionRequest input
//    ) {
//        Position entity = new Position();
//        entity.setName(input.getName());
//        entity.setCode(input.getCode());
//
//        entity = positionService.save(entity);
//
//        return ResponseMessage.success(entity);
//    }

//    @Get("/position/{id}")
//    public ResponseMessage<Position> findById(
//            PositionRequest input
//    ) {
//        Position entity = new Position();
//        entity.setName(input.getName());
//        entity.setCode(input.getCode());
//
//        entity = positionService.save(entity);
//
//        return ResponseMessage.success(entity);
//    }


//    @GetMapping("/positionspage")
//    public ResponseMessage<PageList<Position>> findPage(
//            PositionSearch search
//    ) {
//        Position request = new Position();
//        request.setName(search.getName());
//        request.setCode(search.getCode());
//
//        Page<Position> entityPage = positionService.findAll(request, search.getPage(), search.getSize(), search.getSort());
//        List<Position> entityList = entityPage.toList();
//
//        PageList<Position> entities = new PageList<>(
//                entityList,
//                entityPage.getNumber(),
//                entityPage.getSize(),
//                entityPage.getTotalElements()
//        );
//
//        return ResponseMessage.success(entities);
//    }
//
//    @GetMapping("/position/{id}")
//    public ResponseMessage<?> findById(
//            @PathVariable Integer id
//    ) {
//
////        if(name != null || code != null){
////            List<Position> positions = positionService.findByNameContainingOrCodeContaining(name, code);
//
//        Position positions = positionService.findById(id);
//
//        return ResponseMessage.success(positions);
////        }
//
////        return ResponseMessage.success(null);
//    }


}
