package me.cecil.bots.basicbot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class BasicBot extends ListenerAdapter {
	
	public static JDA api;
	
	public static void main(String[] args) {
		try {
			api = new JDABuilder(AccountType.BOT).setToken(Ref.TOKEN).buildBlocking();
			api.setAutoReconnect(true);
			api.getPresence().setGame(Game.of("Hi! I'm a bot!"));	//Makes the AI say it's "playing" a message
			api.addEventListener(new Commands()); //Says the class commands exists!
			api.addEventListener(new BasicBot());
		} catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
			e.printStackTrace();
		}
	}
	
	public void onGuildJoinEvent(GuildJoinEvent event) {
		System.out.printf("[+] %s (%s Members)\n", event.getGuild().getName(), event.getGuild().getMembers().size());
	}
}
