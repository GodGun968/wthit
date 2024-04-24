package mcp.mobius.waila.plugin.neo.fluid;

import mcp.mobius.waila.api.data.FluidData.FluidDescription;
import mcp.mobius.waila.api.data.FluidData.FluidDescriptionContext;
import mcp.mobius.waila.api.data.FluidData.FluidDescriptor;
import net.minecraft.client.Minecraft;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;

public enum NeoFluidDescriptor implements FluidDescriptor<Fluid> {

    INSTANCE;

    @Override
    public void describeFluid(FluidDescriptionContext<Fluid> ctx, FluidDescription desc) {
        var stack = new FluidStack(ctx.fluid().builtInRegistryHolder(), 1, ctx.data());
        var type = ctx.fluid().getFluidType();
        var extensions = IClientFluidTypeExtensions.of(type);

        desc.name(type.getDescription(stack))
            .sprite(Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(extensions.getStillTexture(stack)))
            .tint(extensions.getTintColor(stack));
    }

}
