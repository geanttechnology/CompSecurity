// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.a;

import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.tender.a;
import com.target.mothership.services.k;
import java.util.List;

public class c extends k
{

    private String mAddressLine1;
    private String mAddressLine2;
    private String mCardName;
    private String mCardNumber;
    private String mCardType;
    private String mCity;
    private String mConfirmEmail;
    private String mCountry;
    private String mCvv;
    private String mEmailId;
    private String mExpiryMonth;
    private String mExpiryYear;
    private String mFirstName;
    private String mLastName;
    private String mMemberCardInfoId;
    private String mMiddleName;
    private String mPhone;
    private String mPin;
    private String mSavedShippingAddress;
    private String mState;
    private String mZipCode;

    public c()
    {
    }

    public void a(AddressParams addressparams)
    {
        mFirstName = addressparams.f();
        mLastName = addressparams.h();
        List list = addressparams.a();
        mAddressLine1 = (String)addressparams.a().get(0);
        if (list.size() > 1)
        {
            mAddressLine2 = (String)list.get(1);
        }
        mPhone = addressparams.i();
        mCity = addressparams.b();
        mState = addressparams.c();
        mCountry = addressparams.e();
        mZipCode = addressparams.d();
    }

    public void a(a a1, String s, String s1)
    {
        mCardType = a1.a();
        mCardNumber = s;
        mCardName = s1;
    }

    public void a(String s)
    {
        mMemberCardInfoId = s;
    }

    public void b(String s)
    {
        mExpiryMonth = s;
    }

    public void c(String s)
    {
        mExpiryYear = s;
    }

    public void d(String s)
    {
        mPin = s;
    }

    public void e(String s)
    {
        mCvv = s;
    }

    public void f(String s)
    {
        mSavedShippingAddress = s;
    }
}
