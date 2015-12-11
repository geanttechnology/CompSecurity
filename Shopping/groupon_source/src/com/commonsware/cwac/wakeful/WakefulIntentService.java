// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.commonsware.cwac.wakeful;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PowerManager;

// Referenced classes of package com.commonsware.cwac.wakeful:
//            AlarmReceiver

public abstract class WakefulIntentService extends IntentService
{
    public static interface AlarmListener
    {

        public abstract long getMaxAge();

        public abstract void scheduleAlarms(AlarmManager alarmmanager, PendingIntent pendingintent, Context context);

        public abstract void sendWakefulWork(Context context);
    }


    static final String LAST_ALARM = "lastAlarm";
    static final String NAME = "com.commonsware.cwac.wakeful.WakefulIntentService";
    private static volatile android.os.PowerManager.WakeLock lockStatic = null;

    public WakefulIntentService(String s)
    {
        super(s);
        setIntentRedelivery(true);
    }

    public static void cancelAlarms(Context context)
    {
        ((AlarmManager)context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, com/commonsware/cwac/wakeful/AlarmReceiver), 0));
    }

    private static android.os.PowerManager.WakeLock getLock(Context context)
    {
        com/commonsware/cwac/wakeful/WakefulIntentService;
        JVM INSTR monitorenter ;
        if (lockStatic == null)
        {
            lockStatic = ((PowerManager)context.getSystemService("power")).newWakeLock(1, "com.commonsware.cwac.wakeful.WakefulIntentService");
            lockStatic.setReferenceCounted(true);
        }
        context = lockStatic;
        com/commonsware/cwac/wakeful/WakefulIntentService;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static void scheduleAlarms(AlarmListener alarmlistener, Context context)
    {
        scheduleAlarms(alarmlistener, context, true);
    }

    public static void scheduleAlarms(AlarmListener alarmlistener, Context context, boolean flag)
    {
        long l = context.getSharedPreferences("com.commonsware.cwac.wakeful.WakefulIntentService", 0).getLong("lastAlarm", 0L);
        if (l == 0L || flag || System.currentTimeMillis() > l && System.currentTimeMillis() - l > alarmlistener.getMaxAge())
        {
            alarmlistener.scheduleAlarms((AlarmManager)context.getSystemService("alarm"), PendingIntent.getBroadcast(context, 0, new Intent(context, com/commonsware/cwac/wakeful/AlarmReceiver), 0), context);
        }
    }

    public static void sendWakefulWork(Context context, Intent intent)
    {
        getLock(context.getApplicationContext()).acquire();
        context.startService(intent);
    }

    public static void sendWakefulWork(Context context, Class class1)
    {
        sendWakefulWork(context, new Intent(context, class1));
    }

    protected abstract void doWakefulWork(Intent intent);

    protected final void onHandleIntent(Intent intent)
    {
        doWakefulWork(intent);
        intent = getLock(getApplicationContext());
        if (intent.isHeld())
        {
            intent.release();
        }
        return;
        intent;
        android.os.PowerManager.WakeLock wakelock = getLock(getApplicationContext());
        if (wakelock.isHeld())
        {
            wakelock.release();
        }
        throw intent;
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        android.os.PowerManager.WakeLock wakelock = getLock(getApplicationContext());
        if (!wakelock.isHeld() || (i & 1) != 0)
        {
            wakelock.acquire();
        }
        super.onStartCommand(intent, i, j);
        return 3;
    }

}
