// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import com.groupon.models.hotel.Destination;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.LoggingUtils;
import java.util.Date;
import org.restlet.engine.util.InternetUsDateFormat;

public class GetawaysSearchViewLogger
{

    private static final String CLICK_METADATA = "getaways";
    private static final String CURRENT_LOCATION_ID = "current_location";
    private static final String DATE_FORMAT = "MMddyyyy";
    private static final String INVENTORY_TYPES = "HOTEL,DEAL,LASTMINUTE";
    private static final String SEARCH_AUTOCOMPLETE = "autocomplete";
    private static final String SEARCH_DATE_CLICK = "search_date_click";
    private static final String SEARCH_LOC_ONLY = "loc_only";
    private static final String SEARCH_RECENTLY_USED = "recentlyused";
    private static final String SPECIFIER = "market_rate";
    private final InternetUsDateFormat internetUsDateFormat;
    private final Logger logger;
    private final LoggingUtils loggingUtils;

    public GetawaysSearchViewLogger(Logger logger1, LoggingUtils loggingutils, InternetUsDateFormat internetusdateformat)
    {
        logger = logger1;
        loggingUtils = loggingutils;
        internetUsDateFormat = internetusdateformat;
    }

    private void logSearch(String s, Date date, Date date1, String s1)
    {
        String s2 = null;
        LoggingUtils loggingutils = loggingUtils;
        if (date != null)
        {
            date = internetUsDateFormat.format("MMddyyyy", date).toString();
        } else
        {
            date = null;
        }
        if (date1 != null)
        {
            s2 = internetUsDateFormat.format("MMddyyyy", date1).toString();
        }
        loggingutils.logHotelsSearchClick(date, s2, s, "HOTEL,DEAL,LASTMINUTE", s1);
    }

    public void logAutocompleteDestinationClick(Destination destination, Date date, Date date1)
    {
        logSearch(destination.uuid, date, date1, "autocomplete");
    }

    public void logCurrentLocationClick(Date date, Date date1)
    {
        logSearch("current_location", date, date1, "autocomplete");
    }

    public void logDateSelectorClick()
    {
        logger.logClick("", "search_date_click", "market_rate", "getaways");
    }

    public void logFreeSearchWithDestinationsAvailable(Destination destination, Date date, Date date1)
    {
        logSearch(destination.uuid, date, date1, "loc_only");
    }

    public void logRecentlySearchedDestinationClick(Destination destination, Date date, Date date1)
    {
        logSearch(destination.uuid, date, date1, "recentlyused");
    }
}
