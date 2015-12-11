// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.util;

import android.content.Context;
import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.pointinside.location.poi.BeaconPOIURLBuilder;
import com.pointinside.location.poi.BeaconPointOfInterestRequester;
import com.pointinside.location.poi.BeaconPointOfInterestResponse;
import java.io.IOException;
import java.util.List;

public abstract class BeaconLoaderTask extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;

    public BeaconLoaderTask(Context context)
    {
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
        TraceMachine.enterMethod(_nr_trace, "BeaconLoaderTask#doInBackground", null);
_L1:
        aobj = doInBackground((String[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "BeaconLoaderTask#doInBackground", null);
          goto _L1
    }

    protected transient List doInBackground(String as[])
    {
        as = new BeaconPointOfInterestRequester(new BeaconPOIURLBuilder(as[0], null), new BeaconPointOfInterestResponse());
        try
        {
            as = as.fetchAll();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as.printStackTrace();
            return null;
        }
        return as;
    }
}
