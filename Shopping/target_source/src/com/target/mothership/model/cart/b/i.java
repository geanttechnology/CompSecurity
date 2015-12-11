// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.b;

import com.target.mothership.common.params.AddressParams;
import java.util.List;

public class i
{

    private AddressParams mAddressParams;
    private List mShippingDetailsAddressParams;
    private Boolean mSkipAddressValidation;

    public i(AddressParams addressparams, List list, Boolean boolean1)
    {
        mAddressParams = addressparams;
        mShippingDetailsAddressParams = list;
        mSkipAddressValidation = boolean1;
    }

    public AddressParams a()
    {
        return mAddressParams;
    }

    public List b()
    {
        return mShippingDetailsAddressParams;
    }

    public Boolean c()
    {
        return mSkipAddressValidation;
    }
}
