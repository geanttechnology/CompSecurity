// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            OcrCharStringVector, ResultAcceptorInterfaceSettings, ResultAcceptorInterface, DetectionEngine, 
//            DetectionInternalSettings, DetectionResult, DetectionSettings, OcrCharVariants, 
//            OcrChar, OcrCharVector, OcrConfidence, OcrEngineBaseSession, 
//            OcrEngineSettings, OcrEngineBase, OcrEngineSession, OcrQuadrangleVector, 
//            OcrEngine, OcrField, OcrPoint, OcrQuadrangle, 
//            OcrResult, OcrTimingRecordVector, OcrTimingRecord, OcrEngineInternalSettings

public class jniInterfaceJNI
{

    public jniInterfaceJNI()
    {
    }

    public static final native int ConversionUtils_convertImage(byte abyte0[], int i, byte abyte1[]);

    public static final native long DetectionEngine_processRawImage(long l, DetectionEngine detectionengine, byte abyte0[], int i, int j, int k, int i1);

    public static final native long DetectionEngine_processRawYUVImage(long l, DetectionEngine detectionengine, byte abyte0[], int i, int j, int k, int i1);

    public static final native void DetectionEngine_resetSession(long l, DetectionEngine detectionengine);

    public static final native long DetectionInternalSettingsFactory_createFromFileSystem(String s);

    public static final native void DetectionInternalSettings_change_ownership(DetectionInternalSettings detectioninternalsettings, long l, boolean flag);

    public static final native void DetectionInternalSettings_director_connect(DetectionInternalSettings detectioninternalsettings, long l, boolean flag, boolean flag1);

    public static final native int DetectionResult_getCardImageQualityScore(long l, DetectionResult detectionresult);

    public static final native long DetectionResult_getCardQuadrangle(long l, DetectionResult detectionresult);

    public static final native long DetectionResult_getExposurePointOfInterest(long l, DetectionResult detectionresult);

    public static final native boolean DetectionResult_getFlashTurnOn(long l, DetectionResult detectionresult);

    public static final native long DetectionResult_getFocusPointOfInterest(long l, DetectionResult detectionresult);

    public static final native boolean DetectionResult_hasBottomOfCard(long l, DetectionResult detectionresult);

    public static final native boolean DetectionResult_hasLeftOfCard(long l, DetectionResult detectionresult);

    public static final native boolean DetectionResult_hasRightOfCard(long l, DetectionResult detectionresult);

    public static final native boolean DetectionResult_hasTopOfCard(long l, DetectionResult detectionresult);

    public static final native boolean DetectionResult_isCardImageOfGoodQuality(long l, DetectionResult detectionresult);

    public static final native boolean DetectionResult_isCardInRoi(long l, DetectionResult detectionresult);

    public static final native double DetectionSettings_getRoiBottomMargin(long l, DetectionSettings detectionsettings);

    public static final native double DetectionSettings_getRoiHorizontalDeviation(long l, DetectionSettings detectionsettings);

    public static final native double DetectionSettings_getRoiLeftMargin(long l, DetectionSettings detectionsettings);

    public static final native double DetectionSettings_getRoiRightMargin(long l, DetectionSettings detectionsettings);

    public static final native double DetectionSettings_getRoiTopMargin(long l, DetectionSettings detectionsettings);

    public static final native double DetectionSettings_getRoiVerticalDeviation(long l, DetectionSettings detectionsettings);

    public static final native void DetectionSettings_setRoiBottomMargin(long l, DetectionSettings detectionsettings, double d);

    public static final native void DetectionSettings_setRoiHorizontalDeviation(long l, DetectionSettings detectionsettings, double d);

    public static final native void DetectionSettings_setRoiLeftMargin(long l, DetectionSettings detectionsettings, double d);

    public static final native void DetectionSettings_setRoiRightMargin(long l, DetectionSettings detectionsettings, double d);

    public static final native void DetectionSettings_setRoiTopMargin(long l, DetectionSettings detectionsettings, double d);

    public static final native void DetectionSettings_setRoiVerticalDeviation(long l, DetectionSettings detectionsettings, double d);

    public static final native float ImageCheck_computeFlashConfidence(byte abyte0[], int i, int j, int k, int l);

    public static final native int ImageCheck_computeFocusConfidence(byte abyte0[], int i, int j, int k, int l);

    public static final native boolean ImageCheck_isFlashNeeded(byte abyte0[], int i, int j, int k, int l, int i1);

    public static final native boolean ImageCheck_isRefocusNeeded(byte abyte0[], int i, int j, int k, int l, int i1);

    public static final native void OcrCharStringVector_add(long l, OcrCharStringVector ocrcharstringvector, long l1, OcrCharVariants ocrcharvariants);

    public static final native long OcrCharStringVector_capacity(long l, OcrCharStringVector ocrcharstringvector);

    public static final native void OcrCharStringVector_clear(long l, OcrCharStringVector ocrcharstringvector);

    public static final native long OcrCharStringVector_get(long l, OcrCharStringVector ocrcharstringvector, int i);

    public static final native boolean OcrCharStringVector_isEmpty(long l, OcrCharStringVector ocrcharstringvector);

    public static final native void OcrCharStringVector_reserve(long l, OcrCharStringVector ocrcharstringvector, long l1);

    public static final native void OcrCharStringVector_set(long l, OcrCharStringVector ocrcharstringvector, int i, long l1, OcrCharVariants ocrcharvariants);

    public static final native long OcrCharStringVector_size(long l, OcrCharStringVector ocrcharstringvector);

    public static final native void OcrCharVariants_add(long l, OcrCharVariants ocrcharvariants, long l1, OcrChar ocrchar);

    public static final native long OcrCharVariants_get(long l, OcrCharVariants ocrcharvariants);

    public static final native int OcrCharVariants_getHighlightingMask(long l, OcrCharVariants ocrcharvariants);

    public static final native long OcrCharVariants_getQuadrangle(long l, OcrCharVariants ocrcharvariants);

    public static final native void OcrCharVector_add(long l, OcrCharVector ocrcharvector, long l1, OcrChar ocrchar);

    public static final native long OcrCharVector_capacity(long l, OcrCharVector ocrcharvector);

    public static final native void OcrCharVector_clear(long l, OcrCharVector ocrcharvector);

    public static final native long OcrCharVector_get(long l, OcrCharVector ocrcharvector, int i);

    public static final native boolean OcrCharVector_isEmpty(long l, OcrCharVector ocrcharvector);

    public static final native void OcrCharVector_reserve(long l, OcrCharVector ocrcharvector, long l1);

    public static final native void OcrCharVector_set(long l, OcrCharVector ocrcharvector, int i, long l1, OcrChar ocrchar);

    public static final native long OcrCharVector_size(long l, OcrCharVector ocrcharvector);

    public static final native char OcrChar_getCharacter(long l, OcrChar ocrchar);

    public static final native double OcrChar_getProbability(long l, OcrChar ocrchar);

    public static final native double OcrConfidence_getAverage(long l, OcrConfidence ocrconfidence);

    public static final native double OcrConfidence_getMinimum(long l, OcrConfidence ocrconfidence);

    public static final native void OcrEngineBaseSession_change_ownership(OcrEngineBaseSession ocrenginebasesession, long l, boolean flag);

    public static final native float OcrEngineBaseSession_computeFlashConfidence(long l, OcrEngineBaseSession ocrenginebasesession, byte abyte0[], int i, int j, int k, int i1);

    public static final native int OcrEngineBaseSession_computeFocusConfidence(long l, OcrEngineBaseSession ocrenginebasesession, byte abyte0[], int i, int j, int k, int i1);

    public static final native void OcrEngineBaseSession_director_connect(OcrEngineBaseSession ocrenginebasesession, long l, boolean flag, boolean flag1);

    public static final native boolean OcrEngineBaseSession_isFlashRequired(long l, OcrEngineBaseSession ocrenginebasesession, byte abyte0[], int i, int j, int k, int i1, 
            int j1);

    public static final native boolean OcrEngineBaseSession_isRefocusRequired(long l, OcrEngineBaseSession ocrenginebasesession, byte abyte0[], int i, int j, int k, int i1, 
            int j1);

    public static final native long OcrEngineBaseSession_processUncompressedImageData__SWIG_0(long l, OcrEngineBaseSession ocrenginebasesession, byte abyte0[], int i, int j, int k, long l1, OcrEngineSettings ocrenginesettings);

    public static final native long OcrEngineBaseSession_processUncompressedImageData__SWIG_1(long l, OcrEngineBaseSession ocrenginebasesession, byte abyte0[], int i, int j, int k);

    public static final native long OcrEngineBaseSession_processUncompressedYUVImageData__SWIG_0(long l, OcrEngineBaseSession ocrenginebasesession, byte abyte0[], int i, int j, int k, long l1, OcrEngineSettings ocrenginesettings);

    public static final native long OcrEngineBaseSession_processUncompressedYUVImageData__SWIG_1(long l, OcrEngineBaseSession ocrenginebasesession, byte abyte0[], int i, int j, int k);

    public static final native void OcrEngineBaseSession_resetSession(long l, OcrEngineBaseSession ocrenginebasesession);

    public static final native void OcrEngineBase_change_ownership(OcrEngineBase ocrenginebase, long l, boolean flag);

    public static final native long OcrEngineBase_createSession__SWIG_0(long l, OcrEngineBase ocrenginebase, long l1, ResultAcceptorInterface resultacceptorinterface);

    public static final native long OcrEngineBase_createSession__SWIG_1(long l, OcrEngineBase ocrenginebase);

    public static final native void OcrEngineBase_director_connect(OcrEngineBase ocrenginebase, long l, boolean flag, boolean flag1);

    public static final native int OcrEngineBase_getBuildNumber();

    public static final native long OcrEngineBase_getTimingStats();

    public static final native long OcrEngineInternalSettings_createFromFilesystem(String s);

    public static final native long OcrEngineSession_SWIGUpcast(long l);

    public static final native void OcrEngineSession_change_ownership(OcrEngineSession ocrenginesession, long l, boolean flag);

    public static final native void OcrEngineSession_director_connect(OcrEngineSession ocrenginesession, long l, boolean flag, boolean flag1);

    public static final native long OcrEngineSession_processImageData__SWIG_0(long l, OcrEngineSession ocrenginesession, byte abyte0[], long l1, OcrEngineSettings ocrenginesettings);

    public static final native long OcrEngineSession_processImageData__SWIG_1(long l, OcrEngineSession ocrenginesession, byte abyte0[]);

    public static final native long OcrEngineSession_processImageFile__SWIG_0(long l, OcrEngineSession ocrenginesession, String s, long l1, OcrEngineSettings ocrenginesettings);

    public static final native long OcrEngineSession_processImageFile__SWIG_1(long l, OcrEngineSession ocrenginesession, String s);

    public static final native boolean OcrEngineSettings_getAmexCVVRecognitionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_getCheckChinaUnionPayLuhnCodeFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_getCheckUmpFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_getExpiryContextCorrectionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_getExpiryRecognitionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native int OcrEngineSettings_getFocusThreshold(long l, OcrEngineSettings ocrenginesettings);

    public static final native int OcrEngineSettings_getIntensityThreshold(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_getLogoAnalysisFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_getNameContextCorrectionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_getNameRecognitionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_getNumberContextCorrectionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native int OcrEngineSettings_getNumberOfQuadranglesToProcess(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_getNumberRecognitionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native long OcrEngineSettings_getPreDetectedQuadrangles(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_getRawSecondLineRecognitionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_getServerModeFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_getUkSortCodeAccountNumberContextCorrectionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_getUkSortCodeAccountNumberRecognitionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_getUpturnedCardDetectionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_getUseAdvAcceptDictFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenAmexCVVRecognitionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenCheckChinaUnionPayLuhnCodeFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenCheckUmpFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenExpiryContextCorrectionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenExpiryRecognitionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenFocusThreshold(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenIntensityThreshold(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenLogoAnalysisFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenNameContextCorrectionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenNameRecognitionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenNumberContextCorrectionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenNumberOfQuadranglesToProcess(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenNumberRecognitionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenPreDetectedQuadrangles(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenRawSecondLineRecognitionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenServerModeFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenUkSortCodeAccountNumberContextCorrectionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenUkSortCodeAccountNumberRecognitionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenUpturnedCardDetectionFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native boolean OcrEngineSettings_isOverridenUseAdvAcceptDictFlag(long l, OcrEngineSettings ocrenginesettings);

    public static final native void OcrEngineSettings_setAmexCVVRecognitionFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native void OcrEngineSettings_setCheckChinaUnionPayLuhnCodeFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native void OcrEngineSettings_setCheckUmpFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native void OcrEngineSettings_setExpiryContextCorrectionFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native void OcrEngineSettings_setExpiryRecognitionFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native void OcrEngineSettings_setFocusThreshold(long l, OcrEngineSettings ocrenginesettings, int i);

    public static final native void OcrEngineSettings_setIntensityThreshold(long l, OcrEngineSettings ocrenginesettings, int i);

    public static final native void OcrEngineSettings_setLogoAnalysisFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native void OcrEngineSettings_setNameContextCorrectionFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native void OcrEngineSettings_setNameRecognitionFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native void OcrEngineSettings_setNumberContextCorrectionFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native void OcrEngineSettings_setNumberOfQuadranglesToProcess(long l, OcrEngineSettings ocrenginesettings, int i);

    public static final native void OcrEngineSettings_setNumberRecognitionFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native void OcrEngineSettings_setPreDetectedQuadrangles(long l, OcrEngineSettings ocrenginesettings, long l1, OcrQuadrangleVector ocrquadranglevector);

    public static final native void OcrEngineSettings_setRawSecondLineRecognitionFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native void OcrEngineSettings_setServerModeFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native void OcrEngineSettings_setUkSortCodeAccountNumberContextCorrectionFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native void OcrEngineSettings_setUkSortCodeAccountNumberRecognitionFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native void OcrEngineSettings_setUpturnedCardDetectionFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native void OcrEngineSettings_setUseAdvAcceptDictFlag(long l, OcrEngineSettings ocrenginesettings, boolean flag);

    public static final native long OcrEngine_SWIGUpcast(long l);

    public static final native void OcrEngine_change_ownership(OcrEngine ocrengine, long l, boolean flag);

    public static final native long OcrEngine_createSession__SWIG_0(long l, OcrEngine ocrengine, long l1, ResultAcceptorInterface resultacceptorinterface);

    public static final native long OcrEngine_createSession__SWIG_1(long l, OcrEngine ocrengine);

    public static final native void OcrEngine_director_connect(OcrEngine ocrengine, long l, boolean flag, boolean flag1);

    public static final native String OcrField_getAsString(long l, OcrField ocrfield);

    public static final native long OcrField_getConfidence(long l, OcrField ocrfield);

    public static final native long OcrField_getLength(long l, OcrField ocrfield);

    public static final native long OcrField_getOcrCharVariants(long l, OcrField ocrfield);

    public static final native boolean OcrField_getToAcceptFlag(long l, OcrField ocrfield);

    public static final native int OcrLogoTypeUnknown_get();

    public static final native int OcrPoint_getX(long l, OcrPoint ocrpoint);

    public static final native int OcrPoint_getY(long l, OcrPoint ocrpoint);

    public static final native void OcrQuadrangleVector_add(long l, OcrQuadrangleVector ocrquadranglevector, long l1, OcrQuadrangle ocrquadrangle);

    public static final native long OcrQuadrangleVector_capacity(long l, OcrQuadrangleVector ocrquadranglevector);

    public static final native void OcrQuadrangleVector_clear(long l, OcrQuadrangleVector ocrquadranglevector);

    public static final native long OcrQuadrangleVector_get(long l, OcrQuadrangleVector ocrquadranglevector, int i);

    public static final native boolean OcrQuadrangleVector_isEmpty(long l, OcrQuadrangleVector ocrquadranglevector);

    public static final native void OcrQuadrangleVector_reserve(long l, OcrQuadrangleVector ocrquadranglevector, long l1);

    public static final native void OcrQuadrangleVector_set(long l, OcrQuadrangleVector ocrquadranglevector, int i, long l1, OcrQuadrangle ocrquadrangle);

    public static final native long OcrQuadrangleVector_size(long l, OcrQuadrangleVector ocrquadranglevector);

    public static final native long OcrQuadrangle_getBottomLeft(long l, OcrQuadrangle ocrquadrangle);

    public static final native long OcrQuadrangle_getBottomRight(long l, OcrQuadrangle ocrquadrangle);

    public static final native long OcrQuadrangle_getTopLeft(long l, OcrQuadrangle ocrquadrangle);

    public static final native long OcrQuadrangle_getTopRight(long l, OcrQuadrangle ocrquadrangle);

    public static final native long OcrResult_getAmexCVV(long l, OcrResult ocrresult);

    public static final native long OcrResult_getCardExpiry(long l, OcrResult ocrresult);

    public static final native long OcrResult_getCardName(long l, OcrResult ocrresult);

    public static final native long OcrResult_getCardNumber(long l, OcrResult ocrresult);

    public static final native long OcrResult_getCardQuadrangle(long l, OcrResult ocrresult);

    public static final native int OcrResult_getLogoType(long l, OcrResult ocrresult);

    public static final native int OcrResult_getOrientation(long l, OcrResult ocrresult);

    public static final native long OcrResult_getRawSecondLine(long l, OcrResult ocrresult);

    public static final native boolean OcrResult_getShouldBeDiscardedFlag(long l, OcrResult ocrresult);

    public static final native long OcrResult_getUkAccountNumber(long l, OcrResult ocrresult);

    public static final native long OcrResult_getUkSortCode(long l, OcrResult ocrresult);

    public static final native boolean OcrResult_getUmpCardFlag(long l, OcrResult ocrresult);

    public static final native boolean OcrResult_getUpturnedCardFlag(long l, OcrResult ocrresult);

    public static final native void OcrTimingRecordVector_add(long l, OcrTimingRecordVector ocrtimingrecordvector, long l1, OcrTimingRecord ocrtimingrecord);

    public static final native long OcrTimingRecordVector_capacity(long l, OcrTimingRecordVector ocrtimingrecordvector);

    public static final native void OcrTimingRecordVector_clear(long l, OcrTimingRecordVector ocrtimingrecordvector);

    public static final native long OcrTimingRecordVector_get(long l, OcrTimingRecordVector ocrtimingrecordvector, int i);

    public static final native boolean OcrTimingRecordVector_isEmpty(long l, OcrTimingRecordVector ocrtimingrecordvector);

    public static final native void OcrTimingRecordVector_reserve(long l, OcrTimingRecordVector ocrtimingrecordvector, long l1);

    public static final native void OcrTimingRecordVector_set(long l, OcrTimingRecordVector ocrtimingrecordvector, int i, long l1, OcrTimingRecord ocrtimingrecord);

    public static final native long OcrTimingRecordVector_size(long l, OcrTimingRecordVector ocrtimingrecordvector);

    public static final native long OcrTimingRecord_getCallCount(long l, OcrTimingRecord ocrtimingrecord);

    public static final native String OcrTimingRecord_getComment(long l, OcrTimingRecord ocrtimingrecord);

    public static final native String OcrTimingRecord_getName(long l, OcrTimingRecord ocrtimingrecord);

    public static final native double OcrTimingRecord_getTotalTime(long l, OcrTimingRecord ocrtimingrecord);

    public static final native boolean ResultAcceptorInterfaceSettings_getOcrEnabledFlag(long l, ResultAcceptorInterfaceSettings resultacceptorinterfacesettings, int i);

    public static final native void ResultAcceptorInterfaceSettings_setAllOcrEnabledFlag(long l, ResultAcceptorInterfaceSettings resultacceptorinterfacesettings, boolean flag);

    public static final native void ResultAcceptorInterfaceSettings_setOcrEnabledFlag(long l, ResultAcceptorInterfaceSettings resultacceptorinterfacesettings, int i, boolean flag);

    public static final native void ResultAcceptorInterface_accept(long l, ResultAcceptorInterface resultacceptorinterface, int i, long l1, OcrCharStringVector ocrcharstringvector, int j, 
            int k, long l2, ResultAcceptorInterfaceSettings resultacceptorinterfacesettings, boolean flag);

    public static final native void ResultAcceptorInterface_acceptSwigExplicitResultAcceptorInterface(long l, ResultAcceptorInterface resultacceptorinterface, int i, long l1, OcrCharStringVector ocrcharstringvector, int j, 
            int k, long l2, ResultAcceptorInterfaceSettings resultacceptorinterfacesettings, boolean flag);

    public static final native void ResultAcceptorInterface_change_ownership(ResultAcceptorInterface resultacceptorinterface, long l, boolean flag);

    public static final native void ResultAcceptorInterface_director_connect(ResultAcceptorInterface resultacceptorinterface, long l, boolean flag, boolean flag1);

    public static void SwigDirector_ResultAcceptorInterface_accept(ResultAcceptorInterface resultacceptorinterface, int i, long l, int j, int k, long l1, 
            boolean flag)
    {
        resultacceptorinterface.accept(ResultAcceptorInterfaceSettings.FieldName.swigToEnum(i), new OcrCharStringVector(l, false), j, k, new ResultAcceptorInterfaceSettings(l1, false), flag);
    }

    public static final native int YuvUtils_yuv2rgb(byte abyte0[], byte abyte1[], int i, int j);

    public static final native int YuvUtils_yuvCutRotateScale2rgb(byte abyte0[], int i, int j, int k, int l, int i1, int j1, byte abyte1[], 
            int k1, int l1, int i2);

    public static final native void delete_ConversionUtils(long l);

    public static final native void delete_DetectionEngine(long l);

    public static final native void delete_DetectionInternalSettings(long l);

    public static final native void delete_DetectionInternalSettingsFactory(long l);

    public static final native void delete_DetectionResult(long l);

    public static final native void delete_DetectionSettings(long l);

    public static final native void delete_ImageCheck(long l);

    public static final native void delete_OcrChar(long l);

    public static final native void delete_OcrCharStringVector(long l);

    public static final native void delete_OcrCharVariants(long l);

    public static final native void delete_OcrCharVector(long l);

    public static final native void delete_OcrConfidence(long l);

    public static final native void delete_OcrEngine(long l);

    public static final native void delete_OcrEngineBase(long l);

    public static final native void delete_OcrEngineBaseSession(long l);

    public static final native void delete_OcrEngineInternalSettings(long l);

    public static final native void delete_OcrEngineSession(long l);

    public static final native void delete_OcrEngineSettings(long l);

    public static final native void delete_OcrField(long l);

    public static final native void delete_OcrPoint(long l);

    public static final native void delete_OcrQuadrangle(long l);

    public static final native void delete_OcrQuadrangleVector(long l);

    public static final native void delete_OcrResult(long l);

    public static final native void delete_OcrTimingRecord(long l);

    public static final native void delete_OcrTimingRecordVector(long l);

    public static final native void delete_ResultAcceptorInterface(long l);

    public static final native void delete_ResultAcceptorInterfaceSettings(long l);

    public static final native void delete_YuvUtils(long l);

    public static final native long new_ConversionUtils();

    public static final native long new_DetectionEngine(long l, DetectionSettings detectionsettings, long l1, DetectionInternalSettings detectioninternalsettings);

    public static final native long new_DetectionInternalSettings();

    public static final native long new_DetectionInternalSettingsFactory();

    public static final native long new_DetectionResult__SWIG_0();

    public static final native long new_DetectionResult__SWIG_1(boolean flag, boolean flag1, int i, boolean flag2, boolean flag3, boolean flag4, boolean flag5, long l, OcrPoint ocrpoint, long l1, OcrPoint ocrpoint1, boolean flag6, long l2, OcrQuadrangle ocrquadrangle);

    public static final native long new_DetectionSettings();

    public static final native long new_ImageCheck();

    public static final native long new_OcrCharStringVector__SWIG_0();

    public static final native long new_OcrCharStringVector__SWIG_1(long l);

    public static final native long new_OcrCharVariants__SWIG_0();

    public static final native long new_OcrCharVariants__SWIG_1(long l, OcrQuadrangle ocrquadrangle, int i);

    public static final native long new_OcrCharVector__SWIG_0();

    public static final native long new_OcrCharVector__SWIG_1(long l);

    public static final native long new_OcrChar__SWIG_0();

    public static final native long new_OcrChar__SWIG_1(char c, double d);

    public static final native long new_OcrConfidence(double d, double d1);

    public static final native long new_OcrEngine(long l, OcrEngineInternalSettings ocrengineinternalsettings);

    public static final native long new_OcrEngineBase(long l, OcrEngineInternalSettings ocrengineinternalsettings);

    public static final native long new_OcrEngineSettings__SWIG_0();

    public static final native long new_OcrEngineSettings__SWIG_1(long l, OcrEngineSettings ocrenginesettings);

    public static final native long new_OcrField__SWIG_0(long l, OcrCharStringVector ocrcharstringvector, boolean flag);

    public static final native long new_OcrField__SWIG_1(long l, OcrField ocrfield);

    public static final native long new_OcrPoint__SWIG_0(int i, int j);

    public static final native long new_OcrPoint__SWIG_1(int i);

    public static final native long new_OcrPoint__SWIG_2();

    public static final native long new_OcrQuadrangleVector__SWIG_0();

    public static final native long new_OcrQuadrangleVector__SWIG_1(long l);

    public static final native long new_OcrQuadrangle__SWIG_0();

    public static final native long new_OcrQuadrangle__SWIG_1(long l, OcrPoint ocrpoint, long l1, OcrPoint ocrpoint1, long l2, 
            OcrPoint ocrpoint2, long l3, OcrPoint ocrpoint3);

    public static final native long new_OcrResult(long l, OcrField ocrfield, long l1, OcrField ocrfield1, long l2, 
            OcrField ocrfield2, long l3, OcrField ocrfield3, long l4, OcrField ocrfield4, 
            long l5, OcrField ocrfield5, long l6, OcrField ocrfield6, long l7, OcrQuadrangle ocrquadrangle, boolean flag, boolean flag1, int i, boolean flag2);

    public static final native long new_OcrTimingRecordVector__SWIG_0();

    public static final native long new_OcrTimingRecordVector__SWIG_1(long l);

    public static final native long new_OcrTimingRecord__SWIG_0();

    public static final native long new_OcrTimingRecord__SWIG_1(double d, long l, String s, String s1);

    public static final native long new_ResultAcceptorInterface();

    public static final native long new_ResultAcceptorInterfaceSettings__SWIG_0();

    public static final native long new_ResultAcceptorInterfaceSettings__SWIG_1(long l, ResultAcceptorInterfaceSettings resultacceptorinterfacesettings);

    public static final native long new_YuvUtils();

    private static final native void swig_module_init();

    static 
    {
        swig_module_init();
    }
}
