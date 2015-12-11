// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import java.util.Date;
import org.altbeacon.beacon.logging.LogManager;

// Referenced classes of package org.altbeacon.beacon.service:
//            Callback

public class MonitorState
{

    public static long INSIDE_EXPIRATION_MILLIS = 0L;
    private static final String TAG = "MonitorState";
    private Callback callback;
    private boolean inside;
    private long lastSeenTime;

    public MonitorState(Callback callback1)
    {
        inside = false;
        lastSeenTime = 0L;
        callback = callback1;
    }

    public Callback getCallback()
    {
        return callback;
    }

    public boolean isInside()
    {
        return inside && !isNewlyOutside();
    }

    public boolean isNewlyOutside()
    {
        if (inside && lastSeenTime > 0L && (new Date()).getTime() - lastSeenTime > INSIDE_EXPIRATION_MILLIS)
        {
            inside = false;
            LogManager.d("MonitorState", "We are newly outside the region because the lastSeenTime of %s was %s seconds ago, and that is over the expiration duration of %s", new Object[] {
                Long.valueOf(lastSeenTime), Long.valueOf(System.currentTimeMillis() - lastSeenTime), Long.valueOf(INSIDE_EXPIRATION_MILLIS)
            });
            lastSeenTime = 0L;
            return true;
        } else
        {
            return false;
        }
    }

    public boolean markInside()
    {
        lastSeenTime = System.currentTimeMillis();
        if (!inside)
        {
            inside = true;
            return true;
        } else
        {
            return false;
        }
    }

    static 
    {
        INSIDE_EXPIRATION_MILLIS = 10000L;
    }
}
