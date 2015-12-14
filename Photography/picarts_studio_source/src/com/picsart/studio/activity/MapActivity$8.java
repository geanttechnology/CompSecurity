// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.activity;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.picsart.studio.utils.d;

// Referenced classes of package com.picsart.studio.activity:
//            MapActivity, a

final class a
    implements com.google.android.gms.maps.foWindowClickListener
{

    private MapActivity a;

    public final void onInfoWindowClick(Marker marker)
    {
        MapActivity.a(a, marker.getTitle(), (int)(marker.getPosition().latitude * 1000000D), (int)(marker.getPosition().longitude * 1000000D), ((d)MapActivity.a(a).getItem(MapActivity.a(a).a(MapActivity.b(a)))).h);
        a.finish();
    }

    foWindowClickListener(MapActivity mapactivity)
    {
        a = mapactivity;
        super();
    }
}
