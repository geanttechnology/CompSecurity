// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, CameraAccelerometerMeasurement

public class VectorOfFlowCameraAccelerometerMeasurement
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public VectorOfFlowCameraAccelerometerMeasurement()
    {
        this(A9VSMobileJNI.new_VectorOfFlowCameraAccelerometerMeasurement__SWIG_0(), true);
    }

    public VectorOfFlowCameraAccelerometerMeasurement(long l)
    {
        this(A9VSMobileJNI.new_VectorOfFlowCameraAccelerometerMeasurement__SWIG_1(l), true);
    }

    protected VectorOfFlowCameraAccelerometerMeasurement(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(VectorOfFlowCameraAccelerometerMeasurement vectorofflowcameraaccelerometermeasurement)
    {
        if (vectorofflowcameraaccelerometermeasurement == null)
        {
            return 0L;
        } else
        {
            return vectorofflowcameraaccelerometermeasurement.swigCPtr;
        }
    }

    public void add(CameraAccelerometerMeasurement cameraaccelerometermeasurement)
    {
        A9VSMobileJNI.VectorOfFlowCameraAccelerometerMeasurement_add(swigCPtr, this, CameraAccelerometerMeasurement.getCPtr(cameraaccelerometermeasurement), cameraaccelerometermeasurement);
    }

    public long capacity()
    {
        return A9VSMobileJNI.VectorOfFlowCameraAccelerometerMeasurement_capacity(swigCPtr, this);
    }

    public void clear()
    {
        A9VSMobileJNI.VectorOfFlowCameraAccelerometerMeasurement_clear(swigCPtr, this);
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
                A9VSMobileJNI.delete_VectorOfFlowCameraAccelerometerMeasurement(swigCPtr);
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

    public CameraAccelerometerMeasurement get(int i)
    {
        return new CameraAccelerometerMeasurement(A9VSMobileJNI.VectorOfFlowCameraAccelerometerMeasurement_get(swigCPtr, this, i), false);
    }

    public boolean isEmpty()
    {
        return A9VSMobileJNI.VectorOfFlowCameraAccelerometerMeasurement_isEmpty(swigCPtr, this);
    }

    public void reserve(long l)
    {
        A9VSMobileJNI.VectorOfFlowCameraAccelerometerMeasurement_reserve(swigCPtr, this, l);
    }

    public void set(int i, CameraAccelerometerMeasurement cameraaccelerometermeasurement)
    {
        A9VSMobileJNI.VectorOfFlowCameraAccelerometerMeasurement_set(swigCPtr, this, i, CameraAccelerometerMeasurement.getCPtr(cameraaccelerometermeasurement), cameraaccelerometermeasurement);
    }

    public long size()
    {
        return A9VSMobileJNI.VectorOfFlowCameraAccelerometerMeasurement_size(swigCPtr, this);
    }
}
