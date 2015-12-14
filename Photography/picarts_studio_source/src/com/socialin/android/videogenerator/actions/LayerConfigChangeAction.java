// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import com.socialin.android.videogenerator.layer.LayerConfig;
import java.util.UUID;
import myobfuscated.cz.a;

// Referenced classes of package com.socialin.android.videogenerator.actions:
//            Action

public class LayerConfigChangeAction extends Action
{

    private static final long serialVersionUID = 0x377326e53a9b0f4aL;
    private LayerConfig config;
    private UUID layerId;

    public LayerConfigChangeAction(UUID uuid, LayerConfig layerconfig, String s)
    {
        super(s);
        config = layerconfig;
        layerId = uuid;
    }

    public void apply(a a1)
    {
        a1.a(getLayerId()).b = getConfig();
    }

    public String getActionDescription()
    {
        return "Config change";
    }

    public LayerConfig getConfig()
    {
        return config;
    }

    public UUID getLayerId()
    {
        return layerId;
    }

    public boolean isOpacityChanged(Action action)
    {
        if (action == null)
        {
            return true;
        }
        if (action instanceof LayerConfigChangeAction)
        {
            return config.isOpacityChanged(((LayerConfigChangeAction)action).config.getOpacity());
        } else
        {
            return false;
        }
    }

    public void setConfig(LayerConfig layerconfig)
    {
        config = layerconfig;
    }

    public void setLayerId(UUID uuid)
    {
        layerId = uuid;
    }

    public String toString()
    {
        return (new StringBuilder("LayerConfigChange configs:")).append(config.toString()).toString();
    }
}
