// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;


// Referenced classes of package com.amazon.geo.mapsv2.model:
//            CameraPosition, LatLng

public static final class zoom
{

    private float bearing;
    private LatLng target;
    private float tilt;
    private float zoom;

    public zoom bearing(float f)
    {
        bearing = f;
        return this;
    }

    public CameraPosition build()
    {
        return new CameraPosition(this, null);
    }

    public bearing target(LatLng latlng)
    {
        target = latlng;
        return this;
    }

    public target tilt(float f)
    {
        tilt = f;
        return this;
    }

    public tilt zoom(float f)
    {
        zoom = f;
        return this;
    }





    public ()
    {
        bearing = 0.0F;
        tilt = 0.0F;
        zoom = 0.0F;
        target = null;
    }

    public target(CameraPosition cameraposition)
    {
        bearing = cameraposition.bearing;
        target = cameraposition.target;
        tilt = cameraposition.tilt;
        zoom = cameraposition.zoom;
    }
}
