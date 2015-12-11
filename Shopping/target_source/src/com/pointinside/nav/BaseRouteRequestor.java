// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import com.google.b.t;
import com.pointinside.internal.utils.IOUtils;
import com.pointinside.net.requestor.WebserviceRequestor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.pointinside.nav:
//            RouteException, IRouteWaypoint, BaseRouteURLBuilder, BaseRouteModel, 
//            BaseRouteWaypoint

public abstract class BaseRouteRequestor extends WebserviceRequestor
{
    public static abstract class Builder
    {

        private IRouteWaypoint mEndPoint;
        private IRouteWaypoint mStartPoint;
        private String mStoreId;
        private String mVenueUuid;
        private List mWaypoints;
        private String mWeighting;

        public Builder setEndPoint(IRouteWaypoint iroutewaypoint)
        {
            mEndPoint = iroutewaypoint;
            return this;
        }

        public Builder setStartPoint(IRouteWaypoint iroutewaypoint)
        {
            mStartPoint = iroutewaypoint;
            return this;
        }

        public Builder setStoreId(String s)
        {
            mStoreId = s;
            return this;
        }

        public Builder setVenueUuid(String s)
        {
            mVenueUuid = s;
            return this;
        }

        public Builder setWaypoints(List list)
        {
            mWaypoints = list;
            return this;
        }

        public Builder setWeightingAlgorithm(String s)
        {
            mWeighting = s;
            return this;
        }







        public Builder()
        {
            mWeighting = null;
            mVenueUuid = null;
            mStoreId = null;
            mStartPoint = null;
            mEndPoint = null;
            mWaypoints = new ArrayList();
        }
    }

    private static class RequestPostData
    {

        BaseRouteWaypoint end;
        BaseRouteWaypoint start;
        List waypoints;

        private RequestPostData()
        {
        }

    }


    final IRouteWaypoint mEndPoint;
    final Map mMap;
    final IRouteWaypoint mStartPoint;
    final String mStoreId;
    final String mVenueUuid;
    final List mWaypoints;
    final String mWeighting;

    protected BaseRouteRequestor(BaseRouteURLBuilder baserouteurlbuilder, BaseRouteModel baseroutemodel, Builder builder)
        throws RouteException
    {
        super(baserouteurlbuilder, baseroutemodel);
        mWeighting = builder.mWeighting;
        mWaypoints = builder.mWaypoints;
        mStartPoint = builder.mStartPoint;
        mEndPoint = builder.mEndPoint;
        mVenueUuid = builder.mVenueUuid;
        mStoreId = builder.mStoreId;
        if (mVenueUuid == null && mStoreId == null)
        {
            throw new RouteException("Both VenueUuid and StoreId are null");
        }
        if (mStartPoint == null)
        {
            throw new RouteException("Startpoint is mandatory for route/order request");
        }
        if (mWaypoints.isEmpty())
        {
            throw new RouteException("Waypoints cannot be empty");
        } else
        {
            mMap = new HashMap();
            return;
        }
    }

    private RequestPostData createPostData()
        throws RouteException
    {
        ArrayList arraylist = new ArrayList();
        IRouteWaypoint iroutewaypoint;
        BaseRouteWaypoint baseroutewaypoint2;
        for (Iterator iterator = mWaypoints.iterator(); iterator.hasNext(); mMap.put(baseroutewaypoint2, iroutewaypoint))
        {
            iroutewaypoint = (IRouteWaypoint)iterator.next();
            baseroutewaypoint2 = iroutewaypoint.getWaypoint();
            arraylist.add(baseroutewaypoint2);
        }

        RequestPostData requestpostdata = new RequestPostData();
        BaseRouteWaypoint baseroutewaypoint = mStartPoint.getWaypoint();
        requestpostdata.start = baseroutewaypoint;
        mMap.put(baseroutewaypoint, mStartPoint);
        if (mEndPoint != null)
        {
            BaseRouteWaypoint baseroutewaypoint1 = mEndPoint.getWaypoint();
            requestpostdata.end = baseroutewaypoint1;
            mMap.put(baseroutewaypoint1, mEndPoint);
        }
        requestpostdata.waypoints = arraylist;
        return requestpostdata;
    }

    BaseRouteModel fetch()
        throws RouteException
    {
        updateUrl();
        lastNetworkDate = System.currentTimeMillis();
        BaseRouteModel baseroutemodel;
        HttpURLConnection httpurlconnection = ((BaseRouteURLBuilder)URL).openConnection();
        lastPostBody = IOUtils.serializeToJSONString(createPostData(), new t[0]);
        baseroutemodel = (BaseRouteModel)parseResponseAsObject(IOUtils.executeHttpPostRequest(httpurlconnection, lastPostBody));
        httpurlconnection.disconnect();
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        return baseroutemodel;
        Object obj;
        obj;
        throw new RouteException(((Throwable) (obj)));
        obj;
        lastNetworkDuration = System.currentTimeMillis() - lastNetworkDate;
        throw obj;
    }

    void updateUrl()
    {
        if (mVenueUuid != null)
        {
            ((BaseRouteURLBuilder)URL).venueUUID = mVenueUuid;
        } else
        {
            ((BaseRouteURLBuilder)URL).storeID = mStoreId;
        }
        ((BaseRouteURLBuilder)URL).weighting = mWeighting;
    }
}
