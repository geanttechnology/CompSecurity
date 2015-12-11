// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

// Referenced classes of package com.googlecode.javacpp:
//            Pointer

public class FloatPointer extends Pointer
{

    public FloatPointer(int i)
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

    public FloatPointer(Pointer pointer)
    {
        super(pointer);
    }

    public FloatPointer(FloatBuffer floatbuffer)
    {
        super(floatbuffer);
        if (floatbuffer != null && floatbuffer.hasArray())
        {
            float af[] = floatbuffer.array();
            allocateArray(af.length);
            put(af);
            position(floatbuffer.position());
            limit(floatbuffer.limit());
        }
    }

    public transient FloatPointer(float af[])
    {
        this(af.length);
        put(af);
    }

    private native void allocateArray(int i);

    public volatile Buffer asBuffer()
    {
        return asBuffer();
    }

    public final FloatBuffer asBuffer()
    {
        return asByteBuffer().asFloatBuffer();
    }

    public FloatPointer capacity(int i)
    {
        return (FloatPointer)super.capacity(i);
    }

    public volatile Pointer capacity(int i)
    {
        return capacity(i);
    }

    public float get()
    {
        return get(0);
    }

    public native float get(int i);

    public FloatPointer get(float af[])
    {
        return get(af, 0, af.length);
    }

    public native FloatPointer get(float af[], int i, int j);

    public FloatPointer limit(int i)
    {
        return (FloatPointer)super.limit(i);
    }

    public volatile Pointer limit(int i)
    {
        return limit(i);
    }

    public FloatPointer position(int i)
    {
        return (FloatPointer)super.position(i);
    }

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public FloatPointer put(float f)
    {
        return put(0, f);
    }

    public native FloatPointer put(int i, float f);

    public FloatPointer put(float af[])
    {
        return put(af, 0, af.length);
    }

    public native FloatPointer put(float af[], int i, int j);
}
