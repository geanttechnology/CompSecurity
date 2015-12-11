// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.groupon.receiver.MarkUsedReceiver;
import java.util.concurrent.TimeUnit;

public class MarkUsedAlarmUtil
{

    protected static final int APP_CREATE_REQUEST_CODE = 0x173968e;

    public MarkUsedAlarmUtil()
    {
    }

    private PendingIntent createUpdatePendingAlarmIntent(Context context)
    {
        return PendingIntent.getBroadcast(context, 0x173968e, createIntent(context), 0x8000000);
    }

    protected Intent createIntent(Context context)
    {
        return new Intent(context, com/groupon/receiver/MarkUsedReceiver);
    }

    public boolean isAlarmSet(Application application)
    {
        return PendingIntent.getBroadcast(application, 0x173968e, createIntent(application), 0x20000000) != null;
    }

    public void setUpAlarmIfNotSet(Application application, long l, long l1)
    {
        if (!isAlarmSet(application))
        {
            ((AlarmManager)application.getSystemService("alarm")).setRepeating(2, SystemClock.elapsedRealtime() + TimeUnit.MINUTES.toMillis(l), TimeUnit.HOURS.toMillis(l1), createUpdatePendingAlarmIntent(application));
        }
    }
}
