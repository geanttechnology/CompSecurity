// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.input;

import com.amazon.retailsearch.android.ui.ClearableAutoCompleteTextView;
import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryContext;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionFilter;
import com.amazon.retailsearch.data.SuggestionDataProvider;

// Referenced classes of package com.amazon.retailsearch.android.ui.input:
//            RetailSearchQueryEntry

class val.deleteURL
    implements Runnable
{

    final this._cls0 this$0;
    final String val$deleteURL;
    final String val$id;

    public void run()
    {
        cess._mth600(this._cls0.this).deletePastSearches(val$id, val$deleteURL);
        if (cess._mth700(this._cls0.this) != null)
        {
            cess._mth800(this._cls0.this).setForceUpdatePastSearches(true);
            cess._mth700(this._cls0.this).filter(cess._mth900(this._cls0.this).getText());
        }
    }

    ()
    {
        this$0 = final_;
        val$id = s;
        val$deleteURL = String.this;
        super();
    }
}
