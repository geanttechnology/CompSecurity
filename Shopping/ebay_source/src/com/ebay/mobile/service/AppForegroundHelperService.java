// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.service;

import android.content.Intent;
import android.util.Log;
import com.ebay.common.content.EbayBroadcast;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.util.LocationUtil;
import com.ebay.nautilus.shell.app.BaseIntentService;

// Referenced classes of package com.ebay.mobile.service:
//            AppForegroundService

public class AppForegroundHelperService extends BaseIntentService
{

    public static final String CHECK_FOREGROUND = "AppForegroundCheck";
    private static final String TAG;
    public static int pendingBroadcasts = 0;

    public AppForegroundHelperService()
    {
        super(com/ebay/mobile/service/AppForegroundHelperService.getSimpleName());
    }

    protected void onHandleIntent(Intent intent)
    {
        if (intent.getAction().equals("AppForegroundCheck"))
        {
            (new Runnable() {

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
                    if (Log.isLoggable(AppForegroundHelperService.TAG, 2))
                    {
                        Log.v(AppForegroundHelperService.TAG, "Looks like app backgrounded");
                    }
                    Thread.sleep(1000L);
                    if (AppForegroundHelperService.pendingBroadcasts != 0)
                    {
                        break MISSING_BLOCK_LABEL_127;
                    }
                    if (!MyApp.isInForeground(AppForegroundHelperService.this))
                    {
                        if (Log.isLoggable(AppForegroundHelperService.TAG, 3))
                        {
                            Log.d(AppForegroundHelperService.TAG, "App in background");
                        }
                        LocationUtil.sendForegroundOrBackgroundEvent(AppForegroundHelperService.this, "Background");
                        EbayBroadcast.sendAppBackgroundBroadcast(AppForegroundHelperService.this);
                        return;
                    }
                    if (Log.isLoggable(AppForegroundHelperService.TAG, 2))
                    {
                        Log.v(AppForegroundHelperService.TAG, "... but app still in foreground");
                        return;
                    }
                    break MISSING_BLOCK_LABEL_166;
                    if (Log.isLoggable(AppForegroundHelperService.TAG, 2))
                    {
                        Log.v(AppForegroundHelperService.TAG, "... but app sent another foreground check.");
                        return;
                    }
                    break MISSING_BLOCK_LABEL_166;
                    if (Log.isLoggable(AppForegroundHelperService.TAG, 2))
                    {
                        Log.v(AppForegroundHelperService.TAG, "App still in foreground.");
                    }
                }

            
            {
                this$0 = AppForegroundHelperService.this;
                super();
            }
            }).run();
        }
    }

    public void onStart(Intent intent, int i)
    {
        super.onStart(intent, i);
        pendingBroadcasts++;
    }

    static 
    {
        TAG = AppForegroundService.TAG;
    }

}
