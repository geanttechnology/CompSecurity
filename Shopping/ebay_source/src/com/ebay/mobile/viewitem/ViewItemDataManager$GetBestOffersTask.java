// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager, ViewItemViewData

private final class FERS extends AsyncTask
{

    private final EbayTradingApi api;
    private final boolean initialLoad;
    private final long itemId;
    final ViewItemDataManager this$0;
    private final ViewItemViewData viewData;

    protected transient Content doInBackground(Content acontent[])
    {
label0:
        {
            Object obj = null;
            Content content = obj;
            if (acontent[0] != null)
            {
                content = obj;
                if (acontent[0].getData() != null)
                {
                    ResultStatus resultstatus = ViewItemDataManager.access$1400(ViewItemDataManager.this, api, itemId, initialLoad, (Item)acontent[0].getData());
                    content = obj;
                    if (resultstatus != ResultStatus.CANCELED)
                    {
                        if (!resultstatus.hasError())
                        {
                            break label0;
                        }
                        content = new Content(null, resultstatus);
                    }
                }
            }
            return content;
        }
        return acontent[0];
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Content[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleLoadDataResult(FERS, viewData, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        if (initialLoad)
        {
            handleLoadDataResult(FERS, viewData, content);
            return;
        } else
        {
            handleGetBestOffersResult(this, content);
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (EbayTradingApi ebaytradingapi, long l, boolean flag, ViewItemViewData viewitemviewdata)
    {
        this$0 = ViewItemDataManager.this;
        super();
        api = ebaytradingapi;
        itemId = l;
        initialLoad = flag;
        viewData = viewitemviewdata;
        ViewItemDataManager.access$000(ViewItemDataManager.this, FERS);
    }
}
