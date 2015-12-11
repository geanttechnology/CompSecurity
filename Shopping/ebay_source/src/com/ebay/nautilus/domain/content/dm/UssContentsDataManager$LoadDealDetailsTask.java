// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.data.UnifiedStream.KeyValue;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.api.unifiedstream.UssDealDetailsRequest;
import com.ebay.nautilus.domain.net.api.unifiedstream.UssListOfListingsResponse;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssContentsDataManager

private final class this._cls0 extends this._cls0
{

    UssListOfListingsResponse response;
    final UssContentsDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        com.ebay.nautilus.domain.net.api.unifiedstream.tent tent = new com.ebay.nautilus.domain.net.api.unifiedstream.tent();
        if (keyParams.textValues != null && keyParams.textValues.size() != 0) goto _L2; else goto _L1
_L2:
        UssContentsDataManager usscontentsdatamanager;
        tent. = ((KeyValue)keyParams.textValues.get(0)).value;
        if (lastRequestTime > 0L)
        {
            tent.ag = EbayDateUtils.formatIso8601DateTime(new Date(lastRequestTime));
        }
        usscontentsdatamanager = UssContentsDataManager.this;
        if (auth == null)
        {
            break MISSING_BLOCK_LABEL_353;
        }
        avoid = auth.iafToken;
_L4:
        response = (UssListOfListingsResponse)UssContentsDataManager.access$100(usscontentsdatamanager, new UssDealDetailsRequest(avoid, country, tent));
        avoid = response.getResultStatus();
        lastRequestTime = response.requestTime;
        if (avoid.hasError())
        {
            return new Content(avoid);
        }
        if (response.streamContents == null || response.streamContents.listings.size() <= 0) goto _L1; else goto _L3
_L3:
        Object obj1 = response.streamContents.listings;
        Object obj = new com.ebay.nautilus.domain.data.UnifiedStream.Content.listings();
        obj.listings = ContentTypeEnum.DEALS_CATEGORY;
        obj.s = ((List) (obj1));
        obj1 = new com.ebay.nautilus.domain.data.UnifiedStream.s();
        obj1.s = ContentSourceEnum.DEALS;
        obj1.s = new ArrayList();
        ((com.ebay.nautilus.domain.data.UnifiedStream.s) (obj1)).s.add(obj);
        obj = new Contents();
        obj.contentGroups = new ArrayList();
        ((Contents) (obj)).contentGroups.add(obj1);
        avoid = new Content(obj, avoid);
        UssContentsDataManager.cacheManager.put(getCacheKey(auth, country.getSite().id), new <init>(avoid));
        return avoid;
_L1:
        return null;
        avoid;
        return null;
        avoid = null;
          goto _L4
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    public (Authentication authentication, EbayCountry ebaycountry,  )
    {
        this$0 = UssContentsDataManager.this;
        super(UssContentsDataManager.this, authentication, ebaycountry, );
    }
}
