// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;
import com.pointinside.maps.model.CameraPosition;
import com.pointinside.model.Zone;

// Referenced classes of package com.pointinside.maps:
//            PIMap, Projection

class MapUtil
{

    private static final float MAX_DISTANCE_AT_MAP_ANIMATE_RATE_OFFSET = 597F;
    private static final float MAX_DURATION_FOR_MAP_ANIMATE_RATE_OFFSET = 1F;
    private static final float MIN_DISTANCE_AT_MAP_ANIMATE_RATE_OFFSET = 128F;
    private static final float MIN_DURATION_FOR_MAP_ANIMATE_RATE_OFFSET = 0.217F;
    private static final float Seconds_PER_POINT_FOR_MAP_ANIMATE_RATE_OFFSET = 0.0015685F;

    MapUtil()
    {
    }

    static float computeTraversalDurationForPreviousLocation(PIMap pimap, PointF pointf, PointF pointf1)
    {
        pimap = pimap.getProjection();
        pointf = pimap.pointInZoneToView(pointf.x, pointf.y);
        pimap = pimap.pointInZoneToView(pointf1.x, pointf1.y);
        float f = Math.abs(pointf.x - ((PointF) (pimap)).x);
        float f1 = Math.abs(pointf.y - ((PointF) (pimap)).y);
        double d = Math.pow(f, 2D);
        f = (float)Math.sqrt(Math.pow(f1, 2D) + d) / 2.0F;
        if (f < 128F)
        {
            return 0.217F;
        }
        if (f > 597F)
        {
            return 1.0F;
        } else
        {
            return f * 0.0015685F;
        }
    }

    static float getRawTextSize(Context context, float f)
    {
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    static String getZoneImagePath(Zone zone, Context context)
    {
        return Uri.parse(zone.getImagePath(context.getCacheDir())).toString();
    }

    static boolean isItJustPointInZoneChange(CameraPosition cameraposition, CameraPosition cameraposition1)
    {
        return !cameraposition.pointInZone.equals(cameraposition1.pointInZone) && cameraposition.zone.getUUID().equals(cameraposition1.zone.getUUID()) && cameraposition.visibleMapWidth == cameraposition1.visibleMapWidth && cameraposition.tilt == cameraposition1.tilt && cameraposition.rotation == cameraposition1.rotation;
    }

    static Drawable setBounds(Drawable drawable, com.pointinside.maps.model.MarkerOptions.AnchorPoint anchorpoint)
    {
        int i;
        int l;
        int i1;
        l = 0;
        i = drawable.getIntrinsicWidth();
        i1 = drawable.getIntrinsicHeight();
        static class _cls1
        {

            static final int $SwitchMap$com$pointinside$maps$model$MarkerOptions$AnchorPoint[];

            static 
            {
                $SwitchMap$com$pointinside$maps$model$MarkerOptions$AnchorPoint = new int[com.pointinside.maps.model.MarkerOptions.AnchorPoint.values().length];
                try
                {
                    $SwitchMap$com$pointinside$maps$model$MarkerOptions$AnchorPoint[com.pointinside.maps.model.MarkerOptions.AnchorPoint.CENTER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$pointinside$maps$model$MarkerOptions$AnchorPoint[com.pointinside.maps.model.MarkerOptions.AnchorPoint.CENTER_BOTTOM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.pointinside.maps.model.MarkerOptions.AnchorPoint[anchorpoint.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 63
    //                   2 88;
           goto _L1 _L2 _L3
_L1:
        int j;
        int k;
        i = 0;
        j = 0;
        k = 0;
_L5:
        drawable.setBounds(k, j, i, l);
        return drawable;
_L2:
        k = -i / 2;
        j = -i1 / 2;
        i /= 2;
        l = i1 / 2;
        continue; /* Loop/switch isn't completed */
_L3:
        k = -i / 2;
        i += k;
        j = -i1;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
