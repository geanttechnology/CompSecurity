// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.trend;

import android.text.TextUtils;
import android.view.View;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.collections.CollectionDetailsActivity;
import com.ebay.mobile.common.view.ViewModel;

// Referenced classes of package com.ebay.mobile.trend:
//            TrendingActivity, TopicViewModel

class this._cls0
    implements com.ebay.mobile.common.view.stener
{

    final TrendingActivity this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof TopicViewModel)
        {
            view = (TopicViewModel)viewmodel;
            if (!TextUtils.isEmpty(((TopicViewModel) (view)).collectionId))
            {
                CollectionDetailsActivity.startActivity(TrendingActivity.this, ((TopicViewModel) (view)).collectionId, null, null);
            } else
            if (((TopicViewModel) (view)).searchParameters != null)
            {
                startActivity(ActivityStarter.getSearchResultListIntent(TrendingActivity.this, ((TopicViewModel) (view)).searchParameters, null));
                return;
            }
        }
    }

    ailsActivity()
    {
        this$0 = TrendingActivity.this;
        super();
    }
}
