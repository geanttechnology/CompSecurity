// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

static class fragmentReference
    implements android.support.v4.widget.stener
{

    private final WeakReference fragmentReference;

    public void onRefresh()
    {
        DepartmentFragment departmentfragment = (DepartmentFragment)fragmentReference.get();
        if (departmentfragment != null && departmentfragment.getView() != null)
        {
            SwipeRefreshLayout swiperefreshlayout = (SwipeRefreshLayout)departmentfragment.getView().findViewById(0x7f1002e1);
            if (swiperefreshlayout != null)
            {
                swiperefreshlayout.setRefreshing(true);
            }
            if (departmentfragment.contentDataManager != null)
            {
                departmentfragment.contentDataManager.invalidateAndForceReloadData();
                return;
            }
        }
    }

    (DepartmentFragment departmentfragment)
    {
        fragmentReference = new WeakReference(departmentfragment);
    }
}
