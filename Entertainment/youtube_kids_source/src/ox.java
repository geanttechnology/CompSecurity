// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ox
    implements Runnable
{

    private bxb a;
    private String b;
    private bhv c;
    private ow d;

    public ox(ow ow1, bxb bxb1, String s, bhv bhv1)
    {
        d = ow1;
        a = bxb1;
        b = s;
        c = bhv1;
        super();
    }

    public final void run()
    {
        Object obj1 = new bnb(ow.a(d), d.d);
        String s = bxb.a(a.a);
        Object obj = ow.b(d);
        Object obj2 = a;
        Object obj3 = b;
        obj2 = ((bdb) (obj)).a(((bxb) (obj2)));
        if (obj2 == null)
        {
            c.a(s, null);
            return;
        }
        obj3 = d;
        String s1 = b;
        obj = a;
        HashMap hashmap = new HashMap();
        dtj adtj[] = ((bxb) (obj)).a.d;
        int j = adtj.length;
        for (int i = 0; i < j; i++)
        {
            Object obj4 = adtj[i];
            if (((dtj) (obj4)).c != null && ((dtj) (obj4)).c.a != null)
            {
                obj4 = new bxb(((dtj) (obj4)).c.a, ((bxb) (obj)).b, ((bxb) (obj)).c, bxb.a(new bwy(new bwz[0]), ((dtj) (obj4)).c.a, ((bxb) (obj)).b));
                hashmap.put(bxb.a(((bxb) (obj4)).a), obj4);
            }
        }

        if (hashmap.isEmpty())
        {
            obj = Collections.emptyMap();
        } else
        {
            obj = Collections.unmodifiableMap(hashmap);
        }
        obj1 = ((ow) (obj3)).a(((bfx) (obj2)), s1, ((bnb) (obj1)), ((Map) (obj)));
        if (obj1 != null)
        {
            obj = ((bfm) (obj1)).b;
        } else
        {
            obj = null;
        }
        if (obj != null && ((buz) (obj)).V != null && ow.c(d) != null)
        {
            ow.c(d).c(new bfe(((bfm) (obj1))));
        }
        c.a(s, obj1);
        obj = d;
        obj = b;
        obj = a.h();
        if (((bwp) (obj)).a.g == null)
        {
            new bwo();
            return;
        } else
        {
            new bwo(((bwp) (obj)).a.g);
            return;
        }
    }
}
