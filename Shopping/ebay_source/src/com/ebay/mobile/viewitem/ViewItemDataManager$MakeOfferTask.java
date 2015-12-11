// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import com.ebay.common.model.PlaceOfferResult;
import com.ebay.common.net.api.trading.PlaceOfferRequest;
import com.ebay.common.net.api.trading.PlaceOfferResponse;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.mobile.bestoffer.BestOfferTracking;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.message.PlaceOfferResultStatus;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

private final class FER extends AsyncTask
{

    private final String action;
    private final EbayTradingApi api;
    private final String bestOfferId;
    private final String bestOfferTermsToSeller;
    private final ItemCurrency bid;
    private final long itemId;
    private final ArrayList options;
    private final int quantity;
    private final boolean requestTrackingPartnerCode;
    final ViewItemDataManager this$0;

    protected transient Content doInBackground(Content acontent[])
    {
        Object obj;
         ;
        ResultStatusOwner resultstatusowner;
        PlaceOfferResponse placeofferresponse;
        obj = null;
         = new (ViewItemDataManager.this);
        .item = acontent[0];
        acontent = new PlaceOfferRequest(api, itemId, action, bid, quantity, options, bestOfferId, bestOfferTermsToSeller, requestTrackingPartnerCode, false);
        resultstatusowner = new ResultStatusOwner();
        placeofferresponse = (PlaceOfferResponse)ViewItemDataManager.access$2100(ViewItemDataManager.this, acontent, resultstatusowner);
        if (resultstatusowner.getResultStatus() == ResultStatus.CANCELED)
        {
            return null;
        }
        .response = placeofferresponse;
        if (resultstatusowner.getResultStatus().hasError()) goto _L2; else goto _L1
_L1:
        acontent = new Content(, resultstatusowner.getResultStatus());
_L4:
        return acontent;
_L2:
        if (Util.checkForIAFTokenError(placeofferresponse))
        {
            acontent = new Content(null, resultstatusowner.getResultStatus());
        } else
        if (EbayErrorUtil.userAccessLevelUpgradeRequired(placeofferresponse.getResultStatus().getMessages()))
        {
            .resultStatus = new PlaceOfferResultStatus(502, true, null);
            acontent = new Content(, resultstatusowner.getResultStatus());
        } else
        {
            List list = placeofferresponse.getResultStatus().getMessages();
            acontent = obj;
            if (list != null)
            {
                acontent = obj;
                if (list.size() > 0)
                {
                    acontent = (com.ebay.nautilus.kernel.content.tatus)list.get(list.size() - 1);
                    .resultStatus.putMessage(ResultStatus.getSafeLongMessage(getEbayContext(), acontent));
                    if (!(acontent instanceof EbayResponseError) || !((EbayResponseError)acontent).code.equals("21917143"))
                    {
                        BestOfferTracking.trackState(getEbayContext(), "OBME", Long.valueOf(itemId), null, placeofferresponse.result.bestOfferId);
                    }
                    acontent = new Content(, resultstatusowner.getResultStatus());
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Content[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleMakeOfferResult(this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleMakeOfferResult(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (EbayTradingApi ebaytradingapi, long l, String s, ItemCurrency itemcurrency, int i, 
            ArrayList arraylist, String s1, String s2, boolean flag)
    {
        this$0 = ViewItemDataManager.this;
        super();
        api = ebaytradingapi;
        itemId = l;
        action = s;
        bid = itemcurrency;
        quantity = i;
        options = arraylist;
        bestOfferId = s1;
        bestOfferTermsToSeller = s2;
        requestTrackingPartnerCode = flag;
        ViewItemDataManager.access$000(ViewItemDataManager.this, FER);
    }
}
