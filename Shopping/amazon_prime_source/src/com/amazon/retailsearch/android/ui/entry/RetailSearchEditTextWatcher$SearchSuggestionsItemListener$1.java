// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import com.amazon.retailsearch.data.ISuggestionDataProvider;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchEditTextWatcher, RetailSearchEntryContext, RetailSearchEditText, RetailSearchSuggestionFilter

class val.deleteURL
    implements Runnable
{

    final is._cls0 this$1;
    final String val$deleteURL;
    final String val$id;

    public void run()
    {
        cess._mth400(this._cls1.this).deletePastSearches(val$id, val$deleteURL);
        if (RetailSearchEditTextWatcher.access$500(_fld0) != null)
        {
            RetailSearchEditTextWatcher.access$600(_fld0).setForceUpdatePastSearches(true);
            RetailSearchEditTextWatcher.access$500(_fld0).filter(mSearchEditText.getText());
        }
    }

    ()
    {
        this$1 = final_;
        val$id = s;
        val$deleteURL = String.this;
        super();
    }
}
