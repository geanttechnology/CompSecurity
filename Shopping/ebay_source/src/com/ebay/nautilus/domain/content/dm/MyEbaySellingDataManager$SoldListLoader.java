// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;
import com.ebay.nautilus.domain.content.PaymentReminderStorageUtil;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbaySellingDataManager

private final class er extends er
{

    final MyEbaySellingDataManager this$0;

    public void onCountChanged(ListCountContent listcountcontent)
    {
        ((er)MyEbaySellingDataManager.access$800(MyEbaySellingDataManager.this)).CountChanged(MyEbaySellingDataManager.this, listcountcontent);
    }

    public void onListChanged(ListContent listcontent)
    {
        ((this._cls0)MyEbaySellingDataManager.access$900(MyEbaySellingDataManager.this)).ListChanged(MyEbaySellingDataManager.this, listcontent);
        listcontent = null;
        if (MyEbaySellingDataManager.access$1000(MyEbaySellingDataManager.this).getData() != null)
        {
            listcontent = MyEbaySellingDataManager.access$1000(MyEbaySellingDataManager.this).getData().getList();
        }
        PaymentReminderStorageUtil.flushSoldAndOldRecords(listcontent);
    }

    public er()
    {
        this$0 = MyEbaySellingDataManager.this;
        super(MyEbaySellingDataManager.this, "SoldList");
    }
}
