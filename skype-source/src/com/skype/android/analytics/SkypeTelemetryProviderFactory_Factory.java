// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.skype.android.analytics;

import android.app.Application;
import com.skype.android.concurrent.AsyncService;
import com.skype.android.config.ecs.EcsConfiguration;
import com.skype.android.inject.AccountProvider;
import com.skype.telemetry.sdk.FlurryAccessInterface;
import dagger.internal.Factory;
import javax.inject.Provider;

// Referenced classes of package com.skype.android.analytics:
//            SkypeTelemetryProviderFactory

public final class SkypeTelemetryProviderFactory_Factory
    implements Factory
{

    static final boolean $assertionsDisabled;
    private final Provider accountProvider;
    private final Provider applicationProvider;
    private final Provider asyncProvider;
    private final Provider ecsConfigurationProvider;
    private final Provider flurryProvider;

    public SkypeTelemetryProviderFactory_Factory(Provider provider, Provider provider1, Provider provider2, Provider provider3, Provider provider4)
    {
        if (!$assertionsDisabled && provider == null)
        {
            throw new AssertionError();
        }
        applicationProvider = provider;
        if (!$assertionsDisabled && provider1 == null)
        {
            throw new AssertionError();
        }
        asyncProvider = provider1;
        if (!$assertionsDisabled && provider2 == null)
        {
            throw new AssertionError();
        }
        flurryProvider = provider2;
        if (!$assertionsDisabled && provider3 == null)
        {
            throw new AssertionError();
        }
        accountProvider = provider3;
        if (!$assertionsDisabled && provider4 == null)
        {
            throw new AssertionError();
        } else
        {
            ecsConfigurationProvider = provider4;
            return;
        }
    }

    public static Factory create(Provider provider, Provider provider1, Provider provider2, Provider provider3, Provider provider4)
    {
        return new SkypeTelemetryProviderFactory_Factory(provider, provider1, provider2, provider3, provider4);
    }

    public final SkypeTelemetryProviderFactory get()
    {
        return new SkypeTelemetryProviderFactory((Application)applicationProvider.get(), (AsyncService)asyncProvider.get(), (FlurryAccessInterface)flurryProvider.get(), (AccountProvider)accountProvider.get(), (EcsConfiguration)ecsConfigurationProvider.get());
    }

    public final volatile Object get()
    {
        return get();
    }

    static 
    {
        boolean flag;
        if (!com/skype/android/analytics/SkypeTelemetryProviderFactory_Factory.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
