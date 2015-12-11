// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji;

import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.GoogleAndBitstripsAnalyticsService;
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

    private Binding googleAndBitstripsAnalyticsService;
    private final ImojiModule module;

    public void attach(Linker linker)
    {
        googleAndBitstripsAnalyticsService = linker.requestBinding("com.bitstrips.imoji.analytics.GoogleAndBitstripsAnalyticsService", com/bitstrips/imoji/ImojiModule, getClass().getClassLoader());
    }

    public AnalyticsService get()
    {
        return module.provideAnalyticsService((GoogleAndBitstripsAnalyticsService)googleAndBitstripsAnalyticsService.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(googleAndBitstripsAnalyticsService);
    }

    public (ImojiModule imojimodule)
    {
        super("com.bitstrips.imoji.analytics.AnalyticsService", false, "com.bitstrips.imoji.ImojiModule", "provideAnalyticsService");
        module = imojimodule;
        setLibrary(false);
    }
}
