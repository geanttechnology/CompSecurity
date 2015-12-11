// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.manager.FloaterServiceManager;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            SettingsActivity

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding analytics;
    private Binding facebookService;
    private Binding floaterServiceManager;
    private Binding preferenceUtils;

    public void attach(Linker linker)
    {
        analytics = linker.requestBinding("com.bitstrips.imoji.analytics.AnalyticsService", com/bitstrips/imoji/ui/SettingsActivity, getClass().getClassLoader());
        floaterServiceManager = linker.requestBinding("com.bitstrips.imoji.manager.FloaterServiceManager", com/bitstrips/imoji/ui/SettingsActivity, getClass().getClassLoader());
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/ui/SettingsActivity, getClass().getClassLoader());
        facebookService = linker.requestBinding("com.bitstrips.imoji.auth.FacebookService", com/bitstrips/imoji/ui/SettingsActivity, getClass().getClassLoader());
    }

    public SettingsActivity get()
    {
        SettingsActivity settingsactivity = new SettingsActivity();
        injectMembers(settingsactivity);
        return settingsactivity;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(analytics);
        set1.add(floaterServiceManager);
        set1.add(preferenceUtils);
        set1.add(facebookService);
    }

    public void injectMembers(SettingsActivity settingsactivity)
    {
        settingsactivity.analytics = (AnalyticsService)analytics.get();
        settingsactivity.floaterServiceManager = (FloaterServiceManager)floaterServiceManager.get();
        settingsactivity.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
        settingsactivity.facebookService = (FacebookService)facebookService.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((SettingsActivity)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.SettingsActivity", "members/com.bitstrips.imoji.ui.SettingsActivity", false, com/bitstrips/imoji/ui/SettingsActivity);
    }
}
