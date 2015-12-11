// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.text.Editable;
import com.target.ui.k.b;
import com.target.ui.view.CustomErrorViewWrapper;

// Referenced classes of package com.target.ui.view.account:
//            AccountCredentialsInputView

private final class input extends b
{

    private CustomErrorViewWrapper input;
    final AccountCredentialsInputView this$0;
    private boolean wasValid;

    private void a(boolean flag)
    {
        if (AccountCredentialsInputView.c(AccountCredentialsInputView.this) != null)
        {
            AccountCredentialsInputView.c(AccountCredentialsInputView.this).a(AccountCredentialsInputView.this, flag);
        }
    }

    private void a(boolean flag, boolean flag1)
    {
        if (input.getId() == AccountCredentialsInputView.f(AccountCredentialsInputView.this).accountWrapper.getId())
        {
            AccountCredentialsInputView.a(AccountCredentialsInputView.this, flag);
        } else
        if (input.getId() == AccountCredentialsInputView.f(AccountCredentialsInputView.this).passwordWrapper.getId())
        {
            com.target.ui.view.account.AccountCredentialsInputView.b(AccountCredentialsInputView.this, flag1);
            return;
        }
    }

    public void a(Editable editable)
    {
        boolean flag1 = AccountCredentialsInputView.d(AccountCredentialsInputView.this);
        boolean flag2 = AccountCredentialsInputView.e(AccountCredentialsInputView.this);
        boolean flag;
        if (flag1 && flag2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag != wasValid)
        {
            a(flag);
        }
        wasValid = flag;
        a(flag2, flag1);
    }

    public void a(CharSequence charsequence, int i, int j, int k)
    {
        wasValid = d();
    }

    public void b(CharSequence charsequence, int i, int j, int k)
    {
    }

    public ews(CustomErrorViewWrapper customerrorviewwrapper)
    {
        this$0 = AccountCredentialsInputView.this;
        super();
        input = customerrorviewwrapper;
    }
}
