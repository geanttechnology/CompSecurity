// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Loader;
import android.os.Bundle;
import android.view.View;
import com.groupon.manager.StockCategoriesSyncManager;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            StockCategories

class this._cls0
    implements android.app.erCallbacks
{

    final StockCategories this$0;

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new ockCategoriesLoader(StockCategories.this, dealId, dealOptionId, null);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (List)obj);
    }

    public void onLoadFinished(Loader loader, List list)
    {
        if (list != null && !list.isEmpty())
        {
            StockCategories.access$100(StockCategories.this, list);
            if (stockValue != null)
            {
                setSpinnerSelection(list);
            }
            stockProgressView.setVisibility(8);
            return;
        } else
        {
            StockCategories.access$200(StockCategories.this).requestSync(StockCategories.this, null);
            return;
        }
    }

    public void onLoaderReset(Loader loader)
    {
    }

    Manager()
    {
        this$0 = StockCategories.this;
        super();
    }
}
