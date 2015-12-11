// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.google.android.gms.maps.model.LatLng;
import com.groupon.mapview.DealsMapView;
import com.groupon.models.Place;

// Referenced classes of package com.groupon.fragment:
//            RapiSearchResultContainerFragment, RapiSearchResultFragment

class this._cls0
    implements android.view.gment._cls1
{

    final RapiSearchResultContainerFragment this$0;

    public void onClick(View view)
    {
        view = searchMapView.getCenterCoordinates();
        RapiSearchResultContainerFragment.access$000(RapiSearchResultContainerFragment.this).updateSearchLocation(new Place("", ((LatLng) (view)).latitude, ((LatLng) (view)).longitude));
        reloadDeals();
    }

    ()
    {
        this$0 = RapiSearchResultContainerFragment.this;
        super();
    }
}
