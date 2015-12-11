// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.manager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.services.FloaterService;
import com.bitstrips.imoji.util.PreferenceUtils;

public class FloaterServiceManager
{

    AlarmManager alarmManager;
    private Context context;
    private Intent floaterIntent;
    private PendingIntent pendingIntent;
    private long period;
    PreferenceUtils preferenceUtils;

    public FloaterServiceManager(Context context1)
    {
        ((InjectorApplication)context1).inject(this);
        context = context1;
        period = preferenceUtils.getInt(0x7f060084, 0x2bf20).intValue();
    }

    private Intent createFloaterIntent()
    {
        String s = preferenceUtils.getString(0x7f06002a, null);
        Intent intent = new Intent(context, com/bitstrips/imoji/services/FloaterService);
        intent.setData(Uri.parse(String.format(context.getString(0x7f060085), new Object[] {
            s
        })));
        return intent;
    }

    public void restartFloaterService()
    {
        stopFloaterService();
        startFloaterService();
    }

    public void startFloaterService()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = "b4m".equals("production");
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (android.os.Build.VERSION.SDK_INT <= 21)
        {
            floaterIntent = createFloaterIntent();
            pendingIntent = PendingIntent.getService(context, 0, floaterIntent, 0);
            context.startService(floaterIntent);
            alarmManager.setRepeating(3, SystemClock.elapsedRealtime() + period, period, pendingIntent);
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void stopFloaterService()
    {
        this;
        JVM INSTR monitorenter ;
        if (pendingIntent != null)
        {
            alarmManager.cancel(pendingIntent);
            pendingIntent = null;
        }
        if (floaterIntent != null)
        {
            context.stopService(floaterIntent);
            floaterIntent = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
