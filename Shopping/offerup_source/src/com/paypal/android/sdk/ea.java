// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            dz

public final class ea extends Enum
{

    private static final ea B[];
    public static final ea a;
    public static final ea b;
    public static final ea c;
    public static final ea d;
    public static final ea e;
    public static final ea f;
    public static final ea g;
    public static final ea h;
    public static final ea i;
    public static final ea j;
    public static final ea k;
    public static final ea l;
    public static final ea m;
    public static final ea n;
    public static final ea o;
    public static final ea p;
    public static final ea q;
    private static ea r;
    private static ea s;
    private static ea t;
    private static ea u;
    private static ea v;
    private static ea w;
    private boolean A;
    private String x;
    private String y;
    private boolean z;

    private ea(String s1, int i1, String s2, String s3, boolean flag, boolean flag1)
    {
        super(s1, i1);
        x = s2;
        y = s3;
        z = flag;
        A = flag1;
    }

    public static ea valueOf(String s1)
    {
        return (ea)Enum.valueOf(com/paypal/android/sdk/ea, s1);
    }

    public static ea[] values()
    {
        return (ea[])B.clone();
    }

    public final String a()
    {
        return (new StringBuilder()).append(x).append("::").append(y).toString();
    }

    public final String a(String s1, boolean flag)
    {
        String s2;
        if (z)
        {
            if (flag)
            {
                s2 = "returnuser";
            } else
            {
                s2 = "newuser";
            }
        } else
        {
            s2 = "";
        }
        return (new StringBuilder()).append(dz.a).append(":").append(s1).append(":").append(s2).toString();
    }

    public final boolean b()
    {
        return A;
    }

    static 
    {
        a = new ea("PreConnect", 0, "preconnect", "", false, false);
        b = new ea("DeviceCheck", 1, "devicecheck", "", false, false);
        r = new ea("PaymentMethodWindow", 2, "selectpaymentmethod", "", false, false);
        s = new ea("PaymentMethodCancel", 3, "selectpaymentmethod", "cancel", false, true);
        t = new ea("SelectPayPalPayment", 4, "selectpaymentmethod", "paypal", false, true);
        u = new ea("SelectCreditCardPayment", 5, "selectpaymentmethod", "card", false, true);
        v = new ea("ConfirmPaymentWindow", 6, "confirmpayment", "", false, false);
        c = new ea("ConfirmPayment", 7, "confirmpayment", "confirm", false, false);
        w = new ea("ConfirmPaymentCancel", 8, "confirmpayment", "cancel", false, true);
        d = new ea("PaymentSuccessful", 9, "paymentsuccessful", "", false, false);
        e = new ea("LoginWindow", 10, "login", "password", true, false);
        f = new ea("LoginPassword", 11, "login", "password", true, true);
        g = new ea("LoginPIN", 12, "login", "PIN", true, true);
        h = new ea("SignUp", 13, "login", "password", true, true);
        i = new ea("LoginForgotPassword", 14, "login", "password", true, true);
        j = new ea("LoginCancel", 15, "login", "cancel", true, true);
        k = new ea("ConsentWindow", 16, "authorizationconsent", "", false, false);
        l = new ea("ConsentAgree", 17, "authorizationconsent", "agree", false, true);
        m = new ea("ConsentCancel", 18, "authorizationconsent", "cancel", false, true);
        n = new ea("ConsentMerchantUrl", 19, "authorizationconsent", "merchanturl", false, true);
        o = new ea("ConsentPayPalPrivacyUrl", 20, "authorizationconsent", "privacy", false, true);
        p = new ea("AuthorizationSuccessful", 21, "authorizationsuccessful", "", false, false);
        q = new ea("LegalTextWindow", 22, "legaltext", "", false, false);
        B = (new ea[] {
            a, b, r, s, t, u, v, c, w, d, 
            e, f, g, h, i, j, k, l, m, n, 
            o, p, q
        });
    }
}
