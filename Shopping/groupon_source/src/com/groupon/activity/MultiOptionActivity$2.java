// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Loader;
import android.os.Bundle;
import android.widget.ProgressBar;
import com.groupon.abtest.NewCartAbTestHelper;
import com.groupon.db.events.DealUpdateEvent;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.goods.shoppingcart.ShoppingCartPresenter;
import com.groupon.loader.DealLoader;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            MultiOptionActivity

class this._cls0
    implements android.app.llbacks
{

    final MultiOptionActivity this$0;

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new DealLoader(com/groupon/db/models/Deal, com/groupon/db/events/DealUpdateEvent, MultiOptionActivity.this, dealId);
    }

    public void onLoadFinished(Loader loader, Deal deal)
    {
        boolean flag = false;
        loadingView.setVisibility(8);
        if (deal != null)
        {
            MultiOptionActivity.access$302(MultiOptionActivity.this, deal);
            MultiOptionActivity.access$1202(MultiOptionActivity.this, deal.getOptions());
            MultiOptionActivity multioptionactivity;
            byte byte0;
            boolean flag1;
            if (!MultiOptionActivity.access$1200(MultiOptionActivity.this).isEmpty())
            {
                loader = ((Option)MultiOptionActivity.access$1200(MultiOptionActivity.this).get(0)).externalUrl;
            } else
            {
                loader = null;
            }
            multioptionactivity = MultiOptionActivity.this;
            flag1 = MultiOptionActivity.access$600(MultiOptionActivity.this);
            if (Strings.isEmpty(loader) && deal.allowedInCart && MultiOptionActivity.access$1300(MultiOptionActivity.this).isShoppingCartEnabled())
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            MultiOptionActivity.access$602(multioptionactivity, byte0 | flag1);
            if (MultiOptionActivity.access$600(MultiOptionActivity.this))
            {
                MultiOptionActivity.access$800(MultiOptionActivity.this).cacheCart();
                loader = loadingView;
                byte0 = flag;
                if (MultiOptionActivity.access$800(MultiOptionActivity.this).isCartReady())
                {
                    byte0 = 8;
                }
                loader.setVisibility(byte0);
            }
            setupAdapter();
        }
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Deal)obj);
    }

    public void onLoaderReset(Loader loader)
    {
    }

    Presenter()
    {
        this$0 = MultiOptionActivity.this;
        super();
    }
}
