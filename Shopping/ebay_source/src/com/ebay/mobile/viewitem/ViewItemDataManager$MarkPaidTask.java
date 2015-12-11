// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import com.ebay.common.UserCache;
import com.ebay.common.net.api.trading.CompleteSaleRequest;
import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

private final class markAsPaid extends AsyncTask
{

    private final EbayTradingApi api;
    private final long itemId;
    private final Boolean markAsPaid;
    final ViewItemDataManager this$0;
    public final ShipmentTracking tracking;
    private final Long transactionId;

    protected transient Content doInBackground(Content acontent[])
    {
        ResultStatusOwner resultstatusowner;
label0:
        {
            Object obj = null;
            resultstatusowner = new ResultStatusOwner();
            CompleteSaleRequest completesalerequest = new CompleteSaleRequest(api, itemId, transactionId, tracking, null, markAsPaid);
            ViewItemDataManager.access$800(ViewItemDataManager.this, completesalerequest, resultstatusowner);
            if (resultstatusowner.getResultStatus() != ResultStatus.CANCELED)
            {
                if (resultstatusowner.getResultStatus().hasError() || acontent == null || acontent[0] == null || acontent[0].getData() == null)
                {
                    break label0;
                }
                obj = (Item)acontent[0].getData();
                boolean flag;
                if (markAsPaid.booleanValue())
                {
                    acontent = "PaidWithPayPal";
                } else
                {
                    acontent = "NotPaid";
                }
                obj.paidStatus = acontent;
                ViewItemDataManager.access$700(ViewItemDataManager.this).addToPaidStatus(((Item) (obj)).getIdString(), Long.toString(((Item) (obj)).transactionId.longValue()), ((Item) (obj)).paidStatus, null);
                obj.isPaid = markAsPaid.booleanValue();
                if (!((Item) (obj)).isPaid)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                obj.isShowMarkAsPaid = flag;
                obj.isShowMarkAsUnPaid = ((Item) (obj)).isPaid;
                obj = new Content(obj, resultstatusowner.getResultStatus());
            }
            return ((Content) (obj));
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
        handleMarkPaidResult(this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleMarkPaidResult(this, content);
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
        markAsPaid = boolean1;
    }
}
