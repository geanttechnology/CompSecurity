// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, CameraMemsMeasurement

public class VectorOfFlowCameraMemsMeasurement
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public VectorOfFlowCameraMemsMeasurement()
    {
        this(A9VSMobileJNI.new_VectorOfFlowCameraMemsMeasurement__SWIG_0(), true);
    }

    public VectorOfFlowCameraMemsMeasurement(long l)
    {
        this(A9VSMobileJNI.new_VectorOfFlowCameraMemsMeasurement__SWIG_1(l), true);
    }

    protected VectorOfFlowCameraMemsMeasurement(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(VectorOfFlowCameraMemsMeasurement vectorofflowcameramemsmeasurement)
    {
        if (vectorofflowcameramemsmeasurement == null)
        {
            return 0L;
        } else
        {
            return vectorofflowcameramemsmeasurement.swigCPtr;
        }
    }

    public void add(CameraMemsMeasurement cameramemsmeasurement)
    {
        A9VSMobileJNI.VectorOfFlowCameraMemsMeasurement_add(swigCPtr, this, CameraMemsMeasurement.getCPtr(cameramemsmeasurement), cameramemsmeasurement);
    }

    public long capacity()
    {
        return A9VSMobileJNI.VectorOfFlowCameraMemsMeasurement_capacity(swigCPtr, this);
    }

    public void clear()
    {
        A9VSMobileJNI.VectorOfFlowCameraMemsMeasurement_clear(swigCPtr, this);
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
                A9VSMobileJNI.delete_VectorOfFlowCameraMemsMeasurement(swigCPtr);
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

    public CameraMemsMeasurement get(int i)
    {
        return new CameraMemsMeasurement(A9VSMobileJNI.VectorOfFlowCameraMemsMeasurement_get(swigCPtr, this, i), false);
    }

    public boolean isEmpty()
    {
        return A9VSMobileJNI.VectorOfFlowCameraMemsMeasurement_isEmpty(swigCPtr, this);
    }

    public void reserve(long l)
    {
        A9VSMobileJNI.VectorOfFlowCameraMemsMeasurement_reserve(swigCPtr, this, l);
    }

    public void set(int i, CameraMemsMeasurement cameramemsmeasurement)
    {
        A9VSMobileJNI.VectorOfFlowCameraMemsMeasurement_set(swigCPtr, this, i, CameraMemsMeasurement.getCPtr(cameramemsmeasurement), cameramemsmeasurement);
    }

    public long size()
    {
        return A9VSMobileJNI.VectorOfFlowCameraMemsMeasurement_size(swigCPtr, this);
    }
}
