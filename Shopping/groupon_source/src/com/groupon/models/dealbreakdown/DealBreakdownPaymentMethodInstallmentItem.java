// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.dealbreakdown;

import com.groupon.models.GenericAmount;

public class DealBreakdownPaymentMethodInstallmentItem
{

    public GenericAmount amount;
    public int numberOfPayments;
    public String periodOfPayment;
    public GenericAmount totalAmount;

    public DealBreakdownPaymentMethodInstallmentItem()
    {
    }
}
