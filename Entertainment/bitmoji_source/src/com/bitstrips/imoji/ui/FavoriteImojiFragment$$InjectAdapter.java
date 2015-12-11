// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.manager.RecentImojiesManager;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            FavoriteImojiFragment, AvatarChangeRegister, ImagesGridViewsWrapper

public final class A extends Binding
    implements Provider, MembersInjector
{

    private Binding avatarChangeRegister;
    private Binding popularGridViewsWrapper;
    private Binding preferenceUtils;
    private Binding purchasedGridViewsWrapper;
    private Binding recentGridViewsWrapper;
    private Binding recentImojiesManager;
    private Binding supertype;
    private Binding templatesManager;

    public void attach(Linker linker)
    {
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/ui/FavoriteImojiFragment, getClass().getClassLoader());
        avatarChangeRegister = linker.requestBinding("com.bitstrips.imoji.ui.AvatarChangeRegister", com/bitstrips/imoji/ui/FavoriteImojiFragment, getClass().getClassLoader());
        recentGridViewsWrapper = linker.requestBinding("com.bitstrips.imoji.ui.ImagesGridViewsWrapper", com/bitstrips/imoji/ui/FavoriteImojiFragment, getClass().getClassLoader());
        popularGridViewsWrapper = linker.requestBinding("com.bitstrips.imoji.ui.ImagesGridViewsWrapper", com/bitstrips/imoji/ui/FavoriteImojiFragment, getClass().getClassLoader());
        purchasedGridViewsWrapper = linker.requestBinding("com.bitstrips.imoji.ui.ImagesGridViewsWrapper", com/bitstrips/imoji/ui/FavoriteImojiFragment, getClass().getClassLoader());
        templatesManager = linker.requestBinding("com.bitstrips.imoji.manager.TemplatesManager", com/bitstrips/imoji/ui/FavoriteImojiFragment, getClass().getClassLoader());
        recentImojiesManager = linker.requestBinding("com.bitstrips.imoji.manager.RecentImojiesManager", com/bitstrips/imoji/ui/FavoriteImojiFragment, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.bitstrips.imoji.ui.AbstractFragment", com/bitstrips/imoji/ui/FavoriteImojiFragment, getClass().getClassLoader(), false, true);
    }

    public FavoriteImojiFragment get()
    {
        FavoriteImojiFragment favoriteimojifragment = new FavoriteImojiFragment();
        injectMembers(favoriteimojifragment);
        return favoriteimojifragment;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(preferenceUtils);
        set1.add(avatarChangeRegister);
        set1.add(recentGridViewsWrapper);
        set1.add(popularGridViewsWrapper);
        set1.add(purchasedGridViewsWrapper);
        set1.add(templatesManager);
        set1.add(recentImojiesManager);
        set1.add(supertype);
    }

    public void injectMembers(FavoriteImojiFragment favoriteimojifragment)
    {
        favoriteimojifragment.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
        favoriteimojifragment.avatarChangeRegister = (AvatarChangeRegister)avatarChangeRegister.get();
        favoriteimojifragment.recentGridViewsWrapper = (ImagesGridViewsWrapper)recentGridViewsWrapper.get();
        favoriteimojifragment.popularGridViewsWrapper = (ImagesGridViewsWrapper)popularGridViewsWrapper.get();
        favoriteimojifragment.purchasedGridViewsWrapper = (ImagesGridViewsWrapper)purchasedGridViewsWrapper.get();
        favoriteimojifragment.templatesManager = (TemplatesManager)templatesManager.get();
        favoriteimojifragment.recentImojiesManager = (RecentImojiesManager)recentImojiesManager.get();
        supertype.injectMembers(favoriteimojifragment);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((FavoriteImojiFragment)obj);
    }

    public A()
    {
        super("com.bitstrips.imoji.ui.FavoriteImojiFragment", "members/com.bitstrips.imoji.ui.FavoriteImojiFragment", false, com/bitstrips/imoji/ui/FavoriteImojiFragment);
    }
}
