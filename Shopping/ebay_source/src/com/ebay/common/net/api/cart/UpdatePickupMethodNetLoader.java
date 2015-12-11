// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi

public class UpdatePickupMethodNetLoader extends EbaySimpleNetLoader
{

    private final EbayCartApi api;
    private final String cartId;
    private final String cartLineItemId;
    private final List logisticsPlanOptionIds;
    private final com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type logisticsPlanType;
    private final String pickupStoreId;

    public UpdatePickupMethodNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, String s1, List list, String s2, com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type type)
    {
        super(ebaycontext);
        api = ebaycartapi;
        cartId = s;
        cartLineItemId = s1;
        logisticsPlanOptionIds = list;
        pickupStoreId = s2;
        logisticsPlanType = type;
    }

    protected EbayRequest createRequest()
    {
        return new UpdatePickupMethod.UpdatePickupMethodRequest(api, cartId, cartLineItemId, logisticsPlanOptionIds, pickupStoreId, logisticsPlanType);
    }

    public boolean isServiceError()
    {
        return false;
    }
}
