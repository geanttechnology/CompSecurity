// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import com.pointinside.internal.ParameterCheck;
import com.pointinside.net.EndpointType;
import com.pointinside.net.url.URLBuilder;
import java.util.HashMap;

abstract class BaseRouteURLBuilder extends URLBuilder
{

    private static final String KEY_STORE_ID = "storeId".intern();
    private static final String KEY_VENUE_UUID = "venue".intern();
    private static final String KEY_WEIGHTING = "weighting".intern();
    String storeID;
    String venueUUID;
    String weighting;

    public BaseRouteURLBuilder(EndpointType endpointtype, String s)
    {
        super(endpointtype, s);
    }

    protected String getVersion()
    {
        return "v1.3";
    }

    public void onPrepareURL()
    {
        addProximityDataIfAvailable();
        if (!ParameterCheck.isNullOrEmpty(venueUUID))
        {
            parameters.put(KEY_VENUE_UUID, venueUUID);
        } else
        {
            parameters.put(KEY_STORE_ID, storeID);
        }
        if (!ParameterCheck.isNullOrEmpty(weighting))
        {
            parameters.put(KEY_WEIGHTING, weighting);
        }
    }

}
