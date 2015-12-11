// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.resultheader;

import com.amazon.retailsearch.interaction.SearchDataSource;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.android.ui.resultheader:
//            ResultsInfoBarContentListener

public final class  extends Binding
    implements MembersInjector, Provider
{

    private Binding searchDataSource;

    public void attach(Linker linker)
    {
        searchDataSource = linker.requestBinding("com.amazon.retailsearch.interaction.SearchDataSource", com/amazon/retailsearch/android/ui/resultheader/ResultsInfoBarContentListener, getClass().getClassLoader());
    }

    public ResultsInfoBarContentListener get()
    {
        ResultsInfoBarContentListener resultsinfobarcontentlistener = new ResultsInfoBarContentListener();
        injectMembers(resultsinfobarcontentlistener);
        return resultsinfobarcontentlistener;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(searchDataSource);
    }

    public void injectMembers(ResultsInfoBarContentListener resultsinfobarcontentlistener)
    {
        resultsinfobarcontentlistener.searchDataSource = (SearchDataSource)searchDataSource.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ResultsInfoBarContentListener)obj);
    }

    public ()
    {
        super("com.amazon.retailsearch.android.ui.resultheader.ResultsInfoBarContentListener", "members/com.amazon.retailsearch.android.ui.resultheader.ResultsInfoBarContentListener", false, com/amazon/retailsearch/android/ui/resultheader/ResultsInfoBarContentListener);
    }
}
