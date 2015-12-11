// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.target.mothership.util.o;
import com.target.ui.view.CustomErrorViewWrapper;

// Referenced classes of package com.target.ui.view.checkout:
//            GiftCardInputView

private final class <init>
    implements TextWatcher
{

    final GiftCardInputView this$0;

    public void afterTextChanged(Editable editable)
    {
        if (o.c(editable.toString()))
        {
            GiftCardInputView.a(GiftCardInputView.this).gcLastDigits.setSelection(GiftCardInputView.a(GiftCardInputView.this).gcLastDigits.length());
            GiftCardInputView.a(GiftCardInputView.this).gcLastDigits.requestFocus();
        }
        if (GiftCardInputView.a(GiftCardInputView.this).gcInputWrapper.a())
        {
            GiftCardInputView.a(GiftCardInputView.this).gcInputWrapper.b();
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (charsequence.length() == 8)
        {
            GiftCardInputView.f(GiftCardInputView.this);
            return;
        } else
        {
            GiftCardInputView.a(GiftCardInputView.this).redeemButton.setEnabled(false);
            return;
        }
    }

    private ews()
    {
        this$0 = GiftCardInputView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
