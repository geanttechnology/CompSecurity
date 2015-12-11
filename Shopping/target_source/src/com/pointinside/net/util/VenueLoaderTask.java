// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.util;

import android.content.Context;
import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.pointinside.internal.utils.StringUtils;
import com.pointinside.model.Venue;
import com.pointinside.model.VenueFactory;
import com.pointinside.net.VenueCacheIOException;

abstract class VenueLoaderTask extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    private VenueLoader.IVenueLoader loader;
    private com.pointinside.feeds.ZoneImageEntity.ImageType mImageType[];
    private VenueFactory mVenueFactory;

    public transient VenueLoaderTask(Context context, VenueLoader.IVenueLoader ivenueloader, com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
    {
        loader = null;
        mVenueFactory = new VenueFactory(context);
        mImageType = aimagetype;
        loader = ivenueloader;
    }

    public transient VenueLoaderTask(Context context, com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
    {
        loader = null;
        mVenueFactory = new VenueFactory(context);
        mImageType = aimagetype;
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

    protected transient Venue doInBackground(String as[])
    {
        Venue venue2;
        Object obj;
        Object obj1;
        venue2 = null;
        obj1 = null;
        obj = null;
        if (as == null) goto _L2; else goto _L1
_L1:
        Venue venue;
        Venue venue1;
        venue1 = obj;
        venue = obj1;
        if (as.length > 0) goto _L3; else goto _L2
_L2:
        venue1 = obj;
        venue = obj1;
        throw new VenueCacheIOException("No Venue ID specified");
        as;
_L10:
        loader.onVenueLoadError(as);
        venue2 = venue1;
_L5:
        return venue2;
_L3:
        venue1 = obj;
        venue = obj1;
        if (StringUtils.isNullOrEmpty(as[0])) goto _L5; else goto _L4
_L4:
        venue1 = obj;
        venue = obj1;
        venue2 = mVenueFactory.getVenueById(as[0], mImageType);
        venue = mVenueFactory.getCachedVenue(as[0], mImageType);
        venue2 = venue;
        if (venue != null) goto _L5; else goto _L6
_L6:
        venue1 = venue;
        as = mVenueFactory.getVenueById(as[0], mImageType);
        return as;
        as;
_L8:
        as.printStackTrace();
        loader.onVenueLoadError(as);
        return venue;
        as;
        venue = venue2;
        if (true) goto _L8; else goto _L7
_L7:
        as;
        venue1 = venue2;
        if (true) goto _L10; else goto _L9
_L9:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "VenueLoaderTask#doInBackground", null);
_L1:
        aobj = doInBackground((String[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "VenueLoaderTask#doInBackground", null);
          goto _L1
    }

    protected void onPostExecute(final Venue venue)
    {
        venue = new TraceFieldInterface() {

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

            protected transient Void doInBackground(Void avoid1[])
            {
                if (venue != null)
                {
                    mVenueFactory.refreshCache(venue);
                    loader.onVenueCacheRefresh(venue);
                }
                return null;
            }

            
            {
                this$0 = VenueLoaderTask.this;
                venue = venue1;
                super();
            }
        };
        Void avoid[] = new Void[0];
        if (!(venue instanceof AsyncTask))
        {
            venue.execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)venue, avoid);
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "VenueLoaderTask#onPostExecute", null);
_L1:
        onPostExecute((Venue)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "VenueLoaderTask#onPostExecute", null);
          goto _L1
    }


}
