package de.elia.ghostmain.all.plugins.permissionSystem.listener;

import de.elia.ghostmain.GhostMain;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class OperatorListener implements Listener {

    private final String ownerPermissionID = "ghostowner";

    private final String adminPermissionID = "ghostadmin";

    private final String developerPermissionID = "ghostdeveloper";

    private final String moderatorPermissionID = "ghostmoderator";

    @EventHandler
    public void onOperator(@NotNull PlayerJoinEvent event){

        Player player = event.getPlayer();

        if (GhostMain.getInstance().getPermissionOwnerConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + ownerPermissionID , true)) {
            if (!player.isOp()) {
                player.setOp(true);
            }
        }else if (GhostMain.getInstance().getPermissionAdminConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + adminPermissionID ,true)) {
            if (!player.isOp()) {
                player.setOp(true);
            }
        }else if (GhostMain.getInstance().getPermissionDeveloperConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + developerPermissionID ,true)) {
            if (!player.isOp()) {
                player.setOp(true);
            }
        }else if (GhostMain.getInstance().getPermissionModeratorConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + moderatorPermissionID ,true)) {
            if (player.isOp()){
                player.setOp(false);
            }
        }else if (!GhostMain.getInstance().getPermissionOwnerConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + ownerPermissionID , true)) {
            if (!GhostMain.getInstance().getPermissionAdminConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + adminPermissionID ,true)) {
                if (!GhostMain.getInstance().getPermissionDeveloperConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + developerPermissionID ,true)) {
                    if (!GhostMain.getInstance().getPermissionModeratorConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + moderatorPermissionID ,true)) {
                        if (player.isOp()) {
                            player.setOp(false);
                        }
                    }
                }
            }
        }
    }

}
