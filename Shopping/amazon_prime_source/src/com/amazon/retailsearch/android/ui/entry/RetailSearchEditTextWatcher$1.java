// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.view.View;
import android.widget.AdapterView;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.UIUtils;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchEditTextWatcher, RetailSearchSuggestionAdapter, RetailSearchEditText

class this._cls0
    implements android.widget.r
{

    final RetailSearchEditTextWatcher this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        UIUtils.closeSoftKeyboard(mSearchEditText);
        if (RetailSearchEditTextWatcher.access$000(RetailSearchEditTextWatcher.this) != null)
        {
            adapterview = RetailSearchEditTextWatcher.access$100(RetailSearchEditTextWatcher.this).generateQuery(i);
            RetailSearchEditTextWatcher.access$000(RetailSearchEditTextWatcher.this).onQuerySubmit(adapterview);
            mSearchEditText.setText(adapterview.getKeywords());
            setForceUpdatePastSearches(true);
        }
    }

    Listener()
    {
        this$0 = RetailSearchEditTextWatcher.this;
        super();
    }
}
