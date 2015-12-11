// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            OcrEngineBaseSession, jniInterfaceJNI, OcrResult, OcrEngineSettings

public class OcrEngineSession extends OcrEngineBaseSession
{

    private long a;

    protected OcrEngineSession(long l, boolean flag)
    {
        super(jniInterfaceJNI.OcrEngineSession_SWIGUpcast(l), flag);
        a = l;
    }

    protected static long getCPtr(OcrEngineSession ocrenginesession)
    {
        if (ocrenginesession == null)
        {
            return 0L;
        } else
        {
            return ocrenginesession.a;
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
                jniInterfaceJNI.delete_OcrEngineSession(a);
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
    {
        long l = jniInterfaceJNI.OcrEngineSession_processImageData__SWIG_1(a, this, abyte0);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrResult(l, true);
        }
    }

    public OcrResult processImageData(byte abyte0[], OcrEngineSettings ocrenginesettings)
    {
        long l = jniInterfaceJNI.OcrEngineSession_processImageData__SWIG_0(a, this, abyte0, OcrEngineSettings.getCPtr(ocrenginesettings), ocrenginesettings);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrResult(l, true);
        }
    }

    public OcrResult processImageFile(String s)
    {
        long l = jniInterfaceJNI.OcrEngineSession_processImageFile__SWIG_1(a, this, s);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrResult(l, true);
        }
    }

    public OcrResult processImageFile(String s, OcrEngineSettings ocrenginesettings)
    {
        long l = jniInterfaceJNI.OcrEngineSession_processImageFile__SWIG_0(a, this, s, OcrEngineSettings.getCPtr(ocrenginesettings), ocrenginesettings);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrResult(l, true);
        }
    }

    protected void swigDirectorDisconnect()
    {
        swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership()
    {
        swigCMemOwn = false;
        jniInterfaceJNI.OcrEngineSession_change_ownership(this, a, false);
    }

    public void swigTakeOwnership()
    {
        swigCMemOwn = true;
        jniInterfaceJNI.OcrEngineSession_change_ownership(this, a, true);
    }
}
