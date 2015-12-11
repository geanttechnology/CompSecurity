// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.input;

import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class  extends Binding
    implements MembersInjector
{

    private Binding platform;

    public void attach(Linker linker)
    {
        platform = linker.requestBinding("com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform", com/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(platform);
    }

    public void injectMembers(platform platform1)
    {
        platform1.platform = (RetailSearchAndroidPlatform)platform.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((injectMembers)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.input.RetailSearchQueryEntry$FilterListener", false, com/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener);
    }
}
