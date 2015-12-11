// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class Point2f
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public Point2f()
    {
        this(A9VSMobileJNI.new_Point2f__SWIG_0(), true);
    }

    public Point2f(float f, float f1)
    {
        this(A9VSMobileJNI.new_Point2f__SWIG_1(f, f1), true);
    }

    protected Point2f(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(Point2f point2f)
    {
        if (point2f == null)
        {
            return 0L;
        } else
        {
            return point2f.swigCPtr;
        }
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
                A9VSMobileJNI.delete_Point2f(swigCPtr);
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

    public float getX()
    {
        return A9VSMobileJNI.Point2f_x_get(swigCPtr, this);
    }

    public float getY()
    {
        return A9VSMobileJNI.Point2f_y_get(swigCPtr, this);
    }

    public void setX(float f)
    {
        A9VSMobileJNI.Point2f_x_set(swigCPtr, this, f);
    }

    public void setY(float f)
    {
        A9VSMobileJNI.Point2f_y_set(swigCPtr, this, f);
    }
}
