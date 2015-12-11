// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import com.ebay.common.model.AllBiddersData;
import com.ebay.common.net.api.trading.GetAllBiddersRequest;
import com.ebay.common.net.api.trading.GetAllBiddersResponse;
import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.mobile.viewitem:
//            BiddingDataManager

private final class item extends AsyncTask
{

    public final long auctionEndsAt;
    public final int bidCount;
    public final Item item;
    public final com.ebay.common.net.api.trading.rams requestParams;
    final BiddingDataManager this$0;

    protected transient nt doInBackground(Void avoid[])
    {
        if (BiddingDataManager.logger.Params)
        {
            BiddingDataManager.logger.Params((new StringBuilder()).append("Calling GetAllBidders API for: ").append(requestParams).toString());
        }
        Object obj = new ResultStatusOwner();
        avoid = (GetAllBiddersResponse)BiddingDataManager.access$000(BiddingDataManager.this, new GetAllBiddersRequest(requestParams), ((ResultStatusOwner) (obj)));
        obj = ((ResultStatusOwner) (obj)).getResultStatus();
        if (obj == ResultStatus.CANCELED)
        {
            return null;
        }
        if (((ResultStatus) (obj)).hasError())
        {
            return new nt(null, ((ResultStatus) (obj)), item);
        }
        avoid = ((GetAllBiddersResponse) (avoid)).allBidders;
        if (avoid == null || ((AllBiddersData) (avoid)).listingStatus == null)
        {
            return new nt(null, ResultStatus.create(new com.ebay.nautilus.kernel.content.>[] {
                InternalDomainError.getServerResponseNotValidMessage()
            }), item);
        } else
        {
            return new nt(avoid, ((ResultStatus) (obj)), item);
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleBidderLoadComplete(this, null);
    }

    protected void onPostExecute(nt nt)
    {
        super.onPostExecute(nt);
        handleBidderLoadComplete(this, nt);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((nt)obj);
    }

    public String toString()
    {
        return (new StringBuilder()).append("BidderTask [bidCount=").append(bidCount).append(", auctionEndsAt=").append(auctionEndsAt).append(", requestParams=").append(requestParams).append("]").toString();
    }

    public questParams(int i, long l, com.ebay.common.net.api.trading.rams rams, Item item1)
    {
        this$0 = BiddingDataManager.this;
        super();
        bidCount = i;
        auctionEndsAt = l;
        requestParams = rams;
        item = item1;
    }
}
