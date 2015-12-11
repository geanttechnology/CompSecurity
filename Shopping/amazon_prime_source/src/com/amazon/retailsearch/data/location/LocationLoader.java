// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.location;

import com.amazon.retailsearch.client.AndroidRetailSearchClient;
import com.amazon.retailsearch.client.SearchClientUtil;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.searchapp.retailsearch.client.LocationListener;
import com.amazon.searchapp.retailsearch.client.RetailSearchClient;
import com.amazon.searchapp.retailsearch.model.Current;
import com.amazon.searchapp.retailsearch.model.LocationResults;
import com.amazon.searchapp.retailsearch.model.LocationSuggestions;
import com.amazon.searchapp.retailsearch.model.Locations;

public class LocationLoader
{
    public static interface LocationResultListener
    {

        public abstract void currentLocation(Current current);

        public abstract void endParse(LocationResults locationresults);

        public abstract void locationSuggestions(LocationSuggestions locationsuggestions);

        public abstract void locations(Locations locations1);

        public abstract void onError(Exception exception);
    }

    private class RequestListener
        implements LocationListener
    {

        final LocationLoader this$0;

        public void currentAddress(Current current)
        {
            listener.currentLocation(current);
        }

        public void endParse(LocationResults locationresults)
        {
            listener.endParse(locationresults);
        }

        public void endRequest()
        {
        }

        public void error(Exception exception)
        {
            LocationLoader.log.error("Location request ended with an exception", exception);
            listener.onError(exception);
        }

        public void locationSuggestions(LocationSuggestions locationsuggestions)
        {
            listener.locationSuggestions(locationsuggestions);
        }

        public void locations(Locations locations1)
        {
            listener.locations(locations1);
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

        private RequestListener()
        {
            this$0 = LocationLoader.this;
            super();
        }

    }


    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/data/location/LocationLoader);
    private LocationResultListener listener;

    public LocationLoader(LocationResultListener locationresultlistener)
    {
        listener = locationresultlistener;
    }

    public void getLocation(String s)
    {
        RequestListener requestlistener = new RequestListener();
        SearchClientUtil.executeRequest(AndroidRetailSearchClient.getClient().location(requestlistener, s));
    }



}
