// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import aag;
import adi;
import android.app.Activity;
import android.os.Looper;
import zw;

// Referenced classes of package com.crashlytics.android.answers:
//            AnswersEventsHandler, SessionEvent, CustomEvent, PredefinedEvent

class SessionAnalyticsManager
{

    static final String ON_CRASH_ERROR_MSG = "onCrash called from main thread!!!";
    final AnswersEventsHandler eventsHandler;

    public SessionAnalyticsManager(AnswersEventsHandler answerseventshandler)
    {
        eventsHandler = answerseventshandler;
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
            zw.h().a("Answers", "Logged crash");
            eventsHandler.processEventSync(SessionEvent.crashEventBuilder(s));
            return;
        }
    }

    public void onCustom(CustomEvent customevent)
    {
        zw.h().a("Answers", (new StringBuilder()).append("Logged custom event: ").append(customevent).toString());
        eventsHandler.processEventAsync(SessionEvent.customEventBuilder(customevent));
    }

    public void onError(String s)
    {
        zw.h().a("Answers", "Logged error");
        eventsHandler.processEventAsync(SessionEvent.errorEventBuilder(s));
    }

    public void onInstall()
    {
        zw.h().a("Answers", "Logged install");
        eventsHandler.processEventAsyncAndFlush(SessionEvent.installEventBuilder());
    }

    public void onLifecycle(Activity activity, SessionEvent.Type type)
    {
        zw.h().a("Answers", (new StringBuilder()).append("Logged lifecycle event: ").append(type.name()).toString());
        eventsHandler.processEventAsync(SessionEvent.lifecycleEventBuilder(type, activity));
    }

    public void onPredefined(PredefinedEvent predefinedevent)
    {
        zw.h().a("Answers", (new StringBuilder()).append("Logged predefined event: ").append(predefinedevent).toString());
        eventsHandler.processEventAsync(SessionEvent.predefinedEventBuilder(predefinedevent));
    }

    public void setAnalyticsSettingsData(adi adi, String s)
    {
        eventsHandler.setAnalyticsSettingsData(adi, s);
    }
}
