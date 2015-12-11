// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

// Referenced classes of package com.target.ui.view.search:
//            SearchHistoryCardView

private class <init>
    implements android.widget.istener
{

    final SearchHistoryCardView this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        while (SearchHistoryCardView.a(SearchHistoryCardView.this) == null || i < SearchHistoryCardView.b(SearchHistoryCardView.this).listView.getHeaderViewsCount()) 
        {
            return;
        }
        adapterview = (String)adapterview.getItemAtPosition(i);
        SearchHistoryCardView.a(SearchHistoryCardView.this).a(adapterview);
    }

    private ews()
    {
        this$0 = SearchHistoryCardView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
