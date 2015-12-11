// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.util:
//            CurrencyUtil

public class CurrencyTextWatcher
    implements TextWatcher
{

    private static final String DEFAULT_STRING_VALUE = "0.00";
    private static final float MAX_VALUE = 9999.99F;
    private EditText currencyEditText;
    private String currencySymbol;
    private CurrencyUtil currencyUtil;
    private DecimalFormat decimalFormatUS;
    private float previousValue;

    public CurrencyTextWatcher(Context context, EditText edittext, String s)
    {
        currencyEditText = edittext;
        currencySymbol = s;
        decimalFormatUS = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));
        edittext.setHint((new StringBuilder()).append(s).append(" ").append("0.00").toString());
        RoboGuice.getInjector(context).injectMembers(this);
    }

    public void afterTextChanged(Editable editable)
    {
        float f = extractFloatValueFromString(editable.toString());
        boolean flag = isValueAboveLimit(f);
        if (!currencyUtil.isCorrectCurrencyFormat(editable.toString()) || flag)
        {
            f = generateValidFloatValue(f, previousValue);
            if (f > -1F)
            {
                currencyEditText.setText((new StringBuilder()).append(currencySymbol).append(" ").append(decimalFormatUS.format(f)).toString());
                currencyEditText.setSelection(currencyEditText.getText().length());
            }
        }
        previousValue = 0.0F;
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        charsequence = (new StringBuilder()).append("").append(charsequence.toString().replaceAll("[^\\d]", "")).toString();
        if (charsequence.length() > 0)
        {
            previousValue = Float.valueOf(Float.parseFloat(charsequence)).floatValue() / 100F;
        }
    }

    public float extractFloatValueFromString(String s)
    {
        float f = -1F;
        s = (new StringBuilder()).append("").append(s.replaceAll("[^\\d]", "")).toString();
        if (s.length() > 0)
        {
            f = Float.valueOf(Float.parseFloat(s)).floatValue() / 100F;
        }
        return f;
    }

    public float generateValidFloatValue(float f, float f1)
    {
        if (isValueAboveLimit(f))
        {
            return f1;
        } else
        {
            return f;
        }
    }

    public boolean isValueAboveLimit(float f)
    {
        return f > 9999.99F;
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
