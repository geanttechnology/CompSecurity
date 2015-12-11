// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.analytics;

import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.analytics:
//            GoogleAndBitstripsAnalyticsService, GoogleAnalyticsService, BitstripsAnalyticsService

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding bitstripsAnalyticsService;
    private Binding googleAnalyticsService;

    public void attach(Linker linker)
    {
        googleAnalyticsService = linker.requestBinding("com.bitstrips.imoji.analytics.GoogleAnalyticsService", com/bitstrips/imoji/analytics/GoogleAndBitstripsAnalyticsService, getClass().getClassLoader());
        bitstripsAnalyticsService = linker.requestBinding("com.bitstrips.imoji.analytics.BitstripsAnalyticsService", com/bitstrips/imoji/analytics/GoogleAndBitstripsAnalyticsService, getClass().getClassLoader());
    }

    public GoogleAndBitstripsAnalyticsService get()
    {
        GoogleAndBitstripsAnalyticsService googleandbitstripsanalyticsservice = new GoogleAndBitstripsAnalyticsService();
        injectMembers(googleandbitstripsanalyticsservice);
        return googleandbitstripsanalyticsservice;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(googleAnalyticsService);
        set1.add(bitstripsAnalyticsService);
    }

    public void injectMembers(GoogleAndBitstripsAnalyticsService googleandbitstripsanalyticsservice)
    {
        googleandbitstripsanalyticsservice.googleAnalyticsService = (GoogleAnalyticsService)googleAnalyticsService.get();
        googleandbitstripsanalyticsservice.bitstripsAnalyticsService = (BitstripsAnalyticsService)bitstripsAnalyticsService.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((GoogleAndBitstripsAnalyticsService)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.analytics.GoogleAndBitstripsAnalyticsService", "members/com.bitstrips.imoji.analytics.GoogleAndBitstripsAnalyticsService", false, com/bitstrips/imoji/analytics/GoogleAndBitstripsAnalyticsService);
    }
}
