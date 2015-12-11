// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.view.View;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchEntryView, RetailSearchEditText

class this._cls0
    implements android.view.try.RetailSearchEntryView._cls2
{

    final RetailSearchEntryView this$0;

    public void onClick(View view)
    {
        view = mSearchEditText.getText().toString().trim();
        doSearch(view);
    }

    ()
    {
        this$0 = RetailSearchEntryView.this;
        super();
    }
}
