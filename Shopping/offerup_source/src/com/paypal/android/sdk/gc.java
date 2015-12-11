// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            gb, fx, gy

public final class gc
{

    private boolean a;
    private String b[];
    private String c[];
    private boolean d;

    public gc(gb gb1)
    {
        a = gb1.d;
        b = gb.a(gb1);
        c = gb.b(gb1);
        d = gb1.e;
    }

    gc(boolean flag)
    {
        a = flag;
    }

    static boolean a(gc gc1)
    {
        return gc1.a;
    }

    static String[] b(gc gc1)
    {
        return gc1.b;
    }

    static String[] c(gc gc1)
    {
        return gc1.c;
    }

    static boolean d(gc gc1)
    {
        return gc1.d;
    }

    public final gc a()
    {
        if (!a)
        {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        } else
        {
            d = true;
            return this;
        }
    }

    public final transient gc a(fx afx[])
    {
        if (!a)
        {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        String as[] = new String[afx.length];
        for (int i = 0; i < afx.length; i++)
        {
            as[i] = afx[i].o;
        }

        b = as;
        return this;
    }

    public final transient gc a(gy agy[])
    {
        if (!a)
        {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        if (agy.length == 0)
        {
            throw new IllegalArgumentException("At least one TlsVersion is required");
        }
        String as[] = new String[agy.length];
        for (int i = 0; i < agy.length; i++)
        {
            as[i] = agy[i].d;
        }

        c = as;
        return this;
    }

    public final transient gc a(String as[])
    {
        if (!a)
        {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        if (as == null)
        {
            b = null;
            return this;
        } else
        {
            b = (String[])as.clone();
            return this;
        }
    }

    public final gb b()
    {
        return new gb(this, (byte)0);
    }

    public final transient gc b(String as[])
    {
        if (!a)
        {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        if (as == null)
        {
            c = null;
            return this;
        } else
        {
            c = (String[])as.clone();
            return this;
        }
    }
}
