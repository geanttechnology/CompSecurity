// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import com.target.mothership.model.h;
import com.target.mothership.services.x;

// Referenced classes of package com.target.ui.fragment.account:
//            ForgotPasswordDialog

class this._cls0 extends h
{

    final ForgotPasswordDialog this$0;

    public String a()
    {
        return ForgotPasswordDialog.TAG;
    }

    public void a(x x1)
    {
        if (ForgotPasswordDialog.c(ForgotPasswordDialog.this) == null || ForgotPasswordDialog.d(ForgotPasswordDialog.this) == null)
        {
            return;
        } else
        {
            ForgotPasswordDialog.a(ForgotPasswordDialog.this, false);
            ForgotPasswordDialog.d(ForgotPasswordDialog.this)._mth0(ForgotPasswordDialog.e(ForgotPasswordDialog.this));
            dismiss();
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((Void)obj);
    }

    public void a(Void void1)
    {
        if (ForgotPasswordDialog.c(ForgotPasswordDialog.this) == null || ForgotPasswordDialog.d(ForgotPasswordDialog.this) == null)
        {
            return;
        } else
        {
            ForgotPasswordDialog.a(ForgotPasswordDialog.this, false);
            ForgotPasswordDialog.d(ForgotPasswordDialog.this)._mth0(ForgotPasswordDialog.e(ForgotPasswordDialog.this));
            dismiss();
            return;
        }
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    ()
    {
        this$0 = ForgotPasswordDialog.this;
        super();
    }
}
