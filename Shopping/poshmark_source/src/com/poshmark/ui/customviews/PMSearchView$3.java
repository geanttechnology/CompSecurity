// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import com.poshmark.data_model.adapters.SearchSuggestionsAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.SuggestedSearchItem;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMSearchView

class this._cls0
    implements android.widget.ggestionListener
{

    final PMSearchView this$0;

    public boolean onSuggestionClick(int i)
    {
        Object obj = (CustomMatrixCursor)adapter.getCursor();
        if (((CustomMatrixCursor) (obj)).moveToPosition(i))
        {
            obj = (SuggestedSearchItem)((CustomMatrixCursor) (obj)).get(((CustomMatrixCursor) (obj)).getColumnIndex(PMData.DATA_COL));
            setQuery(null, false);
            launchSearch(((SuggestedSearchItem) (obj)), false);
        }
        return true;
    }

    public boolean onSuggestionSelect(int i)
    {
        return false;
    }

    rchItem()
    {
        this$0 = PMSearchView.this;
        super();
    }
}
