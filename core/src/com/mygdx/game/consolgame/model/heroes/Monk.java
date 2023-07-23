package com.mygdx.game.consolgame.model.heroes;

import com.mygdx.game.consolgame.model.Arena;
import com.mygdx.game.consolgame.model.BaseHero;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Monk extends MagicianHero {
    public Monk(String namePerson, Arena position) {
        super(namePerson,
                10,
                10,
                10,
                1,
                State.Stand,
                position);
        this.setInitiate(this.getInitiate() + 2);
    }
    @Override
    public String getInfo(){
        return super.getInfo();
    }
    public String getName(){
        return name;
    }
    public void step(List<BaseHero> ourTeam, List<BaseHero> oppositeTeam) {
        if (State.Dead.equals(this.state)) return;
        super.step(ourTeam, oppositeTeam);
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
        BaseHero wia = null;
        for (BaseHero itemWia: ourTeam) {                       // ищет самого раненого, но еще живого и лечит его
            if (itemWia.gethP() < itemWia.getMaxHP() && !Objects.equals(itemWia.getName(), getName())){
                wia = itemWia;
                break;
            }
        }
        if (wia == null) {
            getDamage(damage);
            return;
        }
        if (State.Dead.equals(wia.state) && new Random().nextInt(3) == 1) {
            wia.state = State.Stand;
            wia.getDamage(-damage);
            getDamage(3);
        }
        else {
            if (wia.gethP() + damage > wia.getMaxHP()) wia.getDamage(wia.getMaxHP() - wia.gethP());
            else wia.getDamage(-damage);
        }
    }
}
