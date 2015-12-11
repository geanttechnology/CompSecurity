// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.mapview.HotelMapView;

// Referenced classes of package com.groupon.fragment:
//            HotelsSearchResult

class this._cls0
    implements com.google.android.gms.maps.allback
{

    final HotelsSearchResult this$0;

    public void onCancel()
    {
    }

    public void onFinish()
    {
        if (hotelsMapView != null)
        {
            hotelsMapView.scrollCamera(0.0F, HotelsSearchResult.access$000(HotelsSearchResult.this), true, null);
        }
    }

    elableCallback()
    {
        this$0 = HotelsSearchResult.this;
        super();
    }
}
