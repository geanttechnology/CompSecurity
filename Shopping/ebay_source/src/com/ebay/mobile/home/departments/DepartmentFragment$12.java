// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.ListOfTrendingViewModel;
import com.ebay.mobile.trend.TrendingActivity;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

class this._cls0
    implements com.ebay.mobile.common.view.ner
{

    final DepartmentFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof ListOfTrendingViewModel)
        {
            int i = ((ListOfTrendingViewModel)viewmodel).trendAnchor;
            viewmodel = getActivity();
            Intent intent = new Intent(viewmodel, com/ebay/mobile/trend/TrendingActivity);
            intent.putExtra("trend_topic_anchors", i);
            if (i >= 0)
            {
                view = (new StringBuilder()).append("trend").append(String.valueOf(i + 1)).toString();
            } else
            {
                view = "moretrending";
            }
            intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName(), view, TrackingData.sanitize(departmentId)));
            viewmodel.startActivity(intent);
        }
    }

    ()
    {
        this$0 = DepartmentFragment.this;
        super();
    }
}
