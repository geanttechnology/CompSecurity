// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, Point3d

public class CameraAccelerometerMeasurement
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public CameraAccelerometerMeasurement()
    {
        this(A9VSMobileJNI.new_CameraAccelerometerMeasurement(), true);
    }

    protected CameraAccelerometerMeasurement(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(CameraAccelerometerMeasurement cameraaccelerometermeasurement)
    {
        if (cameraaccelerometermeasurement == null)
        {
            return 0L;
        } else
        {
            return cameraaccelerometermeasurement.swigCPtr;
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
                A9VSMobileJNI.delete_CameraAccelerometerMeasurement(swigCPtr);
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
        long l = A9VSMobileJNI.CameraAccelerometerMeasurement_m_acceleration_get(swigCPtr, this);
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
        return A9VSMobileJNI.CameraAccelerometerMeasurement_m_timeSinceInit_get(swigCPtr, this);
    }

    public void setM_acceleration(Point3d point3d)
    {
        A9VSMobileJNI.CameraAccelerometerMeasurement_m_acceleration_set(swigCPtr, this, Point3d.getCPtr(point3d), point3d);
    }

    public void setM_timeSinceInit(double d)
    {
        A9VSMobileJNI.CameraAccelerometerMeasurement_m_timeSinceInit_set(swigCPtr, this, d);
    }
}
