package me.cecil.bots.basicbot;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] command = event.getMessage().getContent().split(" "); //Splits message at every space
		//String message = event.getMessage().getContent();
		
		if (!command[0].startsWith(Ref.PREFIX))
			return;
		
		if(command[0].equalsIgnoreCase("!ping")) {
			String msg = "Pong! `" + event.getJDA().getPing() + "ms";
			if(command.length == 1) {
				event.getChannel().sendMessage(msg).queue(); //Allows bot to resume sending messages
			} else if (command.length == 2 && command[1].equalsIgnoreCase("-e")) {
				EmbedBuilder eb = new EmbedBuilder();
				eb.setColor(Color.CYAN);
				eb.setDescription(msg);
				event.getChannel().sendMessage(eb.build()).queue();
			}

			
		}
	}
}
