// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.location;

import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.searchapp.retailsearch.client.LocationListener;
import com.amazon.searchapp.retailsearch.model.Current;
import com.amazon.searchapp.retailsearch.model.LocationResults;
import com.amazon.searchapp.retailsearch.model.LocationSuggestions;
import com.amazon.searchapp.retailsearch.model.Locations;

// Referenced classes of package com.amazon.retailsearch.data.location:
//            LocationLoader

private class <init>
    implements LocationListener
{

    final LocationLoader this$0;

    public void currentAddress(Current current)
    {
        LocationLoader.access$200(LocationLoader.this).currentLocation(current);
    }

    public void endParse(LocationResults locationresults)
    {
        LocationLoader.access$200(LocationLoader.this).endParse(locationresults);
    }

    public void endRequest()
    {
    }

    public void error(Exception exception)
    {
        LocationLoader.access$100().error("Location request ended with an exception", exception);
        LocationLoader.access$200(LocationLoader.this).onError(exception);
    }

    public void locationSuggestions(LocationSuggestions locationsuggestions)
    {
        LocationLoader.access$200(LocationLoader.this).locationSuggestions(locationsuggestions);
    }

    public void locations(Locations locations1)
    {
        LocationLoader.access$200(LocationLoader.this).locations(locations1);
    }

    public void result(LocationResults locationresults)
    {
    }

    public volatile void result(Object obj)
    {
        result((LocationResults)obj);
    }

    public void startParse(LocationResults locationresults)
    {
    }

    public void startRequest()
    {
    }

    private stener()
    {
        this$0 = LocationLoader.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
