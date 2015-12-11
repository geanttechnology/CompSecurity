// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.util;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.pointinside.model.Venue;
import com.pointinside.model.VenueFactory;

// Referenced classes of package com.pointinside.net.util:
//            VenueLoaderTask

class val.venue extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final VenueLoaderTask this$0;
    final Venue val$venue;

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
        TraceMachine.enterMethod(_nr_trace, "VenueLoaderTask$1#doInBackground", null);
_L1:
        aobj = doInBackground((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "VenueLoaderTask$1#doInBackground", null);
          goto _L1
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (val$venue != null)
        {
            VenueLoaderTask.access$000(VenueLoaderTask.this).refreshCache(val$venue);
            VenueLoaderTask.access$100(VenueLoaderTask.this).onVenueCacheRefresh(val$venue);
        }
        return null;
    }

    Loader()
    {
        this$0 = final_venueloadertask;
        val$venue = Venue.this;
        super();
    }
}
