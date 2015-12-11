// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.k;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.pointinside.model.Venue;
import com.pointinside.model.VenueFactory;
import com.pointinside.net.VenueCacheIOException;
import com.target.ui.util.q;
import java.lang.ref.WeakReference;
import java.util.List;

public class com.target.ui.helper.k.a
{
    public static interface a
    {

        public abstract void a(Venue venue);

        public abstract void p_();
    }

    public static class b extends AsyncTask
        implements TraceFieldInterface
    {

        private static final String LOG_TAG = com/target/ui/helper/k/a$b.getSimpleName();
        public Trace _nr_trace;
        private WeakReference mLoadVenueListener;
        private VenueFactory mVenueFactory;

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

        protected transient Venue a(String as[])
        {
            if ((a)mLoadVenueListener.get() == null)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            as = mVenueFactory.getVenueById(as[0], new com.pointinside.feeds.ZoneImageEntity.ImageType[] {
                com.pointinside.feeds.ZoneImageEntity.ImageType.DEFAULT4
            });
            return as;
            as;
            q.a(LOG_TAG, "Exception while loading venue");
            return null;
        }

        protected void a(Venue venue)
        {
            a a1;
            if (!isCancelled())
            {
                if ((a1 = (a)mLoadVenueListener.get()) != null)
                {
                    if (venue == null || venue.getAllZones().isEmpty())
                    {
                        a1.p_();
                        return;
                    } else
                    {
                        a1.a(venue);
                        return;
                    }
                }
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "a$b#doInBackground", null);
_L1:
            aobj = a((String[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "a$b#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "a$b#onPostExecute", null);
_L1:
            a((Venue)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "a$b#onPostExecute", null);
              goto _L1
        }


        public b(a a1, VenueFactory venuefactory)
        {
            mLoadVenueListener = new WeakReference(a1);
            mVenueFactory = venuefactory;
        }
    }


    private VenueFactory mVenueFactory;
    private b mVenueLoaderTask;

    public com.target.ui.helper.k.a(VenueFactory venuefactory)
    {
        mVenueFactory = venuefactory;
    }

    public void a()
    {
        if (mVenueLoaderTask != null && !mVenueLoaderTask.isCancelled())
        {
            mVenueLoaderTask.cancel(true);
        }
    }

    public void a(a a1, String s)
    {
        mVenueLoaderTask = new b(a1, mVenueFactory);
        a1 = mVenueLoaderTask;
        String as[] = new String[1];
        as[0] = s;
        if (!(a1 instanceof AsyncTask))
        {
            a1.execute(as);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)a1, as);
            return;
        }
    }
}
