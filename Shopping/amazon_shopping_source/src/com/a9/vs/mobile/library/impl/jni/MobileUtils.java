// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, NEONAccelerationResult

public class MobileUtils
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public MobileUtils()
    {
        this(A9VSMobileJNI.new_MobileUtils(), true);
    }

    protected MobileUtils(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(MobileUtils mobileutils)
    {
        if (mobileutils == null)
        {
            return 0L;
        } else
        {
            return mobileutils.swigCPtr;
        }
    }

    public static String getDataDumpLocation()
    {
        return A9VSMobileJNI.MobileUtils_getDataDumpLocation();
    }

    public static void setDataDumpLocation(String s)
    {
        A9VSMobileJNI.MobileUtils_setDataDumpLocation(s);
    }

    public static boolean setupLogging(String s, boolean flag)
    {
        return A9VSMobileJNI.MobileUtils_setupLogging(s, flag);
    }

    public static void testNEON(NEONAccelerationResult neonaccelerationresult)
    {
        A9VSMobileJNI.MobileUtils_testNEON(NEONAccelerationResult.getCPtr(neonaccelerationresult), neonaccelerationresult);
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
                A9VSMobileJNI.delete_MobileUtils(swigCPtr);
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
}
