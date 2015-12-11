// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.target.ui.model.search.a;

// Referenced classes of package com.target.ui.view.search:
//            SearchSuggestionCardView

private class <init>
    implements android.widget.ener
{

    final SearchSuggestionCardView this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        while (com.target.ui.view.search.SearchSuggestionCardView.a(SearchSuggestionCardView.this) == null || i < SearchSuggestionCardView.b(SearchSuggestionCardView.this).listView.getHeaderViewsCount()) 
        {
            return;
        }
        adapterview = (a)adapterview.getItemAtPosition(i);
        com.target.ui.view.search.SearchSuggestionCardView.a(SearchSuggestionCardView.this).a(adapterview);
    }

    private ews()
    {
        this$0 = SearchSuggestionCardView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
