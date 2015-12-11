// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import com.amazon.retailsearch.interaction.PrefetchingManager;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchEditTextWatcher

public final class Y extends Binding
    implements MembersInjector
{

    private Binding platform;
    private Binding prefetchingManager;

    public void attach(Linker linker)
    {
        prefetchingManager = linker.requestBinding("com.amazon.retailsearch.interaction.PrefetchingManager", com/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher, getClass().getClassLoader());
        platform = linker.requestBinding("com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform", com/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(prefetchingManager);
        set1.add(platform);
    }

    public void injectMembers(RetailSearchEditTextWatcher retailsearchedittextwatcher)
    {
        retailsearchedittextwatcher.prefetchingManager = (PrefetchingManager)prefetchingManager.get();
        retailsearchedittextwatcher.platform = (RetailSearchAndroidPlatform)platform.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((RetailSearchEditTextWatcher)obj);
    }

    public Y()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.entry.RetailSearchEditTextWatcher", false, com/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher);
    }
}
