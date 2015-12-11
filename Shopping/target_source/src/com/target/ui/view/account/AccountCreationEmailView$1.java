// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.target.ui.view.account:
//            AccountCreationEmailView

class this._cls0
    implements android.view.onEmailView._cls1
{

    final AccountCreationEmailView this$0;

    public void onFocusChange(View view, boolean flag)
    {
        while (view.getId() != AccountCreationEmailView.a(AccountCreationEmailView.this).email.getId() || flag) 
        {
            return;
        }
        AccountCreationEmailView.b(AccountCreationEmailView.this);
    }

    ews()
    {
        this$0 = AccountCreationEmailView.this;
        super();
    }
}
