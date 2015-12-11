// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class VectorOfInt
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public VectorOfInt()
    {
        this(A9VSMobileJNI.new_VectorOfInt__SWIG_0(), true);
    }

    public VectorOfInt(long l)
    {
        this(A9VSMobileJNI.new_VectorOfInt__SWIG_1(l), true);
    }

    protected VectorOfInt(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(VectorOfInt vectorofint)
    {
        if (vectorofint == null)
        {
            return 0L;
        } else
        {
            return vectorofint.swigCPtr;
        }
    }

    public void add(int i)
    {
        A9VSMobileJNI.VectorOfInt_add(swigCPtr, this, i);
    }

    public long capacity()
    {
        return A9VSMobileJNI.VectorOfInt_capacity(swigCPtr, this);
    }

    public void clear()
    {
        A9VSMobileJNI.VectorOfInt_clear(swigCPtr, this);
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
                A9VSMobileJNI.delete_VectorOfInt(swigCPtr);
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

    public int get(int i)
    {
        return A9VSMobileJNI.VectorOfInt_get(swigCPtr, this, i);
    }

    public boolean isEmpty()
    {
        return A9VSMobileJNI.VectorOfInt_isEmpty(swigCPtr, this);
    }

    public void reserve(long l)
    {
        A9VSMobileJNI.VectorOfInt_reserve(swigCPtr, this, l);
    }

    public void set(int i, int j)
    {
        A9VSMobileJNI.VectorOfInt_set(swigCPtr, this, i, j);
    }

    public long size()
    {
        return A9VSMobileJNI.VectorOfInt_size(swigCPtr, this);
    }
}
