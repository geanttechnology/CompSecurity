// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;


final class cm extends Enum
{

    public static final cm a;
    public static final cm b;
    public static final cm c;
    public static final cm d;
    public static final cm e;
    public static final cm f;
    public static final cm g;
    public static final cm h;
    public static final cm i;
    public static final cm j;
    public static final cm k;
    public static final cm l;
    public static final cm m;
    public static final cm n;
    public static final cm o;
    public static final cm p;
    public static final cm q;
    public static final cm r;
    public static final cm s;
    private static final cm t[];

    private cm(String s1, int i1)
    {
        super(s1, i1);
    }

    public static cm valueOf(String s1)
    {
        return (cm)Enum.valueOf(com/paypal/android/sdk/payments/cm, s1);
    }

    public static cm[] values()
    {
        return (cm[])t.clone();
    }

    static 
    {
        a = new cm("openid_connect", 0);
        b = new cm("oauth_fullname", 1);
        c = new cm("oauth_gender", 2);
        d = new cm("oauth_date_of_birth", 3);
        e = new cm("oauth_timezone", 4);
        f = new cm("oauth_locale", 5);
        g = new cm("oauth_language", 6);
        h = new cm("oauth_age_range", 7);
        i = new cm("oauth_account_verified", 8);
        j = new cm("oauth_account_type", 9);
        k = new cm("oauth_account_creation_date", 10);
        l = new cm("oauth_email", 11);
        m = new cm("oauth_street_address1", 12);
        n = new cm("oauth_street_address2", 13);
        o = new cm("oauth_city", 14);
        p = new cm("oauth_state", 15);
        q = new cm("oauth_country", 16);
        r = new cm("oauth_zip", 17);
        s = new cm("oauth_phone_number", 18);
        t = (new cm[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s
        });
    }
}
