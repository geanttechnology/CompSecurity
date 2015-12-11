// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.events.EventItemsActivity;
import com.ebay.mobile.events.EventTimeLeftHelper;
import com.ebay.mobile.events.EventViewModel;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

class this._cls0
    implements com.ebay.mobile.common.view.ener
{

    final DepartmentFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof EventViewModel)
        {
            EventViewModel eventviewmodel = (EventViewModel)viewmodel;
            Activity activity = getActivity();
            view = "HomePage";
            if (!hasCarousel())
            {
                view = "SubDepartment";
            }
            viewmodel = null;
            Resources resources = activity.getResources();
            if (eventviewmodel.showTimer)
            {
                viewmodel = EventTimeLeftHelper.getEndsInTimeMaxUnitString(resources, EventTimeLeftHelper.getRemainingDuration(eventviewmodel.endDate), true);
                viewmodel = String.format(resources.getString(0x7f0701f4), new Object[] {
                    viewmodel
                });
            }
            EventItemsActivity.startActivity(activity, eventviewmodel, departmentId, viewmodel, new SourceIdentification(view, "salesevents", TrackingData.sanitize(departmentId)));
        }
    }

    ()
    {
        this$0 = DepartmentFragment.this;
        super();
    }
}
