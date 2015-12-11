// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.api.ecas.AddItemToShoppingCartRequest;
import com.ebay.nautilus.domain.net.api.ecas.EcasApiContext;
import com.ebay.nautilus.domain.net.api.ecas.EcasApiRequest;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            EcasShoppingCartDataManager

public final class requestedQuantity extends requestedQuantity
{

    private final Long ebayItemId;
    private final int requestedQuantity;
    private final String storeLocationId;
    final EcasShoppingCartDataManager this$0;
    private final String variationId;

    protected EcasApiRequest createRequest()
    {
        return new AddItemToShoppingCartRequest(ecasApiContext, ebayItemId, variationId, storeLocationId, requestedQuantity);
    }

    public (EcasApiContext ecasapicontext, EbayShoppingApi ebayshoppingapi, Long long1, String s, String s1, int i, 
            String s2, String s3,  )
    {
        this$0 = EcasShoppingCartDataManager.this;
        super(EcasShoppingCartDataManager.this, init>, ecasapicontext, ebayshoppingapi, s2, TextUtils.concat(new CharSequence[] {
            Long.toString(long1.longValue()), "-", s
        }).toString(), , s3);
        ebayItemId = long1;
        variationId = s;
        storeLocationId = s1;
        requestedQuantity = i;
    }
}
