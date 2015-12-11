// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.services.B4MService;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojisPreloader

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding b4MService;
    private Binding picassoProvider;
    private Binding preferenceUtils;
    private Binding templatesManager;

    public void attach(Linker linker)
    {
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/ui/ImojisPreloader, getClass().getClassLoader());
        templatesManager = linker.requestBinding("com.bitstrips.imoji.manager.TemplatesManager", com/bitstrips/imoji/ui/ImojisPreloader, getClass().getClassLoader());
        picassoProvider = linker.requestBinding("javax.inject.Provider<com.squareup.picasso.Picasso>", com/bitstrips/imoji/ui/ImojisPreloader, getClass().getClassLoader());
        b4MService = linker.requestBinding("com.bitstrips.imoji.services.B4MService", com/bitstrips/imoji/ui/ImojisPreloader, getClass().getClassLoader());
    }

    public ImojisPreloader get()
    {
        ImojisPreloader imojispreloader = new ImojisPreloader();
        injectMembers(imojispreloader);
        return imojispreloader;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(preferenceUtils);
        set1.add(templatesManager);
        set1.add(picassoProvider);
        set1.add(b4MService);
    }

    public void injectMembers(ImojisPreloader imojispreloader)
    {
        imojispreloader.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
        imojispreloader.templatesManager = (TemplatesManager)templatesManager.get();
        imojispreloader.picassoProvider = (Provider)picassoProvider.get();
        imojispreloader.b4MService = (B4MService)b4MService.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ImojisPreloader)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.ImojisPreloader", "members/com.bitstrips.imoji.ui.ImojisPreloader", false, com/bitstrips/imoji/ui/ImojisPreloader);
    }
}
