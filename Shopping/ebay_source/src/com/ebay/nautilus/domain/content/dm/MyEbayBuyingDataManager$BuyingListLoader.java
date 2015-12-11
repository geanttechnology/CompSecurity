// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbayBuyingRequest;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbayResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            PagedListManager, MyEbayBuyingDataManager

private abstract class sort extends PagedListManager
{

    public ListCountContent listCount;
    public final String listName;
    public String sort;
    final MyEbayBuyingDataManager this$0;

    public ResultStatus getPage(int i, ArrayList arraylist)
        throws InterruptedException
    {
        if (i < 1 || i > 100)
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
            obj = new GetMyEbayBuyingRequest(((com.ebay.nautilus.domain.net.api.trading.EbayTradingApi) (obj1)), listName, itemsPerPage, i, sort);
            GetMyEbayResponse getmyebayresponse = (GetMyEbayResponse)MyEbayBuyingDataManager.access$200(MyEbayBuyingDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)));
            obj1 = getmyebayresponse.getResultStatus();
            obj = obj1;
            if (!((ResultStatus) (obj1)).hasError())
            {
                if (getmyebayresponse.resultItemList != null)
                {
                    arraylist.addAll(getmyebayresponse.resultItemList);
                }
                totalNumberOfItems = getmyebayresponse.totalEntries;
                highestPageIndex = getmyebayresponse.totalPages;
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
        this(s, null);
    }

    public <init>(String s, String s1)
    {
        this$0 = MyEbayBuyingDataManager.this;
        super(25);
        listCount = null;
        listName = s;
        sort = s1;
    }
}
