// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.target.ui.fragment.account:
//            AccountLoginFragment

private class <init>
    implements com.target.ui.view.account.a
{

    final AccountLoginFragment this$0;

    public void a()
    {
        AccountLoginFragment.b(AccountLoginFragment.this);
    }

    public void a(String s)
    {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse((new StringBuilder()).append("tel:").append(s).toString()));
        startActivity(intent);
    }

    private ()
    {
        this$0 = AccountLoginFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
