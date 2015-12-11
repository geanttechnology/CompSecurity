// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;

import android.app.ActivityManager;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.analytics:
//            TailwindModule, TailwindActivityManager

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private Binding activityManager;
    private final TailwindModule module;

    public void attach(Linker linker)
    {
        activityManager = linker.requestBinding("android.app.ActivityManager", com/amazon/analytics/TailwindModule, getClass().getClassLoader());
    }

    public TailwindActivityManager get()
    {
        return module.getTailwindActivityManager((ActivityManager)activityManager.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(activityManager);
    }

    public (TailwindModule tailwindmodule)
    {
        super("com.amazon.analytics.TailwindActivityManager", true, "com.amazon.analytics.TailwindModule", "getTailwindActivityManager");
        module = tailwindmodule;
        setLibrary(false);
    }
}
