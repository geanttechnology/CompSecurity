// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;
import java.util.Iterator;

abstract class bj
    implements Iterator
{

    final Iterator b;

    bj(Iterator iterator)
    {
        b = (Iterator)g.a(iterator);
    }

    abstract Object a(Object obj);

    public final boolean hasNext()
    {
        return b.hasNext();
    }

    public final Object next()
    {
        return a(b.next());
    }

    public final void remove()
    {
        b.remove();
    }
}
