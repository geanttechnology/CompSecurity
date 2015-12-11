// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public final class clz
    implements WritableByteChannel
{

    final BlockingQueue a = new ArrayBlockingQueue(16);
    final BlockingQueue b = new ArrayBlockingQueue(16);
    private ByteBuffer c;
    private boolean d;
    private cly e;

    protected clz(cly cly1)
    {
        e = cly1;
        super();
        d = true;
    }

    public final int a(byte abyte0[], int i, int j)
    {
        int k = a.size();
        int l = b.size();
        bmo.e((new StringBuilder(80)).append("Reading ").append(j).append(" bytes, queue size ").append(k).append(", return queue size ").append(l).toString());
        l = 0;
        k = i;
        for (i = l; j > 0; i = l + i)
        {
            if (c == null)
            {
                if (i == 0)
                {
                    try
                    {
                        c = (ByteBuffer)a.poll(cly.a(e), TimeUnit.MILLISECONDS);
                        if (c == null)
                        {
                            throw new SocketTimeoutException("Cronet read timeout.");
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (byte abyte0[])
                    {
                        throw new IOException("Interrupted.", abyte0);
                    }
                } else
                {
                    c = (ByteBuffer)a.poll();
                    if (c == null)
                    {
                        break;
                    }
                }
            }
            l = Math.min(c.remaining(), j);
            c.get(abyte0, k, l);
            k += l;
            j -= l;
            if (!c.hasRemaining())
            {
                c.clear();
                b.offer(c);
                c = null;
            }
        }

        return i;
    }

    public final void close()
    {
        d = false;
    }

    public final boolean isOpen()
    {
        return d;
    }

    public final int write(ByteBuffer bytebuffer)
    {
        ByteBuffer bytebuffer1;
        int i;
label0:
        {
            if (!isOpen())
            {
                throw new ClosedChannelException();
            }
            i = bytebuffer.remaining();
            ByteBuffer bytebuffer2 = (ByteBuffer)b.poll();
            if (bytebuffer2 != null)
            {
                bytebuffer1 = bytebuffer2;
                if (bytebuffer2.capacity() >= bytebuffer.remaining())
                {
                    break label0;
                }
            }
            int j = bytebuffer.limit();
            bmo.e((new StringBuilder(37)).append("Allocating a buffer, size=").append(j).toString());
            bytebuffer1 = ByteBuffer.allocate(bytebuffer.limit());
        }
        bytebuffer1.put(bytebuffer);
        bytebuffer1.flip();
        try
        {
            a.put(bytebuffer1);
        }
        // Misplaced declaration of an exception variable
        catch (ByteBuffer bytebuffer)
        {
            throw new IOException("Failed to write.", bytebuffer);
        }
        if (!isOpen())
        {
            throw new ClosedChannelException();
        } else
        {
            return i;
        }
    }
}
