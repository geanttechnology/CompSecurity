// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            OcrCharStringVector, OcrQuadrangle, jniInterfaceJNI, OcrConfidence

public class OcrResult
{

    private long a;
    protected boolean swigCMemOwn;

    protected OcrResult(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public OcrResult(OcrCharStringVector ocrcharstringvector, OcrCharStringVector ocrcharstringvector1, OcrCharStringVector ocrcharstringvector2, OcrCharStringVector ocrcharstringvector3, OcrCharStringVector ocrcharstringvector4, OcrCharStringVector ocrcharstringvector5, OcrCharStringVector ocrcharstringvector6, 
            OcrQuadrangle ocrquadrangle, boolean flag)
    {
        this(jniInterfaceJNI.new_OcrResult(OcrCharStringVector.getCPtr(ocrcharstringvector), ocrcharstringvector, OcrCharStringVector.getCPtr(ocrcharstringvector1), ocrcharstringvector1, OcrCharStringVector.getCPtr(ocrcharstringvector2), ocrcharstringvector2, OcrCharStringVector.getCPtr(ocrcharstringvector3), ocrcharstringvector3, OcrCharStringVector.getCPtr(ocrcharstringvector4), ocrcharstringvector4, OcrCharStringVector.getCPtr(ocrcharstringvector5), ocrcharstringvector5, OcrCharStringVector.getCPtr(ocrcharstringvector6), ocrcharstringvector6, OcrQuadrangle.getCPtr(ocrquadrangle), ocrquadrangle, flag), true);
    }

    protected static long getCPtr(OcrResult ocrresult)
    {
        if (ocrresult == null)
        {
            return 0L;
        } else
        {
            return ocrresult.a;
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
                jniInterfaceJNI.delete_OcrResult(a);
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

    public OcrCharStringVector getCardExpiry()
    {
        return new OcrCharStringVector(jniInterfaceJNI.OcrResult_getCardExpiry(a, this), false);
    }

    public String getCardExpiryAsString()
    {
        return jniInterfaceJNI.OcrResult_getCardExpiryAsString(a, this);
    }

    public OcrConfidence getCardExpiryConfidence()
    {
        return new OcrConfidence(jniInterfaceJNI.OcrResult_getCardExpiryConfidence(a, this), true);
    }

    public OcrCharStringVector getCardName()
    {
        return new OcrCharStringVector(jniInterfaceJNI.OcrResult_getCardName(a, this), false);
    }

    public String getCardNameAsString()
    {
        return jniInterfaceJNI.OcrResult_getCardNameAsString(a, this);
    }

    public OcrConfidence getCardNameConfidence()
    {
        return new OcrConfidence(jniInterfaceJNI.OcrResult_getCardNameConfidence(a, this), true);
    }

    public OcrCharStringVector getCardNumber()
    {
        return new OcrCharStringVector(jniInterfaceJNI.OcrResult_getCardNumber(a, this), false);
    }

    public String getCardNumberAsString()
    {
        return jniInterfaceJNI.OcrResult_getCardNumberAsString(a, this);
    }

    public OcrConfidence getCardNumberConfidence()
    {
        return new OcrConfidence(jniInterfaceJNI.OcrResult_getCardNumberConfidence(a, this), true);
    }

    public OcrCharStringVector getCardNumberPreview()
    {
        return new OcrCharStringVector(jniInterfaceJNI.OcrResult_getCardNumberPreview(a, this), false);
    }

    public String getCardNumberPreviewAsString()
    {
        return jniInterfaceJNI.OcrResult_getCardNumberPreviewAsString(a, this);
    }

    public OcrConfidence getCardNumberPreviewConfidence()
    {
        return new OcrConfidence(jniInterfaceJNI.OcrResult_getCardNumberPreviewConfidence(a, this), true);
    }

    public OcrQuadrangle getCardQuadrangle()
    {
        return new OcrQuadrangle(jniInterfaceJNI.OcrResult_getCardQuadrangle(a, this), false);
    }

    public int getOrientation()
    {
        return jniInterfaceJNI.OcrResult_getOrientation(a, this);
    }

    public OcrCharStringVector getRawSecondLine()
    {
        return new OcrCharStringVector(jniInterfaceJNI.OcrResult_getRawSecondLine(a, this), false);
    }

    public boolean getShouldBeDiscardedFlag()
    {
        return jniInterfaceJNI.OcrResult_getShouldBeDiscardedFlag(a, this);
    }

    public OcrCharStringVector getUkAccountNumber()
    {
        return new OcrCharStringVector(jniInterfaceJNI.OcrResult_getUkAccountNumber(a, this), false);
    }

    public String getUkAccountNumberAsString()
    {
        return jniInterfaceJNI.OcrResult_getUkAccountNumberAsString(a, this);
    }

    public OcrConfidence getUkAccountNumberConfidence()
    {
        return new OcrConfidence(jniInterfaceJNI.OcrResult_getUkAccountNumberConfidence(a, this), true);
    }

    public OcrCharStringVector getUkSortCode()
    {
        return new OcrCharStringVector(jniInterfaceJNI.OcrResult_getUkSortCode(a, this), false);
    }

    public String getUkSortCodeAsString()
    {
        return jniInterfaceJNI.OcrResult_getUkSortCodeAsString(a, this);
    }

    public OcrConfidence getUkSortCodeConfidence()
    {
        return new OcrConfidence(jniInterfaceJNI.OcrResult_getUkSortCodeConfidence(a, this), true);
    }
}
