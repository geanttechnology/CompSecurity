// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.product;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.product:
//            GetProductDetailsRequest, EbayProductApi

public class GetProductDetailsLoader extends EbaySimpleNetLoader
{

    private final EbayProductApi api;
    private final String barcode;
    private final String barcodeType;

    public GetProductDetailsLoader(EbayContext ebaycontext, EbayProductApi ebayproductapi, String s, String s1)
    {
        super(ebaycontext);
        api = ebayproductapi;
        barcode = s;
        barcodeType = s1;
    }

    protected EbayRequest createRequest()
    {
        return new GetProductDetailsRequest(api.site, barcode, barcodeType);
    }

    public String getBarcode()
    {
        return barcode;
    }

    public String getBarcodeType()
    {
        return barcodeType;
    }
}
