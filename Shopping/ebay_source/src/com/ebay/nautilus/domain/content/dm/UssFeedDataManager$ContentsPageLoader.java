// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.data.UnifiedStream.Pagination;
import com.ebay.nautilus.domain.net.api.unifiedstream.UnifiedStreamRequest;
import com.ebay.nautilus.domain.net.api.unifiedstream.UnifiedStreamResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            PagedListManager, UssFeedDataManager

private final class highestPageIndex extends PagedListManager
{

    private final Authentication auth;
    private final EbayCountry country;
    final UssFeedDataManager this$0;

    private Pagination getPagination(List list, ContentSourceEnum contentsourceenum)
    {
label0:
        {
            if (list == null)
            {
                break label0;
            }
            list = list.iterator();
            Pagination pagination;
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
                pagination = (Pagination)list.next();
            } while (pagination.contentSource != contentsourceenum);
            return pagination;
        }
        return null;
    }

    protected ResultStatus getPage(int i, ArrayList arraylist)
        throws InterruptedException
    {
        Object obj;
        Object obj2;
        com.ebay.nautilus.domain.data.UnifiedStream.sting sting;
        int j;
        Object obj1 = UssFeedDataManager.getRequestParams(lastRequestTime, lastOutputPagination);
        obj2 = UssFeedDataManager.this;
        Iterator iterator;
        Iterator iterator1;
        com.ebay.nautilus.domain.data.UnifiedStream.sting sting1;
        if (auth != null)
        {
            obj = auth.iafToken;
        } else
        {
            obj = null;
        }
        obj1 = (UnifiedStreamResponse)UssFeedDataManager.access$000(((UssFeedDataManager) (obj2)), new UnifiedStreamRequest(((String) (obj)), country, ((com.ebay.nautilus.domain.net.api.unifiedstream.ng) (obj1))));
        obj = ((UnifiedStreamResponse) (obj1)).getResultStatus();
        lastRequestTime = ((UnifiedStreamResponse) (obj1)).requestTime;
        if (((ResultStatus) (obj)).hasError())
        {
            break MISSING_BLOCK_LABEL_463;
        }
        obj1 = ((UnifiedStreamResponse) (obj1)).streamContents;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_463;
        }
        lastOutputPagination = ((Contents) (obj1)).paginationOutput.pagination;
        j = 0;
        i = 0;
        if (((Contents) (obj1)).contentGroups == null) goto _L2; else goto _L1
_L1:
        obj1 = ((Contents) (obj1)).contentGroups.iterator();
_L5:
        j = i;
        if (!((Iterator) (obj1)).hasNext()) goto _L2; else goto _L3
_L3:
        obj2 = (com.ebay.nautilus.domain.data.UnifiedStream..pagination)((Iterator) (obj1)).next();
        if (obj2 == null) goto _L5; else goto _L4
_L4:
        iterator = ((com.ebay.nautilus.domain.data.UnifiedStream..pagination) (obj2)).pagination.iterator();
        j = i;
_L8:
        i = j;
        if (!iterator.hasNext()) goto _L5; else goto _L6
_L6:
        sting = (com.ebay.nautilus.domain.data.UnifiedStream..pagination)iterator.next();
        if (sting == null) goto _L8; else goto _L7
_L7:
        i = 1;
        if (sting.pe == null) goto _L10; else goto _L9
_L9:
        ay.nautilus.domain.data.UnifiedStream.ContentTypeEnum[sting.pe.ordinal()];
        JVM INSTR tableswitch 1 2: default 260
    //                   1 266
    //                   2 266;
           goto _L11 _L12 _L12
_L11:
        j = i;
          goto _L8
_L12:
        iterator1 = sting.stings.iterator();
_L14:
        j = i;
        if (!iterator1.hasNext()) goto _L8; else goto _L13
_L13:
        sting1 = (com.ebay.nautilus.domain.data.UnifiedStream.sting)iterator1.next();
        arraylist.add(new it>(UssFeedDataManager.this, sting.pe, sting.tle, sting1));
          goto _L14
_L10:
        j = i;
        if (!ContentSourceEnum.FEED.equals(((com.ebay.nautilus.domain.data.UnifiedStream.sting) (obj2)).sting)) goto _L8; else goto _L15
_L15:
        j = i;
        if (sting.edEvent == null) goto _L8; else goto _L16
_L16:
        j = i;
        if (sting.edEvent.listings == null) goto _L8; else goto _L17
_L17:
        Iterator iterator2 = sting.edEvent.listings.iterator();
_L19:
        j = i;
        if (!iterator2.hasNext()) goto _L8; else goto _L18
_L18:
        com.ebay.nautilus.domain.data.UnifiedStream.sting sting2 = (com.ebay.nautilus.domain.data.UnifiedStream.sting)iterator2.next();
        arraylist.add(new it>(UssFeedDataManager.this, ContentTypeEnum.LISTING, sting.tle, sting2));
          goto _L19
          goto _L8
_L2:
        if (j == 0)
        {
            totalNumberOfItems = arraylist.size();
        }
        return ((ResultStatus) (obj));
    }

    protected void handleLoadListResult(ListContent listcontent)
    {
        ((totalNumberOfItems)UssFeedDataManager.access$100(UssFeedDataManager.this)).stChanged(UssFeedDataManager.this, listcontent);
    }

    protected void onLoadStarted()
    {
    }

    public ecord.FeedEvent(EbayCountry ebaycountry, Authentication authentication)
    {
        this$0 = UssFeedDataManager.this;
        super(25);
        country = ebaycountry;
        auth = authentication;
        totalNumberOfItems = 0x7ffffffe;
        highestPageIndex = 0x7ffffffe;
    }
}
