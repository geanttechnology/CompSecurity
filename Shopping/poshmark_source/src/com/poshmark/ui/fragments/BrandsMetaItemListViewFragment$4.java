// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Filter;
import android.widget.TextView;
import com.poshmark.data_model.adapters.BrandsMetaItemListAdapter;

// Referenced classes of package com.poshmark.ui.fragments:
//            BrandsMetaItemListViewFragment

class this._cls0
    implements TextWatcher
{

    final BrandsMetaItemListViewFragment this$0;

    public void afterTextChanged(Editable editable)
    {
        if (searchText != null && searchText.length() > 0)
        {
            if (allBrandsTextView != null)
            {
                allBrandsTextView.setVisibility(8);
            }
            adapter.getFilter().filter(editable);
            return;
        } else
        {
            BrandsMetaItemListViewFragment.access$000(BrandsMetaItemListViewFragment.this);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        searchText = charsequence.toString();
    }

    ()
    {
        this$0 = BrandsMetaItemListViewFragment.this;
        super();
    }
}
