package com.heroslender.herodungeons.portal.builder;

import com.heroslender.herodungeons.HeroDungeons;
import lombok.val;
import org.bukkit.block.Block;
import org.bukkit.material.MaterialData;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

public class PortalBuilderStandard extends PortalBuilder {
    public PortalBuilderStandard(Iterator<Map.Entry<Block, MaterialData>> toReplace) {
        super("Standard", 2, toReplace);
    }

    public PortalBuilderStandard(String name, Iterator<Map.Entry<Block, MaterialData>> toReplace) {
        super(name, 2, toReplace);
    }

    public PortalBuilderStandard(String name, int delay, Iterator<Map.Entry<Block, MaterialData>> toReplace) {
        super(name, delay, toReplace);
    }

    @Override
    public void build(final Consumer<Block> onBlockChange, final Runnable onBuildFinish) {
        HeroDungeons.getInstance().getLogger().info("Building portal " + getClass().getName() + "...");
        new BukkitRunnable() {
            @Override
            public void run() {
                val blockIterator = getBlockIterator();

                try {
                    if (blockIterator.hasNext()) {
                        Map.Entry<Block, MaterialData> entry = blockIterator.next();
                        final MaterialData blockData = entry.getValue();
                        if (blockData != null) {
                            final Block block = entry.getKey();

                            block.setType(blockData.getItemType());
                            block.setData(blockData.getData());

                            if (onBlockChange != null) {
                                onBlockChange.accept(block);
                            }
                        }
                    } else {
                        finishBuild();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    finishBuild();
                }
            }

            private void finishBuild() {
                HeroDungeons.getInstance().getLogger().info("Finishing portal " + getClass().getName() + "...");
                cancel();
                if (onBuildFinish != null) {
                    onBuildFinish.run();
                }
            }
        }.runTaskTimer(HeroDungeons.getInstance(), 1, getDelay());
    }
}
