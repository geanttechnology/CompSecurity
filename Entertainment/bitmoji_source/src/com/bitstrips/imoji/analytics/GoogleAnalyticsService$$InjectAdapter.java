// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.analytics;

import android.content.Context;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.google.android.gms.analytics.Tracker;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.analytics:
//            GoogleAnalyticsService

public final class I extends Binding
    implements Provider, MembersInjector
{

    private Binding field_preferenceUtils;
    private Binding parameter_context;
    private Binding parameter_tracker;

    public void attach(Linker linker)
    {
        parameter_tracker = linker.requestBinding("com.google.android.gms.analytics.Tracker", com/bitstrips/imoji/analytics/GoogleAnalyticsService, getClass().getClassLoader());
        parameter_context = linker.requestBinding("android.content.Context", com/bitstrips/imoji/analytics/GoogleAnalyticsService, getClass().getClassLoader());
        field_preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/analytics/GoogleAnalyticsService, getClass().getClassLoader());
    }

    public GoogleAnalyticsService get()
    {
        GoogleAnalyticsService googleanalyticsservice = new GoogleAnalyticsService((Tracker)parameter_tracker.get(), (Context)parameter_context.get());
        injectMembers(googleanalyticsservice);
        return googleanalyticsservice;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(parameter_tracker);
        set.add(parameter_context);
        set1.add(field_preferenceUtils);
    }

    public void injectMembers(GoogleAnalyticsService googleanalyticsservice)
    {
        googleanalyticsservice.preferenceUtils = (PreferenceUtils)field_preferenceUtils.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((GoogleAnalyticsService)obj);
    }

    public I()
    {
        super("com.bitstrips.imoji.analytics.GoogleAnalyticsService", "members/com.bitstrips.imoji.analytics.GoogleAnalyticsService", false, com/bitstrips/imoji/analytics/GoogleAnalyticsService);
    }
}
