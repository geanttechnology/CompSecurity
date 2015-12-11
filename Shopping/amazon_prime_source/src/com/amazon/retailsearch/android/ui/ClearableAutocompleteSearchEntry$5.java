// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            ClearableAutocompleteSearchEntry, SearchEntryAutocompleteTextView

class this._cls0
    implements android.view.completeSearchEntry._cls5
{

    final ClearableAutocompleteSearchEntry this$0;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        if (i == 0 && j == 0 && k == 0 && l == 0)
        {
            return;
        }
        if (android.os.tocompleteSearchEntry >= 21)
        {
            ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).setDropDownBackgroundResource(com.amazon.retailsearch.order);
        }
        ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).setDropDownWidth((ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).getWidth() + ClearableAutocompleteSearchEntry.access$500(ClearableAutocompleteSearchEntry.this).getWidth()) - ClearableAutocompleteSearchEntry.access$500(ClearableAutocompleteSearchEntry.this).getPaddingRight());
    }

    ()
    {
        this$0 = ClearableAutocompleteSearchEntry.this;
        super();
    }
}
