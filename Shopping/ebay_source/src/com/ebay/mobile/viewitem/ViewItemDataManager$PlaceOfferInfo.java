// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.common.net.api.trading.PlaceOfferResponse;
import com.ebay.mobile.viewitem.message.PlaceOfferResultStatus;
import com.ebay.nautilus.domain.content.Content;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

public final class resultStatus
{

    public String action;
    public Content item;
    public PlaceOfferResponse response;
    public PlaceOfferResultStatus resultStatus;
    final ViewItemDataManager this$0;

    public A()
    {
        this$0 = ViewItemDataManager.this;
        super();
        resultStatus = new PlaceOfferResultStatus();
    }

    public t>(Content content, PlaceOfferResultStatus placeofferresultstatus)
    {
        this$0 = ViewItemDataManager.this;
        super();
        item = content;
        resultStatus = placeofferresultstatus;
    }
}
