// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            OcrEngineInternalSettings, jniInterfaceJNI, ResultAcceptorInterface, OcrTimingRecordVector, 
//            OcrException, OcrResult, OcrEngineSettings

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
        this(jniInterfaceJNI.new_OcrEngineBase__SWIG_1(OcrEngineInternalSettings.getCPtr(ocrengineinternalsettings), ocrengineinternalsettings), true);
    }

    public OcrEngineBase(OcrEngineInternalSettings ocrengineinternalsettings, ResultAcceptorInterface resultacceptorinterface)
    {
        this(jniInterfaceJNI.new_OcrEngineBase__SWIG_0(OcrEngineInternalSettings.getCPtr(ocrengineinternalsettings), ocrengineinternalsettings, ResultAcceptorInterface.getCPtr(resultacceptorinterface), resultacceptorinterface), true);
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

    public OcrResult processUncompressedImageData(byte abyte0[], int i, int j, int k)
        throws OcrException
    {
        long l = jniInterfaceJNI.OcrEngineBase_processUncompressedImageData__SWIG_1(a, this, abyte0, i, j, k);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrResult(l, false);
        }
    }

    public OcrResult processUncompressedImageData(byte abyte0[], int i, int j, int k, OcrEngineSettings ocrenginesettings)
        throws OcrException
    {
        long l = jniInterfaceJNI.OcrEngineBase_processUncompressedImageData__SWIG_0(a, this, abyte0, i, j, k, OcrEngineSettings.getCPtr(ocrenginesettings), ocrenginesettings);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrResult(l, false);
        }
    }
}
