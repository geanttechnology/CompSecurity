// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.error;


// Referenced classes of package com.groupon.models.error:
//            GrouponException

public class OrderException extends GrouponException
{

    public String amount;
    public boolean failedBillingRecordRevalidation;
    public boolean invalidMaxItemQuantity;
    public String inventoryUnavailable;
    public boolean requiredBillingRecordRevalidation;
    public String taxAmountChanged;
    public String travelSegmentIdExpired;

    public OrderException(int i, String s)
    {
        super(i, s);
    }
}
