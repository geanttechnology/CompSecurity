// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.util;

import java.util.ListIterator;

public final class i
    implements ListIterator
{

    private final ListIterator a;

    public i(ListIterator listiterator)
    {
        a = listiterator;
    }

    public final void add(Object obj)
    {
        a.add(obj);
    }

    public final boolean hasNext()
    {
        return a.hasPrevious();
    }

    public final boolean hasPrevious()
    {
        return a.hasNext();
    }

    public final Object next()
    {
        return a.previous();
    }

    public final int nextIndex()
    {
        return a.previousIndex();
    }

    public final Object previous()
    {
        return a.next();
    }

    public final int previousIndex()
    {
        return a.nextIndex();
    }

    public final void remove()
    {
        a.remove();
    }

    public final void set(Object obj)
    {
        a.set(obj);
    }
}
