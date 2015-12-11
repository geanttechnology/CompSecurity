// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi, UpdateLogisticsPlanParams

public class UpdateLogisticsPlanNetLoader extends EbaySimpleNetLoader
{

    private final EbayCartApi api;
    private final String cartId;
    private final List paramList;

    public UpdateLogisticsPlanNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, UpdateLogisticsPlanParams updatelogisticsplanparams)
    {
        super(ebaycontext);
        api = ebaycartapi;
        cartId = s;
        paramList = new ArrayList();
        paramList.add(updatelogisticsplanparams);
    }

    public UpdateLogisticsPlanNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, List list)
    {
        super(ebaycontext);
        api = ebaycartapi;
        cartId = s;
        paramList = list;
    }

    protected EbayRequest createRequest()
    {
        return new UpdateLogisticsPlan.UpdateLogisticsPlanRequest(api, cartId, paramList);
    }

    public boolean isServiceError()
    {
        return false;
    }
}
