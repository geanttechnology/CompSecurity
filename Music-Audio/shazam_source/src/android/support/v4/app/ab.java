// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;

public final class ab extends ad.a
{
    static interface a
    {
    }

    static final class b
        implements a
    {

        b()
        {
        }
    }

    static final class c
        implements a
    {

        c()
        {
        }
    }

    static final class d
        implements a
    {

        d()
        {
        }
    }


    public static final ad.a.a a = new ad.a.a() {

    };
    private static final a g;
    private final String b;
    private final CharSequence c;
    private final CharSequence d[];
    private final boolean e;
    private final Bundle f;

    public final String a()
    {
        return b;
    }

    public final CharSequence b()
    {
        return c;
    }

    public final CharSequence[] c()
    {
        return d;
    }

    public final boolean d()
    {
        return e;
    }

    public final Bundle e()
    {
        return f;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 20)
        {
            g = new b();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            g = new d();
        } else
        {
            g = new c();
        }
    }
}
