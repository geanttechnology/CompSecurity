// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            bm

public final class cp extends Enum
{

    public static final cp a;
    public static final cp b;
    public static final cp c;
    public static final cp d;
    public static final cp e;
    public static final cp f;
    public static final cp g;
    public static final cp h;
    private static cp i;
    private static cp j;
    private static cp k;
    private static cp l;
    private static final cp o[];
    private bm m;
    private String n;

    private cp(String s, int i1, bm bm1, String s1)
    {
        super(s, i1);
        m = bm1;
        n = s1;
    }

    public static cp valueOf(String s)
    {
        return (cp)Enum.valueOf(com/paypal/android/sdk/cp, s);
    }

    public static cp[] values()
    {
        return (cp[])o.clone();
    }

    final bm a()
    {
        return m;
    }

    final String b()
    {
        return n;
    }

    static 
    {
        a = new cp("FptiRequest", 0, bm.b, null);
        b = new cp("PreAuthRequest", 1, bm.b, "oauth2/token");
        c = new cp("LoginRequest", 2, bm.b, "oauth2/login");
        d = new cp("LoginChallengeRequest", 3, bm.b, "oauth2/login/challenge");
        e = new cp("ConsentRequest", 4, bm.b, "oauth2/consent");
        i = new cp("CreditCardPaymentRequest", 5, bm.b, "payments/payment");
        j = new cp("PayPalPaymentRequest", 6, bm.b, "payments/payment");
        k = new cp("CreateSfoPaymentRequest", 7, bm.b, "orchestration/msdk-create-sfo-payment");
        l = new cp("ApproveAndExecuteSfoPaymentRequest", 8, bm.b, "orchestration/msdk-approve-and-execute-sfo-payment");
        f = new cp("TokenizeCreditCardRequest", 9, bm.b, "vault/credit-card");
        g = new cp("DeleteCreditCardRequest", 10, bm.c, "vault/credit-card");
        h = new cp("GetAppInfoRequest", 11, bm.a, "apis/applications");
        o = (new cp[] {
            a, b, c, d, e, i, j, k, l, f, 
            g, h
        });
    }
}
