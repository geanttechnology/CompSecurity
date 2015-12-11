// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.departments.DepartmentFragment;
import com.ebay.mobile.home.departments.DepartmentNameViewModel;
import com.ebay.nautilus.domain.data.UnifiedStream.Channel;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

static final class fragmentReference
    implements com.ebay.mobile.common.view.tReference
{

    private final WeakReference fragmentReference;

    public void onClick(View view, ViewModel viewmodel)
    {
        StartFragment startfragment;
        startfragment = (StartFragment)fragmentReference.get();
        break MISSING_BLOCK_LABEL_11;
        if (startfragment != null && startfragment.getView() != null && (viewmodel instanceof DepartmentNameViewModel))
        {
            view = (DepartmentNameViewModel)viewmodel;
            viewmodel = (ViewPager)startfragment.getView().findViewById(0x7f1002e6);
            if (viewmodel != null)
            {
                if (((DepartmentNameViewModel) (view)).position != viewmodel.getCurrentItem())
                {
                    viewmodel.setCurrentItem(((DepartmentNameViewModel) (view)).position, true);
                    return;
                }
                if (((DepartmentNameViewModel) (view)).channel.isDepartment)
                {
                    view = ((DepartmentNameViewModel) (view)).channel.departmentName;
                } else
                {
                    view = ((DepartmentNameViewModel) (view)).channel.name;
                }
                view = startfragment.getChildFragmentManager().findFragmentByTag(view);
                if (view != null && (view instanceof DepartmentFragment))
                {
                    ((DepartmentFragment)view).toggleFeaturedCategories();
                    return;
                }
            }
        }
        return;
    }

    (StartFragment startfragment)
    {
        fragmentReference = new WeakReference(startfragment);
    }
}
