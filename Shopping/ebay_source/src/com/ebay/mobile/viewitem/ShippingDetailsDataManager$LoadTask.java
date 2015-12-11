// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import com.ebay.common.model.EbayDetail;
import com.ebay.common.net.api.trading.GetEbayDetailsRequest;
import com.ebay.common.net.api.trading.GetEbayDetailsResponse;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ShippingDetailsDataManager

private final class details extends AsyncTask
{

    private final EbayTradingApi api;
    private ArrayList details;
    final ShippingDetailsDataManager this$0;

    protected transient Content doInBackground( a[])
    {
        Object obj2 = null;
        Object obj1 = null;
        if (a[0].site != null)
        {
            obj1 = (EbayDetail)ShippingDetailsDataManager.access$100().get(ShippingDetailsDataManager.access$000(a[0].site));
        }
        ResultStatusOwner resultstatusowner = new ResultStatusOwner();
        Object obj;
        Content content;
        if (obj1 == null)
        {
            if (ShippingDetailsDataManager.logTag.)
            {
                ShippingDetailsDataManager.logTag.((new StringBuilder()).append("cache miss on site ").append(a[0].site).toString());
            }
            obj = new GetEbayDetailsRequest(api, details);
            GetEbayDetailsResponse getebaydetailsresponse = (GetEbayDetailsResponse)ShippingDetailsDataManager.access$200(ShippingDetailsDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), resultstatusowner);
            obj = obj1;
            content = obj2;
            if (resultstatusowner.getResultStatus() != ResultStatus.CANCELED)
            {
                if (!resultstatusowner.getResultStatus().hasError())
                {
                    obj1 = getebaydetailsresponse.detail;
                    if (ShippingDetailsDataManager.logTag.)
                    {
                        ShippingDetailsDataManager.logTag.((new StringBuilder()).append("caching site ").append(a[0].site).toString());
                    }
                    obj = obj1;
                    content = obj2;
                    if (a[0].site != null)
                    {
                        ShippingDetailsDataManager.access$100().put(ShippingDetailsDataManager.access$000(a[0].site), obj1);
                        content = obj2;
                        obj = obj1;
                    }
                } else
                {
                    content = new Content(null, resultstatusowner.getResultStatus());
                    obj = null;
                }
            }
        } else
        {
            obj = obj1;
            content = obj2;
            if (ShippingDetailsDataManager.logTag.)
            {
                ShippingDetailsDataManager.logTag.((new StringBuilder()).append("cache hit on site ").append(a[0].site).toString());
                obj = obj1;
                content = obj2;
            }
        }
        if (obj != null)
        {
            a = new HashMap();
            if (((EbayDetail) (obj)).shippingServiceDetails != null)
            {
                for (obj = ((EbayDetail) (obj)).shippingServiceDetails.iterator(); ((Iterator) (obj)).hasNext(); a.put(((com.ebay.common.model.ams.site) (obj1)).ppingService, obj1))
                {
                    obj1 = (com.ebay.common.model.ppingService)((Iterator) (obj)).next();
                }

            }
            content = new Content(a, resultstatusowner.getResultStatus());
        }
        return content;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground(([])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleLoadDataResult(this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleLoadDataResult(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (EbayTradingApi ebaytradingapi, ArrayList arraylist)
    {
        this$0 = ShippingDetailsDataManager.this;
        super();
        details = new ArrayList();
        api = ebaytradingapi;
        details = arraylist;
    }
}
