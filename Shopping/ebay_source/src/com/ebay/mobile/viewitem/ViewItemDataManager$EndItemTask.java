// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import com.ebay.common.net.api.trading.EndItemRequest;
import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager, ViewItemViewData

private final class reason extends AsyncTask
{

    private final EbayTradingApi api;
    private final long itemId;
    private final String reason;
    final ViewItemDataManager this$0;

    protected transient ResultStatus doInBackground(Void avoid[])
    {
        avoid = new ResultStatusOwner();
        EndItemRequest enditemrequest = new EndItemRequest(api, itemId, reason);
        ViewItemDataManager.access$200(ViewItemDataManager.this, enditemrequest, avoid);
        if (avoid.getResultStatus() != ResultStatus.CANCELED && !avoid.getResultStatus().hasError())
        {
            ((Item)ViewItemDataManager.access$300(ViewItemDataManager.this).getData()).listingStatus = "Completed";
            if ("SellToHighBidder".equals(reason))
            {
                ViewItemViewData viewitemviewdata = ViewItemDataManager.access$400(ViewItemDataManager.this);
                viewitemviewdata.keyParams = new nit>(itemId, Long.valueOf(0L));
                viewitemviewdata.kind = com.ebay.common.ItemTask.itemId;
                ViewItemDataManager.access$500(ViewItemDataManager.this).put(viewitemviewdata.keyParams, viewitemviewdata);
            }
        }
        return avoid.getResultStatus();
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleEndItemResult(this, null);
    }

    protected void onPostExecute(ResultStatus resultstatus)
    {
        super.onPostExecute(resultstatus);
        handleEndItemResult(this, resultstatus);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    public (EbayTradingApi ebaytradingapi, long l, String s)
    {
        this$0 = ViewItemDataManager.this;
        super();
        api = ebaytradingapi;
        itemId = l;
        reason = s;
    }
}
