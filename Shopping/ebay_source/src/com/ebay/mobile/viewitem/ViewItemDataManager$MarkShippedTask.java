// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.common.UserCache;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.net.api.trading.CompleteSaleRequest;
import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

private final class shipped extends AsyncTask
{

    private final EbayTradingApi api;
    private final long itemId;
    private final Boolean shipped;
    final ViewItemDataManager this$0;
    public final ShipmentTracking tracking;
    private final Long transactionId;

    protected transient Content doInBackground(Content acontent[])
    {
        ResultStatusOwner resultstatusowner;
label0:
        {
            Content content = null;
            resultstatusowner = new ResultStatusOwner();
            CompleteSaleRequest completesalerequest = new CompleteSaleRequest(api, itemId, transactionId, tracking, shipped, null);
            ViewItemDataManager.access$900(ViewItemDataManager.this, completesalerequest, resultstatusowner);
            if (resultstatusowner.getResultStatus() != ResultStatus.CANCELED)
            {
                if (resultstatusowner.getResultStatus().hasError() || acontent == null || acontent[0] == null || acontent[0].getData() == null)
                {
                    break label0;
                }
                acontent = (Item)acontent[0].getData();
                ViewItemDataManager.access$700(ViewItemDataManager.this).setShipped(acontent.getIdString(), Long.toString(((Item) (acontent)).transactionId.longValue()), shipped.booleanValue());
                if (!shipped.booleanValue())
                {
                    if (((Item) (acontent)).iTransaction.shippedTime != null)
                    {
                        ((Item) (acontent)).iTransaction.shippedTime = null;
                    }
                    if (!TextUtils.isEmpty(((Item) (acontent)).iTransaction.getShipmentTrackingNumber()))
                    {
                        ((Item) (acontent)).iTransaction.shipmentTrackingDetails = new ArrayList();
                    }
                }
                content = new Content(acontent, resultstatusowner.getResultStatus());
            }
            return content;
        }
        return new Content(null, resultstatusowner.getResultStatus());
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Content[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleMarkShippedResult(this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleMarkShippedResult(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (EbayTradingApi ebaytradingapi, long l, Long long1, ShipmentTracking shipmenttracking, Boolean boolean1)
    {
        this$0 = ViewItemDataManager.this;
        super();
        api = ebaytradingapi;
        itemId = l;
        transactionId = long1;
        tracking = shipmenttracking;
        shipped = boolean1;
    }
}
