// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;
import com.ebay.nautilus.domain.data.SellingListRefinement;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbaySellingDataManager

public static interface 
{

    public abstract void onActiveCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent);

    public abstract void onActiveListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent);

    public abstract void onFilteredListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent, SellingListRefinement sellinglistrefinement);

    public abstract void onRemoveFromSoldListComplete(MyEbaySellingDataManager myebaysellingdatamanager, Content content);

    public abstract void onRemoveFromUnsoldListComplete(MyEbaySellingDataManager myebaysellingdatamanager, Content content);

    public abstract void onScheduledCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent);

    public abstract void onScheduledListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent);

    public abstract void onSoldCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent);

    public abstract void onSoldListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent);

    public abstract void onUnsoldCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent);

    public abstract void onUnsoldListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent);
}
