// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.details:
//            MarketPlaceView, MarketPlaceOffersAdapter

class this._cls0
    implements android.widget.Factory
{

    final MarketPlaceView this$0;
    final Map views = new HashMap(4);

    public View createTabContent(String s)
    {
        View view1 = (View)views.get(s);
        View view = view1;
        if (view1 == null)
        {
            view = MarketPlaceOffersAdapter.getMarketPlaceOffersView(MarketPlaceView.access$000(MarketPlaceView.this), MarketPlaceView.access$100(MarketPlaceView.this), s);
            views.put(s, view);
        }
        return view;
    }

    dapter()
    {
        this$0 = MarketPlaceView.this;
        super();
    }
}
