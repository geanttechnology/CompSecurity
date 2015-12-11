// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            acx, act, acr

class d
    implements d
{

    final Map a;
    final Map b;
    final Map c;
    final Map d;
    final acx e;

    public void a(d d1, Set set, Set set1, act act1)
    {
        List list = (List)a.get(d1);
        List list1 = (List)b.get(d1);
        if (list != null)
        {
            set.addAll(list);
            act1.c().a(list, list1);
        }
        set = (List)c.get(d1);
        d1 = (List)d.get(d1);
        if (set != null)
        {
            set1.addAll(set);
            act1.d().a(set, d1);
        }
    }

    (acx acx1, Map map, Map map1, Map map2, Map map3)
    {
        e = acx1;
        a = map;
        b = map1;
        c = map2;
        d = map3;
        super();
    }
}
