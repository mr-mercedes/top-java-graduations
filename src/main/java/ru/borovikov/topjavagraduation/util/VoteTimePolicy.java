package ru.borovikov.topjavagraduation.util;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class VoteTimePolicy {

    public static final LocalTime DEADLINE = LocalTime.of(11, 0);

    public static boolean canChangeVote(LocalDateTime now) {
        return now.toLocalTime().isBefore(DEADLINE);
    }
}
