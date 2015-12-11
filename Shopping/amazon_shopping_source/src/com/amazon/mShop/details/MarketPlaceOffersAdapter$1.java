// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.details:
//            MarketPlaceOffersAdapter

class this._cls0
    implements com.amazon.mShop.error.oxActionListener
{

    final MarketPlaceOffersAdapter this$0;

    public void onActionButtonClick(int i)
    {
        com.amazon.mShop.platform.e().invokeLater(new Runnable() {

            final MarketPlaceOffersAdapter._cls1 this$1;

            public void run()
            {
                MarketPlaceOffersAdapter.access$000(this$0, 0);
                MarketPlaceOffersAdapter.access$100(this$0).replayPageRequest();
            }

            
            {
                this$1 = MarketPlaceOffersAdapter._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = MarketPlaceOffersAdapter.this;
        super();
    }
}
