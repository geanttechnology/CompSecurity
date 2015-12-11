// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

// Referenced classes of package com.googlecode.javacpp:
//            Pointer

public class BytePointer extends Pointer
{

    public BytePointer(int i)
    {
        try
        {
            allocateArray(i);
            return;
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            throw new RuntimeException("No native JavaCPP library in memory. (Has Loader.load() been called?)", unsatisfiedlinkerror);
        }
    }

    public BytePointer(Pointer pointer)
    {
        super(pointer);
    }

    public BytePointer(String s)
    {
        this(s.getBytes().length + 1);
        putString(s);
    }

    public BytePointer(String s, String s1)
        throws UnsupportedEncodingException
    {
        this(s.getBytes(s1).length + 1);
        putString(s, s1);
    }

    public BytePointer(ByteBuffer bytebuffer)
    {
        super(bytebuffer);
        if (bytebuffer != null && bytebuffer.hasArray())
        {
            byte abyte0[] = bytebuffer.array();
            allocateArray(abyte0.length);
            put(abyte0);
            position(bytebuffer.position());
            limit(bytebuffer.limit());
        }
    }

    public transient BytePointer(byte abyte0[])
    {
        this(abyte0.length);
        put(abyte0);
    }

    private native void allocateArray(int i);

    public volatile Buffer asBuffer()
    {
        return asBuffer();
    }

    public final ByteBuffer asBuffer()
    {
        return asByteBuffer();
    }

    public BytePointer capacity(int i)
    {
        return (BytePointer)super.capacity(i);
    }

    public volatile Pointer capacity(int i)
    {
        return capacity(i);
    }

    public byte get()
    {
        return get(0);
    }

    public native byte get(int i);

    public BytePointer get(byte abyte0[])
    {
        return get(abyte0, 0, abyte0.length);
    }

    public native BytePointer get(byte abyte0[], int i, int j);

    public String getString()
    {
        return new String(getStringBytes());
    }

    public String getString(String s)
        throws UnsupportedEncodingException
    {
        return new String(getStringBytes(), s);
    }

    public byte[] getStringBytes()
    {
        byte abyte0[] = new byte[16];
        int j = 0;
        int i = position();
        do
        {
            byte byte0 = position(i).get();
            abyte0[j] = byte0;
            if (byte0 == 0)
            {
                break;
            }
            int k = j + 1;
            int l = i + 1;
            j = k;
            i = l;
            if (k >= abyte0.length)
            {
                byte abyte1[] = new byte[abyte0.length * 2];
                System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
                abyte0 = abyte1;
                j = k;
                i = l;
            }
        } while (true);
        byte abyte2[] = new byte[j];
        System.arraycopy(abyte0, 0, abyte2, 0, j);
        return abyte2;
    }

    public BytePointer limit(int i)
    {
        return (BytePointer)super.limit(i);
    }

    public volatile Pointer limit(int i)
    {
        return limit(i);
    }

    public BytePointer position(int i)
    {
        return (BytePointer)super.position(i);
    }

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public BytePointer put(byte byte0)
    {
        return put(0, byte0);
    }

    public native BytePointer put(int i, byte byte0);

    public BytePointer put(byte abyte0[])
    {
        return put(abyte0, 0, abyte0.length);
    }

    public native BytePointer put(byte abyte0[], int i, int j);

    public BytePointer putString(String s)
    {
        s = s.getBytes();
        return put(s).put(s.length, (byte)0);
    }

    public BytePointer putString(String s, String s1)
        throws UnsupportedEncodingException
    {
        s = s.getBytes(s1);
        put(s).put(s.length, (byte)0);
        return this;
    }
}
