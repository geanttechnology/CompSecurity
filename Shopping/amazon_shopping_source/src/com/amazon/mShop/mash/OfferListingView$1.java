// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash;

import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.mash:
//            OfferListingView

class this._cls0
    implements com.amazon.mShop.error.onErrorBoxActionListener
{

    final OfferListingView this$0;

    public void onActionButtonClick(int i)
    {
        com.amazon.mShop.platform.tInstance().invokeLater(new Runnable() {

            final OfferListingView._cls1 this$1;

            public void run()
            {
                OfferListingView.access$000(this$0).replayProductRequest();
            }

            
            {
                this$1 = OfferListingView._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = OfferListingView.this;
        super();
    }
}
