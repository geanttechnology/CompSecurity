// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            OcrField, OcrQuadrangle, OcrLogoType, jniInterfaceJNI

public class OcrResult
{

    private long a;
    protected boolean swigCMemOwn;

    protected OcrResult(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public OcrResult(OcrField ocrfield, OcrField ocrfield1, OcrField ocrfield2, OcrField ocrfield3, OcrField ocrfield4, OcrField ocrfield5, OcrField ocrfield6, 
            OcrQuadrangle ocrquadrangle, boolean flag, boolean flag1, OcrLogoType ocrlogotype, boolean flag2)
    {
        this(jniInterfaceJNI.new_OcrResult(OcrField.getCPtr(ocrfield), ocrfield, OcrField.getCPtr(ocrfield1), ocrfield1, OcrField.getCPtr(ocrfield2), ocrfield2, OcrField.getCPtr(ocrfield3), ocrfield3, OcrField.getCPtr(ocrfield4), ocrfield4, OcrField.getCPtr(ocrfield5), ocrfield5, OcrField.getCPtr(ocrfield6), ocrfield6, OcrQuadrangle.getCPtr(ocrquadrangle), ocrquadrangle, flag, flag1, ocrlogotype.swigValue(), flag2), true);
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

    public OcrField getAmexCVV()
    {
        return new OcrField(jniInterfaceJNI.OcrResult_getAmexCVV(a, this), false);
    }

    public OcrField getCardExpiry()
    {
        return new OcrField(jniInterfaceJNI.OcrResult_getCardExpiry(a, this), false);
    }

    public OcrField getCardName()
    {
        return new OcrField(jniInterfaceJNI.OcrResult_getCardName(a, this), false);
    }

    public OcrField getCardNumber()
    {
        return new OcrField(jniInterfaceJNI.OcrResult_getCardNumber(a, this), false);
    }

    public OcrQuadrangle getCardQuadrangle()
    {
        return new OcrQuadrangle(jniInterfaceJNI.OcrResult_getCardQuadrangle(a, this), false);
    }

    public OcrLogoType getLogoType()
    {
        return OcrLogoType.swigToEnum(jniInterfaceJNI.OcrResult_getLogoType(a, this));
    }

    public int getOrientation()
    {
        return jniInterfaceJNI.OcrResult_getOrientation(a, this);
    }

    public OcrField getRawSecondLine()
    {
        return new OcrField(jniInterfaceJNI.OcrResult_getRawSecondLine(a, this), false);
    }

    public boolean getShouldBeDiscardedFlag()
    {
        return jniInterfaceJNI.OcrResult_getShouldBeDiscardedFlag(a, this);
    }

    public OcrField getUkAccountNumber()
    {
        return new OcrField(jniInterfaceJNI.OcrResult_getUkAccountNumber(a, this), false);
    }

    public OcrField getUkSortCode()
    {
        return new OcrField(jniInterfaceJNI.OcrResult_getUkSortCode(a, this), false);
    }

    public boolean getUmpCardFlag()
    {
        return jniInterfaceJNI.OcrResult_getUmpCardFlag(a, this);
    }

    public boolean getUpturnedCardFlag()
    {
        return jniInterfaceJNI.OcrResult_getUpturnedCardFlag(a, this);
    }
}
