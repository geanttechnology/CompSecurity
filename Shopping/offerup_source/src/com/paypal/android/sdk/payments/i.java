// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.cn;
import com.paypal.android.sdk.dd;
import com.paypal.android.sdk.dt;
import com.paypal.android.sdk.ex;
import com.paypal.android.sdk.f;

class i
{

    i()
    {
    }

    static String a()
    {
        String s = cn.a().c().a();
        if (dd.b(s) || s.equalsIgnoreCase("US"))
        {
            return "https://www.paypal.com/webapps/accountrecovery/passwordrecovery";
        } else
        {
            String s1 = ex.c(s);
            return String.format("https://www.paypal.com/%s/cgi-bin/webscr?cmd=_account-recovery&from=%s&locale.x=%s", new Object[] {
                s.toLowerCase(), "PayPalMPL", s1
            });
        }
    }

    static 
    {
        com/paypal/android/sdk/payments/i.getSimpleName();
    }
}
