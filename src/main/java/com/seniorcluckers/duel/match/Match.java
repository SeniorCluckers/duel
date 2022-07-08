package com.seniorcluckers.duel.match;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.Set;

public class Match {

    @Getter
    private MatchRules rules;

    private final Set<Player> players;

    public Match(Set<Player> players) {
        this.players = players;
    }

}
