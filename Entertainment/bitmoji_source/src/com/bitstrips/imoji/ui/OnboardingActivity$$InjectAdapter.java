// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.analytics.AnalyticsService;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            OnboardingActivity

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding analyticsService;

    public void attach(Linker linker)
    {
        analyticsService = linker.requestBinding("com.bitstrips.imoji.analytics.AnalyticsService", com/bitstrips/imoji/ui/OnboardingActivity, getClass().getClassLoader());
    }

    public OnboardingActivity get()
    {
        OnboardingActivity onboardingactivity = new OnboardingActivity();
        injectMembers(onboardingactivity);
        return onboardingactivity;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(analyticsService);
    }

    public void injectMembers(OnboardingActivity onboardingactivity)
    {
        onboardingactivity.analyticsService = (AnalyticsService)analyticsService.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((OnboardingActivity)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.OnboardingActivity", "members/com.bitstrips.imoji.ui.OnboardingActivity", false, com/bitstrips/imoji/ui/OnboardingActivity);
    }
}
