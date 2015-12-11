// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.FloaterGoogleAnalyticsService;
import com.squareup.picasso.Picasso;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.services:
//            FloaterService, PackageService

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding analytics;
    private Binding floaterAnalyticsService;
    private Binding packageService;
    private Binding picasso;

    public void attach(Linker linker)
    {
        analytics = linker.requestBinding("com.bitstrips.imoji.analytics.AnalyticsService", com/bitstrips/imoji/services/FloaterService, getClass().getClassLoader());
        picasso = linker.requestBinding("com.squareup.picasso.Picasso", com/bitstrips/imoji/services/FloaterService, getClass().getClassLoader());
        floaterAnalyticsService = linker.requestBinding("com.bitstrips.imoji.analytics.FloaterGoogleAnalyticsService", com/bitstrips/imoji/services/FloaterService, getClass().getClassLoader());
        packageService = linker.requestBinding("com.bitstrips.imoji.services.PackageService", com/bitstrips/imoji/services/FloaterService, getClass().getClassLoader());
    }

    public FloaterService get()
    {
        FloaterService floaterservice = new FloaterService();
        injectMembers(floaterservice);
        return floaterservice;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(analytics);
        set1.add(picasso);
        set1.add(floaterAnalyticsService);
        set1.add(packageService);
    }

    public void injectMembers(FloaterService floaterservice)
    {
        floaterservice.analytics = (AnalyticsService)analytics.get();
        floaterservice.picasso = (Picasso)picasso.get();
        floaterservice.floaterAnalyticsService = (FloaterGoogleAnalyticsService)floaterAnalyticsService.get();
        floaterservice.packageService = (PackageService)packageService.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((FloaterService)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.services.FloaterService", "members/com.bitstrips.imoji.services.FloaterService", false, com/bitstrips/imoji/services/FloaterService);
    }
}
