// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.net.api.ecas.EcasApiContext;
import com.ebay.nautilus.domain.net.api.ecas.EcasApiRequest;
import com.ebay.nautilus.domain.net.api.ecas.GetAndValidateShoppingCartByUserIdRequest;
import com.ebay.nautilus.domain.net.api.ecas.GetShoppingCartByUserIdRequest;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            EcasShoppingCartDataManager

public class  extends 
{

    final EcasShoppingCartDataManager this$0;

    protected EcasApiRequest createRequest()
    {
        if (action.action)
        {
            return new GetAndValidateShoppingCartByUserIdRequest(ecasApiContext);
        } else
        {
            return new GetShoppingCartByUserIdRequest(ecasApiContext);
        }
    }

    public a(EcasApiContext ecasapicontext, EbayShoppingApi ebayshoppingapi, String s, String s1, boolean flag, a a)
    {
        this$0 = EcasShoppingCartDataManager.this;
        a a1;
        if (flag)
        {
            a1 = ;
        } else
        {
            a1 = ;
        }
        super(EcasShoppingCartDataManager.this, a1, ecasapicontext, ebayshoppingapi, s, null, a, s1);
    }
}
