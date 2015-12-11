// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.view.View;
import android.widget.Button;
import com.target.ui.analytics.a.w;

// Referenced classes of package com.target.ui.fragment.account:
//            AccountLoginFragment

private class <init>
    implements com.target.ui.view.account.View.c
{

    final AccountLoginFragment this$0;

    public void a(View view, String s, String s1)
    {
        AccountLoginFragment.c(AccountLoginFragment.this);
        AccountLoginFragment.this.a(s, s1);
        w.j().e();
    }

    public void a(View view, boolean flag)
    {
        AccountLoginFragment.d(AccountLoginFragment.this).loginButton.setEnabled(flag);
    }

    private ews()
    {
        this$0 = AccountLoginFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
