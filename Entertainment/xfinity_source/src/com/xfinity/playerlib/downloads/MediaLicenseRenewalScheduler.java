// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.comcast.cim.utils.DebugUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.downloads:
//            MediaLicenseRenewalService

public class MediaLicenseRenewalScheduler
{
    private class ConnectivityChangeReceiver extends BroadcastReceiver
    {

        private final Logger LOG;
        private boolean isRegistered;
        final MediaLicenseRenewalScheduler this$0;

        public void onReceive(Context context1, Intent intent)
        {
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || intent.getBooleanExtra("noConnectivity", false))
            {
                break MISSING_BLOCK_LABEL_69;
            }
            this;
            JVM INSTR monitorenter ;
            if (isRegistered)
            {
                LOG.debug("Connection re-established");
                context1.startService(MediaLicenseRenewalService.createIntent(context1));
                context1.unregisterReceiver(this);
                isRegistered = false;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            context1;
            this;
            JVM INSTR monitorexit ;
            throw context1;
        }

        public void register()
        {
            this;
            JVM INSTR monitorenter ;
            if (!isRegistered)
            {
                IntentFilter intentfilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(this, intentfilter);
                isRegistered = true;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private ConnectivityChangeReceiver()
        {
            this$0 = MediaLicenseRenewalScheduler.this;
            super();
            LOG = LoggerFactory.getLogger(com/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver);
            isRegistered = false;
        }

    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler);
    private final ConnectivityChangeReceiver connectivityChangeReceiver = new ConnectivityChangeReceiver();
    private final Context context;

    public MediaLicenseRenewalScheduler(Context context1)
    {
        context = context1;
    }

    public void runAtInterval(long l)
    {
        LOG.debug("Scheduling next run");
        AlarmManager alarmmanager = (AlarmManager)context.getSystemService("alarm");
        Object obj = MediaLicenseRenewalService.createIntent(context);
        obj = PendingIntent.getService(context, 0, ((Intent) (obj)), 0x8000000);
        long l1 = SystemClock.elapsedRealtime();
        long l2 = System.currentTimeMillis();
        alarmmanager.set(3, l1 + l, ((PendingIntent) (obj)));
        LOG.debug("{} scheduled to run again at approximately {}", MediaLicenseRenewalService.NAME, DebugUtil.millisToDateString(l2 + l));
    }

    public void runWhenConnectionIsAvailable()
    {
        LOG.debug("Scheduling to run when internet connection is available");
        connectivityChangeReceiver.register();
    }


}
