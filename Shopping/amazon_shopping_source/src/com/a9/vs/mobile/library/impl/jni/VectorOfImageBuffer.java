// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, ImageBuffer

public class VectorOfImageBuffer
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public VectorOfImageBuffer()
    {
        this(A9VSMobileJNI.new_VectorOfImageBuffer__SWIG_0(), true);
    }

    public VectorOfImageBuffer(long l)
    {
        this(A9VSMobileJNI.new_VectorOfImageBuffer__SWIG_1(l), true);
    }

    protected VectorOfImageBuffer(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(VectorOfImageBuffer vectorofimagebuffer)
    {
        if (vectorofimagebuffer == null)
        {
            return 0L;
        } else
        {
            return vectorofimagebuffer.swigCPtr;
        }
    }

    public void add(ImageBuffer imagebuffer)
    {
        A9VSMobileJNI.VectorOfImageBuffer_add(swigCPtr, this, ImageBuffer.getCPtr(imagebuffer), imagebuffer);
    }

    public long capacity()
    {
        return A9VSMobileJNI.VectorOfImageBuffer_capacity(swigCPtr, this);
    }

    public void clear()
    {
        A9VSMobileJNI.VectorOfImageBuffer_clear(swigCPtr, this);
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (swigCPtr != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                A9VSMobileJNI.delete_VectorOfImageBuffer(swigCPtr);
            }
            swigCPtr = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize()
    {
        delete();
    }

    public ImageBuffer get(int i)
    {
        return new ImageBuffer(A9VSMobileJNI.VectorOfImageBuffer_get(swigCPtr, this, i), false);
    }

    public boolean isEmpty()
    {
        return A9VSMobileJNI.VectorOfImageBuffer_isEmpty(swigCPtr, this);
    }

    public void reserve(long l)
    {
        A9VSMobileJNI.VectorOfImageBuffer_reserve(swigCPtr, this, l);
    }

    public void set(int i, ImageBuffer imagebuffer)
    {
        A9VSMobileJNI.VectorOfImageBuffer_set(swigCPtr, this, i, ImageBuffer.getCPtr(imagebuffer), imagebuffer);
    }

    public long size()
    {
        return A9VSMobileJNI.VectorOfImageBuffer_size(swigCPtr, this);
    }
}
