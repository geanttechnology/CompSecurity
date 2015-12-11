// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice;

import com.amazon.mas.client.account.summary.AccountSummaryProvider;
import com.amazon.mas.client.device.DeviceInspector;
import com.amazon.zeroes.intentservice.action.ActionFactory;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.zeroes.intentservice:
//            ZeroesService

public final class  extends Binding
    implements MembersInjector, Provider
{

    private Binding accountSummaryProvider;
    private Binding actionFactory;
    private Binding deviceInspector;

    public void attach(Linker linker)
    {
        actionFactory = linker.requestBinding("com.amazon.zeroes.intentservice.action.ActionFactory", com/amazon/zeroes/intentservice/ZeroesService, getClass().getClassLoader());
        deviceInspector = linker.requestBinding("com.amazon.mas.client.device.DeviceInspector", com/amazon/zeroes/intentservice/ZeroesService, getClass().getClassLoader());
        accountSummaryProvider = linker.requestBinding("com.amazon.mas.client.account.summary.AccountSummaryProvider", com/amazon/zeroes/intentservice/ZeroesService, getClass().getClassLoader());
    }

    public ZeroesService get()
    {
        ZeroesService zeroesservice = new ZeroesService();
        injectMembers(zeroesservice);
        return zeroesservice;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(actionFactory);
        set1.add(deviceInspector);
        set1.add(accountSummaryProvider);
    }

    public void injectMembers(ZeroesService zeroesservice)
    {
        zeroesservice.actionFactory = (ActionFactory)actionFactory.get();
        zeroesservice.deviceInspector = (DeviceInspector)deviceInspector.get();
        zeroesservice.accountSummaryProvider = (AccountSummaryProvider)accountSummaryProvider.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ZeroesService)obj);
    }

    public ()
    {
        super("com.amazon.zeroes.intentservice.ZeroesService", "members/com.amazon.zeroes.intentservice.ZeroesService", false, com/amazon/zeroes/intentservice/ZeroesService);
    }
}
