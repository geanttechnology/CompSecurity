// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

// Referenced classes of package com.googlecode.javacpp:
//            Pointer

public class ShortPointer extends Pointer
{

    public ShortPointer(int i)
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

    public ShortPointer(Pointer pointer)
    {
        super(pointer);
    }

    public ShortPointer(ShortBuffer shortbuffer)
    {
        super(shortbuffer);
        if (shortbuffer != null && shortbuffer.hasArray())
        {
            short aword0[] = shortbuffer.array();
            allocateArray(aword0.length);
            put(aword0);
            position(shortbuffer.position());
            limit(shortbuffer.limit());
        }
    }

    public transient ShortPointer(short aword0[])
    {
        this(aword0.length);
        put(aword0);
    }

    private native void allocateArray(int i);

    public volatile Buffer asBuffer()
    {
        return asBuffer();
    }

    public final ShortBuffer asBuffer()
    {
        return asByteBuffer().asShortBuffer();
    }

    public volatile Pointer capacity(int i)
    {
        return capacity(i);
    }

    public ShortPointer capacity(int i)
    {
        return (ShortPointer)super.capacity(i);
    }

    public ShortPointer get(short aword0[])
    {
        return get(aword0, 0, aword0.length);
    }

    public native ShortPointer get(short aword0[], int i, int j);

    public short get()
    {
        return get(0);
    }

    public native short get(int i);

    public volatile Pointer limit(int i)
    {
        return limit(i);
    }

    public ShortPointer limit(int i)
    {
        return (ShortPointer)super.limit(i);
    }

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public ShortPointer position(int i)
    {
        return (ShortPointer)super.position(i);
    }

    public native ShortPointer put(int i, short word0);

    public ShortPointer put(short word0)
    {
        return put(0, word0);
    }

    public ShortPointer put(short aword0[])
    {
        return put(aword0, 0, aword0.length);
    }

    public native ShortPointer put(short aword0[], int i, int j);
}
