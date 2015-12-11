// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.fragments;

import com.bitstrips.imoji.manager.RecentImojiesManager;
import com.bitstrips.imoji.manager.TemplatesManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui.fragments:
//            FavouriteFragment

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding recentImojiesManager;
    private Binding templatesManager;

    public void attach(Linker linker)
    {
        templatesManager = linker.requestBinding("com.bitstrips.imoji.manager.TemplatesManager", com/bitstrips/imoji/ui/fragments/FavouriteFragment, getClass().getClassLoader());
        recentImojiesManager = linker.requestBinding("com.bitstrips.imoji.manager.RecentImojiesManager", com/bitstrips/imoji/ui/fragments/FavouriteFragment, getClass().getClassLoader());
    }

    public FavouriteFragment get()
    {
        FavouriteFragment favouritefragment = new FavouriteFragment();
        injectMembers(favouritefragment);
        return favouritefragment;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(templatesManager);
        set1.add(recentImojiesManager);
    }

    public void injectMembers(FavouriteFragment favouritefragment)
    {
        favouritefragment.templatesManager = (TemplatesManager)templatesManager.get();
        favouritefragment.recentImojiesManager = (RecentImojiesManager)recentImojiesManager.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((FavouriteFragment)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.fragments.FavouriteFragment", "members/com.bitstrips.imoji.ui.fragments.FavouriteFragment", false, com/bitstrips/imoji/ui/fragments/FavouriteFragment);
    }
}
