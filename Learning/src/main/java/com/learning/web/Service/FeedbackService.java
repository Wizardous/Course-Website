package com.learning.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.web.Repository.FeedbackRepository;
import com.learning.web.Entity.Feedback;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepo;

	public List<Feedback> getAllFeedbacks() {
		return feedbackRepo.findAll();
	}

	public Feedback saveFeedback(Feedback feedback) {
		return feedbackRepo.save(feedback);
	}

	public Feedback getFeedbackById(Long id) {
		return feedbackRepo.findById(id).get();
	}

	public Feedback updateFeedback(Feedback feedback) {
		return feedbackRepo.save(feedback);
	}

	public void deleteFeedbackById(Long id) {
		feedbackRepo.deleteById(id);
	}

}
