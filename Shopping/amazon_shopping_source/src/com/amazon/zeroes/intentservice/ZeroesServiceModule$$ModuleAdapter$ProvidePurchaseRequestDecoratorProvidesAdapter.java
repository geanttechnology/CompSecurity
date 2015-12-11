// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.zeroes.intentservice:
//            ZeroesServiceModule, DefaultZeroesPurchaseRequestDecorator, ZeroesPurchaseRequestDecorator

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private Binding decorator;
    private final ZeroesServiceModule module;

    public void attach(Linker linker)
    {
        decorator = linker.requestBinding("com.amazon.zeroes.intentservice.DefaultZeroesPurchaseRequestDecorator", com/amazon/zeroes/intentservice/ZeroesServiceModule, getClass().getClassLoader());
    }

    public ZeroesPurchaseRequestDecorator get()
    {
        return module.providePurchaseRequestDecorator((DefaultZeroesPurchaseRequestDecorator)decorator.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(decorator);
    }

    public (ZeroesServiceModule zeroesservicemodule)
    {
        super("com.amazon.zeroes.intentservice.ZeroesPurchaseRequestDecorator", false, "com.amazon.zeroes.intentservice.ZeroesServiceModule", "providePurchaseRequestDecorator");
        module = zeroesservicemodule;
        setLibrary(false);
    }
}
