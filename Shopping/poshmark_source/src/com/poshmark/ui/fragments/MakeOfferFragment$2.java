// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import com.poshmark.utils.CurrencyUtils;

// Referenced classes of package com.poshmark.ui.fragments:
//            MakeOfferFragment

class this._cls0
    implements TextWatcher
{

    final MakeOfferFragment this$0;

    public void afterTextChanged(Editable editable)
    {
        if (!editable.toString().contains(CurrencyUtils.getCurrencySymbol()))
        {
            editable = (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(offerText.getText().toString()).toString();
            offerText.setText(editable);
            Selection.setSelection(offerText.getText(), offerText.getText().length());
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$0 = MakeOfferFragment.this;
        super();
    }
}
