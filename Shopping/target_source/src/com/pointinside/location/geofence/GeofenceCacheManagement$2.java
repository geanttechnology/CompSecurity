// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.location.Location;
import com.pointinside.internal.utils.LogUtils;

// Referenced classes of package com.pointinside.location.geofence:
//            GeofenceCacheManagement

class nueLookupListener
    implements nueCacheUpdateListener
{

    final GeofenceCacheManagement this$0;
    final nueLookupListener val$listener;

    public void onVenueCacheUpdate(Location location)
    {
        location = getNearestVenue(location);
        if (location != null)
        {
            val$listener.onSuccessfulLookup(location);
            return;
        } else
        {
            LogUtils.logE(GeofenceCacheManagement.access$200(), "Cache returned null for nearest Venue Lookup.");
            return;
        }
    }

    nueLookupListener()
    {
        this$0 = final_geofencecachemanagement;
        val$listener = nueLookupListener.this;
        super();
    }
}
