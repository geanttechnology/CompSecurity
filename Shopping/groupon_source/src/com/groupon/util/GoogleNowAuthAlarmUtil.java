// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.groupon.receiver.GoogleNowAuthWakefulBroadcastReceiver;
import com.groupon.service.LoginService;
import com.groupon.service.core.AbTestService;
import java.util.Calendar;
import roboguice.inject.Lazy;

public class GoogleNowAuthAlarmUtil
{

    private static final int RETRIES_ON_EXCEPTIONS = 3;
    private Lazy abTestService;
    private AlarmManager alarmManager;
    private Application application;
    private Lazy loginService;

    public GoogleNowAuthAlarmUtil()
    {
    }

    private void cancelPendingIntent(PendingIntent pendingintent)
    {
        pendingintent.cancel();
        alarmManager.cancel(pendingintent);
    }

    private PendingIntent currentPendingIntent()
    {
        Intent intent = new Intent(application, com/groupon/receiver/GoogleNowAuthWakefulBroadcastReceiver);
        return PendingIntent.getBroadcast(application, 0, intent, 0x20000000);
    }

    public void cancelAlarmIfSet()
    {
        PendingIntent pendingintent = currentPendingIntent();
        boolean flag;
        if (pendingintent != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            cancelPendingIntent(pendingintent);
        }
    }

    public void init()
    {
        alarmManager = (AlarmManager)application.getSystemService("alarm");
        abTestService = new Lazy(application) {

            final GoogleNowAuthAlarmUtil this$0;

            
            {
                this$0 = GoogleNowAuthAlarmUtil.this;
                super(context);
            }
        };
        loginService = new Lazy(application) {

            final GoogleNowAuthAlarmUtil this$0;

            
            {
                this$0 = GoogleNowAuthAlarmUtil.this;
                super(context);
            }
        };
    }

    public void setUpAlarmIfNotSet()
    {
        boolean flag1 = ((AbTestService)abTestService.get()).isVariantEnabledAndUSCA("googleNowRedemptionsUSCA1508", "on");
        Object obj = currentPendingIntent();
        boolean flag;
        if (obj != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag1 && ((LoginService)loginService.get()).isLoggedIn())
        {
            if (!flag)
            {
                obj = new Intent(application, com/groupon/receiver/GoogleNowAuthWakefulBroadcastReceiver);
                obj = PendingIntent.getBroadcast(application, 0, ((Intent) (obj)), 0x8000000);
                alarmManager.setInexactRepeating(2, 0L, 0x5265c00L, ((PendingIntent) (obj)));
            }
        } else
        if (flag)
        {
            cancelPendingIntent(((PendingIntent) (obj)));
            return;
        }
    }

    public boolean setUpAlarmWhenException(Intent intent)
    {
        int i = intent.getIntExtra("request_retries", 3) - 1;
        if (i >= 0)
        {
            intent = Calendar.getInstance();
            intent.add(11, 1);
            alarmManager.set(0, intent.getTimeInMillis(), PendingIntent.getBroadcast(application, 1, (new Intent(application, com/groupon/receiver/GoogleNowAuthWakefulBroadcastReceiver)).putExtra("request_retries", i), 0x8000000));
            return true;
        } else
        {
            return false;
        }
    }
}
