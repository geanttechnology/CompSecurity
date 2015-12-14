// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import java.util.List;
import java.util.UUID;
import myobfuscated.cz.a;

// Referenced classes of package com.socialin.android.videogenerator.actions:
//            Action

public class LayerRemoveAction extends Action
{

    private static final long serialVersionUID = 0x93d356ffe673bf27L;
    private UUID removeLayerId;

    public LayerRemoveAction(UUID uuid, String s)
    {
        super(s);
        setRemoveLayerID(uuid);
    }

    public void apply(a a1)
    {
        UUID uuid = getRemoveLayerID();
        for (int i = 0; i < a1.b.size(); i++)
        {
            if (a1.a(i).c.equals(uuid))
            {
                a1.b.remove(i);
            }
        }

    }

    public String getActionDescription()
    {
        return (new StringBuilder("Remove Layer")).append(removeLayerId).toString();
    }

    public UUID getRemoveLayerID()
    {
        return removeLayerId;
    }

    public void setRemoveLayerID(UUID uuid)
    {
        removeLayerId = uuid;
    }

    public String toString()
    {
        return (new StringBuilder("Remove Layer LayerId:")).append(removeLayerId).toString();
    }
}
