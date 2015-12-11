// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI, OcrResult, OcrEngineSettings

public class OcrEngineBaseSession
{

    private long a;
    protected boolean swigCMemOwn;

    protected OcrEngineBaseSession(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(OcrEngineBaseSession ocrenginebasesession)
    {
        if (ocrenginebasesession == null)
        {
            return 0L;
        } else
        {
            return ocrenginebasesession.a;
        }
    }

    public float computeFlashConfidence(byte abyte0[], int i, int j, int k, int l)
    {
        return jniInterfaceJNI.OcrEngineBaseSession_computeFlashConfidence(a, this, abyte0, i, j, k, l);
    }

    public int computeFocusConfidence(byte abyte0[], int i, int j, int k, int l)
    {
        return jniInterfaceJNI.OcrEngineBaseSession_computeFocusConfidence(a, this, abyte0, i, j, k, l);
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
                jniInterfaceJNI.delete_OcrEngineBaseSession(a);
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

    public boolean isFlashRequired(byte abyte0[], int i, int j, int k, int l, int i1)
    {
        return jniInterfaceJNI.OcrEngineBaseSession_isFlashRequired(a, this, abyte0, i, j, k, l, i1);
    }

    public boolean isRefocusRequired(byte abyte0[], int i, int j, int k, int l, int i1)
    {
        return jniInterfaceJNI.OcrEngineBaseSession_isRefocusRequired(a, this, abyte0, i, j, k, l, i1);
    }

    public OcrResult processUncompressedImageData(byte abyte0[], int i, int j, int k)
    {
        long l = jniInterfaceJNI.OcrEngineBaseSession_processUncompressedImageData__SWIG_1(a, this, abyte0, i, j, k);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrResult(l, true);
        }
    }

    public OcrResult processUncompressedImageData(byte abyte0[], int i, int j, int k, OcrEngineSettings ocrenginesettings)
    {
        long l = jniInterfaceJNI.OcrEngineBaseSession_processUncompressedImageData__SWIG_0(a, this, abyte0, i, j, k, OcrEngineSettings.getCPtr(ocrenginesettings), ocrenginesettings);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrResult(l, true);
        }
    }

    public OcrResult processUncompressedYUVImageData(byte abyte0[], int i, int j, int k)
    {
        long l = jniInterfaceJNI.OcrEngineBaseSession_processUncompressedYUVImageData__SWIG_1(a, this, abyte0, i, j, k);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrResult(l, true);
        }
    }

    public OcrResult processUncompressedYUVImageData(byte abyte0[], int i, int j, int k, OcrEngineSettings ocrenginesettings)
    {
        long l = jniInterfaceJNI.OcrEngineBaseSession_processUncompressedYUVImageData__SWIG_0(a, this, abyte0, i, j, k, OcrEngineSettings.getCPtr(ocrenginesettings), ocrenginesettings);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new OcrResult(l, true);
        }
    }

    public void resetSession()
    {
        jniInterfaceJNI.OcrEngineBaseSession_resetSession(a, this);
    }

    protected void swigDirectorDisconnect()
    {
        swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership()
    {
        swigCMemOwn = false;
        jniInterfaceJNI.OcrEngineBaseSession_change_ownership(this, a, false);
    }

    public void swigTakeOwnership()
    {
        swigCMemOwn = true;
        jniInterfaceJNI.OcrEngineBaseSession_change_ownership(this, a, true);
    }
}
