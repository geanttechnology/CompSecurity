// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.activity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// Referenced classes of package com.picsart.studio.activity:
//            MapActivity

final class a
    implements com.google.android.gms.maps.pLongClickListener
{

    private MapActivity a;

    public final void onMapLongClick(LatLng latlng)
    {
        MarkerOptions markeroptions = (new MarkerOptions()).position(latlng).title(latlng.toString());
        MapActivity.d(a).clear();
        MapActivity.d(a).addMarker(markeroptions);
        MapActivity.a(a, latlng.latitude, latlng.longitude);
    }

    tions(MapActivity mapactivity)
    {
        a = mapactivity;
        super();
    }
}
