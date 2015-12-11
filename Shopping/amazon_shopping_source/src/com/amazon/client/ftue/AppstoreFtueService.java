// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.ftue;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.amazon.logging.Logger;
import com.amazon.mas.client.security.broadcast.SecureBroadcastManager;

public class AppstoreFtueService extends IntentService
{

    private static final Long FTUE_SEND_DELAY = Long.valueOf(30000L);
    private static final Logger LOG = Logger.getLogger(com/amazon/client/ftue/AppstoreFtueService);

    public AppstoreFtueService()
    {
        super(com/amazon/client/ftue/AppstoreFtueService.getSimpleName());
    }

    private PendingIntent getDelayedPendingIntent()
    {
        return PendingIntent.getService(this, 0, (new Intent(this, com/amazon/client/ftue/AppstoreFtueService)).setAction("com.amazon.mas.client.startup.ftue.SEND_FTUE"), 0);
    }

    private SharedPreferences getFtueSharedPrefs()
    {
        return getSharedPreferences("appstore_ftue", 0);
    }

    private void reset(Intent intent)
    {
        if (intent.getStringExtra("com.amazon.mas.client.authentication.key.DIRECTEDID") == null)
        {
            LOG.e("Null account directedId encountered");
            return;
        }
        if (!intent.getBooleanExtra("com.amazon.mas.client.authentication.key.DEREGISTERED_ACCOUNT_IS_PRIMARY", false))
        {
            LOG.i("secondary account deregistration encountered, ignoring");
            return;
        } else
        {
            LOG.i("primary account deregistration encountered, clearing shared prefs");
            getFtueSharedPrefs().edit().remove("appstore_ftue_encountered").commit();
            getFtueSharedPrefs().edit().putBoolean("appstore_ftue_clear_webview_cache", true).commit();
            return;
        }
    }

    private void sendFtueBroadcast(SharedPreferences sharedpreferences)
    {
        PendingIntent pendingintent = getDelayedPendingIntent();
        ((AlarmManager)getSystemService("alarm")).cancel(pendingintent);
        pendingintent.cancel();
        sharedpreferences.edit().putBoolean("appstore_ftue_encountered", true).commit();
        sharedpreferences = new Intent("com.amazon.mas.client.application.events.APPSTORE_FTUE");
        (new SecureBroadcastManager(this)).sendBroadcast(sharedpreferences);
        LOG.i("sent broadcast: com.amazon.mas.client.application.events.APPSTORE_FTUE");
    }

    protected void onHandleIntent(Intent intent)
    {
        String s = intent.getAction();
        if ("com.amazon.mas.client.startup.ftue.RESET".equals(s))
        {
            reset(intent);
            return;
        }
        intent = getFtueSharedPrefs();
        if (intent.getBoolean("appstore_ftue_encountered", false))
        {
            LOG.i("request to send FTUE broadcast ignored as we've already broadcast it");
            return;
        }
        if ("com.amazon.mas.client.startup.ftue.FORCED_FTUE".equals(s))
        {
            LOG.i("sending broadcast immediately");
            sendFtueBroadcast(intent);
            return;
        }
        if ("com.amazon.mas.client.startup.ftue.DELAYED_FTUE".equals(s))
        {
            intent = getDelayedPendingIntent();
            ((AlarmManager)getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + FTUE_SEND_DELAY.longValue(), intent);
            LOG.i((new StringBuilder()).append("sending broadcast in ").append(FTUE_SEND_DELAY).append("ms").toString());
            return;
        }
        if ("com.amazon.mas.client.startup.ftue.SEND_FTUE".equals(s))
        {
            LOG.i("finished delay, sending FTUE broadcast");
            sendFtueBroadcast(intent);
            return;
        } else
        {
            LOG.w((new StringBuilder()).append("unexpected action received: ").append(s).toString());
            return;
        }
    }

}
