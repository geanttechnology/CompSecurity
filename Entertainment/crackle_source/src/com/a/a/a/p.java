// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import android.content.Context;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.a.a.a:
//            a, q, e, f, 
//            k

public abstract class p extends a
{

    f a;
    private int b;
    private String c;

    public p()
    {
        a = new q(this);
    }

    static void a(p p1, int i)
    {
        p1.b = i;
    }

    static void a(p p1, String s)
    {
        p1.c = s;
    }

    public abstract String a(Throwable throwable, String s);

    protected void a(DefaultHttpClient defaulthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, String s, f f, Context context)
    {
        if (s != null)
        {
            httpurirequest.addHeader("Content-Type", s);
        }
        (new e(defaulthttpclient, httpcontext, httpurirequest, f)).run();
    }

    public String b(String s)
    {
        a(s, null, a);
        return c;
    }

    public String b(String s, k k)
    {
        a(s, k, a);
        return c;
    }

    public int c()
    {
        return b;
    }

    public String c(String s)
    {
        c(s, null, a);
        return c;
    }

    public String c(String s, k k)
    {
        c(s, k, a);
        return c;
    }

    public String d(String s)
    {
        b(s, null, a);
        return c;
    }

    public String d(String s, k k)
    {
        b(s, k, a);
        return c;
    }

    public void d(String s, k k, f f)
    {
        d(s, f);
    }

    public String e(String s)
    {
        d(s, null, a);
        return c;
    }

    public String e(String s, k k)
    {
        d(s, k, a);
        return c;
    }
}
