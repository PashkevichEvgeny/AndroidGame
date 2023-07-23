package com.mygdx.game.consolgame.model;

import java.util.List;

public interface GameInterface {
    void step(List<BaseHero> ourTeam, List<BaseHero> oppositeTeam);
    String getInfo();
}
