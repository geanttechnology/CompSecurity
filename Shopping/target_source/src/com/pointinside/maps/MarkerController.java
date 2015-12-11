// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.g.a.a.a.c;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.maps.model.MarkerOptions;
import com.pointinside.model.Venue;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.pointinside.maps:
//            PIMap, PIMGL, Marker, Location, 
//            Projection, PIMGLAnnotationAttrs, PIMGLColor, MarkerImage, 
//            PIBitmap, MapUtil

class MarkerController
{

    private static final String TAG = com/pointinside/maps/MarkerController.getSimpleName();
    private final PIMap mMap;
    private final Map mMarkerImageStyleRefMap = new HashMap();
    private final Map mMarkerToRefMap = new HashMap();
    private final List mPendingMarkers = new ArrayList();

    MarkerController(PIMap pimap)
    {
        mMap = pimap;
    }

    private IntByReference addMarkerUsingStyle(PIMap pimap, IntByReference intbyreference, IntByReference intbyreference1, Location location, String s)
    {
        pimap = pimap.getPIMGLContext();
        IntByReference intbyreference2 = new IntByReference();
        PIMGL.ref_create(pimap, new PointerByReference(intbyreference2.getPointer()));
        PIMGL.annotation_create(pimap, intbyreference2, intbyreference1, intbyreference, location, 0.0F, s);
        return intbyreference2;
    }

    private void animateAddMarker(Marker marker, PIMGLAnnotationAttrs pimglannotationattrs, PIMap.AddMarkerAnimation addmarkeranimation)
    {
        PIMGLContext pimglcontext = mMap.getPIMGLContext();
        IntByReference intbyreference = marker.get();
        Location location = marker.getLocation();
        static class _cls1
        {

            static final int $SwitchMap$com$pointinside$maps$PIMap$AddMarkerAnimation[];

            static 
            {
                $SwitchMap$com$pointinside$maps$PIMap$AddMarkerAnimation = new int[PIMap.AddMarkerAnimation.values().length];
                try
                {
                    $SwitchMap$com$pointinside$maps$PIMap$AddMarkerAnimation[PIMap.AddMarkerAnimation.DROP.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$pointinside$maps$PIMap$AddMarkerAnimation[PIMap.AddMarkerAnimation.FADE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.pointinside.maps.PIMap.AddMarkerAnimation[addmarkeranimation.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            pimglannotationattrs.mYOffset = mMap.getProjection().pointInZoneToView(location.x, location.y).y;
            pimglannotationattrs.mScale = 1.0F;
            pimglannotationattrs.mShadowScale = 0.0F;
            pimglannotationattrs.mShadowAlpha = 1.0F;
            PIMGL.annotation_setAttrs(pimglcontext, intbyreference, pimglannotationattrs, 0.0F, 1, false, Pointer.NULL);
            float f = pimglannotationattrs.mYOffset;
            pimglannotationattrs.mYOffset = 0.0F;
            pimglannotationattrs.mShadowScale = 1.0F;
            PIMGL.annotation_setAttrs(pimglcontext, intbyreference, pimglannotationattrs, 0.5F * (f / mMap.getViewHeight()), 1, false, Pointer.NULL);
            return;

        case 2: // '\002'
            pimglannotationattrs.mXOffset = 0.0F;
            break;
        }
        pimglannotationattrs.mYOffset = 0.0F;
        pimglannotationattrs.mScale = 1.0F;
        pimglannotationattrs.mColor = PIMGLColor.fromColor(0);
        pimglannotationattrs.mShadowScale = 1.0F;
        pimglannotationattrs.mShadowAlpha = 0.0F;
        PIMGL.annotation_setAttrs(pimglcontext, intbyreference, pimglannotationattrs, 0.0F, 7, false, Pointer.NULL);
        int i = marker.getTintColor().intValue();
        if (i == 0x7fffffff)
        {
            pimglannotationattrs.mColor = PIMGLColor.fromColor(-1);
        } else
        {
            pimglannotationattrs.mColor = PIMGLColor.fromColor(i);
        }
        pimglannotationattrs.mShadowAlpha = 1.0F;
        PIMGL.annotation_setAttrs(pimglcontext, intbyreference, pimglannotationattrs, 1.5F, 7, false, Pointer.NULL);
    }

    private IntByReference createMarkerStyle(MarkerImage markerimage)
    {
        PIMGLContext pimglcontext = mMap.getPIMGLContext();
        IntByReference intbyreference1 = (IntByReference)mMarkerImageStyleRefMap.get(markerimage);
        IntByReference intbyreference = intbyreference1;
        if (intbyreference1 == null)
        {
            intbyreference = new IntByReference();
            PIMGL.ref_create(pimglcontext, new PointerByReference(intbyreference.getPointer()));
            PIMGL.annotationStyle_create(pimglcontext, intbyreference);
            createTextureForMarkerStyle(markerimage.marker, intbyreference, false);
            if (markerimage.shadow != null)
            {
                createTextureForMarkerStyle(markerimage.shadow, intbyreference, true);
            }
            mMarkerImageStyleRefMap.put(markerimage, intbyreference);
        }
        return intbyreference;
    }

    private void createTextureForMarkerStyle(Drawable drawable, IntByReference intbyreference, boolean flag)
    {
        PIMGLContext pimglcontext = mMap.getPIMGLContext();
        IntByReference intbyreference1 = new IntByReference();
        PIMGL.ref_create(pimglcontext, new PointerByReference(intbyreference1.getPointer()));
        PIBitmap pibitmap = new PIBitmap(drawable);
        pibitmap.write();
        Object obj = pibitmap.getPointer();
        pibitmap.read();
        PIMGL.texture_createFromData(pimglcontext, intbyreference1, ((Pointer) (obj)), new c(pibitmap.mBitMapBytes.length));
        obj = new IntByReference();
        PIMGL.ref_create(pimglcontext, new PointerByReference(((IntByReference) (obj)).getPointer()));
        PIMGL.image_create(pimglcontext, ((IntByReference) (obj)), intbyreference1);
        drawable = drawable.copyBounds();
        PIMGL.image_setModelRect(pimglcontext, ((IntByReference) (obj)), ((Rect) (drawable)).left, ((Rect) (drawable)).top, ((Rect) (drawable)).right, ((Rect) (drawable)).bottom);
        PIMGL.image_setUVRect(pimglcontext, ((IntByReference) (obj)), 0.0F, 0.0F, 1.0F, 1.0F);
        PIMGL.annotationStyle_setPinImage(pimglcontext, intbyreference, ((IntByReference) (obj)), flag);
        PIMGL.ref_release(pimglcontext, ((IntByReference) (obj)));
        PIMGL.ref_release(pimglcontext, intbyreference1);
        pibitmap.clear();
    }

    private IntByReference getMarkerStyleRef(MarkerOptions markeroptions)
    {
        Resources resources = mMap.getAppContext().getResources();
        Drawable drawable;
        Drawable drawable1;
        if (markeroptions.getMarkerDrawable() != null)
        {
            drawable = markeroptions.getMarkerDrawable();
        } else
        if (markeroptions.getMarkerResourceId() != 0x7fffffff)
        {
            drawable = resources.getDrawable(markeroptions.getMarkerResourceId());
        } else
        {
            drawable1 = resources.getDrawable(com.pointinside.R.drawable.ic_marker_default_white_48dp);
            drawable = drawable1;
            if (markeroptions.getTintColor() == 0x7fffffff)
            {
                markeroptions.tintColor(Color.rgb(27, 130, 178));
                drawable = drawable1;
            }
        }
        MapUtil.setBounds(drawable, markeroptions.getMarkerAnchorPoint());
        if (markeroptions.getShadowDrawable() != null)
        {
            drawable1 = markeroptions.getShadowDrawable();
        } else
        if (markeroptions.getShadowResourceId() != 0x7fffffff)
        {
            drawable1 = resources.getDrawable(markeroptions.getShadowResourceId());
        } else
        {
            drawable1 = null;
        }
        if (drawable1 != null)
        {
            MapUtil.setBounds(drawable1, markeroptions.getShadowAnchorPoint());
        }
        markeroptions.markerDrawable(null).shadowDrawable(null);
        return createMarkerStyle(new MarkerImage(drawable, drawable1));
    }

    private void logMarkersWhateverYouWant(String s)
    {
        LogUtils.logD(PIMGL.TAG, TAG, "/*******************************");
        LogUtils.logD(PIMGL.TAG, TAG, (new StringBuilder()).append("Marker operation: ").append(s).toString());
        LogUtils.logD(PIMGL.TAG, TAG, (new StringBuilder()).append("Total markers: ").append(String.valueOf(mMarkerToRefMap.size())).toString());
        LogUtils.logD(PIMGL.TAG, TAG, (new StringBuilder()).append("Total markerDrawable image combinations: ").append(String.valueOf(mMarkerImageStyleRefMap.size())).toString());
        LogUtils.logD(PIMGL.TAG, TAG, "********************************/");
    }

    private void updateAttrs(Marker marker, float f)
    {
        PIMGLContext pimglcontext = mMap.getPIMGLContext();
        Location location = marker.getLocation();
        IntByReference intbyreference = mMap.getZoneRefFromUUID(location.zone);
        IntByReference intbyreference1 = marker.get();
        PIMGLAnnotationAttrs pimglannotationattrs = new PIMGLAnnotationAttrs();
        PIMGL.annotation_getAttrs(pimglcontext, intbyreference1, pimglannotationattrs);
        pimglannotationattrs.mX = location.x;
        pimglannotationattrs.mY = -location.y;
        pimglannotationattrs.mZone = intbyreference;
        pimglannotationattrs.mStyle = marker.getStyle();
        pimglannotationattrs.mColor = PIMGLColor.fromColor(marker.getTintColor().intValue());
        PIMGL.annotation_setAttrs(pimglcontext, intbyreference1, pimglannotationattrs, f, 7, false, Pointer.NULL);
    }

    void addAnyPendingMarker(String s)
    {
        Object obj = new ArrayList();
        Iterator iterator = mPendingMarkers.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Marker marker = (Marker)iterator.next();
            Object obj1 = marker.getLocation();
            if (((Location) (obj1)).zone.equals(s))
            {
                IntByReference intbyreference = mMap.getZoneRefFromUUID(((Location) (obj1)).zone);
                IntByReference intbyreference1 = marker.getStyle();
                obj1 = addMarkerUsingStyle(mMap, intbyreference1, intbyreference, ((Location) (obj1)), marker.getTitle());
                marker.setRef(((IntByReference) (obj1)));
                mMarkerToRefMap.put(marker, obj1);
                updateAttrs(marker, 0.0F);
                logMarkersWhateverYouWant("Pending Marker added/updated");
                ((List) (obj)).add(marker);
            }
        } while (true);
        for (s = ((List) (obj)).iterator(); s.hasNext(); mPendingMarkers.remove(obj))
        {
            obj = (Marker)s.next();
        }

    }

    Marker addMarker(MarkerOptions markeroptions, PIMap.AddMarkerAnimation addmarkeranimation)
        throws IllegalArgumentException
    {
        PIMGLContext pimglcontext = mMap.getPIMGLContext();
        Object obj = MarkerOptions.copy(markeroptions);
        IntByReference intbyreference = mMap.getZoneRefFromUUID(((MarkerOptions) (obj)).getLocation().zone);
        Object obj1 = getMarkerStyleRef(((MarkerOptions) (obj)));
        if (intbyreference != null)
        {
            Location location = ((MarkerOptions) (obj)).getLocation();
            markeroptions = addMarkerUsingStyle(mMap, ((IntByReference) (obj1)), intbyreference, location, markeroptions.getTitle());
            obj = new Marker(this, ((MarkerOptions) (obj)), markeroptions, ((IntByReference) (obj1)));
            mMarkerToRefMap.put(obj, markeroptions);
            logMarkersWhateverYouWant("Marker added");
            obj1 = new PIMGLAnnotationAttrs();
            PIMGL.annotation_getAttrs(pimglcontext, markeroptions, ((PIMGLAnnotationAttrs) (obj1)));
            obj1.mColor = PIMGLColor.fromColor(((Marker) (obj)).getTintColor().intValue());
            PIMGL.annotation_setAttrs(pimglcontext, markeroptions, ((PIMGLAnnotationAttrs) (obj1)), 0.0F, 7, false, Pointer.NULL);
            animateAddMarker(((Marker) (obj)), ((PIMGLAnnotationAttrs) (obj1)), addmarkeranimation);
            return ((Marker) (obj));
        } else
        {
            Log.e(TAG, (new StringBuilder()).append("ZoneRef was null for Marker. Location zone = ").append(((MarkerOptions) (obj)).getLocation().zone).toString());
            markeroptions = new Marker(this, ((MarkerOptions) (obj)), null, ((IntByReference) (obj1)));
            mMarkerToRefMap.put(markeroptions, null);
            mPendingMarkers.add(markeroptions);
            return markeroptions;
        }
    }

    void clear(PIMap pimap)
    {
        pimap = pimap.getPIMGLContext();
        for (Iterator iterator = mMarkerToRefMap.entrySet().iterator(); iterator.hasNext(); PIMGL.annotation_delete(pimap, (IntByReference)((java.util.Map.Entry)iterator.next()).getValue())) { }
        for (Iterator iterator1 = mMarkerImageStyleRefMap.entrySet().iterator(); iterator1.hasNext(); PIMGL.ref_release(pimap, (IntByReference)((java.util.Map.Entry)iterator1.next()).getValue())) { }
        mMarkerImageStyleRefMap.clear();
        mMarkerToRefMap.clear();
        mPendingMarkers.clear();
    }

    Marker getMarker(Pointer pointer)
    {
        Iterator iterator = mMarkerToRefMap.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Object obj = (IntByReference)entry.getValue();
            if (obj != null)
            {
                obj = ((IntByReference) (obj)).getPointer();
                if (obj != null)
                {
                    if (((Pointer) (obj)).equals(pointer))
                    {
                        return (Marker)entry.getKey();
                    }
                } else
                {
                    Log.e(TAG, (new StringBuilder()).append("getMarker, entry ").append(entry).append(" has null mappedPointer value.").toString());
                }
            } else
            {
                Log.e(TAG, (new StringBuilder()).append("getMarker, entry ").append(entry).append(" has null value.").toString());
            }
        } while (true);
        return null;
    }

    boolean isMarkerLocationValid(PIMap pimap, Location location)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (location != null)
        {
            flag = flag1;
            if (pimap.getCurrentVenue().getUUID().equals(location.venue))
            {
                flag = flag1;
                if (location.zone != null)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    void removeMarker(Marker marker)
        throws IllegalArgumentException
    {
        PIMGL.annotation_delete(mMap.getPIMGLContext(), (IntByReference)mMarkerToRefMap.get(marker));
        mMarkerToRefMap.remove(marker);
        logMarkersWhateverYouWant("Marker removed");
    }

    void sendToBack(Marker marker)
        throws IllegalArgumentException
    {
        PIMGL.annotation_setBack(mMap.getPIMGLContext(), (IntByReference)mMarkerToRefMap.get(marker));
        logMarkersWhateverYouWant("Marker moved to end of stack");
    }

    void sendToFront(Marker marker)
        throws IllegalArgumentException
    {
        PIMGL.annotation_setFront(mMap.getPIMGLContext(), (IntByReference)mMarkerToRefMap.get(marker));
        logMarkersWhateverYouWant("Marker moved to beginning of stack");
    }

    boolean updateMarker(Marker marker, PIMap.UpdateMarkerAnimation updatemarkeranimation)
        throws IllegalArgumentException
    {
label0:
        {
            IntByReference intbyreference;
            Object obj;
            IntByReference intbyreference1;
label1:
            {
                obj = marker.getUpdate();
                intbyreference = getMarkerStyleRef(((MarkerOptions) (obj)));
                obj = ((MarkerOptions) (obj)).getLocation();
                if (isMarkerLocationValid(mMap, ((Location) (obj))))
                {
                    marker.setStyle(intbyreference);
                    intbyreference1 = mMap.getZoneRefFromUUID(((Location) (obj)).zone);
                    if (!marker.isDirty())
                    {
                        break label0;
                    }
                    if (intbyreference1 != null)
                    {
                        break label1;
                    }
                    logMarkersWhateverYouWant("Marker is dirty. Can't update right now");
                }
                return false;
            }
            intbyreference = addMarkerUsingStyle(mMap, intbyreference, intbyreference1, ((Location) (obj)), marker.getTitle());
            marker.setRef(intbyreference);
            mMarkerToRefMap.put(marker, intbyreference);
        }
        float f;
        if (updatemarkeranimation == PIMap.UpdateMarkerAnimation.NONE)
        {
            f = 0.0F;
        } else
        {
            f = 2.0F;
        }
        updateAttrs(marker, f);
        logMarkersWhateverYouWant("Marker updated");
        return true;
    }

}
