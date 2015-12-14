// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

// Referenced classes of package it.sephiroth.android.library.exif2:
//            Rational

class OrderedDataOutputStream extends FilterOutputStream
{

    private final ByteBuffer mByteBuffer = ByteBuffer.allocate(4);

    public OrderedDataOutputStream(OutputStream outputstream)
    {
        super(outputstream);
    }

    public OrderedDataOutputStream setByteOrder(ByteOrder byteorder)
    {
        mByteBuffer.order(byteorder);
        return this;
    }

    public OrderedDataOutputStream writeInt(int i)
        throws IOException
    {
        mByteBuffer.rewind();
        mByteBuffer.putInt(i);
        out.write(mByteBuffer.array());
        return this;
    }

    public OrderedDataOutputStream writeRational(Rational rational)
        throws IOException
    {
        writeInt((int)rational.getNumerator());
        writeInt((int)rational.getDenominator());
        return this;
    }

    public OrderedDataOutputStream writeShort(short word0)
        throws IOException
    {
        mByteBuffer.rewind();
        mByteBuffer.putShort(word0);
        out.write(mByteBuffer.array(), 0, 2);
        return this;
    }
}
