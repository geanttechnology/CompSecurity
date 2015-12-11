// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;
import com.ebay.nautilus.domain.content.PaymentReminderStorageUtil;
import com.ebay.nautilus.domain.data.SellingListRefinement;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbaySellingRequest;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbaySellingDataManager

private class refinement extends refinement
{

    SellingListRefinement refinement;
    final MyEbaySellingDataManager this$0;

    protected GetMyEbaySellingRequest createGetMyEbaySellingRequest(int i, EbayTradingApi ebaytradingapi)
    {
        String s;
        String s1;
        byte byte0;
        s = null;
        s1 = refinement.filter;
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 4: default 60
    //                   -2042223450: 112
    //                   -1251545734: 128
    //                   -607502763: 144
    //                   1002796579: 160;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        byte0;
        JVM INSTR tableswitch 0 3: default 92
    //                   0 176
    //                   1 182
    //                   2 188
    //                   3 194;
           goto _L6 _L7 _L8 _L9 _L10
_L6:
        return new GetMyEbaySellingRequest(ebaytradingapi, listName, itemsPerPage, i, null, s);
_L2:
        if (s1.equals("AwaitingShipment"))
        {
            byte0 = 0;
        }
          goto _L1
_L3:
        if (s1.equals("AwaitingPayment"))
        {
            byte0 = 1;
        }
          goto _L1
_L4:
        if (s1.equals("FixedPrice"))
        {
            byte0 = 2;
        }
          goto _L1
_L5:
        if (s1.equals("Auction"))
        {
            byte0 = 3;
        }
          goto _L1
_L7:
        s = "AwaitingShipment";
          goto _L6
_L8:
        s = "AwaitingPayment";
          goto _L6
_L9:
        s = "FixedPriceItem";
          goto _L6
_L10:
        s = "Auction";
          goto _L6
    }

    public void onCountChanged(ListCountContent listcountcontent)
    {
    }

    public void onListChanged(ListContent listcontent)
    {
        java.util.List list = null;
        if (MyEbaySellingDataManager.access$1000(MyEbaySellingDataManager.this).etData() != null)
        {
            list = MyEbaySellingDataManager.access$1000(MyEbaySellingDataManager.this).etData().getList();
        }
        PaymentReminderStorageUtil.flushSoldAndOldRecords(list);
        ((ds)MyEbaySellingDataManager.access$1500(MyEbaySellingDataManager.this)).ListChanged(MyEbaySellingDataManager.this, listcontent, refinement);
    }

    public (String s, SellingListRefinement sellinglistrefinement)
    {
        this(s, sellinglistrefinement, 25, 100);
    }

    public <init>(String s, SellingListRefinement sellinglistrefinement, int i, int j)
    {
        this$0 = MyEbaySellingDataManager.this;
        super(MyEbaySellingDataManager.this, s, i, j);
        refinement = sellinglistrefinement;
    }
}
