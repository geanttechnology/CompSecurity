// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayBuyingDataManager

private final class er extends er
{

    final MyEbayBuyingDataManager this$0;

    public void onCountChanged(ListCountContent listcountcontent)
    {
        ((er)MyEbayBuyingDataManager.access$500(MyEbayBuyingDataManager.this)).CountChanged(MyEbayBuyingDataManager.this, listcountcontent);
    }

    public void onListChanged(ListContent listcontent)
    {
        ((this._cls0)MyEbayBuyingDataManager.access$600(MyEbayBuyingDataManager.this)).ListChanged(MyEbayBuyingDataManager.this, listcontent);
    }

    public er()
    {
        this$0 = MyEbayBuyingDataManager.this;
        super(MyEbayBuyingDataManager.this, "WonList");
    }
}
