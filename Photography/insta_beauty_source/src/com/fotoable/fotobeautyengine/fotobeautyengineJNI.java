// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotobeautyengine;

import adc;
import add;
import ade;
import adg;
import adh;
import adi;
import adj;
import adk;
import adl;
import adm;
import adn;
import ado;
import adq;
import adr;
import ads;
import adt;
import adu;
import adv;
import adw;
import adx;
import ady;
import adz;
import aea;
import aeb;
import android.content.res.AssetManager;
import android.graphics.Bitmap;

public class fotobeautyengineJNI
{

    public static final native void BeautyFaceMannualEyeBiggerData_brushSize_set(long l, adc adc, float f);

    public static final native void BeautyFaceMannualEyeBiggerData_xcord_set(long l, adc adc, int i);

    public static final native void BeautyFaceMannualEyeBiggerData_ycord_set(long l, adc adc, int i);

    public static final native void BeautyFaceMannualEyeBiggerData_zoomLevel_set(long l, adc adc, float f);

    public static final native void BeautyFaceMannualSlimData_brushSize_set(long l, add add, float f);

    public static final native void BeautyFaceMannualSlimData_xend_set(long l, add add, int i);

    public static final native void BeautyFaceMannualSlimData_xstart_set(long l, add add, int i);

    public static final native void BeautyFaceMannualSlimData_yend_set(long l, add add, int i);

    public static final native void BeautyFaceMannualSlimData_ystart_set(long l, add add, int i);

    public static final native void BeautyFaceMannualSlimData_zoomLevel_set(long l, add add, float f);

    public static final native void BeautyPointVector_add(long l, ade ade, long l1, adi adi);

    public static final native void BeautyPointVector_clear(long l, ade ade);

    public static final native void BeautyUtilityWrapper_getBeautyMaigc(Bitmap bitmap, float f);

    public static final native void CustomVector_add(long l, adg adg, long l1, adm adm);

    public static final native void CustomVector_clear(long l, adg adg);

    public static final native long CustomVector_get(long l, adg adg, int i);

    public static final native boolean CustomVector_isEmpty(long l, adg adg);

    public static final native long CustomVector_size(long l, adg adg);

    public static final native long FaceKeyPoints_forehead_get(long l, adh adh);

    public static final native long FaceKeyPoints_leftEye_get(long l, adh adh);

    public static final native long FaceKeyPoints_meixin_get(long l, adh adh);

    public static final native long FaceKeyPoints_mouth_get(long l, adh adh);

    public static final native long FaceKeyPoints_mustache_get(long l, adh adh);

    public static final native long FaceKeyPoints_noseTip_get(long l, adh adh);

    public static final native long FaceKeyPoints_rightEye_get(long l, adh adh);

    public static final native float FotoBeautyPoint_x_get(long l, adi adi);

    public static final native void FotoBeautyPoint_x_set(long l, adi adi, float f);

    public static final native float FotoBeautyPoint_y_get(long l, adi adi);

    public static final native void FotoBeautyPoint_y_set(long l, adi adi, float f);

    public static final native void FotoBeautyRemoveEyeBagVector_add(long l, adj adj, long l1, adl adl);

    public static final native void FotoBeautyRemoveEyeBagVector_clear(long l, adj adj);

    public static final native long FotoBeautyRemoveEyeBagVector_get(long l, adj adj, int i);

    public static final native boolean FotoBeautyRemoveEyeBagVector_isEmpty(long l, adj adj);

    public static final native long FotoBeautyRemoveEyeBagVector_size(long l, adj adj);

    public static final native long FotoFaceBeautyEngineWrapper_SWIGUpcast(long l);

    public static final native void FotoFaceBeautyEngineWrapper_alignFaceWithPinnedPts(long l, adk adk, long l1, adi adi, long l2, 
            adi adi1);

    public static final native void FotoFaceBeautyEngineWrapper_enterState__SWIG_0(long l, adk adk, int i, long l1, adv adv);

    public static final native void FotoFaceBeautyEngineWrapper_exitState(long l, adk adk);

    public static final native int FotoFaceBeautyEngineWrapper_getFaceCount(long l, adk adk);

    public static final native void FotoFaceBeautyEngineWrapper_getFaceKeyPoints(long l, adk adk, long l1, adh adh, int i);

    public static final native void FotoFaceBeautyEngineWrapper_getResultImage(long l, adk adk, Bitmap bitmap);

    public static final native void FotoFaceBeautyEngineWrapper_getSuggestParams(long l, adk adk, long l1, adv adv);

    public static final native boolean FotoFaceBeautyEngineWrapper_hasFace(long l, adk adk);

    public static final native void FotoFaceBeautyEngineWrapper_initEngineWithImage(long l, adk adk, AssetManager assetmanager, Bitmap bitmap);

    public static final native void FotoFaceBeautyEngineWrapper_operate(long l, adk adk, long l1, adv adv);

    public static final native void FotoFaceBeautyEngineWrapper_selectFace(long l, adk adk, int i);

    public static final native void FotoFaceBeautyEngineWrapper_setIsFastPhone(long l, adk adk, boolean flag);

    public static final native void FotoFaceBeautyEngineWrapper_setNeedDetectFace(long l, adk adk, boolean flag);

    public static final native void FotoFaceBeautyEngineWrapper_updateImage(long l, adk adk, AssetManager assetmanager, Bitmap bitmap);

    public static final native void FotoRemoveEyebagContour_pts_set(long l, adl adl, long l1, ade ade);

    public static final native void FotoRemoveEyebagContour_thickness_set(long l, adl adl, int i);

    public static final native void FotoUserTappedPt_areRadius_set(long l, adm adm, float f);

    public static final native void FotoUserTappedPt_x_set(long l, adm adm, float f);

    public static final native void FotoUserTappedPt_y_set(long l, adm adm, float f);

    public static final native void MEyeBigDataVector_add(long l, adn adn, long l1, adc adc);

    public static final native void MEyeBigDataVector_clear(long l, adn adn);

    public static final native long MEyeBigDataVector_get(long l, adn adn, int i);

    public static final native boolean MEyeBigDataVector_isEmpty(long l, adn adn);

    public static final native long MEyeBigDataVector_size(long l, adn adn);

    public static final native void MSlimDataVector_add(long l, ado ado, long l1, add add);

    public static final native void MSlimDataVector_clear(long l, ado ado);

    public static final native long MSlimDataVector_get(long l, ado ado, int i);

    public static final native boolean MSlimDataVector_isEmpty(long l, ado ado);

    public static final native long MSlimDataVector_size(long l, ado ado);

    public static final native long StateClearEyeParam_SWIGUpcast(long l);

    public static final native void StateClearEyeParam_level_set(long l, adq adq, float f);

    public static final native long StateEnhanceNoseParam_SWIGUpcast(long l);

    public static final native void StateEnhanceNoseParam_level_set(long l, adr adr, float f);

    public static final native long StateEnlargeEyeParam_SWIGUpcast(long l);

    public static final native void StateEnlargeEyeParam_autoLevel_set(long l, ads ads, float f);

    public static final native void StateEnlargeEyeParam_mannualEyeBigData_set(long l, ads ads, long l1, adn adn);

    public static final native long StateOneKeyBeautyInitParam_SWIGUpcast(long l);

    public static final native void StateOneKeyBeautyInitParam_autoQuBan_set(long l, adt adt, boolean flag);

    public static final native void StateOneKeyBeautyInitParam_autoRemoveEyeBagLevel_set(long l, adt adt, float f);

    public static final native void StateOneKeyBeautyInitParam_clearEyeLevel_set(long l, adt adt, float f);

    public static final native void StateOneKeyBeautyInitParam_enhanceNoseLevel_set(long l, adt adt, float f);

    public static final native void StateOneKeyBeautyInitParam_enlargeEyeLevel_set(long l, adt adt, float f);

    public static final native void StateOneKeyBeautyInitParam_slimFaceLevel_set(long l, adt adt, float f);

    public static final native void StateOneKeyBeautyInitParam_slimNoseLevel_set(long l, adt adt, float f);

    public static final native long StateOneKeyBeautyParam_SWIGUpcast(long l);

    public static final native void StateOneKeyBeautyParam_softenLevel_set(long l, adu adu, float f);

    public static final native long StateQubanParam_SWIGUpcast(long l);

    public static final native void StateQubanParam_isOpen_set(long l, adw adw, boolean flag);

    public static final native void StateQubanParam_pts_set(long l, adw adw, long l1, adg adg);

    public static final native long StateRemoveEyebagParam_SWIGUpcast(long l);

    public static final native void StateRemoveEyebagParam_bagContour_set(long l, adx adx, long l1, adj adj);

    public static final native void StateRemoveEyebagParam_isOpen_set(long l, adx adx, boolean flag);

    public static final native void StateRemoveEyebagParam_level_set(long l, adx adx, float f);

    public static final native long StateSlimFaceParam_SWIGUpcast(long l);

    public static final native void StateSlimFaceParam_autoLevel_set(long l, ady ady, float f);

    public static final native void StateSlimFaceParam_mannualSlimFaceOperationData_set(long l, ady ady, long l1, ado ado);

    public static final native long StateSlimNoseParam_SWIGUpcast(long l);

    public static final native void StateSlimNoseParam_autoLevel_set(long l, adz adz, float f);

    public static final native void StateSlimNoseParam_mannualSlimNoseOperationData_set(long l, adz adz, long l1, ado ado);

    public static final native long StateSoftenParam_SWIGUpcast(long l);

    public static final native void StateSoftenParam_skinLevel_set(long l, aea aea, float f);

    public static final native void StateSoftenParam_softenLevel_set(long l, aea aea, float f);

    public static final native void StateSoftenParam_whiteLevel_set(long l, aea aea, float f);

    public static final native long StateSoftenSuggestParam_SWIGUpcast(long l);

    public static final native float StateSoftenSuggestParam_skinLevel_get(long l, aeb aeb);

    public static final native float StateSoftenSuggestParam_whiteLevel_get(long l, aeb aeb);

    public static final native void delete_BeautyFaceMannualEyeBiggerData(long l);

    public static final native void delete_BeautyFaceMannualSlimData(long l);

    public static final native void delete_BeautyPointVector(long l);

    public static final native void delete_BeautyUtilityWrapper(long l);

    public static final native void delete_CustomVector(long l);

    public static final native void delete_FaceKeyPoints(long l);

    public static final native void delete_FotoBeautyPoint(long l);

    public static final native void delete_FotoBeautyRemoveEyeBagVector(long l);

    public static final native void delete_FotoFaceBeautyEngineWrapper(long l);

    public static final native void delete_FotoRemoveEyebagContour(long l);

    public static final native void delete_FotoUserTappedPt(long l);

    public static final native void delete_MEyeBigDataVector(long l);

    public static final native void delete_MSlimDataVector(long l);

    public static final native void delete_StateClearEyeParam(long l);

    public static final native void delete_StateEnhanceNoseParam(long l);

    public static final native void delete_StateEnlargeEyeParam(long l);

    public static final native void delete_StateOneKeyBeautyInitParam(long l);

    public static final native void delete_StateOneKeyBeautyParam(long l);

    public static final native void delete_StateParamBase(long l);

    public static final native void delete_StateQubanParam(long l);

    public static final native void delete_StateRemoveEyebagParam(long l);

    public static final native void delete_StateSlimFaceParam(long l);

    public static final native void delete_StateSlimNoseParam(long l);

    public static final native void delete_StateSoftenParam(long l);

    public static final native void delete_StateSoftenSuggestParam(long l);

    public static final native void delete_WrapperBase(long l);

    public static final native long new_BeautyFaceMannualEyeBiggerData();

    public static final native long new_BeautyFaceMannualSlimData();

    public static final native long new_BeautyPointVector__SWIG_0();

    public static final native long new_CustomVector__SWIG_0();

    public static final native long new_FaceKeyPoints();

    public static final native long new_FotoBeautyPoint();

    public static final native long new_FotoBeautyRemoveEyeBagVector__SWIG_0();

    public static final native long new_FotoFaceBeautyEngineWrapper__SWIG_0(boolean flag);

    public static final native long new_FotoFaceBeautyEngineWrapper__SWIG_1();

    public static final native long new_FotoRemoveEyebagContour();

    public static final native long new_FotoUserTappedPt();

    public static final native long new_MEyeBigDataVector__SWIG_0();

    public static final native long new_MSlimDataVector__SWIG_0();

    public static final native long new_StateClearEyeParam();

    public static final native long new_StateEnhanceNoseParam();

    public static final native long new_StateEnlargeEyeParam();

    public static final native long new_StateOneKeyBeautyInitParam();

    public static final native long new_StateOneKeyBeautyParam();

    public static final native long new_StateQubanParam();

    public static final native long new_StateRemoveEyebagParam();

    public static final native long new_StateSlimFaceParam();

    public static final native long new_StateSlimNoseParam();

    public static final native long new_StateSoftenParam();

    public static final native long new_StateSoftenSuggestParam();
}
