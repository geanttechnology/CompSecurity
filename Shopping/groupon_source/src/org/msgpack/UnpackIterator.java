// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package org.msgpack:
//            UnpackResult, Unpacker, MessagePackObject

public class UnpackIterator extends UnpackResult
    implements Iterator
{

    private Unpacker pac;

    UnpackIterator(Unpacker unpacker)
    {
        pac = unpacker;
    }

    public boolean hasNext()
    {
        if (finished)
        {
            return true;
        }
        boolean flag;
        try
        {
            flag = pac.next(this);
        }
        catch (IOException ioexception)
        {
            return false;
        }
        return flag;
    }

    public volatile Object next()
    {
        return next();
    }

    public MessagePackObject next()
    {
        if (!finished && !hasNext())
        {
            throw new NoSuchElementException();
        } else
        {
            finished = false;
            return data;
        }
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}
