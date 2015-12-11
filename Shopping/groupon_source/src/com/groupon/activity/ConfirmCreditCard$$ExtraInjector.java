// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            ConfirmCreditCard

public class 
{

    public static void inject(com.f2prateek.dart.r r, ConfirmCreditCard confirmcreditcard, Object obj)
    {
        Object obj1 = r.r(obj, "dealId");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'dealId' for field 'dealId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        confirmcreditcard.dealId = (String)obj1;
        obj1 = r.r(obj, "cc_four_digits");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'cc_four_digits' for field 'creditCardLastDigits' was not found. If this extra is optional add '@Optional' annotation.");
        }
        confirmcreditcard.creditCardLastDigits = (String)obj1;
        obj1 = r.tDigits(obj, "cc_type");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'cc_type' for field 'creditCardType' was not found. If this extra is optional add '@Optional' annotation.");
        }
        confirmcreditcard.creditCardType = (String)obj1;
        obj1 = r.e(obj, "cc_validation_state");
        if (obj1 != null)
        {
            confirmcreditcard.creditCardValidationState = (String)obj1;
        }
        r = ((com.f2prateek.dart.idationState) (r.idationState(obj, "isShippingAddressRequired")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'isShippingAddressRequired' for field 'isShippingAddressRequired' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            confirmcreditcard.isShippingAddressRequired = ((Boolean)r).booleanValue();
            return;
        }
    }

    public ()
    {
    }
}
