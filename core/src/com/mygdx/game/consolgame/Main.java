package com.mygdx.game.consolgame;

import com.mygdx.game.consolgame.model.BaseHero;
import com.mygdx.game.consolgame.model.GameMechanic;


import java.util.*;

public class Main {
        public List<BaseHero> teamGood = new ArrayList<>();
        public List<BaseHero> teamEvil = new ArrayList<>();
        public List<BaseHero> allTeam = new ArrayList<>();
        int a, b;

    public void main() {
        teamGood = GameMechanic.fillTeam(false);
        teamEvil = GameMechanic.fillTeam(true);
        allTeam = GameMechanic.mergedTeam(teamEvil, teamGood);
    }
    public boolean run(){
        a = b = 0;
        GameMechanic.letsBattle(teamGood, teamEvil);
        for (BaseHero hero: allTeam ) {
            if (teamGood.contains(hero) && hero.state.equals(BaseHero.State.Dead)) a++;
            if (teamGood.contains(hero) && hero.state.equals(BaseHero.State.Dead)) b++;
        }
        if (a == 10 || b == 10) return false;
        return true;
    }
}
