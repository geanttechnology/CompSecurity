// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.model.CameraPosition;
import com.amazon.geo.mapsv2.model.internal.ICameraPositionPrimitive;
import com.amazon.geo.mapsv2.model.internal.ILatLngPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            Primitives

public class CameraPositionPrimitive extends PrimitiveBase
    implements ICameraPositionPrimitive
{

    private final ILatLngPrimitive mTarget;

    public CameraPositionPrimitive(CameraPosition cameraposition)
    {
        super(cameraposition);
        mTarget = Primitives.create(cameraposition.target);
    }

    public float getBearing()
    {
        return ((CameraPosition)get()).bearing;
    }

    public ILatLngPrimitive getTarget()
    {
        return mTarget;
    }

    public float getTilt()
    {
        return ((CameraPosition)get()).tilt;
    }

    public float getZoom()
    {
        return ((CameraPosition)get()).zoom;
    }
}
