// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            ShippingAddressLATAM

public class 
{

    public static void inject(com.f2prateek.dart.r r, ShippingAddressLATAM shippingaddresslatam, Object obj)
    {
        ect(r, shippingaddresslatam, obj);
        r = ((com.f2prateek.dart.nject) (r.nject(obj, "dealId")));
        if (r != null)
        {
            shippingaddresslatam.dealId = (String)r;
        }
    }

    public ()
    {
    }
}
