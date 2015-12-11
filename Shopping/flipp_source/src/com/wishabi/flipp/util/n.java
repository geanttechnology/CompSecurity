// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.util;


// Referenced classes of package com.wishabi.flipp.util:
//            o, m

final class n extends o
{

    private final int f;

    private n(int i, int j)
    {
        super(i);
        f = j;
    }

    n(int i, int j, byte byte0)
    {
        this(i, j);
    }

    private n(int i, int j, String s)
    {
        super(i, s);
        f = j;
    }

    n(int i, int j, String s, byte byte0)
    {
        this(i, j, s);
    }

    public final int a()
    {
        return f;
    }

    public final m a(int i)
    {
        if (i < f)
        {
            return null;
        } else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public final void a(m m)
    {
        throw new IllegalStateException("Can't add items to a PlaceHolderSection");
    }

    public final int b()
    {
        return f;
    }

    public final m b(int i)
    {
        return a(i);
    }

    public final void b(m m)
    {
        throw new IllegalStateException("Can't add items to a PlaceHolderSection");
    }
}
