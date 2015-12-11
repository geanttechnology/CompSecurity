// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            wd

public final class wk extends wd
{

    private String a;
    private String b;
    private String c;
    private String d;

    public wk()
    {
    }

    public String a()
    {
        return a;
    }

    public volatile void a(wd wd1)
    {
        a((wk)wd1);
    }

    public void a(wk wk1)
    {
        if (!TextUtils.isEmpty(a))
        {
            wk1.a(a);
        }
        if (!TextUtils.isEmpty(b))
        {
            wk1.b(b);
        }
        if (!TextUtils.isEmpty(c))
        {
            wk1.c(c);
        }
        if (!TextUtils.isEmpty(d))
        {
            wk1.d(d);
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

    public String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("appName", a);
        hashmap.put("appVersion", b);
        hashmap.put("appId", c);
        hashmap.put("appInstallerId", d);
        return a(hashmap);
    }
}
