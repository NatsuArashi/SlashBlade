package mods.flammpfeil.slashblade.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.Timer;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Furia on 2016/02/03.
 */
public class ReflectionAccessHelper {

    @SideOnly(Side.CLIENT)
    public static Timer timer;
    @SideOnly(Side.CLIENT)
    public static float getPartialTicks(){

        if(timer == null)
            timer = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), "timer", "field_71428_T");

        return timer.renderPartialTicks;
    }

    public static void setFire(Entity entity, int ticks) {
        ReflectionHelper.setPrivateValue(Entity.class, entity, ticks, "fire", "field_70151_c");
    }
}
