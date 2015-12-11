// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            wd

public final class wl extends wd
{

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    public wl()
    {
    }

    public String a()
    {
        return a;
    }

    public volatile void a(wd wd1)
    {
        a((wl)wd1);
    }

    public void a(wl wl1)
    {
        if (!TextUtils.isEmpty(a))
        {
            wl1.a(a);
        }
        if (!TextUtils.isEmpty(b))
        {
            wl1.b(b);
        }
        if (!TextUtils.isEmpty(c))
        {
            wl1.c(c);
        }
        if (!TextUtils.isEmpty(d))
        {
            wl1.d(d);
        }
        if (!TextUtils.isEmpty(e))
        {
            wl1.e(e);
        }
        if (!TextUtils.isEmpty(f))
        {
            wl1.f(f);
        }
        if (!TextUtils.isEmpty(g))
        {
            wl1.g(g);
        }
        if (!TextUtils.isEmpty(h))
        {
            wl1.h(h);
        }
        if (!TextUtils.isEmpty(i))
        {
            wl1.i(i);
        }
        if (!TextUtils.isEmpty(j))
        {
            wl1.j(j);
        }
    }

    public void a(String s)
    {
        a = s;
    }

    public String b()
    {
        return b;
    }

    public void b(String s)
    {
        b = s;
    }

    public String c()
    {
        return c;
    }

    public void c(String s)
    {
        c = s;
    }

    public String d()
    {
        return d;
    }

    public void d(String s)
    {
        d = s;
    }

    public String e()
    {
        return e;
    }

    public void e(String s)
    {
        e = s;
    }

    public String f()
    {
        return f;
    }

    public void f(String s)
    {
        f = s;
    }

    public String g()
    {
        return g;
    }

    public void g(String s)
    {
        g = s;
    }

    public String h()
    {
        return h;
    }

    public void h(String s)
    {
        h = s;
    }

    public String i()
    {
        return i;
    }

    public void i(String s)
    {
        i = s;
    }

    public String j()
    {
        return j;
    }

    public void j(String s)
    {
        j = s;
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("name", a);
        hashmap.put("source", b);
        hashmap.put("medium", c);
        hashmap.put("keyword", d);
        hashmap.put("content", e);
        hashmap.put("id", f);
        hashmap.put("adNetworkId", g);
        hashmap.put("gclid", h);
        hashmap.put("dclid", i);
        hashmap.put("aclid", j);
        return a(hashmap);
    }
}
