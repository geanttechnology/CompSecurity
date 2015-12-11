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
import com.shazam.android.aspects.b.b.a;

public class DialogFragmentSessionAspect extends a
{

    private FragmentSessionStrategy sessionStrategy;
    private final FragmentSessionStrategyFactory strategyFactory;

    public DialogFragmentSessionAspect()
    {
        this(((FragmentSessionStrategyFactory) (new DefaultFragmentSessionStrategyFactory())));
    }

    public DialogFragmentSessionAspect(FragmentSessionStrategyFactory fragmentsessionstrategyfactory)
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
            ((StringBuilder) (obj)).append("Could not initialize Session for fragment ").append(fragment.getClass().toString()).append(". ").append(com/shazam/android/aspects/fragments/analytics/DialogFragmentSessionAspect.toString()).append(" should not be directly applied to the object. Instead, use ").append(com/shazam/android/annotation/analytics/WithPageView.toString());
            throw new SessionInitializationException(((StringBuilder) (obj)).toString());
        }
        obj = ((WithPageView) (obj)).lifeCycle();
        if (fragment instanceof ConfigurableSessionStrategyType)
        {
            obj = ((ConfigurableSessionStrategyType)fragment).configurableSessionStrategyType();
        }
        sessionStrategy = strategyFactory.createSessionStrategy(((com.shazam.android.analytics.session.SessionStrategyType) (obj)));
    }

    public void onPause(com.shazam.android.aspects.c.b.a a1)
    {
        lazyLoadSessionStrategyFrom(a1);
        sessionStrategy.onPause(a1);
    }

    public void onResume(com.shazam.android.aspects.c.b.a a1)
    {
        lazyLoadSessionStrategyFrom(a1);
        sessionStrategy.onResume(a1);
    }

    public void onStart(com.shazam.android.aspects.c.b.a a1)
    {
        lazyLoadSessionStrategyFrom(a1);
        sessionStrategy.onStart(a1);
    }

    public void onStop(com.shazam.android.aspects.c.b.a a1)
    {
        lazyLoadSessionStrategyFrom(a1);
        sessionStrategy.onStop(a1);
    }
}
