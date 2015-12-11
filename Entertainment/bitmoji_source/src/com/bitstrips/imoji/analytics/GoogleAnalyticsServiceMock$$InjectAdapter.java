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
//            GoogleAnalyticsServiceMock

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding field_preferenceUtils;
    private Binding parameter_context;
    private Binding parameter_tracker;
    private Binding supertype;

    public void attach(Linker linker)
    {
        parameter_tracker = linker.requestBinding("com.google.android.gms.analytics.Tracker", com/bitstrips/imoji/analytics/GoogleAnalyticsServiceMock, getClass().getClassLoader());
        parameter_context = linker.requestBinding("android.content.Context", com/bitstrips/imoji/analytics/GoogleAnalyticsServiceMock, getClass().getClassLoader());
        field_preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/analytics/GoogleAnalyticsServiceMock, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.bitstrips.imoji.analytics.GoogleAnalyticsService", com/bitstrips/imoji/analytics/GoogleAnalyticsServiceMock, getClass().getClassLoader(), false, true);
    }

    public GoogleAnalyticsServiceMock get()
    {
        GoogleAnalyticsServiceMock googleanalyticsservicemock = new GoogleAnalyticsServiceMock((Tracker)parameter_tracker.get(), (Context)parameter_context.get());
        injectMembers(googleanalyticsservicemock);
        return googleanalyticsservicemock;
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
        set1.add(supertype);
    }

    public void injectMembers(GoogleAnalyticsServiceMock googleanalyticsservicemock)
    {
        googleanalyticsservicemock.preferenceUtils = (PreferenceUtils)field_preferenceUtils.get();
        supertype.injectMembers(googleanalyticsservicemock);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((GoogleAnalyticsServiceMock)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.analytics.GoogleAnalyticsServiceMock", "members/com.bitstrips.imoji.analytics.GoogleAnalyticsServiceMock", false, com/bitstrips/imoji/analytics/GoogleAnalyticsServiceMock);
    }
}
