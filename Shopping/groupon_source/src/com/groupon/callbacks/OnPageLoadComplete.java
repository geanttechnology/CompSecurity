// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import android.os.SystemClock;
import com.groupon.activity.DealDetails;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.callbacks:
//            LoadCompleteCallback

public class OnPageLoadComplete
    implements LoadCompleteCallback
{

    private boolean hasBeenLogged;
    private Logger logger;
    private long startTime;

    public OnPageLoadComplete(Logger logger1, long l)
    {
        startTime = 0L;
        logger = logger1;
        startTime = l;
    }

    public void onLoadComplete()
    {
        if (!hasBeenLogged)
        {
            logger.logPageLoad("", com/groupon/activity/DealDetails.getSimpleName(), 0, startTime, (int)(SystemClock.elapsedRealtime() - startTime), Logger.NULL_NST_FIELD);
            hasBeenLogged = true;
        }
    }
}
