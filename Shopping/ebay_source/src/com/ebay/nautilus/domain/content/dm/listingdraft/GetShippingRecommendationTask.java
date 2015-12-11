// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm.listingdraft;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.data.ShippingRecommendation;
import com.ebay.nautilus.domain.net.api.shippingrecs.GetShippingRecommendationRequest;
import com.ebay.nautilus.domain.net.api.shippingrecs.GetShippingRecommendationResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;

public class GetShippingRecommendationTask extends AsyncTask
{

    private final String categoryId;
    private final String country;
    private final String draftId;
    private final String iafToken;
    private final ListingDraftDataManager listingDraftDataManager;
    private final EbaySite site;
    private final String title;
    private final String zipcode;

    public GetShippingRecommendationTask(ListingDraftDataManager listingdraftdatamanager, String s, EbaySite ebaysite, String s1, String s2, String s3, String s4, 
            String s5)
    {
        listingDraftDataManager = listingdraftdatamanager;
        iafToken = s;
        site = ebaysite;
        title = s1;
        categoryId = s2;
        country = s3;
        zipcode = s4;
        draftId = s5;
    }

    protected transient ShippingRecommendation doInBackground(Void avoid[])
    {
        avoid = (GetShippingRecommendationResponse)listingDraftDataManager.getEbayContext().getConnector().sendRequest(new GetShippingRecommendationRequest(iafToken, site, title, categoryId, country, zipcode, draftId));
        if (avoid.getResultStatus().hasError())
        {
            break MISSING_BLOCK_LABEL_72;
        }
        avoid = avoid.getDetails();
        return avoid;
        avoid;
        return null;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(ShippingRecommendation shippingrecommendation)
    {
        super.onPostExecute(shippingrecommendation);
        listingDraftDataManager.handleShippingRecommendationResult(shippingrecommendation);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ShippingRecommendation)obj);
    }
}
