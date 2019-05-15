package com.heroslender.herodungeons.portal.builder;

import lombok.val;
import org.bukkit.block.Block;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class PortalBuilderRandom extends PortalBuilderStandard {
    public PortalBuilderRandom(Map<Block, MaterialData> toReplace) {
        super("Random", shuffleBlocks(toReplace));
    }

    private static Iterator<Map.Entry<Block, MaterialData>> shuffleBlocks(Map<Block, MaterialData> blocks) {
        val list = new ArrayList<>(blocks.entrySet());

        Collections.shuffle(list);

        return list.iterator();
    }
}
