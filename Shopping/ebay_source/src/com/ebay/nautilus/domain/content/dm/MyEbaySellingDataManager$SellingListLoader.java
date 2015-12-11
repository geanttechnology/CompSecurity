// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbayResponse;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbaySellingRequest;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            PagedListManager, MyEbaySellingDataManager

private abstract class highestPageAllowed extends PagedListManager
{

    public final int highestPageAllowed;
    public ListCountContent listCount;
    public final String listName;
    final MyEbaySellingDataManager this$0;

    protected GetMyEbaySellingRequest createGetMyEbaySellingRequest(int i, EbayTradingApi ebaytradingapi)
    {
        return new GetMyEbaySellingRequest(ebaytradingapi, listName, itemsPerPage, i, null, null);
    }

    public ResultStatus getPage(int i, ArrayList arraylist)
        throws InterruptedException
    {
        if (i < 1 || i > highestPageAllowed)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("pageIndex(").append(i).append(") out of range").toString());
        }
        Object obj = new ResultStatusOwner();
        Object obj1 = getApi(((ResultStatusOwner) (obj)));
        if (obj1 == null)
        {
            obj = ((ResultStatusOwner) (obj)).getResultStatus();
        } else
        {
            obj = createGetMyEbaySellingRequest(i, ((EbayTradingApi) (obj1)));
            GetMyEbayResponse getmyebayresponse = (GetMyEbayResponse)MyEbaySellingDataManager.access$300(MyEbaySellingDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)));
            obj1 = getmyebayresponse.getResultStatus();
            obj = obj1;
            if (!((ResultStatus) (obj1)).hasError())
            {
                if (getmyebayresponse.resultItemList != null)
                {
                    arraylist.addAll(getmyebayresponse.resultItemList);
                }
                totalNumberOfItems = getmyebayresponse.totalEntries;
                if (getmyebayresponse.totalPages > highestPageAllowed)
                {
                    i = highestPageAllowed;
                } else
                {
                    i = getmyebayresponse.totalPages;
                }
                highestPageIndex = i;
                return ((ResultStatus) (obj1));
            }
        }
        return ((ResultStatus) (obj));
    }

    public void handleLoadListResult(ListContent listcontent)
    {
        if (listcontent.getStatus().hasError()) goto _L2; else goto _L1
_L1:
        if (listCount != null && listCount.getTotalItemCount() == listcontent.getTotalItemCount()) goto _L4; else goto _L3
_L3:
        ListCountContent listcountcontent = new ListCountContent(listcontent);
        listCount = listcountcontent;
        onCountChanged(listcountcontent);
_L2:
        onListChanged(listcontent);
        return;
_L4:
        if (listCount.getLastUpdatedMillis() < listcontent.getLastUpdatedMillis())
        {
            listCount = new ListCountContent(listcontent);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public abstract void onCountChanged(ListCountContent listcountcontent);

    public abstract void onListChanged(ListContent listcontent);

    protected void onLoadStarted()
    {
    }

    public (String s)
    {
        this(s, 25, 100);
    }

    public <init>(String s, int i, int j)
    {
        this$0 = MyEbaySellingDataManager.this;
        super(i);
        listCount = null;
        listName = s;
        highestPageAllowed = j;
    }
}
