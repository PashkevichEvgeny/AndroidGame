package com.mygdx.game.consolgame.model;

import com.mygdx.game.consolgame.model.heroes.Archer;
import com.mygdx.game.consolgame.model.heroes.Crossbowman;
import com.mygdx.game.consolgame.model.heroes.Monk;
import com.mygdx.game.consolgame.model.heroes.Peasant;
import com.mygdx.game.consolgame.model.heroes.Robber;
import com.mygdx.game.consolgame.model.heroes.Sorcerer;
import com.mygdx.game.consolgame.model.heroes.Spearman;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class GameMechanic {
    public static List<BaseHero> fillTeam(boolean side){
        int commandSize = 10;
        List<BaseHero> team = new ArrayList<>();
        for (int i = 1; i <= commandSize; i++) {
            int coordX = 1, coordY = i;
            if (side) coordX = 11;
            String prefix = ((side)?"B":"A") + i;
            int cnt = new Random().nextInt(8);
            switch (cnt) {
                case 0:
                    team.add(new Peasant("Batrak" + prefix, new Arena(coordX, coordY)));
                    break;
                case 1:
                    team.add(new Sorcerer("Kolduy" + prefix, new Arena(coordX, coordY)));
                    break;
                case 2:
                    team.add(new Monk("Monakh" + prefix, new Arena(coordX, coordY)));
                    break;
                case 3:
                    team.add(new Robber("Razboy" + prefix, new Arena(coordX, coordY)));
                    break;
                case 4:
                    team.add(new Crossbowman("Arbale" + prefix, new Arena(coordX, coordY)));
                    break;
                case 5:
                    team.add(new Archer("Luchni" + prefix, new Arena(coordX, coordY)));
                    break;
                default:
                    team.add(new Spearman("Kopeys" + prefix, new Arena(coordX, coordY)));
                    break;
            }
        }
        return team;
    }
    public static List<BaseHero> mergedTeam(List<BaseHero> team1, List<BaseHero> team2){
        List<BaseHero> mergedTeam = new ArrayList<>();
        mergedTeam.addAll(team1);
        mergedTeam.addAll(team2);
        return mergedTeam;
    }
    public static void letsBattle(List<BaseHero> team1, List<BaseHero> team2){
        List<BaseHero> allTeam = mergedTeam(team1, team2);
        Collections.sort(allTeam, new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero o1, BaseHero o2) {
            if (o2.getInitiate() - o1.getInitiate() == 0) {
                return o2.getInitiate() - o1.getInitiate() - new Random().nextInt(2);
            }
            return o2.getInitiate() - o1.getInitiate();
            }
        });
        for (BaseHero baseHero : allTeam) {
            if (team1.contains(baseHero)) {
                baseHero.step(team1, team2);
            } else {
                baseHero.step(team2, team1);
            }
        }
    }
}
