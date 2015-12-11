// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji;

import com.bitstrips.imoji.analytics.GoogleAnalyticsService;
import com.google.android.gms.analytics.Tracker;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji:
//            ImojiModule

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private final ImojiModule module;
    private Binding tracker;

    public void attach(Linker linker)
    {
        tracker = linker.requestBinding("com.google.android.gms.analytics.Tracker", com/bitstrips/imoji/ImojiModule, getClass().getClassLoader());
    }

    public GoogleAnalyticsService get()
    {
        return module.provideGoogleAnalyticsAnalyticsService((Tracker)tracker.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(tracker);
    }

    public (ImojiModule imojimodule)
    {
        super("com.bitstrips.imoji.analytics.GoogleAnalyticsService", false, "com.bitstrips.imoji.ImojiModule", "provideGoogleAnalyticsAnalyticsService");
        module = imojimodule;
        setLibrary(false);
    }
}
