// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.text.Editable;
import android.text.TextWatcher;
import com.target.mothership.util.o;
import com.target.ui.view.BackSpaceDetectorEditText;
import com.target.ui.view.CustomErrorViewWrapper;

// Referenced classes of package com.target.ui.view.checkout:
//            GiftCardInputView

private final class <init>
    implements TextWatcher
{

    final GiftCardInputView this$0;

    public void afterTextChanged(Editable editable)
    {
        editable = editable.toString();
        if (o.g(GiftCardInputView.c(GiftCardInputView.this)) && GiftCardInputView.c(GiftCardInputView.this).length() >= 3)
        {
            StringBuilder stringbuilder = new StringBuilder(GiftCardInputView.d(GiftCardInputView.this));
            stringbuilder.replace(GiftCardInputView.c(GiftCardInputView.this).length() - 3, GiftCardInputView.c(GiftCardInputView.this).length(), editable);
            GiftCardInputView.a(GiftCardInputView.this, stringbuilder.toString());
        }
        if (o.e(editable))
        {
            GiftCardInputView.b(GiftCardInputView.this, null);
            GiftCardInputView.e(GiftCardInputView.this);
        } else
        {
            if (GiftCardInputView.a(GiftCardInputView.this).gcInputWrapper.a())
            {
                GiftCardInputView.a(GiftCardInputView.this).gcInputWrapper.b();
            }
            if (editable.length() == 3)
            {
                GiftCardInputView.a(GiftCardInputView.this).gcAccessCode.requestFocus();
                return;
            }
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
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
