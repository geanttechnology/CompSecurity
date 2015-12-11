// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.viewitem:
//            BiddingDataManager

private final class requestParams extends AsyncTask
{

    public final stParams requestParams;
    final BiddingDataManager this$0;

    protected transient nt doInBackground(Void avoid[])
    {
        if (BiddingDataManager.logger.stParams)
        {
            BiddingDataManager.logger.stParams((new StringBuilder()).append("Calling GetPhotoNetLoader API for: ").append(requestParams).toString());
        }
        avoid = new com.ebay.mobile.common.tLoader(requestParams.url, com.ebay.mobile.common.ution.Standard, -1, getEbayContext(), requestParams.lruSize);
        avoid.executeImmediate();
        if (avoid.isInterrupted())
        {
            return null;
        }
        ResultStatus resultstatus = avoid.getResultStatus();
        if (resultstatus.hasError())
        {
            return new nt(null, resultstatus);
        } else
        {
            return new nt(avoid.getBitmap(), resultstatus);
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleImageLoadComplete(this, null);
    }

    protected void onPostExecute(nt nt)
    {
        super.onPostExecute(nt);
        handleImageLoadComplete(this, nt);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((nt)obj);
    }

    public String toString()
    {
        return (new StringBuilder()).append("ImageTask [requestParams=").append(requestParams).append("]").toString();
    }

    public stParams(stParams stparams)
    {
        this$0 = BiddingDataManager.this;
        super();
        requestParams = stparams;
    }
}
