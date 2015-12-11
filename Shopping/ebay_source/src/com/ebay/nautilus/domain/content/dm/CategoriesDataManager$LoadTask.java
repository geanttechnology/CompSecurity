// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.GetCategoryFeaturesRequest;
import com.ebay.nautilus.domain.net.api.trading.GetCategoryFeaturesResponse;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            CategoriesDataManager

private final class api extends AsyncTask
{

    private final EbayTradingApi api;
    final CategoriesDataManager this$0;

    protected transient Content doInBackground( a[])
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        if (a[0].site == null) goto _L2; else goto _L1
_L1:
        ories ories1;
        ResultStatusOwner resultstatusowner;
        ories1 = (ories)CategoriesDataManager.access$100().get(CategoriesDataManager.access$000(a[0].site));
        resultstatusowner = new ResultStatusOwner();
        if (ories1 != null && ories1.categoriesIdsRequiringConsent != null) goto _L4; else goto _L3
_L3:
        ories ories;
        if (CategoriesDataManager.logTag.Tag)
        {
            CategoriesDataManager.logTag.Tag((new StringBuilder()).append("cache miss on site ").append(a[0].site).toString());
        }
        obj = new GetCategoryFeaturesRequest(api);
        GetCategoryFeaturesResponse getcategoryfeaturesresponse = (GetCategoryFeaturesResponse)CategoriesDataManager.access$200(CategoriesDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), resultstatusowner);
        ories = ories1;
        obj = obj1;
        if (resultstatusowner.getResultStatus() != ResultStatus.CANCELED)
        {
            if (!resultstatusowner.getResultStatus().hasError())
            {
                if (CategoriesDataManager.logTag.Tag)
                {
                    CategoriesDataManager.logTag.Tag((new StringBuilder()).append("caching site ").append(a[0].site).toString());
                }
                ories = new ories();
                ories.categoriesIdsRequiringConsent = getcategoryfeaturesresponse.categoriesRequiringConsent;
                CategoriesDataManager.access$100().put(CategoriesDataManager.access$000(a[0].site), ories);
                obj = obj1;
            } else
            {
                obj = new Content(null, resultstatusowner.getResultStatus());
                ories = ories1;
            }
        }
_L6:
        if (ories != null)
        {
            obj = new Content(ories, resultstatusowner.getResultStatus());
        }
_L2:
        return ((Content) (obj));
_L4:
        ories = ories1;
        obj = obj1;
        if (CategoriesDataManager.logTag.Tag)
        {
            CategoriesDataManager.logTag.Tag((new StringBuilder()).append("cache hit on site ").append(a[0].site).toString());
            ories = ories1;
            obj = obj1;
        }
        if (true) goto _L6; else goto _L5
_L5:
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

    public (EbayTradingApi ebaytradingapi)
    {
        this$0 = CategoriesDataManager.this;
        super();
        api = ebaytradingapi;
    }
}
