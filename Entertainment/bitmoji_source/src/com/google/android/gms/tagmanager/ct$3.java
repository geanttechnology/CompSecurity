// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            ct, cn, cl

class WX
    implements WX
{

    final ct WT;
    final Map WU;
    final Map WV;
    final Map WW;
    final Map WX;

    public void a(WX wx, Set set, Set set1, cn cn1)
    {
        List list = (List)WU.get(wx);
        List list1 = (List)WV.get(wx);
        if (list != null)
        {
            set.addAll(list);
            cn1.jl().b(list, list1);
        }
        set = (List)WW.get(wx);
        wx = (List)WX.get(wx);
        if (set != null)
        {
            set1.addAll(set);
            cn1.jm().b(set, wx);
        }
    }

    (ct ct1, Map map, Map map1, Map map2, Map map3)
    {
        WT = ct1;
        WU = map;
        WV = map1;
        WW = map2;
        WX = map3;
        super();
    }
}
