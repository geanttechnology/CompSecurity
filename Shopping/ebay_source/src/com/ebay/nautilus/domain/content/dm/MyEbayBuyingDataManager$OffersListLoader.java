// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayBuyingDataManager

private final class <init> extends <init>
{

    final MyEbayBuyingDataManager this$0;

    public void onCountChanged(ListCountContent listcountcontent)
    {
        ((<init>)MyEbayBuyingDataManager.access$900(MyEbayBuyingDataManager.this)).OffersCountChanged(MyEbayBuyingDataManager.this, listcountcontent);
    }

    public void onListChanged(ListContent listcontent)
    {
        ((this._cls0)MyEbayBuyingDataManager.access$1000(MyEbayBuyingDataManager.this)).OffersListChanged(MyEbayBuyingDataManager.this, listcontent);
    }

    public (String s)
    {
        this$0 = MyEbayBuyingDataManager.this;
        super(MyEbayBuyingDataManager.this, "BestOfferList", s);
    }
}
