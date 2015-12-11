// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;

// Referenced classes of package com.target.ui.view.account:
//            AccountExternalLaunchView

private class <init>
    implements android.view.lLaunchView.b
{

    final AccountExternalLaunchView this$0;

    public void onClick(View view)
    {
        if (AccountExternalLaunchView.a(AccountExternalLaunchView.this) == null)
        {
            return;
        }
        switch (view.getId())
        {
        default:
            return;

        case 2131755706: 
            AccountExternalLaunchView.a(AccountExternalLaunchView.this).a();
            return;

        case 2131755707: 
            AccountExternalLaunchView.a(AccountExternalLaunchView.this).b();
            break;
        }
    }

    private ()
    {
        this$0 = AccountExternalLaunchView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
