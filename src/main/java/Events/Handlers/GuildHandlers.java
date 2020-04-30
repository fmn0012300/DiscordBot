package Events.Handlers;

public class GuildHandlers {

    /**
     * return curr info regarding boss fight
     * i.e stage, hp, who's fighting, who's dead, who've fought, who's next, time since last person started
     */
    public static void info() {

    }

    /**
     * join the guild
     */
    public static void joinGuild() {

    }

    /**
     * return guild member
     */
    public static void guildMember() {

    }

    /**
     * queue up players
     */
    public static void queue(String id) {

    }

    /**
     * record the starting id, time
     * @param id id of the player
     */
    public static void start(String id) {

    }

    /**
     * end the curr guild fight and call the next player, record down damage dealt
     * @param damage damage dealt to the boss
     */
    public static void end(int damage) {

    }

    /**
     * put curr player onto the sos list
     * @param id player to sos list
     */
    public static void sos(String id) {

    }
}
