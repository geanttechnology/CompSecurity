// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

// Referenced classes of package com.google.tagmanager.protobuf:
//            ByteString, LiteralByteString

public static final class buffer extends OutputStream
{

    private static final byte EMPTY_BYTE_ARRAY[] = new byte[0];
    private byte buffer[];
    private int bufferPos;
    private final ArrayList flushedBuffers;
    private int flushedBuffersTotalBytes;
    private final int initialCapacity;

    private void flushFullBuffer(int i)
    {
        flushedBuffers.add(new LiteralByteString(buffer));
        flushedBuffersTotalBytes = flushedBuffersTotalBytes + buffer.length;
        buffer = new byte[Math.max(initialCapacity, Math.max(i, flushedBuffersTotalBytes >>> 1))];
        bufferPos = 0;
    }

    private void flushLastBuffer()
    {
        if (bufferPos < buffer.length)
        {
            if (bufferPos > 0)
            {
                byte abyte0[] = new byte[bufferPos];
                System.arraycopy(buffer, 0, abyte0, 0, bufferPos);
                flushedBuffers.add(new LiteralByteString(abyte0));
            }
        } else
        {
            flushedBuffers.add(new LiteralByteString(buffer));
            buffer = EMPTY_BYTE_ARRAY;
        }
        flushedBuffersTotalBytes = flushedBuffersTotalBytes + bufferPos;
        bufferPos = 0;
    }

    public void reset()
    {
        this;
        JVM INSTR monitorenter ;
        flushedBuffers.clear();
        flushedBuffersTotalBytes = 0;
        bufferPos = 0;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int size()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = flushedBuffersTotalBytes;
        j = bufferPos;
        this;
        JVM INSTR monitorexit ;
        return i + j;
        Exception exception;
        exception;
        throw exception;
    }

    public ByteString toByteString()
    {
        this;
        JVM INSTR monitorenter ;
        ByteString bytestring;
        flushLastBuffer();
        bytestring = ByteString.copyFrom(flushedBuffers);
        this;
        JVM INSTR monitorexit ;
        return bytestring;
        Exception exception;
        exception;
        throw exception;
    }

    public String toString()
    {
        return String.format("<ByteString.Output@%s size=%d>", new Object[] {
            Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())
        });
    }

    public void write(int i)
    {
        this;
        JVM INSTR monitorenter ;
        byte abyte0[];
        int j;
        if (bufferPos == buffer.length)
        {
            flushFullBuffer(1);
        }
        abyte0 = buffer;
        j = bufferPos;
        bufferPos = j + 1;
        abyte0[j] = (byte)i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void write(byte abyte0[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        if (j > buffer.length - bufferPos) goto _L2; else goto _L1
_L1:
        System.arraycopy(abyte0, i, buffer, bufferPos, j);
        bufferPos = bufferPos + j;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int k;
        k = buffer.length - bufferPos;
        System.arraycopy(abyte0, i, buffer, bufferPos, k);
        j -= k;
        flushFullBuffer(j);
        System.arraycopy(abyte0, i + k, buffer, 0, j);
        bufferPos = j;
        if (true) goto _L4; else goto _L3
_L3:
        abyte0;
        throw abyte0;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        byte abyte0[];
        ByteString abytestring[];
        int j;
        abytestring = (ByteString[])flushedBuffers.toArray(new ByteString[flushedBuffers.size()]);
        abyte0 = buffer;
        j = bufferPos;
        this;
        JVM INSTR monitorexit ;
        int k = abytestring.length;
        for (int i = 0; i < k; i++)
        {
            abytestring[i].writeTo(outputstream);
        }

        break MISSING_BLOCK_LABEL_72;
        outputstream;
        this;
        JVM INSTR monitorexit ;
        throw outputstream;
        byte abyte1[] = new byte[j];
        System.arraycopy(abyte0, 0, abyte1, 0, j);
        outputstream.write(abyte1);
        return;
    }


    (int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("Buffer size < 0");
        } else
        {
            initialCapacity = i;
            flushedBuffers = new ArrayList();
            buffer = new byte[i];
            return;
        }
    }
}
