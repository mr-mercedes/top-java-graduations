package ru.borovikov.topjavagraduation.service;

import ru.borovikov.topjavagraduation.model.Vote;

import java.util.Map;

public interface VoteService {

    Vote vote(Long userId, Long restaurantId);

    Map<Long, Long> getTodayResults();
}
