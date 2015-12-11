// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class NEONAccelerationResult
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public NEONAccelerationResult()
    {
        this(A9VSMobileJNI.new_NEONAccelerationResult(), true);
    }

    protected NEONAccelerationResult(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(NEONAccelerationResult neonaccelerationresult)
    {
        if (neonaccelerationresult == null)
        {
            return 0L;
        } else
        {
            return neonaccelerationresult.swigCPtr;
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
                A9VSMobileJNI.delete_NEONAccelerationResult(swigCPtr);
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

    public String getResultStr()
    {
        return A9VSMobileJNI.NEONAccelerationResult_resultStr_get(swigCPtr, this);
    }

    public void setResultStr(String s)
    {
        A9VSMobileJNI.NEONAccelerationResult_resultStr_set(swigCPtr, this, s);
    }
}
