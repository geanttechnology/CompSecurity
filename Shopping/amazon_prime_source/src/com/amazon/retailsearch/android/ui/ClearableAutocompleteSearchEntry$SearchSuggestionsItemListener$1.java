// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryContext;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionFilter;
import com.amazon.retailsearch.data.SuggestionDataProvider;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            ClearableAutocompleteSearchEntry, SearchEntryAutocompleteTextView

class val.deleteURL
    implements Runnable
{

    final is._cls0 this$1;
    final String val$deleteURL;
    final String val$id;

    public void run()
    {
        ClearableAutocompleteSearchEntry.access$1200(_fld0).deletePastSearches(val$id, val$deleteURL);
        if (cess._mth1300(this._cls1.this) != null)
        {
            ClearableAutocompleteSearchEntry.access$400(_fld0).setForceUpdatePastSearches(true);
            cess._mth1300(this._cls1.this).filter(ClearableAutocompleteSearchEntry.access$000(_fld0).getText());
        }
    }

    i()
    {
        this$1 = final_i;
        val$id = s;
        val$deleteURL = String.this;
        super();
    }
}
