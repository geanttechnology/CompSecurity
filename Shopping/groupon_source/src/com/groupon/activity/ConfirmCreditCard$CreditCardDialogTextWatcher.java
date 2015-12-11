// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.groupon.view.PatternTextWatcher;

// Referenced classes of package com.groupon.activity:
//            ConfirmCreditCard

private class patternTextWatcher
    implements TextWatcher
{

    private PatternTextWatcher patternTextWatcher;
    final ConfirmCreditCard this$0;

    public void afterTextChanged(Editable editable)
    {
        patternTextWatcher.afterTextChanged(editable);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        patternTextWatcher.beforeTextChanged(charsequence, i, j, k);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if ("errorOn".equals(creditCardError.getTag()))
        {
            ConfirmCreditCard.access$100(ConfirmCreditCard.this);
        }
        patternTextWatcher.onTextChanged(charsequence, i, j, k);
    }

    public (String s, String s1)
    {
        this$0 = ConfirmCreditCard.this;
        super();
        patternTextWatcher = new PatternTextWatcher(s, s1);
    }
}
