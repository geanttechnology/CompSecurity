// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.content.Intent;
import android.net.Uri;
import com.paypal.android.sdk.ct;
import com.paypal.android.sdk.dd;
import com.paypal.android.sdk.o;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk.payments:
//            co, PayPalConfiguration, PayPalOAuthScopes, c

class ax extends co
{

    private boolean a;

    ax(Intent intent, PayPalConfiguration paypalconfiguration, boolean flag)
    {
        super(intent, paypalconfiguration);
        a = flag;
    }

    private static boolean a(String s)
    {
        try
        {
            new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    boolean a()
    {
        boolean flag;
        boolean flag3 = dd.c(d().k());
        a(flag3, "merchantName");
        boolean flag1;
        boolean flag2;
        if (d().l() != null && dd.a(b(), d().l().toString(), "merchantPrivacyPolicyUrl") && a(d().l().toString()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        a(flag1, "merchantPrivacyPolicyUrl");
        if (d().m() != null && dd.a(b(), d().m().toString(), "merchantUserAgreementUrl") && a(d().m().toString()))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        a(flag2, "merchantUserAgreementUrl");
        if (!a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (a)
        {
            Object obj = (PayPalOAuthScopes)c().getParcelableExtra("com.paypal.android.sdk.requested_scopes");
            if (obj == null)
            {
                flag = false;
            } else
            if (((PayPalOAuthScopes) (obj)).a() == null || ((PayPalOAuthScopes) (obj)).a().size() <= 0)
            {
                flag = false;
            } else
            {
label0:
                {
                    obj = ((PayPalOAuthScopes) (obj)).a().iterator();
                    String s;
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break label0;
                        }
                        s = (String)((Iterator) (obj)).next();
                    } while (o.i.contains(s) || ct.i.contains(s));
                    flag = false;
                }
            }
        }
_L1:
        a(flag, "paypalScopes");
        return flag3 && flag1 && flag2 && flag;
        flag = true;
          goto _L1
    }

    protected String b()
    {
        return com/paypal/android/sdk/payments/c.getSimpleName();
    }
}
