// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.fragments.analytics;

import android.support.v4.app.Fragment;
import com.shazam.android.analytics.session.exception.SessionInitializationException;
import com.shazam.android.analytics.session.fragments.strategy.ConfigurableSessionStrategyType;
import com.shazam.android.analytics.session.fragments.strategy.DefaultFragmentSessionStrategyFactory;
import com.shazam.android.analytics.session.fragments.strategy.FragmentSessionStrategy;
import com.shazam.android.analytics.session.fragments.strategy.FragmentSessionStrategyFactory;
import com.shazam.android.annotation.analytics.WithPageView;
import com.shazam.android.aspects.c.b.b;
import com.shazam.android.aspects.fragments.ShazamCustomFragmentAspect;

public class FragmentSessionAspect extends ShazamCustomFragmentAspect
{

    private FragmentSessionStrategy sessionStrategy;
    private final FragmentSessionStrategyFactory strategyFactory;

    public FragmentSessionAspect()
    {
        this(((FragmentSessionStrategyFactory) (new DefaultFragmentSessionStrategyFactory())));
    }

    public FragmentSessionAspect(FragmentSessionStrategyFactory fragmentsessionstrategyfactory)
    {
        strategyFactory = fragmentsessionstrategyfactory;
    }

    private void lazyLoadSessionStrategyFrom(Fragment fragment)
    {
        if (sessionStrategy != null)
        {
            return;
        }
        Object obj = (WithPageView)fragment.getClass().getAnnotation(com/shazam/android/annotation/analytics/WithPageView);
        if (obj == null)
        {
            obj = new StringBuilder();
            ((StringBuilder) (obj)).append("Could not initialize Session for fragment ").append(fragment.getClass().toString()).append(". ").append(com/shazam/android/aspects/fragments/analytics/FragmentSessionAspect.toString()).append(" should not be directly applied to the object. Instead, use ").append(com/shazam/android/annotation/analytics/WithPageView.toString());
            throw new SessionInitializationException(((StringBuilder) (obj)).toString());
        }
        obj = ((WithPageView) (obj)).lifeCycle();
        if (fragment instanceof ConfigurableSessionStrategyType)
        {
            obj = ((ConfigurableSessionStrategyType)fragment).configurableSessionStrategyType();
        }
        sessionStrategy = strategyFactory.createSessionStrategy(((com.shazam.android.analytics.session.SessionStrategyType) (obj)));
    }

    public void onPause(b b)
    {
        lazyLoadSessionStrategyFrom(b);
        sessionStrategy.onPause(b);
    }

    public void onResume(b b)
    {
        lazyLoadSessionStrategyFrom(b);
        sessionStrategy.onResume(b);
    }

    public void onSelected(b b)
    {
        lazyLoadSessionStrategyFrom(b);
        sessionStrategy.onSelected(b);
    }

    public void onStart(b b)
    {
        lazyLoadSessionStrategyFrom(b);
        sessionStrategy.onStart(b);
    }

    public void onStop(b b)
    {
        lazyLoadSessionStrategyFrom(b);
        sessionStrategy.onStop(b);
    }

    public void onUnselected(b b)
    {
        lazyLoadSessionStrategyFrom(b);
        sessionStrategy.onUnselected(b);
    }

    public void onWindowFocused(b b)
    {
        lazyLoadSessionStrategyFrom(b);
        sessionStrategy.onWindowFocused(b);
    }

    public void onWindowUnfocused(b b)
    {
        lazyLoadSessionStrategyFrom(b);
        sessionStrategy.onWindowUnfocused(b);
    }
}
