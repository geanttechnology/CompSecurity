// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.recents;

import com.ebay.nautilus.domain.content.Content;

// Referenced classes of package com.ebay.mobile.recents:
//            RecentsDataManager

public static interface _cls9
{

    public abstract void onAllSearchItemDeleteComplete(RecentsDataManager recentsdatamanager, Content content);

    public abstract void onAllViewedItemDeleteComplete(RecentsDataManager recentsdatamanager, Content content);

    public abstract void onGetRecentlySearchedData(RecentsDataManager recentsdatamanager, Content content);

    public abstract void onSearchItemAddComplete(RecentsDataManager recentsdatamanager, Content content);

    public abstract void onViewedItemAddComplete(RecentsDataManager recentsdatamanager, Content content);
}
