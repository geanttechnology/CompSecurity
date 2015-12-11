// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.if;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package io.presage.services.if:
//            a, f, e

public final class d extends a
    implements f
{

    private String a;
    private String b;
    private String c;
    private String d;
    private long e;

    public d()
    {
        e = 0L;
    }

    private String c()
    {
        if (c == null || c.length() == 0)
        {
            c = "0";
        }
        return c;
    }

    public final long a(e e1)
    {
        for (e1 = (d)e1; e1 == null || e1.c() == null || c() == null || e1.c().equals("0") || c().equals("0");)
        {
            return 0L;
        }

        return Math.abs(Long.parseLong(c()) - Long.parseLong(e1.c()));
    }

    public final void a(long l)
    {
        e = l;
    }

    public final String b()
    {
        StringBuilder stringbuilder = new StringBuilder(a());
        stringbuilder.append(":");
        stringbuilder.append(b);
        return stringbuilder.toString();
    }

    public final void b(String s)
    {
        a = s;
    }

    public final boolean b(e e1)
    {
        e1 = (d)e1;
        return e1 != null && Long.parseLong(c()) != Long.parseLong(e1.c());
    }

    public final void c(String s)
    {
        b = s;
    }

    public final Map d()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("_id", a());
        hashmap.put("title", a);
        hashmap.put("url", b);
        hashmap.put("date", c());
        hashmap.put("visits", d);
        hashmap.put("time", Long.toString(e));
        return hashmap;
    }

    public final void d(String s)
    {
        c = s;
    }

    public final void e(String s)
    {
        d = s;
    }

    public final String f()
    {
        StringBuilder stringbuilder = new StringBuilder(a());
        stringbuilder.append(":");
        stringbuilder.append(b);
        stringbuilder.append(":");
        stringbuilder.append(d);
        return stringbuilder.toString();
    }
}
