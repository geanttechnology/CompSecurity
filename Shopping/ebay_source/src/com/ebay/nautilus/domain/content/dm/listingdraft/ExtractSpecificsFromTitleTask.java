// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm.listingdraft;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.net.api.attribute.GetAttributesRequest;
import com.ebay.nautilus.domain.net.api.attribute.GetAttributesResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.Connector;
import java.util.ArrayList;

public final class ExtractSpecificsFromTitleTask extends AsyncTask
{

    private final String categoryId;
    private final ListingDraftDataManager listingDraftDataManager;
    private final String title;

    public ExtractSpecificsFromTitleTask(ListingDraftDataManager listingdraftdatamanager, String s, String s1)
    {
        listingDraftDataManager = listingdraftdatamanager;
        title = s1;
        categoryId = s;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient ArrayList doInBackground(Void avoid[])
    {
        avoid = (GetAttributesResponse)listingDraftDataManager.getEbayContext().getConnector().sendRequest(new GetAttributesRequest(listingDraftDataManager.getParams().draftSite.idInt, categoryId, title));
        if (((GetAttributesResponse) (avoid)).ackCode == -1)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        avoid = ((GetAttributesResponse) (avoid)).attributes;
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
        listingDraftDataManager.handleExtractSpecificsResult(arraylist);
    }
}
