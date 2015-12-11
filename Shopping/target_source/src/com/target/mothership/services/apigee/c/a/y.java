// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.a;

import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.tender.a;
import com.target.mothership.services.k;
import java.util.List;

public class y extends k
{

    private String mAddressLine1;
    private String mAddressLine2;
    private String mCity;
    private String mCountry;
    private String mCvv;
    private String mFirstName;
    private String mLastName;
    private String mMiddleName;
    private String mPhone;
    private String mPin;
    private String mSavedShippingAddress;
    private String mState;
    private String mZipCode;

    public y(a a1, String s, AddressParams addressparams)
    {
        mFirstName = addressparams.f();
        mMiddleName = addressparams.g();
        mLastName = addressparams.h();
        List list = addressparams.a();
        if (list != null && !list.isEmpty())
        {
            mAddressLine1 = (String)list.get(0);
            if (list.size() > 1)
            {
                mAddressLine2 = (String)list.get(1);
            }
        }
        mCity = addressparams.b();
        mState = addressparams.c();
        mCountry = addressparams.e();
        mZipCode = addressparams.d();
        mPhone = addressparams.i();
        if (a1 == a.TARGET_DEBIT)
        {
            mPin = s;
            return;
        } else
        {
            mCvv = s;
            return;
        }
    }
}
