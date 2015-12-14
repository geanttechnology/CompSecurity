// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.millennialmedia.google.gson.internal:
//            LinkedHashTreeMap, i

abstract class h
    implements Iterator
{

    private i a;
    private i b;
    private int c;
    private LinkedHashTreeMap d;

    private h(LinkedHashTreeMap linkedhashtreemap)
    {
        d = linkedhashtreemap;
        super();
        a = d.header.d;
        b = null;
        c = d.modCount;
    }

    h(LinkedHashTreeMap linkedhashtreemap, byte byte0)
    {
        this(linkedhashtreemap);
    }

    final i a()
    {
        i j = a;
        if (j == d.header)
        {
            throw new NoSuchElementException();
        }
        if (d.modCount != c)
        {
            throw new ConcurrentModificationException();
        } else
        {
            a = j.d;
            b = j;
            return j;
        }
    }

    public final boolean hasNext()
    {
        return a != d.header;
    }

    public final void remove()
    {
        if (b == null)
        {
            throw new IllegalStateException();
        } else
        {
            d.removeInternal(b, true);
            b = null;
            c = d.modCount;
            return;
        }
    }
}
