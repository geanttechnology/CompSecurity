// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.a;

import com.google.b.f;
import com.google.b.o;
import com.target.mothership.b;
import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.tender.a;
import com.target.mothership.model.common.c;
import com.target.mothership.services.k;

public abstract class h extends k
{

    private static final String DO_NOT_SET_AS_DEFAULT = "N";
    private static final String DO_NOT_SKIP_ADDRESS_VALIDATION = "N";
    private static final int NULL_YEAR = 0;
    private static final String SET_AS_DEAFULT = "Y";
    private static final String SKIP_ADDRESS_VALIDATION = "Y";
    private String mCardNickName;
    private boolean mIsDefaultPayment;
    private boolean mSkipAddressValidation;

    public h()
    {
        mIsDefaultPayment = true;
        mSkipAddressValidation = true;
        mCardNickName = null;
    }

    private static String a(c c1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$model$common$PhoneNumberType[];

            static 
            {
                $SwitchMap$com$target$mothership$model$common$PhoneNumberType = new int[c.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$model$common$PhoneNumberType[c.Home.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$common$PhoneNumberType[c.Mobile.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$common$PhoneNumberType[c.Work.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$model$common$PhoneNumberType[c.Other.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.model.common.PhoneNumberType[c1.ordinal()])
        {
        default:
            return "Other";

        case 1: // '\001'
            return "Home";

        case 2: // '\002'
            return "Mobile";

        case 3: // '\003'
            return "Work";
        }
    }

    protected void a(o o1, AddressParams addressparams)
    {
        f f1 = b.a().k();
        o1.a("firstName", addressparams.f());
        o1.a("middleName", addressparams.g());
        o1.a("lastName", addressparams.h());
        o1.a("addressLine", f1.a(addressparams.a()));
        o1.a("city", addressparams.b());
        o1.a("state", addressparams.c());
        o1.a("zipCode", addressparams.d());
        o1.a("phoneType", a(addressparams.j()));
        o1.a("phone", addressparams.i());
    }

    protected void a(o o1, com.target.mothership.common.params.b b1, String s)
    {
        o1.a("cardNumber", b1.b());
        o1.a("cardName", b1.c());
        o1.a("cardType", b1.a().a());
        o1.a("expiryMonth", b1.i());
        String s1;
        if (b1.j() != 0)
        {
            s1 = String.valueOf(b1.j());
        } else
        {
            s1 = null;
        }
        o1.a("expiryYear", s1);
        if (b1.g())
        {
            s1 = "Y";
        } else
        {
            s1 = "N";
        }
        o1.a("skipAddressValidation", s1);
        o1.a("cardNickName", b1.h());
        if (b1.f())
        {
            s1 = "Y";
        } else
        {
            s1 = "N";
        }
        o1.a("defaultPayment", s1);
        if (b1.a() == a.TARGET_DEBIT)
        {
            o1.a("tcPinNum", s);
            return;
        } else
        {
            o1.a("cvv", s);
            return;
        }
    }

    protected void a(o o1, String s)
    {
        o1.a("addressId", s);
    }
}
