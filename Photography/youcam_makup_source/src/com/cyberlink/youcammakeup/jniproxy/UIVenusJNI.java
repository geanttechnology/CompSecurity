// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;

import com.pf.common.a;
import java.io.PrintStream;
import java.nio.ByteBuffer;

// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            f, d, ai, y, 
//            bm, ah, bl, bj, 
//            r, bn, bi, av, 
//            aj, ax, az, bk, 
//            s, aa, ad, z, 
//            ab, ac, ak, af, 
//            ag, ae, am, al, 
//            au, at, bb, bc

public class UIVenusJNI
{

    public static final native int CUIVenus_AnalyzeImage(long l, f f, long l1, d d);

    public static final native boolean CUIVenus_AnalyzeLiveImage(long l, f f, Object obj, Object obj1, int i, int j, int k, 
            int ai[], float f1, float f2, boolean flag);

    public static final native int CUIVenus_AutoDetectHairDyeMask(long l, f f, long l1, d d, long l2, 
            ai ai, long l3, y y);

    public static final native int CUIVenus_ChangeWigColor(long l, f f, long l1, bm bm, float f1);

    public static final native int CUIVenus_ContinueWarpWigInLocal(long l, f f, long l1, ah ah);

    public static final native boolean CUIVenus_DetectOpenMouth(long l, f f, long l1, ai ai);

    public static final native boolean CUIVenus_DumpWigOffsetData(long l, f f, String s);

    public static final native int CUIVenus_EndWarpWigInLocal(long l, f f, long l1, bl bl, long l2, 
            d d);

    public static final native int CUIVenus_ExtractUserProfile(long l, f f, long l1, bj bj);

    public static final native void CUIVenus_FlipWig(long l, f f, boolean flag);

    public static final native int CUIVenus_GenerateHairDyeThumbnail(long l, f f, long l1, d d, long l2, 
            r r);

    public static final native int CUIVenus_GetAutoWigLuminanceParameter(long l, f f, long l1, ai ai, long l2, 
            bn bn);

    public static final native int CUIVenus_GetEarringNaturalLookingModelAndTranslation(long l, f f, long l1, d d, long l2, 
            ah ah, long l3, ah ah1, long l4, ah ah2, 
            long l5, ah ah3, long l6, ai ai, long l7, y y, long l8, bi bi, long l9, 
            bi bi1);

    public static final native int CUIVenus_GetEyebrowOriginalColor(long l, f f, long l1, ai ai, long l2, 
            av av);

    public static final native int CUIVenus_GetEyewearNaturalLookingModelAndTranslation(long l, f f, long l1, d d, long l2, 
            ah ah, long l3, ah ah1, int i, long l4, 
            ai ai, long l5, y y, long l6, bi bi);

    public static final native int CUIVenus_GetFaceAlignmentData__SWIG_0(long l, f f, long l1, ai ai, long l2, 
            y y);

    public static final native boolean CUIVenus_GetFaceAlignmentData__SWIG_1(long l, f f, Object obj, Object obj1);

    public static final native int CUIVenus_GetFaceInfos__SWIG_0(long l, f f, int i, long l1, aj aj);

    public static final native boolean CUIVenus_GetFaceInfos__SWIG_1(long l, f f, Object obj, int i);

    public static final native boolean CUIVenus_GetFaceRectangle(long l, f f, Object obj);

    public static final native int CUIVenus_GetHairDyeMask(long l, f f, long l1, d d);

    public static final native int CUIVenus_GetHairbandNaturalLookingModelAndTranslation(long l, f f, long l1, d d, long l2, 
            ah ah, long l3, ah ah1, long l4, ai ai, 
            long l5, y y, long l6, bi bi);

    public static final native boolean CUIVenus_GetInternalModelState(long l, f f, Object obj);

    public static final native int CUIVenus_GetIrisRadius__SWIG_0(long l, f f, long l1, ai ai, long l2, 
            ax ax);

    public static final native boolean CUIVenus_GetIrisRadius__SWIG_1(long l, f f, Object obj, Object obj1);

    public static final native int CUIVenus_GetLookParameters(long l, f f, long l1, az az, int i, long l2, az az1);

    public static final native boolean CUIVenus_GetMakeupImage(long l, f f, long l1, d d, long l2, 
            d d1, long l3, bk bk);

    public static final native boolean CUIVenus_GetMakeupMetadata(long l, f f, Object aobj[], Object obj, Object obj1, Object obj2, Object obj3);

    public static final native int CUIVenus_GetNecklaceNaturalLookingModelAndTranslation(long l, f f, long l1, d d, long l2, 
            ah ah, long l3, ah ah1, long l4, ai ai, 
            long l5, y y, long l6, bi bi);

    public static final native int CUIVenus_GetWarpedWigModel(long l, f f, long l1, bl bl, long l2, 
            d d);

    public static final native void CUIVenus_InitialEyeModelCommonInfo(long l, f f, Object aobj[], int i, int j);

    public static final native boolean CUIVenus_IsLocalMoveWigDone(long l, f f);

    public static final native boolean CUIVenus_IsModelLoaded(long l, f f);

    public static final native boolean CUIVenus_LoadWigOffsetData(long l, f f, String s);

    public static final native boolean CUIVenus_MakeupLiveInitialize(long l, f f);

    public static final native boolean CUIVenus_MakeupLiveUnInitialize(long l, f f);

    public static final native int CUIVenus_ManualGetFaceAlignmentData(long l, f f, long l1, d d, long l2, 
            ah ah, long l3, ah ah1, long l4, ah ah2, 
            long l5, y y);

    public static final native boolean CUIVenus_PreprocessEyelashModel(long l, f f, byte abyte0[], Object aobj[], int i, int j, int k, 
            int i1, int j1);

    public static final native boolean CUIVenus_PreprocessEyelinerModel(long l, f f, byte abyte0[], Object aobj[], int i, int j, int k, 
            int i1, int j1);

    public static final native boolean CUIVenus_PreprocessEyeshadowModel(long l, f f, int ai[], Object aobj[], int ai1[], int ai2[], int i, 
            int j, int k, int i1, int j1, int ai3[], int k1, int l1, 
            int i2, byte abyte0[], byte abyte1[], byte abyte2[]);

    public static final native int CUIVenus_QueryHairDetectionProgress(long l, f f);

    public static final native void CUIVenus_RedoWarpWig(long l, f f);

    public static final native boolean CUIVenus_ReleaseMakeupBuffer(long l, f f);

    public static final native void CUIVenus_ReleaseWigOffsetData(long l, f f);

    public static final native void CUIVenus_ResetWarpWig(long l, f f);

    public static final native void CUIVenus_SendFrameBuffer(long l, f f, byte abyte0[], int i, int j, int k, boolean flag);

    public static final native int CUIVenus_SetHairDyeMask(long l, f f, long l1, d d);

    public static final native boolean CUIVenus_SetInternalModelPaths(long l, f f, String s, String s1);

    public static final native boolean CUIVenus_SetLipstickIntensity(long l, f f, int i);

    public static final native boolean CUIVenus_SetLipstickProfile(long l, f f, Object obj);

    public static final native void CUIVenus_SetSkinSmoothFilterStatus(long l, f f, boolean flag, float f1);

    public static final native int CUIVenus_SetUserProfileFolder(long l, f f, String s);

    public static final native int CUIVenus_StartWarpWigInLocal(long l, f f, long l1, bi bi, long l2, 
            ah ah);

    public static final native void CUIVenus_UndoWarpWig(long l, f f);

    public static final native int CUIVenus_UpdateHairDyeMask(long l, f f, long l1, d d, ByteBuffer bytebuffer, boolean flag, 
            int i);

    public static final native void CUIVenus_setIsHoudini(long l, f f, boolean flag);

    public static final native void UIColorVector_add(long l, s s, long l1, r r);

    public static final native void UIColor_setBLevel(long l, r r, int i);

    public static final native void UIColor_setGLevel(long l, r r, int i);

    public static final native void UIColor_setRLevel(long l, r r, int i);

    public static final native boolean UIFaceAlignmentData_equals(long l, y y, long l1, y y1);

    public static final native long UIFaceAlignmentData_getChin(long l, y y);

    public static final native long UIFaceAlignmentData_getForehead(long l, y y);

    public static final native long UIFaceAlignmentData_getLeftBrow(long l, y y);

    public static final native long UIFaceAlignmentData_getLeftEar(long l, y y);

    public static final native long UIFaceAlignmentData_getLeftEye(long l, y y);

    public static final native long UIFaceAlignmentData_getLeftShape(long l, y y);

    public static final native long UIFaceAlignmentData_getMouth(long l, y y);

    public static final native long UIFaceAlignmentData_getNose(long l, y y);

    public static final native long UIFaceAlignmentData_getRightBrow(long l, y y);

    public static final native long UIFaceAlignmentData_getRightEar(long l, y y);

    public static final native long UIFaceAlignmentData_getRightEye(long l, y y);

    public static final native long UIFaceAlignmentData_getRightShape(long l, y y);

    public static final native void UIFaceAlignmentData_setChin(long l, y y, long l1, aa aa);

    public static final native void UIFaceAlignmentData_setForehead(long l, y y, long l1, ad ad);

    public static final native void UIFaceAlignmentData_setLeftBrow(long l, y y, long l1, z z);

    public static final native void UIFaceAlignmentData_setLeftEar(long l, y y, long l1, ab ab);

    public static final native void UIFaceAlignmentData_setLeftEye(long l, y y, long l1, ac ac);

    public static final native void UIFaceAlignmentData_setLeftShape(long l, y y, long l1, ak ak);

    public static final native void UIFaceAlignmentData_setMouth(long l, y y, long l1, af af);

    public static final native void UIFaceAlignmentData_setNose(long l, y y, long l1, ag ag);

    public static final native void UIFaceAlignmentData_setRightBrow(long l, y y, long l1, z z);

    public static final native void UIFaceAlignmentData_setRightEar(long l, y y, long l1, ab ab);

    public static final native void UIFaceAlignmentData_setRightEye(long l, y y, long l1, ac ac);

    public static final native void UIFaceAlignmentData_setRightShape(long l, y y, long l1, ak ak);

    public static final native long UIFaceBrow_bottom_get(long l, z z);

    public static final native void UIFaceBrow_bottom_set(long l, z z, long l1, ah ah);

    public static final native long UIFaceBrow_left_get(long l, z z);

    public static final native void UIFaceBrow_left_set(long l, z z, long l1, ah ah);

    public static final native long UIFaceBrow_right_get(long l, z z);

    public static final native void UIFaceBrow_right_set(long l, z z, long l1, ah ah);

    public static final native long UIFaceBrow_top_get(long l, z z);

    public static final native void UIFaceBrow_top_set(long l, z z, long l1, ah ah);

    public static final native long UIFaceChin_center_get(long l, aa aa);

    public static final native void UIFaceChin_center_set(long l, aa aa, long l1, ah ah);

    public static final native long UIFaceEar_bottom_get(long l, ab ab);

    public static final native void UIFaceEar_bottom_set(long l, ab ab, long l1, ah ah);

    public static final native long UIFaceEar_top_get(long l, ab ab);

    public static final native void UIFaceEar_top_set(long l, ab ab, long l1, ah ah);

    public static final native long UIFaceEye_bottom_get(long l, ac ac);

    public static final native void UIFaceEye_bottom_set(long l, ac ac, long l1, ah ah);

    public static final native long UIFaceEye_center_get(long l, ac ac);

    public static final native void UIFaceEye_center_set(long l, ac ac, long l1, ah ah);

    public static final native long UIFaceEye_left_get(long l, ac ac);

    public static final native void UIFaceEye_left_set(long l, ac ac, long l1, ah ah);

    public static final native long UIFaceEye_right_get(long l, ac ac);

    public static final native void UIFaceEye_right_set(long l, ac ac, long l1, ah ah);

    public static final native long UIFaceEye_top_get(long l, ac ac);

    public static final native void UIFaceEye_top_set(long l, ac ac, long l1, ah ah);

    public static final native long UIFaceForehead_left_get(long l, ad ad);

    public static final native void UIFaceForehead_left_set(long l, ad ad, long l1, ah ah);

    public static final native long UIFaceForehead_middle_get(long l, ad ad);

    public static final native void UIFaceForehead_middle_set(long l, ad ad, long l1, ah ah);

    public static final native long UIFaceForehead_right_get(long l, ad ad);

    public static final native void UIFaceForehead_right_set(long l, ad ad, long l1, ah ah);

    public static final native void UIFaceModelCacheVector_add(long l, ae ae, String s);

    public static final native void UIFaceModelCacheVector_clear(long l, ae ae);

    public static final native String UIFaceModelCacheVector_get(long l, ae ae, int i);

    public static final native long UIFaceModelCacheVector_size(long l, ae ae);

    public static final native long UIFaceMouth_bottomLip1_get(long l, af af);

    public static final native void UIFaceMouth_bottomLip1_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceMouth_bottomLip2_get(long l, af af);

    public static final native void UIFaceMouth_bottomLip2_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceMouth_interpBottomLeft_get(long l, af af);

    public static final native void UIFaceMouth_interpBottomLeft_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceMouth_interpBottomRight_get(long l, af af);

    public static final native void UIFaceMouth_interpBottomRight_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceMouth_interpInnerLeft_get(long l, af af);

    public static final native void UIFaceMouth_interpInnerLeft_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceMouth_interpInnerRight_get(long l, af af);

    public static final native void UIFaceMouth_interpInnerRight_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceMouth_interpLowerLeft_get(long l, af af);

    public static final native void UIFaceMouth_interpLowerLeft_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceMouth_interpLowerRight_get(long l, af af);

    public static final native void UIFaceMouth_interpLowerRight_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceMouth_interpTopLeft_get(long l, af af);

    public static final native void UIFaceMouth_interpTopLeft_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceMouth_interpTopRight_get(long l, af af);

    public static final native void UIFaceMouth_interpTopRight_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceMouth_interpUpperLeft_get(long l, af af);

    public static final native void UIFaceMouth_interpUpperLeft_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceMouth_interpUpperRight_get(long l, af af);

    public static final native void UIFaceMouth_interpUpperRight_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceMouth_leftCorner_get(long l, af af);

    public static final native void UIFaceMouth_leftCorner_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceMouth_rightCorner_get(long l, af af);

    public static final native void UIFaceMouth_rightCorner_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceMouth_topLip1_get(long l, af af);

    public static final native void UIFaceMouth_topLip1_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceMouth_topLip2_get(long l, af af);

    public static final native void UIFaceMouth_topLip2_set(long l, af af, long l1, ah ah);

    public static final native long UIFaceNose_bottom_get(long l, ag ag);

    public static final native void UIFaceNose_bottom_set(long l, ag ag, long l1, ah ah);

    public static final native long UIFaceNose_bridgeTop_get(long l, ag ag);

    public static final native void UIFaceNose_bridgeTop_set(long l, ag ag, long l1, ah ah);

    public static final native long UIFaceNose_left_get(long l, ag ag);

    public static final native void UIFaceNose_left_set(long l, ag ag, long l1, ah ah);

    public static final native long UIFaceNose_right_get(long l, ag ag);

    public static final native void UIFaceNose_right_set(long l, ag ag, long l1, ah ah);

    public static final native long UIFaceNose_top_get(long l, ag ag);

    public static final native void UIFaceNose_top_set(long l, ag ag, long l1, ah ah);

    public static final native float UIFacePoint_x_get(long l, ah ah);

    public static final native void UIFacePoint_x_set(long l, ah ah, float f);

    public static final native float UIFacePoint_y_get(long l, ah ah);

    public static final native void UIFacePoint_y_set(long l, ah ah, float f);

    public static final native long UIFaceRectVector_get(long l, aj aj, int i);

    public static final native long UIFaceRectVector_size(long l, aj aj);

    public static final native int UIFaceRect_getBottom(long l, ai ai);

    public static final native int UIFaceRect_getLeft(long l, ai ai);

    public static final native int UIFaceRect_getRight(long l, ai ai);

    public static final native int UIFaceRect_getTop(long l, ai ai);

    public static final native void UIFaceRect_setBottom(long l, ai ai, int i);

    public static final native void UIFaceRect_setLeft(long l, ai ai, int i);

    public static final native void UIFaceRect_setRight(long l, ai ai, int i);

    public static final native void UIFaceRect_setTop(long l, ai ai, int i);

    public static final native long UIFaceShape_shape1_get(long l, ak ak);

    public static final native void UIFaceShape_shape1_set(long l, ak ak, long l1, ah ah);

    public static final native long UIFaceShape_shape2_get(long l, ak ak);

    public static final native void UIFaceShape_shape2_set(long l, ak ak, long l1, ah ah);

    public static final native void UIFaceTattooColorVector_add(long l, am am, long l1, al al);

    public static final native void UIFaceTattooColor_setBRatio(long l, al al, int i);

    public static final native void UIFaceTattooColor_setBrightness(long l, al al, int i);

    public static final native void UIFaceTattooColor_setColorAdjustable(long l, al al, boolean flag);

    public static final native void UIFaceTattooColor_setContrastFirstNewy(long l, al al, int i);

    public static final native void UIFaceTattooColor_setContrastFirstOldy(long l, al al, int i);

    public static final native void UIFaceTattooColor_setContrastSecondNewy(long l, al al, int i);

    public static final native void UIFaceTattooColor_setContrastSecondOldy(long l, al al, int i);

    public static final native void UIFaceTattooColor_setGRatio(long l, al al, int i);

    public static final native void UIFaceTattooColor_setLuminanceParameter(long l, al al, int i);

    public static final native void UIFaceTattooColor_setRRatio(long l, al al, int i);

    public static final native void UIIntPointVector_add(long l, au au, long l1, at at);

    public static final native void UIIntPoint_x_set(long l, at at, int i);

    public static final native void UIIntPoint_y_set(long l, at at, int i);

    public static final native void UIIntVector_add(long l, av av, int i);

    public static final native int UIIntVector_get(long l, av av, int i);

    public static final native long UIIntVector_size(long l, av av);

    public static final native int UIIrisRadius_getValue(long l, ax ax);

    public static final native void UIIrisRadius_setValue(long l, ax ax, int i);

    public static final native void UILookParameters_dumpDebugString(long l, az az);

    public static final native int UILookParameters_getAntiShineIntensity(long l, az az);

    public static final native int UILookParameters_getBlushIntensity(long l, az az);

    public static final native int UILookParameters_getDoubleEyelidsIntensity(long l, az az);

    public static final native int UILookParameters_getEyeBrowHiddenIntensity(long l, az az);

    public static final native int UILookParameters_getEyeBrowIntensity(long l, az az);

    public static final native int UILookParameters_getEyeContactsIntensity(long l, az az);

    public static final native int UILookParameters_getEyeLashIntensity(long l, az az);

    public static final native int UILookParameters_getEyeLinerIntensity(long l, az az);

    public static final native int UILookParameters_getEyeShadowCount(long l, az az);

    public static final native void UILookParameters_getEyeShadowIntensity(long l, az az, long l1, av av);

    public static final native void UILookParameters_getEyeShadowShimmerIntensity(long l, az az, long l1, av av);

    public static final native int UILookParameters_getFaceContourIntensity(long l, az az);

    public static final native int UILookParameters_getHairDyeIntensity(long l, az az);

    public static final native int UILookParameters_getLipStickIntensity(long l, az az);

    public static final native int UILookParameters_getNoseEnhancementIntentsity(long l, az az);

    public static final native int UILookParameters_getSkinSmoothIntensity(long l, az az);

    public static final native int UILookParameters_getSkinToneIntensity(long l, az az);

    public static final native int UILookParameters_getSparkleEyeIntensity(long l, az az);

    public static final native void UILookParameters_setAntiShineIntensity(long l, az az, int i);

    public static final native void UILookParameters_setBlushIntensity(long l, az az, int i);

    public static final native void UILookParameters_setDoubleEyelidsIntensity(long l, az az, int i);

    public static final native void UILookParameters_setEyeBrowHiddenIntensity(long l, az az, int i);

    public static final native void UILookParameters_setEyeBrowIntensity(long l, az az, int i);

    public static final native void UILookParameters_setEyeContactsIntensity(long l, az az, int i);

    public static final native void UILookParameters_setEyeLashIntensity(long l, az az, int i);

    public static final native void UILookParameters_setEyeLinerIntensity(long l, az az, int i);

    public static final native void UILookParameters_setEyeShadowCount(long l, az az, int i);

    public static final native void UILookParameters_setEyeShadowIntensity(long l, az az, long l1, av av);

    public static final native void UILookParameters_setEyeShadowShimmerIntensity(long l, az az, long l1, av av);

    public static final native void UILookParameters_setFaceContourIntensity(long l, az az, int i);

    public static final native void UILookParameters_setHairDyeIntensity(long l, az az, int i);

    public static final native void UILookParameters_setLipStickIntensity(long l, az az, int i);

    public static final native void UILookParameters_setNoseEnhancementIntentsity(long l, az az, int i);

    public static final native void UILookParameters_setSkinSmoothIntensity(long l, az az, int i);

    public static final native void UILookParameters_setSkinToneIntensity(long l, az az, int i);

    public static final native void UILookParameters_setSparkleEyeIntensity(long l, az az, int i);

    public static final native void UIModelBrowEngineRect_head_set(long l, bb bb, long l1, ah ah);

    public static final native void UIModelBrowEngineRect_tail_set(long l, bb bb, long l1, ah ah);

    public static final native void UIModelBrowEngineRect_top_set(long l, bb bb, long l1, ah ah);

    public static final native void UIModelEyeRect_bottom_set(long l, bc bc, long l1, ah ah);

    public static final native void UIModelEyeRect_left_set(long l, bc bc, long l1, ah ah);

    public static final native void UIModelEyeRect_right_set(long l, bc bc, long l1, ah ah);

    public static final native void UIModelEyeRect_top_set(long l, bc bc, long l1, ah ah);

    public static final native float UITransform_getRotation(long l, bi bi);

    public static final native float UITransform_getScale(long l, bi bi);

    public static final native float UITransform_getShiftX(long l, bi bi);

    public static final native float UITransform_getShiftY(long l, bi bi);

    public static final native void UITransform_setRotation(long l, bi bi, float f);

    public static final native void UITransform_setScale(long l, bi bi, float f);

    public static final native void UITransform_setShiftX(long l, bi bi, float f);

    public static final native void UITransform_setShiftY(long l, bi bi, float f);

    public static final native int UIUserProfile_getEyebrowColor(long l, bj bj);

    public static final native int UIUserProfile_getGender(long l, bj bj);

    public static final native int UIUserProfile_getHairColor(long l, bj bj);

    public static final native int UIUserProfile_getIrisColor(long l, bj bj);

    public static final native int UIUserProfile_getLipColor(long l, bj bj);

    public static final native int UIUserProfile_getSkinColor(long l, bj bj);

    public static final native int UIUserProfile_getStatus(long l, bj bj);

    public static final native void UIVenusPipelineSettings_UpdateEyeBrowAutoHiddenFlag(long l, bk bk, boolean flag);

    public static final native void UIVenusPipelineSettings_UpdateEyeBrowAutoMatchFlag(long l, bk bk, boolean flag);

    public static final native void UIVenusPipelineSettings_configAntiShine(long l, bk bk, int i);

    public static final native void UIVenusPipelineSettings_configAutoSpotRemoval(long l, bk bk, boolean flag);

    public static final native void UIVenusPipelineSettings_configBlush(long l, bk bk, int i, long l1, r r, String s, 
            String s1, boolean flag);

    public static final native void UIVenusPipelineSettings_configBrow(long l, bk bk, int i, int j, long l1, r r, 
            long l2, ae ae, long l3, ae ae1, long l4, bb bb, long l5, bb bb1, long l6, 
            bb bb2, String s, boolean flag, boolean flag1, int k, long l7, 
            z z, long l8, z z1);

    public static final native void UIVenusPipelineSettings_configCacheMode(long l, bk bk, int i);

    public static final native void UIVenusPipelineSettings_configClassicLipstick(long l, bk bk, int i, boolean flag, int j, int k, int i1, 
            int j1);

    public static final native void UIVenusPipelineSettings_configDoubleEyelid(long l, bk bk, int i, long l1, r r, long l2, ae ae, long l3, bc bc, String s);

    public static final native void UIVenusPipelineSettings_configEyeContact(long l, bk bk, int i, float f, int j, long l1, 
            s s, long l2, ae ae, long l3, ae ae1);

    public static final native void UIVenusPipelineSettings_configEyebrowTattooLeft(long l, bk bk, int i, int j, long l1, ae ae, 
            long l2, bc bc);

    public static final native void UIVenusPipelineSettings_configEyebrowTattooRight(long l, bk bk, int i, int j, long l1, ae ae, 
            long l2, bc bc);

    public static final native void UIVenusPipelineSettings_configEyelash(long l, bk bk, int i, long l1, r r, long l2, ae ae, long l3, bc bc, String s, int j);

    public static final native void UIVenusPipelineSettings_configEyelashTattooLeftLower(long l, bk bk, int i, int j, long l1, ae ae, 
            long l2, bc bc);

    public static final native void UIVenusPipelineSettings_configEyelashTattooLeftUpper(long l, bk bk, int i, int j, long l1, ae ae, 
            long l2, bc bc);

    public static final native void UIVenusPipelineSettings_configEyelashTattooResetAll(long l, bk bk);

    public static final native void UIVenusPipelineSettings_configEyelashTattooRightLower(long l, bk bk, int i, int j, long l1, ae ae, 
            long l2, bc bc);

    public static final native void UIVenusPipelineSettings_configEyelashTattooRightUpper(long l, bk bk, int i, int j, long l1, ae ae, 
            long l2, bc bc);

    public static final native void UIVenusPipelineSettings_configEyeliner(long l, bk bk, int i, long l1, r r, long l2, ae ae, long l3, bc bc, String s, int j);

    public static final native void UIVenusPipelineSettings_configEyelinerTattooLeft(long l, bk bk, int i, int j, long l1, ae ae, 
            long l2, bc bc);

    public static final native void UIVenusPipelineSettings_configEyelinerTattooRight(long l, bk bk, int i, int j, long l1, ae ae, 
            long l2, bc bc);

    public static final native void UIVenusPipelineSettings_configEyeshadow(long l, bk bk, long l1, av av, long l2, 
            s s, long l3, av av1, long l4, ae ae, 
            long l5, bc bc, String s1, long l6, ae ae1, 
            long l7, av av2, int i);

    public static final native void UIVenusPipelineSettings_configEyeshadowTattooLeft(long l, bk bk, int i, int j, long l1, ae ae, 
            long l2, bc bc);

    public static final native void UIVenusPipelineSettings_configEyeshadowTattooRight(long l, bk bk, int i, int j, long l1, ae ae, 
            long l2, bc bc);

    public static final native void UIVenusPipelineSettings_configFaceArt(long l, bk bk, long l1, ae ae, long l2, 
            au au, long l3, am am);

    public static final native void UIVenusPipelineSettings_configFaceContour(long l, bk bk, int i);

    public static final native void UIVenusPipelineSettings_configFaceData(long l, bk bk, long l1, ai ai, long l2, 
            y y);

    public static final native void UIVenusPipelineSettings_configFaceWidget(long l, bk bk, long l1, ae ae, long l2, 
            au au, long l3, am am);

    public static final native void UIVenusPipelineSettings_configHairDye(long l, bk bk, int i, float f, long l1, r r);

    public static final native void UIVenusPipelineSettings_configKoreanStyleLipstick(long l, bk bk, int i, boolean flag, int j, int k, int i1, 
            int j1, int k1, int l1, int i2, int j2, int k2);

    public static final native void UIVenusPipelineSettings_configMouthOpen(long l, bk bk, boolean flag);

    public static final native void UIVenusPipelineSettings_configNoseEnhancement(long l, bk bk, int i);

    public static final native void UIVenusPipelineSettings_configOriginalEyeBrow(long l, bk bk, long l1, z z, long l2, 
            z z1);

    public static final native void UIVenusPipelineSettings_configSkinSmooth(long l, bk bk, int i);

    public static final native void UIVenusPipelineSettings_configSkinTone(long l, bk bk, int i, long l1, r r);

    public static final native void UIVenusPipelineSettings_configSparkleEye(long l, bk bk, int i);

    public static final native void UIVenusPipelineSettings_configWig(long l, bk bk, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, 
            long l1, bi bi, long l2, bm bm, long l3, ae ae, int i);

    public static final native void UIVenusPipelineSettings_configWigTransform(long l, bk bk, long l1, bi bi);

    public static final native boolean UIVenusPipelineSettings_getBrowAutoHiddenFlag(long l, bk bk);

    public static final native boolean UIVenusPipelineSettings_getBrowAutoMatchFlag(long l, bk bk);

    public static final native int UIVenusPipelineSettings_getBrowHiddenIntensity(long l, bk bk);

    public static final native boolean UIVenusPipelineSettings_getEnableEyeBrow(long l, bk bk);

    public static final native boolean UIVenusPipelineSettings_getEnableEyeContact(long l, bk bk);

    public static final native boolean UIVenusPipelineSettings_getEnableHairDye(long l, bk bk);

    public static final native boolean UIVenusPipelineSettings_getEnableWig(long l, bk bk);

    public static final native long UIVenusPipelineSettings_getEyeContactColor(long l, bk bk);

    public static final native int UIVenusPipelineSettings_getEyeContactIntensity(long l, bk bk);

    public static final native float UIVenusPipelineSettings_getEyeContactIntensitySize(long l, bk bk);

    public static final native int UIVenusPipelineSettings_getEyeContactIrisRadius(long l, bk bk);

    public static final native long UIVenusPipelineSettings_getEyeContactMaskModelCache(long l, bk bk);

    public static final native long UIVenusPipelineSettings_getEyeContactModelCache(long l, bk bk);

    public static final native boolean UIVenusPipelineSettings_getIsWigModelChange(long l, bk bk);

    public static final native void UIVenusPipelineSettings_getOriginalEyeBrow(long l, bk bk, long l1, z z, long l2, 
            z z1);

    public static final native void UIVenusPipelineSettings_getWarpedWigImageInfo(long l, bk bk, long l1, bl bl);

    public static final native void UIVenusPipelineSettings_getWarpedWigTransform(long l, bk bk, long l1, bi bi);

    public static final native long UIVenusPipelineSettings_getWigCache(long l, bk bk);

    public static final native boolean UIVenusPipelineSettings_isForceApplyWigPosition(long l, bk bk);

    public static final native boolean UIVenusPipelineSettings_isModelBrowRectAllZero(long l, bk bk);

    public static final native int UIVenusPipelineSettings_queryCacheMode(long l, bk bk);

    public static final native long UIVenusPipelineSettings_queryFaceRect(long l, bk bk);

    public static final native long UIVenusPipelineSettings_queryFeaturePoints(long l, bk bk);

    public static final native void UIVenusPipelineSettings_setEnableWig(long l, bk bk, boolean flag);

    public static final native void UIVenusPipelineSettings_setIsWigModelChange(long l, bk bk, boolean flag);

    public static final native int UIWarpedWigImageInfo_height_get(long l, bl bl);

    public static final native int UIWarpedWigImageInfo_width_get(long l, bl bl);

    public static final native void UIWigColor_setBRatio(long l, bm bm, int i);

    public static final native void UIWigColor_setBrightness(long l, bm bm, int i);

    public static final native void UIWigColor_setContrastFirstNewy(long l, bm bm, int i);

    public static final native void UIWigColor_setContrastFirstOldy(long l, bm bm, int i);

    public static final native void UIWigColor_setContrastSecondNewy(long l, bm bm, int i);

    public static final native void UIWigColor_setContrastSecondOldy(long l, bm bm, int i);

    public static final native void UIWigColor_setGRatio(long l, bm bm, int i);

    public static final native void UIWigColor_setRRatio(long l, bm bm, int i);

    public static final native int UIWigLuminance_getValue(long l, bn bn);

    public static final native void UIWigLuminance_setValue(long l, bn bn, int i);

    public static final native void delete_CUIVenus(long l);

    public static final native void delete_UIColor(long l);

    public static final native void delete_UIColorVector(long l);

    public static final native void delete_UIFaceAlignmentData(long l);

    public static final native void delete_UIFaceBrow(long l);

    public static final native void delete_UIFaceChin(long l);

    public static final native void delete_UIFaceEar(long l);

    public static final native void delete_UIFaceEye(long l);

    public static final native void delete_UIFaceForehead(long l);

    public static final native void delete_UIFaceModelCacheVector(long l);

    public static final native void delete_UIFaceMouth(long l);

    public static final native void delete_UIFaceNose(long l);

    public static final native void delete_UIFacePoint(long l);

    public static final native void delete_UIFaceRect(long l);

    public static final native void delete_UIFaceRectVector(long l);

    public static final native void delete_UIFaceShape(long l);

    public static final native void delete_UIFaceTattooColor(long l);

    public static final native void delete_UIFaceTattooColorVector(long l);

    public static final native void delete_UIIntPoint(long l);

    public static final native void delete_UIIntPointVector(long l);

    public static final native void delete_UIIntVector(long l);

    public static final native void delete_UIIrisRadius(long l);

    public static final native void delete_UILookParameters(long l);

    public static final native void delete_UIModelBrowEngineRect(long l);

    public static final native void delete_UIModelEyeRect(long l);

    public static final native void delete_UITransform(long l);

    public static final native void delete_UIUserProfile(long l);

    public static final native void delete_UIVenusPipelineSettings(long l);

    public static final native void delete_UIWarpedWigImageInfo(long l);

    public static final native void delete_UIWigColor(long l);

    public static final native void delete_UIWigLuminance(long l);

    public static final native long new_CUIVenus(String s, String s1, String s2, String s3);

    public static final native long new_UIColorVector__SWIG_0();

    public static final native long new_UIColor__SWIG_0();

    public static final native long new_UIColor__SWIG_1(int i, int j, int k);

    public static final native long new_UIFaceAlignmentData__SWIG_0();

    public static final native long new_UIFaceAlignmentData__SWIG_1(long l, y y);

    public static final native long new_UIFaceBrow();

    public static final native long new_UIFaceChin();

    public static final native long new_UIFaceEar();

    public static final native long new_UIFaceEye();

    public static final native long new_UIFaceForehead();

    public static final native long new_UIFaceModelCacheVector__SWIG_0();

    public static final native long new_UIFaceMouth();

    public static final native long new_UIFaceNose();

    public static final native long new_UIFacePoint__SWIG_0();

    public static final native long new_UIFacePoint__SWIG_1(long l, ah ah);

    public static final native long new_UIFaceRectVector__SWIG_0();

    public static final native long new_UIFaceRect__SWIG_0();

    public static final native long new_UIFaceRect__SWIG_1(long l, ai ai);

    public static final native long new_UIFaceShape();

    public static final native long new_UIFaceTattooColor();

    public static final native long new_UIFaceTattooColorVector__SWIG_0();

    public static final native long new_UIIntPointVector__SWIG_0();

    public static final native long new_UIIntPoint__SWIG_0();

    public static final native long new_UIIntVector__SWIG_0();

    public static final native long new_UIIrisRadius__SWIG_0();

    public static final native long new_UIIrisRadius__SWIG_1(long l, ax ax);

    public static final native long new_UILookParameters();

    public static final native long new_UIModelBrowEngineRect();

    public static final native long new_UIModelEyeRect();

    public static final native long new_UITransform__SWIG_0();

    public static final native long new_UITransform__SWIG_1(long l, bi bi);

    public static final native long new_UIUserProfile__SWIG_0();

    public static final native long new_UIVenusPipelineSettings__SWIG_0();

    public static final native long new_UIVenusPipelineSettings__SWIG_1(long l, bk bk);

    public static final native long new_UIWarpedWigImageInfo__SWIG_0();

    public static final native long new_UIWigColor__SWIG_0();

    public static final native long new_UIWigLuminance__SWIG_0();

    public static final native long new_UIWigLuminance__SWIG_1(long l, bn bn);

    static 
    {
        try
        {
            a.b();
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            System.err.println((new StringBuilder()).append("JNI error: ").append(unsatisfiedlinkerror).toString());
            System.exit(1);
        }
    }
}
