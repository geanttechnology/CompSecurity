// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;


// Referenced classes of package com.paypal.android.sdk.payments:
//            bd, bh, LoginActivity

final class aj
    implements bd
{

    private LoginActivity a;

    aj(LoginActivity loginactivity)
    {
        a = loginactivity;
        super();
    }

    public final void a(bh bh1)
    {
        if (bh1.b())
        {
            LoginActivity.j(a);
            return;
        } else
        {
            LoginActivity.a(a, bh1.b);
            return;
        }
    }

    public final void a(Object obj)
    {
        LoginActivity.i(a);
    }
}
