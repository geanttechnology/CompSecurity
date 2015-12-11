// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.a;

import com.google.b.f;
import com.target.mothership.b;
import com.target.mothership.common.params.AddressParams;
import com.target.mothership.model.common.c;
import com.target.mothership.services.k;

public class l extends k
{

    private static final String NO = "N";
    private static final int NULL_YEAR = 0;
    private static final String USER_ACTION_EDIT = "Edit";
    private static final String YES = "Y";
    private com.google.b.l mAddressLine;
    private String mCardName;
    private String mCardNumber;
    private String mCardType;
    private String mCity;
    private String mCountry;
    private String mCvv;
    private String mExistingAddressId;
    private String mExpiryMonth;
    private String mExpiryYear;
    private String mFirstName;
    private String mIsDefaultPayment;
    private String mLastName;
    private String mMiddleName;
    private String mPhone;
    private String mPhoneType;
    private String mSkipAddressValidation;
    private String mState;
    private String mTcPin;
    private String mUserAction;
    private String mZipCode;

    public l(boolean flag, AddressParams addressparams)
    {
        Object obj;
        if (flag)
        {
            obj = "Y";
        } else
        {
            obj = "N";
        }
        mIsDefaultPayment = ((String) (obj));
        mFirstName = addressparams.f();
        mMiddleName = addressparams.g();
        mLastName = addressparams.h();
        obj = addressparams.a();
        mAddressLine = b.a().k().a(obj);
        mCity = addressparams.b();
        mState = addressparams.c();
        mCountry = addressparams.e();
        mZipCode = addressparams.d();
        mPhone = addressparams.i();
        mPhoneType = a(addressparams.j());
        mUserAction = "Edit";
        mSkipAddressValidation = "Y";
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
}
