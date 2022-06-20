package de.elia.ghostmain.all.plugins.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

import java.util.IllegalFormatException;
import java.util.Set;

public class GhostChatEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private boolean cancel = false;

    private String message;

    private String format = "<%1§s> %2§s";

    private final Set<Player> recipients;

    public GhostChatEvent(final boolean async , @NotNull final Player who , @NotNull final String message , @NotNull final Set<Player> players) {
        super(who , async);
        this.message = message;
        recipients = players;
    }

    @NotNull
    public String getMessage(){
        return message;
    }

    public void setMessage(@NotNull String message){
        this.message = message;
    }

    @NotNull
    public String getFormat(){
        return format;
    }

    public void setFormat(@NotNull final String format) throws IllegalFormatException , NullPointerException{
        try {
            String.format(format , player , message);
        }catch (RuntimeException exception){
            exception.fillInStackTrace();
            throw exception;
        }
        this.format = format;
    }

    @NotNull
    public Set<Player> getRecipients(){
        return recipients;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }
}
