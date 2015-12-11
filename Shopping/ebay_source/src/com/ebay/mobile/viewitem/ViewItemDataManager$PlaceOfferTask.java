// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import com.ebay.common.model.PlaceOfferResult;
import com.ebay.common.net.api.trading.PlaceOfferRequest;
import com.ebay.common.net.api.trading.PlaceOfferResponse;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.message.PlaceOfferResultStatus;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
    private final String bidSource;
    private final boolean incrementalBid;
    public boolean isBidAction;
    public boolean isPurchaseAction;
    private boolean isUserConsentRequired;
    private final long itemId;
    private final ArrayList options;
    private final int quantity;
    private final String referrer;
    private final boolean requestTrackingPartnerCode;
    final ViewItemDataManager this$0;
    private final ItemCurrency totalCostWithShipping;

    protected transient Content doInBackground(Content acontent[])
    {
        Object obj;
        FER fer;
        ResultStatusOwner resultstatusowner;
        Object obj2;
        obj = null;
        fer = new <init>(ViewItemDataManager.this);
        fer.item = acontent[0];
        fer.action = action;
        PlaceOfferRequest placeofferrequest = new PlaceOfferRequest(api, itemId, action, bid, quantity, options, bestOfferId, bestOfferTermsToSeller, requestTrackingPartnerCode, isUserConsentRequired);
        resultstatusowner = new ResultStatusOwner();
        obj2 = (PlaceOfferResponse)ViewItemDataManager.access$1800(ViewItemDataManager.this, placeofferrequest, resultstatusowner);
        if (resultstatusowner.getResultStatus() == ResultStatus.CANCELED)
        {
            return null;
        }
        fer.response = ((PlaceOfferResponse) (obj2));
        if (!"Decline".equals(action) && !"Accept".equals(action) && !"Counter".equals(action)) goto _L2; else goto _L1
_L1:
        if (!resultstatusowner.getResultStatus().hasError())
        {
            acontent = new Content(fer, resultstatusowner.getResultStatus());
        } else
        {
            acontent = new Content(null, resultstatusowner.getResultStatus());
        }
_L6:
        return acontent;
_L2:
        Object obj1;
        Item item;
        HashSet hashset;
        int i;
        if (obj2 != null && ((PlaceOfferResponse) (obj2)).result != null && ((PlaceOfferResponse) (obj2)).result.suggestedBidValues != null && ((PlaceOfferResponse) (obj2)).result.suggestedBidValues.size() > 0)
        {
            ((Item)acontent[0].getData()).powerBidValues = ((PlaceOfferResponse) (obj2)).result.suggestedBidValues;
        }
        if (!resultstatusowner.getResultStatus().hasError())
        {
            fer.resultStatus = ViewItemDataManager.access$1900(ViewItemDataManager.this, this, ((PlaceOfferResponse) (obj2)), acontent[0]);
            acontent = new Content(fer, resultstatusowner.getResultStatus());
            continue; /* Loop/switch isn't completed */
        }
        if (Util.checkForIAFTokenError(((com.ebay.nautilus.domain.net.EbayResponse) (obj2))))
        {
            acontent = new Content(null, resultstatusowner.getResultStatus());
            continue; /* Loop/switch isn't completed */
        }
        if (EbayErrorUtil.userAccessLevelUpgradeRequired(((PlaceOfferResponse) (obj2)).getResultStatus().getMessages()))
        {
            fer.resultStatus = new PlaceOfferResultStatus(502, true, null);
            acontent = new Content(fer, resultstatusowner.getResultStatus());
            continue; /* Loop/switch isn't completed */
        }
        item = (Item)acontent[0].getData();
        boolean flag = action.equals("Purchase");
        obj1 = utState.SERVICE_ERROR;
        acontent = ((Content []) (obj));
        if (utState.CONNECTION_ERROR == obj1)
        {
            continue; /* Loop/switch isn't completed */
        }
        acontent = ((Content []) (obj));
        if (!((PlaceOfferResponse) (obj2)).getResultStatus().hasMessage())
        {
            continue; /* Loop/switch isn't completed */
        }
        acontent = ((PlaceOfferResponse) (obj2)).getResultStatus().getMessages();
        hashset = new HashSet(acontent.size());
        obj = null;
        obj1 = acontent.iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            Object obj3 = (com.ebay.nautilus.kernel.content.CONNECTION_ERROR)((Iterator) (obj1)).next();
            if (obj3 instanceof EbayResponseError)
            {
                obj3 = (EbayResponseError)obj3;
                hashset.add(((EbayResponseError) (obj3)).code);
                if (((EbayResponseError) (obj3)).code != null && ((EbayResponseError) (obj3)).code.equals("12210"))
                {
                    obj = ((EbayResponseError) (obj3)).longMessage;
                }
            }
        } while (true);
        com.ebay.nautilus.kernel.content.nsentRequired nsentrequired = (com.ebay.nautilus.kernel.content.CONNECTION_ERROR)acontent.get(0);
        obj1 = MyApp.getDisplayableServiceError(getEbayContext(), resultstatusowner.getResultStatus());
        if (hashset.contains("36"))
        {
            acontent = getContext().getString(0x7f0703cf);
        } else
        {
            acontent = ((Content []) (obj1));
            if (!flag)
            {
label0:
                {
                    if ((item == null || !item.isAuctionEnded) && !hashset.contains("12243") && !hashset.contains("12234"))
                    {
                        break label0;
                    }
                    acontent = getContext().getString(0x7f07017b);
                }
            }
        }
_L4:
        i = nsentrequired.CONNECTION_ERROR();
        if (12310 == i)
        {
            obj1 = getEbayContext();
            obj2 = nsentrequired.(((com.ebay.nautilus.kernel.content.EbayContext) (obj1)));
            obj = acontent;
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                obj = Html.fromHtml(((String) (obj2))).toString().replaceAll("Filter Id:", "").trim();
            }
            acontent = ((Content []) (obj));
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                acontent = nsentrequired.e(((com.ebay.nautilus.kernel.content.EbayContext) (obj1)));
            }
        } else
        if (0x14e6c6e == i)
        {
            acontent = getContext().getString(0x7f0709f0);
        }
        fer.resultStatus = new PlaceOfferResultStatus(503, false, acontent);
        acontent = new Content(fer, resultstatusowner.getResultStatus());
        continue; /* Loop/switch isn't completed */
        acontent = ((Content []) (obj1));
        if (!hashset.contains("12210")) goto _L4; else goto _L3
_L3:
        acontent = new PlaceOfferResultStatus(505, true, null);
        obj1 = acontent.getBundle();
        obj2 = ((PlaceOfferResponse) (obj2)).result;
        if (obj2 != null && ((PlaceOfferResult) (obj2)).currentPrice != null)
        {
            ((Bundle) (obj1)).putParcelable("current_price", ((PlaceOfferResult) (obj2)).currentPrice);
        }
        if (((PlaceOfferResult) (obj2)).minimumToBid != null)
        {
            item.minimumToBid = ViewItemDataManager.access$2000(ViewItemDataManager.this, item, ((PlaceOfferResult) (obj2)).minimumToBid);
        }
        fer.resultStatus = acontent;
        ((Bundle) (obj1)).putString("bidTooLowErrorMessage", ((String) (obj)));
        return new Content(fer, resultstatusowner.getResultStatus());
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Content[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handlePlaceOfferResult(this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handlePlaceOfferResult(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }









    public utState(EbayTradingApi ebaytradingapi, long l, String s, ItemCurrency itemcurrency, int i, 
            ArrayList arraylist, String s1, String s2, boolean flag, ItemCurrency itemcurrency1, String s3, String s4, 
            boolean flag1, boolean flag2)
    {
        this$0 = ViewItemDataManager.this;
        super();
        isUserConsentRequired = false;
        api = ebaytradingapi;
        itemId = l;
        action = s;
        isBidAction = "Bid".equals(s);
        isPurchaseAction = "Purchase".equals(s);
        bid = itemcurrency;
        quantity = i;
        options = arraylist;
        bestOfferId = s1;
        bestOfferTermsToSeller = s2;
        requestTrackingPartnerCode = flag;
        totalCostWithShipping = itemcurrency1;
        bidSource = s3;
        referrer = s4;
        incrementalBid = flag1;
        isUserConsentRequired = flag2;
        ViewItemDataManager.access$000(ViewItemDataManager.this, FER);
    }
}
