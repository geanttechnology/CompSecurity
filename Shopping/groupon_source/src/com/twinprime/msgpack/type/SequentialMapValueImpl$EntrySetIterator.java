// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.twinprime.msgpack.type:
//            SequentialMapValueImpl, Value

private static class pos
    implements Iterator
{

    private Value array[];
    private int pos;

    public boolean hasNext()
    {
        return pos < array.length;
    }

    public volatile Object next()
    {
        return next();
    }

    public java.util.EntrySetIterator next()
    {
        if (pos >= array.length)
        {
            throw new NoSuchElementException();
        } else
        {
            java.util.EntrySetIterator entrysetiterator = new java.util.EntrySetIterator.array(array[pos], array[pos + 1]);
            pos = pos + 2;
            return entrysetiterator;
        }
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    (Value avalue[])
    {
        array = avalue;
        pos = 0;
    }
}
