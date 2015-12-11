// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            wd

public final class wo extends wd
{

    private String a;
    private String b;
    private String c;
    private long d;

    public wo()
    {
    }

    public String a()
    {
        return a;
    }

    public void a(long l)
    {
        d = l;
    }

    public volatile void a(wd wd1)
    {
        a((wo)wd1);
    }

    public void a(wo wo1)
    {
        if (!TextUtils.isEmpty(a))
        {
            wo1.a(a);
        }
        if (!TextUtils.isEmpty(b))
        {
            wo1.b(b);
        }
        if (!TextUtils.isEmpty(c))
        {
            wo1.c(c);
        }
        if (d != 0L)
        {
            wo1.a(d);
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

    public long d()
    {
        return d;
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("category", a);
        hashmap.put("action", b);
        hashmap.put("label", c);
        hashmap.put("value", Long.valueOf(d));
        return a(hashmap);
    }
}
