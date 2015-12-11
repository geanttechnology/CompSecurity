// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.api.a.g:
//            a

final class 
    implements Iterator
{

    final a a;
    private boolean b;
    private int c;

    public final boolean hasNext()
    {
        return c < a.a;
    }

    public final Object next()
    {
        int i = c;
        if (i == a.a)
        {
            throw new NoSuchElementException();
        } else
        {
            c = c + 1;
            return new <init>(a, i);
        }
    }

    public final void remove()
    {
        int i = c - 1;
        if (b || i < 0)
        {
            throw new IllegalArgumentException();
        } else
        {
            a.b(i << 1);
            b = true;
            return;
        }
    }

    ntException(a a1)
    {
        a = a1;
        super();
    }
}
