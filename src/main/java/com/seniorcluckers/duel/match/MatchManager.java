package com.seniorcluckers.duel.match;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import lombok.Getter;

import java.util.Set;
import java.util.HashSet;

public class MatchManager {

    @Getter
    private static MatchManager instance;

    private final Set<Match> matches;

    public static void init() {
        Preconditions.checkState(instance == null, "MatchManager already initialized");
        instance = new MatchManager();
    }


    public Set<Match> getMatches() {
        return ImmutableSet.copyOf(this.matches);
    }

    public void startMatch(Match match) {
        matches.add(match);
    }

    private MatchManager() {
        this.matches = new HashSet<>();
    }

}
