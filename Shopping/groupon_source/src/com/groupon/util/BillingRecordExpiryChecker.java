// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.models.billingrecord.BillingRecord;
import java.util.Calendar;

public class BillingRecordExpiryChecker
{

    private final int currentMonth;
    private final int currentYear;

    private BillingRecordExpiryChecker()
    {
        Calendar calendar = Calendar.getInstance();
        currentMonth = calendar.get(2) + 1;
        currentYear = calendar.get(1);
    }

    public BillingRecordExpiryChecker(int i, int j)
    {
        currentMonth = i;
        currentYear = j;
    }

    public boolean isBillingRecordExpired(BillingRecord billingrecord)
    {
        if (billingrecord != null)
        {
            Integer integer = billingrecord.expirationMonth;
            billingrecord = billingrecord.expirationYear;
            if (integer != null && billingrecord != null && (billingrecord.intValue() < currentYear || billingrecord.intValue() == currentYear && integer.intValue() < currentMonth))
            {
                return true;
            }
        }
        return false;
    }
}
