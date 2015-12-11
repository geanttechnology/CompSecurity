// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class CameraResRequirement
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public CameraResRequirement()
    {
        this(A9VSMobileJNI.new_CameraResRequirement(), true);
    }

    protected CameraResRequirement(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(CameraResRequirement cameraresrequirement)
    {
        if (cameraresrequirement == null)
        {
            return 0L;
        } else
        {
            return cameraresrequirement.swigCPtr;
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
                A9VSMobileJNI.delete_CameraResRequirement(swigCPtr);
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

    public int getMaxHeight()
    {
        return A9VSMobileJNI.CameraResRequirement_maxHeight_get(swigCPtr, this);
    }

    public int getMinHeight()
    {
        return A9VSMobileJNI.CameraResRequirement_minHeight_get(swigCPtr, this);
    }

    public void setMaxHeight(int i)
    {
        A9VSMobileJNI.CameraResRequirement_maxHeight_set(swigCPtr, this, i);
    }

    public void setMinHeight(int i)
    {
        A9VSMobileJNI.CameraResRequirement_minHeight_set(swigCPtr, this, i);
    }
}
