// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.manager.RecentImojiesManager;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.bitstrips.imoji.ui:
//            BaseShareDialogFragment, ResolveInfosSorter, IntentCreatorService

public final class  extends Binding
    implements MembersInjector
{

    private Binding analytics;
    private Binding intentCreatorService;
    private Binding preferenceUtils;
    private Binding recentImojiesManager;
    private Binding resolveInfosSorter;

    public void attach(Linker linker)
    {
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/ui/BaseShareDialogFragment, getClass().getClassLoader());
        resolveInfosSorter = linker.requestBinding("com.bitstrips.imoji.ui.ResolveInfosSorter", com/bitstrips/imoji/ui/BaseShareDialogFragment, getClass().getClassLoader());
        recentImojiesManager = linker.requestBinding("com.bitstrips.imoji.manager.RecentImojiesManager", com/bitstrips/imoji/ui/BaseShareDialogFragment, getClass().getClassLoader());
        intentCreatorService = linker.requestBinding("com.bitstrips.imoji.ui.IntentCreatorService", com/bitstrips/imoji/ui/BaseShareDialogFragment, getClass().getClassLoader());
        analytics = linker.requestBinding("com.bitstrips.imoji.analytics.AnalyticsService", com/bitstrips/imoji/ui/BaseShareDialogFragment, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(preferenceUtils);
        set1.add(resolveInfosSorter);
        set1.add(recentImojiesManager);
        set1.add(intentCreatorService);
        set1.add(analytics);
    }

    public void injectMembers(BaseShareDialogFragment basesharedialogfragment)
    {
        basesharedialogfragment.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
        basesharedialogfragment.resolveInfosSorter = (ResolveInfosSorter)resolveInfosSorter.get();
        basesharedialogfragment.recentImojiesManager = (RecentImojiesManager)recentImojiesManager.get();
        basesharedialogfragment.intentCreatorService = (IntentCreatorService)intentCreatorService.get();
        basesharedialogfragment.analytics = (AnalyticsService)analytics.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((BaseShareDialogFragment)obj);
    }

    public ()
    {
        super(null, "members/com.bitstrips.imoji.ui.BaseShareDialogFragment", false, com/bitstrips/imoji/ui/BaseShareDialogFragment);
    }
}
