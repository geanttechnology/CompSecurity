// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.fragments;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.shazam.android.al.c;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.orientation.EventOrientationProvider;
import com.shazam.android.analytics.session.SessionCancellationPolicy;
import com.shazam.android.analytics.session.SessionManager;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.analytics.session.page.PageConfiguration;
import com.shazam.android.analytics.session.page.PageRetriever;
import com.shazam.android.k.f.i;
import com.shazam.android.k.f.j;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.n.m;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DefaultSessionManager
    implements SessionManager
{

    private final EventAnalytics eventAnalytics;
    private final EventOrientationProvider eventOrientationProvider;
    private final j launchingExtrasSerializer;
    private String orientation;
    private Page page;
    private final PageConfiguration pageConfiguration;
    private final PageRetriever pageRetriever;
    private final SessionCancellationPolicy sessionCancellationPolicy;
    private Long startTime;
    private final m timeProvider;

    public DefaultSessionManager(PageRetriever pageretriever, SessionCancellationPolicy sessioncancellationpolicy, EventAnalytics eventanalytics, EventOrientationProvider eventorientationprovider, m m1, j j1, PageConfiguration pageconfiguration)
    {
        pageRetriever = pageretriever;
        sessionCancellationPolicy = sessioncancellationpolicy;
        eventAnalytics = eventanalytics;
        eventOrientationProvider = eventorientationprovider;
        timeProvider = m1;
        launchingExtrasSerializer = j1;
        pageConfiguration = pageconfiguration;
    }

    private void clearSession()
    {
        startTime = null;
    }

    private Activity getActivity(Object obj)
    {
        Object obj1 = null;
        if (obj instanceof Activity)
        {
            obj1 = (Activity)obj;
        }
        if (obj instanceof Fragment)
        {
            obj1 = ((Fragment)obj).getActivity();
        }
        if (obj instanceof android.app.Fragment)
        {
            obj1 = ((android.app.Fragment)obj).getActivity();
        }
        return ((Activity) (obj1));
    }

    private Intent getIntentFrom(Object obj)
    {
        return getIntentFromActivity(getActivity(obj));
    }

    private Intent getIntentFromActivity(Activity activity)
    {
        if (activity == null || activity.getIntent() == null)
        {
            return null;
        } else
        {
            return activity.getIntent();
        }
    }

    private void sendAnalyticsEvent(Object obj, Long long1)
    {
        String s = null;
        pageConfiguration.configureIfAppropriate(obj, page);
        Intent intent = getIntentFrom(obj);
        Object obj1;
        Object obj2;
        String s1;
        boolean flag;
        if (intent != null)
        {
            obj1 = j.a(intent);
            c c1 = ((i) (obj1)).b();
            obj2 = c1.c;
            s = c1.b;
            flag = c1.a;
        } else
        {
            obj1 = null;
            flag = false;
            obj2 = null;
        }
        s1 = page.getPageName();
        long1 = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, s1).putNotEmptyOrNullParameter(DefinedEventParameterKey.ORIENTATION, orientation).putNotEmptyOrNullParameter(DefinedEventParameterKey.N_TYPE, ((String) (obj2))).putNotEmptyOrNullParameter(DefinedEventParameterKey.N_ANNOUNCEMENT, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.TIME_SPENT, String.valueOf(long1.longValue() - startTime.longValue()));
        for (Iterator iterator = page.getAdditionalEventParameters().entrySet().iterator(); iterator.hasNext(); long1.putNotEmptyOrNullParameter(com.shazam.android.analytics.event.StringEventParameterKey.Builder.stringEventParameterKey().withParameterKey((String)((java.util.Map.Entry) (obj2)).getKey()).build(), (String)((java.util.Map.Entry) (obj2)).getValue()))
        {
            obj2 = (java.util.Map.Entry)iterator.next();
        }

        if (flag)
        {
            long1.putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_ORIGIN, ScreenOrigin.NOTIFICATION.value);
            obj1 = com.shazam.android.k.f.i.a.a(((i) (obj1)));
            obj1.c = (new com.shazam.android.al.c.a()).a();
            j.a(((com.shazam.android.k.f.i.a) (obj1)).a(), intent);
            setIntentToActivity(intent, obj);
        }
        obj = long1.build();
        obj = com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.PAGE_VIEW).withParameters(((com.shazam.android.analytics.event.EventParameters) (obj))).build();
        eventAnalytics.logEvent(((com.shazam.android.analytics.event.Event) (obj)));
        clearSession();
    }

    private void setIntentToActivity(Intent intent, Object obj)
    {
        obj = getActivity(obj);
        if (obj != null)
        {
            ((Activity) (obj)).setIntent(intent);
        }
    }

    public boolean isSessionActive()
    {
        return startTime != null;
    }

    public void startSession(Object obj)
    {
        startTime = Long.valueOf(timeProvider.b());
        page = pageRetriever.retrievePageFrom(obj);
        pageConfiguration.configureIfAppropriate(obj, page);
        orientation = eventOrientationProvider.getOrientation();
    }

    public void stopSession(Object obj)
    {
        if (isSessionActive() && !sessionCancellationPolicy.isSessionCanceled(obj))
        {
            sendAnalyticsEvent(obj, Long.valueOf(timeProvider.b()));
        }
    }
}
