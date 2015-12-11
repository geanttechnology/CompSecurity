// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class bmt
    implements Iterator
{

    private final Iterator a;
    private Object b;

    public bmt(Iterator iterator)
    {
        a = (Iterator)b.a(iterator);
        b();
    }

    private void b()
    {
        Object obj;
        if (a.hasNext())
        {
            obj = a.next();
        } else
        {
            obj = null;
        }
        b = obj;
    }

    public final Object a()
    {
        if (b == null)
        {
            throw new NoSuchElementException();
        } else
        {
            return b;
        }
    }

    public final boolean hasNext()
    {
        return b != null;
    }

    public final Object next()
    {
        if (b == null)
        {
            throw new NoSuchElementException();
        } else
        {
            Object obj = b;
            b();
            return obj;
        }
    }

    public final void remove()
    {
        throw new UnsupportedOperationException();
    }
}
