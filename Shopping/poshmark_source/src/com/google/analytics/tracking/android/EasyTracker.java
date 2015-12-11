// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.google.analytics.tracking.android:
//            Tracker, ParameterLoaderImpl, GoogleAnalytics, GAServiceManager, 
//            ParameterLoader, Log, Logger, ServiceManager, 
//            ExceptionReporter, GAUsage, Clock, TrackerHandler

public class EasyTracker extends Tracker
{
    private class NotInForegroundTimerTask extends TimerTask
    {

        final EasyTracker this$0;

        public void run()
        {
            mIsInForeground = false;
        }

        private NotInForegroundTimerTask()
        {
            this$0 = EasyTracker.this;
            super();
        }

    }


    private static final int DEFAULT_SAMPLE_RATE = 100;
    private static final String EASY_TRACKER_NAME = "easy_tracker";
    static final int NUM_MILLISECONDS_TO_WAIT_FOR_OPEN_ACTIVITY = 1000;
    private static EasyTracker sInstance;
    private static String sResourcePackageName;
    private int mActivitiesActive;
    private final Map mActivityNameMap;
    private Clock mClock = new Clock() {

        final EasyTracker this$0;

        public long currentTimeMillis()
        {
            return System.currentTimeMillis();
        }

            
            {
                this$0 = EasyTracker.this;
                super();
            }
    };
    private Context mContext;
    private final GoogleAnalytics mGoogleAnalytics;
    private boolean mIsAutoActivityTracking;
    private boolean mIsInForeground;
    private boolean mIsReportUncaughtExceptionsEnabled;
    private long mLastOnStopTime;
    private ParameterLoader mParameterFetcher;
    private ServiceManager mServiceManager;
    private long mSessionTimeout;
    private boolean mStartSessionOnNextSend;
    private Timer mTimer;
    private TimerTask mTimerTask;

    private EasyTracker(Context context)
    {
        this(context, ((ParameterLoader) (new ParameterLoaderImpl(context))), GoogleAnalytics.getInstance(context), ((ServiceManager) (GAServiceManager.getInstance())), null);
    }

    private EasyTracker(Context context, ParameterLoader parameterloader, GoogleAnalytics googleanalytics, ServiceManager servicemanager, TrackerHandler trackerhandler)
    {
        if (trackerhandler == null)
        {
            trackerhandler = googleanalytics;
        }
        super("easy_tracker", null, trackerhandler);
        mIsAutoActivityTracking = false;
        mActivitiesActive = 0;
        mActivityNameMap = new HashMap();
        mIsInForeground = false;
        mStartSessionOnNextSend = false;
        if (sResourcePackageName != null)
        {
            parameterloader.setResourcePackageName(sResourcePackageName);
        }
        mGoogleAnalytics = googleanalytics;
        setContext(context, parameterloader, servicemanager);
    }

    private void clearExistingTimer()
    {
        this;
        JVM INSTR monitorenter ;
        if (mTimer != null)
        {
            mTimer.cancel();
            mTimer = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private String getActivityName(Activity activity)
    {
        String s = activity.getClass().getCanonicalName();
        if (mActivityNameMap.containsKey(s))
        {
            return (String)mActivityNameMap.get(s);
        }
        String s1 = mParameterFetcher.getString(s);
        activity = s1;
        if (s1 == null)
        {
            activity = s;
        }
        mActivityNameMap.put(s, activity);
        return activity;
    }

    public static EasyTracker getInstance(Context context)
    {
        if (sInstance == null)
        {
            sInstance = new EasyTracker(context);
        }
        return sInstance;
    }

    private Logger.LogLevel getLogLevelFromString(String s)
    {
        try
        {
            s = Logger.LogLevel.valueOf(s.toUpperCase());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    static EasyTracker getNewInstance(Context context, ParameterLoader parameterloader, GoogleAnalytics googleanalytics, ServiceManager servicemanager, TrackerHandler trackerhandler)
    {
        sInstance = new EasyTracker(context, parameterloader, googleanalytics, servicemanager, trackerhandler);
        return sInstance;
    }

    private void loadParameters()
    {
        Log.v("Starting EasyTracker.");
        Object obj1 = mParameterFetcher.getString("ga_trackingId");
        Object obj = obj1;
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            obj = mParameterFetcher.getString("ga_api_key");
        }
        set("&tid", ((String) (obj)));
        Log.v((new StringBuilder()).append("[EasyTracker] trackingId loaded: ").append(((String) (obj))).toString());
        obj = mParameterFetcher.getString("ga_appName");
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            Log.v((new StringBuilder()).append("[EasyTracker] app name loaded: ").append(((String) (obj))).toString());
            set("&an", ((String) (obj)));
        }
        obj = mParameterFetcher.getString("ga_appVersion");
        if (obj != null)
        {
            Log.v((new StringBuilder()).append("[EasyTracker] app version loaded: ").append(((String) (obj))).toString());
            set("&av", ((String) (obj)));
        }
        obj = mParameterFetcher.getString("ga_logLevel");
        if (obj != null)
        {
            obj = getLogLevelFromString(((String) (obj)));
            if (obj != null)
            {
                Log.v((new StringBuilder()).append("[EasyTracker] log level loaded: ").append(obj).toString());
                mGoogleAnalytics.getLogger().setLogLevel(((Logger.LogLevel) (obj)));
            }
        }
        obj1 = mParameterFetcher.getDoubleFromString("ga_sampleFrequency");
        obj = obj1;
        if (obj1 == null)
        {
            obj = new Double(mParameterFetcher.getInt("ga_sampleRate", 100));
        }
        if (((Double) (obj)).doubleValue() != 100D)
        {
            set("&sf", Double.toString(((Double) (obj)).doubleValue()));
        }
        Log.v((new StringBuilder()).append("[EasyTracker] sample rate loaded: ").append(obj).toString());
        int i = mParameterFetcher.getInt("ga_dispatchPeriod", 1800);
        Log.v((new StringBuilder()).append("[EasyTracker] dispatch period loaded: ").append(i).toString());
        mServiceManager.setLocalDispatchPeriod(i);
        mSessionTimeout = mParameterFetcher.getInt("ga_sessionTimeout", 30) * 1000;
        Log.v((new StringBuilder()).append("[EasyTracker] session timeout loaded: ").append(mSessionTimeout).toString());
        boolean flag;
        if (mParameterFetcher.getBoolean("ga_autoActivityTracking") || mParameterFetcher.getBoolean("ga_auto_activity_tracking"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsAutoActivityTracking = flag;
        Log.v((new StringBuilder()).append("[EasyTracker] auto activity tracking loaded: ").append(mIsAutoActivityTracking).toString());
        flag = mParameterFetcher.getBoolean("ga_anonymizeIp");
        if (flag)
        {
            set("&aip", "1");
            Log.v((new StringBuilder()).append("[EasyTracker] anonymize ip loaded: ").append(flag).toString());
        }
        mIsReportUncaughtExceptionsEnabled = mParameterFetcher.getBoolean("ga_reportUncaughtExceptions");
        if (mIsReportUncaughtExceptionsEnabled)
        {
            Thread.setDefaultUncaughtExceptionHandler(new ExceptionReporter(this, mServiceManager, Thread.getDefaultUncaughtExceptionHandler(), mContext));
            Log.v((new StringBuilder()).append("[EasyTracker] report uncaught exceptions loaded: ").append(mIsReportUncaughtExceptionsEnabled).toString());
        }
        flag = mParameterFetcher.getBoolean("ga_dryRun");
        mGoogleAnalytics.setDryRun(flag);
    }

    private void setContext(Context context, ParameterLoader parameterloader, ServiceManager servicemanager)
    {
        if (context == null)
        {
            Log.e("Context cannot be null");
        }
        mContext = context.getApplicationContext();
        mServiceManager = servicemanager;
        mParameterFetcher = parameterloader;
        loadParameters();
    }

    public static void setResourcePackageName(String s)
    {
        sResourcePackageName = s;
    }

    public void activityStart(Activity activity)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.EASY_TRACKER_ACTIVITY_START);
        clearExistingTimer();
        if (!mIsInForeground && mActivitiesActive == 0 && checkForNewSession())
        {
            mStartSessionOnNextSend = true;
        }
        mIsInForeground = true;
        mActivitiesActive = mActivitiesActive + 1;
        if (mIsAutoActivityTracking)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("&t", "appview");
            GAUsage.getInstance().setDisableUsage(true);
            set("&cd", getActivityName(activity));
            send(hashmap);
            GAUsage.getInstance().setDisableUsage(false);
        }
    }

    public void activityStop(Activity activity)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.EASY_TRACKER_ACTIVITY_STOP);
        mActivitiesActive = mActivitiesActive - 1;
        mActivitiesActive = Math.max(0, mActivitiesActive);
        mLastOnStopTime = mClock.currentTimeMillis();
        if (mActivitiesActive == 0)
        {
            clearExistingTimer();
            mTimerTask = new NotInForegroundTimerTask();
            mTimer = new Timer("waitForActivityStart");
            mTimer.schedule(mTimerTask, 1000L);
        }
    }

    boolean checkForNewSession()
    {
        return mSessionTimeout == 0L || mSessionTimeout > 0L && mClock.currentTimeMillis() > mLastOnStopTime + mSessionTimeout;
    }

    public void dispatchLocalHits()
    {
        mServiceManager.dispatchLocalHits();
    }

    int getActivitiesActive()
    {
        return mActivitiesActive;
    }

    void overrideUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        if (mIsReportUncaughtExceptionsEnabled)
        {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtexceptionhandler);
        }
    }

    public void send(Map map)
    {
        if (mStartSessionOnNextSend)
        {
            map.put("&sc", "start");
            mStartSessionOnNextSend = false;
        }
        super.send(map);
    }

    void setClock(Clock clock)
    {
        mClock = clock;
    }


/*
    static boolean access$102(EasyTracker easytracker, boolean flag)
    {
        easytracker.mIsInForeground = flag;
        return flag;
    }

*/
}
