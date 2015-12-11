// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.favseller;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

public class GetFavSellersNetLoader extends EbaySimpleNetLoader
{

    private final String clientVersion;
    private final String iafToken;
    private final EbaySite site;

    public GetFavSellersNetLoader(EbayContext ebaycontext, String s, EbaySite ebaysite, String s1)
    {
        super(ebaycontext);
        iafToken = s;
        site = ebaysite;
        clientVersion = s1;
    }

    protected EbayRequest createRequest()
    {
        return new GetFavoriteSellers.GetRequest(iafToken, site, clientVersion);
    }
}
