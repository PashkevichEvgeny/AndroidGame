package com.mygdx.game.consolgame.model;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Arena {
    public int x;
    public int y;

    public Arena(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static double distance(Arena coordPlayer1, Arena coordPlayer2){
        return sqrt(pow(coordPlayer2.x - coordPlayer1.x, 2) + pow(coordPlayer2.y - coordPlayer1.y, 2));
    }
    public static boolean freeLine(List<Integer> line, List<BaseHero> ourTeam, BaseHero victim, boolean direction){
        for (BaseHero hero: ourTeam) {
            if (line.size() > 0
                    && direction
                    && (line.get(0) != hero.getPosition().x && !BaseHero.State.Dead.equals(hero.state))
                    && (line.get(0) != victim.getPosition().x && !BaseHero.State.Dead.equals(victim.state)))
            { return true; }
            if (line.size() > 1
                    && !direction
                    && (line.get(0) != hero.getPosition().y || !BaseHero.State.Dead.equals(hero.state))
                    && (line.get(0) != victim.getPosition().y || !BaseHero.State.Dead.equals(victim.state)))
            { return true; }
        }
        return false;
    }
    public static List<Integer> line(int a, int b){
        List<Integer> way = new ArrayList<>();
        if (a > b) {
            for (int i = a - 1; i >= b; i--) way.add(i);
        } else {
            for (int i = a + 1; i <= b; i++) way.add(i);
        }
        if (a == b) way.add(a);
        return way;
    }
}
