// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import android.graphics.Bitmap;
import java.util.UUID;
import myobfuscated.cz.a;

// Referenced classes of package com.socialin.android.videogenerator.actions:
//            Action

public class LayerClearAction extends Action
{

    private static final long serialVersionUID = 0x50b23906358aa8c3L;
    private UUID layerId;

    public LayerClearAction(UUID uuid, String s)
    {
        super(s);
        layerId = uuid;
    }

    public void apply(a a1)
    {
        a1 = a1.a(getLayerId());
        if (((com.socialin.android.videogenerator.layer.a) (a1)).e != null)
        {
            if (((com.socialin.android.videogenerator.layer.a) (a1)).a != null)
            {
                ((com.socialin.android.videogenerator.layer.a) (a1)).a.recycle();
            }
            a1.a();
            return;
        } else
        {
            ((com.socialin.android.videogenerator.layer.a) (a1)).a.eraseColor(0);
            return;
        }
    }

    public void apply(a a1, int i)
    {
    }

    public String getActionDescription()
    {
        return "Clear Layer";
    }

    public UUID getLayerId()
    {
        return layerId;
    }

    public void setLayerId(UUID uuid)
    {
        layerId = uuid;
    }

    public String toString()
    {
        return (new StringBuilder("Clear Layer LayerId:")).append(layerId).toString();
    }
}
