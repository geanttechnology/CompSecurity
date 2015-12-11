// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            CustomerReviewsInfo, SimilarItemsResponse

public class ExtraProductInfo
{

    private CustomerReviewsInfo customerReviewsInfo;
    private List descs;
    private List details;
    private List offerListSummaries;
    private List offers;
    private List productMessages;
    private List productWarnings;
    private SimilarItemsResponse similarItems;
    private List trackListings;
    private List videoClips;

    public ExtraProductInfo()
    {
    }

    public List getOfferListSummaries()
    {
        return offerListSummaries;
    }

    public void setCustomerReviewsInfo(CustomerReviewsInfo customerreviewsinfo)
    {
        customerReviewsInfo = customerreviewsinfo;
    }

    public void setDescs(List list)
    {
        descs = list;
    }

    public void setDetails(List list)
    {
        details = list;
    }

    public void setOfferListSummaries(List list)
    {
        offerListSummaries = list;
    }

    public void setOffers(List list)
    {
        offers = list;
    }

    public void setProductMessages(List list)
    {
        productMessages = list;
    }

    public void setProductWarnings(List list)
    {
        productWarnings = list;
    }

    public void setSimilarItems(SimilarItemsResponse similaritemsresponse)
    {
        similarItems = similaritemsresponse;
    }

    public void setTrackListings(List list)
    {
        trackListings = list;
    }

    public void setVideoClips(List list)
    {
        videoClips = list;
    }
}
