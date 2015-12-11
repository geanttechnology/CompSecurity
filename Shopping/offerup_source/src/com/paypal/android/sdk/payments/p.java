// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;


// Referenced classes of package com.paypal.android.sdk.payments:
//            bd, LoginActivity, bh

final class p
    implements bd
{

    private LoginActivity a;

    p(LoginActivity loginactivity)
    {
        a = loginactivity;
        super();
    }

    public final void a(bh bh)
    {
        LoginActivity.a(a, bh);
    }

    public final void a(Object obj)
    {
        LoginActivity.i(a);
    }
}
