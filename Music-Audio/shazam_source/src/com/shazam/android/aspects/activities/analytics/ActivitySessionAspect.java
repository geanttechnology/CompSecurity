// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities.analytics;

import android.app.Activity;
import com.shazam.android.analytics.session.activity.strategy.ActivitySessionStrategy;
import com.shazam.android.analytics.session.activity.strategy.ActivitySessionStrategyFactory;
import com.shazam.android.analytics.session.activity.strategy.DefaultActivitySessionStrategyFactory;
import com.shazam.android.analytics.session.exception.SessionInitializationException;
import com.shazam.android.annotation.analytics.WithPageView;
import com.shazam.android.aspects.b.a.b;
import com.shazam.android.aspects.c.a.a;

public class ActivitySessionAspect extends b
{

    private ActivitySessionStrategy sessionStrategy;
    private final ActivitySessionStrategyFactory strategyFactory;

    public ActivitySessionAspect()
    {
        this(((ActivitySessionStrategyFactory) (new DefaultActivitySessionStrategyFactory())));
    }

    public ActivitySessionAspect(ActivitySessionStrategyFactory activitysessionstrategyfactory)
    {
        strategyFactory = activitysessionstrategyfactory;
    }

    private void lazyLoadSessionStrategyFrom(Activity activity)
    {
        if (sessionStrategy != null)
        {
            return;
        }
        Object obj = (WithPageView)activity.getClass().getAnnotation(com/shazam/android/annotation/analytics/WithPageView);
        if (obj == null)
        {
            obj = new StringBuilder();
            ((StringBuilder) (obj)).append("Could not initialize Session for activity ").append(activity.getClass().toString()).append(". ").append(com/shazam/android/aspects/activities/analytics/ActivitySessionAspect.toString()).append(" should not be directly applied to the object. Instead, use ").append(com/shazam/android/annotation/analytics/WithPageView.toString());
            throw new SessionInitializationException(((StringBuilder) (obj)).toString());
        } else
        {
            sessionStrategy = strategyFactory.createSessionStrategy(((WithPageView) (obj)).lifeCycle());
            return;
        }
    }

    public void onPause(a a)
    {
        lazyLoadSessionStrategyFrom(a);
        sessionStrategy.onPause(a);
    }

    public void onResume(a a)
    {
        lazyLoadSessionStrategyFrom(a);
        sessionStrategy.onResume(a);
    }

    public void onStart(a a)
    {
        lazyLoadSessionStrategyFrom(a);
        sessionStrategy.onStart(a);
    }

    public void onStop(a a)
    {
        lazyLoadSessionStrategyFrom(a);
        sessionStrategy.onStop(a);
    }

    public void onWindowFocusChanged(a a, boolean flag)
    {
        lazyLoadSessionStrategyFrom(a);
        if (flag)
        {
            sessionStrategy.onWindowFocused(a);
            return;
        } else
        {
            sessionStrategy.onWindowUnfocused(a);
            return;
        }
    }
}
