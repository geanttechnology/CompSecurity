// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import com.amazon.searchapp.retailsearch.model.Current;
import com.amazon.searchapp.retailsearch.model.LocationResults;
import com.amazon.searchapp.retailsearch.model.LocationSuggestions;
import com.amazon.searchapp.retailsearch.model.Locations;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementsListView, RefinementsAdapter

class this._cls0
    implements com.amazon.retailsearch.data.location.nResultListener
{

    final RefinementsListView this$0;

    public void currentLocation(Current current)
    {
        RefinementsListView.access$402(RefinementsListView.this, current);
        RefinementsListView.access$200(RefinementsListView.this).setCurrentAddress(current);
    }

    public void endParse(LocationResults locationresults)
    {
        RefinementsListView.access$500(RefinementsListView.this);
        RefinementsListView.access$600(RefinementsListView.this);
    }

    public void locationSuggestions(LocationSuggestions locationsuggestions)
    {
        RefinementsListView.access$302(RefinementsListView.this, locationsuggestions);
        RefinementsListView.access$200(RefinementsListView.this).setLocationSuggestions(locationsuggestions);
    }

    public void locations(Locations locations1)
    {
        RefinementsListView.access$002(RefinementsListView.this, locations1);
        RefinementsListView.access$102(RefinementsListView.this, locations1.getDomains());
        RefinementsListView.access$200(RefinementsListView.this).setLocations(locations1);
    }

    public void onError(Exception exception)
    {
    }

    stener()
    {
        this$0 = RefinementsListView.this;
        super();
    }
}
