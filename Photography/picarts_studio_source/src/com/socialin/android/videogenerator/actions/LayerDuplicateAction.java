// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import java.util.UUID;
import myobfuscated.cz.a;

// Referenced classes of package com.socialin.android.videogenerator.actions:
//            Action

public class LayerDuplicateAction extends Action
{

    private static final long serialVersionUID = 0x79c163367f7df220L;
    private UUID layerId;
    private UUID newLayerId;

    public LayerDuplicateAction(UUID uuid, UUID uuid1, String s)
    {
        super(s);
        layerId = uuid;
        newLayerId = uuid1;
    }

    public void apply(a a)
    {
    }

    public String getActionDescription()
    {
        return null;
    }

    public UUID getLayerId()
    {
        return layerId;
    }

    public UUID getNewLayerId()
    {
        return newLayerId;
    }

    public void setLayerId(UUID uuid)
    {
        layerId = uuid;
    }

    public void setNewLayerId(UUID uuid)
    {
        newLayerId = uuid;
    }
}
