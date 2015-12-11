// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import java.util.List;

// Referenced classes of package com.pointinside.location.geofence:
//            VenuesLoaderTask, GeofenceCacheManagement

class val.up extends VenuesLoaderTask
{

    final GeofenceCacheManagement this$0;
    final Context val$ctx;
    final Location val$locationFix;
    final nueCacheUpdateListener val$up;

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((List)obj);
    }

    protected void onPostExecute(List list)
    {
        if (list != null)
        {
            addRequestCacheParams(val$ctx, val$locationFix);
            Log.d("updatevenuecache", (new StringBuilder()).append("updatevenueCache received ").append(list.size()).append(" venues").toString());
            GeofenceCacheManagement.access$002(GeofenceCacheManagement.this, list);
            GeofenceCacheManagement.access$100(GeofenceCacheManagement.this, getResult());
        }
        if (val$up != null)
        {
            val$up.onVenueCacheUpdate(val$locationFix);
        }
    }

    nueCacheUpdateListener(Location location1, nueCacheUpdateListener nuecacheupdatelistener)
    {
        this$0 = final_geofencecachemanagement;
        val$ctx = Context.this;
        val$locationFix = location1;
        val$up = nuecacheupdatelistener;
        super(final_context, final_location);
    }
}
