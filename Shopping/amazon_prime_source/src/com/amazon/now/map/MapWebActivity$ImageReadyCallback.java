// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;

import android.graphics.Bitmap;
import com.amazon.geo.mapsv2.model.BitmapDescriptorFactory;
import com.amazon.geo.mapsv2.model.Marker;

// Referenced classes of package com.amazon.now.map:
//            MapWebActivity

private static class mMarker
    implements com.amazon.now.util.Marker
{

    private Marker mMarker;

    public void bitmapReady(Bitmap bitmap)
    {
        mMarker.setIcon(BitmapDescriptorFactory.fromBitmap(bitmap));
        mMarker.setVisible(true);
    }

    public (Marker marker)
    {
        mMarker = marker;
    }
}
