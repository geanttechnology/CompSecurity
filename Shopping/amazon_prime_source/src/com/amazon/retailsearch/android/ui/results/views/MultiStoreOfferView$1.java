// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.widget.TextView;
import com.amazon.retailsearch.android.ui.buttons.InlineActionsListener;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            MultiStoreOfferView

class this._cls0
    implements InlineActionsListener
{

    final MultiStoreOfferView this$0;

    public void onAddToCartSuccess()
    {
        MultiStoreOfferView.access$000(MultiStoreOfferView.this).setVisibility(8);
        MultiStoreOfferView.access$100(MultiStoreOfferView.this).setVisibility(0);
        platform.invokeLater(new Runnable() {

            final MultiStoreOfferView._cls1 this$1;

            public void run()
            {
                MultiStoreOfferView.access$000(this$0).setVisibility(0);
                MultiStoreOfferView.access$100(this$0).setVisibility(8);
            }

            
            {
                this$1 = MultiStoreOfferView._cls1.this;
                super();
            }
        }, 800L);
    }

    _cls1.this._cls1()
    {
        this$0 = MultiStoreOfferView.this;
        super();
    }
}
