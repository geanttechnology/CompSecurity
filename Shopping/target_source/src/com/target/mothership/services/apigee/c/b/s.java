// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import com.target.mothership.common.product.CatEntryId;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.util.o;
import java.util.List;

public class s
{

    private static final String YES = "Y";
    private List mAttachments;
    private String mCatEntryIdString;
    private String mCurrency;
    private String mDeliveryDateString;
    private String mDpciString;
    private String mFulfillmentTypeString;
    private String mIsGiftCardString;
    private String mIsSelectedString;
    private String mName;
    private String mPartNumber;
    private String mPriceString;
    private String mQuantityString;

    public s()
    {
    }

    public CatEntryId a()
    {
        return new CatEntryId(mCatEntryIdString);
    }

    public String b()
    {
        return mName;
    }

    public Dpci c()
    {
        return new Dpci(mDpciString);
    }

    public Tcin d()
    {
        return new Tcin(mPartNumber);
    }

    public List e()
    {
        return mAttachments;
    }

    public String f()
    {
        return mDeliveryDateString;
    }

    public String g()
    {
        return mCurrency;
    }

    public String h()
    {
        return mPriceString;
    }

    public String i()
    {
        return mFulfillmentTypeString;
    }

    public boolean j()
    {
        return o.g(mIsGiftCardString) && "Y".equalsIgnoreCase(mIsGiftCardString);
    }

    public boolean k()
    {
        return Boolean.parseBoolean(mIsSelectedString);
    }

    public String l()
    {
        return mQuantityString;
    }
}
