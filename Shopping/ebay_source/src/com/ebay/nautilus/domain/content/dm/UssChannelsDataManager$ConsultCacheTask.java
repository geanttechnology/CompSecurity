// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssChannelsDataManager

private final class observers extends AsyncTask
{

    private final Authentication auth;
    private final EbayCountry country;
    private final ArrayList observers = new ArrayList();
    final UssChannelsDataManager this$0;

    public void attach(observers observers1)
    {
        if (observers1 != null)
        {
            observers.add(observers1);
        }
    }

    protected transient rd doInBackground(Void avoid[])
    {
        avoid = null;
        String s = getCacheKey(auth, country.getSite().id);
        if (s != null)
        {
            if (UssChannelsDataManager.logger.country)
            {
                UssChannelsDataManager.logger.country((new StringBuilder()).append("cache lookup ").append(s).toString());
            }
            avoid = (rd)UssChannelsDataManager.cacheManager.get(s);
        } else
        if (UssChannelsDataManager.logger.r)
        {
            UssChannelsDataManager.logger.r("lookup aborted, invalid key");
            return null;
        }
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(rd rd)
    {
        super.onPostExecute(rd);
        if (rd != null && flushCacheTask == null) goto _L2; else goto _L1
_L1:
        if (UssChannelsDataManager.logger.ask)
        {
            UssChannelsDataManager.logger.ask("cache miss, forcing update");
        }
        if (loadTask == null)
        {
            getContentsAsync(auth, country);
        } else
        if (UssChannelsDataManager.logger.country)
        {
            UssChannelsDataManager.logger.country("aborting update, already in progress");
        }
_L4:
        consultCacheTask = null;
        return;
_L2:
        if (!rd.isStale())
        {
            break; /* Loop/switch isn't completed */
        }
        if (UssChannelsDataManager.logger.isStale)
        {
            UssChannelsDataManager.logger.isStale("cache hit but entry is stale, forcing update");
        }
        if (loadTask == null)
        {
            getContentsAsync(auth, country);
        } else
        if (UssChannelsDataManager.logger.country)
        {
            UssChannelsDataManager.logger.country("aborting update, already in progress");
        }
_L6:
        handleLoadDataResult(new Content(rd.channelsContainer), observers);
        if (true) goto _L4; else goto _L3
_L3:
        if (!UssChannelsDataManager.logger.observers) goto _L6; else goto _L5
_L5:
        UssChannelsDataManager.logger.observers("cache hit");
          goto _L6
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((rd)obj);
    }

    protected rd(Authentication authentication, EbayCountry ebaycountry, rd rd)
    {
        this$0 = UssChannelsDataManager.this;
        super();
        auth = authentication;
        country = ebaycountry;
        if (rd != null)
        {
            observers.add(rd);
        }
    }
}
