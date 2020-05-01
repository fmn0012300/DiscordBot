package events.Handlers;

import java.util.Queue;
import java.util.Set;

public class DataBean {
    private Queue<String> bossQ;
    private Set<String> member;
    private int currBoss;
    private int currHp;
    private Set<String> hanging;
    private String currFighting;
    private String time;

    public DataBean() {
    }

    public DataBean(Queue<String> bossQ, Set<String> member, int currBoss, int currHp, Set<String> hanging, String currFighting) {
        this.bossQ = bossQ;
        this.currBoss = currBoss;
        this.member = member;
        this.currHp = currHp;
        this.currFighting = currFighting;
        this.hanging = hanging;
    }

    public Queue<String> getBossQ() {
        return bossQ;
    }

    public Set<String> getMember() {
        return member;
    }

    public int getCurrBoss() {
        return currBoss;
    }

    public int getCurrHp() {
        return currHp;
    }

    public Set<String> getHanging() {
        return hanging;
    }

    public String getCurrFighting() {
        return currFighting;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCurrFighting(String currFighting) {
        this.currFighting = currFighting;
    }

    public void setHanging(Set<String> hanging) {
        this.hanging = hanging;
    }

    public void setCurrHp(int currHp) {
        this.currHp = currHp;
    }

    public void setCurrBoss(int currBoss) {
        this.currBoss = currBoss;
    }

    public void setMember(Set<String> member) {
        this.member = member;
    }

    public void setBossQ(Queue<String> bossQ) {
        this.bossQ = bossQ;
    }
}
