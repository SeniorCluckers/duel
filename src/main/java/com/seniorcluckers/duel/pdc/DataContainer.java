package com.seniorcluckers.duel.pdc;

import com.seniorcluckers.duel.match.Rule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DataContainer {

    private Rule rule;
    private boolean toggled;

}
