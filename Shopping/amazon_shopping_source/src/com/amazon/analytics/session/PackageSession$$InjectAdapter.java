// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.session;

import com.amazon.analytics.AnalyticsConfiguration;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.amazon.analytics.session:
//            PackageSession, SessionObserver

public final class  extends Binding
    implements MembersInjector
{

    private Binding config;
    private Binding sessionObserver;
    private Binding timerService;

    public void attach(Linker linker)
    {
        config = linker.requestBinding("com.amazon.analytics.AnalyticsConfiguration", com/amazon/analytics/session/PackageSession, getClass().getClassLoader());
        sessionObserver = linker.requestBinding("com.amazon.analytics.session.SessionObserver", com/amazon/analytics/session/PackageSession, getClass().getClassLoader());
        timerService = linker.requestBinding("@javax.inject.Named(value=TailwindExecutorService)/java.util.concurrent.ScheduledExecutorService", com/amazon/analytics/session/PackageSession, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(config);
        set1.add(sessionObserver);
        set1.add(timerService);
    }

    public void injectMembers(PackageSession packagesession)
    {
        packagesession.config = (AnalyticsConfiguration)config.get();
        packagesession.sessionObserver = (SessionObserver)sessionObserver.get();
        packagesession.timerService = (ScheduledExecutorService)timerService.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((PackageSession)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.analytics.session.PackageSession", false, com/amazon/analytics/session/PackageSession);
    }
}
