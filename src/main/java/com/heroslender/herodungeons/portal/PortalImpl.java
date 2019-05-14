package com.heroslender.herodungeons.portal;

import com.heroslender.herodungeons.portal.exceptions.PortalAlreadyBuildedException;
import com.heroslender.herodungeons.portal.exceptions.PortalException;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.material.MaterialData;

import java.util.HashMap;
import java.util.Map;

public class PortalImpl implements Portal {
    private final String name;
    private final Location location;
    private final Map<Block, MaterialData> blocks;
    private final Map<Block, MaterialData> portalBlocks;
    private final Map<Block, MaterialData> oldBlocks = new HashMap<>();

    private boolean open = false;

    public PortalImpl(String name, Location location, Map<Block, MaterialData> blocks, Map<Block, MaterialData> portalBlocks) {
        this.name = name;
        this.location = location;
        this.blocks = blocks;
        this.portalBlocks = portalBlocks;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public Map<Block, MaterialData> getBlocks() {
        return blocks;
    }

    @Override
    public Map<Block, MaterialData> getPortalBlocks() {
        return portalBlocks;
    }

    @Override
    public void build(Runnable done) throws PortalAlreadyBuildedException {
        if (isOpen()) {
            throw new PortalAlreadyBuildedException();
        }
        open = true;

        // TODO - Build portal

        done.run();
    }

    @Override
    public void buildPortal(Runnable done) throws PortalException {
        if (!isOpen()) {
            throw new PortalException("Portal must be open.");
        }
        open = true;

        // TODO - Build portal
        done.run();

    }
}
