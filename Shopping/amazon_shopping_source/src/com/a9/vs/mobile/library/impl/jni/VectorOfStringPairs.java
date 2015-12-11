// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, StringPair

public class VectorOfStringPairs
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public VectorOfStringPairs()
    {
        this(A9VSMobileJNI.new_VectorOfStringPairs__SWIG_0(), true);
    }

    public VectorOfStringPairs(long l)
    {
        this(A9VSMobileJNI.new_VectorOfStringPairs__SWIG_1(l), true);
    }

    protected VectorOfStringPairs(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(VectorOfStringPairs vectorofstringpairs)
    {
        if (vectorofstringpairs == null)
        {
            return 0L;
        } else
        {
            return vectorofstringpairs.swigCPtr;
        }
    }

    public void add(StringPair stringpair)
    {
        A9VSMobileJNI.VectorOfStringPairs_add(swigCPtr, this, StringPair.getCPtr(stringpair), stringpair);
    }

    public long capacity()
    {
        return A9VSMobileJNI.VectorOfStringPairs_capacity(swigCPtr, this);
    }

    public void clear()
    {
        A9VSMobileJNI.VectorOfStringPairs_clear(swigCPtr, this);
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
                A9VSMobileJNI.delete_VectorOfStringPairs(swigCPtr);
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

    public StringPair get(int i)
    {
        return new StringPair(A9VSMobileJNI.VectorOfStringPairs_get(swigCPtr, this, i), false);
    }

    public boolean isEmpty()
    {
        return A9VSMobileJNI.VectorOfStringPairs_isEmpty(swigCPtr, this);
    }

    public void reserve(long l)
    {
        A9VSMobileJNI.VectorOfStringPairs_reserve(swigCPtr, this, l);
    }

    public void set(int i, StringPair stringpair)
    {
        A9VSMobileJNI.VectorOfStringPairs_set(swigCPtr, this, i, StringPair.getCPtr(stringpair), stringpair);
    }

    public long size()
    {
        return A9VSMobileJNI.VectorOfStringPairs_size(swigCPtr, this);
    }
}
