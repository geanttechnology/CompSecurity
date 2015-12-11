// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import java.util.EnumSet;

// Referenced classes of package com.mopub.common:
//            o, n

public static final class c
{

    public c a;
    public c b;
    public boolean c;
    private EnumSet d;

    public final transient c a(n n1, n an[])
    {
        d = EnumSet.of(n1, an);
        return this;
    }

    public final d a(EnumSet enumset)
    {
        d = EnumSet.copyOf(enumset);
        return this;
    }

    public final o a()
    {
        return new o(d, a, b, c, (byte)0);
    }

    public ()
    {
        d = EnumSet.of(n.j);
        a = o.a();
        b = o.b();
        c = false;
    }
}
