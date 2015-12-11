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

    public Value next()
    {
        if (pos >= array.length)
        {
            throw new NoSuchElementException();
        } else
        {
            Value value = array[pos];
            pos = pos + 2;
            return value;
        }
    }

    public volatile Object next()
    {
        return next();
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    (Value avalue[], int i)
    {
        array = avalue;
        pos = i;
    }
}
