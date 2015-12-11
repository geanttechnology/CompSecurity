// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.widget.AbsListView;
import se.emilsjolander.stickylistheaders.ExpandableStickyListHeadersListView;

// Referenced classes of package com.groupon.fragment:
//            FilterSheetViewFragment

class this._cls0
    implements android.widget.er
{

    final FilterSheetViewFragment this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        filterList.setOnScrollListener(null);
        FilterSheetViewFragment.access$300(FilterSheetViewFragment.this).onScrollableActivated();
    }

    rollableActivatedListener()
    {
        this$0 = FilterSheetViewFragment.this;
        super();
    }
}
