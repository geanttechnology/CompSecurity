// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayBuyingDataManager

public static interface 
{

    public abstract void onBiddingCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent);

    public abstract void onBiddingListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent);

    public abstract void onBuyingOffersCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent);

    public abstract void onBuyingOffersListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent);

    public abstract void onNotWonCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent);

    public abstract void onNotWonListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent);

    public abstract void onRemoveFromNotWonListComplete(MyEbayBuyingDataManager myebaybuyingdatamanager, Content content);

    public abstract void onRemoveFromWonListComplete(MyEbayBuyingDataManager myebaybuyingdatamanager, Content content);

    public abstract void onWonCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent);

    public abstract void onWonListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent);
}
