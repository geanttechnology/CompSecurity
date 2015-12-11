// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.details;

import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.details:
//            Seller, ToolTip

public class SellerBucket
{

    public Map actions;
    public List errors;
    public List lineItems;
    public List promotions;
    public Seller seller;
    public String sellerId;
    public ToolTip sellerMessageToolTip;

    public SellerBucket()
    {
    }
}
