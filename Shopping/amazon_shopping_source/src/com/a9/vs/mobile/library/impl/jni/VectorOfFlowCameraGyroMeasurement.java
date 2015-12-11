// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, CameraGyroMeasurement

public class VectorOfFlowCameraGyroMeasurement
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public VectorOfFlowCameraGyroMeasurement()
    {
        this(A9VSMobileJNI.new_VectorOfFlowCameraGyroMeasurement__SWIG_0(), true);
    }

    public VectorOfFlowCameraGyroMeasurement(long l)
    {
        this(A9VSMobileJNI.new_VectorOfFlowCameraGyroMeasurement__SWIG_1(l), true);
    }

    protected VectorOfFlowCameraGyroMeasurement(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(VectorOfFlowCameraGyroMeasurement vectorofflowcameragyromeasurement)
    {
        if (vectorofflowcameragyromeasurement == null)
        {
            return 0L;
        } else
        {
            return vectorofflowcameragyromeasurement.swigCPtr;
        }
    }

    public void add(CameraGyroMeasurement cameragyromeasurement)
    {
        A9VSMobileJNI.VectorOfFlowCameraGyroMeasurement_add(swigCPtr, this, CameraGyroMeasurement.getCPtr(cameragyromeasurement), cameragyromeasurement);
    }

    public long capacity()
    {
        return A9VSMobileJNI.VectorOfFlowCameraGyroMeasurement_capacity(swigCPtr, this);
    }

    public void clear()
    {
        A9VSMobileJNI.VectorOfFlowCameraGyroMeasurement_clear(swigCPtr, this);
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
                A9VSMobileJNI.delete_VectorOfFlowCameraGyroMeasurement(swigCPtr);
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

    public CameraGyroMeasurement get(int i)
    {
        return new CameraGyroMeasurement(A9VSMobileJNI.VectorOfFlowCameraGyroMeasurement_get(swigCPtr, this, i), false);
    }

    public boolean isEmpty()
    {
        return A9VSMobileJNI.VectorOfFlowCameraGyroMeasurement_isEmpty(swigCPtr, this);
    }

    public void reserve(long l)
    {
        A9VSMobileJNI.VectorOfFlowCameraGyroMeasurement_reserve(swigCPtr, this, l);
    }

    public void set(int i, CameraGyroMeasurement cameragyromeasurement)
    {
        A9VSMobileJNI.VectorOfFlowCameraGyroMeasurement_set(swigCPtr, this, i, CameraGyroMeasurement.getCPtr(cameragyromeasurement), cameragyromeasurement);
    }

    public long size()
    {
        return A9VSMobileJNI.VectorOfFlowCameraGyroMeasurement_size(swigCPtr, this);
    }
}
