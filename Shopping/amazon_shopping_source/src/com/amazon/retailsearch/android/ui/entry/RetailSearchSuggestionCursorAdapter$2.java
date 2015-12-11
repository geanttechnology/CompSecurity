// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.view.View;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchSuggestionCursorAdapter, SuggestionsItemListener

class val.searchSuggestion
    implements android.view.chSuggestionCursorAdapter._cls2
{

    final RetailSearchSuggestionCursorAdapter this$0;
    final String val$searchSuggestion;

    public void onClick(View view)
    {
        if (RetailSearchSuggestionCursorAdapter.access$000(RetailSearchSuggestionCursorAdapter.this) != null)
        {
            RetailSearchSuggestionCursorAdapter.access$000(RetailSearchSuggestionCursorAdapter.this).onQueryBuilderClick(val$searchSuggestion);
        }
    }

    ()
    {
        this$0 = final_retailsearchsuggestioncursoradapter;
        val$searchSuggestion = String.this;
        super();
    }
}
