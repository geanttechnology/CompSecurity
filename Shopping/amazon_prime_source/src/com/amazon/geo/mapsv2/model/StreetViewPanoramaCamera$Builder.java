// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import com.amazon.geo.mapsv2.pvt.AmazonMapsStrictModeHelper;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            StreetViewPanoramaCamera, StreetViewPanoramaOrientation

public static final class zoom
{

    public float bearing;
    public float tilt;
    public float zoom;

    public zoom bearing(float f)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        bearing = f;
        return this;
    }

    public StreetViewPanoramaCamera build()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return new StreetViewPanoramaCamera(zoom, tilt, bearing);
    }

    public bearing orientation(StreetViewPanoramaOrientation streetviewpanoramaorientation)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        bearing = streetviewpanoramaorientation.bearing;
        tilt = streetviewpanoramaorientation.tilt;
        return this;
    }

    public t tilt(float f)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        tilt = f;
        return this;
    }

    public tilt zoom(float f)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        zoom = f;
        return this;
    }

    public ()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
    }

    public eetViewStrictMode(StreetViewPanoramaCamera streetviewpanoramacamera)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        bearing = streetviewpanoramacamera.bearing;
        tilt = streetviewpanoramacamera.tilt;
        zoom = streetviewpanoramacamera.zoom;
    }
}
