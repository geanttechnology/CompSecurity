// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.unifiedstream.UssChannelsRequest;
import com.ebay.nautilus.domain.net.api.unifiedstream.UssChannelsResponse;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssChannelsDataManager

private final class auth extends AsyncTask
{

    private final Authentication auth;
    private final EbayCountry country;
    UssChannelsResponse response;
    final UssChannelsDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        Object obj;
        obj = UssChannelsDataManager.this;
        if (auth == null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        avoid = auth.iafToken;
_L1:
        response = (UssChannelsResponse)UssChannelsDataManager.access$000(((UssChannelsDataManager) (obj)), new UssChannelsRequest(avoid, country));
        avoid = response.getResultStatus();
        if (avoid.hasError())
        {
            return new Content(avoid);
        }
        obj = new Content(response.container, avoid);
        avoid = ((Void []) (obj));
        if (response.container == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        UssChannelsDataManager.cacheManager.put(getCacheKey(auth, country.getSite().id), new acheRecord(((Content) (obj))));
        return ((Content) (obj));
        avoid;
        avoid = null;
        return avoid;
        avoid = null;
          goto _L1
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleLoadDataResult(null, null);
        loadTask = null;
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleLoadDataResult(content, null);
        loadTask = null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public acheRecord(Authentication authentication, EbayCountry ebaycountry)
    {
        this$0 = UssChannelsDataManager.this;
        super();
        country = ebaycountry;
        auth = authentication;
    }
}
