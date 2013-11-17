package org.mikegeorge.ram;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class RAM extends JavaPlugin
{
  public void onDisable()
  {
    System.out.println("[RAM v0.2.2] Plugin Shut Down");
  }

  public void onEnable()
  {
    System.out.println("[RAM v0.2.2] Plugin Loaded");
    getCommand("ram").setExecutor(new CommandExecutor() {
      public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        command_logic(sender);
        return true;
      }
    });
    getCommand("mem").setExecutor(new CommandExecutor() {
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
          command_logic(sender);
          return true;
        }
      });
  }
  public void command_logic(CommandSender sender)
  {
	  Runtime runtime = Runtime.getRuntime();
      System.gc();
      if ((sender.isOp()) || (sender.hasPermission("ram.command")))
        sender.sendMessage(ChatColor.GREEN + "[Used / Total / Free]  " + ChatColor.BLUE + (runtime.totalMemory() - runtime.freeMemory()) / 1048576L +  " MB / " + runtime.totalMemory() / 1048576L + " MB / " + runtime.freeMemory() / 1048576L + " MB");
      else
    	  sender.sendMessage(ChatColor.RED + "[RAM] You Do Not Have Permission to Execute This Command");
  }
}