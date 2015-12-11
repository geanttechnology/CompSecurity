// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            OcrEngineInternalSettings, jniInterfaceJNI, OcrTimingRecordVector, OcrEngineBaseSession, 
//            ResultAcceptorInterface

public class OcrEngineBase
{

    private long a;
    protected boolean swigCMemOwn;

    protected OcrEngineBase(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public OcrEngineBase(OcrEngineInternalSettings ocrengineinternalsettings)
    {
        this(jniInterfaceJNI.new_OcrEngineBase(OcrEngineInternalSettings.getCPtr(ocrengineinternalsettings), ocrengineinternalsettings), true);
        jniInterfaceJNI.OcrEngineBase_director_connect(this, a, swigCMemOwn, true);
    }

    public static int getBuildNumber()
    {
        return jniInterfaceJNI.OcrEngineBase_getBuildNumber();
    }

    protected static long getCPtr(OcrEngineBase ocrenginebase)
    {
        if (ocrenginebase == null)
        {
            return 0L;
        } else
        {
            return ocrenginebase.a;
        }
    }

    public static OcrTimingRecordVector getTimingStats()
    {
        return new OcrTimingRecordVector(jniInterfaceJNI.OcrEngineBase_getTimingStats(), true);
    }

    public OcrEngineBaseSession createSession()
    {
        long l = jniInterfaceJNI.OcrEngineBase_createSession__SWIG_1(a, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrEngineBaseSession(l, true);
        }
    }

    public OcrEngineBaseSession createSession(ResultAcceptorInterface resultacceptorinterface)
    {
        long l = jniInterfaceJNI.OcrEngineBase_createSession__SWIG_0(a, this, ResultAcceptorInterface.getCPtr(resultacceptorinterface), resultacceptorinterface);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrEngineBaseSession(l, true);
        }
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrEngineBase(a);
            }
            a = 0L;
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

    protected void swigDirectorDisconnect()
    {
        swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership()
    {
        swigCMemOwn = false;
        jniInterfaceJNI.OcrEngineBase_change_ownership(this, a, false);
    }

    public void swigTakeOwnership()
    {
        swigCMemOwn = true;
        jniInterfaceJNI.OcrEngineBase_change_ownership(this, a, true);
    }
}
