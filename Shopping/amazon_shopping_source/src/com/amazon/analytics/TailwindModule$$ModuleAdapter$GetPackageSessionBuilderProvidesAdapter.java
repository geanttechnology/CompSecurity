// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;

import com.amazon.analytics.session.PackageSessionBuilder;
import dagger.internal.ProvidesBinding;
import javax.inject.Provider;

// Referenced classes of package com.amazon.analytics:
//            TailwindModule

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private final TailwindModule module;

    public PackageSessionBuilder get()
    {
        return module.getPackageSessionBuilder();
    }

    public volatile Object get()
    {
        return get();
    }

    public (TailwindModule tailwindmodule)
    {
        super("com.amazon.analytics.session.PackageSessionBuilder", true, "com.amazon.analytics.TailwindModule", "getPackageSessionBuilder");
        module = tailwindmodule;
        setLibrary(false);
    }
}
