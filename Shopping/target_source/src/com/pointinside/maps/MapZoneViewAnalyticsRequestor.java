// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.os.AsyncTask;
import android.util.Log;
import com.google.b.t;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.pointinside.internal.utils.IOUtils;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.net.EndpointType;
import com.pointinside.net.requestor.WebserviceRequestor;
import com.pointinside.net.url.URLBuilder;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.pointinside.maps:
//            MapAnalyticsDataInternal

class MapZoneViewAnalyticsRequestor extends WebserviceRequestor
{
    private class AnalyticsJSONPOSTRequest
    {

        public final List data;
        final MapZoneViewAnalyticsRequestor this$0;

        public AnalyticsJSONPOSTRequest(List list)
        {
            this$0 = MapZoneViewAnalyticsRequestor.this;
            super();
            data = list;
        }
    }

    private class ConnectionThread extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        final MapZoneViewAnalyticsRequestor this$0;

        public void _nr_setTrace(Trace trace)
        {
            try
            {
                _nr_trace = trace;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Trace trace)
            {
                return;
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "MapZoneViewAnalyticsRequestor$ConnectionThread#doInBackground", null);
_L1:
            aobj = doInBackground((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "MapZoneViewAnalyticsRequestor$ConnectionThread#doInBackground", null);
              goto _L1
        }

        protected transient Void doInBackground(Void avoid[])
        {
            HttpURLConnection httpurlconnection = ((MapZoneViewAnalyticsURLBuilder)URL).openConnection();
            avoid = httpurlconnection;
            IOUtils.executeHttpPostRequest(httpurlconnection, MapZoneViewAnalyticsRequestor.this._nr_trace);
            if (httpurlconnection != null)
            {
                httpurlconnection.disconnect();
            }
_L2:
            return null;
            IOException ioexception;
            ioexception;
            httpurlconnection = null;
_L5:
            avoid = httpurlconnection;
            LogUtils.logE("MapZoneViewAnalyticsRequestor", Log.getStackTraceString(ioexception));
            if (httpurlconnection == null) goto _L2; else goto _L1
_L1:
            httpurlconnection.disconnect();
            return null;
            Exception exception;
            exception;
            avoid = null;
_L4:
            if (avoid != null)
            {
                avoid.disconnect();
            }
            throw exception;
            exception;
            if (true) goto _L4; else goto _L3
_L3:
            ioexception;
              goto _L5
        }

        private ConnectionThread()
        {
            this$0 = MapZoneViewAnalyticsRequestor.this;
            super();
        }

    }

    static class MapZoneViewAnalyticsURLBuilder extends URLBuilder
    {

        public void onPrepareURL()
        {
            addProximityDataIfAvailable();
        }

        public MapZoneViewAnalyticsURLBuilder()
        {
            super(EndpointType.MAP_ZONE_VIEW_ANALYTICS, null);
        }
    }


    MapZoneViewAnalyticsRequestor()
    {
        super(new MapZoneViewAnalyticsURLBuilder(), null);
    }

    void sendAnalyticsInfo(MapAnalyticsDataInternal mapanalyticsdatainternal)
    {
        lastPostBody = IOUtils.serializeToJSONString(new AnalyticsJSONPOSTRequest(Arrays.asList(new MapAnalyticsDataInternal[] {
            mapanalyticsdatainternal
        })), new t[0]);
        mapanalyticsdatainternal = new ConnectionThread();
        Void avoid[] = new Void[0];
        if (!(mapanalyticsdatainternal instanceof AsyncTask))
        {
            mapanalyticsdatainternal.execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)mapanalyticsdatainternal, avoid);
            return;
        }
    }

}
