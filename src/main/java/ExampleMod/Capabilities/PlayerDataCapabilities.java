package HavenCoreNetwork.BlackClover.Capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class PlayerDataCapabilities {

    @CapabilityInject(IPlayerData.class)
    public static final Capability<IPlayerData> PLAYER_DATA = null;
}
