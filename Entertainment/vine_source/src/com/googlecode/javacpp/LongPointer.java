// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;

// Referenced classes of package com.googlecode.javacpp:
//            Pointer

public class LongPointer extends Pointer
{

    public LongPointer(int i)
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

    public LongPointer(Pointer pointer)
    {
        super(pointer);
    }

    public LongPointer(LongBuffer longbuffer)
    {
        super(longbuffer);
        if (longbuffer != null && longbuffer.hasArray())
        {
            long al[] = longbuffer.array();
            allocateArray(al.length);
            put(al);
            position(longbuffer.position());
            limit(longbuffer.limit());
        }
    }

    public transient LongPointer(long al[])
    {
        this(al.length);
        put(al);
    }

    private native void allocateArray(int i);

    public volatile Buffer asBuffer()
    {
        return asBuffer();
    }

    public final LongBuffer asBuffer()
    {
        return asByteBuffer().asLongBuffer();
    }

    public LongPointer capacity(int i)
    {
        return (LongPointer)super.capacity(i);
    }

    public volatile Pointer capacity(int i)
    {
        return capacity(i);
    }

    public long get()
    {
        return get(0);
    }

    public native long get(int i);

    public LongPointer get(long al[])
    {
        return get(al, 0, al.length);
    }

    public native LongPointer get(long al[], int i, int j);

    public LongPointer limit(int i)
    {
        return (LongPointer)super.limit(i);
    }

    public volatile Pointer limit(int i)
    {
        return limit(i);
    }

    public LongPointer position(int i)
    {
        return (LongPointer)super.position(i);
    }

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public native LongPointer put(int i, long l);

    public LongPointer put(long l)
    {
        return put(0, l);
    }

    public LongPointer put(long al[])
    {
        return put(al, 0, al.length);
    }

    public native LongPointer put(long al[], int i, int j);
}
