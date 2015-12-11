// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.bitstrips.imoji.services:
//            BitshopGooglePlayService

public final class  extends Binding
    implements MembersInjector
{

    private Binding analytics;
    private Binding bitstripsService;
    private Binding facebookService;
    private Binding preferenceUtils;
    private Binding templatesManager;

    public void attach(Linker linker)
    {
        templatesManager = linker.requestBinding("com.bitstrips.imoji.manager.TemplatesManager", com/bitstrips/imoji/services/BitshopGooglePlayService, getClass().getClassLoader());
        bitstripsService = linker.requestBinding("com.bitstrips.imoji.api.BitstripsService", com/bitstrips/imoji/services/BitshopGooglePlayService, getClass().getClassLoader());
        facebookService = linker.requestBinding("com.bitstrips.imoji.auth.FacebookService", com/bitstrips/imoji/services/BitshopGooglePlayService, getClass().getClassLoader());
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/services/BitshopGooglePlayService, getClass().getClassLoader());
        analytics = linker.requestBinding("com.bitstrips.imoji.analytics.AnalyticsService", com/bitstrips/imoji/services/BitshopGooglePlayService, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(templatesManager);
        set1.add(bitstripsService);
        set1.add(facebookService);
        set1.add(preferenceUtils);
        set1.add(analytics);
    }

    public void injectMembers(BitshopGooglePlayService bitshopgoogleplayservice)
    {
        bitshopgoogleplayservice.templatesManager = (TemplatesManager)templatesManager.get();
        bitshopgoogleplayservice.bitstripsService = (BitstripsService)bitstripsService.get();
        bitshopgoogleplayservice.facebookService = (FacebookService)facebookService.get();
        bitshopgoogleplayservice.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
        bitshopgoogleplayservice.analytics = (AnalyticsService)analytics.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((BitshopGooglePlayService)obj);
    }

    public ()
    {
        super(null, "members/com.bitstrips.imoji.services.BitshopGooglePlayService", false, com/bitstrips/imoji/services/BitshopGooglePlayService);
    }
}
