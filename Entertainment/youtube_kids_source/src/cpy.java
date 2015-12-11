// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class cpy extends cre
    implements bn
{

    private final List j;
    private final Map k;
    private final cqb l;
    private final cqt m;

    public cpy(int i, String s, boolean flag, String s1, int i1, long l1, 
            Map map, cqb cqb1, mj mj, List list, bmi bmi, int j1, cqt cqt1)
    {
        super(i, s, mj);
        super.h = new lv((int)TimeUnit.SECONDS.toMillis(j1), 0, 0.0F);
        super.e = false;
        b.a(s);
        b.a(s1);
        k = map;
        l = (cqb)b.a(cqb1);
        j = (List)b.a(list);
        b.a(bmi);
        m = (cqt)b.a(cqt1);
    }

    protected final mi a(mb mb)
    {
        return mi.a(null, null);
    }

    protected final void a(Object obj)
    {
        l.a();
    }

    public final void b(mp mp)
    {
        cqb cqb1 = l;
        cni.a(mp);
        cqb1.b();
    }

    public final Map c()
    {
        HashMap hashmap = new HashMap();
        cqs cqs1;
        for (Iterator iterator = j.iterator(); iterator.hasNext(); cqs1.a(hashmap, this))
        {
            cqs1 = (cqs)iterator.next();
            m.a();
        }

        return hashmap;
    }

    protected final Map f()
    {
        return k;
    }
}
