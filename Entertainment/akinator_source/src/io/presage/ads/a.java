// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.ads;

import io.presage.utils.do.do.b;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package io.presage.ads:
//            d, c

public final class a
{

    private static a a = null;
    private Map b;

    private a()
    {
        b = new HashMap();
    }

    public static a a()
    {
        if (a == null)
        {
            a = new a();
        }
        return a;
    }

    public final d a(String s)
    {
        return (d)b.get(s);
    }

    public final d a(Map map, b b1)
    {
        map = new c(map, b1);
        b.put(map.c(), map);
        return map;
    }

    public final void b(String s)
    {
        b.remove(s);
    }

}
