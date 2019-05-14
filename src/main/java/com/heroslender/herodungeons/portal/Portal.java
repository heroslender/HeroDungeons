package com.heroslender.herodungeons.portal;

import com.heroslender.herodungeons.portal.exceptions.PortalAlreadyBuildedException;
import com.heroslender.herodungeons.portal.exceptions.PortalException;
import org.bukkit.block.Block;
import org.bukkit.material.MaterialData;

import java.util.Map;

public interface Portal {

    /**
     * Get the portal name.
     * Portal names are unique.
     *
     * @return The portal name.
     */
    String getName();

    /**
     * Get if the portal is open or not.
     *
     * @return {@code true} if open, {@code false} otherwise.
     */
    boolean isOpen();

    /**
     * Get the blocks for the portal.
     *
     * @return An array of blocks in the form of [x][y][z]
     */
    Map<Block, MaterialData> getBlocks();

    /**
     * Get the blocks for the portal part where
     * players pass throw to enter.
     *
     * @return An array of blocks in the form of [x][y][z]
     */
    Map<Block, MaterialData> getPortalBlocks();

    /**
     * Build the portal.
     *
     * @param done Callback called when the portal has finished building.
     */
    void build(Runnable done) throws PortalAlreadyBuildedException;

    /**
     * Build the portal part where players pass throw to enter.
     *
     * @param done Callback called when the portal has finished building.
     */
    void buildPortal(Runnable done) throws PortalException;
}
