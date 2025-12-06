package com.t2pellet.strawgolem.common.entity.capabilities.harvester;

import com.t2pellet.haybale.common.capability.api.Capability;
import com.t2pellet.haybale.common.capability.api.ICapabilityHaver;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentUser;

import java.util.Optional;



public interface Harvester extends Capability {

    interface HarvesterEntity extends
            ICapabilityHaver,
            //? if >= 1.20.6
            EquipmentUser
    {}

    static <E extends Entity & ICapabilityHaver> Harvester getInstance(E entity) {
        return new HarvesterImpl<>((Entity & HarvesterEntity) entity);
    }

    void queueHarvest(BlockPos pos);
    Optional<BlockPos> startHarvest();
    void completeHarvest();
    void clearQueue();
    void clearHarvest();
    boolean isHarvesting();
    boolean isHarvestingBlock();
    Optional<BlockPos> getHarvesting();
    void findHarvestables();

}
