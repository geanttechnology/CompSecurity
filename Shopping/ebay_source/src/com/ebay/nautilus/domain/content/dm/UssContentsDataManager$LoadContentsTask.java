// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.unifiedstream.UnifiedStreamRequest;
import com.ebay.nautilus.domain.net.api.unifiedstream.UnifiedStreamResponse;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssContentsDataManager

private final class t> extends t>
{

    UnifiedStreamResponse response;
    final UssContentsDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        Object obj;
        UssContentsDataManager usscontentsdatamanager;
        obj = getRequestParams(keyParams, lastRequestTime, null);
        usscontentsdatamanager = UssContentsDataManager.this;
        if (auth == null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        avoid = auth.iafToken;
_L1:
        response = (UnifiedStreamResponse)UssContentsDataManager.access$000(usscontentsdatamanager, new UnifiedStreamRequest(avoid, country, ((com.ebay.nautilus.domain.net.api.unifiedstream._0A__20__20__20__20__20__20__20__20_h) (obj))));
        avoid = response.getResultStatus();
        lastRequestTime = response.requestTime;
        if (avoid.hasError())
        {
            return new Content(avoid);
        }
        obj = response.streamContents;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        avoid = new Content(obj, avoid);
        UssContentsDataManager.cacheManager.put(getCacheKey(auth, country.getSite().id), new rd(avoid));
        return avoid;
        avoid;
        return null;
        avoid = null;
          goto _L1
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    public rd(Authentication authentication, EbayCountry ebaycountry, rd rd)
    {
        this$0 = UssContentsDataManager.this;
        super(UssContentsDataManager.this, authentication, ebaycountry, rd);
    }
}
