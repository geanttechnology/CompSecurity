// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.net.api.inventory.GetLocationDetailsRequest;
import com.ebay.common.net.api.inventory.GetLocationDetailsResponse;
import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager, ViewItemViewData

private final class AILS extends AsyncTask
{

    final ViewItemDataManager this$0;
    private final ViewItemViewData viewData;

    protected transient Content doInBackground(Content acontent[])
    {
        Item item = (Item)acontent[0].getData();
        if (item.isTransacted && !TextUtils.isEmpty(item.iTransaction.storeId))
        {
            Object obj = new GetLocationDetailsRequest(item.sellerUserId, item.iTransaction.storeId);
            ResultStatusOwner resultstatusowner = new ResultStatusOwner();
            obj = (GetLocationDetailsResponse)ViewItemDataManager.access$1500(ViewItemDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), resultstatusowner);
            if (resultstatusowner.getResultStatus() != ResultStatus.CANCELED)
            {
                ViewItemDataManager.access$1600(ViewItemDataManager.this, ((GetLocationDetailsResponse) (obj)), item, item.mskuSelections);
            }
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
        handleLoadDataResult(AILS, viewData, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleLoadDataResult(AILS, viewData, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public I(ViewItemViewData viewitemviewdata)
    {
        this$0 = ViewItemDataManager.this;
        super();
        viewData = viewitemviewdata;
        ViewItemDataManager.access$000(ViewItemDataManager.this, AILS);
    }
}
