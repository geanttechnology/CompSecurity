// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Current, LocationSuggestions, Locations

public interface LocationResults
{

    public abstract Current getCurrent();

    public abstract LocationSuggestions getLocationSuggestions();

    public abstract Locations getLocations();

    public abstract void setCurrent(Current current);

    public abstract void setLocationSuggestions(LocationSuggestions locationsuggestions);

    public abstract void setLocations(Locations locations);
}
