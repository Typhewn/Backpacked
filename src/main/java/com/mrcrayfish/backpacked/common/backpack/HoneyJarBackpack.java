package com.mrcrayfish.backpacked.common.backpack;

import com.mrcrayfish.backpacked.Reference;
import com.mrcrayfish.backpacked.client.ClientHandler;
import com.mrcrayfish.backpacked.client.ModelInstances;
import com.mrcrayfish.backpacked.client.model.BackpackModel;
import com.mrcrayfish.backpacked.common.Backpack;
import com.mrcrayfish.backpacked.common.IProgressTracker;
import com.mrcrayfish.backpacked.common.ProgressFormatters;
import com.mrcrayfish.backpacked.common.tracker.CountProgressTracker;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

/**
 * Author: MrCrayfish
 */
public class HoneyJarBackpack extends Backpack
{
    public static final ResourceLocation ID = new ResourceLocation(Reference.MOD_ID, "honey_jar");

    public HoneyJarBackpack()
    {
        super(ID);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BackpackModel getModel()
    {
        return ClientHandler.getModelInstances().getHoneyJar();
    }

    @Nullable
    @Override
    protected IProgressTracker createProgressTracker()
    {
        return new CountProgressTracker(20, ProgressFormatters.COLLECT_X_OF_X);
    }
}
