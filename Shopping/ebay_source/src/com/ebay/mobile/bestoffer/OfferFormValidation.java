// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.ebay.mobile.widget.PriceView;

public class OfferFormValidation
{
    private class ValidationWatcher
        implements TextWatcher
    {

        final OfferFormValidation this$0;

        public void afterTextChanged(Editable editable)
        {
            updateSubmitButton();
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        private ValidationWatcher()
        {
            this$0 = OfferFormValidation.this;
            super();
        }

    }


    private final PriceView bidField;
    private final int quantityAvailable;
    private final EditText quantityField;
    private final Button submitButton;

    public OfferFormValidation(Button button, PriceView priceview, EditText edittext, int i)
    {
        submitButton = button;
        bidField = priceview;
        quantityField = edittext;
        quantityAvailable = i;
        button = new ValidationWatcher();
        priceview.addTextChangedListener(button);
        edittext.addTextChangedListener(button);
        updateSubmitButton();
    }

    private boolean priceIsValid()
    {
        return bidField.getPrice() > 0.0D;
    }

    private boolean quantityIsValid()
    {
        if (quantityAvailable >= 2) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        int i = 0;
        int j = Integer.parseInt(quantityField.getText().toString());
        i = j;
_L4:
        if (1 > i || i > quantityAvailable)
        {
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        NumberFormatException numberformatexception;
        numberformatexception;
          goto _L4
    }

    private void updateSubmitButton()
    {
        boolean flag1 = priceIsValid();
        Button button = submitButton;
        boolean flag;
        if (flag1 && quantityIsValid())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        button.setEnabled(flag);
        if (!flag1 && !bidField.isEmpty())
        {
            Context context = quantityField.getContext();
            bidField.setError(context.getString(0x7f070482));
        }
    }

}
