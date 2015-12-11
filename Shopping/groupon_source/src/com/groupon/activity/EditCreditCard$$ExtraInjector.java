// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import com.groupon.models.billingrecord.BillingRecord;

// Referenced classes of package com.groupon.activity:
//            EditCreditCard

public class 
{

    public static void inject(com.f2prateek.dart.r r, EditCreditCard editcreditcard, Object obj)
    {
        Object obj1 = r.r(obj, "available_cc_payment_methods_for_deal");
        if (obj1 != null)
        {
            editcreditcard.availableCCPaymentMethodsForDeal = (String[])(String[])obj1;
        }
        obj1 = r.ymentMethodsForDeal(obj, "next");
        if (obj1 != null)
        {
            editcreditcard.next = (Intent)obj1;
        }
        obj1 = r.ymentMethodsForDeal(obj, "CREDIT_CARD");
        if (obj1 != null)
        {
            editcreditcard.creditCard = (BillingRecord)obj1;
        }
        obj1 = r.ymentMethodsForDeal(obj, "dealId");
        if (obj1 != null)
        {
            editcreditcard.dealId = (String)obj1;
        }
        obj1 = r.ymentMethodsForDeal(obj, "cart_uuid");
        if (obj1 != null)
        {
            editcreditcard.cartUUID = (String)obj1;
        }
        obj1 = r.ymentMethodsForDeal(obj, "is_billing_record");
        if (obj1 != null)
        {
            editcreditcard.isBillingRecord = ((Boolean)obj1).booleanValue();
        }
        obj1 = r.rd(obj, "billingRecordId");
        if (obj1 != null)
        {
            editcreditcard.billingRecordId = (String)obj1;
        }
        obj1 = r.Id(obj, "billingRecordCity");
        if (obj1 != null)
        {
            editcreditcard.billingRecordCity = (String)obj1;
        }
        obj1 = r.City(obj, "billingRecordPostalCode");
        if (obj1 != null)
        {
            editcreditcard.billingRecordPostalCode = (String)obj1;
        }
        obj1 = r.PostalCode(obj, "billingRecordState");
        if (obj1 != null)
        {
            editcreditcard.billingRecordState = (String)obj1;
        }
        obj1 = r.State(obj, "billingRecordNumber");
        if (obj1 != null)
        {
            editcreditcard.billingRecordCardNumber = (String)obj1;
        }
        r = ((com.f2prateek.dart.CardNumber) (r.CardNumber(obj, "billingRecordStreetAddressOne")));
        if (r != null)
        {
            editcreditcard.billingRecordAddressOne = (String)r;
        }
    }

    public ()
    {
    }
}
