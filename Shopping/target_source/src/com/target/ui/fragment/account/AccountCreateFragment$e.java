// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.view.View;
import com.target.ui.view.account.AccountCreationEmailView;
import com.target.ui.view.account.AccountCreationPasswordView;
import com.target.ui.view.account.b;
import com.target.ui.view.common.NameView;

// Referenced classes of package com.target.ui.fragment.account:
//            AccountCreateFragment

private final class <init>
    implements b
{

    final AccountCreateFragment this$0;

    public void a(View view, boolean flag)
    {
        int i = view.getId();
        if (i == com.target.ui.fragment.account.AccountCreateFragment.b(AccountCreateFragment.this).email.getId())
        {
            AccountCreateFragment.a(AccountCreateFragment.this, flag);
        } else
        {
            if (i == com.target.ui.fragment.account.AccountCreateFragment.b(AccountCreateFragment.this).name.getId())
            {
                com.target.ui.fragment.account.AccountCreateFragment.b(AccountCreateFragment.this, flag);
                return;
            }
            if (i == com.target.ui.fragment.account.AccountCreateFragment.b(AccountCreateFragment.this).password.getId())
            {
                AccountCreateFragment.c(AccountCreateFragment.this, flag);
                return;
            }
        }
    }

    private ews()
    {
        this$0 = AccountCreateFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
