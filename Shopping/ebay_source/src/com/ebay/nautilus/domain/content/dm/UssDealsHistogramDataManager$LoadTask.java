// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.unifiedstream.UssDealsHistogramRequest;
import com.ebay.nautilus.domain.net.api.unifiedstream.UssDealsHistogramResponse;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssDealsHistogramDataManager

private final class country extends AsyncTask
{

    private final EbayCountry country;
    UssDealsHistogramResponse response;
    final UssDealsHistogramDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        try
        {
            response = (UssDealsHistogramResponse)UssDealsHistogramDataManager.access$100(UssDealsHistogramDataManager.this, new UssDealsHistogramRequest(country));
            avoid = response.getResultStatus();
            if (avoid.hasError())
            {
                return new Content(avoid);
            }
            avoid = new Content(response.container.archRefinement, avoid);
            UssDealsHistogramDataManager.access$300().put(UssDealsHistogramDataManager.access$200(UssDealsHistogramDataManager.this, country.getSite().id), new ogramCacheRecord(avoid));
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return null;
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
        handleLoadDataResult(null);
        UssDealsHistogramDataManager.access$402(UssDealsHistogramDataManager.this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleLoadDataResult(content);
        UssDealsHistogramDataManager.access$402(UssDealsHistogramDataManager.this, null);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public ogramCacheRecord(EbayCountry ebaycountry)
    {
        this$0 = UssDealsHistogramDataManager.this;
        super();
        country = ebaycountry;
    }
}
