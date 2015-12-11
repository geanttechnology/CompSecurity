// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.target.ui.view.account:
//            ForgotPasswordInputView

class this._cls0
    implements android.widget.tener
{

    final ForgotPasswordInputView this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            ForgotPasswordInputView.a(ForgotPasswordInputView.this);
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = ForgotPasswordInputView.this;
        super();
    }
}
