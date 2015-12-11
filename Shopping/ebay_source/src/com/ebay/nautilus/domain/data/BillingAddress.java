// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;

public class BillingAddress extends BaseDataMapped
{

    public String city;
    public String countryCode;
    public String firstName;
    public String lastName;
    public String phone;
    public String postalCode;
    public String state;
    public String streetAddress;
    public String streetAddress2;

    public BillingAddress()
    {
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof BillingAddress)) goto _L2; else goto _L1
_L1:
        if (obj != this) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        if (TextUtils.equals(firstName, ((BillingAddress) (obj = (BillingAddress)obj)).firstName) && TextUtils.equals(lastName, ((BillingAddress) (obj)).lastName) && TextUtils.equals(streetAddress, ((BillingAddress) (obj)).streetAddress) && TextUtils.equals(streetAddress2, ((BillingAddress) (obj)).streetAddress2) && TextUtils.equals(city, ((BillingAddress) (obj)).city) && TextUtils.equals(state, ((BillingAddress) (obj)).state) && TextUtils.equals(postalCode, ((BillingAddress) (obj)).postalCode) && TextUtils.equals(countryCode, ((BillingAddress) (obj)).countryCode) && TextUtils.equals(phone, ((BillingAddress) (obj)).phone)) goto _L3; else goto _L2
_L2:
        return false;
    }

    public void setFirstLastNameFromFullNameString(String s)
    {
        s = s.trim();
        int i = s.lastIndexOf(" ");
        if (i == -1)
        {
            firstName = s;
            lastName = s;
            return;
        } else
        {
            firstName = s.substring(0, i);
            lastName = s.substring(i);
            return;
        }
    }
}
