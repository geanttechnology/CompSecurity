// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            OcrEngineBase, jniInterfaceJNI, OcrEngineInternalSettings, ResultAcceptorInterface, 
//            OcrException, OcrResult, OcrEngineSettings

public class OcrEngine extends OcrEngineBase
{

    private long a;

    protected OcrEngine(long l, boolean flag)
    {
        super(jniInterfaceJNI.OcrEngine_SWIGUpcast(l), flag);
        a = l;
    }

    public OcrEngine(OcrEngineInternalSettings ocrengineinternalsettings)
    {
        this(jniInterfaceJNI.new_OcrEngine__SWIG_1(OcrEngineInternalSettings.getCPtr(ocrengineinternalsettings), ocrengineinternalsettings), true);
    }

    public OcrEngine(OcrEngineInternalSettings ocrengineinternalsettings, ResultAcceptorInterface resultacceptorinterface)
    {
        this(jniInterfaceJNI.new_OcrEngine__SWIG_0(OcrEngineInternalSettings.getCPtr(ocrengineinternalsettings), ocrengineinternalsettings, ResultAcceptorInterface.getCPtr(resultacceptorinterface), resultacceptorinterface), true);
    }

    protected static long getCPtr(OcrEngine ocrengine)
    {
        if (ocrengine == null)
        {
            return 0L;
        } else
        {
            return ocrengine.a;
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
                jniInterfaceJNI.delete_OcrEngine(a);
            }
            a = 0L;
        }
        super.delete();
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

    public OcrResult processImageData(byte abyte0[])
        throws OcrException
    {
        long l = jniInterfaceJNI.OcrEngine_processImageData__SWIG_1(a, this, abyte0);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrResult(l, false);
        }
    }

    public OcrResult processImageData(byte abyte0[], OcrEngineSettings ocrenginesettings)
        throws OcrException
    {
        long l = jniInterfaceJNI.OcrEngine_processImageData__SWIG_0(a, this, abyte0, OcrEngineSettings.getCPtr(ocrenginesettings), ocrenginesettings);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrResult(l, false);
        }
    }

    public OcrResult processImageFile(String s)
        throws OcrException
    {
        long l = jniInterfaceJNI.OcrEngine_processImageFile__SWIG_1(a, this, s);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrResult(l, false);
        }
    }

    public OcrResult processImageFile(String s, OcrEngineSettings ocrenginesettings)
        throws OcrException
    {
        long l = jniInterfaceJNI.OcrEngine_processImageFile__SWIG_0(a, this, s, OcrEngineSettings.getCPtr(ocrenginesettings), ocrenginesettings);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrResult(l, false);
        }
    }
}
