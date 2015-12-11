// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm.listingdraft;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.net.api.shippingrecs.GetShippingEstimatesRequest;
import com.ebay.nautilus.domain.net.api.shippingrecs.GetShippingEstimatesResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import java.util.ArrayList;
import java.util.List;

public class GetShippingEstimatesTask extends AsyncTask
{

    private final double depth;
    private final String dimensionUnitType;
    private final String iafToken;
    private final double length;
    private final ListingDraftDataManager listingDraftDataManager;
    private final String packageType;
    private final String postalCode;
    private final List serviceCodes;
    private final EbaySite site;
    private final String unitType;
    private final double weight;
    private final double width;

    public GetShippingEstimatesTask(ListingDraftDataManager listingdraftdatamanager, String s, EbaySite ebaysite, List list, String s1, String s2, String s3, 
            double d, String s4, double d1, double d2, 
            double d3)
    {
        listingDraftDataManager = listingdraftdatamanager;
        iafToken = s;
        site = ebaysite;
        serviceCodes = list;
        postalCode = s1;
        packageType = s2;
        unitType = s3;
        weight = d;
        dimensionUnitType = s4;
        length = d1;
        width = d2;
        depth = d3;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient ArrayList doInBackground(Void avoid[])
    {
        avoid = (GetShippingEstimatesResponse)listingDraftDataManager.getEbayContext().getConnector().sendRequest(new GetShippingEstimatesRequest(iafToken, site, serviceCodes, postalCode, packageType, unitType, weight, dimensionUnitType, length, width, depth));
        if (avoid.getResultStatus().hasError())
        {
            break MISSING_BLOCK_LABEL_88;
        }
        avoid = avoid.getEstimates();
        return avoid;
        avoid;
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ArrayList)obj);
    }

    protected void onPostExecute(ArrayList arraylist)
    {
        super.onPostExecute(arraylist);
        listingDraftDataManager.handleShippingEstimatesResult(arraylist);
    }
}
