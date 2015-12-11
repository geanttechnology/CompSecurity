// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.target.mothership.util.o;
import com.target.ui.util.d.b;
import com.target.ui.view.CustomErrorViewWrapper;

// Referenced classes of package com.target.ui.view.checkout:
//            GiftCardInputView

private final class <init>
    implements TextWatcher
{

    String before;
    final GiftCardInputView this$0;

    public void afterTextChanged(Editable editable)
    {
        String s = editable.toString();
        if (!o.c(editable.toString()))
        {
            if (((com.target.ui.util.d.a.b) (editable = b.a(before, s))).wasFormattingNeeded)
            {
                GiftCardInputView.a(GiftCardInputView.this).gcEditText.setText(((com.target.ui.util.d.a.b) (editable)).formattingAppliedString);
                GiftCardInputView.a(GiftCardInputView.this).gcEditText.setSelection(GiftCardInputView.a(GiftCardInputView.this).gcEditText.length());
                return;
            }
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        before = charsequence.toString();
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (charsequence.length() == 0)
        {
            GiftCardInputView.a(GiftCardInputView.this).gcNumberWrapper.b();
        } else
        if (charsequence.length() == 19)
        {
            GiftCardInputView.a(GiftCardInputView.this, com.target.ui.view.checkout.GiftCardInputView.b(GiftCardInputView.this, b.d(charsequence.toString())));
            com.target.ui.view.checkout.GiftCardInputView.b(GiftCardInputView.this);
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
