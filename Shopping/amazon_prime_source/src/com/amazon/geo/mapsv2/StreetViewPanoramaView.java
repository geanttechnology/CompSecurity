// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.amazon.geo.mapsv2.pvt.AmazonMapsStrictModeHelper;

// Referenced classes of package com.amazon.geo.mapsv2:
//            StreetViewPanoramaOptions, StreetViewPanorama, OnStreetViewPanoramaReadyCallback

public class StreetViewPanoramaView extends FrameLayout
{

    public StreetViewPanoramaView(Context context)
    {
        super(context);
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        throw new UnsupportedOperationException("The street view API is not supported.");
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeset)
    {
        super(context);
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        throw new UnsupportedOperationException("The street view API is not supported.");
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeset, int i)
    {
        super(context);
        AmazonMapsStrictModeHelper.applyStreetViewStrictMode();
        throw new UnsupportedOperationException("The street view API is not supported.");
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetviewpanoramaoptions)
    {
        super(context);
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

    public final void onCreate(Bundle bundle)
    {
    }

    public final void onDestroy()
    {
    }

    public final void onLowMemory()
    {
    }

    public final void onPause()
    {
    }

    public final void onResume()
    {
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
    }
}
