// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.view.View;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.NativeAdsViewModel;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

class this._cls0
    implements com.ebay.mobile.common.view.ner
{

    final DepartmentFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof NativeAdsViewModel)
        {
            view = (NativeAdsViewModel)viewmodel;
            viewmodel = new TrackingData("AdClick", TrackingType.EVENT);
            viewmodel.addKeyValuePair("adid", view.getAdID());
            viewmodel.addKeyValuePair("adtype", "1");
            viewmodel.addSourceIdentification(new SourceIdentification(getTrackingEventName(), "ad", TrackingData.sanitize(departmentId)));
            viewmodel.send(MyApp.getApp().getApplicationContext(), null);
        }
    }

    ()
    {
        this$0 = DepartmentFragment.this;
        super();
    }
}
