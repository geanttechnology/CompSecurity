// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssContentsDataManager

private final class contentSources extends AsyncTask
{

    private final Authentication auth;
    private ArrayList contentSources;
    private final EbayCountry country;
    private final ArrayList observers = new ArrayList();
    final UssContentsDataManager this$0;

    public transient void attach(contentSources contentsources, ContentSourceEnum acontentsourceenum[])
    {
label0:
        {
            if (contentsources != null)
            {
                observers.add(contentsources);
            }
            if (contentSources != null)
            {
                if (acontentsourceenum != null && acontentsourceenum.length != 0)
                {
                    break label0;
                }
                contentSources = null;
            }
            return;
        }
        contentSources.addAll(Arrays.asList(acontentsourceenum));
    }

    protected transient rd doInBackground(Void avoid[])
    {
        avoid = null;
        String s = getCacheKey(auth, country.getSite().id);
        if (s != null)
        {
            if (UssContentsDataManager.logger.country)
            {
                UssContentsDataManager.logger.country((new StringBuilder()).append("cache lookup ").append(s).toString());
            }
            avoid = (rd)UssContentsDataManager.cacheManager.get(s);
        } else
        if (UssContentsDataManager.logger.r)
        {
            UssContentsDataManager.logger.r("lookup aborted, invalid key");
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
        boolean flag1;
        super.onPostExecute(rd);
        flag1 = false;
        if (rd != null && flushCacheTask == null) goto _L2; else goto _L1
_L1:
        if (UssContentsDataManager.logger.ask)
        {
            UssContentsDataManager.logger.ask("cache miss, forcing update");
        }
        if (loadTask == null)
        {
            getContentsAsync(auth, country);
        } else
        if (UssContentsDataManager.logger.country)
        {
            UssContentsDataManager.logger.country("aborting update, already in progress");
        }
_L4:
        consultCacheTask = null;
        return;
_L2:
        boolean flag;
        if (!rd.isStale() && !rd.isStaleContentSources(contentSources))
        {
            break; /* Loop/switch isn't completed */
        }
        if (UssContentsDataManager.logger.contentSources)
        {
            UssContentsDataManager.logger.contentSources("cache hit but entry is stale, forcing update");
        }
        flag1 = true;
        if (loadTask == null)
        {
            getContentsAsync(auth, country);
            flag = flag1;
        } else
        {
            flag = flag1;
            if (UssContentsDataManager.logger.country)
            {
                UssContentsDataManager.logger.country("aborting update, already in progress");
                flag = flag1;
            }
        }
_L5:
        handleLoadDataResult(new Content(rd.content), true, flag, observers);
        if (true) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (UssContentsDataManager.logger.observers)
        {
            UssContentsDataManager.logger.observers("cache hit");
            flag = flag1;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((rd)obj);
    }

    protected transient rd(Authentication authentication, EbayCountry ebaycountry, rd rd, ContentSourceEnum acontentsourceenum[])
    {
        this$0 = UssContentsDataManager.this;
        super();
        auth = authentication;
        country = ebaycountry;
        if (rd != null)
        {
            observers.add(rd);
        }
        contentSources = new ArrayList();
        if (acontentsourceenum != null)
        {
            contentSources.addAll(Arrays.asList(acontentsourceenum));
        }
    }
}
