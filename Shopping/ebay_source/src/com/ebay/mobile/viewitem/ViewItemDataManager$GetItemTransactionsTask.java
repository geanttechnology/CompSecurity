// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import com.ebay.common.net.api.trading.GetItemTransactionsRequest;
import com.ebay.common.net.api.trading.GetItemTransactionsResponse;
import com.ebay.mobile.Item;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager, ViewItemViewData

private final class IONS extends AsyncTask
{

    final ViewItemDataManager this$0;
    private final ViewItemViewData viewData;

    protected transient Content doInBackground(Content acontent[])
    {
        Object obj;
label0:
        {
            Content content = null;
            obj = (Item)acontent[0].getData();
            long l = ((Item) (obj)).transactionId.longValue();
            Object obj1 = new GetItemTransactionsRequest(EbayApiUtil.getTradingApi(getContext(), ViewItemDataManager.access$1000(ViewItemDataManager.this)), ((Item) (obj)).id, l);
            obj = new ResultStatusOwner();
            obj1 = (GetItemTransactionsResponse)ViewItemDataManager.access$1100(ViewItemDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj1)), ((ResultStatusOwner) (obj)));
            if (((ResultStatusOwner) (obj)).getResultStatus() != ResultStatus.CANCELED)
            {
                if (((ResultStatusOwner) (obj)).getResultStatus().hasError())
                {
                    break label0;
                }
                ViewItemDataManager.access$1200(ViewItemDataManager.this, ((GetItemTransactionsResponse) (obj1)), viewData, l, acontent[0]);
                content = acontent[0];
            }
            return content;
        }
        return new Content(null, ((ResultStatusOwner) (obj)).getResultStatus());
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Content[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleLoadDataResult(IONS, viewData, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleLoadDataResult(IONS, viewData, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (ViewItemViewData viewitemviewdata)
    {
        this$0 = ViewItemDataManager.this;
        super();
        viewData = viewitemviewdata;
        ViewItemDataManager.access$000(ViewItemDataManager.this, IONS);
    }
}
