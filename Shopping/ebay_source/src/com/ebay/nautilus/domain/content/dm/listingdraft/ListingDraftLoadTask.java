// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm.listingdraft;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.domain.net.api.lds.CreateListingDraftRequest;
import com.ebay.nautilus.domain.net.api.lds.GetListingDraftsRequest;
import com.ebay.nautilus.domain.net.api.lds.LdsRequestParams;
import com.ebay.nautilus.domain.net.api.lds.LdsResponse;
import com.ebay.nautilus.domain.net.api.lds.PublishListingDraftRequest;
import com.ebay.nautilus.domain.net.api.lds.UpdateListingDraftRequest;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.ebay.nautilus.domain.content.dm.listingdraft:
//            ListingDraftOperation

public final class ListingDraftLoadTask extends AsyncTask
{

    private final ListingDraftDataManager listingDraftDataManager;
    private final LdsRequestParams requestParams;
    private LdsResponse response;
    public final int taskId;

    public ListingDraftLoadTask(ListingDraftDataManager listingdraftdatamanager, LdsRequestParams ldsrequestparams)
    {
        listingDraftDataManager = listingdraftdatamanager;
        requestParams = ldsrequestparams;
        taskId = ldsrequestparams.operation.ordinal();
    }

    public static LdsRequestParams buildLoadParams(com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.LoadDraftDetails loaddraftdetails, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams keyparams)
    {
        if (loaddraftdetails.draftId == null)
        {
            LdsRequestParams ldsrequestparams;
            if ("RelistItem".equals(keyparams.listingMode))
            {
                ldsrequestparams = new LdsRequestParams(ListingDraftOperation.CREATE_RELIST);
            } else
            {
                ldsrequestparams = new LdsRequestParams(ListingDraftOperation.CREATE);
            }
            if (loaddraftdetails.sourceItemId != null)
            {
                ldsrequestparams.sourceItemId = loaddraftdetails.sourceItemId;
            }
            if (keyparams.listingMode == null || keyparams.listingMode.equals("ReviseItem") || keyparams.listingMode.equals("RelistItem") || keyparams.listingMode.equals("SellSimilarItem"))
            {
                return ldsrequestparams;
            }
            if (loaddraftdetails.epid != null)
            {
                ldsrequestparams.values.put("Listing.Item.ProductInfo.ProductId", loaddraftdetails.epid);
            }
            if (loaddraftdetails.title != null)
            {
                ldsrequestparams.values.put("Listing.Item.Title", loaddraftdetails.title);
            }
            if (loaddraftdetails.categoryId != null)
            {
                ldsrequestparams.values.put("Listing.CategoryInfo[0].Id", loaddraftdetails.categoryId);
            }
            if (loaddraftdetails.defaults.shippingType != null)
            {
                ldsrequestparams.values.put("Listing.ShippingInfo.DomesticShippingType", loaddraftdetails.defaults.shippingType);
            }
            if (loaddraftdetails.defaults.paypalEmail != null)
            {
                ldsrequestparams.values.put("Listing.PaymentInfo.PaypalEmailAddress", loaddraftdetails.defaults.paypalEmail);
            }
            if (loaddraftdetails.defaults.country != null)
            {
                ldsrequestparams.values.put("Listing.ItemLocation.CountryCode", loaddraftdetails.defaults.country);
            }
            if (loaddraftdetails.defaults.zipcode != null)
            {
                ldsrequestparams.values.put("Listing.ItemLocation.ZipCode", loaddraftdetails.defaults.zipcode);
            }
            if (loaddraftdetails.defaults.cityState != null)
            {
                ldsrequestparams.values.put("Listing.ItemLocation.CityState", loaddraftdetails.defaults.cityState);
            }
            if (loaddraftdetails.defaults.handlingTime != null)
            {
                ldsrequestparams.values.put("Listing.ShippingInfo.HandlingDuration", loaddraftdetails.defaults.handlingTime);
            }
            if (loaddraftdetails.defaults.acceptedPaymentMethods != null)
            {
                ldsrequestparams.values.put("Listing.PaymentInfo.AcceptedPaymentMethod", loaddraftdetails.defaults.acceptedPaymentMethods);
            }
            if (loaddraftdetails.defaults.returnsAccepted != null)
            {
                ldsrequestparams.values.put("Listing.ReturnPolicy.ReturnsAccepted", loaddraftdetails.defaults.returnsAccepted);
            }
            keyparams = ldsrequestparams;
            if ("ReturnsAccepted".equals(loaddraftdetails.defaults.returnsAccepted))
            {
                if (loaddraftdetails.defaults.returnPeriod != null)
                {
                    ldsrequestparams.values.put("Listing.ReturnPolicy.ReturnPeriod", loaddraftdetails.defaults.returnPeriod);
                }
                if (loaddraftdetails.defaults.refundMethod != null)
                {
                    ldsrequestparams.values.put("Listing.ReturnPolicy.RefundMethod", loaddraftdetails.defaults.refundMethod);
                }
                if (loaddraftdetails.defaults.refundShipmentPayee != null)
                {
                    ldsrequestparams.values.put("Listing.ReturnPolicy.RefundShipmentPayee", loaddraftdetails.defaults.refundShipmentPayee);
                }
                if (loaddraftdetails.defaults.restockingFee != null)
                {
                    ldsrequestparams.values.put("Listing.ReturnPolicy.RestockingFeeValue", loaddraftdetails.defaults.restockingFee);
                }
                keyparams = ldsrequestparams;
                if (loaddraftdetails.defaults.policyDetails != null)
                {
                    ldsrequestparams.values.put("Listing.ReturnPolicy.PolicyDetails", loaddraftdetails.defaults.policyDetails);
                    keyparams = ldsrequestparams;
                }
            }
        } else
        {
            keyparams = new LdsRequestParams(ListingDraftOperation.GET);
            keyparams.id = loaddraftdetails.draftId;
        }
        return keyparams;
    }

    protected transient ListingDraftContent doInBackground(Void avoid[])
    {
        if (requestParams.operation.ordinal() >= ListingDraftOperation.UPDATE_START_RANGE.ordinal() || requestParams.operation == ListingDraftOperation.UPDATE_FOR_REVIEW)
        {
            response = (LdsResponse)listingDraftDataManager.getEbayContext().getConnector().sendRequest(new UpdateListingDraftRequest(requestParams));
        }
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation = new int[ListingDraftOperation.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation[ListingDraftOperation.CREATE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation[ListingDraftOperation.CREATE_RELIST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation[ListingDraftOperation.GET.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation[ListingDraftOperation.PUBLISH.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.nautilus.domain.content.dm.listingdraft.ListingDraftOperation[requestParams.operation.ordinal()];
        JVM INSTR tableswitch 1 4: default 272
    //                   1 139
    //                   2 139
    //                   3 175
    //                   4 211;
           goto _L1 _L2 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_211;
_L5:
        avoid = response.getResultStatus();
        if (avoid.hasError())
        {
            return new ListingDraftContent(new ListingDraft(), avoid);
        }
        break MISSING_BLOCK_LABEL_247;
_L2:
        response = (LdsResponse)listingDraftDataManager.getEbayContext().getConnector().sendRequest(new CreateListingDraftRequest(requestParams));
          goto _L5
_L3:
        try
        {
            response = (LdsResponse)listingDraftDataManager.getEbayContext().getConnector().sendRequest(new GetListingDraftsRequest(requestParams));
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return null;
        }
          goto _L5
        response = (LdsResponse)listingDraftDataManager.getEbayContext().getConnector().sendRequest(new PublishListingDraftRequest(requestParams));
          goto _L5
        avoid = new ListingDraftContent((ListingDraft)response.drafts.get(0), avoid);
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    public LdsRequestParams getRequestParams()
    {
        return requestParams;
    }

    protected void onCancelled(ListingDraftContent listingdraftcontent)
    {
        listingDraftDataManager.handleDraftTaskResult(this, listingdraftcontent);
    }

    protected volatile void onCancelled(Object obj)
    {
        onCancelled((ListingDraftContent)obj);
    }

    protected void onPostExecute(ListingDraftContent listingdraftcontent)
    {
        super.onPostExecute(listingdraftcontent);
        listingDraftDataManager.handleDraftTaskResult(this, listingdraftcontent);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ListingDraftContent)obj);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        listingDraftDataManager.handleDraftTaskStarted(this);
    }
}
