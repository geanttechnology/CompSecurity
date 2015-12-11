// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            CreditCardActivity

public final class <init> extends <init>
{

    final CreditCardActivity this$0;

    public void afterTextChanged(Editable editable)
    {
        Object obj;
        if (editable == watchedView.getText())
        {
            obj = CreditCardActivity.access$500(CreditCardActivity.this).getText().toString();
            editable = editable.toString();
            break MISSING_BLOCK_LABEL_30;
        }
_L1:
        return;
        if (!TextUtils.isEmpty(editable) && com.ebay.nautilus.domain.data.this._mth0(((String) (obj))) && com.ebay.nautilus.domain.data.this._mth0(((String) (obj))))
        {
            obj = com.ebay.nautilus.domain.data.this._mth0(((String) (obj)));
            if (editable.length() == ((com.ebay.nautilus.domain.data.this._cls0) (obj))._mth0())
            {
                CreditCardActivity.access$400(CreditCardActivity.this, CreditCardActivity.access$600(CreditCardActivity.this));
                return;
            }
        }
          goto _L1
    }

    public (EditText edittext)
    {
        this$0 = CreditCardActivity.this;
        super(edittext);
    }
}
