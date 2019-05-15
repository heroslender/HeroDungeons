package com.heroslender.herodungeons.portal.builder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.block.Block;
import org.bukkit.material.MaterialData;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

@RequiredArgsConstructor
public abstract class PortalBuilder {
    @Getter private final String name;
    @Getter private final int delay;
    @Getter private final Iterator<Map.Entry<Block, MaterialData>> blockIterator;

    abstract public void build(final Consumer<Block> onBlockChange, final Runnable onBuildFinish);
}
