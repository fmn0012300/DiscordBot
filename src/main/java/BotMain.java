import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class BotMain {
    public static void main (String[] args) throws LoginException {
        JDA jda = new JDABuilder("token").build();
    }
}
