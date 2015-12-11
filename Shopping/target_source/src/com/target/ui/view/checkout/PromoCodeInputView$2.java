// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.text.Editable;
import android.text.TextWatcher;
import com.target.ui.view.CustomErrorViewWrapper;

// Referenced classes of package com.target.ui.view.checkout:
//            PromoCodeInputView

class this._cls0
    implements TextWatcher
{

    final PromoCodeInputView this$0;

    public void afterTextChanged(Editable editable)
    {
        PromoCodeInputView.b(PromoCodeInputView.this).promoCodeError.b();
        if (editable.length() == 0)
        {
            PromoCodeInputView.a(PromoCodeInputView.this, false);
            return;
        } else
        {
            PromoCodeInputView.a(PromoCodeInputView.this, true);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ews()
    {
        this$0 = PromoCodeInputView.this;
        super();
    }
}
