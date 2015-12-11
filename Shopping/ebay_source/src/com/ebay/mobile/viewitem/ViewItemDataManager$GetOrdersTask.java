// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import com.ebay.common.net.api.trading.GetOrdersRequest;
import com.ebay.common.net.api.trading.GetOrdersResponse;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

private final class locale extends AsyncTask
{

    private final EbayTradingApi api;
    private final String iafToken;
    private final Locale locale;
    private final String orderId;
    final ViewItemDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        Object obj = null;
        ResultStatusOwner resultstatusowner = new ResultStatusOwner();
        avoid = new GetOrdersRequest(api, iafToken, locale, orderId);
        GetOrdersResponse getordersresponse = (GetOrdersResponse)ViewItemDataManager.access$3400(ViewItemDataManager.this, avoid, resultstatusowner);
        avoid = obj;
        if (resultstatusowner.getResultStatus() != ResultStatus.CANCELED)
        {
            avoid = obj;
            if (!resultstatusowner.getResultStatus().hasError())
            {
                avoid = new Content(getordersresponse.orders, resultstatusowner.getResultStatus());
            }
        }
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleGetOrdersResult(this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleGetOrdersResult(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (EbayTradingApi ebaytradingapi, String s, Locale locale1, String s1)
    {
        this$0 = ViewItemDataManager.this;
        super();
        iafToken = s;
        api = ebaytradingapi;
        orderId = s1;
        locale = locale1;
    }
}
