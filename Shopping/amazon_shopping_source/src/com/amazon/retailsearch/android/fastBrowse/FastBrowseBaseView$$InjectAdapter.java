// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            FastBrowseBaseView

public final class  extends Binding
    implements MembersInjector
{

    private Binding platform;

    public void attach(Linker linker)
    {
        platform = linker.requestBinding("com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform", com/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(platform);
    }

    public void injectMembers(FastBrowseBaseView fastbrowsebaseview)
    {
        fastbrowsebaseview.platform = (RetailSearchAndroidPlatform)platform.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((FastBrowseBaseView)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.fastBrowse.FastBrowseBaseView", false, com/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView);
    }
}
