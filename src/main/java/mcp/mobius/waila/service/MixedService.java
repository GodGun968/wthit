package mcp.mobius.waila.service;

import mcp.mobius.waila.WailaClient;
import mcp.mobius.waila.gui.hud.TooltipRenderer;
import mcp.mobius.waila.mixed.IMixedService;
import mcp.mobius.waila.registry.RegistryFilter;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.RegistryAccess;

public class MixedService implements IMixedService {

    @Override
    public void attachRegistryFilter(RegistryAccess registryAccess) {
        RegistryFilter.attach(registryAccess);
    }

    @Override
    public void onServerLogin() {
        WailaClient.onServerLogIn();
    }

    @Override
    public void onGuiRender(GuiGraphics ctx, float tickDelta) {
        TooltipRenderer.render(ctx, tickDelta);
    }

}
