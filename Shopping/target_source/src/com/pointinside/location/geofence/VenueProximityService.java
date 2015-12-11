// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.pointinside.internal.utils.LogUtils;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.pointinside.location.geofence:
//            ProviderHelper, LocationReceiver

public class VenueProximityService extends Service
{
    private static final class ACTION extends Enum
    {

        private static final ACTION $VALUES[];
        public static final ACTION END_LOCATION_ALARM;
        public static final ACTION START;
        public static final ACTION STOP;
        private String str;

        public static ACTION toEnum(String s)
        {
            ACTION action = null;
            ACTION aaction[] = values();
            int j = aaction.length;
            for (int i = 0; i < j; i++)
            {
                ACTION action1 = aaction[i];
                if (action1.str.equals(s))
                {
                    action = action1;
                }
            }

            return action;
        }

        public static ACTION valueOf(String s)
        {
            return (ACTION)Enum.valueOf(com/pointinside/location/geofence/VenueProximityService$ACTION, s);
        }

        public static ACTION[] values()
        {
            return (ACTION[])$VALUES.clone();
        }

        static 
        {
            START = new ACTION("START", 0, "com.pointinside.android.action.START_PROXIMITY_DETECTION");
            STOP = new ACTION("STOP", 1, "com.pointinside.android.action.STOP_PROXIMITY_DETECTION");
            END_LOCATION_ALARM = new ACTION("END_LOCATION_ALARM", 2, "com.pointinside.android.action.LOCATION_ALARM");
            $VALUES = (new ACTION[] {
                START, STOP, END_LOCATION_ALARM
            });
        }


        private ACTION(String s, int i, String s1)
        {
            super(s, i);
            str = s1;
        }
    }

    private final class ServiceHandler extends Handler
    {

        final VenueProximityService this$0;

        public void handleMessage(Message message)
        {
            Intent intent;
            int i;
            int j;
            int k;
            intent = (Intent)message.getData().getParcelable("intent");
            i = intent.getIntExtra("intent_interval", 0x1d4c0);
            j = intent.getIntExtra("intent_duration", 8000);
            k = message.arg1;
            boolean flag = intent.getBooleanExtra("intent_pending", false);
            message = getApplicationContext().getPackageName();
            PendingIntent pendingintent = VenueProximityService.getExistingPending(getApplicationContext(), intent);
            if (flag && pendingintent != null)
            {
                pendingintent.cancel();
            }
            static class _cls2
            {

                static final int $SwitchMap$com$pointinside$location$geofence$VenueProximityService$ACTION[];

                static 
                {
                    $SwitchMap$com$pointinside$location$geofence$VenueProximityService$ACTION = new int[ACTION.values().length];
                    try
                    {
                        $SwitchMap$com$pointinside$location$geofence$VenueProximityService$ACTION[ACTION.START.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$pointinside$location$geofence$VenueProximityService$ACTION[ACTION.END_LOCATION_ALARM.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls2..SwitchMap.com.pointinside.location.geofence.VenueProximityService.ACTION[ACTION.toEnum(intent.getAction()).ordinal()];
            JVM INSTR tableswitch 1 2: default 120
        //                       1 152
        //                       2 190;
               goto _L1 _L2 _L3
_L1:
            LogUtils.logD(VenueProximityService.LOG_TAG, "KILL ME");
            killSearch();
            cancelAllAlarms();
            stopSelf(k);
_L5:
            return;
_L2:
            if (VenueProximityService.alarmSet(getApplicationContext())) goto _L5; else goto _L4
_L4:
            startSearch();
            setNextAlarm(VenueProximityService.getKillLocationIntent(message, i, j), j);
            return;
_L3:
            nextInterval();
            return;
        }

        public ServiceHandler(Looper looper)
        {
            this$0 = VenueProximityService.this;
            super(looper);
        }
    }


    protected static final String CLASS_NAME = com/pointinside/location/geofence/VenueProximityService.getName();
    private static final int DEFAULT_DURATION = 8000;
    private static final int DEFAULT_INTERVAL = 0x1d4c0;
    static final int FLAG_DO_NOT_SET = 0x80000000;
    protected static final String INTENT_DURATION_NAME = "intent_duration";
    protected static final String INTENT_FROM_PENDING = "intent_pending";
    protected static final String INTENT_INTERVAL_NAME = "intent_interval";
    protected static final Map INTENT_MAP = new HashMap();
    static final String LOG_TAG = LogUtils.makeLogTag(com/pointinside/location/geofence/VenueProximityService.getSimpleName());
    private static final int REQUEST_CODE = 1234;
    private static boolean isRunning = false;
    private static ProviderHelper mProviderHelper;
    private ServiceHandler mServiceHandler;

    public VenueProximityService()
    {
    }

    static boolean alarmSet(Context context)
    {
        String s = context.getPackageName();
        return getExistingPending(context, getStartIntent(s)) != null || getExistingPending(context, getKillLocationIntent(s)) != null;
    }

    private static Bundle bundleIntent(Intent intent)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        return bundle;
    }

    private void cancelAlarmsLikeThis(Intent intent)
    {
        ((AlarmManager)getSystemService("alarm")).cancel(getPendingIntent(getApplicationContext(), intent));
    }

    private void cancelAllAlarms()
    {
        Intent intent;
        for (Iterator iterator = INTENT_MAP.values().iterator(); iterator.hasNext(); getExistingPending(getApplicationContext(), intent).cancel())
        {
            intent = (Intent)iterator.next();
            cancelAlarmsLikeThis(intent);
        }

    }

    private static PendingIntent getExistingPending(Context context, Intent intent)
    {
        return PendingIntent.getService(context, 1234, intent, 0x20000000);
    }

    private static Intent getIntent(String s, ACTION action)
    {
        if (!intentExists(action))
        {
            Intent intent = new Intent();
            intent.setAction(action.str);
            intent.setComponent(new ComponentName(s, CLASS_NAME));
            INTENT_MAP.put(action, intent);
        }
        ((Intent)INTENT_MAP.get(action)).removeExtra("intent_pending");
        return (Intent)INTENT_MAP.get(action);
    }

    private static Intent getKillLocationIntent(String s)
    {
        return getKillLocationIntent(s, 0x80000000, 0x80000000);
    }

    private static Intent getKillLocationIntent(String s, int i, int j)
    {
        s = getIntent(s, ACTION.END_LOCATION_ALARM);
        if (i >= 0)
        {
            s.putExtra("intent_interval", i);
        }
        if (j >= 0)
        {
            s.putExtra("intent_duration", j);
        }
        return s;
    }

    static long getMillisToTrigger(int i)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(14, i);
        return calendar.getTimeInMillis();
    }

    private static PendingIntent getPendingIntent(Context context, Intent intent)
    {
        intent.putExtra("intent_pending", true);
        return PendingIntent.getService(context, 1234, intent, 0x10000000);
    }

    private static Intent getStartIntent(String s)
    {
        return getStartIntent(s, 0x80000000, 0x80000000);
    }

    static Intent getStartIntent(String s, int i, int j)
    {
        s = getIntent(s, ACTION.START);
        if (i >= 0)
        {
            s.putExtra("intent_interval", i);
        }
        if (j >= 0)
        {
            s.putExtra("intent_duration", j);
        }
        return s;
    }

    static Intent getStopIntent(String s)
    {
        return getIntent(s, ACTION.STOP);
    }

    private static boolean intentExists(ACTION action)
    {
        return INTENT_MAP.containsKey(action);
    }

    static boolean isRunning()
    {
        return isRunning;
    }

    private void killSearch()
    {
        if (mProviderHelper != null)
        {
            mProviderHelper.destroy();
        }
        mProviderHelper = null;
    }

    private void logLocationUpdate(Location location)
    {
        if (location != null)
        {
            double d = location.getLatitude();
            double d1 = location.getLongitude();
            LogUtils.logD(LOG_TAG, (new StringBuilder()).append("broadcast best location (").append(location.getProvider()).append("): lat:").append(d).append(" lng:").append(d1).toString());
            return;
        } else
        {
            LogUtils.logD(LOG_TAG, "No broadcast sent: location==NULL");
            return;
        }
    }

    private void nextInterval()
    {
        if (mProviderHelper != null)
        {
            mProviderHelper.close();
        }
        mProviderHelper = null;
    }

    static void setNextAlarm(Context context, Intent intent, int i)
    {
        LogUtils.logD(LOG_TAG, (new StringBuilder()).append("Set Alarm: ").append(String.format("%.1fs", new Object[] {
            Float.valueOf((float)i / 1000F)
        })).append(", ").append(intent.getAction().substring(intent.getAction().lastIndexOf(".") + 1)).toString());
        ((AlarmManager)context.getSystemService("alarm")).set(0, getMillisToTrigger(i), getPendingIntent(context, intent));
    }

    private void setNextAlarm(Intent intent, int i)
    {
        setNextAlarm(getApplicationContext(), intent, i);
    }

    private void startSearch()
    {
        killSearch();
        mProviderHelper = new ProviderHelper(getLocationManager()) {

            final VenueProximityService this$0;

            List getLocationProviders()
            {
                List list = LOCATION_MANAGER.getAllProviders();
                list.remove("passive");
                return list;
            }

            void locationFound(Location location)
            {
                sendBroadcast(LocationReceiver.getIntent(getPackageName(), location));
                logLocationUpdate(location);
            }

            
            {
                this$0 = VenueProximityService.this;
                super(locationmanager);
            }
        };
        LogUtils.logD(LOG_TAG, (new StringBuilder()).append("Searching for location from ").append(getApplicationContext().getPackageCodePath()).append("...").toString());
        mProviderHelper.open();
    }

    protected LocationManager getLocationManager()
    {
        return (LocationManager)getSystemService("location");
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        isRunning = true;
        HandlerThread handlerthread = new HandlerThread(LOG_TAG, 10);
        handlerthread.start();
        mServiceHandler = new ServiceHandler(handlerthread.getLooper());
    }

    public void onDestroy()
    {
        isRunning = false;
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        Message message = mServiceHandler.obtainMessage();
        message.arg1 = j;
        message.setData(bundleIntent(intent));
        mServiceHandler.sendMessage(message);
        return 1;
    }









}
