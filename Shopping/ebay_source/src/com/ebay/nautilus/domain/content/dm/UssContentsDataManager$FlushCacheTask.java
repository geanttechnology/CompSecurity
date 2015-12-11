// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssContentsDataManager

private final class country extends AsyncTask
{

    private final Authentication auth;
    private final EbayCountry country;
    final UssContentsDataManager this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        UssContentsDataManager.cacheManager.remove(getCacheKey(auth, country.getSite().id));
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        flushCacheTask = null;
    }

    public (Authentication authentication, EbayCountry ebaycountry)
    {
        this$0 = UssContentsDataManager.this;
        super();
        auth = authentication;
        country = ebaycountry;
    }
}
