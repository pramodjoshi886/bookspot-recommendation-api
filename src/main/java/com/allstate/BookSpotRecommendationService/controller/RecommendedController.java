package com.allstate.BookSpotRecommendationService.controller;

import java.util.List;

import com.allstate.BookSpotRecommendationService.model.Recommended;
import com.allstate.BookSpotRecommendationService.service.RecommendedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@EnableSwagger2
public class RecommendedController {
    @Autowired
    private RecommendedService recommendedService;

    @GetMapping("/bookSpot/recommended-Book/{id}/{username}")
    public ResponseEntity<?> getBookByRecommendationByIdAndUsername(@PathVariable("id") String id, @PathVariable("username") String username) {
        ResponseEntity<?> responseEntity = null;
        try {
            List<Recommended> recommendedList = recommendedService.getRecommendedBooksByIdAndUsername(id, username);
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(recommendedList);
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return responseEntity;
    }

    @GetMapping("/bookSpot/getMyRecommendedBooks/{username}")
    public ResponseEntity<?> getBookByRecommendation(@PathVariable("username") String username) {
        ResponseEntity<?> responseEntity = null;
        try {
            List<Recommended> recommended = recommendedService.getUsersAllRecommended(username);
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(recommended);
        } catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return responseEntity;
    }

    @GetMapping("/bookSpot/getAllRecommendedBooks")
    public ResponseEntity<?> getAllBooks() {
        ResponseEntity<?> responseEntity = null;
        try {
            List<Recommended> recommendedList = recommendedService.getAllRecommend();
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(recommendedList);
        } catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        System.out.println("GET all recommended response : "+responseEntity);
        return responseEntity;
    }

    @PostMapping("/bookSpot/addToRecommendedBooks")
    public ResponseEntity<?> saveBook(@RequestBody Recommended recommended) {
        System.out.println("Incoming ADD Recommend request : "+recommended);
        ResponseEntity<?> responseEntity = null;
        try {
            Recommended saveRecommended = recommendedService.saveRecommended(recommended);
            if (saveRecommended != null) {
                responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
            } else {
                responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return responseEntity;
    }

    @DeleteMapping("/bookSpot/unrecommended/{id}/{username}")
    public ResponseEntity<?> deleteRecommend(@PathVariable("id") String id, @PathVariable("username") String username) {
        System.out.println("Incoming DELETE recommend request for id:"+id+" ,user: "+username);
        ResponseEntity<?> responseEntity = null;
        recommendedService.deleteFromRecommend(id, username);
        responseEntity = ResponseEntity.status(HttpStatus.OK).build();
        return responseEntity;
    }
}

