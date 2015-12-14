// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import android.graphics.Bitmap;
import java.util.UUID;
import myobfuscated.cz.a;

// Referenced classes of package com.socialin.android.videogenerator.actions:
//            Action

public class LayerFillAction extends Action
{

    private static final long serialVersionUID = 0x2fc4cf3c17299f30L;
    private int color;
    private UUID layerId;

    public LayerFillAction(UUID uuid, int i, String s)
    {
        super(s);
        layerId = uuid;
        color = i;
    }

    public void apply(a a1)
    {
        a1 = a1.a(getLayerId());
        int i = getColor();
        ((com.socialin.android.videogenerator.layer.a) (a1)).a.eraseColor(i);
    }

    public String getActionDescription()
    {
        return (new StringBuilder("Fill Layer with ")).append(color).append("color").toString();
    }

    public int getColor()
    {
        return color;
    }

    public UUID getLayerId()
    {
        return layerId;
    }

    public void setColor(int i)
    {
        color = i;
    }

    public void setLayerId(UUID uuid)
    {
        layerId = uuid;
    }

    public String toString()
    {
        return (new StringBuilder("Fill Layer LayerId:")).append(layerId).append("with ").append(color).append("color").toString();
    }
}
