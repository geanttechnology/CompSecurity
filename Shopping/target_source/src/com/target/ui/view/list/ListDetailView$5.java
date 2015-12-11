// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import com.target.ui.util.e.a;

// Referenced classes of package com.target.ui.view.list:
//            ListDetailView, ListItemSuggestionsView

class this._cls0
    implements android.view.ner
{

    final ListDetailView this$0;

    public void onClick(View view)
    {
        if (ListDetailView.c(ListDetailView.this) != null)
        {
            com.target.ui.view.list.ListDetailView.a(ListDetailView.this).mListDetailView.requestFocus();
            a.a(ListDetailView.this);
            com.target.ui.view.list.ListDetailView.a(ListDetailView.this).listItemSuggestionView.setVisibility(8);
            ListDetailView.c(ListDetailView.this).b();
        }
    }

    nsView()
    {
        this$0 = ListDetailView.this;
        super();
    }
}
