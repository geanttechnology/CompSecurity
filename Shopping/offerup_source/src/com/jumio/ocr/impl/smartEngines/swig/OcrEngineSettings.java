// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI, OcrQuadrangleVector

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

    public boolean getAmexCVVRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getAmexCVVRecognitionFlag(a, this);
    }

    public boolean getCheckChinaUnionPayLuhnCodeFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getCheckChinaUnionPayLuhnCodeFlag(a, this);
    }

    public boolean getCheckUmpFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getCheckUmpFlag(a, this);
    }

    public boolean getExpiryContextCorrectionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getExpiryContextCorrectionFlag(a, this);
    }

    public boolean getExpiryRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getExpiryRecognitionFlag(a, this);
    }

    public int getFocusThreshold()
    {
        return jniInterfaceJNI.OcrEngineSettings_getFocusThreshold(a, this);
    }

    public int getIntensityThreshold()
    {
        return jniInterfaceJNI.OcrEngineSettings_getIntensityThreshold(a, this);
    }

    public boolean getLogoAnalysisFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getLogoAnalysisFlag(a, this);
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

    public boolean getNumberRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getNumberRecognitionFlag(a, this);
    }

    public OcrQuadrangleVector getPreDetectedQuadrangles()
    {
        return new OcrQuadrangleVector(jniInterfaceJNI.OcrEngineSettings_getPreDetectedQuadrangles(a, this), false);
    }

    public boolean getRawSecondLineRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getRawSecondLineRecognitionFlag(a, this);
    }

    public boolean getServerModeFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getServerModeFlag(a, this);
    }

    public boolean getUkSortCodeAccountNumberContextCorrectionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getUkSortCodeAccountNumberContextCorrectionFlag(a, this);
    }

    public boolean getUkSortCodeAccountNumberRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getUkSortCodeAccountNumberRecognitionFlag(a, this);
    }

    public boolean getUpturnedCardDetectionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getUpturnedCardDetectionFlag(a, this);
    }

    public boolean getUseAdvAcceptDictFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_getUseAdvAcceptDictFlag(a, this);
    }

    public boolean isOverridenAmexCVVRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenAmexCVVRecognitionFlag(a, this);
    }

    public boolean isOverridenCheckChinaUnionPayLuhnCodeFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenCheckChinaUnionPayLuhnCodeFlag(a, this);
    }

    public boolean isOverridenCheckUmpFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenCheckUmpFlag(a, this);
    }

    public boolean isOverridenExpiryContextCorrectionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenExpiryContextCorrectionFlag(a, this);
    }

    public boolean isOverridenExpiryRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenExpiryRecognitionFlag(a, this);
    }

    public boolean isOverridenFocusThreshold()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenFocusThreshold(a, this);
    }

    public boolean isOverridenIntensityThreshold()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenIntensityThreshold(a, this);
    }

    public boolean isOverridenLogoAnalysisFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenLogoAnalysisFlag(a, this);
    }

    public boolean isOverridenNameContextCorrectionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenNameContextCorrectionFlag(a, this);
    }

    public boolean isOverridenNameRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenNameRecognitionFlag(a, this);
    }

    public boolean isOverridenNumberContextCorrectionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenNumberContextCorrectionFlag(a, this);
    }

    public boolean isOverridenNumberOfQuadranglesToProcess()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenNumberOfQuadranglesToProcess(a, this);
    }

    public boolean isOverridenNumberRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenNumberRecognitionFlag(a, this);
    }

    public boolean isOverridenPreDetectedQuadrangles()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenPreDetectedQuadrangles(a, this);
    }

    public boolean isOverridenRawSecondLineRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenRawSecondLineRecognitionFlag(a, this);
    }

    public boolean isOverridenServerModeFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenServerModeFlag(a, this);
    }

    public boolean isOverridenUkSortCodeAccountNumberContextCorrectionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenUkSortCodeAccountNumberContextCorrectionFlag(a, this);
    }

    public boolean isOverridenUkSortCodeAccountNumberRecognitionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenUkSortCodeAccountNumberRecognitionFlag(a, this);
    }

    public boolean isOverridenUpturnedCardDetectionFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenUpturnedCardDetectionFlag(a, this);
    }

    public boolean isOverridenUseAdvAcceptDictFlag()
    {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenUseAdvAcceptDictFlag(a, this);
    }

    public void setAmexCVVRecognitionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setAmexCVVRecognitionFlag(a, this, flag);
    }

    public void setCheckChinaUnionPayLuhnCodeFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setCheckChinaUnionPayLuhnCodeFlag(a, this, flag);
    }

    public void setCheckUmpFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setCheckUmpFlag(a, this, flag);
    }

    public void setExpiryContextCorrectionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setExpiryContextCorrectionFlag(a, this, flag);
    }

    public void setExpiryRecognitionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setExpiryRecognitionFlag(a, this, flag);
    }

    public void setFocusThreshold(int i)
    {
        jniInterfaceJNI.OcrEngineSettings_setFocusThreshold(a, this, i);
    }

    public void setIntensityThreshold(int i)
    {
        jniInterfaceJNI.OcrEngineSettings_setIntensityThreshold(a, this, i);
    }

    public void setLogoAnalysisFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setLogoAnalysisFlag(a, this, flag);
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

    public void setNumberRecognitionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setNumberRecognitionFlag(a, this, flag);
    }

    public void setPreDetectedQuadrangles(OcrQuadrangleVector ocrquadranglevector)
    {
        jniInterfaceJNI.OcrEngineSettings_setPreDetectedQuadrangles(a, this, OcrQuadrangleVector.getCPtr(ocrquadranglevector), ocrquadranglevector);
    }

    public void setRawSecondLineRecognitionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setRawSecondLineRecognitionFlag(a, this, flag);
    }

    public void setServerModeFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setServerModeFlag(a, this, flag);
    }

    public void setUkSortCodeAccountNumberContextCorrectionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setUkSortCodeAccountNumberContextCorrectionFlag(a, this, flag);
    }

    public void setUkSortCodeAccountNumberRecognitionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setUkSortCodeAccountNumberRecognitionFlag(a, this, flag);
    }

    public void setUpturnedCardDetectionFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setUpturnedCardDetectionFlag(a, this, flag);
    }

    public void setUseAdvAcceptDictFlag(boolean flag)
    {
        jniInterfaceJNI.OcrEngineSettings_setUseAdvAcceptDictFlag(a, this, flag);
    }
}
