// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.ebay.nautilus.domain.EbayCurrency;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

// Referenced classes of package com.ebay.mobile.widget:
//            PriceView

protected class decimalSeparator
    implements TextWatcher
{

    private final char decimalSeparator;
    final PriceView this$0;

    public void afterTextChanged(Editable editable)
    {
        if (!isSettingPrice)
        {
            isPrefill = false;
        }
        textWithoutSelection = null;
        int i;
        if (decimalSeparator != '.')
        {
            if ((i = editable.length() - 1) >= 0 && editable.charAt(i) == '.')
            {
                editable = (new StringBuilder()).append(editable.toString().substring(0, i)).append(decimalSeparator).toString();
                setText(editable);
                setSelection(length());
                return;
            }
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public ()
    {
        this$0 = PriceView.this;
        super();
        char c;
        if (currency == null)
        {
            c = '.';
        } else
        {
            c = currency.getDecimalFormat(false).getDecimalFormatSymbols().getMonetaryDecimalSeparator();
        }
        decimalSeparator = c;
    }
}
