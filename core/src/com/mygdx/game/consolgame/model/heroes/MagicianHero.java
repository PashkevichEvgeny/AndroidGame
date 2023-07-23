package com.mygdx.game.consolgame.model.heroes;

import com.mygdx.game.consolgame.model.Arena;
import com.mygdx.game.consolgame.model.BaseHero;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MagicianHero extends BaseHero {
    public MagicianHero(String namePerson,
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
                10,
                state,
                position);
    }
    public String getName(){
        return name;
    }
    public String getInfo(){
        return super.getInfo();
    }
    public void step(List<BaseHero> ourTeam, List<BaseHero> oppositeTeam) {
        Collections.sort(ourTeam, new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero o1, BaseHero o2) {
            if (o1.gethP() - o2.gethP() == 0) {
                return o1.gethP() - o2.gethP() - new Random().nextInt(2);
            }
            return o1.gethP() - o2.gethP();
            }
        });
        // получает список своих отсортированный по степени живости
        // Наводит порчу на других магов, или сам получает боевой сглаз
        int r = new Random().nextInt(10);
        BaseHero seekingMagician = oppositeTeam.get(r);
        if (seekingMagician instanceof MagicianHero && State.Stand.equals(seekingMagician.state)) {
            if (r % 2 == 0) seekingMagician.getDamage(damage);
            else getDamage(damage);
        }
    }
}