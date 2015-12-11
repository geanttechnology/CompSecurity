// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.common;

import com.amazon.bluefront.api.common.TranslateToObfuscatedCustomerIdFrom;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

public class BluefrontCustomer
{

    private final String mCustomerId;
    private final TranslateToObfuscatedCustomerIdFrom mCustomerIdentiferType;

    public BluefrontCustomer(String s, TranslateToObfuscatedCustomerIdFrom translatetoobfuscatedcustomeridfrom)
    {
        boolean flag;
        if (!Strings.isNullOrEmpty(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "CustomerId cannot be null or empty");
        Preconditions.checkNotNull(translatetoobfuscatedcustomeridfrom, "Identifier type cannot be null");
        mCustomerId = s;
        mCustomerIdentiferType = translatetoobfuscatedcustomeridfrom;
    }

    public final String getCustomerId()
    {
        return mCustomerId;
    }

    public final TranslateToObfuscatedCustomerIdFrom getIdentifierType()
    {
        return mCustomerIdentiferType;
    }
}
