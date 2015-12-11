// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;

import dagger.internal.ProvidesBinding;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;

// Referenced classes of package com.amazon.analytics:
//            TailwindModule

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private final TailwindModule module;

    public volatile Object get()
    {
        return get();
    }

    public ScheduledExecutorService get()
    {
        return module.getScheduledExecutorService();
    }

    public (TailwindModule tailwindmodule)
    {
        super("@javax.inject.Named(value=TailwindExecutorService)/java.util.concurrent.ScheduledExecutorService", true, "com.amazon.analytics.TailwindModule", "getScheduledExecutorService");
        module = tailwindmodule;
        setLibrary(false);
    }
}
