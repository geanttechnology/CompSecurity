// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;
import java.util.Map;
import java.util.Set;

class ang.Object
    implements arr
{

    final Map a;
    final Map b;
    final Map c;
    final Map d;
    final arq e;

    public void a(aro aro, Set set, Set set1, arl arl1)
    {
        List list = (List)a.get(aro);
        List list1 = (List)b.get(aro);
        if (list != null)
        {
            set.addAll(list);
            arl1.c().a(list, list1);
        }
        set = (List)c.get(aro);
        aro = (List)d.get(aro);
        if (set != null)
        {
            set1.addAll(set);
            arl1.d().a(set, aro);
        }
    }

    (arq arq1, Map map, Map map1, Map map2, Map map3)
    {
        e = arq1;
        a = map;
        b = map1;
        c = map2;
        d = map3;
        super();
    }
}
