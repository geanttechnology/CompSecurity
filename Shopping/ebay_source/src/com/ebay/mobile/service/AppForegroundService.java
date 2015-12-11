// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.service;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.ebay.common.content.EbayBroadcast;
import com.ebay.mobile.util.LocationUtil;
import com.ebay.nautilus.shell.app.BaseIntentService;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.service:
//            AppForegroundHelperService

public class AppForegroundService extends BaseIntentService
{

    private static final String KEEP_AWAKE = "keepAwake";
    public static final String TAG = com/ebay/mobile/service/AppForegroundService.getSimpleName();
    private static int bindCount = 0;

    public AppForegroundService()
    {
        super(com/ebay/mobile/service/AppForegroundService.getSimpleName());
    }

    private boolean isSessionStarted()
    {
        for (Iterator iterator = ((ActivityManager)getSystemService("activity")).getRunningServices(0x7fffffff).iterator(); iterator.hasNext();)
        {
            android.app.ActivityManager.RunningServiceInfo runningserviceinfo = (android.app.ActivityManager.RunningServiceInfo)iterator.next();
            if (com/ebay/mobile/service/AppForegroundHelperService.getName().equals(runningserviceinfo.service.getClassName()))
            {
                return false;
            }
        }

        return true;
    }

    public IBinder onBind(Intent intent)
    {
        if (isSessionStarted())
        {
            if (Log.isLoggable(TAG, 3))
            {
                Log.d(TAG, "App is now in foreground!");
            }
            LocationUtil.sendForegroundOrBackgroundEvent(this, "Foreground");
            EbayBroadcast.sendAppForegroundBroadcast(this);
        }
        bindCount++;
        return super.onBind(intent);
    }

    protected void onHandleIntent(Intent intent)
    {
        if (intent != null && "keepAwake".equals(intent.getAction()))
        {
            (new Runnable() {

                final AppForegroundService this$0;

                public void run()
                {
                    try
                    {
                        Thread.sleep(100L);
                        if (AppForegroundService.bindCount == 0)
                        {
                            stopSelf();
                        }
                        return;
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        return;
                    }
                }

            
            {
                this$0 = AppForegroundService.this;
                super();
            }
            }).run();
        }
    }

    public boolean onUnbind(Intent intent)
    {
        bindCount--;
        Intent intent1 = new Intent(this, com/ebay/mobile/service/AppForegroundService);
        intent1.setAction("keepAwake");
        startService(intent1);
        intent1 = new Intent(this, com/ebay/mobile/service/AppForegroundHelperService);
        intent1.setAction("AppForegroundCheck");
        startService(intent1);
        return super.onUnbind(intent);
    }


}
