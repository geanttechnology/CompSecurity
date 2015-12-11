// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            FrameQueue, TemplateInfo, FrameProcessingCallbackTemplateMatcher, LivenessDetectorResult, 
//            LivenessDetectorCallback, FaceRect, FrameProcessingSettingsTemplateMatcher, FrameProcessorLivenessDetector, 
//            LibImage, FrameProcessorManager, FrameProcessorTemplateMatcher, FrameProcessor, 
//            FramesVector, HierarchicalClusteringSettings, LandmarkPoint, LandmarkVector, 
//            StringVector, TemplatePolygon, Uint8Array

public class jniLivenessAndTMJNI
{

    public jniLivenessAndTMJNI()
    {
    }

    public static final native int FaceRect_getHeight(long l, FaceRect facerect);

    public static final native int FaceRect_getWidth(long l, FaceRect facerect);

    public static final native int FaceRect_getX(long l, FaceRect facerect);

    public static final native int FaceRect_getY(long l, FaceRect facerect);

    public static final native void FaceRect_setHeight(long l, FaceRect facerect, int i);

    public static final native void FaceRect_setWidth(long l, FaceRect facerect, int i);

    public static final native void FaceRect_setX(long l, FaceRect facerect, int i);

    public static final native void FaceRect_setY(long l, FaceRect facerect, int i);

    public static final native void FrameProcessingCallbackTemplateMatcher_change_ownership(FrameProcessingCallbackTemplateMatcher frameprocessingcallbacktemplatematcher, long l, boolean flag);

    public static final native void FrameProcessingCallbackTemplateMatcher_director_connect(FrameProcessingCallbackTemplateMatcher frameprocessingcallbacktemplatematcher, long l, boolean flag, boolean flag1);

    public static final native void FrameProcessingCallbackTemplateMatcher_finalResult(long l, FrameProcessingCallbackTemplateMatcher frameprocessingcallbacktemplatematcher, long l1, FrameQueue framequeue, long l2, 
            TemplateInfo templateinfo);

    public static final native void FrameProcessingCallbackTemplateMatcher_intermediateResult(long l, FrameProcessingCallbackTemplateMatcher frameprocessingcallbacktemplatematcher, long l1, FrameQueue framequeue, long l2, 
            TemplateInfo templateinfo);

    public static final native void FrameProcessingCallbackTemplateMatcher_noResult(long l, FrameProcessingCallbackTemplateMatcher frameprocessingcallbacktemplatematcher, long l1, FrameQueue framequeue);

    public static final native void FrameProcessingCallbackTemplateMatcher_noResultSwigExplicitFrameProcessingCallbackTemplateMatcher(long l, FrameProcessingCallbackTemplateMatcher frameprocessingcallbacktemplatematcher, long l1, FrameQueue framequeue);

    public static final native long FrameProcessingSettingsTemplateMatcher_getClusteringSettings(long l, FrameProcessingSettingsTemplateMatcher frameprocessingsettingstemplatematcher);

    public static final native int FrameProcessingSettingsTemplateMatcher_getMaxKeyPointsToDetect(long l, FrameProcessingSettingsTemplateMatcher frameprocessingsettingstemplatematcher);

    public static final native int FrameProcessingSettingsTemplateMatcher_getNumImagesToKeep(long l, FrameProcessingSettingsTemplateMatcher frameprocessingsettingstemplatematcher);

    public static final native int FrameProcessingSettingsTemplateMatcher_getNumSuccessMatchesToComplete(long l, FrameProcessingSettingsTemplateMatcher frameprocessingsettingstemplatematcher);

    public static final native boolean FrameProcessingSettingsTemplateMatcher_getUseClustring(long l, FrameProcessingSettingsTemplateMatcher frameprocessingsettingstemplatematcher);

    public static final native long FrameProcessorLivenessDetector_SWIGSmartPtrUpcast(long l);

    public static final native void FrameProcessorLivenessDetector_pushFrame(long l, FrameProcessorLivenessDetector frameprocessorlivenessdetector, long l1, LibImage libimage, int i);

    public static final native void FrameProcessorManager_pushFrame(long l, FrameProcessorManager frameprocessormanager, byte abyte0[], long l1, int i, int j, 
            int k, int i1, int j1, int k1, int i2);

    public static final native void FrameProcessorManager_reset(long l, FrameProcessorManager frameprocessormanager);

    public static final native long FrameProcessorTemplateMatcher_SWIGSmartPtrUpcast(long l);

    public static final native boolean FrameProcessorTemplateMatcher_addTemplatesFromBinaryFile(long l, FrameProcessorTemplateMatcher frameprocessortemplatematcher, String s);

    public static final native void FrameProcessorTemplateMatcher_clearAllTemplates(long l, FrameProcessorTemplateMatcher frameprocessortemplatematcher);

    public static final native boolean FrameProcessorTemplateMatcher_detectSingleFrame(long l, FrameProcessorTemplateMatcher frameprocessortemplatematcher, long l1, LibImage libimage, long l2, 
            TemplateInfo templateinfo);

    public static final native void FrameProcessorTemplateMatcher_discardFrameByID(long l, FrameProcessorTemplateMatcher frameprocessortemplatematcher, int i);

    public static final native void FrameProcessor_pushFrame(long l, FrameProcessor frameprocessor, long l1, LibImage libimage);

    public static final native void FrameProcessor_reset(long l, FrameProcessor frameprocessor);

    public static final native void FrameQueue_clear(long l, FrameQueue framequeue);

    public static final native void FrameQueue_getAllFrames(long l, FrameQueue framequeue, long l1, FramesVector framesvector);

    public static final native long FrameQueue_getFrameByID(long l, FrameQueue framequeue, int i);

    public static final native void FrameQueue_getFramesInRange(long l, FrameQueue framequeue, int i, int j, long l1, FramesVector framesvector);

    public static final native long FrameQueue_lastFrame(long l, FrameQueue framequeue);

    public static final native void FrameQueue_pushFrame(long l, FrameQueue framequeue, long l1, LibImage libimage);

    public static final native boolean FrameQueue_removeFrameByID(long l, FrameQueue framequeue, int i);

    public static final native long FrameQueue_size(long l, FrameQueue framequeue);

    public static final native void FramesVector_add(long l, FramesVector framesvector, long l1, LibImage libimage);

    public static final native long FramesVector_capacity(long l, FramesVector framesvector);

    public static final native void FramesVector_clear(long l, FramesVector framesvector);

    public static final native long FramesVector_get(long l, FramesVector framesvector, int i);

    public static final native boolean FramesVector_isEmpty(long l, FramesVector framesvector);

    public static final native void FramesVector_reserve(long l, FramesVector framesvector, long l1);

    public static final native void FramesVector_set(long l, FramesVector framesvector, int i, long l1, LibImage libimage);

    public static final native long FramesVector_size(long l, FramesVector framesvector);

    public static final native String GetCollectedPerformanceStatistics();

    public static final native int HierarchicalClusteringSettings_getBranching(long l, HierarchicalClusteringSettings hierarchicalclusteringsettings);

    public static final native int HierarchicalClusteringSettings_getLeafMaxSize(long l, HierarchicalClusteringSettings hierarchicalclusteringsettings);

    public static final native int HierarchicalClusteringSettings_getMaxChecks(long l, HierarchicalClusteringSettings hierarchicalclusteringsettings);

    public static final native int HierarchicalClusteringSettings_getTrees(long l, HierarchicalClusteringSettings hierarchicalclusteringsettings);

    public static final native int IMAGE_ORIENTATION_LANDSCAPE_get();

    public static final native void ImgWarp_warp(byte abyte0[], long l, int i, int j, int k, float f, float f1, 
            float f2, float f3, float f4, float f5, float f6, float f7, byte abyte1[], 
            int i1, int j1);

    public static final native float LandmarkPoint_getX(long l, LandmarkPoint landmarkpoint);

    public static final native float LandmarkPoint_getY(long l, LandmarkPoint landmarkpoint);

    public static final native void LandmarkVector_add(long l, LandmarkVector landmarkvector, long l1, LandmarkPoint landmarkpoint);

    public static final native long LandmarkVector_capacity(long l, LandmarkVector landmarkvector);

    public static final native void LandmarkVector_clear(long l, LandmarkVector landmarkvector);

    public static final native long LandmarkVector_get(long l, LandmarkVector landmarkvector, int i);

    public static final native boolean LandmarkVector_isEmpty(long l, LandmarkVector landmarkvector);

    public static final native void LandmarkVector_reserve(long l, LandmarkVector landmarkvector, long l1);

    public static final native void LandmarkVector_set(long l, LandmarkVector landmarkvector, int i, long l1, LandmarkPoint landmarkpoint);

    public static final native long LandmarkVector_size(long l, LandmarkVector landmarkvector);

    public static final native int LibImage_getChannelDepth(long l, LibImage libimage);

    public static final native int LibImage_getChannels(long l, LibImage libimage);

    public static final native int LibImage_getFormat(long l, LibImage libimage);

    public static final native long LibImage_getFrameBuffer__SWIG_0(long l, LibImage libimage);

    public static final native void LibImage_getFrameBuffer__SWIG_1(long l, LibImage libimage, byte abyte0[]);

    public static final native int LibImage_getFrameIndex(long l, LibImage libimage);

    public static final native int LibImage_getHeight(long l, LibImage libimage);

    public static final native long LibImage_getStride(long l, LibImage libimage);

    public static final native int LibImage_getTimeStamp(long l, LibImage libimage);

    public static final native int LibImage_getWidth(long l, LibImage libimage);

    public static final native void LivenessDetectorCallback_change_ownership(LivenessDetectorCallback livenessdetectorcallback, long l, boolean flag);

    public static final native void LivenessDetectorCallback_director_connect(LivenessDetectorCallback livenessdetectorcallback, long l, boolean flag, boolean flag1);

    public static final native void LivenessDetectorCallback_onResult(long l, LivenessDetectorCallback livenessdetectorcallback, long l1, LivenessDetectorResult livenessdetectorresult, int i);

    public static final native void LivenessDetectorCallback_onResultSwigExplicitLivenessDetectorCallback(long l, LivenessDetectorCallback livenessdetectorcallback, long l1, LivenessDetectorResult livenessdetectorresult, int i);

    public static final native long LivenessDetectorResult_getFaceRect(long l, LivenessDetectorResult livenessdetectorresult);

    public static final native long LivenessDetectorResult_getLandmarkPoints(long l, LivenessDetectorResult livenessdetectorresult);

    public static final native boolean LivenessDetectorResult_isLeftEyeBlinking(long l, LivenessDetectorResult livenessdetectorresult);

    public static final native boolean LivenessDetectorResult_isRightEyeBlinking(long l, LivenessDetectorResult livenessdetectorresult);

    public static final native boolean LivenessDetectorResult_isSmiling(long l, LivenessDetectorResult livenessdetectorresult);

    public static final native boolean LivenessDetectorResult_isTooLargeMovement(long l, LivenessDetectorResult livenessdetectorresult);

    public static final native boolean LivenessDetectorResult_isTracking(long l, LivenessDetectorResult livenessdetectorresult);

    public static final native void StringVector_add(long l, StringVector stringvector, String s);

    public static final native long StringVector_capacity(long l, StringVector stringvector);

    public static final native void StringVector_clear(long l, StringVector stringvector);

    public static final native String StringVector_get(long l, StringVector stringvector, int i);

    public static final native boolean StringVector_isEmpty(long l, StringVector stringvector);

    public static final native void StringVector_reserve(long l, StringVector stringvector, long l1);

    public static final native void StringVector_set(long l, StringVector stringvector, int i, String s);

    public static final native long StringVector_size(long l, StringVector stringvector);

    public static void SwigDirector_FrameProcessingCallbackTemplateMatcher_finalResult(FrameProcessingCallbackTemplateMatcher frameprocessingcallbacktemplatematcher, long l, long l1)
    {
        frameprocessingcallbacktemplatematcher.finalResult(new FrameQueue(l, false), new TemplateInfo(l1, false));
    }

    public static void SwigDirector_FrameProcessingCallbackTemplateMatcher_intermediateResult(FrameProcessingCallbackTemplateMatcher frameprocessingcallbacktemplatematcher, long l, long l1)
    {
        frameprocessingcallbacktemplatematcher.intermediateResult(new FrameQueue(l, false), new TemplateInfo(l1, false));
    }

    public static void SwigDirector_FrameProcessingCallbackTemplateMatcher_noResult(FrameProcessingCallbackTemplateMatcher frameprocessingcallbacktemplatematcher, long l)
    {
        frameprocessingcallbacktemplatematcher.noResult(new FrameQueue(l, false));
    }

    public static void SwigDirector_LivenessDetectorCallback_onResult(LivenessDetectorCallback livenessdetectorcallback, long l, int i)
    {
        livenessdetectorcallback.onResult(new LivenessDetectorResult(l, false), i);
    }

    public static final native String TemplateInfo_getCountry(long l, TemplateInfo templateinfo);

    public static final native String TemplateInfo_getDocumentType(long l, TemplateInfo templateinfo);

    public static final native int TemplateInfo_getFrameIndex(long l, TemplateInfo templateinfo);

    public static final native int TemplateInfo_getMatchesCount(long l, TemplateInfo templateinfo);

    public static final native long TemplateInfo_getPolygon(long l, TemplateInfo templateinfo);

    public static final native String TemplateInfo_getRegion(long l, TemplateInfo templateinfo);

    public static final native String TemplateInfo_getState(long l, TemplateInfo templateinfo);

    public static final native int TemplateInfo_getTemplateHeight(long l, TemplateInfo templateinfo);

    public static final native int TemplateInfo_getTemplateWidth(long l, TemplateInfo templateinfo);

    public static final native double TemplateInfo_getTransformError(long l, TemplateInfo templateinfo);

    public static final native void TemplateInfo_setCountry(long l, TemplateInfo templateinfo, String s);

    public static final native void TemplateInfo_setDocumentType(long l, TemplateInfo templateinfo, String s);

    public static final native void TemplateInfo_setFrameIndex(long l, TemplateInfo templateinfo, int i);

    public static final native void TemplateInfo_setMatchesCount(long l, TemplateInfo templateinfo, int i);

    public static final native void TemplateInfo_setPolygon(long l, TemplateInfo templateinfo, long l1, TemplatePolygon templatepolygon);

    public static final native void TemplateInfo_setRegion(long l, TemplateInfo templateinfo, String s);

    public static final native void TemplateInfo_setState(long l, TemplateInfo templateinfo, String s);

    public static final native void TemplateInfo_setTemplateHeight(long l, TemplateInfo templateinfo, int i);

    public static final native void TemplateInfo_setTemplateWidth(long l, TemplateInfo templateinfo, int i);

    public static final native void TemplateInfo_setTransformError(long l, TemplateInfo templateinfo, double d);

    public static final native float TemplatePolygon_getBLx(long l, TemplatePolygon templatepolygon);

    public static final native float TemplatePolygon_getBLy(long l, TemplatePolygon templatepolygon);

    public static final native float TemplatePolygon_getBRx(long l, TemplatePolygon templatepolygon);

    public static final native float TemplatePolygon_getBRy(long l, TemplatePolygon templatepolygon);

    public static final native float TemplatePolygon_getTLx(long l, TemplatePolygon templatepolygon);

    public static final native float TemplatePolygon_getTLy(long l, TemplatePolygon templatepolygon);

    public static final native float TemplatePolygon_getTRx(long l, TemplatePolygon templatepolygon);

    public static final native float TemplatePolygon_getTRy(long l, TemplatePolygon templatepolygon);

    public static final native void TemplatePolygon_setBLx(long l, TemplatePolygon templatepolygon, float f);

    public static final native void TemplatePolygon_setBLy(long l, TemplatePolygon templatepolygon, float f);

    public static final native void TemplatePolygon_setBRx(long l, TemplatePolygon templatepolygon, float f);

    public static final native void TemplatePolygon_setBRy(long l, TemplatePolygon templatepolygon, float f);

    public static final native void TemplatePolygon_setTLx(long l, TemplatePolygon templatepolygon, float f);

    public static final native void TemplatePolygon_setTLy(long l, TemplatePolygon templatepolygon, float f);

    public static final native void TemplatePolygon_setTRx(long l, TemplatePolygon templatepolygon, float f);

    public static final native void TemplatePolygon_setTRy(long l, TemplatePolygon templatepolygon, float f);

    public static final native long Uint8Array_cast(long l, Uint8Array uint8array);

    public static final native long Uint8Array_frompointer(long l);

    public static final native short Uint8Array_getitem(long l, Uint8Array uint8array, int i);

    public static final native void Uint8Array_setitem(long l, Uint8Array uint8array, int i, short word0);

    public static final native void delete_FaceRect(long l);

    public static final native void delete_FrameProcessingSettingsTemplateMatcher(long l);

    public static final native void delete_FrameProcessor(long l);

    public static final native void delete_FrameProcessorLivenessDetector(long l);

    public static final native void delete_FrameProcessorManager(long l);

    public static final native void delete_FrameProcessorTemplateMatcher(long l);

    public static final native void delete_FrameQueue(long l);

    public static final native void delete_FramesVector(long l);

    public static final native void delete_HierarchicalClusteringSettings(long l);

    public static final native void delete_ImgWarp(long l);

    public static final native void delete_LandmarkPoint(long l);

    public static final native void delete_LandmarkVector(long l);

    public static final native void delete_LibImage(long l);

    public static final native void delete_LivenessDetectorCallback(long l);

    public static final native void delete_LivenessDetectorResult(long l);

    public static final native void delete_StringVector(long l);

    public static final native void delete_TemplateInfo(long l);

    public static final native void delete_TemplatePolygon(long l);

    public static final native void delete_Uint8Array(long l);

    public static final native long make_async(long l);

    public static final native long new_FaceRect__SWIG_0(int i, int j, int k, int l);

    public static final native long new_FaceRect__SWIG_1(int i, int j, int k);

    public static final native long new_FaceRect__SWIG_2(int i, int j);

    public static final native long new_FaceRect__SWIG_3(int i);

    public static final native long new_FaceRect__SWIG_4();

    public static final native long new_FrameProcessingCallbackTemplateMatcher();

    public static final native long new_FrameProcessingSettingsTemplateMatcher__SWIG_0(int i, boolean flag, long l, HierarchicalClusteringSettings hierarchicalclusteringsettings, int j, int k);

    public static final native long new_FrameProcessingSettingsTemplateMatcher__SWIG_1(int i, boolean flag, long l, HierarchicalClusteringSettings hierarchicalclusteringsettings, int j);

    public static final native long new_FrameProcessingSettingsTemplateMatcher__SWIG_2(int i, boolean flag, long l, HierarchicalClusteringSettings hierarchicalclusteringsettings);

    public static final native long new_FrameProcessingSettingsTemplateMatcher__SWIG_3(int i, boolean flag);

    public static final native long new_FrameProcessingSettingsTemplateMatcher__SWIG_4(int i);

    public static final native long new_FrameProcessingSettingsTemplateMatcher__SWIG_5();

    public static final native long new_FrameProcessorLivenessDetector(long l, LivenessDetectorCallback livenessdetectorcallback, String s);

    public static final native long new_FrameProcessorManager__SWIG_0(long l);

    public static final native long new_FrameProcessorManager__SWIG_1(long l, long l1);

    public static final native long new_FrameProcessorManager__SWIG_2(long l, long l1, long l2);

    public static final native long new_FrameProcessorTemplateMatcher(long l, FrameProcessingSettingsTemplateMatcher frameprocessingsettingstemplatematcher, long l1, FrameProcessingCallbackTemplateMatcher frameprocessingcallbacktemplatematcher);

    public static final native long new_FrameQueue(long l);

    public static final native long new_FramesVector__SWIG_0();

    public static final native long new_FramesVector__SWIG_1(long l);

    public static final native long new_HierarchicalClusteringSettings__SWIG_0(int i, int j, int k, int l);

    public static final native long new_HierarchicalClusteringSettings__SWIG_1(int i, int j, int k);

    public static final native long new_HierarchicalClusteringSettings__SWIG_2(int i, int j);

    public static final native long new_HierarchicalClusteringSettings__SWIG_3(int i);

    public static final native long new_HierarchicalClusteringSettings__SWIG_4();

    public static final native long new_ImgWarp();

    public static final native long new_LandmarkPoint__SWIG_0(float f, float f1);

    public static final native long new_LandmarkPoint__SWIG_1(float f);

    public static final native long new_LandmarkPoint__SWIG_2();

    public static final native long new_LandmarkVector__SWIG_0();

    public static final native long new_LandmarkVector__SWIG_1(long l);

    public static final native long new_LibImage__SWIG_0(byte abyte0[], int i, int j, int k, long l, int i1, int j1, 
            int k1, int l1, boolean flag);

    public static final native long new_LibImage__SWIG_1(byte abyte0[], int i, int j, int k, long l, int i1, int j1, 
            int k1, int l1);

    public static final native long new_LivenessDetectorCallback();

    public static final native long new_LivenessDetectorResult__SWIG_0(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, long l, LandmarkVector landmarkvector, 
            long l1, FaceRect facerect);

    public static final native long new_LivenessDetectorResult__SWIG_1(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, long l, LandmarkVector landmarkvector);

    public static final native long new_LivenessDetectorResult__SWIG_2(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4);

    public static final native long new_LivenessDetectorResult__SWIG_3(boolean flag, boolean flag1, boolean flag2, boolean flag3);

    public static final native long new_LivenessDetectorResult__SWIG_4(boolean flag, boolean flag1, boolean flag2);

    public static final native long new_LivenessDetectorResult__SWIG_5(boolean flag, boolean flag1);

    public static final native long new_LivenessDetectorResult__SWIG_6(boolean flag);

    public static final native long new_LivenessDetectorResult__SWIG_7();

    public static final native long new_StringVector__SWIG_0();

    public static final native long new_StringVector__SWIG_1(long l);

    public static final native long new_TemplateInfo__SWIG_0();

    public static final native long new_TemplateInfo__SWIG_1(int i, String s, String s1, String s2, String s3, long l, TemplatePolygon templatepolygon, 
            int j, double d);

    public static final native long new_TemplatePolygon__SWIG_0();

    public static final native long new_TemplatePolygon__SWIG_1(float f, float f1, float f2, float f3, float f4, float f5, float f6, float f7);

    public static final native long new_Uint8Array(int i);

    private static final native void swig_module_init();

    static 
    {
        swig_module_init();
    }
}
