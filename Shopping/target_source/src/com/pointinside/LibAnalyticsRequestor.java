// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
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

// Referenced classes of package com.pointinside:
//            InitializationAnalyticsData

class LibAnalyticsRequestor extends WebserviceRequestor
{
    private class AnalyticsJSONPOSTRequest
    {

        private List data;
        final LibAnalyticsRequestor this$0;

        public AnalyticsJSONPOSTRequest(InitializationAnalyticsData initializationanalyticsdata)
        {
            this$0 = LibAnalyticsRequestor.this;
            super();
            data = Arrays.asList(new InitializationAnalyticsData[] {
                initializationanalyticsdata
            });
        }
    }

    private class ConnectionThread extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        final LibAnalyticsRequestor this$0;

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
            TraceMachine.enterMethod(_nr_trace, "LibAnalyticsRequestor$ConnectionThread#doInBackground", null);
_L1:
            aobj = doInBackground((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "LibAnalyticsRequestor$ConnectionThread#doInBackground", null);
              goto _L1
        }

        protected transient Void doInBackground(Void avoid[])
        {
            HttpURLConnection httpurlconnection = ((LibAnalyticsURLBuilder)URL).openConnection();
            avoid = httpurlconnection;
            IOUtils.executeHttpPostRequest(httpurlconnection, 
// JavaClassFileOutputException: get_constant: invalid tag

        private ConnectionThread()
        {
            this$0 = LibAnalyticsRequestor.this;
            super();
        }

    }

    static class LibAnalyticsURLBuilder extends URLBuilder
    {

        public void onPrepareURL()
        {
        }

        public void setLocation(Location location)
        {
            putLocationInParam(location);
        }

        public LibAnalyticsURLBuilder()
        {
            super(EndpointType.INITIALIZE, null);
        }
    }


    private static final String TAG = LogUtils.makeLogTag(com/pointinside/LibAnalyticsRequestor.getSimpleName());

    public LibAnalyticsRequestor()
    {
        WebserviceRequestor(new LibAnalyticsURLBuilder(), null);
    }

    private Location getCurrentLocation(Context context)
    {
        Object obj2 = null;
        if (context == null) goto _L2; else goto _L1
_L1:
        Object obj = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
_L12:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        String as[] = ((PackageInfo) (obj)).requestedPermissions;
        int i;
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        i = 0;
_L14:
        if (i >= as.length)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        if (!as[i].equalsIgnoreCase("android.permission.ACCESS_FINE_LOCATION")) goto _L4; else goto _L3
_L3:
        if (android.os.Build.VERSION.SDK_INT < 16) goto _L6; else goto _L5
_L5:
        if ((((PackageInfo) (obj)).requestedPermissionsFlags[i] & 2) == 0) goto _L4; else goto _L7
_L7:
        i = 1;
_L13:
        if (i == 0) goto _L2; else goto _L8
_L8:
        boolean flag;
        boolean flag1;
        obj = (LocationManager)context.getSystemService("location");
        flag = ((LocationManager) (obj)).isProviderEnabled("gps");
        flag1 = ((LocationManager) (obj)).isProviderEnabled("network");
        if (!flag && !flag1) goto _L2; else goto _L9
_L9:
        context = obj2;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        context = ((LocationManager) (obj)).getLastKnownLocation("network");
        if (!flag || context != null || obj == null) goto _L11; else goto _L10
_L10:
        obj = ((LocationManager) (obj)).getLastKnownLocation("gps");
        return ((Location) (obj));
        Object obj1;
        obj1;
        ((android.content.pm.PackageManager.NameNotFoundException) (obj1)).printStackTrace();
        obj1 = null;
          goto _L12
_L6:
        i = 1;
          goto _L13
_L4:
        i++;
          goto _L14
        obj1;
        context = null;
_L15:
        ((Exception) (obj1)).printStackTrace();
        return context;
        obj1;
        if (true) goto _L15; else goto _L11
_L11:
        return context;
_L2:
        return null;
        i = 0;
          goto _L13
    }

    void sendLibAnalytics(InitializationAnalyticsData initializationanalyticsdata, Context context)
    {
        if (context != null)
        {
            context = getCurrentLocation(context);
            if (context != null)
            {
                ((LibAnalyticsURLBuilder)URL).setLocation(context);
            }
        }
        lastPostBody = IOUtils.serializeToJSONString(new AnalyticsJSONPOSTRequest(initializationanalyticsdata), new t[0]);
        initializationanalyticsdata = new ConnectionThread();
        context = new Void[0];
        if (!(initializationanalyticsdata instanceof AsyncTask))
        {
            initializationanalyticsdata.execute(context);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)initializationanalyticsdata, context);
            return;
        }
    }


}
