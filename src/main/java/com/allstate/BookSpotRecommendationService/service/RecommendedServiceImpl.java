package com.allstate.BookSpotRecommendationService.service;

import java.util.List;

import com.allstate.BookSpotRecommendationService.model.Recommended;
import com.allstate.BookSpotRecommendationService.repo.RecommendedRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendedServiceImpl implements RecommendedService {
    private static Logger logger = LoggerFactory.getLogger(RecommendedServiceImpl.class);

    @Autowired
    private RecommendedRepository recommendedRepository;

    @Override
    public Recommended deleteFromRecommend(String id, String username) {
        Recommended recommended = null;
        try {
            recommended = recommendedRepository.deleteByBookIdAndUsername(id, username);
        } catch (Exception e) {
            logger.error("Error while deleting from recommend");
        }
        return recommended;
    }

    @Override
    public List<Recommended> getRecommendedBooksByIdAndUsername(String id, String username) {
        List<Recommended> recommendedList = recommendedRepository.findByBookIdAndUsername(id, username);
        if (!recommendedList.isEmpty()) {
            return recommendedList;
        }
        return null;
    }

    @Override
    public Recommended saveRecommended(Recommended f) {
        return recommendedRepository.save(f);
    }

    @Override
    public List<Recommended> getUsersAllRecommended(String username) {
        List<Recommended> recommendedList = recommendedRepository.findByUsername(username);
        if (!recommendedList.isEmpty()) {
            return recommendedList;
        }
        return null;
    }

    @Override
    public List<Recommended> getAllRecommend() {
        List<Recommended> recommendedList = recommendedRepository.findAll();
        if (!recommendedList.isEmpty()) {
            return recommendedList;
        }
        return null;
    }


}
