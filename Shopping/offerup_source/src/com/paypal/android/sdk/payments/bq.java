// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.cn;
import com.paypal.android.sdk.dt;
import com.paypal.android.sdk.ex;
import com.paypal.android.sdk.f;

class bq
{

    bq()
    {
    }

    static String a()
    {
        String s = cn.a().c().a();
        return String.format("https://www.paypal.com/signup/account?country.x=%s&locale.x=%s", new Object[] {
            s, ex.c(s)
        });
    }

    static 
    {
        com/paypal/android/sdk/payments/bq.getSimpleName();
    }
}
