// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import com.ebay.common.rtm.RtmHelper;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.lang.ref.WeakReference;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

static class fragmentReference
    implements com.ebay.common.content.dm.erver
{

    private final WeakReference fragmentReference;

    public void onAdsContextReady(List list, com.ebay.common.content.dm.erver erver)
    {
        erver = (DepartmentFragment)fragmentReference.get();
        DataManagerContainer datamanagercontainer;
        if (erver != null)
        {
            if ((datamanagercontainer = DepartmentFragment.access$000(erver)) != null)
            {
                if (DepartmentFragment.access$100(erver))
                {
                    list = (UssContentsDataManager)datamanagercontainer.initialize(UssContentsDataManager.getDepartmentChannelKeyParams(((DepartmentFragment) (erver)).departmentId, null, list), erver);
                } else
                {
                    list = (UssContentsDataManager)datamanagercontainer.initialize(UssContentsDataManager.getChannelKeyParams(((DepartmentFragment) (erver)).departmentId, null, list), erver);
                }
                erver.contentDataManager = list;
                return;
            }
        }
    }

    public void onAdsReady(RtmHelper rtmhelper, com.ebay.common.content.dm.erver erver)
    {
    }

    (DepartmentFragment departmentfragment)
    {
        fragmentReference = new WeakReference(departmentfragment);
    }
}
