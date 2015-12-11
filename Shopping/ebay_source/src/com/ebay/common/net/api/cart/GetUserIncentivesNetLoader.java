// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi

public class GetUserIncentivesNetLoader extends EbaySimpleNetLoader
{

    private final EbayCartApi api;
    private final GetUserIncentives.UserIncentiveType type;

    public GetUserIncentivesNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, GetUserIncentives.UserIncentiveType userincentivetype)
    {
        super(ebaycontext);
        api = ebaycartapi;
        type = userincentivetype;
    }

    protected EbayRequest createRequest()
    {
        return new GetUserIncentives.GetUserIncentivesRequest(api, type);
    }

    public boolean isServiceError()
    {
        return false;
    }
}
