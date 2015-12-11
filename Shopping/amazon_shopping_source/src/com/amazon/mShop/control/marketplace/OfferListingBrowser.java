// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.marketplace;

import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.customclientfields.CustomClientFields;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.OfferListing;
import com.amazon.rio.j2me.client.services.mShop.OfferListingsRequest;
import com.amazon.rio.j2me.client.services.mShop.OfferListingsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.PrimeOneClickStatus;

public final class OfferListingBrowser extends PagedListingBrowser
    implements OfferListingsResponseListener
{

    private final String asin;
    private String conditionType;
    private final String requestId;

    public OfferListingBrowser(int i, int j, String s, String s1)
    {
        super(i, j);
        asin = s;
        requestId = s1;
    }

    public void receivedOfferListing(OfferListing offerlisting, int i, ServiceCall servicecall)
    {
        objectReceived(offerlisting, i, servicecall);
    }

    public void receivedPrimeOneClickStatus(final PrimeOneClickStatus value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final OfferListingBrowser this$0;
            final PrimeOneClickStatus val$value;

            public void run()
            {
                User.setPrimeOneClickStatus(value);
            }

            
            {
                this$0 = OfferListingBrowser.this;
                value = primeoneclickstatus;
                super();
            }
        });
    }

    public void setConditionType(String s)
    {
        conditionType = s;
    }

    protected ServiceCall startPageRequest(int i)
    {
        OfferListingsRequest offerlistingsrequest = new OfferListingsRequest();
        offerlistingsrequest.setAsin(asin);
        offerlistingsrequest.setPage(i + 1);
        offerlistingsrequest.setSize(pageSize);
        offerlistingsrequest.setConditionType(conditionType);
        CustomClientFields.setCustomHeaderFields("offer_listings_v32", true, requestId);
        return ServiceController.getMShopService().offerListings(offerlistingsrequest, this);
    }
}
