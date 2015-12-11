// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            ClearableAutocompleteSearchEntry

public final class  extends Binding
    implements MembersInjector
{

    private Binding platform;

    public void attach(Linker linker)
    {
        platform = linker.requestBinding("com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform", com/amazon/retailsearch/android/ui/ClearableAutocompleteSearchEntry, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(platform);
    }

    public void injectMembers(ClearableAutocompleteSearchEntry clearableautocompletesearchentry)
    {
        clearableautocompletesearchentry.platform = (RetailSearchAndroidPlatform)platform.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ClearableAutocompleteSearchEntry)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.ClearableAutocompleteSearchEntry", false, com/amazon/retailsearch/android/ui/ClearableAutocompleteSearchEntry);
    }
}
