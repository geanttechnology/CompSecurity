// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

// Referenced classes of package com.googlecode.javacpp:
//            Pointer

public class DoublePointer extends Pointer
{

    public DoublePointer(int i)
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

    public DoublePointer(Pointer pointer)
    {
        super(pointer);
    }

    public DoublePointer(DoubleBuffer doublebuffer)
    {
        super(doublebuffer);
        if (doublebuffer != null && doublebuffer.hasArray())
        {
            double ad[] = doublebuffer.array();
            allocateArray(ad.length);
            put(ad);
            position(doublebuffer.position());
            limit(doublebuffer.limit());
        }
    }

    public transient DoublePointer(double ad[])
    {
        this(ad.length);
        put(ad);
    }

    private native void allocateArray(int i);

    public volatile Buffer asBuffer()
    {
        return asBuffer();
    }

    public final DoubleBuffer asBuffer()
    {
        return asByteBuffer().asDoubleBuffer();
    }

    public DoublePointer capacity(int i)
    {
        return (DoublePointer)super.capacity(i);
    }

    public volatile Pointer capacity(int i)
    {
        return capacity(i);
    }

    public double get()
    {
        return get(0);
    }

    public native double get(int i);

    public DoublePointer get(double ad[])
    {
        return get(ad, 0, ad.length);
    }

    public native DoublePointer get(double ad[], int i, int j);

    public DoublePointer limit(int i)
    {
        return (DoublePointer)super.limit(i);
    }

    public volatile Pointer limit(int i)
    {
        return limit(i);
    }

    public DoublePointer position(int i)
    {
        return (DoublePointer)super.position(i);
    }

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public DoublePointer put(double d)
    {
        return put(0, d);
    }

    public native DoublePointer put(int i, double d);

    public DoublePointer put(double ad[])
    {
        return put(ad, 0, ad.length);
    }

    public native DoublePointer put(double ad[], int i, int j);
}
