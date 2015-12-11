// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.text.Editable;
import com.target.ui.k.b;

// Referenced classes of package com.target.ui.view.account:
//            AccountCreationEmailView

private final class <init> extends b
{

    final AccountCreationEmailView this$0;
    private boolean wasValid;

    public void a(Editable editable)
    {
        boolean flag = AccountCreationEmailView.c(AccountCreationEmailView.this);
        if (wasValid != flag)
        {
            AccountCreationEmailView.a(AccountCreationEmailView.this, flag);
        }
        com.target.ui.view.account.AccountCreationEmailView.b(AccountCreationEmailView.this, flag);
    }

    public void a(CharSequence charsequence, int i, int j, int k)
    {
        wasValid = AccountCreationEmailView.c(AccountCreationEmailView.this);
    }

    public void b(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ()
    {
        this$0 = AccountCreationEmailView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
