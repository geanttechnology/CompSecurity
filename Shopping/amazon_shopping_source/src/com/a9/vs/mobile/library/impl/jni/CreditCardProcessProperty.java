// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, CameraMode, Orientation, ScanMode

public class CreditCardProcessProperty
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public CreditCardProcessProperty()
    {
        this(A9VSMobileJNI.new_CreditCardProcessProperty(), true);
    }

    protected CreditCardProcessProperty(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(CreditCardProcessProperty creditcardprocessproperty)
    {
        if (creditcardprocessproperty == null)
        {
            return 0L;
        } else
        {
            return creditcardprocessproperty.swigCPtr;
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
                A9VSMobileJNI.delete_CreditCardProcessProperty(swigCPtr);
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

    public boolean getAutoFlip()
    {
        return A9VSMobileJNI.CreditCardProcessProperty_autoFlip_get(swigCPtr, this);
    }

    public CameraMode getCameraMode()
    {
        return CameraMode.swigToEnum(A9VSMobileJNI.CreditCardProcessProperty_cameraMode_get(swigCPtr, this));
    }

    public boolean getMultiThread()
    {
        return A9VSMobileJNI.CreditCardProcessProperty_multiThread_get(swigCPtr, this);
    }

    public Orientation getOrient()
    {
        return Orientation.swigToEnum(A9VSMobileJNI.CreditCardProcessProperty_orient_get(swigCPtr, this));
    }

    public boolean getReadDate()
    {
        return A9VSMobileJNI.CreditCardProcessProperty_readDate_get(swigCPtr, this);
    }

    public ScanMode getScanMode()
    {
        return ScanMode.swigToEnum(A9VSMobileJNI.CreditCardProcessProperty_scanMode_get(swigCPtr, this));
    }

    public void setAutoFlip(boolean flag)
    {
        A9VSMobileJNI.CreditCardProcessProperty_autoFlip_set(swigCPtr, this, flag);
    }

    public void setCameraMode(CameraMode cameramode)
    {
        A9VSMobileJNI.CreditCardProcessProperty_cameraMode_set(swigCPtr, this, cameramode.swigValue());
    }

    public void setMultiThread(boolean flag)
    {
        A9VSMobileJNI.CreditCardProcessProperty_multiThread_set(swigCPtr, this, flag);
    }

    public void setOrient(Orientation orientation)
    {
        A9VSMobileJNI.CreditCardProcessProperty_orient_set(swigCPtr, this, orientation.swigValue());
    }

    public void setReadDate(boolean flag)
    {
        A9VSMobileJNI.CreditCardProcessProperty_readDate_set(swigCPtr, this, flag);
    }

    public void setScanMode(ScanMode scanmode)
    {
        A9VSMobileJNI.CreditCardProcessProperty_scanMode_set(swigCPtr, this, scanmode.swigValue());
    }
}
