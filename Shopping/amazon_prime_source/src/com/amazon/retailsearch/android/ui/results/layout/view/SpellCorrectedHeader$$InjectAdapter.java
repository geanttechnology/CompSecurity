// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.view:
//            SpellCorrectedHeader

public final class  extends Binding
    implements MembersInjector
{

    private Binding preferencesManager;

    public void attach(Linker linker)
    {
        preferencesManager = linker.requestBinding("com.amazon.retailsearch.userpreferences.UserPreferenceManager", com/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(preferencesManager);
    }

    public void injectMembers(SpellCorrectedHeader spellcorrectedheader)
    {
        spellcorrectedheader.preferencesManager = (UserPreferenceManager)preferencesManager.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((SpellCorrectedHeader)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.results.layout.view.SpellCorrectedHeader", false, com/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader);
    }
}
