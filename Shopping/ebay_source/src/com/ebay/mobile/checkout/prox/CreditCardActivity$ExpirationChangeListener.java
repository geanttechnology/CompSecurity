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
            if (!TextUtils.isEmpty(editable))
            {
                safeSetTextAfterTextChanged(com.ebay.nautilus.domain.data.safeSetTextAfterTextChanged(editable));
                if (com.ebay.nautilus.domain.data.safeSetTextAfterTextChanged(editable))
                {
                    if (com.ebay.nautilus.domain.data.safeSetTextAfterTextChanged(editable))
                    {
                        watchedView.setTextColor(baseColor);
                        CreditCardActivity.access$400(CreditCardActivity.this, CreditCardActivity.access$200(CreditCardActivity.this));
                        return;
                    } else
                    {
                        watchedView.setTextColor(errorColor);
                        return;
                    }
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
