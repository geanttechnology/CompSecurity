// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.data.Event;
import com.ebay.nautilus.domain.net.api.events.EventItemsRequest;
import com.ebay.nautilus.domain.net.api.events.EventItemsResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            PagedListManager, EventItemsDataManager

private final class highestPageIndex extends PagedListManager
{

    private final EbayCountry country;
    final EventItemsDataManager this$0;

    protected ResultStatus getPage(int i, ArrayList arraylist)
        throws InterruptedException
    {
        Object obj = EventItemsDataManager.getRequestParams(i, EventItemsDataManager.access$000(), country, EventItemsDataManager.access$100(EventItemsDataManager.this), EventItemsDataManager.access$200(EventItemsDataManager.this), EventItemsDataManager.access$300(EventItemsDataManager.this), EventItemsDataManager.access$400(EventItemsDataManager.this));
        obj = new EventItemsRequest(country, ((com.ebay.nautilus.domain.net.api.events.try) (obj)));
        EventItemsResponse eventitemsresponse = (EventItemsResponse)EventItemsDataManager.access$500(EventItemsDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)));
        obj = eventitemsresponse.getResultStatus();
        if (!((ResultStatus) (obj)).hasError())
        {
            EventItemsDataManager.access$602(EventItemsDataManager.this, eventitemsresponse.event);
            if (EventItemsDataManager.access$600(EventItemsDataManager.this) != null)
            {
                com.ebay.nautilus.domain.data.ams ams = EventItemsDataManager.access$600(EventItemsDataManager.this).paginationResponse;
                totalNumberOfItems = (int)EventItemsDataManager.access$600(EventItemsDataManager.this).matchCount;
                highestPageIndex = ams.highestPageIndex;
                if (EventItemsDataManager.access$600(EventItemsDataManager.this).searchRecord != null)
                {
                    for (Iterator iterator = EventItemsDataManager.access$600(EventItemsDataManager.this).searchRecord.iterator(); iterator.hasNext(); arraylist.add((com.ebay.nautilus.domain.data.oader.this._cls0)iterator.next())) { }
                }
            }
        }
        return ((ResultStatus) (obj));
    }

    protected void handleLoadListResult(ListContent listcontent)
    {
        ((this._cls0)EventItemsDataManager.access$700(EventItemsDataManager.this)).ontentChanged(EventItemsDataManager.this, listcontent);
    }

    protected void onLoadStarted()
    {
    }

    public (EbayCountry ebaycountry)
    {
        this$0 = EventItemsDataManager.this;
        super(EventItemsDataManager.MAX_ENTRIES_PER_PAGE);
        country = ebaycountry;
        totalNumberOfItems = 0x7ffffffe;
        highestPageIndex = 0x7ffffffe;
    }
}
