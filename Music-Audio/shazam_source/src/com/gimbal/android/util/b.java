// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.android.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class b
    implements Iterator
{

    private List a;
    private ListIterator b;
    private Object c;

    public b(List list)
    {
        a = list;
        b = (new ArrayList(list)).listIterator();
        a();
    }

    private void a()
    {
label0:
        {
            WeakReference weakreference;
            for (; b.hasNext(); a.remove(weakreference))
            {
                weakreference = (WeakReference)b.next();
                c = weakreference.get();
                if (c != null)
                {
                    break label0;
                }
                b.remove();
            }

            c = null;
        }
    }

    public final boolean hasNext()
    {
        return c != null;
    }

    public final Object next()
    {
        Object obj = c;
        a();
        return obj;
    }

    public final void remove()
    {
        throw new UnsupportedOperationException();
    }
}
