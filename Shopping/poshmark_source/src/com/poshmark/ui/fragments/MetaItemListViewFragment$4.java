// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Filter;
import com.poshmark.data_model.adapters.MetaItemListAdapter;

// Referenced classes of package com.poshmark.ui.fragments:
//            MetaItemListViewFragment

class this._cls0
    implements TextWatcher
{

    final MetaItemListViewFragment this$0;

    public void afterTextChanged(Editable editable)
    {
        adapter.getFilter().filter(editable);
        searchBox.requestFocus();
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$0 = MetaItemListViewFragment.this;
        super();
    }
}
