// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.NoSuchElementException;

public class rk
    implements Iterator
{

    protected final rh a;
    protected int b;

    public rk(rh rh1)
    {
        a = (rh)ady.a(rh1);
        b = -1;
    }

    public boolean hasNext()
    {
        return b < a.c() - 1;
    }

    public Object next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException((new StringBuilder()).append("Cannot advance the iterator beyond ").append(b).toString());
        } else
        {
            rh rh1 = a;
            int i = b + 1;
            b = i;
            return rh1.a(i);
        }
    }

    public void remove()
    {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
