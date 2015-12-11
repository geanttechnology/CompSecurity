// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.ListIterator;

// Referenced classes of package com.google.a.c:
//            x, ad, z, bl

final class ax extends x
{

    private final z b;
    private final ad c;

    private ax(z z, ad ad1)
    {
        b = z;
        c = ad1;
    }

    ax(z z, Object aobj[])
    {
        this(z, ad.b(aobj, aobj.length));
    }

    final int a(Object aobj[], int i)
    {
        return c.a(aobj, i);
    }

    public final bl a(int i)
    {
        return c.a(i);
    }

    final z c()
    {
        return b;
    }

    public final Object get(int i)
    {
        return c.get(i);
    }

    public final ListIterator listIterator(int i)
    {
        return a(i);
    }
}
