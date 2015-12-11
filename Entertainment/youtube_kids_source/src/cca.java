// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class cca
    implements bhv
{

    private final List a;
    private final bhv b;
    private final Map c;
    private final List d;
    private cbz e;

    cca(cbz cbz1, List list, bhv bhv1, Map map, List list1)
    {
        e = cbz1;
        super();
        a = list;
        b = bhv1;
        c = map;
        d = list1;
    }

    public final void a(Object obj, Exception exception)
    {
        b.a(a, exception);
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (List)obj1;
        obj1 = new HashMap();
        Iterator iterator = d.iterator();
        for (int i = 0; iterator.hasNext(); i++)
        {
            String s = (String)iterator.next();
            cdj cdj1 = (cdj)((List) (obj)).get(i);
            if (cdj1.b == 200)
            {
                e.a.a(e.b.a(s), new cnz(cdj1.a, e.c.a()));
            }
            ((Map) (obj1)).put(s, cdj1);
        }

        b.a(a, cbz.a(e, a, c, ((Map) (obj1))));
    }
}
