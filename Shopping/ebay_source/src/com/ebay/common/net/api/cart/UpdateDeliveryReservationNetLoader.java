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

public class UpdateDeliveryReservationNetLoader extends EbaySimpleNetLoader
{

    private final EbayCartApi api;
    private final String cartId;
    private final String deliveryInstructions;
    private final List logisticsPlanOptionIds;
    private final String reservationToken;

    public UpdateDeliveryReservationNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, String s1, List list, String s2, String s3)
    {
        super(ebaycontext);
        api = ebaycartapi;
        cartId = s;
        logisticsPlanOptionIds = list;
        reservationToken = s2;
        deliveryInstructions = s3;
    }

    protected EbayRequest createRequest()
    {
        return new UpdateDeliveryReservation.UpdateDeliveryReservationRequest(api, cartId, logisticsPlanOptionIds, reservationToken, deliveryInstructions);
    }

    public boolean isServiceError()
    {
        return false;
    }
}
