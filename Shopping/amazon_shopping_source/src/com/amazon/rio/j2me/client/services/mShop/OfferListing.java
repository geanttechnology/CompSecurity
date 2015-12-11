// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            BasicOfferListing, ExtraOfferListing, PrimeOneClickShippingOffers

public class OfferListing
{

    private BasicOfferListing basicOffer;
    private ExtraOfferListing extraOffer;
    private PrimeOneClickShippingOffers primeOneClickShippingOffers;

    public OfferListing()
    {
    }

    public BasicOfferListing getBasicOffer()
    {
        return basicOffer;
    }

    public ExtraOfferListing getExtraOffer()
    {
        return extraOffer;
    }

    public PrimeOneClickShippingOffers getPrimeOneClickShippingOffers()
    {
        return primeOneClickShippingOffers;
    }

    public void setBasicOffer(BasicOfferListing basicofferlisting)
    {
        basicOffer = basicofferlisting;
    }

    public void setExtraOffer(ExtraOfferListing extraofferlisting)
    {
        extraOffer = extraofferlisting;
    }

    public void setPrimeOneClickShippingOffers(PrimeOneClickShippingOffers primeoneclickshippingoffers)
    {
        primeOneClickShippingOffers = primeoneclickshippingoffers;
    }
}
