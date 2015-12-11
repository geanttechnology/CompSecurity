// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import com.ebay.common.net.api.shipping.GetShipmentTrackingRequest;
import com.ebay.common.net.api.shipping.GetShipmentTrackingResponse;
import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager, ViewItemViewData

private final class KING extends AsyncTask
{

    private final String iafToken;
    private final boolean initialLoad;
    private final long itemId;
    private final boolean realTime;
    private final EbaySite site;
    final ViewItemDataManager this$0;
    private final Long transactionId;
    private final ViewItemViewData viewData;

    protected transient Content doInBackground(Content acontent[])
    {
        ResultStatusOwner resultstatusowner = new ResultStatusOwner();
        Object obj = new GetShipmentTrackingRequest(iafToken, site, itemId, transactionId.longValue(), realTime, viewData.useEventTimeHack);
        obj = (GetShipmentTrackingResponse)ViewItemDataManager.access$2500(ViewItemDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), resultstatusowner);
        if (!resultstatusowner.getResultStatus().hasError())
        {
            ((Item)acontent[0].getData()).tracking = ((GetShipmentTrackingResponse) (obj)).tracking;
            return acontent[0];
        } else
        {
            return new Content(null, resultstatusowner.getResultStatus());
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Content[])aobj);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        if (initialLoad)
        {
            handleLoadDataResult(KING, viewData, content);
            return;
        } else
        {
            handleGetShipmentTrackingResult(this, content);
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (String s, EbaySite ebaysite, long l, Long long1, boolean flag, 
            ViewItemViewData viewitemviewdata)
    {
        this(s, ebaysite, l, long1, false, flag, viewitemviewdata);
    }

    public <init>(String s, EbaySite ebaysite, long l, Long long1, boolean flag, 
            boolean flag1, ViewItemViewData viewitemviewdata)
    {
        this$0 = ViewItemDataManager.this;
        super();
        iafToken = s;
        site = ebaysite;
        itemId = l;
        transactionId = long1;
        initialLoad = flag;
        realTime = flag1;
        viewData = viewitemviewdata;
        ViewItemDataManager.access$000(ViewItemDataManager.this, KING);
    }
}
