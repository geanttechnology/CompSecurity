// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            CreditCardActivity

public final class this._cls0 extends this._cls0
{

    final CreditCardActivity this$0;

    public void afterTextChanged(Editable editable)
    {
        if (editable == watchedView.getText())
        {
            editable = editable.toString();
            com.ebay.nautilus.domain.data.this._cls0 _lcls0 = com.ebay.nautilus.domain.data.watchedView(editable);
            if (_lcls0.watchedView() == 4)
            {
                CreditCardActivity.access$200(CreditCardActivity.this).setHint(0x7f0707f1);
            } else
            {
                CreditCardActivity.access$200(CreditCardActivity.this).setHint(0x7f0707f0);
            }
            setCurrentType(_lcls0);
            if (!TextUtils.isEmpty(editable))
            {
                int i = editable.length();
                String s = com.ebay.nautilus.domain.data.this._mth0(editable);
                if (i < s.length())
                {
                    safeSetTextAfterTextChanged(s);
                }
                if (com.ebay.nautilus.domain.data.safeSetTextAfterTextChanged(editable))
                {
                    if (com.ebay.nautilus.domain.data.safeSetTextAfterTextChanged(editable))
                    {
                        watchedView.setTextColor(baseColor);
                        CreditCardActivity.access$400(CreditCardActivity.this, CreditCardActivity.access$300(CreditCardActivity.this));
                        return;
                    } else
                    {
                        watchedView.setTextColor(errorColor);
                        return;
                    }
                }
                if (_lcls0 == com.ebay.nautilus.domain.data.errorColor || _lcls0 == com.ebay.nautilus.domain.data.errorColor)
                {
                    if (!editable.contains("\u2022"))
                    {
                        watchedView.setTextColor(errorColor);
                        return;
                    }
                } else
                {
                    watchedView.setTextColor(baseColor);
                    return;
                }
            }
        }
    }

    public (EditText edittext)
    {
        this$0 = CreditCardActivity.this;
        super(edittext);
    }
}
