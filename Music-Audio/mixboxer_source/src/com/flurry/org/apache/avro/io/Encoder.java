// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.util.Utf8;
import java.io.Flushable;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class Encoder
    implements Flushable
{

    public Encoder()
    {
    }

    public abstract void setItemCount(long l)
        throws IOException;

    public abstract void startItem()
        throws IOException;

    public abstract void writeArrayEnd()
        throws IOException;

    public abstract void writeArrayStart()
        throws IOException;

    public abstract void writeBoolean(boolean flag)
        throws IOException;

    public abstract void writeBytes(ByteBuffer bytebuffer)
        throws IOException;

    public void writeBytes(byte abyte0[])
        throws IOException
    {
        writeBytes(abyte0, 0, abyte0.length);
    }

    public abstract void writeBytes(byte abyte0[], int i, int j)
        throws IOException;

    public abstract void writeDouble(double d)
        throws IOException;

    public abstract void writeEnum(int i)
        throws IOException;

    public void writeFixed(byte abyte0[])
        throws IOException
    {
        writeFixed(abyte0, 0, abyte0.length);
    }

    public abstract void writeFixed(byte abyte0[], int i, int j)
        throws IOException;

    public abstract void writeFloat(float f)
        throws IOException;

    public abstract void writeIndex(int i)
        throws IOException;

    public abstract void writeInt(int i)
        throws IOException;

    public abstract void writeLong(long l)
        throws IOException;

    public abstract void writeMapEnd()
        throws IOException;

    public abstract void writeMapStart()
        throws IOException;

    public abstract void writeNull()
        throws IOException;

    public abstract void writeString(Utf8 utf8)
        throws IOException;

    public void writeString(CharSequence charsequence)
        throws IOException
    {
        if (charsequence instanceof Utf8)
        {
            writeString((Utf8)charsequence);
            return;
        } else
        {
            writeString(charsequence.toString());
            return;
        }
    }

    public void writeString(String s)
        throws IOException
    {
        writeString(new Utf8(s));
    }
}
