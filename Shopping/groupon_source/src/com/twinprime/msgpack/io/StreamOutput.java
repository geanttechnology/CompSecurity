// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.io;

import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;

public class StreamOutput
    implements Closeable, Flushable
{

    private DataOutputStream out;

    public StreamOutput(OutputStream outputstream)
    {
        out = new DataOutputStream(outputstream);
    }

    public void close()
        throws IOException
    {
        out.close();
    }

    public void flush()
        throws IOException
    {
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        out.write(abyte0, i, j);
    }

    public void writeByte(byte byte0)
        throws IOException
    {
        out.write(byte0);
    }

    public void writeDouble(double d)
        throws IOException
    {
        out.writeDouble(d);
    }

    public void writeFloat(float f)
        throws IOException
    {
        out.writeFloat(f);
    }

    public void writeInt(int i)
        throws IOException
    {
        out.writeInt(i);
    }

    public void writeLong(long l)
        throws IOException
    {
        out.writeLong(l);
    }

    public void writeShort(short word0)
        throws IOException
    {
        out.writeShort(word0);
    }
}
