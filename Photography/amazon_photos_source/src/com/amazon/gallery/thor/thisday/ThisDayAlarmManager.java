// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.thor.app.BroadcastReceiverUtility;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.service.ThisDayPrefetchService;
import java.util.Calendar;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDaySharedPrefsManager, ThisDayBroadcastReceiver, ThisDayUtils

public class ThisDayAlarmManager
    implements android.content.SharedPreferences.OnSharedPreferenceChangeListener, AccountChangeListener
{
    public static final class AlarmType extends Enum
    {

        private static final AlarmType $VALUES[];
        public static final AlarmType NOTIFICATION_ALARM;
        public static final AlarmType PREFETCH_ALARM;

        public static AlarmType valueOf(String s)
        {
            return (AlarmType)Enum.valueOf(com/amazon/gallery/thor/thisday/ThisDayAlarmManager$AlarmType, s);
        }

        public static AlarmType[] values()
        {
            return (AlarmType[])$VALUES.clone();
        }

        static 
        {
            NOTIFICATION_ALARM = new AlarmType("NOTIFICATION_ALARM", 0);
            PREFETCH_ALARM = new AlarmType("PREFETCH_ALARM", 1);
            $VALUES = (new AlarmType[] {
                NOTIFICATION_ALARM, PREFETCH_ALARM
            });
        }

        private AlarmType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/thor/thisday/ThisDayAlarmManager.getName();
    private final AlarmManager alarmManager;
    private final AmazonInsightsHelper amazonInsightsHelper;
    private final Context appContext;
    private final AuthenticationManager authenticationManager;
    private final Intent thisDayNotificationIntent;
    private final Intent thisDayPrefetchIntent;
    private final ThisDaySharedPrefsManager thisDaySharedPrefsManager;

    public ThisDayAlarmManager(Context context)
    {
        appContext = context.getApplicationContext();
        alarmManager = (AlarmManager)appContext.getSystemService("alarm");
        authenticationManager = (AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER);
        amazonInsightsHelper = (AmazonInsightsHelper)ThorGalleryApplication.getBean(Keys.AMAZON_INSIGHTS_HELPER);
        thisDaySharedPrefsManager = new ThisDaySharedPrefsManager(context);
        thisDayNotificationIntent = new Intent(appContext, com/amazon/gallery/thor/thisday/ThisDayBroadcastReceiver);
        thisDayNotificationIntent.setAction("com.amazon.photos.action.ACTION_SHOW_THIS_DAY_NOTIFICATION");
        thisDayPrefetchIntent = new Intent(appContext, com/amazon/gallery/thor/thisday/ThisDayBroadcastReceiver);
        thisDayPrefetchIntent.setAction("com.amazon.photos.action.ACTION_PREFETCH_THIS_DAY_DATA");
    }

    private void attemptPrefetchBannerData()
    {
        Object obj = new ThisDaySharedPrefsManager(appContext);
        if (!StringUtils.isEmpty(((ThisDaySharedPrefsManager) (obj)).getPrefetchedBannerData()) && !((ThisDaySharedPrefsManager) (obj)).isPrefetchedBannerDataStale())
        {
            return;
        }
        obj = appContext.getSharedPreferences("galleryKindleSharedPrefs", 0);
        if (((SharedPreferences) (obj)).getBoolean("coldBootStatus", false))
        {
            appContext.startService(new Intent(appContext, com/amazon/gallery/thor/app/service/ThisDayPrefetchService));
            return;
        } else
        {
            ((SharedPreferences) (obj)).registerOnSharedPreferenceChangeListener(this);
            return;
        }
    }

    private PendingIntent createAlarmPendingIntent(Intent intent)
    {
        return PendingIntent.getBroadcast(appContext, 0, intent, 0);
    }

    private void doSetAlarm(AlarmType alarmtype, Intent intent)
    {
        byte byte0;
        int i;
        long l;
        if (alarmtype == AlarmType.NOTIFICATION_ALARM)
        {
            byte0 = 9;
            i = 0;
        } else
        {
            byte0 = 0;
            i = 1;
        }
        l = getAlarmStartTime(byte0, i);
        cancelAlarm(alarmtype);
        alarmtype = createAlarmPendingIntent(intent);
        alarmManager.setInexactRepeating(0, l, 0x5265c00L, alarmtype);
    }

    private long getAlarmStartTime(int i, int j)
    {
        Calendar calendar = Calendar.getInstance();
        long l2 = calendar.getTimeInMillis();
        calendar.set(11, i);
        calendar.set(12, j);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long l1 = calendar.getTimeInMillis();
        long l = l1;
        if (l1 < l2)
        {
            incrementCalendarByOneDay(calendar, l2);
            l = calendar.getTimeInMillis();
        }
        GLogger.d(TAG, (new StringBuilder()).append("New this day alarm set at ").append(String.format("%s/%s/%s %s:%s", new Object[] {
            Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(2)), Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12))
        })).toString(), new Object[0]);
        return l;
    }

    private static void incrementCalendarByOneDay(Calendar calendar, long l)
    {
        calendar.add(5, 1);
        if (calendar.getTimeInMillis() < l)
        {
            calendar.add(6, 1);
        }
    }

    private boolean isAlarmSet(Intent intent)
    {
        boolean flag = false;
        if (PendingIntent.getBroadcast(appContext, 0, intent, 0x20000000) != null)
        {
            flag = true;
        }
        return flag;
    }

    private void updateBannerEnabledPreference()
    {
        amazonInsightsHelper.loadLaunch("This Day", "show_banner", new com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper.LaunchLoadedListener() {

            final ThisDayAlarmManager this$0;

            public void onLaunchLoaded(boolean flag)
            {
                thisDaySharedPrefsManager.setBannerEnabled(flag);
            }

            
            {
                this$0 = ThisDayAlarmManager.this;
                super();
            }
        });
    }

    public void cancelAlarm(AlarmType alarmtype)
    {
        if (alarmtype == AlarmType.NOTIFICATION_ALARM)
        {
            alarmtype = thisDayNotificationIntent;
        } else
        {
            alarmtype = thisDayPrefetchIntent;
        }
        alarmtype = createAlarmPendingIntent(alarmtype);
        alarmManager.cancel(alarmtype);
        alarmtype.cancel();
    }

    public void onAccountDeregistered()
    {
        cancelAlarm(AlarmType.NOTIFICATION_ALARM);
        cancelAlarm(AlarmType.PREFETCH_ALARM);
        BroadcastReceiverUtility.toggleBroadcastReceiver(appContext, com/amazon/gallery/thor/thisday/ThisDayBroadcastReceiver, false);
    }

    public void onAccountRegistered()
    {
        BroadcastReceiverUtility.toggleBroadcastReceiver(appContext, com/amazon/gallery/thor/thisday/ThisDayBroadcastReceiver, true);
        setAlarm(AlarmType.NOTIFICATION_ALARM, false);
        setAlarm(AlarmType.PREFETCH_ALARM, false);
        if (StringUtils.isEmpty((new ThisDaySharedPrefsManager(appContext)).getCustomerEmailAddress()))
        {
            ThisDayUtils.prefetchCustomerEmailAddress(appContext, (RestClient)ThorGalleryApplication.getBean(Keys.REST_CLIENT));
        }
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        while (sharedpreferences == null || !"coldBootStatus".equals(s) || !sharedpreferences.getBoolean("coldBootStatus", false)) 
        {
            return;
        }
        sharedpreferences.unregisterOnSharedPreferenceChangeListener(this);
        appContext.startService(new Intent(appContext, com/amazon/gallery/thor/app/service/ThisDayPrefetchService));
    }

    public void setAlarm(final AlarmType alarmType, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = authenticationManager.hasActiveAccount();
        if (flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        final Intent intentToFire;
        updateBannerEnabledPreference();
        intentToFire = new ThisDaySharedPrefsManager(appContext);
        if (alarmType == AlarmType.NOTIFICATION_ALARM && !intentToFire.areNotificationsEnabled()) goto _L1; else goto _L3
_L3:
        if (alarmType != AlarmType.NOTIFICATION_ALARM)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        intentToFire = thisDayNotificationIntent;
_L5:
        flag1 = isAlarmSet(intentToFire);
        if (flag1 && !flag) goto _L1; else goto _L4
_L4:
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        if (alarmType == AlarmType.PREFETCH_ALARM)
        {
            attemptPrefetchBannerData();
        }
        if (alarmType != AlarmType.NOTIFICATION_ALARM)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        amazonInsightsHelper.loadLaunch("This Day", "show_notifications", new com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper.LaunchLoadedListener() {

            final ThisDayAlarmManager this$0;
            final AlarmType val$alarmType;
            final Intent val$intentToFire;

            public void onLaunchLoaded(boolean flag2)
            {
                if (flag2)
                {
                    doSetAlarm(alarmType, intentToFire);
                    return;
                } else
                {
                    GLogger.i(ThisDayAlarmManager.TAG, "Not setting This Day notification alarm", new Object[0]);
                    return;
                }
            }

            
            {
                this$0 = ThisDayAlarmManager.this;
                alarmType = alarmtype;
                intentToFire = intent;
                super();
            }
        });
          goto _L1
        alarmType;
        throw alarmType;
        intentToFire = thisDayPrefetchIntent;
          goto _L5
        doSetAlarm(alarmType, intentToFire);
          goto _L1
    }




}
