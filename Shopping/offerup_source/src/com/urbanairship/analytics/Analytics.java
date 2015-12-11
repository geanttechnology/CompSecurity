// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.LifeCycleCallbacks;
import com.urbanairship.Logger;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import com.urbanairship.location.LocationRequestOptions;
import java.util.UUID;

// Referenced classes of package com.urbanairship.analytics:
//            ActivityMonitor, AnalyticsPreferences, EventDataManager, Event, 
//            EventService, AssociateIdentifiersEvent, LocationEvent, AssociatedIdentifiers

public class Analytics
{

    public static final String ACTION_APP_BACKGROUND = "com.urbanairship.analytics.APP_BACKGROUND";
    public static final String ACTION_APP_FOREGROUND = "com.urbanairship.analytics.APP_FOREGROUND";
    private static LifeCycleCallbacks lifeCycleCallbacks;
    private final ActivityMonitor activityMonitor;
    private final AirshipConfigOptions configOptions;
    private final Context context;
    private String conversionSendId;
    private final EventDataManager dataManager;
    private boolean inBackground;
    private final int minSdkVersion;
    private final AnalyticsPreferences preferences;
    private String sessionId;

    public Analytics(Context context1, PreferenceDataStore preferencedatastore, AirshipConfigOptions airshipconfigoptions)
    {
        this(context1, preferencedatastore, airshipconfigoptions, new ActivityMonitor(airshipconfigoptions.minSdkVersion, android.os.Build.VERSION.SDK_INT, airshipconfigoptions.analyticsEnabled));
    }

    Analytics(final Context context, PreferenceDataStore preferencedatastore, AirshipConfigOptions airshipconfigoptions, ActivityMonitor activitymonitor)
    {
        preferences = new AnalyticsPreferences(preferencedatastore);
        this.context = context.getApplicationContext();
        dataManager = new EventDataManager();
        minSdkVersion = airshipconfigoptions.minSdkVersion;
        inBackground = true;
        configOptions = airshipconfigoptions;
        startNewSession();
        activityMonitor = activitymonitor;
        activityMonitor.setListener(new _cls1());
    }

    public static void activityStarted(final Activity activity)
    {
        UAirship.shared(new _cls2());
    }

    public static void activityStopped(final Activity activity)
    {
        UAirship.shared(new _cls3());
    }

    public static void registerLifeCycleCallbacks(Application application)
    {
        if (lifeCycleCallbacks == null)
        {
            application = new _cls4(application);
            lifeCycleCallbacks = application;
            application.register();
        }
    }

    private void reportActivityStarted(Activity activity, int i, long l)
    {
        if (minSdkVersion >= 14 && configOptions.analyticsEnabled && i == 0)
        {
            Logger.warn("activityStarted call is no longer necessary starting with SDK 14 - ICE CREAM SANDWICH. Analytics is auto-instrumented for you.");
        }
        activityMonitor.activityStarted(activity, i, l);
    }

    private void reportActivityStopped(Activity activity, int i, long l)
    {
        if (minSdkVersion >= 14 && configOptions.analyticsEnabled && i == 0)
        {
            Logger.warn("activityStopped call is no longer necessary starting with SDK 14 - ICE CREAM SANDWICH. Analytics is auto-instrumented for you.");
        }
        activityMonitor.activityStopped(activity, i, l);
    }

    public static void unregisterLifeCycleCallbacks()
    {
        if (lifeCycleCallbacks != null)
        {
            lifeCycleCallbacks.unregister();
        }
    }

    public void addEvent(Event event)
    {
        if (event == null || !event.isValid())
        {
            Logger.warn((new StringBuilder("Analytics - Invalid event: ")).append(event).toString());
            return;
        }
        if (!isEnabled())
        {
            Logger.debug((new StringBuilder("Analytics disabled - ignoring event: ")).append(event.getType()).toString());
            return;
        }
        String s = event.createEventPayload(sessionId);
        if (s == null)
        {
            Logger.error((new StringBuilder("Analytics - Failed to add event ")).append(event.getType()).toString());
        }
        Intent intent = (new Intent(context, com/urbanairship/analytics/EventService)).setAction("com.urbanairship.analytics.ADD").putExtra("EXTRA_EVENT_TYPE", event.getType()).putExtra("EXTRA_EVENT_ID", event.getEventId()).putExtra("EXTRA_EVENT_DATA", s).putExtra("EXTRA_EVENT_TIME_STAMP", event.getTime()).putExtra("EXTRA_EVENT_SESSION_ID", sessionId);
        if (context.startService(intent) == null)
        {
            Logger.warn("Unable to start analytics service. Check that the event service is added to the manifest.");
            return;
        } else
        {
            Logger.debug((new StringBuilder("Analytics - Added event: ")).append(event.getType()).append(": ").append(s).toString());
            return;
        }
    }

    public void associateIdentifiers(AssociatedIdentifiers associatedidentifiers)
    {
        addEvent(new AssociateIdentifiersEvent(associatedidentifiers));
    }

    public String getConversionSendId()
    {
        return conversionSendId;
    }

    EventDataManager getDataManager()
    {
        return dataManager;
    }

    AnalyticsPreferences getPreferences()
    {
        return preferences;
    }

    String getSessionId()
    {
        return sessionId;
    }

    public boolean isAppInForeground()
    {
        return !inBackground;
    }

    public boolean isEnabled()
    {
        return configOptions.analyticsEnabled && preferences.isAnalyticsEnabled();
    }

    public void recordLocation(Location location)
    {
        recordLocation(location, null, LocationEvent.UpdateType.SINGLE);
    }

    public void recordLocation(Location location, LocationRequestOptions locationrequestoptions, LocationEvent.UpdateType updatetype)
    {
        byte byte0;
        int i;
        byte0 = 1;
        i = -1;
        if (locationrequestoptions != null) goto _L2; else goto _L1
_L1:
        byte0 = -1;
_L4:
        addEvent(new LocationEvent(location, updatetype, byte0, i, isAppInForeground()));
        return;
_L2:
        int j = (int)locationrequestoptions.getMinDistance();
        i = j;
        if (locationrequestoptions.getPriority() != 1)
        {
            byte0 = 2;
            i = j;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setConversionSendId(String s)
    {
        Logger.debug((new StringBuilder("Analytics - Setting conversion send ID: ")).append(s).toString());
        conversionSendId = s;
    }

    public void setEnabled(boolean flag)
    {
        if (preferences.isAnalyticsEnabled() && !flag)
        {
            Intent intent = (new Intent(context, com/urbanairship/analytics/EventService)).setAction("com.urbanairship.analytics.DELETE_ALL");
            context.startService(intent);
        }
        preferences.setAnalyticsEnabled(flag);
    }

    void startNewSession()
    {
        sessionId = UUID.randomUUID().toString();
        Logger.debug((new StringBuilder("Analytics - New session: ")).append(sessionId).toString());
    }


/*
    static boolean access$002(Analytics analytics, boolean flag)
    {
        analytics.inBackground = flag;
        return flag;
    }

*/



    private class _cls1 extends ActivityMonitor.Listener
    {

        final Analytics this$0;
        final Context val$context;

        public void onBackground(long l)
        {
            inBackground = true;
            addEvent(new AppBackgroundEvent(l));
            h.a(context).a(new Intent("com.urbanairship.analytics.APP_BACKGROUND"));
            setConversionSendId(null);
        }

        public void onForeground(long l)
        {
            startNewSession();
            inBackground = false;
            h.a(context).a(new Intent("com.urbanairship.analytics.APP_FOREGROUND"));
            addEvent(new AppForegroundEvent(l));
        }

        _cls1()
        {
            this$0 = Analytics.this;
            context = context1;
            super();
        }
    }


    private class _cls2
        implements com.urbanairship.UAirship.OnReadyCallback
    {

        final Activity val$activity;
        final long val$timeMS;

        public final void onAirshipReady(UAirship uairship)
        {
            uairship.getAnalytics().reportActivityStarted(activity, 0, timeMS);
        }

        _cls2()
        {
            activity = activity1;
            timeMS = l;
            super();
        }
    }


    private class _cls3
        implements com.urbanairship.UAirship.OnReadyCallback
    {

        final Activity val$activity;
        final long val$timeMS;

        public final void onAirshipReady(UAirship uairship)
        {
            uairship.getAnalytics().reportActivityStopped(activity, 0, timeMS);
        }

        _cls3()
        {
            activity = activity1;
            timeMS = l;
            super();
        }
    }


    private class _cls4 extends LifeCycleCallbacks
    {

        public final void onActivityStarted(final Activity activity)
        {
            class _cls1
                implements com.urbanairship.UAirship.OnReadyCallback
            {

                final _cls4 this$0;
                final Activity val$activity;
                final long val$timeStamp;

                public void onAirshipReady(UAirship uairship)
                {
                    uairship.getAnalytics().reportActivityStarted(activity, 1, timeStamp);
                }

                _cls1()
                {
                    this$0 = _cls4.this;
                    activity = activity1;
                    timeStamp = l;
                    super();
                }
            }

            UAirship.shared(new _cls1());
        }

        public final void onActivityStopped(final Activity activity)
        {
            class _cls2
                implements com.urbanairship.UAirship.OnReadyCallback
            {

                final _cls4 this$0;
                final Activity val$activity;
                final long val$timeStamp;

                public void onAirshipReady(UAirship uairship)
                {
                    uairship.getAnalytics().reportActivityStopped(activity, 1, timeStamp);
                }

                _cls2()
                {
                    this$0 = _cls4.this;
                    activity = activity1;
                    timeStamp = l;
                    super();
                }
            }

            UAirship.shared(new _cls2());
        }

        _cls4(Application application)
        {
            super(application);
        }
    }

}
