// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Current;
import com.amazon.searchapp.retailsearch.model.LocationResults;
import com.amazon.searchapp.retailsearch.model.LocationSuggestions;
import com.amazon.searchapp.retailsearch.model.Locations;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class LocationResultsEntity extends RetailSearchEntity
    implements LocationResults
{

    private Current current;
    private LocationSuggestions locationSuggestions;
    private Locations locations;

    public LocationResultsEntity()
    {
    }

    public Current getCurrent()
    {
        return current;
    }

    public LocationSuggestions getLocationSuggestions()
    {
        return locationSuggestions;
    }

    public Locations getLocations()
    {
        return locations;
    }

    public void setCurrent(Current current1)
    {
        current = current1;
    }

    public void setLocationSuggestions(LocationSuggestions locationsuggestions)
    {
        locationSuggestions = locationsuggestions;
    }

    public void setLocations(Locations locations1)
    {
        locations = locations1;
    }
}
