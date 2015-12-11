// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.if;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package io.presage.services.if:
//            a, f, e

public final class b extends a
    implements f
{

    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private long i;
    private long j;

    public b()
    {
        e = false;
        f = false;
        g = false;
        h = false;
        i = 0L;
    }

    public final long a(e e1)
    {
        e1 = (b)e1;
        if (e1 == null)
        {
            return 0L;
        } else
        {
            return Math.abs(((b) (e1)).j - j);
        }
    }

    public final void a(long l)
    {
        i = l;
    }

    public final void a(boolean flag)
    {
        f = flag;
    }

    public final String b()
    {
        return b;
    }

    public final void b(String s)
    {
        b = s;
    }

    public final void b(boolean flag)
    {
        g = flag;
    }

    public final volatile boolean b(e e1)
    {
        return false;
    }

    public final b c()
    {
        b b1 = new b();
        b1.a = a;
        b1.b = b;
        b1.c = c;
        b1.d = d;
        b1.e = e;
        b1.f = f;
        b1.g = g;
        b1.h = h;
        b1.i = i;
        b1.j = j;
        return b1;
    }

    public final void c(String s)
    {
        c = s;
    }

    public final Object clone()
    {
        return c();
    }

    public final Map d()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("appname", a);
        hashmap.put("pname", b);
        hashmap.put("version_code", d);
        hashmap.put("version_name", c);
        hashmap.put("is_running", Boolean.toString(e));
        hashmap.put("is_system", Boolean.toString(f));
        hashmap.put("is_launcher", Boolean.toString(g));
        hashmap.put("on_front", Boolean.toString(h));
        hashmap.put("use_time", Long.toString(i));
        return hashmap;
    }

    public final void d(String s)
    {
        d = s;
    }

    public final void e()
    {
        j = (new Date()).getTime();
    }

    public final String f()
    {
        StringBuilder stringbuilder = new StringBuilder(b);
        stringbuilder.append(":");
        stringbuilder.append(d);
        stringbuilder.append(":");
        stringbuilder.append(e);
        stringbuilder.append(":");
        stringbuilder.append(h);
        return stringbuilder.toString();
    }
}
