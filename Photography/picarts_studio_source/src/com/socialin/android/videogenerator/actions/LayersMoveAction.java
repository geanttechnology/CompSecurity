// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import myobfuscated.cz.a;

// Referenced classes of package com.socialin.android.videogenerator.actions:
//            Action

public class LayersMoveAction extends Action
{

    private static final long serialVersionUID = 0xdbc3e17e90aad562L;
    private List newLayerIds;

    public LayersMoveAction(List list, String s)
    {
        super(s);
        newLayerIds = list;
    }

    public void apply(a a1)
    {
        if (newLayerIds.size() != a1.b.size()) goto _L2; else goto _L1
_L1:
        List list;
        int j;
        list = newLayerIds;
        j = 0;
_L8:
        if (j >= list.size()) goto _L2; else goto _L3
_L3:
        UUID uuid;
        int i;
        int k;
        uuid = (UUID)list.get(j);
        k = a1.b.size();
        i = 0;
_L6:
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        if (!a1.a(i).c.equals(uuid)) goto _L5; else goto _L4
_L4:
        if (j != i)
        {
            Collections.swap(a1.b, j, i);
        }
        j++;
        continue; /* Loop/switch isn't completed */
_L5:
        i++;
          goto _L6
        i = -1;
          goto _L4
_L2:
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public String getActionDescription()
    {
        return "Move Layer";
    }

    public String toString()
    {
        Iterator iterator = newLayerIds.iterator();
        String s;
        UUID uuid;
        for (s = "Moving Layers LayerIds: "; iterator.hasNext(); s = (new StringBuilder()).append(s).append(" ").append(uuid).toString())
        {
            uuid = (UUID)iterator.next();
        }

        return s;
    }
}
