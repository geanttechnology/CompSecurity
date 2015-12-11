// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.view.View;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            ClearableAutocompleteSearchEntry, SearchEntryAutocompleteTextView, ClearButtonEventListener

class this._cls0
    implements android.view.completeSearchEntry._cls4
{

    final ClearableAutocompleteSearchEntry this$0;

    public void onClick(View view)
    {
        ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).setText("");
        if (ClearableAutocompleteSearchEntry.access$700(ClearableAutocompleteSearchEntry.this) != null)
        {
            ClearableAutocompleteSearchEntry.access$700(ClearableAutocompleteSearchEntry.this).onTextCleared();
        }
    }

    ()
    {
        this$0 = ClearableAutocompleteSearchEntry.this;
        super();
    }
}
