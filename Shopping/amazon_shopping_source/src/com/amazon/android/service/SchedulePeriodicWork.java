// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.amazon.logging.Logger;
import java.util.Date;

public final class SchedulePeriodicWork
{

    private static final Logger LOG = Logger.getLogger(com/amazon/android/service/SchedulePeriodicWork);
    private static final String SHARED_PREFS_NAME = com/amazon/android/service/SchedulePeriodicWork.getCanonicalName();

    private SchedulePeriodicWork()
    {
    }

    private static void cancelAlarmsAndPendingIntentsForIntent(Context context, Intent intent)
    {
        PendingIntent pendingintent = PendingIntent.getService(context, 0, intent, 0x20000000);
        if (pendingintent != null)
        {
            LOG.v((new StringBuilder()).append("Cancelling pending intent for ").append(getWorkIdentifier(intent)).append("  (SCHEDULER)").toString());
            ((AlarmManager)context.getSystemService("alarm")).cancel(pendingintent);
            pendingintent.cancel();
        }
    }

    public static void cancelWork(Context context, Intent intent)
    {
        String s = getWorkIdentifier(intent);
        LOG.d((new StringBuilder()).append("Cancelling work for ").append(s).append(" (SCHEDULER)").toString());
        getSharedPrefs(context).edit().remove(s.concat(".lastRun")).remove(s.concat(".scheduleTime")).remove(s.concat(".period")).remove(s.concat(".scheduledFor")).remove(s.concat(".timeout")).commit();
        cancelAlarmsAndPendingIntentsForIntent(context, intent);
    }

    public static void forceRescheduleWork(Context context, Intent intent, long l)
    {
        forceRescheduleWork(context, intent, l, 60000L);
    }

    public static void forceRescheduleWork(Context context, Intent intent, long l, long l1)
    {
        if (l < 0L || l1 < 0L)
        {
            throw new IllegalArgumentException("Negative period or delay, not continuing. (SCHEDULER)");
        } else
        {
            cancelAlarmsAndPendingIntentsForIntent(context, intent);
            long l2 = System.currentTimeMillis();
            String s = getWorkIdentifier(intent);
            l1 = l2 + l1;
            setPrefValues(context, s, l2, l1, l);
            intent = getPendingIntent(context, intent);
            ((AlarmManager)context.getSystemService("alarm")).set(1, l1, intent);
            return;
        }
    }

    private static long getLastRunTime(Context context, String s)
    {
        return getSharedPrefs(context).getLong(s.concat(".lastRun"), -1L);
    }

    private static PendingIntent getPendingIntent(Context context, Intent intent)
    {
        return PendingIntent.getService(context, 0, intent, 0x10000000);
    }

    private static long getPeriod(Context context, String s)
    {
        return getSharedPrefs(context).getLong(s.concat(".period"), -1L);
    }

    private static long getScheduleOriginTime(Context context)
    {
        context = getSharedPrefs(context);
        if (!context.contains("alarmOrigin"))
        {
            long l = (new Date()).getTime();
            context.edit().putLong("alarmOrigin", l).commit();
            LOG.d((new StringBuilder()).append("(SCHEDULER) Origin time set to ").append((new Date(l)).toString()).toString());
            return l;
        } else
        {
            return context.getLong("alarmOrigin", -1L);
        }
    }

    private static long getScheduleTime(Context context, String s)
    {
        return getSharedPrefs(context).getLong(s.concat(".scheduleTime"), -1L);
    }

    private static long getScheduledFor(Context context, String s)
    {
        return getSharedPrefs(context).getLong(s.concat(".scheduledFor"), -1L);
    }

    private static SharedPreferences getSharedPrefs(Context context)
    {
        return context.getSharedPreferences(SHARED_PREFS_NAME, 0);
    }

    private static long getSuitableRetryDelayMillis(long l)
    {
        long l1 = 0x1499700L;
        if (l <= 0x1499700L)
        {
            l1 = -1L;
        } else
        if (l > 0x5265c00L)
        {
            return 0x5265c00L;
        }
        return l1;
    }

    private static String getWorkIdentifier(Intent intent)
    {
        StringBuilder stringbuilder = new StringBuilder();
        ComponentName componentname = intent.getComponent();
        if (componentname != null)
        {
            stringbuilder.append(componentname.flattenToString()).append("-");
        }
        intent = intent.getAction();
        if (intent != null)
        {
            stringbuilder.append(intent);
        }
        return stringbuilder.toString();
    }

    private static void scheduleToWindow(Context context, Intent intent, long l, String s)
    {
        Object obj = Long.valueOf(System.currentTimeMillis());
        long l1 = getScheduleOriginTime(context);
        l1 = 0x36ee80L * (long)Math.ceil((double)((((Long) (obj)).longValue() + l) - l1) / 3600000D) + l1 + Math.round(Math.random() * 180D * 1000D);
        long l2 = ((Long) (obj)).longValue();
        obj = new Date(l1);
        LOG.i((new StringBuilder()).append(s).append(" - next work will occur at ").append(((Date) (obj)).toString()).append(" (SCHEDULER)").toString());
        forceRescheduleWork(context, intent, l, l1 - l2);
    }

    public static void scheduleWork(Context context, Intent intent, long l)
    {
        scheduleWork(context, intent, l, 60000L);
    }

    public static void scheduleWork(Context context, Intent intent, long l, long l1)
    {
        scheduleWork(context, intent, l, l1, l * 2L);
    }

    public static void scheduleWork(Context context, Intent intent, long l, long l1, long l2)
    {
        if (l2 < l)
        {
            throw new IllegalArgumentException("Timeout must be greater than period!");
        }
        String s = getWorkIdentifier(intent);
        long l3 = getLastRunTime(context, s);
        long l4 = getScheduleTime(context, s);
        Long long1 = Long.valueOf(System.currentTimeMillis());
        long l5 = getScheduledFor(context, s);
        boolean flag;
        if (l4 < 0L || l4 + l1 < long1.longValue() && (long1.longValue() < l3 || long1.longValue() > l3 + l2))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && PendingIntent.getService(context, 0, intent, 0x20000000) != null)
        {
            LOG.d((new StringBuilder()).append(s).append(" is within acceptable timeout period of ").append(l2 / 0x36ee80L).append(" hours and is scheduled to run at ").append((new Date(Long.valueOf(l5).longValue())).toString()).append(". No need to ").append("reschedule now (SCHEDULER)").toString());
            return;
        }
        setTimeout(context, s, l2);
        if (l4 < 0L || l3 < 0L || l3 + l + 0x36ee80L < long1.longValue())
        {
            LOG.i((new StringBuilder()).append(s).append(" is being scheduled for now, skipping windowing logic. (SCHEDULER)").toString());
            forceRescheduleWork(context, intent, l, 60000L);
            return;
        } else
        {
            LOG.d((new StringBuilder()).append(s).append(" is being scheduled into a window. lastRun = ").append((new Date(l3)).toString()).append("").append(" (SCHEDULER)").toString());
            scheduleToWindow(context, intent, l, s);
            return;
        }
    }

    private static void setLastRunTime(Context context, String s, long l)
    {
        context = getSharedPrefs(context).edit();
        context.putLong(s.concat(".lastRun"), l);
        context.commit();
    }

    private static void setPrefValues(Context context, String s, long l, long l1, long l2)
    {
        context = getSharedPrefs(context).edit();
        context.putLong(s.concat(".scheduleTime"), l);
        context.putLong(s.concat(".scheduledFor"), l1);
        context.putLong(s.concat(".period"), l2);
        context.commit();
    }

    private static void setTimeout(Context context, String s, long l)
    {
        getSharedPrefs(context).edit().putLong(s.concat(".timeout"), l).commit();
    }

    public static void workComplete(Context context, Intent intent)
    {
        workComplete(context, intent, System.currentTimeMillis());
    }

    public static void workComplete(Context context, Intent intent, long l)
    {
        String s = getWorkIdentifier(intent);
        long l1 = getLastRunTime(context, s);
        long l2 = getScheduleTime(context, s);
        long l3 = getPeriod(context, s);
        if (l1 < l2)
        {
            LOG.d((new StringBuilder()).append(s).append(" work complete, scheduling next alarm (SCHEDULER)").toString());
            scheduleToWindow(context, intent, l3, s);
        } else
        {
            LOG.d((new StringBuilder()).append(s).append(" already scheduled for repeating alarm, doing nothing. (SCHEDULER)").toString());
        }
        setLastRunTime(context, s, l);
    }

    public static void workFailed(Context context, Intent intent)
    {
        String s = getWorkIdentifier(intent);
        long l1 = getScheduleTime(context, s);
        long l = getPeriod(context, s);
        long l2 = getLastRunTime(context, s);
        if (l1 < 0L || l < 0L)
        {
            LOG.i((new StringBuilder()).append(s).append(" encountered workFailed() concurrent with clear data, ignoring (SCHEDULER)").toString());
            return;
        }
        if (l2 < 0L)
        {
            LOG.w((new StringBuilder()).append(s).append(" workFailed() but will retry on next run of Appstore, ignoring (SCHEDULER)").toString());
            return;
        }
        if (l2 > l1)
        {
            LOG.w((new StringBuilder()).append(s).append(" encountered workFailed() concurrent with workComplete(), ignoring (SCHEDULER)").toString());
            return;
        }
        l1 = getSuitableRetryDelayMillis(l);
        if (l1 < 0L)
        {
            LOG.w((new StringBuilder()).append(s).append(" workFailed() and retry is not applicable, using normal windowing (SCHEDULER)").toString());
            scheduleToWindow(context, intent, l, s);
            return;
        } else
        {
            LOG.v((new StringBuilder()).append(s).append(" retry is being scheduled for ").append(l1 / 1000L).append(" seconds from now, skipping windowing logic. (SCHEDULER)").toString());
            forceRescheduleWork(context, intent, l, l1);
            return;
        }
    }

}
