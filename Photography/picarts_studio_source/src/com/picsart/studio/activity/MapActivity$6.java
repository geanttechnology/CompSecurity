// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.activity;

import android.widget.ListView;
import com.google.android.gms.maps.model.Marker;

// Referenced classes of package com.picsart.studio.activity:
//            MapActivity, a

final class a
    implements com.google.android.gms.maps.rkerClickListener
{

    private MapActivity a;

    public final boolean onMarkerClick(Marker marker)
    {
        MapActivity.a(a, marker.getTitle());
        MapActivity.a(a).notifyDataSetChanged();
        MapActivity.c(a).setSelection(MapActivity.a(a).a(MapActivity.b(a)));
        return false;
    }

    rkerClickListener(MapActivity mapactivity)
    {
        a = mapactivity;
        super();
    }
}
