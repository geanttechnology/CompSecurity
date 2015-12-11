// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.net.api.ecas.EcasApiContext;
import com.ebay.nautilus.domain.net.api.ecas.EcasApiRequest;
import com.ebay.nautilus.domain.net.api.ecas.MoveItemFromCartToSaveForLaterRequest;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            EcasShoppingCartDataManager

public final class shoppingCartItemId extends shoppingCartItemId
{

    private final long shoppingCartItemId;
    final EcasShoppingCartDataManager this$0;

    protected EcasApiRequest createRequest()
    {
        return new MoveItemFromCartToSaveForLaterRequest(ecasApiContext, shoppingCartItemId);
    }

    public (EcasApiContext ecasapicontext, EbayShoppingApi ebayshoppingapi, long l, String s, String s1, 
             )
    {
        this$0 = EcasShoppingCartDataManager.this;
        super(EcasShoppingCartDataManager.this, _LATER, ecasapicontext, ebayshoppingapi, s, Long.toString(l), , s1);
        shoppingCartItemId = l;
    }
}
