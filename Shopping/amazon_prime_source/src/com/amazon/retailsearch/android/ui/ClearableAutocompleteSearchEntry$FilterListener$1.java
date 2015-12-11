// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.graphics.drawable.Drawable;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            ClearableAutocompleteSearchEntry, SearchEntryAutocompleteTextView

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        if (ClearableAutocompleteSearchEntry.access$800(_fld0) != null)
        {
            ClearableAutocompleteSearchEntry.access$000(_fld0).setCompoundDrawablesWithIntrinsicBounds(ClearableAutocompleteSearchEntry.access$900(_fld0), null, ClearableAutocompleteSearchEntry.access$800(_fld0), null);
            ClearableAutocompleteSearchEntry.access$800(_fld0).setVisible(true, false);
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
