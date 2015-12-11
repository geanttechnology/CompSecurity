// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI, OcrPoint, OcrQuadrangle

public class DetectionResult
{

    private long a;
    protected boolean swigCMemOwn;

    public DetectionResult()
    {
        this(jniInterfaceJNI.new_DetectionResult__SWIG_0(), true);
    }

    protected DetectionResult(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public DetectionResult(boolean flag, boolean flag1, int i, boolean flag2, boolean flag3, boolean flag4, boolean flag5, 
            OcrPoint ocrpoint, OcrPoint ocrpoint1, boolean flag6, OcrQuadrangle ocrquadrangle)
    {
        this(jniInterfaceJNI.new_DetectionResult__SWIG_1(flag, flag1, i, flag2, flag3, flag4, flag5, OcrPoint.getCPtr(ocrpoint), ocrpoint, OcrPoint.getCPtr(ocrpoint1), ocrpoint1, flag6, OcrQuadrangle.getCPtr(ocrquadrangle), ocrquadrangle), true);
    }

    protected static long getCPtr(DetectionResult detectionresult)
    {
        if (detectionresult == null)
        {
            return 0L;
        } else
        {
            return detectionresult.a;
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
                jniInterfaceJNI.delete_DetectionResult(a);
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

    public int getCardImageQualityScore()
    {
        return jniInterfaceJNI.DetectionResult_getCardImageQualityScore(a, this);
    }

    public OcrQuadrangle getCardQuadrangle()
    {
        return new OcrQuadrangle(jniInterfaceJNI.DetectionResult_getCardQuadrangle(a, this), true);
    }

    public OcrPoint getExposurePointOfInterest()
    {
        return new OcrPoint(jniInterfaceJNI.DetectionResult_getExposurePointOfInterest(a, this), true);
    }

    public boolean getFlashTurnOn()
    {
        return jniInterfaceJNI.DetectionResult_getFlashTurnOn(a, this);
    }

    public OcrPoint getFocusPointOfInterest()
    {
        return new OcrPoint(jniInterfaceJNI.DetectionResult_getFocusPointOfInterest(a, this), true);
    }

    public boolean hasBottomOfCard()
    {
        return jniInterfaceJNI.DetectionResult_hasBottomOfCard(a, this);
    }

    public boolean hasLeftOfCard()
    {
        return jniInterfaceJNI.DetectionResult_hasLeftOfCard(a, this);
    }

    public boolean hasRightOfCard()
    {
        return jniInterfaceJNI.DetectionResult_hasRightOfCard(a, this);
    }

    public boolean hasTopOfCard()
    {
        return jniInterfaceJNI.DetectionResult_hasTopOfCard(a, this);
    }

    public boolean isCardImageOfGoodQuality()
    {
        return jniInterfaceJNI.DetectionResult_isCardImageOfGoodQuality(a, this);
    }

    public boolean isCardInRoi()
    {
        return jniInterfaceJNI.DetectionResult_isCardInRoi(a, this);
    }
}
