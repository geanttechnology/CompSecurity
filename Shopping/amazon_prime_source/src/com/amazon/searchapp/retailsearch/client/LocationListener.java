// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.model.Current;
import com.amazon.searchapp.retailsearch.model.LocationResults;
import com.amazon.searchapp.retailsearch.model.LocationSuggestions;
import com.amazon.searchapp.retailsearch.model.Locations;

public interface LocationListener
    extends ServiceCallListener
{

    public abstract void currentAddress(Current current);

    public abstract void endParse(LocationResults locationresults);

    public abstract void locationSuggestions(LocationSuggestions locationsuggestions);

    public abstract void locations(Locations locations1);

    public abstract void startParse(LocationResults locationresults);
}
