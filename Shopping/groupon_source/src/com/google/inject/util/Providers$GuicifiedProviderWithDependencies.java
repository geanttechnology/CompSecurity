// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.util;

import com.google.inject.Injector;
import com.google.inject.spi.ProviderWithDependencies;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.google.inject.util:
//            Providers

private static final class <init> extends <init>
    implements ProviderWithDependencies
{

    private final Set dependencies;

    public Set getDependencies()
    {
        return dependencies;
    }

    void initialize(Injector injector)
    {
        injector.injectMembers(_flddelegate);
    }

    private (Set set, Provider provider)
    {
        super(provider, null);
        dependencies = set;
    }

    dependencies(Set set, Provider provider, dependencies dependencies1)
    {
        this(set, provider);
    }
}
