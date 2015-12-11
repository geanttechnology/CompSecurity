// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;

// Referenced classes of package com.target.ui.view.account:
//            AccountCredentialsInputView

class this._cls0
    implements android.view.lsInputView._cls1
{

    final AccountCredentialsInputView this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (!flag)
        {
            AccountCredentialsInputView.a(AccountCredentialsInputView.this);
        }
    }

    ()
    {
        this$0 = AccountCredentialsInputView.this;
        super();
    }
}
