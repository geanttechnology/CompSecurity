// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.widget.AbsListView;
import com.livemixtapes.ui.widgets.SearchView;

// Referenced classes of package com.livemixtapes:
//            SearchFragment, LazyAdapterSearch

class previousLast
    implements android.widget.ollListener
{

    private int previousLast;
    final SearchFragment this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
label0:
        {
            i += j;
            if (i == k && k > 1 && i != previousLast)
            {
                if (adapter.isTopArtistSearch())
                {
                    break label0;
                }
                previousLast = i;
                abslistview = SearchFragment.this;
                abslistview.curPage = ((SearchFragment) (abslistview)).curPage + 1;
                SearchFragment.access$1(SearchFragment.this, searchView.getQuery());
            }
            return;
        }
        previousLast = -1;
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    View()
    {
        this$0 = SearchFragment.this;
        super();
        previousLast = -1;
    }
}
