// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.analytics;

import android.content.Context;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.analytics:
//            BitstripsAnalyticsService, BitstripsAnalyticsWebService

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding bitstripsAnalyticsWebService;
    private Binding context;
    private Binding preferenceUtils;

    public void attach(Linker linker)
    {
        bitstripsAnalyticsWebService = linker.requestBinding("com.bitstrips.imoji.analytics.BitstripsAnalyticsWebService", com/bitstrips/imoji/analytics/BitstripsAnalyticsService, getClass().getClassLoader());
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/analytics/BitstripsAnalyticsService, getClass().getClassLoader());
        context = linker.requestBinding("android.content.Context", com/bitstrips/imoji/analytics/BitstripsAnalyticsService, getClass().getClassLoader());
    }

    public BitstripsAnalyticsService get()
    {
        BitstripsAnalyticsService bitstripsanalyticsservice = new BitstripsAnalyticsService();
        injectMembers(bitstripsanalyticsservice);
        return bitstripsanalyticsservice;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(bitstripsAnalyticsWebService);
        set1.add(preferenceUtils);
        set1.add(context);
    }

    public void injectMembers(BitstripsAnalyticsService bitstripsanalyticsservice)
    {
        bitstripsanalyticsservice.bitstripsAnalyticsWebService = (BitstripsAnalyticsWebService)bitstripsAnalyticsWebService.get();
        bitstripsanalyticsservice.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
        bitstripsanalyticsservice.context = (Context)context.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((BitstripsAnalyticsService)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.analytics.BitstripsAnalyticsService", "members/com.bitstrips.imoji.analytics.BitstripsAnalyticsService", false, com/bitstrips/imoji/analytics/BitstripsAnalyticsService);
    }
}
