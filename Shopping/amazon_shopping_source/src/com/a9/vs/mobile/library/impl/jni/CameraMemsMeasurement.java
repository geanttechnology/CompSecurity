// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, Point3d

public class CameraMemsMeasurement
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public CameraMemsMeasurement()
    {
        this(A9VSMobileJNI.new_CameraMemsMeasurement(), true);
    }

    protected CameraMemsMeasurement(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(CameraMemsMeasurement cameramemsmeasurement)
    {
        if (cameramemsmeasurement == null)
        {
            return 0L;
        } else
        {
            return cameramemsmeasurement.swigCPtr;
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
                A9VSMobileJNI.delete_CameraMemsMeasurement(swigCPtr);
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

    public Point3d getM_acceleration()
    {
        long l = A9VSMobileJNI.CameraMemsMeasurement_m_acceleration_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new Point3d(l, false);
        }
    }

    public Point3d getM_magnetometer()
    {
        long l = A9VSMobileJNI.CameraMemsMeasurement_m_magnetometer_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new Point3d(l, false);
        }
    }

    public Point3d getM_omega()
    {
        long l = A9VSMobileJNI.CameraMemsMeasurement_m_omega_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new Point3d(l, false);
        }
    }

    public double getM_timeSinceInit()
    {
        return A9VSMobileJNI.CameraMemsMeasurement_m_timeSinceInit_get(swigCPtr, this);
    }

    public void setM_acceleration(Point3d point3d)
    {
        A9VSMobileJNI.CameraMemsMeasurement_m_acceleration_set(swigCPtr, this, Point3d.getCPtr(point3d), point3d);
    }

    public void setM_magnetometer(Point3d point3d)
    {
        A9VSMobileJNI.CameraMemsMeasurement_m_magnetometer_set(swigCPtr, this, Point3d.getCPtr(point3d), point3d);
    }

    public void setM_omega(Point3d point3d)
    {
        A9VSMobileJNI.CameraMemsMeasurement_m_omega_set(swigCPtr, this, Point3d.getCPtr(point3d), point3d);
    }

    public void setM_timeSinceInit(double d)
    {
        A9VSMobileJNI.CameraMemsMeasurement_m_timeSinceInit_set(swigCPtr, this, d);
    }
}
