// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchEditText

public final class  extends Binding
    implements MembersInjector
{

    private Binding platform;
    private Binding supertype;

    public void attach(Linker linker)
    {
        platform = linker.requestBinding("com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform", com/amazon/retailsearch/android/ui/entry/RetailSearchEditText, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.amazon.retailsearch.android.ui.ClearableEditText", com/amazon/retailsearch/android/ui/entry/RetailSearchEditText, getClass().getClassLoader(), false, true);
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(platform);
        set1.add(supertype);
    }

    public void injectMembers(RetailSearchEditText retailsearchedittext)
    {
        retailsearchedittext.platform = (RetailSearchAndroidPlatform)platform.get();
        supertype.injectMembers(retailsearchedittext);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((RetailSearchEditText)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.entry.RetailSearchEditText", false, com/amazon/retailsearch/android/ui/entry/RetailSearchEditText);
    }
}
