// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import com.target.mothership.common.tender.a;

// Referenced classes of package com.target.mothership.common.params:
//            AddressParams

public class b
{

    private String mAddressId;
    private AddressParams mAddressParams;
    private String mCardName;
    private String mCardNickname;
    private String mCardNumber;
    private a mCardType;
    private String mExpiryMonth;
    private int mExpiryYear;
    private boolean mSetAsDefault;
    private boolean mSkipAddressValidation;

    protected b(a a1, String s, String s1, int k, String s2, boolean flag, AddressParams addressparams, 
            boolean flag1, String s3)
    {
        a(a1, s, s2, flag, addressparams, flag1, s3);
        mExpiryMonth = s1;
        mExpiryYear = k;
    }

    private b(a a1, String s, String s1, boolean flag, AddressParams addressparams, boolean flag1, String s2)
    {
        a(a1, s, s1, flag, addressparams, flag1, s2);
    }

    public static b a(String s, String s1, com.target.mothership.common.tender.b b1, int k, boolean flag, AddressParams addressparams, boolean flag1, String s2)
    {
        return new b(a.VISA, s, b1.toString(), k, s1, flag, addressparams, flag1, s2);
    }

    public static b a(String s, String s1, boolean flag, AddressParams addressparams, boolean flag1, String s2)
    {
        return new b(a.TARGET_BUSINESS, s, s1, flag, addressparams, flag1, s2);
    }

    private void a(a a1, String s, String s1, boolean flag, AddressParams addressparams, boolean flag1, String s2)
    {
        mCardType = a1;
        mCardNumber = s;
        mCardName = s1;
        mAddressParams = addressparams;
        mSkipAddressValidation = flag1;
        mCardNickname = s2;
        mSetAsDefault = flag;
    }

    public static b b(String s, String s1, com.target.mothership.common.tender.b b1, int k, boolean flag, AddressParams addressparams, boolean flag1, String s2)
    {
        return new b(a.MASTER_CARD, s, b1.toString(), k, s1, flag, addressparams, flag1, s2);
    }

    public static b b(String s, String s1, boolean flag, AddressParams addressparams, boolean flag1, String s2)
    {
        return new b(a.TARGET_RED_CARD, s, s1, flag, addressparams, flag1, s2);
    }

    public static b c(String s, String s1, com.target.mothership.common.tender.b b1, int k, boolean flag, AddressParams addressparams, boolean flag1, String s2)
    {
        return new b(a.AMEX, s, b1.toString(), k, s1, flag, addressparams, flag1, s2);
    }

    public static b c(String s, String s1, boolean flag, AddressParams addressparams, boolean flag1, String s2)
    {
        return new b(a.TARGET_CARD, s, s1, flag, addressparams, flag1, s2);
    }

    public static b d(String s, String s1, com.target.mothership.common.tender.b b1, int k, boolean flag, AddressParams addressparams, boolean flag1, String s2)
    {
        return new b(a.DISCOVER, s, b1.toString(), k, s1, flag, addressparams, flag1, s2);
    }

    public static b d(String s, String s1, boolean flag, AddressParams addressparams, boolean flag1, String s2)
    {
        return new b(a.TARGET_DEBIT, s, s1, flag, addressparams, flag1, s2);
    }

    public static b e(String s, String s1, com.target.mothership.common.tender.b b1, int k, boolean flag, AddressParams addressparams, boolean flag1, String s2)
    {
        return new b(a.TARGET_VISA, s, b1.toString(), k, s1, flag, addressparams, flag1, s2);
    }

    public static b f(String s, String s1, com.target.mothership.common.tender.b b1, int k, boolean flag, AddressParams addressparams, boolean flag1, String s2)
    {
        return new b(a.TARGET_MASTERCARD, s, b1.toString(), k, s1, flag, addressparams, flag1, s2);
    }

    public a a()
    {
        return mCardType;
    }

    public String b()
    {
        return mCardNumber;
    }

    public String c()
    {
        return mCardName;
    }

    public String d()
    {
        return mAddressId;
    }

    public AddressParams e()
    {
        return mAddressParams;
    }

    public boolean f()
    {
        return mSetAsDefault;
    }

    public boolean g()
    {
        return mSkipAddressValidation;
    }

    public String h()
    {
        return mCardNickname;
    }

    public String i()
    {
        return mExpiryMonth;
    }

    public int j()
    {
        return mExpiryYear;
    }
}
