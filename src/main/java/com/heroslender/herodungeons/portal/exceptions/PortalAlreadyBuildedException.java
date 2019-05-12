package com.heroslender.herodungeons.portal.exceptions;

import org.bukkit.ChatColor;

public class PortalAlreadyBuildedException extends PortalException {
    public PortalAlreadyBuildedException() {
        super(ChatColor.RED + "The portal is already builded, can not build it again!");
    }
}
