// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.history;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.search.SearchIntentBuilder;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.history:
//            HistoryView

class this._cls0
    implements android.view.stener
{

    final HistoryView this$0;

    public void onClick(View view)
    {
        view = (AmazonActivity)getContext();
        ActivityUtils.startSearchActivity(view, (new SearchIntentBuilder(view)).showSearchEntryView(true).selectInitialQuery(true).clickStreamOrigin(ClickStreamTag.ORIGIN_RVI.getTag()).build());
    }

    amTag()
    {
        this$0 = HistoryView.this;
        super();
    }
}
