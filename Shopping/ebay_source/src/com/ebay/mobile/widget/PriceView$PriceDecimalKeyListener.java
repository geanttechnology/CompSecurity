// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.text.method.DigitsKeyListener;
import com.ebay.nautilus.domain.EbayCurrency;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

// Referenced classes of package com.ebay.mobile.widget:
//            PriceView

protected class decimalSeparator extends DigitsKeyListener
{

    private final char decimalSeparator;
    private final char digits[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };
    private final char digitsAndSeparator[] = {
        '\0', '.', '0', '1', '2', '3', '4', '5', '6', '7', 
        '8', '9'
    };
    private final int fractionDigits;
    private final char nothing[] = new char[0];
    final PriceView this$0;

    protected char[] getAcceptedChars()
    {
        char ac[] = nothing;
        Object obj;
        if (fractionDigits == 0)
        {
            obj = digits;
        } else
        {
            String s = getText().toString();
            int i;
            if (textWithoutSelection == null)
            {
                PriceView priceview;
                if (getSelectionStart() != getSelectionEnd())
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                priceview = PriceView.this;
                if (i != 0)
                {
                    obj = (new StringBuilder()).append(s.substring(0, getSelectionStart())).append(s.substring(getSelectionEnd(), s.length())).toString();
                } else
                {
                    obj = null;
                }
                priceview.textWithoutSelection = ((String) (obj));
            }
            obj = s;
            if (textWithoutSelection != null)
            {
                obj = textWithoutSelection;
            }
            i = ((String) (obj)).indexOf(decimalSeparator);
            if (i == -1)
            {
                return digitsAndSeparator;
            }
            if (((String) (obj)).length() - i <= fractionDigits)
            {
                return digits;
            }
            obj = ac;
            if (getSelectionStart() <= i)
            {
                return digits;
            }
        }
        return ((char []) (obj));
    }

    public int getInputType()
    {
        return 8194;
    }

    public ()
    {
        this$0 = PriceView.this;
        super();
        DecimalFormat decimalformat = currency.getDecimalFormat(false);
        fractionDigits = decimalformat.getMaximumFractionDigits();
        char c;
        if (currency == null)
        {
            c = '.';
        } else
        {
            c = decimalformat.getDecimalFormatSymbols().getMonetaryDecimalSeparator();
        }
        decimalSeparator = c;
        digitsAndSeparator[0] = decimalSeparator;
    }
}
