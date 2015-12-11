// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.favseller;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.ArrayList;

public class AddFavSellerNetLoader extends EbaySimpleNetLoader
{

    private final String clientVersion;
    private final String iafToken;
    private final ArrayList savedSellers;
    private final ArrayList sellerNotes;
    private final EbaySite site;

    public AddFavSellerNetLoader(EbayContext ebaycontext, String s, EbaySite ebaysite, String s1, ArrayList arraylist, ArrayList arraylist1)
    {
        super(ebaycontext);
        iafToken = s;
        site = ebaysite;
        clientVersion = s1;
        savedSellers = arraylist;
        sellerNotes = arraylist1;
    }

    protected EbayRequest createRequest()
    {
        return new AddFavoriteSeller.AddRequest(iafToken, site, clientVersion, savedSellers, sellerNotes);
    }
}
