package com.mygdx.game.consolgame.model.heroes;

import com.mygdx.game.consolgame.model.Arena;
import com.mygdx.game.consolgame.model.BaseHero;

import java.util.List;

/**
 * Герой этого класса должны ходить по полю
 */
public class InfantryHero extends BaseHero {
    public InfantryHero(String namePerson,
                        int hP,
                        int maxHP,
                        int defense,
                        int damage,
                        BaseHero.State state,
                        Arena position) {
        super(namePerson,
                hP,
                maxHP,
                defense,
                damage,
                15,
                state,
                position);
    }
    public String getName(){
        return name;
    }

    public String getInfo(){
        return super.getInfo();
    }

    @Override
    public void step(List<BaseHero> ourTeam, List<BaseHero> oppositeTeam) {

    }


}
