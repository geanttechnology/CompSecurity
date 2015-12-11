// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import com.amazon.retailsearch.interaction.UserInteractionListener;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            StyledSpannableString

public final class  extends Binding
    implements MembersInjector
{

    private Binding retailSearchDataProvider;
    private Binding userInteractionListener;

    public void attach(Linker linker)
    {
        userInteractionListener = linker.requestBinding("com.amazon.retailsearch.interaction.UserInteractionListener", com/amazon/retailsearch/android/ui/StyledSpannableString, getClass().getClassLoader());
        retailSearchDataProvider = linker.requestBinding("dagger.Lazy<com.amazon.retailsearch.data.IRetailSearchDataProvider>", com/amazon/retailsearch/android/ui/StyledSpannableString, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(userInteractionListener);
        set1.add(retailSearchDataProvider);
    }

    public void injectMembers(StyledSpannableString styledspannablestring)
    {
        styledspannablestring.userInteractionListener = (UserInteractionListener)userInteractionListener.get();
        styledspannablestring.retailSearchDataProvider = (Lazy)retailSearchDataProvider.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((StyledSpannableString)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.StyledSpannableString", false, com/amazon/retailsearch/android/ui/StyledSpannableString);
    }
}
