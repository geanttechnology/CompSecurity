// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.Date;

public class mu extends np
{

    private Date a;
    private String b;
    private String c;
    private String d;
    private Uri e;
    private String f;
    private Uri g;
    private Uri h;
    private int i;
    private String j;
    private String k;

    public mu()
    {
        a = new Date();
        d = "-1";
    }

    public String a()
    {
        return b;
    }

    public void a(int l)
    {
        i = l;
    }

    public void a(Uri uri)
    {
        e = uri;
    }

    public void a(String s)
    {
        b = s;
    }

    public String b()
    {
        return c;
    }

    public void b(Uri uri)
    {
        g = uri;
    }

    public void b(String s)
    {
        c = s;
    }

    public String c()
    {
        return d;
    }

    public void c(Uri uri)
    {
        h = uri;
    }

    public void c(String s)
    {
        d = s;
    }

    public Uri d()
    {
        return e;
    }

    public void d(String s)
    {
        f = s;
    }

    public Uri e()
    {
        return g;
    }

    public void e(String s)
    {
        j = s;
    }

    public int f()
    {
        return i;
    }

    public void f(String s)
    {
        k = s;
    }

    public Date g()
    {
        return new Date(Long.valueOf(Long.parseLong(j)).longValue());
    }

    public Uri h()
    {
        return h;
    }
}
