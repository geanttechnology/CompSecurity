// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, VectorOfInt

public class VectorOfVectorOfInt
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public VectorOfVectorOfInt()
    {
        this(A9VSMobileJNI.new_VectorOfVectorOfInt__SWIG_0(), true);
    }

    public VectorOfVectorOfInt(long l)
    {
        this(A9VSMobileJNI.new_VectorOfVectorOfInt__SWIG_1(l), true);
    }

    protected VectorOfVectorOfInt(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(VectorOfVectorOfInt vectorofvectorofint)
    {
        if (vectorofvectorofint == null)
        {
            return 0L;
        } else
        {
            return vectorofvectorofint.swigCPtr;
        }
    }

    public void add(VectorOfInt vectorofint)
    {
        A9VSMobileJNI.VectorOfVectorOfInt_add(swigCPtr, this, VectorOfInt.getCPtr(vectorofint), vectorofint);
    }

    public long capacity()
    {
        return A9VSMobileJNI.VectorOfVectorOfInt_capacity(swigCPtr, this);
    }

    public void clear()
    {
        A9VSMobileJNI.VectorOfVectorOfInt_clear(swigCPtr, this);
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
                A9VSMobileJNI.delete_VectorOfVectorOfInt(swigCPtr);
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

    public VectorOfInt get(int i)
    {
        return new VectorOfInt(A9VSMobileJNI.VectorOfVectorOfInt_get(swigCPtr, this, i), false);
    }

    public boolean isEmpty()
    {
        return A9VSMobileJNI.VectorOfVectorOfInt_isEmpty(swigCPtr, this);
    }

    public void reserve(long l)
    {
        A9VSMobileJNI.VectorOfVectorOfInt_reserve(swigCPtr, this, l);
    }

    public void set(int i, VectorOfInt vectorofint)
    {
        A9VSMobileJNI.VectorOfVectorOfInt_set(swigCPtr, this, i, VectorOfInt.getCPtr(vectorofint), vectorofint);
    }

    public long size()
    {
        return A9VSMobileJNI.VectorOfVectorOfInt_size(swigCPtr, this);
    }
}
