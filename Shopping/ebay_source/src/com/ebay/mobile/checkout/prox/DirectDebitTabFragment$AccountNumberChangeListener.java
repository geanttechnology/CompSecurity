// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            DirectDebitTabFragment

public final class this._cls0 extends this._cls0
{

    final DirectDebitTabFragment this$0;

    public void afterTextChanged(Editable editable)
    {
        if (watchedView != null && editable == watchedView.getText())
        {
            editable = editable.toString();
            break MISSING_BLOCK_LABEL_23;
        }
        do
        {
            return;
        } while (TextUtils.isEmpty(editable) || editable.length() != 10);
        watchedView.setTextColor(baseColor);
        DirectDebitTabFragment.access$300(DirectDebitTabFragment.this, DirectDebitTabFragment.access$200(DirectDebitTabFragment.this));
    }

    public (EditText edittext)
    {
        this$0 = DirectDebitTabFragment.this;
        super(edittext);
    }
}
