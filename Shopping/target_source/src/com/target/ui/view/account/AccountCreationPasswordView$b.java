// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.text.Editable;
import com.target.ui.k.b;
import com.target.ui.util.validation.a.f;

// Referenced classes of package com.target.ui.view.account:
//            AccountCreationPasswordView

private final class <init> extends b
{

    final AccountCreationPasswordView this$0;
    private boolean wasValid;

    public void a(Editable editable)
    {
        editable = com.target.ui.view.account.AccountCreationPasswordView.b(AccountCreationPasswordView.this);
        boolean flag = ((f) (editable)).isValid;
        if (wasValid != flag)
        {
            AccountCreationPasswordView.a(AccountCreationPasswordView.this, flag);
        }
        AccountCreationPasswordView.a(AccountCreationPasswordView.this, editable);
    }

    public void a(CharSequence charsequence, int i, int j, int k)
    {
        wasValid = com.target.ui.view.account.AccountCreationPasswordView.b(AccountCreationPasswordView.this).isValid;
    }

    public void b(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ()
    {
        this$0 = AccountCreationPasswordView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
