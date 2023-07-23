package com.mygdx.game.consolgame.model.heroes;

import com.mygdx.game.consolgame.model.Arena;
import com.mygdx.game.consolgame.model.BaseHero;


import java.util.List;
public class Robber extends InfantryHero {
    public Robber(String namePerson, Arena position){
        super(namePerson,
                10,
                10,
                10,
                3,
                State.Stand,
                position);
        this.setInitiate(this.getInitiate() + 1);
    }
    public String getInfo(){ return super.getInfo(); }
    public String getName(){ return name; }
    public void step(List<BaseHero> ourTeam, List<BaseHero> oppositeTeam) {
        if (State.Dead.equals(this.state)) return;
        BaseHero victim = lookForEnemy(oppositeTeam);
        if (victim == null) return;
        List<Integer> lineX = Arena.line(position.getX(), victim.getPosition().getX());
        List<Integer> lineY = Arena.line(position.getY(), victim.getPosition().getY());
        if (Arena.freeLine(lineX, ourTeam, victim, true)) {
            position.setX(lineX.get(0));
            if (lineX.size() <= 2 && lineY.size() <= 2) victim.getDamage(damage);
            return;
        }
        if (Arena.freeLine(lineY, ourTeam, victim, false)) position.setY(lineY.get(0));
        if (lineX.size() <= 2 && lineY.size() <= 2) victim.getDamage(damage);
    }
}
