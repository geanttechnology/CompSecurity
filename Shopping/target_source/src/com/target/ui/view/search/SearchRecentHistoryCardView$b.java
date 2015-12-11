// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

// Referenced classes of package com.target.ui.view.search:
//            SearchRecentHistoryCardView

private class <init>
    implements android.widget.r
{

    final SearchRecentHistoryCardView this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        while (SearchRecentHistoryCardView.a(SearchRecentHistoryCardView.this) == null || i < SearchRecentHistoryCardView.b(SearchRecentHistoryCardView.this).listView.getHeaderViewsCount()) 
        {
            return;
        }
        adapterview = (String)adapterview.getItemAtPosition(i);
        SearchRecentHistoryCardView.a(SearchRecentHistoryCardView.this).a(adapterview);
    }

    private ews()
    {
        this$0 = SearchRecentHistoryCardView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
