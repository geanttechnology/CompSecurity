// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.pointinside.net.requestor.RequestorFactory;
import com.pointinside.net.requestor.VenueByLocationFeedRequestor;
import com.pointinside.net.url.FeedsVenueLocationURLBuilder;
import java.io.IOException;
import java.util.List;

public class VenuesLoaderTask extends AsyncTask
    implements TraceFieldInterface
{

    private static final int HUNDRED_FORTY = 0x36fec;
    public Trace _nr_trace;
    Location mLocation;
    VenueByLocationFeedRequestor mRequestor;

    public VenuesLoaderTask(Context context, Location location)
    {
        mLocation = location;
    }

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
        TraceMachine.enterMethod(_nr_trace, "VenuesLoaderTask#doInBackground", null);
_L1:
        aobj = doInBackground((String[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "VenuesLoaderTask#doInBackground", null);
          goto _L1
    }

    protected transient List doInBackground(String as[])
    {
        mRequestor = RequestorFactory.newVenueByLocationFeedRequestor();
        try
        {
            if (mRequestor.URL instanceof FeedsVenueLocationURLBuilder)
            {
                ((FeedsVenueLocationURLBuilder)mRequestor.URL).latitude = mLocation.getLatitude();
                ((FeedsVenueLocationURLBuilder)mRequestor.URL).longitude = mLocation.getLongitude();
                ((FeedsVenueLocationURLBuilder)mRequestor.URL).radius = Integer.valueOf(0x36fec);
            }
            as = mRequestor.fetchAll();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
            return null;
        }
        return as;
    }

    public String getResult()
    {
        if (mRequestor != null)
        {
            return mRequestor.getLatestResponsePayload();
        } else
        {
            return null;
        }
    }
}
