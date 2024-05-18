package mcp.mobius.waila.forge;

import com.mojang.blaze3d.platform.InputConstants;
import mcp.mobius.waila.api.WailaConstants;
import mcp.mobius.waila.service.IClientService;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;

public class ForgeClientService implements IClientService {

    @Override
    public KeyMapping createKeyBind(String id, int key) {
        return new KeyMapping(id, KeyConflictContext.IN_GAME, KeyModifier.NONE, InputConstants.Type.KEYSYM, key, WailaConstants.MOD_NAME);
    }

}
