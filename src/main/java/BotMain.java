import events.GuildWarEvents;
import events.Handlers.GuildHandlers;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class BotMain {
    public static void main(String[] args) throws LoginException {
        JDA jda = new JDABuilder("NzA1NDk4NjM4NjkxOTkxNjQy.XquBgg.uJPVZ4p74nnu1s4lYLqHIkdUzfE").build();

        jda.addEventListener(new GuildWarEvents());
    }
}
