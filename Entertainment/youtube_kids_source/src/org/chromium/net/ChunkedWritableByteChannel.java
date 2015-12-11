// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;

public class ChunkedWritableByteChannel
    implements WritableByteChannel
{

    private final ArrayList a = new ArrayList();
    private ByteBuffer b;
    private int c;
    private boolean d;

    public ChunkedWritableByteChannel()
    {
    }

    public void close()
    {
        d = true;
    }

    public boolean isOpen()
    {
        return !d;
    }

    public int write(ByteBuffer bytebuffer)
    {
        if (d)
        {
            throw new ClosedChannelException();
        }
        int i = bytebuffer.remaining();
        c = c + i;
        if (b != null)
        {
            if (i <= b.remaining())
            {
                b.put(bytebuffer);
                return i;
            }
            b.flip();
            a.add(b);
            b = null;
        }
        ByteBuffer bytebuffer1 = ByteBuffer.allocateDirect(i);
        bytebuffer1.put(bytebuffer).rewind();
        a.add(bytebuffer1);
        return i;
    }
}
