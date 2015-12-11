// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.models.billingrecord.BillingRecord;
import roboguice.util.Strings;

public class BillingRecordUtil
{

    private BillingRecordUtil()
    {
    }

    public String generateFormattedCardExpirationDate(int i, int j)
    {
        Object obj;
        if (j < 10)
        {
            obj = (new StringBuilder()).append("0").append(j).toString();
        } else
        {
            obj = Integer.valueOf(j);
        }
        obj = Strings.toString(obj);
        return (new StringBuilder()).append(((String) (obj))).append("/").append(Strings.toString(Integer.valueOf(i)).substring(2, 4)).toString();
    }

    public String getCreditCardLastDigits(BillingRecord billingrecord)
    {
        if (billingrecord != null)
        {
            billingrecord = billingrecord.cardNumber;
        } else
        {
            billingrecord = "";
        }
        if (Strings.notEmpty(billingrecord))
        {
            return billingrecord.substring(Math.max(0, billingrecord.length() - 4));
        } else
        {
            return "";
        }
    }
}
