// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryContext;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            ClearableAutocompleteSearchEntry

class this._cls0
    implements TextWatcher
{

    final ClearableAutocompleteSearchEntry this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (!TextUtils.isEmpty(charsequence))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            ClearableAutocompleteSearchEntry.access$500(ClearableAutocompleteSearchEntry.this).setVisibility(0);
        } else
        {
            ClearableAutocompleteSearchEntry.access$500(ClearableAutocompleteSearchEntry.this).setVisibility(8);
        }
        if (ClearableAutocompleteSearchEntry.access$400(ClearableAutocompleteSearchEntry.this) != null && !ClearableAutocompleteSearchEntry.access$400(ClearableAutocompleteSearchEntry.this).isFirstKeystrokeLogged() && i != 0)
        {
            ClearableAutocompleteSearchEntry.access$600(ClearableAutocompleteSearchEntry.this).searchSuggestionsFirstKeyStroke();
            ClearableAutocompleteSearchEntry.access$400(ClearableAutocompleteSearchEntry.this).setIsFirstKeystrokeLogged(true);
        }
    }

    ()
    {
        this$0 = ClearableAutocompleteSearchEntry.this;
        super();
    }
}
