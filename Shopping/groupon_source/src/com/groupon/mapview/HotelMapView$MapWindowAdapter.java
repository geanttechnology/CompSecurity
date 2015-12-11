// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mapview;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.maps.model.Marker;

// Referenced classes of package com.groupon.mapview:
//            HotelMapView

private static class context
    implements com.google.android.gms.maps.
{

    private final Context context;

    public View getInfoContents(Marker marker)
    {
        return null;
    }

    public View getInfoWindow(Marker marker)
    {
        marker = new TextView(context);
        marker.setLayoutParams(new android.view.dapter.context(-2, -2));
        marker.setText(" ");
        return marker;
    }

    public apter(Context context1)
    {
        context = context1;
    }
}
