// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

// Referenced classes of package org.msgpack:
//            UnpackIterator, UnpackException, UnpackResult, BufferedUnpackerImpl

public class Unpacker
    implements Iterable
{
    final class BufferedUnpackerMixin extends BufferedUnpackerImpl
    {

        final Unpacker this$0;

        boolean fill()
            throws IOException
        {
            if (stream != null)
            {
                reserveBuffer(bufferReserveSize);
                int i = stream.read(buffer, filled, buffer.length - filled);
                if (i > 0)
                {
                    bufferConsumed(i);
                    return true;
                }
            }
            return false;
        }

        BufferedUnpackerMixin()
        {
            this$0 = Unpacker.this;
            super();
        }
    }


    protected int bufferReserveSize;
    final BufferedUnpackerMixin impl;
    protected int parsed;
    protected InputStream stream;

    public Unpacker()
    {
        this(32768);
    }

    public Unpacker(int i)
    {
        this(null, i);
    }

    public Unpacker(InputStream inputstream, int i)
    {
        impl = new BufferedUnpackerMixin();
        parsed = 0;
        bufferReserveSize = i / 2;
        stream = inputstream;
    }

    public void bufferConsumed(int i)
    {
        BufferedUnpackerMixin bufferedunpackermixin = impl;
        bufferedunpackermixin.filled = bufferedunpackermixin.filled + i;
    }

    public Iterator iterator()
    {
        return new UnpackIterator(this);
    }

    public boolean next(UnpackResult unpackresult)
        throws IOException, UnpackException
    {
        return impl.next(unpackresult);
    }

    public void reserveBuffer(int i)
    {
        if (impl.buffer == null)
        {
            if (bufferReserveSize >= i)
            {
                i = bufferReserveSize;
            }
            impl.buffer = new byte[i];
            impl.bufferReferenced = false;
        } else
        {
            if (!impl.bufferReferenced && impl.filled <= impl.offset)
            {
                impl.filled = 0;
                impl.offset = 0;
            }
            if (impl.buffer.length - impl.filled < i)
            {
                int j = impl.buffer.length * 2;
                int k;
                for (k = impl.filled - impl.offset; j < i + k; j *= 2) { }
                byte abyte0[] = new byte[j];
                System.arraycopy(impl.buffer, impl.offset, abyte0, 0, impl.filled - impl.offset);
                impl.buffer = abyte0;
                impl.filled = k;
                impl.offset = 0;
                impl.bufferReferenced = false;
                return;
            }
        }
    }
}
