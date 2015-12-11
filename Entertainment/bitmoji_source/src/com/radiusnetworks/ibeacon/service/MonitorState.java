// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.util.Log;
import java.util.Date;

// Referenced classes of package com.radiusnetworks.ibeacon.service:
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
        boolean flag1 = false;
        boolean flag = flag1;
        if (inside)
        {
            flag = flag1;
            if (lastSeenTime > 0L)
            {
                flag = flag1;
                if ((new Date()).getTime() - lastSeenTime > INSIDE_EXPIRATION_MILLIS)
                {
                    inside = false;
                    Log.d("MonitorState", (new StringBuilder()).append("We are newly outside the region because the lastSeenTime of ").append(lastSeenTime).append(" was ").append((new Date()).getTime() - lastSeenTime).append(" seconds ago, and that is over the expiration duration of  ").append(INSIDE_EXPIRATION_MILLIS).toString());
                    lastSeenTime = 0L;
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean markInside()
    {
        lastSeenTime = (new Date()).getTime();
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
