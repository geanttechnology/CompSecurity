// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.adtracker.androidsdk.impl.net;

import android.util.Log;
import com.inmobi.adtracker.androidsdk.impl.Event;
import com.inmobi.adtracker.androidsdk.impl.EventList;
import com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants;
import com.inmobi.adtracker.androidsdk.impl.Utils;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.adtracker.androidsdk.impl.net:
//            IMAdTrackerNetworkInterface, IMAdTrackerHTTPRequestResponse

class val.odin1
    implements Runnable
{

    private final String val$appID;
    private final boolean val$installStatus;
    private final String val$odin1;

    public void run()
    {
_L6:
        if (!IMAdTrackerNetworkInterface.isSynced.get()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        IMAdTrackerNetworkInterface.isSynced.set(true);
        if (IMAdTrackerNetworkInterface.goalEventList == null) goto _L1; else goto _L3
_L3:
        Vector vector;
        Iterator iterator;
        vector = new Vector();
        iterator = IMAdTrackerNetworkInterface.goalEventList.iterator();
_L8:
        if (iterator.hasNext()) goto _L5; else goto _L4
_L4:
        iterator = vector.iterator();
_L12:
        if (iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_294;
        }
        vector.clear();
        IMAdTrackerNetworkInterface.access$0().set(false);
          goto _L6
_L5:
        Event event;
        String s;
        int i;
        event = (Event)iterator.next();
        s = event.getGoalName();
        i = event.getEventCount();
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.alue() >= com.inmobi.adtracker.androidsdk.OSE.alue())
        {
            Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, (new StringBuilder("EventName: ")).append(event.getGoalName()).append("::").append(event.getEventCount()).toString());
        }
        if (Utils.getPreferences(IMAdTrackerAnalyticsConstants.MARKET_REFERRER) == null && "install".equals(event.getGoalName()) && !val$installStatus) goto _L8; else goto _L7
_L7:
        com.inmobi.adtracker.androidsdk.impl.StatusCode statuscode = IMAdTrackerHTTPRequestResponse.sendHTTPRequest(val$appID, val$odin1, event.getGoalName(), event.getEventCount());
        if (com.inmobi.adtracker.androidsdk.impl.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS != statuscode) goto _L10; else goto _L9
_L9:
        Exception exception;
        if (event.getGoalName().equals("install"))
        {
            Utils.updateStatus();
        }
        vector.add(new Event(s, i));
          goto _L8
_L10:
        if (!event.getGoalName().equals("install")) goto _L8; else goto _L11
_L11:
        Utils.resetStatus();
          goto _L8
        try
        {
            Event event1 = (Event)iterator.next();
            IMAdTrackerNetworkInterface.goalEventList.removeEvent(event1.getGoalName(), event1.getEventCount());
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.alue() >= com.inmobi.adtracker.androidsdk.OSE.alue())
            {
                Log.e(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Failed to remove event from list");
            }
            IMAdTrackerNetworkInterface.access$0().set(false);
            return;
        }
          goto _L12
    }

    usCode()
    {
        val$installStatus = flag;
        val$appID = s;
        val$odin1 = s1;
        super();
    }
}
