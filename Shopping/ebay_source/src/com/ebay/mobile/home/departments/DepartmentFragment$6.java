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
import com.ebay.mobile.events.BrowseEventsActivity;
import com.ebay.mobile.home.cards.ListOfEventGroupsViewModel;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

class this._cls0
    implements com.ebay.mobile.common.view.ener
{

    final DepartmentFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
label0:
        {
            if (viewmodel instanceof ListOfEventGroupsViewModel)
            {
                view = getActivity();
                if (view != null)
                {
                    break label0;
                }
            }
            return;
        }
        viewmodel = new Intent(view, com/ebay/mobile/events/BrowseEventsActivity);
        viewmodel.putExtra("top_level_channel", ChannelEnum.SHOP.name());
        if (hasCarousel())
        {
            viewmodel.putExtra("browse_type", ChannelEnum.DEPARTMENT.name());
        } else
        {
            viewmodel.putExtra("browse_type", "SUB_DEPARTMENT");
        }
        viewmodel.putExtra("department_id", departmentId);
        viewmodel.putExtra("department_title", departmentTitle);
        viewmodel.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName(), "salesevents", TrackingData.sanitize(departmentId)));
        view.startActivity(viewmodel);
    }

    m()
    {
        this$0 = DepartmentFragment.this;
        super();
    }
}
