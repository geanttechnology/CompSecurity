// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionEventsHandler, EnabledSessionAnalyticsManagerStrategy, SessionEvent, SessionEventMetadata, 
//            SessionAnalyticsFilesManager

class SessionAnalyticsManager
{

    boolean customEventsEnabled;
    final SessionEventsHandler eventsHandler;
    final SessionEventMetadata metadata;

    SessionAnalyticsManager(SessionEventMetadata sessioneventmetadata, SessionEventsHandler sessioneventshandler)
    {
        customEventsEnabled = true;
        metadata = sessioneventmetadata;
        eventsHandler = sessioneventshandler;
    }

    public static SessionAnalyticsManager build(Context context, SessionEventMetadata sessioneventmetadata, SessionAnalyticsFilesManager sessionanalyticsfilesmanager, HttpRequestFactory httprequestfactory)
    {
        java.util.concurrent.ScheduledExecutorService scheduledexecutorservice = ExecutorUtils.buildSingleThreadScheduledExecutorService("Crashlytics SAM");
        return new SessionAnalyticsManager(sessioneventmetadata, new SessionEventsHandler(context, new EnabledSessionAnalyticsManagerStrategy(context, scheduledexecutorservice, sessionanalyticsfilesmanager, httprequestfactory), sessionanalyticsfilesmanager, scheduledexecutorservice));
    }

    public void disable()
    {
        eventsHandler.disable();
    }

    public void onCrash(String s)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new IllegalStateException("onCrash called from main thread!!!");
        } else
        {
            eventsHandler.recordEventSync(SessionEvent.buildCrashEvent(metadata, s));
            return;
        }
    }

    public void onCreate(Activity activity)
    {
        eventsHandler.recordEventAsync(SessionEvent.buildActivityLifecycleEvent(metadata, SessionEvent.Type.CREATE, activity), false);
    }

    public void onDestroy(Activity activity)
    {
        eventsHandler.recordEventAsync(SessionEvent.buildActivityLifecycleEvent(metadata, SessionEvent.Type.DESTROY, activity), false);
    }

    public void onInstall()
    {
        eventsHandler.recordEventAsync(SessionEvent.buildInstallEvent(metadata), true);
    }

    public void onPause(Activity activity)
    {
        eventsHandler.recordEventAsync(SessionEvent.buildActivityLifecycleEvent(metadata, SessionEvent.Type.PAUSE, activity), false);
    }

    public void onResume(Activity activity)
    {
        eventsHandler.recordEventAsync(SessionEvent.buildActivityLifecycleEvent(metadata, SessionEvent.Type.RESUME, activity), false);
    }

    public void onSaveInstanceState(Activity activity)
    {
        eventsHandler.recordEventAsync(SessionEvent.buildActivityLifecycleEvent(metadata, SessionEvent.Type.SAVE_INSTANCE_STATE, activity), false);
    }

    public void onStart(Activity activity)
    {
        eventsHandler.recordEventAsync(SessionEvent.buildActivityLifecycleEvent(metadata, SessionEvent.Type.START, activity), false);
    }

    public void onStop(Activity activity)
    {
        eventsHandler.recordEventAsync(SessionEvent.buildActivityLifecycleEvent(metadata, SessionEvent.Type.STOP, activity), false);
    }

    public void setAnalyticsSettingsData(AnalyticsSettingsData analyticssettingsdata, String s)
    {
        customEventsEnabled = analyticssettingsdata.trackCustomEvents;
        eventsHandler.setAnalyticsSettingsData(analyticssettingsdata, s);
    }
}
