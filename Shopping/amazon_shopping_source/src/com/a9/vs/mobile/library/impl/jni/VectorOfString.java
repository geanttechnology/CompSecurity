// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class VectorOfString
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public VectorOfString()
    {
        this(A9VSMobileJNI.new_VectorOfString__SWIG_0(), true);
    }

    public VectorOfString(long l)
    {
        this(A9VSMobileJNI.new_VectorOfString__SWIG_1(l), true);
    }

    protected VectorOfString(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(VectorOfString vectorofstring)
    {
        if (vectorofstring == null)
        {
            return 0L;
        } else
        {
            return vectorofstring.swigCPtr;
        }
    }

    public void add(String s)
    {
        A9VSMobileJNI.VectorOfString_add(swigCPtr, this, s);
    }

    public long capacity()
    {
        return A9VSMobileJNI.VectorOfString_capacity(swigCPtr, this);
    }

    public void clear()
    {
        A9VSMobileJNI.VectorOfString_clear(swigCPtr, this);
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
                A9VSMobileJNI.delete_VectorOfString(swigCPtr);
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

    public String get(int i)
    {
        return A9VSMobileJNI.VectorOfString_get(swigCPtr, this, i);
    }

    public boolean isEmpty()
    {
        return A9VSMobileJNI.VectorOfString_isEmpty(swigCPtr, this);
    }

    public void reserve(long l)
    {
        A9VSMobileJNI.VectorOfString_reserve(swigCPtr, this, l);
    }

    public void set(int i, String s)
    {
        A9VSMobileJNI.VectorOfString_set(swigCPtr, this, i, s);
    }

    public long size()
    {
        return A9VSMobileJNI.VectorOfString_size(swigCPtr, this);
    }
}
