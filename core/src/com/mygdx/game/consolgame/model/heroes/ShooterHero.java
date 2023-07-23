package com.mygdx.game.consolgame.model.heroes;

import com.mygdx.game.consolgame.model.Arena;
import com.mygdx.game.consolgame.model.BaseHero;

import java.util.List;
public class ShooterHero extends BaseHero {
    protected int amountArrows;
    public ShooterHero(String namePerson,
                       int hP,
                       int maxHP,
                       int defense,
                       int damage,
                       BaseHero.State state,
                       Arena position,
                       int amountArrows){
        super(namePerson,
                hP,
                maxHP,
                defense,
                damage,
                20,
                state,
                position);
        this.amountArrows = amountArrows;
    }
    public String getName(){
        return name;
    }
    public String getInfo(){
        return super.getInfo();
    }
    public void step(List<BaseHero> ourTeam, List<BaseHero> oppositeTeam) {
    }
}
