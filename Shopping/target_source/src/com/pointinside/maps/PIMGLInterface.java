// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.g.a.a.a.a;
import com.g.a.a.a.c;
import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

// Referenced classes of package com.pointinside.maps:
//            PIMGLContext, PIMGLAccessibilityElementSet, PIMGLAnnotationAttrs, PIMGLCameraAttrs, 
//            PIMGLPoint, PIMGLRouteAttrs, PIMGLRouteLegAttrs, PIMGLZonePickerEntry, 
//            PIMGLFeatureSet, PIMGLFeatureAttrs, PIMGLEventData

interface PIMGLInterface
    extends Library
{
    public static interface PIMGLBluedotStyle
    {

        public static final int kPIMGLBluedotStyle_Beacon = 1;
        public static final int kPIMGLBluedotStyle_Dot = 0;
    }

    public static interface PIMGLEaseType
    {

        public static final int kPIMGLEaseType_EaseIn = 0;
        public static final int kPIMGLEaseType_EaseOut = 1;
        public static final int kPIMGLEaseType_ExtraSharpEaseIn = 2;
        public static final int kPIMGLEaseType_ExtraSharpEaseOut = 3;
        public static final int kPIMGLEaseType_ExtraSharpSmooth = 4;
        public static final int kPIMGLEaseType_ExtraSharpSmoothEaseOut = 5;
        public static final int kPIMGLEaseType_Flat = 6;
        public static final int kPIMGLEaseType_Linear = 7;
        public static final int kPIMGLEaseType_SharpEaseIn = 8;
        public static final int kPIMGLEaseType_SharpEaseOut = 9;
        public static final int kPIMGLEaseType_SharpSmooth = 10;
        public static final int kPIMGLEaseType_SharpSmoothEaseOut = 11;
        public static final int kPIMGLEaseType_Smooth = 12;
        public static final int kPIMGLEaseType_SmoothEaseOut = 13;
        public static final int kPIMGLEaseType_SoftEaseIn = 14;
        public static final int kPIMGLEaseType_SoftEaseOut = 15;
        public static final int kPIMGLEaseType_SoftSmooth = 16;
        public static final int kPIMGLEaseType_SoftSmoothEaseOut = 17;
    }

    public static interface PIMGLError
    {

        public static final int kPIMGLError_Invalid = 1;
        public static final int kPIMGLError_MissingContext = 2;
        public static final int kPIMGLError_MissingLuaMethod = 3;
        public static final int kPIMGLError_NoSuchFeature = 4;
        public static final int kPIMGLError_NoSuchFile = 5;
        public static final int kPIMGLError_None = 0;
        public static final int kPIMGLError_SVGParserError = 6;
        public static final int kPIMGLError_TesselationError = 8;
        public static final int kPIMGLError_TesselationWarning = 9;
        public static final int kPIMGLError_UnexpectedParam = 7;
    }

    public static interface PIMGLEventHandlerFunc
        extends Callback
    {

        public abstract void apply(PIMGLEventData pimgleventdata);
    }

    public static interface PIMGLEventType
    {

        public static final int kPIMGLEventType_AnnotationAttrsSet = 0;
        public static final int kPIMGLEventType_CameraAttrsSet = 1;
        public static final int kPIMGLEventType_CameraDidDolly = 2;
        public static final int kPIMGLEventType_CameraDidTruck = 3;
        public static final int kPIMGLEventType_FeatureAttrsSet = 4;
        public static final int kPIMGLEventType_InputTap = 5;
        public static final int kPIMGLEventType_RouteAttrsSet = 6;
        public static final int kPIMGLEventType_RouteFinish = 7;
        public static final int kPIMGLEventType_TotalEvents = 16;
        public static final int kPIMGLEventType_ZoneLoadSVG = 8;
        public static final int kPIMGLEventType_ZonePickerHidden = 15;
        public static final int kPIMGLEventType_ZonePickerHighlightedZoneTapped = 9;
        public static final int kPIMGLEventType_ZonePickerScrolledToZone = 11;
        public static final int kPIMGLEventType_ZonePickerSelectionChanged = 12;
        public static final int kPIMGLEventType_ZonePickerSelectionChangedProgrammatically = 13;
        public static final int kPIMGLEventType_ZonePickerShown = 10;
        public static final int kPIMGLEventType_ZonePickerZoneTapped = 14;
    }

    public static interface PIMGLLogFunc
        extends Callback
    {

        public abstract void apply(String s, Pointer pointer, Pointer pointer1);
    }

    public static interface PIMGLRouteLineStyle
    {

        public static final int kPIMGLRouteLineStyle_Dotted = 1;
        public static final int kPIMGLRouteLineStyle_Solid = 0;
    }

    public static interface PIMGLSvgCacheMode
    {

        public static final int kPIMGLSvgCacheMode_Cache = 1;
        public static final int kPIMGLSvgCacheMode_None = 0;
        public static final int kPIMGLSvgCacheMode_Reset = 2;
    }

    public static interface PIMLevelOfDetailMode
    {

        public static final int kPIMLevelOfDetailMode_Auto = 0;
        public static final int kPIMLevelOfDetailMode_Hidden = 1;
        public static final int kPIMLevelOfDetailMode_Visible = 2;
    }


    public static final PIMGLInterface INSTANCE = (PIMGLInterface)Native.loadLibrary("pimgl", com/pointinside/maps/PIMGLInterface, a.a);
    public static final String JNA_LIBRARY_NAME = "pimgl";
    public static final int kPIMGLRef_Null = 0;

    public abstract int PIMGLAccessibility_GetVisibleElements(PIMGLContext pimglcontext, PIMGLAccessibilityElementSet pimglaccessibilityelementset);

    public abstract int PIMGLAccessibility_ReleaseSet(PIMGLContext pimglcontext, PIMGLAccessibilityElementSet pimglaccessibilityelementset);

    public abstract int PIMGLAnnotationStyle_Create(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLAnnotationStyle_Create(PIMGLContext pimglcontext, IntBuffer intbuffer);

    public abstract int PIMGLAnnotationStyle_Delete(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLAnnotationStyle_Delete(PIMGLContext pimglcontext, IntBuffer intbuffer);

    public abstract int PIMGLAnnotationStyle_SetPinImage(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1);

    public abstract int PIMGLAnnotationStyle_SetPinImage(PIMGLContext pimglcontext, IntBuffer intbuffer, IntBuffer intbuffer1);

    public abstract int PIMGLAnnotationStyle_SetShadowImage(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1);

    public abstract int PIMGLAnnotationStyle_SetShadowImage(PIMGLContext pimglcontext, IntBuffer intbuffer, IntBuffer intbuffer1);

    public abstract int PIMGLAnnotation_Create(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1, IntByReference intbyreference2, float f, float f1, float f2, 
            String s);

    public abstract int PIMGLAnnotation_Create(PIMGLContext pimglcontext, IntBuffer intbuffer, IntBuffer intbuffer1, IntBuffer intbuffer2, float f, float f1, float f2, 
            String s);

    public abstract int PIMGLAnnotation_Delete(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLAnnotation_Delete(PIMGLContext pimglcontext, IntBuffer intbuffer);

    public abstract int PIMGLAnnotation_GetAttrs(PIMGLContext pimglcontext, IntByReference intbyreference, PIMGLAnnotationAttrs pimglannotationattrs);

    public abstract int PIMGLAnnotation_GetAttrs(PIMGLContext pimglcontext, IntBuffer intbuffer, PIMGLAnnotationAttrs pimglannotationattrs);

    public abstract int PIMGLAnnotation_Pick(PIMGLContext pimglcontext, float f, float f1, PointerByReference pointerbyreference);

    public abstract int PIMGLAnnotation_SetAttrs(PIMGLContext pimglcontext, IntByReference intbyreference, PIMGLAnnotationAttrs pimglannotationattrs, float f, int i, boolean flag, Pointer pointer);

    public abstract int PIMGLAnnotation_SetAttrs(PIMGLContext pimglcontext, IntBuffer intbuffer, PIMGLAnnotationAttrs pimglannotationattrs, float f, int i, boolean flag, Pointer pointer);

    public abstract int PIMGLAnnotation_SetBack(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLAnnotation_SetFront(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLBluedot_ClearHeading(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLBluedot_Create(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1, int i);

    public abstract int PIMGLBluedot_Delete(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLBluedot_SetCoreColor(PIMGLContext pimglcontext, IntByReference intbyreference, float f, float f1, float f2, float f3);

    public abstract int PIMGLBluedot_SetCoreRadius(PIMGLContext pimglcontext, IntByReference intbyreference, float f);

    public abstract int PIMGLBluedot_SetHeading(PIMGLContext pimglcontext, IntByReference intbyreference, float f);

    public abstract int PIMGLBluedot_SetLoc(PIMGLContext pimglcontext, IntByReference intbyreference, float f, float f1);

    public abstract int PIMGLBluedot_SetRangeColor(PIMGLContext pimglcontext, IntByReference intbyreference, float f, float f1, float f2, float f3);

    public abstract int PIMGLBluedot_SetRangeRadius(PIMGLContext pimglcontext, IntByReference intbyreference, float f);

    public abstract int PIMGLBluedot_SetUnknownState(PIMGLContext pimglcontext, IntByReference intbyreference, boolean flag);

    public abstract int PIMGLCalloutStyle_Create(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLCalloutStyle_Create(PIMGLContext pimglcontext, IntBuffer intbuffer);

    public abstract int PIMGLCalloutStyle_Delete(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLCalloutStyle_Delete(PIMGLContext pimglcontext, IntBuffer intbuffer);

    public abstract int PIMGLCalloutStyle_SetFont(PIMGLContext pimglcontext, IntByReference intbyreference, Pointer pointer, float f);

    public abstract int PIMGLCalloutStyle_SetFont(PIMGLContext pimglcontext, IntBuffer intbuffer, String s, float f);

    public abstract int PIMGLCalloutStyle_SetFrame(PIMGLContext pimglcontext, IntByReference intbyreference, float f, float f1, float f2, float f3);

    public abstract int PIMGLCalloutStyle_SetFrame(PIMGLContext pimglcontext, IntBuffer intbuffer, float f, float f1, float f2, float f3);

    public abstract int PIMGLCalloutStyle_SetLeftButton(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1);

    public abstract int PIMGLCalloutStyle_SetLeftButton(PIMGLContext pimglcontext, IntBuffer intbuffer, IntBuffer intbuffer1);

    public abstract int PIMGLCalloutStyle_SetMargin(PIMGLContext pimglcontext, IntByReference intbyreference, float f, float f1, float f2, float f3);

    public abstract int PIMGLCalloutStyle_SetMargin(PIMGLContext pimglcontext, IntBuffer intbuffer, float f, float f1, float f2, float f3);

    public abstract int PIMGLCalloutStyle_SetNinePatch(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1, float f, float f1, float f2, float f3);

    public abstract int PIMGLCalloutStyle_SetNinePatch(PIMGLContext pimglcontext, IntBuffer intbuffer, IntBuffer intbuffer1, float f, float f1, float f2, float f3);

    public abstract int PIMGLCalloutStyle_SetRightButton(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1);

    public abstract int PIMGLCalloutStyle_SetRightButton(PIMGLContext pimglcontext, IntBuffer intbuffer, IntBuffer intbuffer1);

    public abstract int PIMGLCalloutStyle_SetTail(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1);

    public abstract int PIMGLCalloutStyle_SetTail(PIMGLContext pimglcontext, IntBuffer intbuffer, IntBuffer intbuffer1);

    public abstract int PIMGLCalloutStyle_SetTailRange(PIMGLContext pimglcontext, IntByReference intbyreference, float f, float f1);

    public abstract int PIMGLCalloutStyle_SetTailRange(PIMGLContext pimglcontext, IntBuffer intbuffer, float f, float f1);

    public abstract int PIMGLCallout_Create(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1, IntByReference intbyreference2);

    public abstract int PIMGLCallout_Create(PIMGLContext pimglcontext, IntBuffer intbuffer, IntBuffer intbuffer1, IntBuffer intbuffer2);

    public abstract int PIMGLCallout_Delete(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLCallout_Delete(PIMGLContext pimglcontext, IntBuffer intbuffer);

    public abstract int PIMGLCamera_ConvertViewToWorld(PIMGLContext pimglcontext, float f, float f1, FloatByReference floatbyreference, FloatByReference floatbyreference1);

    public abstract int PIMGLCamera_ConvertViewToWorld(PIMGLContext pimglcontext, float f, float f1, FloatBuffer floatbuffer, FloatBuffer floatbuffer1);

    public abstract int PIMGLCamera_ConvertWorldToView(PIMGLContext pimglcontext, float f, float f1, FloatByReference floatbyreference, FloatByReference floatbyreference1);

    public abstract int PIMGLCamera_ConvertWorldToView(PIMGLContext pimglcontext, float f, float f1, FloatBuffer floatbuffer, FloatBuffer floatbuffer1);

    public abstract int PIMGLCamera_EnableDolly(PIMGLContext pimglcontext, boolean flag);

    public abstract int PIMGLCamera_EnableInput(PIMGLContext pimglcontext, byte byte0);

    public abstract int PIMGLCamera_EnableOrbit(PIMGLContext pimglcontext, boolean flag);

    public abstract int PIMGLCamera_EnableTapZoom(PIMGLContext pimglcontext, boolean flag);

    public abstract int PIMGLCamera_EnableTilt(PIMGLContext pimglcontext, boolean flag);

    public abstract int PIMGLCamera_EnableTruck(PIMGLContext pimglcontext, boolean flag);

    public abstract int PIMGLCamera_GetAttrs(PIMGLContext pimglcontext, PIMGLCameraAttrs pimglcameraattrs);

    public abstract int PIMGLCamera_GetFit(PIMGLContext pimglcontext, PIMGLCameraAttrs pimglcameraattrs, PIMGLPoint pimglpoint, int i, PIMGLEdgeInsets.ByValue byvalue1, PIMGLCameraAttrs pimglcameraattrs1);

    public abstract int PIMGLCamera_SetAttrs(PIMGLContext pimglcontext, PIMGLCameraAttrs pimglcameraattrs, float f, int i, boolean flag, Pointer pointer);

    public abstract int PIMGLCamera_SetLocBounds(PIMGLContext pimglcontext, float f, float f1, float f2, float f3);

    public abstract int PIMGLCamera_SetLocMomentumDecay(PIMGLContext pimglcontext, float f);

    public abstract int PIMGLCamera_SetScopeBounds(PIMGLContext pimglcontext, float f, float f1);

    public abstract int PIMGLCamera_SetTapZoomStops(PIMGLContext pimglcontext, float f, float f1);

    public abstract int PIMGLCamera_SetTiltBounds(PIMGLContext pimglcontext, float f, float f1);

    public abstract int PIMGLCamera_SetTiltSensitivity(PIMGLContext pimglcontext, float f);

    public abstract int PIMGLCamera_SetZoomMode(PIMGLContext pimglcontext, int i);

    public abstract PIMGLColor.ByValue PIMGLColor_Create(float f, float f1, float f2, float f3);

    public abstract int PIMGLDisplay_SetScreenSize(PIMGLContext pimglcontext, int i, int j);

    public abstract int PIMGLDisplay_SetViewSize(PIMGLContext pimglcontext, int i, int j);

    public abstract int PIMGLFont_Create(PIMGLContext pimglcontext, IntByReference intbyreference, String s);

    public abstract int PIMGLFont_Create(PIMGLContext pimglcontext, IntBuffer intbuffer, String s);

    public abstract int PIMGLFont_CreateWithOutline(PIMGLContext pimglcontext, IntByReference intbyreference, String s, String s1);

    public abstract int PIMGLFont_CreateWithOutline(PIMGLContext pimglcontext, IntBuffer intbuffer, String s, String s1);

    public abstract int PIMGLImage_Create(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1);

    public abstract int PIMGLImage_Create(PIMGLContext pimglcontext, IntBuffer intbuffer, IntBuffer intbuffer1);

    public abstract int PIMGLImage_SetModelRect(PIMGLContext pimglcontext, IntByReference intbyreference, float f, float f1, float f2, float f3);

    public abstract int PIMGLImage_SetModelRect(PIMGLContext pimglcontext, IntBuffer intbuffer, float f, float f1, float f2, float f3);

    public abstract int PIMGLImage_SetUVRect(PIMGLContext pimglcontext, IntByReference intbyreference, float f, float f1, float f2, float f3);

    public abstract int PIMGLImage_SetUVRect(PIMGLContext pimglcontext, IntBuffer intbuffer, float f, float f1, float f2, float f3);

    public abstract int PIMGLOverlay_Create(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1);

    public abstract int PIMGLOverlay_Create(PIMGLContext pimglcontext, IntBuffer intbuffer, IntBuffer intbuffer1);

    public abstract int PIMGLOverlay_Delete(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLOverlay_Delete(PIMGLContext pimglcontext, IntBuffer intbuffer);

    public abstract int PIMGLRef_Create(PIMGLContext pimglcontext, PointerByReference pointerbyreference);

    public abstract int PIMGLRef_IsBound(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLRef_IsBound(PIMGLContext pimglcontext, IntBuffer intbuffer);

    public abstract int PIMGLRef_Release(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLRef_Release(PIMGLContext pimglcontext, IntBuffer intbuffer);

    public abstract int PIMGLRoute_AddPoint(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1, float f, float f1);

    public abstract int PIMGLRoute_AddPoint(PIMGLContext pimglcontext, IntBuffer intbuffer, IntBuffer intbuffer1, float f, float f1);

    public abstract int PIMGLRoute_Create(PIMGLContext pimglcontext, IntByReference intbyreference, PIMGLRouteAttrs pimglrouteattrs);

    public abstract int PIMGLRoute_Create(PIMGLContext pimglcontext, IntBuffer intbuffer, PIMGLRouteAttrs pimglrouteattrs);

    public abstract int PIMGLRoute_Delete(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLRoute_Delete(PIMGLContext pimglcontext, IntBuffer intbuffer);

    public abstract int PIMGLRoute_FinishLeg(PIMGLContext pimglcontext, IntByReference intbyreference, PIMGLRouteLegAttrs pimglroutelegattrs);

    public abstract int PIMGLRoute_FinishLeg(PIMGLContext pimglcontext, IntBuffer intbuffer, PIMGLRouteLegAttrs pimglroutelegattrs);

    public abstract int PIMGLRoute_FinishRoute(PIMGLContext pimglcontext, IntByReference intbyreference, Pointer pointer);

    public abstract int PIMGLRoute_FinishRoute(PIMGLContext pimglcontext, IntBuffer intbuffer, Pointer pointer);

    public abstract int PIMGLRoute_GetAttrs(PIMGLContext pimglcontext, IntByReference intbyreference, int i, PIMGLRouteAttrs pimglrouteattrs);

    public abstract int PIMGLRoute_GetAttrs(PIMGLContext pimglcontext, IntBuffer intbuffer, int i, PIMGLRouteAttrs pimglrouteattrs);

    public abstract int PIMGLRoute_GetNumOfLegs(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1);

    public abstract int PIMGLRoute_SetAttrs(PIMGLContext pimglcontext, IntByReference intbyreference, int i, PIMGLRouteAttrs pimglrouteattrs, float f, int j, boolean flag, 
            Pointer pointer);

    public abstract int PIMGLRoute_SetAttrs(PIMGLContext pimglcontext, IntBuffer intbuffer, int i, PIMGLRouteAttrs pimglrouteattrs, float f, int j, boolean flag, 
            Pointer pointer);

    public abstract int PIMGLSVG_GetLineNumberError(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1);

    public abstract int PIMGLSVG_GetLineNumberError(PIMGLContext pimglcontext, IntBuffer intbuffer, IntBuffer intbuffer1);

    public abstract int PIMGLShape_SetCircle(PIMGLContext pimglcontext, IntByReference intbyreference, float f, PIMGLColor.ByValue byvalue1, float f1, float f2);

    public abstract int PIMGLShape_SetCircle(PIMGLContext pimglcontext, IntBuffer intbuffer, float f, PIMGLColor.ByValue byvalue1, float f1, float f2);

    public abstract int PIMGLTexture_CreateFromData(PIMGLContext pimglcontext, IntByReference intbyreference, Pointer pointer, c c);

    public abstract int PIMGLTexture_CreateFromData(PIMGLContext pimglcontext, IntBuffer intbuffer, Pointer pointer, c c);

    public abstract int PIMGLTexture_CreateFromFile(PIMGLContext pimglcontext, IntByReference intbyreference, String s);

    public abstract int PIMGLTexture_CreateFromFile(PIMGLContext pimglcontext, IntBuffer intbuffer, String s);

    public abstract int PIMGLZonePicker_GetHighlightedZone(PIMGLContext pimglcontext, PointerByReference pointerbyreference);

    public abstract int PIMGLZonePicker_Hide(PIMGLContext pimglcontext, boolean flag, Pointer pointer);

    public abstract int PIMGLZonePicker_SetHighlightedZone(PIMGLContext pimglcontext, IntByReference intbyreference, boolean flag, Pointer pointer);

    public abstract int PIMGLZonePicker_SetHighlightedZone(PIMGLContext pimglcontext, IntBuffer intbuffer, boolean flag, Pointer pointer);

    public abstract int PIMGLZonePicker_SetLabelOutline(PIMGLContext pimglcontext, float f, float f1, float f2, float f3, float f4);

    public abstract int PIMGLZonePicker_SetLabelTextColor(PIMGLContext pimglcontext, float f, float f1, float f2, float f3);

    public abstract int PIMGLZonePicker_SetLabelTextStyle(PIMGLContext pimglcontext, IntByReference intbyreference, float f, float f1, float f2);

    public abstract int PIMGLZonePicker_SetLabelTextStyle(PIMGLContext pimglcontext, IntBuffer intbuffer, float f, float f1, float f2);

    public abstract int PIMGLZonePicker_Show(PIMGLContext pimglcontext, PIMGLZonePickerEntry pimglzonepickerentry, int i, IntByReference intbyreference, boolean flag, boolean flag1, Pointer pointer);

    public abstract int PIMGLZonePicker_Show(PIMGLContext pimglcontext, PIMGLZonePickerEntry pimglzonepickerentry, int i, IntBuffer intbuffer, boolean flag, boolean flag1, Pointer pointer);

    public abstract int PIMGLZonePicker_ShowLabel(PIMGLContext pimglcontext, boolean flag);

    public abstract int PIMGLZone_CleanSVGCache(PIMGLContext pimglcontext, String s);

    public abstract int PIMGLZone_Create(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLZone_Create(PIMGLContext pimglcontext, IntBuffer intbuffer);

    public abstract int PIMGLZone_Delete(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLZone_Delete(PIMGLContext pimglcontext, IntBuffer intbuffer);

    public abstract int PIMGLZone_GetBounds(PIMGLContext pimglcontext, IntByReference intbyreference, FloatByReference floatbyreference, FloatByReference floatbyreference1, FloatByReference floatbyreference2, FloatByReference floatbyreference3);

    public abstract int PIMGLZone_GetBounds(PIMGLContext pimglcontext, IntBuffer intbuffer, FloatBuffer floatbuffer, FloatBuffer floatbuffer1, FloatBuffer floatbuffer2, FloatBuffer floatbuffer3);

    public abstract int PIMGLZone_GetDistanceToFeatures(PIMGLContext pimglcontext, IntByReference intbyreference, PIMGLFeatureSet pimglfeatureset, PointerByReference pointerbyreference, c c, float f, float f1, 
            byte byte0);

    public abstract int PIMGLZone_GetDistanceToFeatures(PIMGLContext pimglcontext, IntBuffer intbuffer, PIMGLFeatureSet pimglfeatureset, String as[], c c, float f, float f1, 
            byte byte0);

    public abstract int PIMGLZone_GetFeatureAttrs(PIMGLContext pimglcontext, IntByReference intbyreference, String s, PIMGLFeatureAttrs pimglfeatureattrs);

    public abstract int PIMGLZone_GetFeatureAttrs(PIMGLContext pimglcontext, IntBuffer intbuffer, String s, PIMGLFeatureAttrs pimglfeatureattrs);

    public abstract int PIMGLZone_GetFeaturesForGroup(PIMGLContext pimglcontext, IntByReference intbyreference, PIMGLFeatureSet pimglfeatureset, String s);

    public abstract int PIMGLZone_GetFeaturesForPoint(PIMGLContext pimglcontext, IntByReference intbyreference, PIMGLFeatureSet pimglfeatureset, String as[], c c, float f, float f1, 
            boolean flag);

    public abstract int PIMGLZone_GetLineNumberError(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1);

    public abstract int PIMGLZone_GetLineNumberError(PIMGLContext pimglcontext, IntBuffer intbuffer, IntBuffer intbuffer1);

    public abstract int PIMGLZone_HasFeature(PIMGLContext pimglcontext, IntByReference intbyreference, String s);

    public abstract int PIMGLZone_HasFeature(PIMGLContext pimglcontext, IntBuffer intbuffer, String s);

    public abstract int PIMGLZone_IsPointInFeature(PIMGLContext pimglcontext, IntByReference intbyreference, String s, float f, float f1, Pointer pointer);

    public abstract int PIMGLZone_LoadSVG(PIMGLContext pimglcontext, IntByReference intbyreference, String s, int i, float f, float f1, float f2, 
            float f3, Pointer pointer);

    public abstract int PIMGLZone_LoadSVG(PIMGLContext pimglcontext, IntBuffer intbuffer, String s, int i, float f, float f1, float f2, 
            float f3, Pointer pointer);

    public abstract int PIMGLZone_ReleaseFeatureSet(PIMGLContext pimglcontext, PIMGLFeatureSet pimglfeatureset);

    public abstract int PIMGLZone_ResetSVGCache(PIMGLContext pimglcontext, Pointer pointer);

    public abstract int PIMGLZone_ResetSVGCache(PIMGLContext pimglcontext, String s);

    public abstract int PIMGLZone_Select(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGLZone_Select(PIMGLContext pimglcontext, IntBuffer intbuffer);

    public abstract int PIMGLZone_SetFeatureAttrs(PIMGLContext pimglcontext, IntByReference intbyreference, String s, PIMGLFeatureAttrs pimglfeatureattrs, float f, int i, boolean flag, 
            Pointer pointer);

    public abstract int PIMGLZone_SetFeatureAttrs(PIMGLContext pimglcontext, IntBuffer intbuffer, String s, PIMGLFeatureAttrs pimglfeatureattrs, float f, int i, boolean flag, 
            Pointer pointer);

    public abstract int PIMGLZone_SetFeatureAttrsImmediate(PIMGLContext pimglcontext, IntByReference intbyreference, String s, PIMGLFeatureAttrs pimglfeatureattrs);

    public abstract int PIMGLZone_SetFeatureMembersText(PIMGLContext pimglcontext, IntByReference intbyreference, Pointer pointer, Pointer pointer1);

    public abstract int PIMGLZone_SetFeatureMembersText(PIMGLContext pimglcontext, IntBuffer intbuffer, String s, String s1);

    public abstract int PIMGLZone_SetLevelOfDetail(PIMGLContext pimglcontext, IntByReference intbyreference, int i, boolean flag, boolean flag1, float f, float f1);

    public abstract int PIMGLZone_SetLevelOfDetailMode(PIMGLContext pimglcontext, int i, int j);

    public abstract int PIMGL_AdjustHeaderTextSizes(PIMGLContext pimglcontext, int i);

    public abstract int PIMGL_AppFinalize();

    public abstract int PIMGL_AppInitialize();

    public abstract int PIMGL_CountContexts(IntByReference intbyreference);

    public abstract int PIMGL_CountContexts(IntBuffer intbuffer);

    public abstract PIMGLContext PIMGL_CreateContext(String s, Pointer pointer, String s1, String s2);

    public abstract int PIMGL_DeleteContext(PIMGLContext pimglcontext);

    public abstract int PIMGL_DetectFramebuffer(PIMGLContext pimglcontext);

    public abstract int PIMGL_DetectGfxContext(PIMGLContext pimglcontext);

    public abstract int PIMGL_EnqueueTouchEvent(PIMGLContext pimglcontext, c c, double d, boolean flag, float f, float f1);

    public abstract int PIMGL_EnqueueTouchEventCancel(PIMGLContext pimglcontext, double d);

    public abstract int PIMGL_FormatLogMsg(String s, Pointer pointer, PointerByReference pointerbyreference);

    public abstract int PIMGL_FormatLogMsg(String s, Pointer pointer, ByteBuffer bytebuffer);

    public abstract int PIMGL_FreeLogMsg(Pointer pointer);

    public abstract PIMGLContext PIMGL_GetContext();

    public abstract int PIMGL_GetError(PIMGLContext pimglcontext);

    public abstract int PIMGL_NeedsRender(PIMGLContext pimglcontext, boolean flag);

    public abstract int PIMGL_Pause(PIMGLContext pimglcontext, boolean flag);

    public abstract int PIMGL_Render(PIMGLContext pimglcontext);

    public abstract int PIMGL_RunScript(PIMGLContext pimglcontext, Pointer pointer);

    public abstract int PIMGL_RunScript(PIMGLContext pimglcontext, String s);

    public abstract int PIMGL_SetButterflyAnchor(PIMGLContext pimglcontext, IntByReference intbyreference);

    public abstract int PIMGL_SetButterflyAnchor(PIMGLContext pimglcontext, IntBuffer intbuffer);

    public abstract int PIMGL_SetClearColor(PIMGLContext pimglcontext, float f, float f1, float f2);

    public abstract int PIMGL_SetContext(PIMGLContext pimglcontext);

    public abstract int PIMGL_SetEnvironmentCacheDir(PIMGLContext pimglcontext, Pointer pointer);

    public abstract int PIMGL_SetEnvironmentCacheDir(PIMGLContext pimglcontext, String s);

    public abstract int PIMGL_SetEventHandler(PIMGLContext pimglcontext, PIMGLEventHandlerFunc pimgleventhandlerfunc);

    public abstract int PIMGL_SetLogFunc(PIMGLLogFunc pimgllogfunc, Pointer pointer);

    public abstract int PIMGL_SetSVGFontFamily(PIMGLContext pimglcontext, IntByReference intbyreference, String s);

    public abstract int PIMGL_SetSVGFontFamily(PIMGLContext pimglcontext, IntBuffer intbuffer, String s);

    public abstract int PIMGL_SetSVGHeaderTextStyle(PIMGLContext pimglcontext, int i, IntByReference intbyreference, float f, float f1, float f2, float f3, 
            float f4, float f5, float f6, float f7, float f8, float f9, float f10, 
            float f11);

    public abstract int PIMGL_SetSVGHeaderTextStyle(PIMGLContext pimglcontext, int i, IntBuffer intbuffer, float f, float f1, float f2, float f3, 
            float f4, float f5, float f6, float f7, float f8, float f9, float f10, 
            float f11);

    public abstract int PIMGL_Update(PIMGLContext pimglcontext);

}
