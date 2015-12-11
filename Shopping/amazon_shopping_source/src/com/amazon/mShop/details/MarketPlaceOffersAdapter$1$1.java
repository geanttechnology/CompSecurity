// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.details:
//            MarketPlaceOffersAdapter

class this._cls1
    implements Runnable
{

    final eRequest this$1;

    public void run()
    {
        MarketPlaceOffersAdapter.access$000(_fld0, 0);
        MarketPlaceOffersAdapter.access$100(_fld0).replayPageRequest();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/details/MarketPlaceOffersAdapter$1

/* anonymous class */
    class MarketPlaceOffersAdapter._cls1
        implements com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener
    {

        final MarketPlaceOffersAdapter this$0;

        public void onActionButtonClick(int i)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new MarketPlaceOffersAdapter._cls1._cls1());
        }

            
            {
                this$0 = MarketPlaceOffersAdapter.this;
                super();
            }
    }

}
