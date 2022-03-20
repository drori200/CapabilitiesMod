package HavenCoreNetwork.BlackClover.Capabilities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerDataProvider implements ICapabilityProvider, ICapabilitySerializable<NBTTagCompound> {

    private final IPlayerData playerData = PlayerDataCapabilities.PLAYER_DATA.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == PlayerDataCapabilities.PLAYER_DATA;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == PlayerDataCapabilities.PLAYER_DATA ? PlayerDataCapabilities.PLAYER_DATA.<T> cast(this.playerData) : null;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        return playerData.serializeNBT();
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        playerData.deserializeNBT(nbt);
    }
}
