// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.text.TextUtils;
import android.view.View;
import com.ebay.mobile.activities.UserDetailActivity;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.collections.CollectionDetailsActivity;
import com.ebay.mobile.collections.CollectionViewModel;
import com.ebay.mobile.common.view.ViewModel;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

class this._cls0
    implements com.ebay.mobile.common.view.ener
{

    final DepartmentFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof CollectionViewModel)
        {
            int i = view.getId();
            android.app.Activity activity = getActivity();
            if (activity != null)
            {
                viewmodel = (CollectionViewModel)viewmodel;
                if (i == 0x7f1000f7)
                {
                    UserDetailActivity.StartActivity(activity, null, ((CollectionViewModel) (viewmodel)).username, null, null, false, true, false, false, null, false, null);
                    return;
                }
                view = "HomePage";
                if (!hasCarousel())
                {
                    view = "SubDepartment";
                }
                String s = TrackingData.sanitize(departmentId);
                if (!TextUtils.isEmpty(((CollectionViewModel) (viewmodel)).collectionId))
                {
                    CollectionDetailsActivity.startActivity(activity, ((CollectionViewModel) (viewmodel)).collectionId, s, new SourceIdentification(view, "collections", s));
                    return;
                }
            }
        }
    }

    ()
    {
        this$0 = DepartmentFragment.this;
        super();
    }
}
