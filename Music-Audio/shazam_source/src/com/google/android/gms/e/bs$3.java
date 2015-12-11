// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.e:
//            bs, bo

final class d
    implements d
{

    final Map a;
    final Map b;
    final Map c;
    final Map d;
    final bs e;

    public final void a(com.google.android.gms.d.d d1, Set set, Set set1, bo bo1)
    {
        List list = (List)a.get(d1);
        b.get(d1);
        if (list != null)
        {
            set.addAll(list);
            bo1.c();
        }
        set = (List)c.get(d1);
        d.get(d1);
        if (set != null)
        {
            set1.addAll(set);
            bo1.d();
        }
    }

    (bs bs1, Map map, Map map1, Map map2, Map map3)
    {
        e = bs1;
        a = map;
        b = map1;
        c = map2;
        d = map3;
        super();
    }
}
