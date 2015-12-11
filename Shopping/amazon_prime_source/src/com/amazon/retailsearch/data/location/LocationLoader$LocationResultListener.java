// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.location;

import com.amazon.searchapp.retailsearch.model.Current;
import com.amazon.searchapp.retailsearch.model.LocationResults;
import com.amazon.searchapp.retailsearch.model.LocationSuggestions;
import com.amazon.searchapp.retailsearch.model.Locations;

// Referenced classes of package com.amazon.retailsearch.data.location:
//            LocationLoader

public static interface Q
{

    public abstract void currentLocation(Current current);

    public abstract void endParse(LocationResults locationresults);

    public abstract void locationSuggestions(LocationSuggestions locationsuggestions);

    public abstract void locations(Locations locations1);

    public abstract void onError(Exception exception);
}
