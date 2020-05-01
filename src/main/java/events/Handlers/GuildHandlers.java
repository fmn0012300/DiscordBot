package events.Handlers;

import com.google.gson.Gson;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class GuildHandlers {
    private static final int[] BOSS = {6000000, 8000000, 10000000, 12000000, 20000000};

    private Queue<String> bossQ;
    private Set<String> member;
    private int currBoss;
    private int currHp;
    private Set<String> hanging;
    private String currFighting;
    private String time;
    private Gson gson;
    private DataBean data;

    public GuildHandlers() {
        bossQ = new LinkedList<>();
        member = new HashSet<>();
        currBoss = 0;
        currHp = BOSS[currBoss];
        hanging = new HashSet<>();
        gson = new Gson();
    }

    /**
     * return curr info regarding boss fight
     * i.e stage, hp, who's fighting, who's dead, who've fought, who's next, time since last person started
     */
    public String info() {
        String result = "现在BOSS Stage：" + currBoss + "\n";
        result = result + "HP: " + currHp + "\n";
        result = result + currFighting + " 正在打，" + time + "开始的\n";
        result = result + bossQ.peek() + " 做好准备\n";
        return result;
    }

    /**
     * join the guild
     * @param id  id of the player
     */
    public String joinGuild(String id) {
        if (member.add(id)) {
            return "Welcome @" + id;
        }
        return "你已经在会里了";
    }

    /**
     * return guild member
     */
    public String guildMember() {
        return "公会成员：" + member.toString();
    }

    /**
     * queue up players
     */
    public String queue(String id) {
        if (bossQ.add(id)) {
            return "已添加！加油~ @" + id;
        }
        return "有问题。。。";
    }

    /**
     * record the starting id, time
     * @param id id of the player
     */
    public String start(String id) {
        if (id.equals(bossQ.peek())) {
            currFighting = id;
            bossQ.remove();
            time = java.time.LocalDateTime.now().toString();
            return "加油！@" + id;
        }
        return "还没到你哦~";
    }

    /**
     * end the curr guild fight and call the next player, record down damage dealt
     * @param damage damage dealt to the boss
     */
    public String end(int damage, String id) {
        currHp = currHp - damage;
        String statement = "";
        if (currHp <= 0) {
            currBoss++;
            if (currBoss > BOSS.length) {
                currBoss = 0;
            }
            currHp = BOSS[currBoss];

            for (String x: hanging) {
                statement = statement + " @" + x;
            }
            statement = statement + "可以下树了";
            hanging.clear();
        }

        return "@" + id + " GJ~！" + statement;
    }

    /**
     * put curr player onto the sos list
     * @param id player to sos list
     */
    public String sos(String id) {
        hanging.add(id);
        return "@everyone " + id + "已死有事烧纸";
    }

    /**
     * save curr status
     * @return statement telling saved successfully
     */
    public String save() {
        try {
            data = new DataBean(bossQ, member, currBoss, currHp, hanging, currFighting);
            String json = gson.toJson(data);
            PrintStream out = new PrintStream(new File("save.txt"));
            out.println(json);
        } catch (Exception e) {
            return "Something went wrong";
        }

        return "Saved!";
    }

    /**
     * load saved file
     * @return statement telling loaded successfully
     * @throws FileNotFoundException if the file does not exist
     */
    public String load() throws FileNotFoundException {
        Scanner reader = new Scanner(new File("save.txt"));
        String json = "";
        while (reader.hasNextLine()) {
            json = json + reader.nextLine();
        }
        data = gson.fromJson(json, data.getClass());
        return "loaded";
    }
}
