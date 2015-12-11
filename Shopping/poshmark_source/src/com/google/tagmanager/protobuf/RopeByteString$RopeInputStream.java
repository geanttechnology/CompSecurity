// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.google.tagmanager.protobuf:
//            RopeByteString, LiteralByteString

private class initialize extends InputStream
{

    private LiteralByteString currentPiece;
    private int currentPieceIndex;
    private int currentPieceOffsetInRope;
    private int currentPieceSize;
    private int mark;
    private readSkipInternal pieceIterator;
    final RopeByteString this$0;

    private void advanceIfCurrentPieceFullyRead()
    {
label0:
        {
            if (currentPiece != null && currentPieceIndex == currentPieceSize)
            {
                currentPieceOffsetInRope = currentPieceOffsetInRope + currentPieceSize;
                currentPieceIndex = 0;
                if (!pieceIterator.sNext())
                {
                    break label0;
                }
                currentPiece = pieceIterator.xt();
                currentPieceSize = currentPiece.size();
            }
            return;
        }
        currentPiece = null;
        currentPieceSize = 0;
    }

    private void initialize()
    {
        pieceIterator = new nit>(RopeByteString.this, null);
        currentPiece = pieceIterator.xt();
        currentPieceSize = currentPiece.size();
        currentPieceIndex = 0;
        currentPieceOffsetInRope = 0;
    }

    private int readSkipInternal(byte abyte0[], int i, int j)
    {
        int l = j;
        int k = i;
        for (i = l; i > 0;)
        {
            advanceIfCurrentPieceFullyRead();
            if (currentPiece == null)
            {
                if (i == j)
                {
                    return -1;
                }
                break;
            }
            int j1 = Math.min(currentPieceSize - currentPieceIndex, i);
            int i1 = k;
            if (abyte0 != null)
            {
                currentPiece.copyTo(abyte0, currentPieceIndex, k, j1);
                i1 = k + j1;
            }
            currentPieceIndex = currentPieceIndex + j1;
            i -= j1;
            k = i1;
        }

        return j - i;
    }

    public int available()
        throws IOException
    {
        int i = currentPieceOffsetInRope;
        int j = currentPieceIndex;
        return size() - (i + j);
    }

    public void mark(int i)
    {
        mark = currentPieceOffsetInRope + currentPieceIndex;
    }

    public boolean markSupported()
    {
        return true;
    }

    public int read()
        throws IOException
    {
        advanceIfCurrentPieceFullyRead();
        if (currentPiece == null)
        {
            return -1;
        } else
        {
            LiteralByteString literalbytestring = currentPiece;
            int i = currentPieceIndex;
            currentPieceIndex = i + 1;
            return literalbytestring.byteAt(i) & 0xff;
        }
    }

    public int read(byte abyte0[], int i, int j)
    {
        if (abyte0 == null)
        {
            throw new NullPointerException();
        }
        if (i < 0 || j < 0 || j > abyte0.length - i)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return readSkipInternal(abyte0, i, j);
        }
    }

    public void reset()
    {
        this;
        JVM INSTR monitorenter ;
        initialize();
        readSkipInternal(null, 0, mark);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public long skip(long l)
    {
        if (l < 0L)
        {
            throw new IndexOutOfBoundsException();
        }
        long l1 = l;
        if (l > 0x7fffffffL)
        {
            l1 = 0x7fffffffL;
        }
        return (long)readSkipInternal(null, 0, (int)l1);
    }

    public ()
    {
        this$0 = RopeByteString.this;
        super();
        initialize();
    }
}
