// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.g.a.a.a.c;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.maps.model.MinMax;
import com.pointinside.maps.model.TextHeadingStyle;
import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.io.File;

// Referenced classes of package com.pointinside.maps:
//            PIMGLInterface, PIMGLUtil, Location, PIMGLEdgeInsets, 
//            PIMGLContext, PIMGLAccessibilityElementSet, PIMGLAnnotationAttrs, PIMGLCameraAttrs, 
//            PIMGLPoint, PIMGLRouteLegAttrs, PIMGLRouteAttrs, PIMGLZonePickerEntry, 
//            PIMGLFeatureSet, PIMGLFeatureAttrs

class PIMGL
{

    static final String TAG = com/pointinside/maps/PIMGL.getSimpleName();
    static boolean isAppInitialize;
    static final Object sAkuLock = new Object();

    PIMGL()
    {
    }

    static boolean accessibility_getVisibleElements(PIMGLContext pimglcontext, PIMGLAccessibilityElementSet pimglaccessibilityelementset)
    {
        boolean flag;
        synchronized (sAkuLock)
        {
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLAccessibility_GetVisibleElements(pimglcontext, pimglaccessibilityelementset));
        }
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void accessibility_releaseSet(PIMGLContext pimglcontext, PIMGLAccessibilityElementSet pimglaccessibilityelementset)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLAccessibility_ReleaseSet(pimglcontext, pimglaccessibilityelementset));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void annotationStyle_create(PIMGLContext pimglcontext, IntByReference intbyreference)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLAnnotationStyle_Create(pimglcontext, intbyreference));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void annotationStyle_setPinImage(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1, boolean flag)
    {
        Object obj = sAkuLock;
        obj;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLAnnotationStyle_SetShadowImage(pimglcontext, intbyreference, intbyreference1));
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLAnnotationStyle_SetPinImage(pimglcontext, intbyreference, intbyreference1));
        if (true) goto _L2; else goto _L1
_L1:
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void annotation_create(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1, IntByReference intbyreference2, Location location, float f, String s)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLAnnotation_Create(pimglcontext, intbyreference, intbyreference1, intbyreference2, location.x, -location.y, f, s));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void annotation_delete(PIMGLContext pimglcontext, IntByReference intbyreference)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLAnnotation_Delete(pimglcontext, intbyreference));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void annotation_getAttrs(PIMGLContext pimglcontext, IntByReference intbyreference, PIMGLAnnotationAttrs pimglannotationattrs)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLAnnotation_GetAttrs(pimglcontext, intbyreference, pimglannotationattrs));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static boolean annotation_pick(PIMGLContext pimglcontext, float f, float f1, PointerByReference pointerbyreference)
    {
        Object obj = sAkuLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (PIMGLInterface.INSTANCE.PIMGLAnnotation_Pick(pimglcontext, f, f1, pointerbyreference) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void annotation_setAttrs(PIMGLContext pimglcontext, IntByReference intbyreference, PIMGLAnnotationAttrs pimglannotationattrs, float f, int i, boolean flag, Pointer pointer)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLAnnotation_SetAttrs(pimglcontext, intbyreference, pimglannotationattrs, f, i, flag, pointer));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void annotation_setBack(PIMGLContext pimglcontext, IntByReference intbyreference)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLAnnotation_SetBack(pimglcontext, intbyreference));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void annotation_setFront(PIMGLContext pimglcontext, IntByReference intbyreference)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLAnnotation_SetFront(pimglcontext, intbyreference));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void appFinalize()
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_AppFinalize());
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void appInitialize()
    {
        synchronized (sAkuLock)
        {
            if (!isAppInitialize)
            {
                PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_AppInitialize());
                isAppInitialize = true;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void blueDotClearHeading(PIMGLContext pimglcontext, IntByReference intbyreference)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLBluedot_ClearHeading(pimglcontext, intbyreference));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static boolean blueDotCreate(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1, int i)
    {
        boolean flag;
        synchronized (sAkuLock)
        {
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLBluedot_Create(pimglcontext, intbyreference, intbyreference1, i));
        }
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void blueDotDelete(PIMGLContext pimglcontext, IntByReference intbyreference)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLBluedot_Delete(pimglcontext, intbyreference));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void blueDotSetCoreColor(PIMGLContext pimglcontext, IntByReference intbyreference, int i)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLBluedot_SetCoreColor(pimglcontext, intbyreference, i >> 24 & 0xff, i >> 16 & 0xff, i >> 8 & 0xff, i & 0xff));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void blueDotSetCoreRadius(PIMGLContext pimglcontext, IntByReference intbyreference, float f)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLBluedot_SetCoreRadius(pimglcontext, intbyreference, f));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void blueDotSetHeading(PIMGLContext pimglcontext, IntByReference intbyreference, float f)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLBluedot_SetHeading(pimglcontext, intbyreference, f));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void blueDotSetLocation(PIMGLContext pimglcontext, IntByReference intbyreference, float f, float f1)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLBluedot_SetLoc(pimglcontext, intbyreference, f, f1));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void blueDotSetRangeColor(PIMGLContext pimglcontext, IntByReference intbyreference, int i)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLBluedot_SetRangeColor(pimglcontext, intbyreference, i >> 24 & 0xff, i >> 16 & 0xff, i >> 8 & 0xff, i & 0xff));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void blueDotSetRangeRadius(PIMGLContext pimglcontext, IntByReference intbyreference, float f)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLBluedot_SetRangeRadius(pimglcontext, intbyreference, f));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void blueDotSetUnknownState(PIMGLContext pimglcontext, IntByReference intbyreference, boolean flag)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLBluedot_SetUnknownState(pimglcontext, intbyreference, flag));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static boolean camera_convertViewToWorld(PIMGLContext pimglcontext, float f, float f1, FloatByReference floatbyreference, FloatByReference floatbyreference1)
    {
        boolean flag;
        synchronized (sAkuLock)
        {
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_ConvertViewToWorld(pimglcontext, f, f1, floatbyreference, floatbyreference1));
        }
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static boolean camera_convertWorldToView(PIMGLContext pimglcontext, float f, float f1, FloatByReference floatbyreference, FloatByReference floatbyreference1)
    {
        boolean flag;
        synchronized (sAkuLock)
        {
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_ConvertWorldToView(pimglcontext, f, f1, floatbyreference, floatbyreference1));
        }
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void camera_enableDolly(PIMGLContext pimglcontext, boolean flag)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_EnableDolly(pimglcontext, flag));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void camera_enableOrbit(PIMGLContext pimglcontext, boolean flag)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_EnableOrbit(pimglcontext, flag));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void camera_enableTapZoom(PIMGLContext pimglcontext, boolean flag)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_EnableTapZoom(pimglcontext, flag));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void camera_enableTilt(PIMGLContext pimglcontext, boolean flag)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_EnableTilt(pimglcontext, flag));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void camera_enableTruck(PIMGLContext pimglcontext, boolean flag)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_EnableTruck(pimglcontext, flag));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void camera_getAttrs(PIMGLContext pimglcontext, PIMGLCameraAttrs pimglcameraattrs)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_GetAttrs(pimglcontext, pimglcameraattrs));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void camera_getFit(PIMGLContext pimglcontext, PIMGLCameraAttrs pimglcameraattrs, PIMGLPoint pimglpoint, int i, PIMGLEdgeInsets pimgledgeinsets, PIMGLCameraAttrs pimglcameraattrs1)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_GetFit(pimglcontext, pimglcameraattrs, pimglpoint, i, (PIMGLEdgeInsets.ByValue)pimgledgeinsets.byValue(), pimglcameraattrs1));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void camera_setAttrs(PIMGLContext pimglcontext, PIMGLCameraAttrs pimglcameraattrs, float f, int i, boolean flag, Pointer pointer)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_SetAttrs(pimglcontext, pimglcameraattrs, f, i, flag, pointer));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void camera_setLocBounds(PIMGLContext pimglcontext, RectF rectf)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_SetLocBounds(pimglcontext, rectf.left, -rectf.bottom, rectf.right, -rectf.top));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void camera_setLocMomentumDecay(PIMGLContext pimglcontext, float f)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_SetLocMomentumDecay(pimglcontext, f));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void camera_setScopeBounds(PIMGLContext pimglcontext, float f, float f1)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_SetScopeBounds(pimglcontext, f, f1));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void camera_setTapZoomStops(PIMGLContext pimglcontext, float f, float f1)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_SetTapZoomStops(pimglcontext, f, f1));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void camera_setTiltBounds(PIMGLContext pimglcontext, MinMax minmax)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_SetTiltBounds(pimglcontext, minmax.minimum, minmax.maximum));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void camera_setZoomMode(PIMGLContext pimglcontext, int i)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLCamera_SetZoomMode(pimglcontext, i));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static PIMGLColor.ByValue color_create(float f, float f1, float f2, float f3)
    {
        PIMGLColor.ByValue byvalue1;
        synchronized (sAkuLock)
        {
            byvalue1 = PIMGLInterface.INSTANCE.PIMGLColor_Create(f, f1, f2, f3);
        }
        return byvalue1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static boolean countContexts(IntByReference intbyreference)
    {
        boolean flag;
        synchronized (sAkuLock)
        {
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_CountContexts(intbyreference));
        }
        return flag;
        intbyreference;
        obj;
        JVM INSTR monitorexit ;
        throw intbyreference;
    }

    static PIMGLContext createContext(Context context)
    {
        synchronized (sAkuLock)
        {
            String s = PIMGLUtil.getRawAssetsPath(context);
            context = context.getFilesDir().getPath();
            context = PIMGLInterface.INSTANCE.PIMGL_CreateContext("/bundle/assets/", Pointer.NULL, s, context);
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static boolean deleteContext(PIMGLContext pimglcontext)
    {
        boolean flag;
        synchronized (sAkuLock)
        {
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_DeleteContext(pimglcontext));
        }
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void detectGfxContext(PIMGLContext pimglcontext)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_DetectGfxContext(pimglcontext));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void display_setScreenSize(PIMGLContext pimglcontext, Context context)
    {
        synchronized (sAkuLock)
        {
            context = context.getResources().getDisplayMetrics();
            int i = ((DisplayMetrics) (context)).widthPixels;
            int j = ((DisplayMetrics) (context)).heightPixels;
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLDisplay_SetScreenSize(pimglcontext, i, j));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void display_setViewSize(PIMGLContext pimglcontext, int i, int j)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLDisplay_SetViewSize(pimglcontext, i, j));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void enqueueTouchEvent(PIMGLContext pimglcontext, MotionEvent motionevent, int i, boolean flag)
    {
        synchronized (sAkuLock)
        {
            double d = motionevent.getEventTime() / 1000L;
            int j = motionevent.getPointerId(i);
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_EnqueueTouchEvent(pimglcontext, new c(j), d, flag, motionevent.getX(i), motionevent.getY(i)));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void enqueueTouchEvent(PIMGLContext pimglcontext, c c1, double d, boolean flag, float f, float f1)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_EnqueueTouchEvent(pimglcontext, c1, d, flag, f, f1));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void enqueueTouchEventCancel(PIMGLContext pimglcontext, MotionEvent motionevent)
    {
        synchronized (sAkuLock)
        {
            double d = motionevent.getEventTime() / 1000L;
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_EnqueueTouchEventCancel(pimglcontext, d));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void font_create(PIMGLContext pimglcontext, IntByReference intbyreference, String s)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLFont_Create(pimglcontext, intbyreference, s));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static int font_createWithOutline(PIMGLContext pimglcontext, IntByReference intbyreference, String s, String s1)
    {
        int i;
        synchronized (sAkuLock)
        {
            i = PIMGLInterface.INSTANCE.PIMGLFont_CreateWithOutline(pimglcontext, intbyreference, s, s1);
            PIMGLUtil.validate(i);
        }
        return i;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void formatString(String s, Pointer pointer, PointerByReference pointerbyreference)
    {
        synchronized (sAkuLock)
        {
            PIMGLInterface.INSTANCE.PIMGL_FormatLogMsg(s, pointer, pointerbyreference);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static void freeString(Pointer pointer)
    {
        synchronized (sAkuLock)
        {
            PIMGLInterface.INSTANCE.PIMGL_FreeLogMsg(pointer);
        }
        return;
        pointer;
        obj;
        JVM INSTR monitorexit ;
        throw pointer;
    }

    static void image_create(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLImage_Create(pimglcontext, intbyreference, intbyreference1));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void image_setModelRect(PIMGLContext pimglcontext, IntByReference intbyreference, float f, float f1, float f2, float f3)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLImage_SetModelRect(pimglcontext, intbyreference, f, f1, f2, f3));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void image_setUVRect(PIMGLContext pimglcontext, IntByReference intbyreference, float f, float f1, float f2, float f3)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLImage_SetUVRect(pimglcontext, intbyreference, f, f1, f2, f3));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void needsRender(PIMGLContext pimglcontext, boolean flag)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_NeedsRender(pimglcontext, flag));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void overlay_Create(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLOverlay_Create(pimglcontext, intbyreference, intbyreference1));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void overlay_Delete(PIMGLContext pimglcontext, IntByReference intbyreference)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLOverlay_Delete(pimglcontext, intbyreference));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void pause(PIMGLContext pimglcontext)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_Pause(pimglcontext, true));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void ref_create(PIMGLContext pimglcontext, PointerByReference pointerbyreference)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLRef_Create(pimglcontext, pointerbyreference));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void ref_release(PIMGLContext pimglcontext, IntByReference intbyreference)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLRef_Release(pimglcontext, intbyreference));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static int render(PIMGLContext pimglcontext)
    {
        int i;
        synchronized (sAkuLock)
        {
            i = PIMGLInterface.INSTANCE.PIMGL_Render(pimglcontext);
        }
        return i;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void resume(PIMGLContext pimglcontext)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_Pause(pimglcontext, false));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static boolean route_FinishLeg(PIMGLContext pimglcontext, IntByReference intbyreference, PIMGLRouteLegAttrs pimglroutelegattrs)
    {
        boolean flag;
        synchronized (sAkuLock)
        {
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLRoute_FinishLeg(pimglcontext, intbyreference, pimglroutelegattrs));
        }
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static boolean route_addPoint(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1, Location location)
    {
        boolean flag;
        synchronized (sAkuLock)
        {
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLRoute_AddPoint(pimglcontext, intbyreference, intbyreference1, location.x, -location.y));
        }
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static boolean route_create(PIMGLContext pimglcontext, IntByReference intbyreference, PIMGLRouteAttrs pimglrouteattrs)
    {
        boolean flag;
        synchronized (sAkuLock)
        {
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLRoute_Create(pimglcontext, intbyreference, pimglrouteattrs));
        }
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static boolean route_delete(PIMGLContext pimglcontext, IntByReference intbyreference)
    {
        boolean flag;
        synchronized (sAkuLock)
        {
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLRoute_Delete(pimglcontext, intbyreference));
        }
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static int route_finishRoute(PIMGLContext pimglcontext, IntByReference intbyreference, Pointer pointer)
    {
        int i;
        synchronized (sAkuLock)
        {
            i = PIMGLInterface.INSTANCE.PIMGLRoute_FinishRoute(pimglcontext, intbyreference, pointer);
            PIMGLUtil.validate(i);
        }
        return i;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static boolean route_getAttrs(PIMGLContext pimglcontext, IntByReference intbyreference, int i, PIMGLRouteAttrs pimglrouteattrs)
    {
        boolean flag;
        synchronized (sAkuLock)
        {
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLRoute_GetAttrs(pimglcontext, intbyreference, i, pimglrouteattrs));
        }
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static boolean route_getNumOfLegs(PIMGLContext pimglcontext, IntByReference intbyreference, IntByReference intbyreference1)
    {
        boolean flag;
        synchronized (sAkuLock)
        {
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLRoute_GetNumOfLegs(pimglcontext, intbyreference, intbyreference1));
        }
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static boolean route_setAttrs(PIMGLContext pimglcontext, IntByReference intbyreference, int i, PIMGLRouteAttrs pimglrouteattrs, float f, int j, boolean flag, Pointer pointer)
    {
        synchronized (sAkuLock)
        {
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLRoute_SetAttrs(pimglcontext, intbyreference, i, pimglrouteattrs, f, j, flag, pointer));
        }
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void setClearColor(PIMGLContext pimglcontext, int i)
    {
        synchronized (sAkuLock)
        {
            float f = (float)Color.red(i) / 255F;
            float f1 = (float)Color.green(i) / 255F;
            float f2 = (float)Color.blue(i) / 255F;
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_SetClearColor(pimglcontext, f, f1, f2));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void setEnvironmentCacheDir(PIMGLContext pimglcontext, String s)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_SetEnvironmentCacheDir(pimglcontext, s));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void setEventListener(PIMGLContext pimglcontext, PIMGLInterface.PIMGLEventHandlerFunc pimgleventhandlerfunc)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_SetEventHandler(pimglcontext, pimgleventhandlerfunc));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void setLogFunc(PIMGLInterface.PIMGLLogFunc pimgllogfunc, Pointer pointer)
    {
        synchronized (sAkuLock)
        {
            PIMGLInterface.INSTANCE.PIMGL_SetLogFunc(pimgllogfunc, pointer);
        }
        return;
        pimgllogfunc;
        obj;
        JVM INSTR monitorexit ;
        throw pimgllogfunc;
    }

    static void setSVGFontFamily(PIMGLContext pimglcontext, IntByReference intbyreference, String s)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_SetSVGFontFamily(pimglcontext, intbyreference, s));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void setSVGHeaderTextStyle(PIMGLContext pimglcontext, int i, IntByReference intbyreference, TextHeadingStyle textheadingstyle)
    {
        synchronized (sAkuLock)
        {
            float f = textheadingstyle.getSize();
            int j = textheadingstyle.getTextColor();
            int k = textheadingstyle.getOutlineColor();
            float f1 = textheadingstyle.getOutlineWidth();
            float f2 = (float)Color.red(j) / 255F;
            float f3 = (float)Color.green(j) / 255F;
            float f4 = (float)Color.blue(j) / 255F;
            float f5 = (float)Color.alpha(j) / 255F;
            float f6 = (float)Color.red(k) / 255F;
            float f7 = (float)Color.green(k) / 255F;
            float f8 = (float)Color.blue(k) / 255F;
            float f9 = (float)Color.alpha(k) / 255F;
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGL_SetSVGHeaderTextStyle(pimglcontext, i, intbyreference, f, f2, f3, f4, f5, 6F, 0.0F, f6, f7, f8, f9, f1));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void texture_createFromData(PIMGLContext pimglcontext, IntByReference intbyreference, Pointer pointer, c c1)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLTexture_CreateFromData(pimglcontext, intbyreference, pointer, c1));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void texture_createFromFile(PIMGLContext pimglcontext, IntByReference intbyreference, String s)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLTexture_CreateFromFile(pimglcontext, intbyreference, s));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static int update(PIMGLContext pimglcontext)
    {
        int i;
        synchronized (sAkuLock)
        {
            i = PIMGLInterface.INSTANCE.PIMGL_Update(pimglcontext);
        }
        return i;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void zonePicker_SetHighlightedZone(PIMGLContext pimglcontext, IntByReference intbyreference, boolean flag, Pointer pointer)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZonePicker_SetHighlightedZone(pimglcontext, intbyreference, flag, pointer));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void zonePicker_hide(PIMGLContext pimglcontext, boolean flag, Pointer pointer)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZonePicker_Hide(pimglcontext, flag, pointer));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void zonePicker_setLabelOutline(PIMGLContext pimglcontext, float f, float f1, float f2, float f3, float f4)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZonePicker_SetLabelOutline(pimglcontext, f, f1, f2, f3, f4));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void zonePicker_setLabelTextColor(PIMGLContext pimglcontext, int i)
    {
        synchronized (sAkuLock)
        {
            float f = (float)Color.red(i) / 255F;
            float f1 = (float)Color.green(i) / 255F;
            float f2 = (float)Color.blue(i) / 255F;
            float f3 = (float)Color.alpha(i) / 255F;
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZonePicker_SetLabelTextColor(pimglcontext, f, f1, f2, f3));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void zonePicker_setLabelTextStyle(PIMGLContext pimglcontext, IntByReference intbyreference, float f, float f1, float f2)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZonePicker_SetLabelTextStyle(pimglcontext, intbyreference, f, f1, f2));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void zonePicker_show(PIMGLContext pimglcontext, PIMGLZonePickerEntry pimglzonepickerentry, int i, IntByReference intbyreference, boolean flag, boolean flag1, Pointer pointer)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZonePicker_Show(pimglcontext, pimglzonepickerentry, i, intbyreference, flag, flag1, pointer));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void zonePicker_showLabel(PIMGLContext pimglcontext, boolean flag)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZonePicker_ShowLabel(pimglcontext, flag));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void zone_create(PIMGLContext pimglcontext, IntByReference intbyreference)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZone_Create(pimglcontext, intbyreference));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void zone_delete(PIMGLContext pimglcontext, IntByReference intbyreference)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZone_Delete(pimglcontext, intbyreference));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static RectF zone_getBounds(PIMGLContext pimglcontext, IntByReference intbyreference)
    {
        synchronized (sAkuLock)
        {
            FloatByReference floatbyreference = new FloatByReference();
            FloatByReference floatbyreference1 = new FloatByReference();
            FloatByReference floatbyreference2 = new FloatByReference();
            FloatByReference floatbyreference3 = new FloatByReference();
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZone_GetBounds(pimglcontext, intbyreference, floatbyreference, floatbyreference1, floatbyreference3, floatbyreference2));
            pimglcontext = new RectF(floatbyreference.getValue(), Math.abs(floatbyreference2.getValue()), floatbyreference3.getValue(), Math.abs(floatbyreference1.getValue()));
        }
        return pimglcontext;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static boolean zone_getDistanceToFeatures(PIMGLContext pimglcontext, IntByReference intbyreference, PIMGLFeatureSet pimglfeatureset, String as[], c c1, float f, float f1, byte byte0)
    {
        boolean flag;
        synchronized (sAkuLock)
        {
            PointerByReference pointerbyreference = new PointerByReference();
            pointerbyreference.setPointer(new StringArray(as));
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZone_GetDistanceToFeatures(pimglcontext, intbyreference, pimglfeatureset, pointerbyreference, c1, f, f1, byte0));
        }
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static int zone_getFeatureAttrs(PIMGLContext pimglcontext, IntByReference intbyreference, String s, PIMGLFeatureAttrs pimglfeatureattrs)
    {
        int i;
        synchronized (sAkuLock)
        {
            i = PIMGLInterface.INSTANCE.PIMGLZone_GetFeatureAttrs(pimglcontext, intbyreference, s, pimglfeatureattrs);
            PIMGLUtil.validate(i);
        }
        return i;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static boolean zone_getFeaturesForPoint(PIMGLContext pimglcontext, IntByReference intbyreference, PIMGLFeatureSet pimglfeatureset, String as[], c c1, float f, float f1, boolean flag)
    {
        synchronized (sAkuLock)
        {
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZone_GetFeaturesForPoint(pimglcontext, intbyreference, pimglfeatureset, as, c1, f, f1, flag));
        }
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static int zone_hasFeature(PIMGLContext pimglcontext, IntByReference intbyreference, String s)
    {
        int i;
        synchronized (sAkuLock)
        {
            i = PIMGLInterface.INSTANCE.PIMGLZone_HasFeature(pimglcontext, intbyreference, s);
        }
        return i;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void zone_isPointInFeature(PIMGLContext pimglcontext, IntByReference intbyreference, String s, float f, float f1, Pointer pointer)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZone_IsPointInFeature(pimglcontext, intbyreference, s, f, f1, pointer));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static int zone_loadSVG(PIMGLContext pimglcontext, IntByReference intbyreference, String s, int i, float f, float f1, float f2, float f3, 
            Pointer pointer)
    {
        synchronized (sAkuLock)
        {
            i = PIMGLInterface.INSTANCE.PIMGLZone_LoadSVG(pimglcontext, intbyreference, s, i, f, f1, f2, f3, pointer);
        }
        return i;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static boolean zone_releaseFeatureSet(PIMGLContext pimglcontext, PIMGLFeatureSet pimglfeatureset)
    {
        boolean flag;
        synchronized (sAkuLock)
        {
            flag = PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZone_ReleaseFeatureSet(pimglcontext, pimglfeatureset));
        }
        return flag;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void zone_select(PIMGLContext pimglcontext, IntByReference intbyreference)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZone_Select(pimglcontext, intbyreference));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static int zone_setFeatureAttrs(PIMGLContext pimglcontext, IntByReference intbyreference, String s, PIMGLFeatureAttrs pimglfeatureattrs, float f, int i, boolean flag, Pointer pointer)
    {
        synchronized (sAkuLock)
        {
            i = PIMGLInterface.INSTANCE.PIMGLZone_SetFeatureAttrs(pimglcontext, intbyreference, s, pimglfeatureattrs, f, i, flag, pointer);
        }
        return i;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static int zone_setFeatureAttrsImmediate(PIMGLContext pimglcontext, IntByReference intbyreference, String s, PIMGLFeatureAttrs pimglfeatureattrs)
    {
        int i;
        synchronized (sAkuLock)
        {
            i = PIMGLInterface.INSTANCE.PIMGLZone_SetFeatureAttrsImmediate(pimglcontext, intbyreference, s, pimglfeatureattrs);
        }
        return i;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void zone_setLevelOfDetail(PIMGLContext pimglcontext, IntByReference intbyreference, int i, boolean flag, boolean flag1, float f, float f1)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZone_SetLevelOfDetail(pimglcontext, intbyreference, i, flag, flag1, f, f1));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static void zone_setLevelOfDetailMode(PIMGLContext pimglcontext, int i, int j)
    {
        synchronized (sAkuLock)
        {
            PIMGLUtil.validate(PIMGLInterface.INSTANCE.PIMGLZone_SetLevelOfDetailMode(pimglcontext, i, j));
        }
        return;
        pimglcontext;
        obj;
        JVM INSTR monitorexit ;
        throw pimglcontext;
    }

    static 
    {
        LogUtils.logV(TAG, "Loading libpimgl.so");
        System.loadLibrary("pimgl");
    }
}
