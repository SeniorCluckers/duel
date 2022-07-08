package com.seniorcluckers.duel.match;

import java.util.EnumMap;
import java.util.Map;
public class MatchRules {

    private final Map<Rule, Boolean> rules = new EnumMap<>(Rule.class);

    public boolean getRule(Rule key) {
        return this.rules.get(key);
    }

    public boolean setRule(Rule key, boolean toggle) {
        return this.rules.put(key, toggle);
    }

}
