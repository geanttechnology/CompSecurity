// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.location.Location;
import com.pointinside.analytics.CommonAnalyticsData;
import com.pointinside.internal.ParameterCheck;
import com.pointinside.net.EndpointType;
import com.pointinside.net.url.URLBuilder;
import java.util.HashMap;

public class SearchURLBuilder extends URLBuilder
{

    private static final String KEY_CUST_DATA = "custData".intern();
    private static final String KEY_STORE_ID = "storeId".intern();
    private static final String KEY_VENUE_UUID = "venue".intern();
    public CommonAnalyticsData commonAnalyticData;
    public String storeID;
    public String venueUUID;

    public SearchURLBuilder(EndpointType endpointtype)
    {
        super(endpointtype, null);
        venueUUID = null;
        storeID = null;
        commonAnalyticData = null;
    }

    public SearchURLBuilder(EndpointType endpointtype, Location location)
    {
        super(endpointtype, null);
        venueUUID = null;
        storeID = null;
        commonAnalyticData = null;
    }

    public void onPrepareURL()
    {
        addProximityDataIfAvailable();
        if (ParameterCheck.isNullOrEmpty(venueUUID)) goto _L2; else goto _L1
_L1:
        parameters.put(KEY_VENUE_UUID, venueUUID);
_L4:
        if (commonAnalyticData != null)
        {
            setParameterOrClear(KEY_PROXIMITY, commonAnalyticData.proximity);
            putLocationInParam(commonAnalyticData.getLocation());
            if (!ParameterCheck.isNullOrEmpty(commonAnalyticData.custData))
            {
                parameters.put(KEY_CUST_DATA, commonAnalyticData.custData);
            }
        }
        return;
_L2:
        if (ParameterCheck.isNullOrEmpty(storeID))
        {
            break; /* Loop/switch isn't completed */
        }
        parameters.put(KEY_STORE_ID, storeID);
        if (true) goto _L4; else goto _L3
_L3:
        if (endpointType == EndpointType.AUTOCOMPLETE) goto _L4; else goto _L5
_L5:
        throw new IllegalArgumentException("Both venueUUID and storeID cannot be null or empty; no default available");
    }

}
