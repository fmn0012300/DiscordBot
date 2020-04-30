package Events;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Member;

public class GuildWarEvents extends ListenerAdapter {

    /**
     * Handle commands relating to guild war.
     * @param event
     */
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String command = event.toString();

        if (command.charAt(0) != '~') {
            return;
        }

        User user = event.getAuthor();
        String[] breakup = command.split(" ");

        switch (breakup[0]) {
            case "~help":
                Help.getHelp();
                break;
            case "~info":

        }
    }
}
