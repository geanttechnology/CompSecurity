// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice;

import android.content.SharedPreferences;
import com.amazon.zeroes.intentservice.persistence.ZeroesCache;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.zeroes.intentservice:
//            ZeroesServiceModule

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private final ZeroesServiceModule module;
    private Binding sharedPreferences;

    public void attach(Linker linker)
    {
        sharedPreferences = linker.requestBinding("android.content.SharedPreferences", com/amazon/zeroes/intentservice/ZeroesServiceModule, getClass().getClassLoader());
    }

    public ZeroesCache get()
    {
        return module.provideCache((SharedPreferences)sharedPreferences.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(sharedPreferences);
    }

    public (ZeroesServiceModule zeroesservicemodule)
    {
        super("com.amazon.zeroes.intentservice.persistence.ZeroesCache", false, "com.amazon.zeroes.intentservice.ZeroesServiceModule", "provideCache");
        module = zeroesservicemodule;
        setLibrary(false);
    }
}
