// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class Point3d
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public Point3d()
    {
        this(A9VSMobileJNI.new_Point3d__SWIG_0(), true);
    }

    public Point3d(double d, double d1, double d2)
    {
        this(A9VSMobileJNI.new_Point3d__SWIG_1(d, d1, d2), true);
    }

    protected Point3d(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(Point3d point3d)
    {
        if (point3d == null)
        {
            return 0L;
        } else
        {
            return point3d.swigCPtr;
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
                A9VSMobileJNI.delete_Point3d(swigCPtr);
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

    public double getX()
    {
        return A9VSMobileJNI.Point3d_x_get(swigCPtr, this);
    }

    public double getY()
    {
        return A9VSMobileJNI.Point3d_y_get(swigCPtr, this);
    }

    public double getZ()
    {
        return A9VSMobileJNI.Point3d_z_get(swigCPtr, this);
    }

    public void setX(double d)
    {
        A9VSMobileJNI.Point3d_x_set(swigCPtr, this, d);
    }

    public void setY(double d)
    {
        A9VSMobileJNI.Point3d_y_set(swigCPtr, this, d);
    }

    public void setZ(double d)
    {
        A9VSMobileJNI.Point3d_z_set(swigCPtr, this, d);
    }
}
