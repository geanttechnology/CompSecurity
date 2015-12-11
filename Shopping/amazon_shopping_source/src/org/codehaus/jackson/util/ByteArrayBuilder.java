// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.util;

import java.io.OutputStream;
import java.util.LinkedList;

// Referenced classes of package org.codehaus.jackson.util:
//            BufferRecycler

public final class ByteArrayBuilder extends OutputStream
{

    private static final byte NO_BYTES[] = new byte[0];
    private final BufferRecycler _bufferRecycler;
    private byte _currBlock[];
    private int _currBlockPtr;
    private final LinkedList _pastBlocks;
    private int _pastLen;

    public ByteArrayBuilder()
    {
        this(null);
    }

    public ByteArrayBuilder(BufferRecycler bufferrecycler)
    {
        this(bufferrecycler, 500);
    }

    public ByteArrayBuilder(BufferRecycler bufferrecycler, int i)
    {
        _pastBlocks = new LinkedList();
        _bufferRecycler = bufferrecycler;
        if (bufferrecycler == null)
        {
            _currBlock = new byte[i];
            return;
        } else
        {
            _currBlock = bufferrecycler.allocByteBuffer(BufferRecycler.ByteBufferType.WRITE_CONCAT_BUFFER);
            return;
        }
    }

    private void _allocMore()
    {
        _pastLen = _pastLen + _currBlock.length;
        int j = Math.max(_pastLen >> 1, 1000);
        int i = j;
        if (j > 0x40000)
        {
            i = 0x40000;
        }
        _pastBlocks.add(_currBlock);
        _currBlock = new byte[i];
        _currBlockPtr = 0;
    }

    public void append(int i)
    {
        if (_currBlockPtr >= _currBlock.length)
        {
            _allocMore();
        }
        byte abyte0[] = _currBlock;
        int j = _currBlockPtr;
        _currBlockPtr = j + 1;
        abyte0[j] = (byte)i;
    }

    public void close()
    {
    }

    public void flush()
    {
    }

    public void write(int i)
    {
        append(i);
    }

    public void write(byte abyte0[])
    {
        write(abyte0, 0, abyte0.length);
    }

    public void write(byte abyte0[], int i, int j)
    {
        int k = i;
        do
        {
            int i1 = Math.min(_currBlock.length - _currBlockPtr, j);
            int l = k;
            i = j;
            if (i1 > 0)
            {
                System.arraycopy(abyte0, k, _currBlock, _currBlockPtr, i1);
                l = k + i1;
                _currBlockPtr = _currBlockPtr + i1;
                i = j - i1;
            }
            if (i <= 0)
            {
                return;
            }
            _allocMore();
            k = l;
            j = i;
        } while (true);
    }

}
