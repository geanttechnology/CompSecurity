// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import com.bitstrips.imoji.manager.RecentImojiesManager;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.services.B4MService;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.squareup.picasso.Picasso;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.bitstrips.imoji.ui.adapters:
//            ImageAdapter

public final class A extends Binding
    implements MembersInjector
{

    private Binding b4MService;
    private Binding picasso;
    private Binding preferenceUtils;
    private Binding recentImojiesManager;
    private Binding templatesManager;

    public void attach(Linker linker)
    {
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/ui/adapters/ImageAdapter, getClass().getClassLoader());
        picasso = linker.requestBinding("com.squareup.picasso.Picasso", com/bitstrips/imoji/ui/adapters/ImageAdapter, getClass().getClassLoader());
        templatesManager = linker.requestBinding("com.bitstrips.imoji.manager.TemplatesManager", com/bitstrips/imoji/ui/adapters/ImageAdapter, getClass().getClassLoader());
        recentImojiesManager = linker.requestBinding("com.bitstrips.imoji.manager.RecentImojiesManager", com/bitstrips/imoji/ui/adapters/ImageAdapter, getClass().getClassLoader());
        b4MService = linker.requestBinding("com.bitstrips.imoji.services.B4MService", com/bitstrips/imoji/ui/adapters/ImageAdapter, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(preferenceUtils);
        set1.add(picasso);
        set1.add(templatesManager);
        set1.add(recentImojiesManager);
        set1.add(b4MService);
    }

    public void injectMembers(ImageAdapter imageadapter)
    {
        imageadapter.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
        imageadapter.picasso = (Picasso)picasso.get();
        imageadapter.templatesManager = (TemplatesManager)templatesManager.get();
        imageadapter.recentImojiesManager = (RecentImojiesManager)recentImojiesManager.get();
        imageadapter.b4MService = (B4MService)b4MService.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ImageAdapter)obj);
    }

    public A()
    {
        super(null, "members/com.bitstrips.imoji.ui.adapters.ImageAdapter", false, com/bitstrips/imoji/ui/adapters/ImageAdapter);
    }
}
