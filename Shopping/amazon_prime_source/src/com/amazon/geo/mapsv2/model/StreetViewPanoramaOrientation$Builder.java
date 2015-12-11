// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import com.amazon.geo.mapsv2.pvt.AmazonMapsStrictModeHelper;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            StreetViewPanoramaOrientation

public static final class tilt
{

    public float bearing;
    public float tilt;

    public tilt bearing(float f)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        bearing = f;
        return this;
    }

    public StreetViewPanoramaOrientation build()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        return new StreetViewPanoramaOrientation(tilt, bearing);
    }

    public bearing tilt(float f)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        tilt = f;
        return this;
    }

    public ()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
    }

    public ewStrictMode(StreetViewPanoramaOrientation streetviewpanoramaorientation)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        bearing = streetviewpanoramaorientation.bearing;
        tilt = streetviewpanoramaorientation.tilt;
    }
}
