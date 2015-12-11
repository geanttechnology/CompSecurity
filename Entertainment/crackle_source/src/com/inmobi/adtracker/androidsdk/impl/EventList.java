// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.adtracker.androidsdk.impl;

import android.util.Log;
import com.inmobi.adtracker.androidsdk.impl.net.IMAdTrackerNetworkInterface;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.adtracker.androidsdk.impl:
//            IMAdTrackerAnalyticsConstants, Event, Utils

public class EventList extends Vector
{

    public static final String GOAL_INSTALL = "install";

    public EventList()
    {
    }

    public void addEvent(String s)
    {
        boolean flag;
        IMAdTrackerNetworkInterface.isSynced.set(false);
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
        {
            Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, (new StringBuilder("Inserting to Map event ")).append(s).toString());
        }
        flag = false;
        if (s == null)
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
            {
                Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "GoalName is null");
            }
            return;
        }
        Iterator iterator = iterator();
_L4:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Event event;
        if (!flag)
        {
            try
            {
                add(new Event(s, 1));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return;
            }
        }
        Utils.saveToFile(this);
        return;
_L2:
        event = (Event)iterator.next();
        if (!event.getGoalName().equals(s)) goto _L4; else goto _L3
_L3:
        if (!"install".equals(s))
        {
            event.setEventCount(event.getEventCount() + 1);
        }
        flag = true;
          goto _L1
    }

    public EventList getLoggedGoals()
    {
        if ((EventList)Utils.readFromFile() != null)
        {
            return (EventList)Utils.readFromFile();
        } else
        {
            return new EventList();
        }
    }

    public void removeEvent(String s, int i)
    {
        Iterator iterator;
        IMAdTrackerNetworkInterface.isSynced.set(false);
        if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
        {
            Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, (new StringBuilder("Removing from Map event ")).append(s).toString());
        }
        if (s == null)
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= com.inmobi.adtracker.androidsdk.IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
            {
                Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "GoalName is null");
            }
            return;
        }
        iterator = iterator();
_L2:
        if (iterator.hasNext())
        {
            Event event = (Event)iterator.next();
            if (!event.getGoalName().equals(s))
            {
                continue; /* Loop/switch isn't completed */
            }
            i = event.getEventCount() - i;
            if (s.equals("install"))
            {
                remove(event);
            } else
            if (i <= 0)
            {
                remove(event);
            } else
            {
                event.setEventCount(i);
            }
        }
        Utils.saveToFile(this);
        return;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void saveGoals()
    {
        Utils.saveToFile(this);
    }
}
