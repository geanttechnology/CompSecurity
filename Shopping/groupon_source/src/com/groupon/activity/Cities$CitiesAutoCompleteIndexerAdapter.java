// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.adapter.BaseGlobalSearchLocationIndexerAdapter;
import com.groupon.models.Place;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            Cities

private class nit> extends BaseGlobalSearchLocationIndexerAdapter
{

    final Cities this$0;

    public void onLocationClick(Place place)
    {
        Cities.access$1400(Cities.this).saveRecentLocation(place);
        Cities.access$1600(Cities.this, place);
    }

    public (List list)
    {
        this$0 = Cities.this;
        super(Cities.this, Cities.access$1400(Cities.this), CURRENT_LOCATION, list);
    }
}
