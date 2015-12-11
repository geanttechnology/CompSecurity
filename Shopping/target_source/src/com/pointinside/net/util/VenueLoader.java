// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.util;

import android.content.Context;
import android.os.AsyncTask;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.pointinside.model.Venue;

// Referenced classes of package com.pointinside.net.util:
//            VenueLoaderTask

public class VenueLoader
{
    public static interface IVenueLoader
    {

        public abstract void onVenueCacheRefresh(Venue venue);

        public abstract void onVenueLoadError(Exception exception);

        public abstract void onVenueRetrieved(Venue venue);
    }


    private final Context context;
    private final com.pointinside.feeds.ZoneImageEntity.ImageType imageType[];
    private final IVenueLoader loader;

    public transient VenueLoader(Context context1, IVenueLoader ivenueloader, com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
    {
        context = context1;
        imageType = aimagetype;
        loader = ivenueloader;
    }

    public VenueLoader execute(String s)
    {
        VenueLoaderTask venueloadertask = new VenueLoaderTask(context, loader, imageType) {

            final VenueLoader this$0;

            protected void onPostExecute(Venue venue)
            {
                loader.onVenueRetrieved(venue);
                super.onPostExecute(venue);
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Venue)obj);
            }

            transient 
            {
                this$0 = VenueLoader.this;
                super(context1, ivenueloader, aimagetype);
            }
        };
        String as[] = new String[1];
        as[0] = s;
        if (!(venueloadertask instanceof AsyncTask))
        {
            venueloadertask.execute(as);
            return this;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)venueloadertask, as);
            return this;
        }
    }

}
