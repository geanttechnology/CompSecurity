// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            CreditCardActivity

public static class errorColor
    implements TextWatcher
{

    protected final int baseColor;
    protected final int errorColor;
    protected final EditText watchedView;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    protected void safeSetTextAfterTextChanged(String s)
    {
        watchedView.removeTextChangedListener(this);
        watchedView.setText(s);
        watchedView.setSelection(s.length());
        watchedView.addTextChangedListener(this);
    }

    public (EditText edittext)
    {
        watchedView = edittext;
        baseColor = edittext.getTextColors().getDefaultColor();
        errorColor = edittext.getResources().getColor(0x7f0d009b);
    }
}
