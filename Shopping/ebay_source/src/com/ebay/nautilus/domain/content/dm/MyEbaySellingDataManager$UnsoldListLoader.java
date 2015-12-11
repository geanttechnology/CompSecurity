// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbaySellingDataManager

private final class  extends 
{

    final MyEbaySellingDataManager this$0;

    public void onCountChanged(ListCountContent listcountcontent)
    {
        (()MyEbaySellingDataManager.access$1100(MyEbaySellingDataManager.this)).CountChanged(MyEbaySellingDataManager.this, listcountcontent);
    }

    public void onListChanged(ListContent listcontent)
    {
        ((this._cls0)MyEbaySellingDataManager.access$1200(MyEbaySellingDataManager.this)).ListChanged(MyEbaySellingDataManager.this, listcontent);
    }

    public ()
    {
        this$0 = MyEbaySellingDataManager.this;
        super(MyEbaySellingDataManager.this, "UnsoldList");
    }
}
