// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, Point2f

public class VectorOfPoint2f
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public VectorOfPoint2f()
    {
        this(A9VSMobileJNI.new_VectorOfPoint2f__SWIG_0(), true);
    }

    public VectorOfPoint2f(long l)
    {
        this(A9VSMobileJNI.new_VectorOfPoint2f__SWIG_1(l), true);
    }

    protected VectorOfPoint2f(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(VectorOfPoint2f vectorofpoint2f)
    {
        if (vectorofpoint2f == null)
        {
            return 0L;
        } else
        {
            return vectorofpoint2f.swigCPtr;
        }
    }

    public void add(Point2f point2f)
    {
        A9VSMobileJNI.VectorOfPoint2f_add(swigCPtr, this, Point2f.getCPtr(point2f), point2f);
    }

    public long capacity()
    {
        return A9VSMobileJNI.VectorOfPoint2f_capacity(swigCPtr, this);
    }

    public void clear()
    {
        A9VSMobileJNI.VectorOfPoint2f_clear(swigCPtr, this);
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
                A9VSMobileJNI.delete_VectorOfPoint2f(swigCPtr);
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

    public Point2f get(int i)
    {
        return new Point2f(A9VSMobileJNI.VectorOfPoint2f_get(swigCPtr, this, i), false);
    }

    public boolean isEmpty()
    {
        return A9VSMobileJNI.VectorOfPoint2f_isEmpty(swigCPtr, this);
    }

    public void reserve(long l)
    {
        A9VSMobileJNI.VectorOfPoint2f_reserve(swigCPtr, this, l);
    }

    public void set(int i, Point2f point2f)
    {
        A9VSMobileJNI.VectorOfPoint2f_set(swigCPtr, this, i, Point2f.getCPtr(point2f), point2f);
    }

    public long size()
    {
        return A9VSMobileJNI.VectorOfPoint2f_size(swigCPtr, this);
    }
}
