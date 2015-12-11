// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.a.a;

import com.shazam.android.ay.b.d;
import com.shazam.model.Provider;
import com.shazam.model.location.SimpleLocation;
import com.shazam.n.n;

public final class a
    implements d
{

    public com.shazam.model.TagContext.Builder b;
    public boolean c;
    private final String d;
    private final com.shazam.android.au.b.d e;
    private final n f;
    private final Provider g;

    public a(String s, n n1, com.shazam.android.au.b.d d1, Provider provider)
    {
        c = false;
        d = s;
        e = d1;
        g = provider;
        f = n1;
        b = com.shazam.model.TagContext.Builder.a();
    }

    public static com.shazam.model.TagContext.Builder a(com.shazam.model.TagContext.Builder builder)
    {
        return com.shazam.model.TagContext.Builder.a(builder);
    }

    public final long a()
    {
        return f.a();
    }

    public final void a(int i, int j)
    {
        e.a(i, j);
    }

    public final byte[] b()
    {
        return e.b();
    }

    public final long c()
    {
        return e.c();
    }

    public final String d()
    {
        return d;
    }

    public final SimpleLocation e()
    {
        return (SimpleLocation)g.a();
    }

    public final com.shazam.model.TagContext.Builder f()
    {
        if (c)
        {
            return com.shazam.model.TagContext.Builder.a(b);
        } else
        {
            return b;
        }
    }
}
