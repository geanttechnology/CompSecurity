// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, VectorOfFlowCameraAccelerometerMeasurement, VectorOfFlowCameraGyroMeasurement, VectorOfFlowCameraMemsMeasurement

public class SensorData
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public SensorData()
    {
        this(A9VSMobileJNI.new_SensorData(), true);
    }

    protected SensorData(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(SensorData sensordata)
    {
        if (sensordata == null)
        {
            return 0L;
        } else
        {
            return sensordata.swigCPtr;
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
                A9VSMobileJNI.delete_SensorData(swigCPtr);
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

    public VectorOfFlowCameraAccelerometerMeasurement getRawAccData()
    {
        long l = A9VSMobileJNI.SensorData_rawAccData_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfFlowCameraAccelerometerMeasurement(l, false);
        }
    }

    public VectorOfFlowCameraGyroMeasurement getRawGyroData()
    {
        long l = A9VSMobileJNI.SensorData_rawGyroData_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfFlowCameraGyroMeasurement(l, false);
        }
    }

    public VectorOfFlowCameraMemsMeasurement getRawSensorData()
    {
        long l = A9VSMobileJNI.SensorData_rawSensorData_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfFlowCameraMemsMeasurement(l, false);
        }
    }

    public void setRawAccData(VectorOfFlowCameraAccelerometerMeasurement vectorofflowcameraaccelerometermeasurement)
    {
        A9VSMobileJNI.SensorData_rawAccData_set(swigCPtr, this, VectorOfFlowCameraAccelerometerMeasurement.getCPtr(vectorofflowcameraaccelerometermeasurement), vectorofflowcameraaccelerometermeasurement);
    }

    public void setRawGyroData(VectorOfFlowCameraGyroMeasurement vectorofflowcameragyromeasurement)
    {
        A9VSMobileJNI.SensorData_rawGyroData_set(swigCPtr, this, VectorOfFlowCameraGyroMeasurement.getCPtr(vectorofflowcameragyromeasurement), vectorofflowcameragyromeasurement);
    }

    public void setRawSensorData(VectorOfFlowCameraMemsMeasurement vectorofflowcameramemsmeasurement)
    {
        A9VSMobileJNI.SensorData_rawSensorData_set(swigCPtr, this, VectorOfFlowCameraMemsMeasurement.getCPtr(vectorofflowcameramemsmeasurement), vectorofflowcameramemsmeasurement);
    }
}
