// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            wd

public final class ws extends wd
{

    public String a;
    public long b;
    public String c;
    public String d;

    public ws()
    {
    }

    public String a()
    {
        return a;
    }

    public void a(long l)
    {
        b = l;
    }

    public volatile void a(wd wd1)
    {
        a((ws)wd1);
    }

    public void a(ws ws1)
    {
        if (!TextUtils.isEmpty(a))
        {
            ws1.a(a);
        }
        if (b != 0L)
        {
            ws1.a(b);
        }
        if (!TextUtils.isEmpty(c))
        {
            ws1.b(c);
        }
        if (!TextUtils.isEmpty(d))
        {
            ws1.c(d);
        }
    }

    public void a(String s)
    {
        a = s;
    }

    public long b()
    {
        return b;
    }

    public void b(String s)
    {
        c = s;
    }

    public String c()
    {
        return c;
    }

    public void c(String s)
    {
        d = s;
    }

    public String d()
    {
        return d;
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("variableName", a);
        hashmap.put("timeInMillis", Long.valueOf(b));
        hashmap.put("category", c);
        hashmap.put("label", d);
        return a(hashmap);
    }
}
