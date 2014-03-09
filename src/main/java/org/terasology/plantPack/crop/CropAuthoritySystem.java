/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.plantPack.crop;

import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.entitySystem.event.ReceiveEvent;
import org.terasology.entitySystem.systems.BaseComponentSystem;
import org.terasology.entitySystem.systems.RegisterMode;
import org.terasology.entitySystem.systems.RegisterSystem;
import org.terasology.farm.event.SeedPlanted;
import org.terasology.gf.PlantedSaplingComponent;
import org.terasology.math.Vector3i;
import org.terasology.registry.In;
import org.terasology.world.BlockEntityRegistry;

/**
 * @author Marcin Sciesinski <marcins78@gmail.com>
 */
@RegisterSystem(RegisterMode.AUTHORITY)
public class CropAuthoritySystem extends BaseComponentSystem {
    @In
    private BlockEntityRegistry blockEntityRegistry;

    @ReceiveEvent
    public void cropPlanted(SeedPlanted event, EntityRef plant) {
        Vector3i location = event.getLocation();
        EntityRef plantedEntity = blockEntityRegistry.getEntityAt(location);
        PlantedSaplingComponent planted = new PlantedSaplingComponent();
        plantedEntity.addComponent(planted);
    }
}