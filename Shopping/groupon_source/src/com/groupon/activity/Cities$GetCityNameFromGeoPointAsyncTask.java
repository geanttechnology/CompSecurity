// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.Place;
import com.groupon.models.division.City;
import com.groupon.models.division.Division;
import com.groupon.util.DivisionUtil;
import com.groupon.util.GeoPoint;
import com.groupon.util.GrouponSafeAsyncTask;
import com.groupon.util.LocationsAutocompleteServiceWrapper;

// Referenced classes of package com.groupon.activity:
//            Cities

private class division extends GrouponSafeAsyncTask
{

    private final Division division;
    private final Place suggestion;
    final Cities this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public String call()
        throws Exception
    {
        return divisionUtil.getCityNameFromGeoPoint(new GeoPoint((int)(suggestion.lat * 1000000D), (int)(suggestion.lng * 1000000D)));
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((String)obj);
    }

    protected void onSuccess(String s)
        throws Exception
    {
        Object obj = division;
        if (s != null)
        {
            if (!suggestion.value.equals(CURRENT_LOCATION) && !Cities.access$1400(Cities.this).isUserLocation(suggestion))
            {
                s = suggestion.value.split(",")[0];
            }
            obj = new City(division, s);
        }
        Cities.access$1500(Cities.this, ((Division) (obj)));
    }

    public (Place place, Division division1)
    {
        this$0 = Cities.this;
        super();
        suggestion = place;
        division = division1;
    }
}
