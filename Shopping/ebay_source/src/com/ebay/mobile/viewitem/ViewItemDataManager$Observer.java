// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.nautilus.domain.content.Content;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

public static interface dled
{

    public abstract void onBidUpdated(ViewItemDataManager viewitemdatamanager, Content content);

    public abstract void onCartChanged(ViewItemDataManager viewitemdatamanager, Content content, dled dled);

    public abstract void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, dled dled, boolean flag);

    public abstract void onGetOrdersCompleted(ViewItemDataManager viewitemdatamanager, Content content);

    public abstract void onPlaceOfferCompleted(ViewItemDataManager viewitemdatamanager, Content content);

    public abstract void onRespondBestOfferCompleted(ViewItemDataManager viewitemdatamanager, Content content);
}
