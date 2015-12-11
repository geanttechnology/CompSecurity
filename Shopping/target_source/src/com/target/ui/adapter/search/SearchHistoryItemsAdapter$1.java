// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.search;

import android.view.View;

// Referenced classes of package com.target.ui.adapter.search:
//            SearchHistoryItemsAdapter

class val.title
    implements android.view.yItemsAdapter._cls1
{

    final SearchHistoryItemsAdapter this$0;
    final String val$title;

    public void onClick(View view)
    {
        if (SearchHistoryItemsAdapter.a(SearchHistoryItemsAdapter.this) != null)
        {
            SearchHistoryItemsAdapter.a(SearchHistoryItemsAdapter.this).a(val$title);
        }
    }

    ()
    {
        this$0 = final_searchhistoryitemsadapter;
        val$title = String.this;
        super();
    }
}
