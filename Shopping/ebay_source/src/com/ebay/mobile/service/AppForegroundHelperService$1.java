// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.service;

import android.util.Log;
import com.ebay.common.content.EbayBroadcast;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.util.LocationUtil;

// Referenced classes of package com.ebay.mobile.service:
//            AppForegroundHelperService

class this._cls0
    implements Runnable
{

    final AppForegroundHelperService this$0;

    public void run()
    {
        int i;
        try
        {
            Thread.sleep(5000L);
            i = AppForegroundHelperService.pendingBroadcasts - 1;
            AppForegroundHelperService.pendingBroadcasts = i;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        if (MyApp.isInForeground(AppForegroundHelperService.this))
        {
            break MISSING_BLOCK_LABEL_147;
        }
        if (Log.isLoggable(AppForegroundHelperService.access$000(), 2))
        {
            Log.v(AppForegroundHelperService.access$000(), "Looks like app backgrounded");
        }
        Thread.sleep(1000L);
        if (AppForegroundHelperService.pendingBroadcasts != 0)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        if (!MyApp.isInForeground(AppForegroundHelperService.this))
        {
            if (Log.isLoggable(AppForegroundHelperService.access$000(), 3))
            {
                Log.d(AppForegroundHelperService.access$000(), "App in background");
            }
            LocationUtil.sendForegroundOrBackgroundEvent(AppForegroundHelperService.this, "Background");
            EbayBroadcast.sendAppBackgroundBroadcast(AppForegroundHelperService.this);
            return;
        }
        if (Log.isLoggable(AppForegroundHelperService.access$000(), 2))
        {
            Log.v(AppForegroundHelperService.access$000(), "... but app still in foreground");
            return;
        }
        break MISSING_BLOCK_LABEL_166;
        if (Log.isLoggable(AppForegroundHelperService.access$000(), 2))
        {
            Log.v(AppForegroundHelperService.access$000(), "... but app sent another foreground check.");
            return;
        }
        break MISSING_BLOCK_LABEL_166;
        if (Log.isLoggable(AppForegroundHelperService.access$000(), 2))
        {
            Log.v(AppForegroundHelperService.access$000(), "App still in foreground.");
        }
    }

    ()
    {
        this$0 = AppForegroundHelperService.this;
        super();
    }
}
