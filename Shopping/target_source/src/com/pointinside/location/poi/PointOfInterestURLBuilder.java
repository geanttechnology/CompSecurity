// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.poi;

import com.pointinside.Constants;
import com.pointinside.analytics.CommonAnalyticsData;
import com.pointinside.internal.ParameterCheck;
import com.pointinside.net.EndpointType;
import com.pointinside.products.SearchURLBuilder;
import java.util.HashMap;

public class PointOfInterestURLBuilder extends SearchURLBuilder
{

    private static final String PARAM_LATITUDE = "requestLat";
    private static final String PARAM_LONGITUDE = "requestLng";
    private static final String PARAM_PROXIMITY = "proximity";
    private static final String PARAM_RADIUS = "radius";
    private static final String PARAM_TYPE = "type";
    private static final String PARAM_X = "x";
    private static final String PARAM_Y = "y";
    private String NEARBY_RESOURCE_NAME;
    private String POIS_RESOURCE_NAME;
    public String accuracy;
    public String lat;
    public String lng;
    private CommonAnalyticsData mCommonAnalyticData;
    public PIPointOfInterest.POIType mPOIType;
    public String mZone;
    public String pointOfInterestId;
    public String proximity;
    public double radius;
    public String x;
    public String y;

    public PointOfInterestURLBuilder(String s, String s1, PIPointOfInterest.POIType poitype)
    {
        super(EndpointType.POI);
        mCommonAnalyticData = null;
        POIS_RESOURCE_NAME = "/pois";
        NEARBY_RESOURCE_NAME = "/nearby";
        venueUUID = s;
        mZone = s1;
        mPOIType = poitype;
    }

    public String getVersion()
    {
        return "v1.4";
    }

    public void onPrepareURL()
    {
        addProximityDataIfAvailable();
        ParameterCheck.throwIfNullOrEmpty("venueUUID", venueUUID);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(venueUUID);
        if (mZone != null)
        {
            stringbuilder.append("/zones/");
            stringbuilder.append(mZone);
        }
        if (pointOfInterestId != null)
        {
            stringbuilder.append(POIS_RESOURCE_NAME);
            stringbuilder.append((new StringBuilder()).append("/").append(pointOfInterestId).toString());
        }
        if (x != null)
        {
            stringbuilder.append(NEARBY_RESOURCE_NAME);
            parameters.put("x", x);
            parameters.put("y", y);
            parameters.put("radius", String.valueOf(radius));
            if (lat != null)
            {
                parameters.put("requestLat", lat);
            }
            if (lng != null)
            {
                parameters.put("requestLng", lng);
            }
        }
        setQualifiers(stringbuilder.toString());
        if (mCommonAnalyticData != null)
        {
            setParameterOrClear(KEY_PROXIMITY, mCommonAnalyticData.proximity);
            if (mCommonAnalyticData.getLocation() != null)
            {
                putLocationInParam(mCommonAnalyticData.getLocation());
            }
            if (!ParameterCheck.isNullOrEmpty(mCommonAnalyticData.custData))
            {
                parameters.put(Constants.KEY_CUST_DATA, mCommonAnalyticData.custData);
            }
        }
    }
}
