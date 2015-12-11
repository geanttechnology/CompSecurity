// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.google_api;

import android.content.Intent;
import android.text.TextUtils;
import com.commonsware.cwac.wakeful.WakefulIntentService;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.groupon.activity.IntentFactory;
import com.groupon.foundations.service.BaseIntentService;
import java.util.List;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.google_api:
//            GeofenceTransitionWakefulBroadcastReceiver

public class GeofenceTransitionService extends BaseIntentService
{

    private IntentFactory intentFactory;

    public GeofenceTransitionService()
    {
        super(com/groupon/google_api/GeofenceTransitionService.getCanonicalName());
    }

    private String getTransitionString(int i)
    {
        switch (i)
        {
        default:
            return "Unknown";

        case 1: // '\001'
            return "Entered";

        case 2: // '\002'
            return "Exited";
        }
    }

    private void handleEnterExit(GeofencingEvent geofencingevent)
    {
        int i = geofencingevent.getGeofenceTransition();
        if (i == 1 || i == 2)
        {
            handleTransition(i, geofencingevent.getTriggeringGeofences());
        }
    }

    private void handleTransition(int i, List list)
    {
        String as[] = new String[list.size()];
        for (int j = 0; j < list.size(); j++)
        {
            as[j] = ((Geofence)list.get(j)).getRequestId();
        }

        list = TextUtils.join(com.groupon.Constants.Geofence.GEOFENCE_ID_DELIMITER, as);
        String s = getTransitionString(i);
        Ln.d("Proximity_Notifications - GeofenceTransitionService : Geofence transition found %s on %s. ", new Object[] {
            s, list
        });
        if (!Strings.equalsIgnoreCase(s, "Unknown"))
        {
            WakefulIntentService.sendWakefulWork(this, intentFactory.newProximityBasedNotificationServiceGeofenceTriggered(s, list));
        }
    }

    protected void onHandleIntent(Intent intent)
    {
        GeofencingEvent geofencingevent;
        Ln.d("Proximity_Notifications - GeofenceTransitionService : Geofence transition service called. ", new Object[0]);
        geofencingevent = GeofencingEvent.fromIntent(intent);
        if (!geofencingevent.hasError())
        {
            handleEnterExit(geofencingevent);
        }
        GeofenceTransitionWakefulBroadcastReceiver.completeWakefulIntent(intent);
        return;
        Exception exception;
        exception;
        GeofenceTransitionWakefulBroadcastReceiver.completeWakefulIntent(intent);
        throw exception;
    }
}
