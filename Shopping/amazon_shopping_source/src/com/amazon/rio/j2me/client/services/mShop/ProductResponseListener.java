// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import com.amazon.rio.j2me.client.services.ResponseListener;
import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            BasicOfferListing, BasicProductInfo, Dimension, WebLink, 
//            ExtraOfferListing, ExtraProductInfo, MultiImage, PrimeOneClickShippingOffers, 
//            PrimeOneClickStatus, Savings, VariationProductInfo, VisualBucket

public interface ProductResponseListener
    extends ResponseListener
{

    public abstract void aboutToReceiveArrayOfSize(int i, ServiceCall servicecall);

    public abstract void completed(ServiceCall servicecall);

    public abstract void receivedBasicOffer(BasicOfferListing basicofferlisting, ServiceCall servicecall);

    public abstract void receivedBasicProduct(BasicProductInfo basicproductinfo, ServiceCall servicecall);

    public abstract void receivedDealId(String s, ServiceCall servicecall);

    public abstract void receivedDimension(Dimension dimension, int i, ServiceCall servicecall);

    public abstract void receivedExternalBuyLink(WebLink weblink, ServiceCall servicecall);

    public abstract void receivedExtraOffer(ExtraOfferListing extraofferlisting, ServiceCall servicecall);

    public abstract void receivedExtraProduct(ExtraProductInfo extraproductinfo, ServiceCall servicecall);

    public abstract void receivedImage(byte abyte0[], ServiceCall servicecall);

    public abstract void receivedMultiImage(MultiImage multiimage, int i, ServiceCall servicecall);

    public abstract void receivedPrimeOneClickShippingOffers(PrimeOneClickShippingOffers primeoneclickshippingoffers, ServiceCall servicecall);

    public abstract void receivedPrimeOneClickStatus(PrimeOneClickStatus primeoneclickstatus, ServiceCall servicecall);

    public abstract void receivedSavings(Savings savings, ServiceCall servicecall);

    public abstract void receivedVariationProductInfo(VariationProductInfo variationproductinfo, int i, ServiceCall servicecall);

    public abstract void receivedVisualBucket(VisualBucket visualbucket, int i, ServiceCall servicecall);

    public abstract void receivedWebLink(WebLink weblink, int i, ServiceCall servicecall);
}
