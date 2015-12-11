// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.content.Context;
import android.os.AsyncTask;
import com.ebay.common.UserCache;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.net.api.trading.CompleteSaleRequest;
import com.ebay.common.net.api.trading.CompleteSaleResponse;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.data.ShipmentTrackingDetail;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

private final class markAsPaid extends AsyncTask
{

    private final EbayTradingApi api;
    private final long itemId;
    private final Boolean markAsPaid;
    private final Boolean shipped;
    final ViewItemDataManager this$0;
    public final ShipmentTracking tracking;
    private final Long transactionId;

    protected transient Content doInBackground(Void avoid[])
    {
        ResultStatusOwner resultstatusowner;
        Object obj;
label0:
        {
            avoid = null;
            resultstatusowner = new ResultStatusOwner();
            obj = new CompleteSaleRequest(api, itemId, transactionId, tracking, shipped, markAsPaid);
            obj = (CompleteSaleResponse)ViewItemDataManager.access$600(ViewItemDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), resultstatusowner);
            if (((CompleteSaleResponse) (obj)).getResultStatus() != ResultStatus.CANCELED)
            {
                if (resultstatusowner.getResultStatus().hasError() || tracking == null || tracking.details == null)
                {
                    break label0;
                }
                avoid = (Item)ViewItemDataManager.access$300(ViewItemDataManager.this).getData();
                String s;
                boolean flag;
                if (!tracking.details.isEmpty())
                {
                    obj = (ShipmentTrackingDetail)tracking.details.get(0);
                    ((Item) (avoid)).iTransaction.setShipmentTrackingNumber(((ShipmentTrackingDetail) (obj)).trackingNumber);
                    ((Item) (avoid)).iTransaction.setShippingCarrierUsed(((ShipmentTrackingDetail) (obj)).carrier);
                } else
                {
                    ((Item) (avoid)).iTransaction.setShipmentTrackingNumber(null);
                    ((Item) (avoid)).iTransaction.setShippingCarrierUsed(null);
                }
                avoid.tracking = tracking;
                obj = ViewItemDataManager.access$700(ViewItemDataManager.this);
                s = avoid.getIdString();
                avoid = Long.toString(((Item) (avoid)).transactionId.longValue());
                if (!tracking.details.isEmpty())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ((UserCache) (obj)).setShipped(s, avoid, flag);
                avoid = new Content(ViewItemDataManager.access$300(ViewItemDataManager.this).getData(), resultstatusowner.getResultStatus());
            }
            return avoid;
        }
        if (EbayErrorUtil.carrierInvalid(((CompleteSaleResponse) (obj)).getResultStatus().getMessages()))
        {
            avoid = new EbayResponseError();
            avoid.severity = 1;
            avoid.longMessage = getContext().getString(0x7f070144);
            avoid.shortMessage = getContext().getString(0x7f07049c);
            resultstatusowner.addResultMessage(new com.ebay.nautilus.kernel.content.[] {
                avoid
            });
        }
        return new Content(null, resultstatusowner.getResultStatus());
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleAddShipmentTrackingResult(this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleAddShipmentTrackingResult(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (EbayTradingApi ebaytradingapi, long l, Long long1, ShipmentTracking shipmenttracking, Boolean boolean1, 
            Boolean boolean2)
    {
        this$0 = ViewItemDataManager.this;
        super();
        api = ebaytradingapi;
        itemId = l;
        transactionId = long1;
        tracking = shipmenttracking;
        shipped = boolean1;
        markAsPaid = boolean2;
    }
}
