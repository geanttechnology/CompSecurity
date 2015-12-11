// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.SellingListRefinement;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbaySellingRequest;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbaySellingDataManager

private final class init> extends init>
{

    private static final int BEST_OFFER_ITEMS_PER_PAGE = 200;
    private ListCountContent listCountOffers;
    private ListContent listDataOffers;
    final MyEbaySellingDataManager this$0;

    protected GetMyEbaySellingRequest createGetMyEbaySellingRequest(int i, EbayTradingApi ebaytradingapi)
    {
        return new GetMyEbaySellingRequest(ebaytradingapi, listName, itemsPerPage, i, "BestOfferCountDescending", null);
    }

    public final ListContent getOfferListData()
    {
        this;
        JVM INSTR monitorenter ;
        ListContent listcontent = listDataOffers;
        this;
        JVM INSTR monitorexit ;
        return listcontent;
        Exception exception;
        exception;
        throw exception;
    }

    public void markDirty()
    {
        this;
        JVM INSTR monitorenter ;
        super.arkDirty();
        listDataOffers = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onCountChanged(ListCountContent listcountcontent)
    {
    }

    public void onListChanged(ListContent listcontent)
    {
        ResultStatus resultstatus = listcontent.getStatus();
        if (resultstatus.hasError())
        {
            ((listDataOffers)MyEbaySellingDataManager.access$600(MyEbaySellingDataManager.this)).istChanged(MyEbaySellingDataManager.this, listcontent, refinement);
            return;
        }
        List list = listcontent.getList();
        boolean flag = false;
        int i = 0;
        Object obj1 = null;
        Object obj = obj1;
        int j = ((flag) ? 1 : 0);
        if (list != null)
        {
            obj = obj1;
            j = ((flag) ? 1 : 0);
            if (!list.isEmpty())
            {
                obj = list.iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    MyEbayListItem myebaylistitem = (MyEbayListItem)((Iterator) (obj)).next();
                    if (!myebaylistitem.bestOfferEnabled || myebaylistitem.bestOfferPendingCount <= 0)
                    {
                        break;
                    }
                    i++;
                } while (true);
                obj = obj1;
                j = i;
                if (i > 0)
                {
                    obj = list.subList(0, i);
                    j = i;
                }
            }
        }
        long l;
        if (obj == null)
        {
            obj = Collections.emptyList();
        } else
        {
            obj = Collections.unmodifiableList(((List) (obj)));
        }
        l = listcontent.getLastUpdatedMillis();
        if (listCountOffers == null || listCountOffers.getTotalItemCount() != j)
        {
            listCountOffers = new ListCountContent(j, resultstatus, l);
        }
        listDataOffers = new ListContent(((List) (obj)), j, listcontent.getPagesLoaded(), listcontent.getHighestPageIndex(), j, j, resultstatus, l);
        ((listDataOffers)MyEbaySellingDataManager.access$700(MyEbaySellingDataManager.this)).istChanged(MyEbaySellingDataManager.this, listDataOffers, refinement);
    }


    public (SellingListRefinement sellinglistrefinement)
    {
        this$0 = MyEbaySellingDataManager.this;
        super(MyEbaySellingDataManager.this, "ActiveList", sellinglistrefinement, 200, 1);
    }
}
