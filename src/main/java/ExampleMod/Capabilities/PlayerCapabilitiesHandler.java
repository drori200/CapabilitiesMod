package HavenCoreNetwork.BlackClover.Capabilities;

import ExampleMod.ExampleMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID)
public class PlayerCapabilitiesHandler {

    public static void register() {
        CapabilityManager.INSTANCE.register(IPlayerData.class, NBTCapabilityStorage.create(NBTTagCompound.class), PlayerData::new);
    }

    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(new ResourceLocation(ExampleMod.MODID, "BC_PDATA"), new PlayerDataProvider());
        }
    }

    @SubscribeEvent
    public static void playerClone(PlayerEvent.Clone event) {
        final IPlayerData oldData = event.getOriginal().getCapability(PlayerDataCapabilities.PLAYER_DATA, null);
        final IPlayerData newData = event.getEntityPlayer().getCapability(PlayerDataCapabilities.PLAYER_DATA, null);
        if(oldData != null && newData != null) {
            newData.deserializeNBT(oldData.serializeNBT());
        }
    }
}
