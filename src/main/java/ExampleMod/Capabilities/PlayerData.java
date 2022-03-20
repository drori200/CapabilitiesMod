package HavenCoreNetwork.BlackClover.Capabilities;

import net.minecraft.nbt.NBTTagCompound;

public class PlayerData implements IPlayerData{
    private int MaxMana;
    private int CurrentMana;

    private static final String Current_MANA_NBT = "Current_Mana";
    private static final String Max_MANA_NBT = "Max_Mana";

    public PlayerData(){
        System.out.println("Hi there mate I AM WORKING");
    }

    @Override
    public int getMana() {
        return CurrentMana;
    }

    @Override
    public void setMana(int Mana) {
        this.CurrentMana = Mana;
    }

    @Override
    public void addMana(int ManaToAdd) {
        this.CurrentMana += ManaToAdd;
    }

    @Override
    public void reduceMana(int ManaToReduce) {
        this.CurrentMana -= ManaToReduce;
    }

    @Override
    public int getMaxMana() {
        return MaxMana;
    }

    @Override
    public void setMaxMana(int Mana) {
        this.MaxMana = Mana;
    }

    @Override
    public void addMaxMana(int ManaToAdd) {
        this.MaxMana += ManaToAdd;
    }

    @Override
    public void reduceMaxMana(int ManaToReduce) {
        this.MaxMana -= ManaToReduce;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        final NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger(Current_MANA_NBT, this.CurrentMana);
        nbt.setInteger(Max_MANA_NBT, this.MaxMana);
        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        this.CurrentMana = nbt.getInteger(Current_MANA_NBT);
        this.MaxMana = nbt.getInteger(Max_MANA_NBT);
    }
}
