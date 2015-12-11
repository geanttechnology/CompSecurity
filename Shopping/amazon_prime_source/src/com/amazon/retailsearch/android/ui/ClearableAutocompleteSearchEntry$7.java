// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.widget.ImageView;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            ClearableAutocompleteSearchEntry, SearchEntryAutocompleteTextView

class this._cls0
    implements Runnable
{

    final ClearableAutocompleteSearchEntry this$0;

    public void run()
    {
        ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).setPadding(ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).getPaddingLeft(), ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).getPaddingTop(), ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).getPaddingRight() + ClearableAutocompleteSearchEntry.access$500(ClearableAutocompleteSearchEntry.this).getWidth(), ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).getPaddingBottom());
        ClearableAutocompleteSearchEntry.access$500(ClearableAutocompleteSearchEntry.this).setVisibility(8);
    }

    ()
    {
        this$0 = ClearableAutocompleteSearchEntry.this;
        super();
    }
}
