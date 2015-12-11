// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


// Referenced classes of package com.groupon.db.models:
//            Price, Option

public class ShippingOption
{

    public String name;
    protected Option parentOption;
    public Price price;
    public Long primaryKey;
    public String remoteId;

    public ShippingOption()
    {
        name = "";
    }

    public void setPrice(Price price1)
    {
        if (price1 != null)
        {
            price1.parentShippingOption = this;
        }
        price = price1;
    }
}
