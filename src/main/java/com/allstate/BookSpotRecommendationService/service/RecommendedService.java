package com.allstate.BookSpotRecommendationService.service;

import java.util.List;

import com.allstate.BookSpotRecommendationService.model.Recommended;
import org.springframework.data.mongodb.repository.Query;

public interface RecommendedService {
	
	public Recommended saveRecommended(Recommended f);
	public List<Recommended> getUsersAllRecommended (String username);
	
	@Query("from Recommended group by bookId")
	public List<Recommended> getAllRecommend();

	public List<Recommended> getRecommendedBooksByIdAndUsername(String id, String username);
	
	public Recommended deleteFromRecommend(String id, String username);
}
