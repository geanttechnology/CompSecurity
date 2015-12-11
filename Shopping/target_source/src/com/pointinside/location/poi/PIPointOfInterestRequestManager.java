// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.poi;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.pointinside.location.poi:
//            PointOfInterestURLBuilder, PointsOfInterestResponseListener, PointOfInterestResponseListener, PointOfInterestRequester, 
//            PointOfInterestResponse, PIPointOfInterest

public class PIPointOfInterestRequestManager
{
    class POILoaderTask extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        final PIPointOfInterestRequestManager this$0;

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
            TraceMachine.enterMethod(_nr_trace, "PIPointOfInterestRequestManager$POILoaderTask#doInBackground", null);
_L1:
            aobj = doInBackground((PointOfInterestURLBuilder[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "PIPointOfInterestRequestManager$POILoaderTask#doInBackground", null);
              goto _L1
        }

        protected transient List doInBackground(PointOfInterestURLBuilder apointofinteresturlbuilder[])
        {
            apointofinteresturlbuilder = new PointOfInterestRequester(apointofinteresturlbuilder[0], new PointOfInterestResponse());
            try
            {
                apointofinteresturlbuilder = apointofinteresturlbuilder.fetchAll();
            }
            // Misplaced declaration of an exception variable
            catch (PointOfInterestURLBuilder apointofinteresturlbuilder[])
            {
                apointofinteresturlbuilder.printStackTrace();
                return null;
            }
            return apointofinteresturlbuilder;
        }

        POILoaderTask()
        {
            this$0 = PIPointOfInterestRequestManager.this;
            super();
        }
    }


    public PIPointOfInterestRequestManager()
    {
    }

    public void fetchAllPois(String s, final PointsOfInterestResponseListener callback)
    {
        if (callback == null || s == null)
        {
            throw new IllegalArgumentException("Callback and venueId can't be null");
        }
        s = new PointOfInterestURLBuilder(s, null, PIPointOfInterest.POIType.None);
        callback = new POILoaderTask() {

            final PIPointOfInterestRequestManager this$0;
            final PointsOfInterestResponseListener val$callback;

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((List)obj);
            }

            protected void onPostExecute(List list)
            {
                super.onPostExecute(list);
                callback.onPointsOfInterestRetrieved(list);
            }

            
            {
                this$0 = PIPointOfInterestRequestManager.this;
                callback = pointsofinterestresponselistener;
                super();
            }
        };
        PointOfInterestURLBuilder apointofinteresturlbuilder[] = new PointOfInterestURLBuilder[1];
        apointofinteresturlbuilder[0] = s;
        if (!(callback instanceof AsyncTask))
        {
            callback.execute(apointofinteresturlbuilder);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)callback, apointofinteresturlbuilder);
            return;
        }
    }

    public void fetchNearbyPointOfInterests(String s, String s1, String s2, String s3, double d, final PointsOfInterestResponseListener callback)
    {
        if (callback == null || s == null)
        {
            throw new IllegalArgumentException("Callback and venueId can't be null");
        }
        s = new PointOfInterestURLBuilder(s, s1, PIPointOfInterest.POIType.None);
        s.x = s2;
        s.y = s3;
        s.radius = d;
        s1 = new POILoaderTask() {

            final PIPointOfInterestRequestManager this$0;
            final PointsOfInterestResponseListener val$callback;

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((List)obj);
            }

            protected void onPostExecute(List list)
            {
                super.onPostExecute(list);
                callback.onPointsOfInterestRetrieved(list);
            }

            
            {
                this$0 = PIPointOfInterestRequestManager.this;
                callback = pointsofinterestresponselistener;
                super();
            }
        };
        s2 = new PointOfInterestURLBuilder[1];
        s2[0] = s;
        if (!(s1 instanceof AsyncTask))
        {
            s1.execute(s2);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)s1, s2);
            return;
        }
    }

    public void fetchPoiById(String s, String s1, String s2, final PointOfInterestResponseListener callback)
    {
        if (callback == null || s1 == null || s == null)
        {
            throw new IllegalArgumentException("Callback, venueId, and poiId can't be null");
        }
        if (s2 == null)
        {
            throw new IllegalArgumentException("ZoneId is required when retrieving a single Point of Interest");
        }
        s = new PointOfInterestURLBuilder(s, s2, PIPointOfInterest.POIType.None);
        s.pointOfInterestId = s1;
        s1 = new POILoaderTask() {

            final PIPointOfInterestRequestManager this$0;
            final PointOfInterestResponseListener val$callback;

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((List)obj);
            }

            protected void onPostExecute(List list)
            {
                super.onPostExecute(list);
                if (list != null)
                {
                    if (list.size() > 0)
                    {
                        callback.onPointOfInterestRetrieved((PIPointOfInterest)list.get(0));
                    }
                    return;
                } else
                {
                    callback.onPointOfInterestRetrieved(null);
                    return;
                }
            }

            
            {
                this$0 = PIPointOfInterestRequestManager.this;
                callback = pointofinterestresponselistener;
                super();
            }
        };
        s2 = new PointOfInterestURLBuilder[1];
        s2[0] = s;
        if (!(s1 instanceof AsyncTask))
        {
            s1.execute(s2);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)s1, s2);
            return;
        }
    }
}
