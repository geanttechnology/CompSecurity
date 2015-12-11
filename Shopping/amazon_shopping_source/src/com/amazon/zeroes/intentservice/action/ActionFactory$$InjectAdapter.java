// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.action;

import dagger.Lazy;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.zeroes.intentservice.action:
//            ActionFactory

public final class I extends Binding
    implements Provider
{

    private Binding lazyCache;
    private Binding lazyDecorator;
    private Binding lazyMasDsClient;
    private Binding lazyWebHttpClient;

    public void attach(Linker linker)
    {
        lazyMasDsClient = linker.requestBinding("dagger.Lazy<com.amazon.mas.client.deviceservice.MasDsClient>", com/amazon/zeroes/intentservice/action/ActionFactory, getClass().getClassLoader());
        lazyWebHttpClient = linker.requestBinding("dagger.Lazy<com.amazon.mas.client.http.WebHttpClient>", com/amazon/zeroes/intentservice/action/ActionFactory, getClass().getClassLoader());
        lazyCache = linker.requestBinding("dagger.Lazy<com.amazon.zeroes.intentservice.persistence.ZeroesCache>", com/amazon/zeroes/intentservice/action/ActionFactory, getClass().getClassLoader());
        lazyDecorator = linker.requestBinding("dagger.Lazy<com.amazon.zeroes.intentservice.ZeroesPurchaseRequestDecorator>", com/amazon/zeroes/intentservice/action/ActionFactory, getClass().getClassLoader());
    }

    public ActionFactory get()
    {
        return new ActionFactory((Lazy)lazyMasDsClient.get(), (Lazy)lazyWebHttpClient.get(), (Lazy)lazyCache.get(), (Lazy)lazyDecorator.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(lazyMasDsClient);
        set.add(lazyWebHttpClient);
        set.add(lazyCache);
        set.add(lazyDecorator);
    }

    public I()
    {
        super("com.amazon.zeroes.intentservice.action.ActionFactory", "members/com.amazon.zeroes.intentservice.action.ActionFactory", false, com/amazon/zeroes/intentservice/action/ActionFactory);
    }
}
