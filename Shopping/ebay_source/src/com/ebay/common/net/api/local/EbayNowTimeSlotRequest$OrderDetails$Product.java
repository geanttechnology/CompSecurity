// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;


// Referenced classes of package com.ebay.common.net.api.local:
//            EbayNowTimeSlotRequest

public static class quantity
{

    public final long id = 0L;
    public final String name;
    public final com.ebay.common.model.local.t price;
    public final int quantity;
    public final String sku;

    public (com.ebay.common.model.cart.ct ct)
    {
        name = ct.name;
        sku = ct.sku();
        price = new com.ebay.common.model.local.nit>(ct.init>);
        quantity = ct.quantity;
    }
}
