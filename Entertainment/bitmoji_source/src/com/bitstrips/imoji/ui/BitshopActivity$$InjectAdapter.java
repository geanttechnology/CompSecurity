// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.services.BitshopGooglePlayService;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            BitshopActivity, IntentCreatorService

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding analytics;
    private Binding bitshopGooglePlayService;
    private Binding facebookService;
    private Binding intentCreatorService;
    private Binding templatesManager;

    public void attach(Linker linker)
    {
        facebookService = linker.requestBinding("com.bitstrips.imoji.auth.FacebookService", com/bitstrips/imoji/ui/BitshopActivity, getClass().getClassLoader());
        analytics = linker.requestBinding("com.bitstrips.imoji.analytics.AnalyticsService", com/bitstrips/imoji/ui/BitshopActivity, getClass().getClassLoader());
        intentCreatorService = linker.requestBinding("com.bitstrips.imoji.ui.IntentCreatorService", com/bitstrips/imoji/ui/BitshopActivity, getClass().getClassLoader());
        templatesManager = linker.requestBinding("com.bitstrips.imoji.manager.TemplatesManager", com/bitstrips/imoji/ui/BitshopActivity, getClass().getClassLoader());
        bitshopGooglePlayService = linker.requestBinding("com.bitstrips.imoji.services.BitshopGooglePlayService", com/bitstrips/imoji/ui/BitshopActivity, getClass().getClassLoader());
    }

    public BitshopActivity get()
    {
        BitshopActivity bitshopactivity = new BitshopActivity();
        injectMembers(bitshopactivity);
        return bitshopactivity;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(facebookService);
        set1.add(analytics);
        set1.add(intentCreatorService);
        set1.add(templatesManager);
        set1.add(bitshopGooglePlayService);
    }

    public void injectMembers(BitshopActivity bitshopactivity)
    {
        bitshopactivity.facebookService = (FacebookService)facebookService.get();
        bitshopactivity.analytics = (AnalyticsService)analytics.get();
        bitshopactivity.intentCreatorService = (IntentCreatorService)intentCreatorService.get();
        bitshopactivity.templatesManager = (TemplatesManager)templatesManager.get();
        bitshopactivity.bitshopGooglePlayService = (BitshopGooglePlayService)bitshopGooglePlayService.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((BitshopActivity)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.BitshopActivity", "members/com.bitstrips.imoji.ui.BitshopActivity", false, com/bitstrips/imoji/ui/BitshopActivity);
    }
}
