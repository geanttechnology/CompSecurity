// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.braintreepayments.cardform.a.b;

// Referenced classes of package com.braintreepayments.cardform.view:
//            c, g

public class MonthYearEditText extends c
    implements TextWatcher
{

    private boolean b;

    public MonthYearEditText(Context context)
    {
        super(context);
        d();
    }

    public MonthYearEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d();
    }

    public MonthYearEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        d();
    }

    private void d()
    {
        setInputType(2);
        setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(6)
        });
        addTextChangedListener(this);
    }

    private String getString()
    {
        Editable editable = getText();
        if (editable != null)
        {
            return editable.toString();
        } else
        {
            return "";
        }
    }

    public final boolean a()
    {
        return com.braintreepayments.cardform.a.b.a(getMonth(), getYear());
    }

    public void afterTextChanged(Editable editable)
    {
        int i = 0;
        if (b && editable.length() == 1 && Character.getNumericValue(editable.charAt(0)) >= 2)
        {
            char c1 = editable.charAt(0);
            editable.replace(0, 1, "0").append(c1);
        }
        Object aobj[] = editable.getSpans(0, editable.length(), com/braintreepayments/cardform/view/g);
        for (int j = aobj.length; i < j; i++)
        {
            editable.removeSpan(aobj[i]);
        }

        if (!a && 2 <= editable.length())
        {
            editable.setSpan(new g(), 1, 2, 33);
        }
        if (getSelectionStart() == 4 && !editable.toString().endsWith("20") || getSelectionStart() == 6)
        {
            b();
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public String getMonth()
    {
        if (getString().length() < 2)
        {
            return "";
        } else
        {
            return getString().substring(0, 2);
        }
    }

    public String getYear()
    {
        String s = getString();
        if (s.length() == 4 || s.length() == 6)
        {
            return getString().substring(2);
        } else
        {
            return "";
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        super.onTextChanged(charsequence, i, j, k);
        boolean flag;
        if (k > j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
    }
}
