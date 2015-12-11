// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.target.ui.view.account:
//            ForgotPasswordInputView

private final class <init>
    implements TextWatcher
{

    final ForgotPasswordInputView this$0;

    public void afterTextChanged(Editable editable)
    {
        if (ForgotPasswordInputView.c(ForgotPasswordInputView.this))
        {
            ForgotPasswordInputView.d(ForgotPasswordInputView.this);
            return;
        } else
        {
            ForgotPasswordInputView.e(ForgotPasswordInputView.this);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ()
    {
        this$0 = ForgotPasswordInputView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
