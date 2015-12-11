// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import com.groupon.callbacks.OnMarketplaceEventListener;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            MarketplaceController

private class <init>
    implements OnMarketplaceEventListener
{

    final MarketplaceController this$0;

    public void onExpandTextClick(boolean flag)
    {
        Logger logger = MarketplaceController.access$200(MarketplaceController.this);
        String s;
        if (flag)
        {
            s = "marketplace_section_collapse";
        } else
        {
            s = "marketplace_section_expand";
        }
        logger.logClick("goods_connected_marketplace", s, MarketplaceController.access$100(MarketplaceController.this), Logger.NULL_NST_FIELD);
    }

    private ()
    {
        this$0 = MarketplaceController.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
