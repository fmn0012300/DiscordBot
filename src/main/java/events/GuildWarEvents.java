package events;

import events.Handlers.GuildHandlers;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class GuildWarEvents extends ListenerAdapter {
    private GuildHandlers handlers = new GuildHandlers();

    /**
     * Handle commands relating to guild war.
     * @param event event to be handled
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String command = event.getMessage().getContentRaw();

        if (command.charAt(0) != '~') {
            return;
        }
        User user = event.getAuthor();
        String[] breakup = command.split(" ");
        String statement;
        switch (breakup[0]) {
            case "~info":
                statement = handlers.info();
                break;
            case "~joinGuild":
                statement = handlers.joinGuild(user.getName());
                break;
            case "~queue":
                statement = handlers.queue(user.getName());
                break;
            case "~start":
                statement = handlers.start(user.getName());
                break;
            case "~end":
                try {
                    statement = handlers.end(Integer.parseInt(breakup[1]), user.getName());
                } catch (Exception e) {
                    statement = "Wrong format";
                }
                break;
            case "~sos":
                statement = handlers.sos(user.getName());
                break;
            case "~guildMember":
                statement = handlers.guildMember();
                break;
            case "~save":
                statement = handlers.save();
                break;
            case "~load":
                try {
                    statement = handlers.load();
                } catch (Exception e) {
                    statement = "Error occurred during loading...";
                }
                break;
            default:
                statement = Help.getHelp();
                break;
        }

        event.getChannel().sendMessage(statement).queue();

    }
}
