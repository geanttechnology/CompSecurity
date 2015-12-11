// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class VectorOfDouble
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public VectorOfDouble()
    {
        this(A9VSMobileJNI.new_VectorOfDouble__SWIG_0(), true);
    }

    public VectorOfDouble(long l)
    {
        this(A9VSMobileJNI.new_VectorOfDouble__SWIG_1(l), true);
    }

    protected VectorOfDouble(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(VectorOfDouble vectorofdouble)
    {
        if (vectorofdouble == null)
        {
            return 0L;
        } else
        {
            return vectorofdouble.swigCPtr;
        }
    }

    public void add(double d)
    {
        A9VSMobileJNI.VectorOfDouble_add(swigCPtr, this, d);
    }

    public long capacity()
    {
        return A9VSMobileJNI.VectorOfDouble_capacity(swigCPtr, this);
    }

    public void clear()
    {
        A9VSMobileJNI.VectorOfDouble_clear(swigCPtr, this);
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
                A9VSMobileJNI.delete_VectorOfDouble(swigCPtr);
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

    public double get(int i)
    {
        return A9VSMobileJNI.VectorOfDouble_get(swigCPtr, this, i);
    }

    public boolean isEmpty()
    {
        return A9VSMobileJNI.VectorOfDouble_isEmpty(swigCPtr, this);
    }

    public void reserve(long l)
    {
        A9VSMobileJNI.VectorOfDouble_reserve(swigCPtr, this, l);
    }

    public void set(int i, double d)
    {
        A9VSMobileJNI.VectorOfDouble_set(swigCPtr, this, i, d);
    }

    public long size()
    {
        return A9VSMobileJNI.VectorOfDouble_size(swigCPtr, this);
    }
}
