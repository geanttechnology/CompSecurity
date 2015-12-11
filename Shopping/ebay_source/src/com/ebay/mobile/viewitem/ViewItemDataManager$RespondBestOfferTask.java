// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import com.ebay.common.net.api.trading.RespondToBestOfferRequest;
import com.ebay.common.net.api.trading.RespondToBestOfferResponse;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

private final class FFER extends AsyncTask
{

    private final String action;
    private final EbayTradingApi api;
    private final long bestOfferId;
    private final String counterOfferCode;
    private final Double counterOfferPrice;
    private final int counterOfferQuantity;
    private final long itemId;
    private final String sellerResponse;
    final ViewItemDataManager this$0;

    protected transient Content doInBackground(Content acontent[])
    {
        Object obj;
        ResultStatusOwner resultstatusowner;
label0:
        {
            obj = null;
            resultstatusowner = new ResultStatusOwner();
            Object obj1 = new RespondToBestOfferRequest(api, action, itemId, bestOfferId, sellerResponse, counterOfferPrice, counterOfferCode, counterOfferQuantity);
            obj1 = (RespondToBestOfferResponse)ViewItemDataManager.access$2600(ViewItemDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj1)), resultstatusowner);
            if (((RespondToBestOfferResponse) (obj1)).getResultStatus() != ResultStatus.CANCELED)
            {
                obj = new <init>(ViewItemDataManager.this);
                obj.response = ((RespondToBestOfferResponse) (obj1));
                obj.action = action;
                if (resultstatusowner.getResultStatus().hasError())
                {
                    break label0;
                }
                obj.item = acontent[0];
                obj = new Content(obj, ResultStatus.SUCCESS);
            }
            return ((Content) (obj));
        }
        return new Content(obj, resultstatusowner.getResultStatus());
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Content[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleRespondBestOfferResult(this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleRespondBestOfferResult(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (EbayTradingApi ebaytradingapi, String s, long l, long l1, 
            String s1, Double double1, String s2, int i)
    {
        this$0 = ViewItemDataManager.this;
        super();
        api = ebaytradingapi;
        action = s;
        itemId = l;
        bestOfferId = l1;
        sellerResponse = s1;
        counterOfferPrice = double1;
        counterOfferCode = s2;
        counterOfferQuantity = i;
        ViewItemDataManager.access$000(ViewItemDataManager.this, FFER);
    }
}
