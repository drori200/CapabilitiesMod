package HavenCoreNetwork.BlackClover.Capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nullable;

public class NBTCapabilityStorage<T extends NBTBase, U extends INBTSerializable<T>> implements Capability.IStorage<U> {

    private final Class<T> nbtClass;

    private NBTCapabilityStorage(Class<T> nbtClass) {
        this.nbtClass = nbtClass;
    }

    public static <V extends NBTBase, W extends INBTSerializable<V>> NBTCapabilityStorage<V, W> create(Class<V> tClass) {
        return new NBTCapabilityStorage<>(tClass);
    }

    public static <V extends INBTSerializable<NBTTagCompound>> NBTCapabilityStorage<NBTTagCompound, V> create() {
        return new NBTCapabilityStorage<>(NBTTagCompound.class);
    }

    @Nullable
    @Override
    public NBTBase writeNBT(Capability<U> capability, U instance, EnumFacing side) {
        return instance.serializeNBT();
    }

    @Override
    public void readNBT(Capability<U> capability, U instance, EnumFacing side, NBTBase nbt) {
        if (nbtClass.isInstance(nbt)) {
            instance.deserializeNBT(nbtClass.cast(nbt));
        }
    }
}
