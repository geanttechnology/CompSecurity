// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.xfinity.playerlib.alt.PlayerSearchTalkListHelper;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchResultsFragment

private class results
    implements Runnable
{

    final List results;
    final SearchResultsFragment this$0;

    public void run()
    {
        SearchResultsFragment.access$2602(SearchResultsFragment.this, new PlayerSearchTalkListHelper(SearchResultsFragment.this, SearchResultsFragment.access$2700(SearchResultsFragment.this), results));
        SearchResultsFragment.access$2800(SearchResultsFragment.this).getTalkDelegate().speak(SearchResultsFragment.access$2600(SearchResultsFragment.this).speakResults());
    }

    (List list)
    {
        this$0 = SearchResultsFragment.this;
        super();
        results = list;
    }
}
