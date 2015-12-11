// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.util.Log;
import com.google.b.t;
import com.pointinside.internal.utils.IOUtils;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.net.EndpointType;
import com.pointinside.net.requestor.WebserviceRequestor;
import com.pointinside.net.url.URLBuilder;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

final class MapMarkerAnalyticsRequestor extends WebserviceRequestor
{
    private class AnalyticsJSONPOSTRequest
    {

        public final List data;
        final MapMarkerAnalyticsRequestor this$0;

        public AnalyticsJSONPOSTRequest(List list)
        {
            this$0 = MapMarkerAnalyticsRequestor.this;
            super();
            data = list;
        }
    }

    static class MapMarkerAnalyticsURLBuilder extends URLBuilder
    {

        public void onPrepareURL()
        {
            addProximityDataIfAvailable();
        }

        public MapMarkerAnalyticsURLBuilder()
        {
            super(EndpointType.MAP_ANNOTATION_VIEW_ANALYTICS, null);
        }
    }


    MapMarkerAnalyticsRequestor()
    {
        super(new MapMarkerAnalyticsURLBuilder(), null);
    }

    boolean sendAnalyticsInfo(List list)
    {
        Object obj;
        lastPostBody = IOUtils.serializeToJSONString(new AnalyticsJSONPOSTRequest(list), new t[0]);
        obj = null;
        list = null;
        HttpURLConnection httpurlconnection = ((MapMarkerAnalyticsURLBuilder)URL).openConnection();
        list = httpurlconnection;
        obj = httpurlconnection;
        IOUtils.executeHttpPostRequest(httpurlconnection, lastPostBody);
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        return true;
        IOException ioexception;
        ioexception;
        obj = list;
        LogUtils.logE("MapZoneViewAnalyticsRequestor", Log.getStackTraceString(ioexception));
        if (list != null)
        {
            list.disconnect();
        }
        return false;
        list;
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        throw list;
    }
}
