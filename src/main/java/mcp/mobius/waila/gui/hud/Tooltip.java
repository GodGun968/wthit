package mcp.mobius.waila.gui.hud;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mcp.mobius.waila.api.ITooltip;
import mcp.mobius.waila.api.ITooltipLine;
import net.minecraft.resources.ResourceLocation;

public class Tooltip extends ObjectArrayList<Line> implements ITooltip {

    private final Object2IntMap<ResourceLocation> tags = new Object2IntOpenHashMap<>();

    public void setLine(ResourceLocation tag, Line line) {
        if (tags.containsKey(tag)) {
            set(tags.getInt(tag), line);
        } else {
            tags.put(tag, size);
            add(line);
        }
    }

    @Override
    public int getLineCount() {
        return size;
    }

    @Override
    public ITooltipLine getLine(int index) {
        return get(index);
    }

    @Override
    public ITooltipLine addLine() {
        var line = new Line(null);
        add(line);
        return line;
    }

    @Override
    public ITooltipLine setLine(ResourceLocation tag) {
        var line = new Line(tag);
        setLine(tag, line);
        return line;
    }

    @Override
    public Line getLine(ResourceLocation tag) {
        return tags.containsKey(tag)
            ? get(tags.getInt(tag))
            : null;
    }

    @Override
    public void clear() {
        super.clear();
        tags.clear();
    }

}
