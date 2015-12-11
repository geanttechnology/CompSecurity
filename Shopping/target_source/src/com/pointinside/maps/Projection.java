// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.graphics.PointF;
import com.sun.jna.ptr.FloatByReference;

// Referenced classes of package com.pointinside.maps:
//            PIMap, PIMGL

public final class Projection
{

    private final PIMap mMap;

    Projection(PIMap pimap)
    {
        mMap = pimap;
    }

    public PointF pointInZoneToView(float f, float f1)
    {
        FloatByReference floatbyreference = new FloatByReference();
        FloatByReference floatbyreference1 = new FloatByReference();
        PIMGL.camera_convertWorldToView(mMap.getPIMGLContext(), f, f1, floatbyreference, floatbyreference1);
        return new PointF(floatbyreference.getValue(), floatbyreference1.getValue());
    }

    public PointF viewToPointInZone(float f, float f1)
    {
        FloatByReference floatbyreference = new FloatByReference();
        FloatByReference floatbyreference1 = new FloatByReference();
        PIMGL.camera_convertViewToWorld(mMap.getPIMGLContext(), f, f1, floatbyreference, floatbyreference1);
        return new PointF(floatbyreference.getValue(), -floatbyreference1.getValue());
    }
}
