// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.TextView;
import com.poshmark.data_model.models.NewListing;
import com.poshmark.ui.customviews.LabelledEditText;
import com.poshmark.utils.CurrencyUtils;
import com.poshmark.utils.view_holders.ListingEditorViewHolder;
import java.math.BigDecimal;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorFragment

class this._cls0
    implements TextWatcher
{

    final ListingEditorFragment this$0;

    public void afterTextChanged(Editable editable)
    {
        if (!editable.toString().contains(CurrencyUtils.getCurrencySymbol()))
        {
            String s = (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(viewHolder.listingPriceEditText.getText().toString()).toString();
            viewHolder.listingPriceEditText.setText(s);
            Selection.setSelection(viewHolder.listingPriceEditText.getText(), viewHolder.listingPriceEditText.getText().length());
        }
        editable = editable.toString();
        if (editable == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        editable = editable.replace(CurrencyUtils.getCurrencySymbol(), "");
        newListing.setListingPrice(editable);
        if (editable.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        editable = new BigDecimal(editable);
        editable = CurrencyUtils.getPriceAsFormattedString(ListingEditorFragment.access$000(ListingEditorFragment.this, editable));
        viewHolder.earningsTextView.setText((new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(editable).toString());
        return;
        editable;
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    older()
    {
        this$0 = ListingEditorFragment.this;
        super();
    }
}
