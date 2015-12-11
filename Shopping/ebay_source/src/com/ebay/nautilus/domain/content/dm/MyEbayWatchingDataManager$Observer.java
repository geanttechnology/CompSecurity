// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayWatchingDataManager

public static interface 
{

    public abstract void onAddToWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, Content content);

    public abstract void onRemoveAllFromWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, ResultStatus resultstatus);

    public abstract void onRemoveFromWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, Content content);

    public abstract void onWatchingListChanged(MyEbayWatchingDataManager myebaywatchingdatamanager, String s, DatedContent datedcontent);
}
