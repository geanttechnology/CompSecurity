// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.app.Fragment;
import com.amazon.geo.mapsv2.pvt.AmazonMapsStrictModeHelper;

// Referenced classes of package com.amazon.geo.mapsv2:
//            StreetViewPanoramaOptions, StreetViewPanorama, OnStreetViewPanoramaReadyCallback

public class StreetViewPanoramaFragment extends Fragment
{

    public StreetViewPanoramaFragment()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        throw new UnsupportedOperationException("The street view API is not supported.");
    }

    public static StreetViewPanoramaFragment newInstance()
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        throw new UnsupportedOperationException("The street view API is not supported.");
    }

    public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions streetviewpanoramaoptions)
    {
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        throw new UnsupportedOperationException("The street view API is not supported.");
    }

    public final StreetViewPanorama getStreetViewPanorama()
    {
        return null;
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
    {
    }
}
