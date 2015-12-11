// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.util.Utf8;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class Decoder
{

    public Decoder()
    {
    }

    public abstract long arrayNext()
        throws IOException;

    public abstract long mapNext()
        throws IOException;

    public abstract long readArrayStart()
        throws IOException;

    public abstract boolean readBoolean()
        throws IOException;

    public abstract ByteBuffer readBytes(ByteBuffer bytebuffer)
        throws IOException;

    public abstract double readDouble()
        throws IOException;

    public abstract int readEnum()
        throws IOException;

    public void readFixed(byte abyte0[])
        throws IOException
    {
        readFixed(abyte0, 0, abyte0.length);
    }

    public abstract void readFixed(byte abyte0[], int i, int j)
        throws IOException;

    public abstract float readFloat()
        throws IOException;

    public abstract int readIndex()
        throws IOException;

    public abstract int readInt()
        throws IOException;

    public abstract long readLong()
        throws IOException;

    public abstract long readMapStart()
        throws IOException;

    public abstract void readNull()
        throws IOException;

    public abstract Utf8 readString(Utf8 utf8)
        throws IOException;

    public abstract String readString()
        throws IOException;

    public abstract long skipArray()
        throws IOException;

    public abstract void skipBytes()
        throws IOException;

    public abstract void skipFixed(int i)
        throws IOException;

    public abstract long skipMap()
        throws IOException;

    public abstract void skipString()
        throws IOException;
}
