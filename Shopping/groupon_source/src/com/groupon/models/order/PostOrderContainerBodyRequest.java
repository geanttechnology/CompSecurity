// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.order;

import com.groupon.models.billingrecord.BillingRecord;
import java.util.List;

// Referenced classes of package com.groupon.models.order:
//            AddressDetail, GiftDetail

public class PostOrderContainerBodyRequest
{

    public AddressDetail addressDetails;
    public BillingRecord billingRecord;
    public GiftDetail giftDetails;
    public String id;
    public String iovationBlackbox;
    public List items;
    public String promoCode;
    public boolean useCart;
    public String userId;

    public PostOrderContainerBodyRequest()
    {
        billingRecord = new BillingRecord();
    }
}
