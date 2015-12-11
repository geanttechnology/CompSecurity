// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.unpacker;

import com.twinprime.msgpack.packer.Unconverter;
import com.twinprime.msgpack.type.Value;
import java.io.EOFException;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.twinprime.msgpack.unpacker:
//            AbstractUnpacker

public class UnpackerIterator
    implements Iterator
{

    private IOException exception;
    private final AbstractUnpacker u;
    private final Unconverter uc;

    public UnpackerIterator(AbstractUnpacker abstractunpacker)
    {
        u = abstractunpacker;
        uc = new Unconverter(abstractunpacker.msgpack);
    }

    public boolean hasNext()
    {
        if (uc.getResult() == null)
        {
            try
            {
                u.readValue(uc);
            }
            catch (EOFException eofexception)
            {
                return false;
            }
            catch (IOException ioexception)
            {
                exception = ioexception;
                return false;
            }
            if (uc.getResult() == null)
            {
                return false;
            }
        }
        return true;
    }

    public Value next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException();
        } else
        {
            Value value = uc.getResult();
            uc.resetResult();
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
}
