// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import java.net.URLEncoder;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            ShowOnMap

class this._cls0
    implements com.google.android.gms.maps.InfoWindowClickListener
{

    final ShowOnMap this$0;

    public void onInfoWindowClick(Marker marker)
    {
        marker = String.format("geo:%s,%s?q=%s", new Object[] {
            Double.valueOf(marker.getPosition().latitude), Double.valueOf(marker.getPosition().longitude), URLEncoder.encode(marker.getSnippet())
        });
        Ln.d((new StringBuilder()).append("Loading map for address with URI: ").append(marker).toString(), new Object[0]);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(marker)));
    }

    .Marker()
    {
        this$0 = ShowOnMap.this;
        super();
    }
}
