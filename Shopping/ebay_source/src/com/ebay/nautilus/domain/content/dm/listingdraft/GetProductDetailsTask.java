// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm.listingdraft;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.net.api.catalogcontent.GetProductDetailsRequest;
import com.ebay.nautilus.domain.net.api.catalogcontent.GetProductDetailsResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;

public class GetProductDetailsTask extends AsyncTask
{

    private final String epid;
    private final String iafToken;
    private final ListingDraftDataManager listingDraftDataManager;
    private final EbaySite site;

    public GetProductDetailsTask(ListingDraftDataManager listingdraftdatamanager, String s, EbaySite ebaysite, String s1)
    {
        listingDraftDataManager = listingdraftdatamanager;
        iafToken = s;
        site = ebaysite;
        epid = s1;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        avoid = (GetProductDetailsResponse)listingDraftDataManager.getEbayContext().getConnector().sendRequest(new GetProductDetailsRequest(iafToken, site, epid));
        if (avoid.getResultStatus().hasError())
        {
            break MISSING_BLOCK_LABEL_56;
        }
        avoid = ((GetProductDetailsResponse) (avoid)).description;
        return avoid;
        avoid;
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        listingDraftDataManager.handleProductDetailsResult(s);
    }
}
