// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.android.api.query.Query;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.UIUtils;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchEditTextWatcher

class this._cls0
    implements QuerySubmitListener
{

    final RetailSearchEditTextWatcher this$0;

    public volatile void onQuerySubmit(Query query)
    {
        onQuerySubmit((RetailSearchQuery)query);
    }

    public void onQuerySubmit(RetailSearchQuery retailsearchquery)
    {
        if (RetailSearchEditTextWatcher.access$000(RetailSearchEditTextWatcher.this) != null)
        {
            UIUtils.closeSoftKeyboard(mSearchEditText);
            RetailSearchEditTextWatcher.access$000(RetailSearchEditTextWatcher.this).onQuerySubmit(retailsearchquery);
        }
    }

    Listener()
    {
        this$0 = RetailSearchEditTextWatcher.this;
        super();
    }
}
