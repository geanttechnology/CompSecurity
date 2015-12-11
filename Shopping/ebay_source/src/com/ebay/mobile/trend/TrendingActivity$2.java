// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.trend;

import android.text.TextUtils;
import android.view.View;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.kernel.util.NumberUtil;

// Referenced classes of package com.ebay.mobile.trend:
//            TrendingActivity, TopicListingViewModel

class this._cls0
    implements com.ebay.mobile.common.view.stener
{

    final TrendingActivity this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof TopicListingViewModel)
        {
            view = (TopicListingViewModel)viewmodel;
            if (!TextUtils.isEmpty(((TopicListingViewModel) (view)).listingId))
            {
                long l = NumberUtil.safeParseLong(((TopicListingViewModel) (view)).listingId, -1L);
                if (l != -1L)
                {
                    ItemViewActivity.StartActivity(TrendingActivity.this, l, com.ebay.common.mKind.CustomList);
                }
            }
        }
    }

    ()
    {
        this$0 = TrendingActivity.this;
        super();
    }
}
