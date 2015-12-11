// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class ExtraFrameData
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public ExtraFrameData()
    {
        this(A9VSMobileJNI.new_ExtraFrameData__SWIG_0(), true);
    }

    public ExtraFrameData(int i, int j, int k, int l, boolean flag, int i1, double d)
    {
        this(A9VSMobileJNI.new_ExtraFrameData__SWIG_1(i, j, k, l, flag, i1, d), true);
    }

    protected ExtraFrameData(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(ExtraFrameData extraframedata)
    {
        if (extraframedata == null)
        {
            return 0L;
        } else
        {
            return extraframedata.swigCPtr;
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
                A9VSMobileJNI.delete_ExtraFrameData(swigCPtr);
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

    public boolean getFlat()
    {
        return A9VSMobileJNI.ExtraFrameData_flat_get(swigCPtr, this);
    }

    public int getHeightDisp()
    {
        return A9VSMobileJNI.ExtraFrameData_heightDisp_get(swigCPtr, this);
    }

    public int getScreenOrient()
    {
        return A9VSMobileJNI.ExtraFrameData_screenOrient_get(swigCPtr, this);
    }

    public double getTimeSinceInit()
    {
        return A9VSMobileJNI.ExtraFrameData_timeSinceInit_get(swigCPtr, this);
    }

    public int getWidthDisp()
    {
        return A9VSMobileJNI.ExtraFrameData_widthDisp_get(swigCPtr, this);
    }

    public int getXDisp()
    {
        return A9VSMobileJNI.ExtraFrameData_xDisp_get(swigCPtr, this);
    }

    public int getYDisp()
    {
        return A9VSMobileJNI.ExtraFrameData_yDisp_get(swigCPtr, this);
    }

    public void setFlat(boolean flag)
    {
        A9VSMobileJNI.ExtraFrameData_flat_set(swigCPtr, this, flag);
    }

    public void setHeightDisp(int i)
    {
        A9VSMobileJNI.ExtraFrameData_heightDisp_set(swigCPtr, this, i);
    }

    public void setScreenOrient(int i)
    {
        A9VSMobileJNI.ExtraFrameData_screenOrient_set(swigCPtr, this, i);
    }

    public void setTimeSinceInit(double d)
    {
        A9VSMobileJNI.ExtraFrameData_timeSinceInit_set(swigCPtr, this, d);
    }

    public void setWidthDisp(int i)
    {
        A9VSMobileJNI.ExtraFrameData_widthDisp_set(swigCPtr, this, i);
    }

    public void setXDisp(int i)
    {
        A9VSMobileJNI.ExtraFrameData_xDisp_set(swigCPtr, this, i);
    }

    public void setYDisp(int i)
    {
        A9VSMobileJNI.ExtraFrameData_yDisp_set(swigCPtr, this, i);
    }
}
