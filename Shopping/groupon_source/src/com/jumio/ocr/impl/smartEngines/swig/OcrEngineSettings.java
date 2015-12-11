// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI

public class OcrEngineSettings
{

    private long a;
    protected boolean swigCMemOwn;

    public OcrEngineSettings()
    {
        this(jniInterfaceJNI.new_OcrEngineSettings__SWIG_0(), true);
    }

    protected OcrEngineSettings(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public OcrEngineSettings(OcrEngineSettings ocrenginesettings)
    {
        this(jniInterfaceJNI.new_OcrEngineSettings__SWIG_1(getCPtr(ocrenginesettings), ocrenginesettings), true);
    }

    protected static long getCPtr(OcrEngineSettings ocrenginesettings)
    {
        if (ocrenginesettings == null)
        {
            return 0L;
        } else
        {
            return ocrenginesettings.a;
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
                jniInterfaceJNI.delete_OcrEngineSettings(a);
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

    public boolean getExpiryContextCorrectionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getExpiryContextCorrectionFlag(a, this);
    }

    public boolean getExpiryRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getExpiryRecognitionFlag(a, this);
    }

    public boolean getFindcardFastModeFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getFindcardFastModeFlag(a, this);
    }

    public boolean getNameContextCorrectionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getNameContextCorrectionFlag(a, this);
    }

    public boolean getNameRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getNameRecognitionFlag(a, this);
    }

    public boolean getNumberContextCorrectionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getNumberContextCorrectionFlag(a, this);
    }

    public int getNumberOfQuadranglesToProcess()
    {
        return jniInterfaceJNI.OcrEngineSettings_getNumberOfQuadranglesToProcess(a, this);
    }

    public boolean getNumberPreviewContextCorrectionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getNumberPreviewContextCorrectionFlag(a, this);
    }

    public boolean getNumberPreviewRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getNumberPreviewRecognitionFlag(a, this);
    }

    public boolean getNumberRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getNumberRecognitionFlag(a, this);
    }

    public boolean getRawSecondLineRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getRawSecondLineRecognitionFlag(a, this);
    }

    public double getRoiBottomMargin()
    {
        return jniInterfaceJNI.OcrEngineSettings_getRoiBottomMargin(a, this);
    }

    public double getRoiHorizontalDeviation()
    {
        return jniInterfaceJNI.OcrEngineSettings_getRoiHorizontalDeviation(a, this);
    }

    public double getRoiLeftMargin()
    {
        return jniInterfaceJNI.OcrEngineSettings_getRoiLeftMargin(a, this);
    }

    public double getRoiRightMargin()
    {
        return jniInterfaceJNI.OcrEngineSettings_getRoiRightMargin(a, this);
    }

    public double getRoiTopMargin()
    {
        return jniInterfaceJNI.OcrEngineSettings_getRoiTopMargin(a, this);
    }

    public double getRoiVerticalDeviation()
    {
        return jniInterfaceJNI.OcrEngineSettings_getRoiVerticalDeviation(a, this);
    }

    public boolean getUkSortCodeAccountNumberContextCorrectionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getUkSortCodeAccountNumberContextCorrectionFlag(a, this);
    }

    public boolean getUkSortCodeAccountNumberRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getUkSortCodeAccountNumberRecognitionFlag(a, this);
    }

    public void setExpiryContextCorrectionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setExpiryContextCorrectionFlag(a, this, flag);
    }

    public void setExpiryRecognitionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setExpiryRecognitionFlag(a, this, flag);
    }

    public void setFindcardFastModeFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setFindcardFastModeFlag(a, this, flag);
    }

    public void setNameContextCorrectionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setNameContextCorrectionFlag(a, this, flag);
    }

    public void setNameRecognitionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setNameRecognitionFlag(a, this, flag);
    }

    public void setNumberContextCorrectionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setNumberContextCorrectionFlag(a, this, flag);
    }

    public void setNumberOfQuadranglesToProcess(int i)
    {
        jniInterfaceJNI.OcrEngineSettings_setNumberOfQuadranglesToProcess(a, this, i);
    }

    public void setNumberPreviewContextCorrectionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setNumberPreviewContextCorrectionFlag(a, this, flag);
    }

    public void setNumberPreviewRecognitionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setNumberPreviewRecognitionFlag(a, this, flag);
    }

    public void setNumberRecognitionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setNumberRecognitionFlag(a, this, flag);
    }

    public void setRawSecondLineRecognitionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setRawSecondLineRecognitionFlag(a, this, flag);
    }

    public void setRoiBottomMargin(double d)
    {
        jniInterfaceJNI.OcrEngineSettings_setRoiBottomMargin(a, this, d);
    }

    public void setRoiHorizontalDeviation(double d)
    {
        jniInterfaceJNI.OcrEngineSettings_setRoiHorizontalDeviation(a, this, d);
    }

    public void setRoiLeftMargin(double d)
    {
        jniInterfaceJNI.OcrEngineSettings_setRoiLeftMargin(a, this, d);
    }

    public void setRoiRightMargin(double d)
    {
        jniInterfaceJNI.OcrEngineSettings_setRoiRightMargin(a, this, d);
    }

    public void setRoiTopMargin(double d)
    {
        jniInterfaceJNI.OcrEngineSettings_setRoiTopMargin(a, this, d);
    }

    public void setRoiVerticalDeviation(double d)
    {
        jniInterfaceJNI.OcrEngineSettings_setRoiVerticalDeviation(a, this, d);
    }

    public void setUkSortCodeAccountNumberContextCorrectionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setUkSortCodeAccountNumberContextCorrectionFlag(a, this, flag);
    }

    public void setUkSortCodeAccountNumberRecognitionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setUkSortCodeAccountNumberRecognitionFlag(a, this, flag);
    }
}
