package HavenCoreNetwork.BlackClover.Capabilities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

public interface IPlayerData extends INBTSerializable<NBTTagCompound> {

    int getMana();
    void setMana(int Mana);
    void addMana(int ManaToAdd);
    void reduceMana(int  ManaToReduce);

    int getMaxMana();
    void setMaxMana(int Mana);
    void addMaxMana(int ManaToAdd);
    void reduceMaxMana(int  ManaToReduce);
}
