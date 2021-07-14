package org.learn_java.bot.event.listeners.slash_commands;

import com.jagrosh.jdautilities.command.Command;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.learn_java.bot.commands.SlashCommand;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SlashListener extends ListenerAdapter {

    private List<SlashCommand> commands;

    public SlashListener(List<SlashCommand> commands) {
        this.commands = commands;
    }

    @Override
    public void onSlashCommand(SlashCommandEvent event) {
        String slashCommand = event.getName();
        SlashCommand command = commands.stream()
                .filter(c -> c.getName().equalsIgnoreCase(slashCommand))
                .findFirst().orElse(null);

        if(command != null) {
            command.executeSlash(event);
        }
    }
}
