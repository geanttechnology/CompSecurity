// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mapview;

import com.google.android.gms.maps.model.Marker;

// Referenced classes of package com.groupon.mapview:
//            BaseMapView

class this._cls0
    implements com.google.android.gms.maps.rkerClickListener
{

    final BaseMapView this$0;

    public boolean onMarkerClick(Marker marker)
    {
        if (BaseMapView.access$000(BaseMapView.this) != null)
        {
            return BaseMapView.access$000(BaseMapView.this).onMarkerClicked(marker);
        } else
        {
            return false;
        }
    }

    Marker()
    {
        this$0 = BaseMapView.this;
        super();
    }
}
