// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.support.v7.widget.RecyclerView;
import com.ebay.mobile.home.channels.ChannelObserver;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

static final class dispatcher extends android.support.v7.widget.stener
{

    private final ChannelObserver dispatcher;
    private final WeakReference fragmentReference;

    public void onScrolled(RecyclerView recyclerview, int i, int j)
    {
        super.stener(recyclerview, i, j);
        for (recyclerview = (DepartmentFragment)fragmentReference.get(); recyclerview == null || recyclerview.isRemoving() || dispatcher == null;)
        {
            return;
        }

        ChannelObserver channelobserver = dispatcher;
        if (recyclerview.hasScrollOffset())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        channelobserver.onScrollChanged(recyclerview, 0, i);
    }

    (DepartmentFragment departmentfragment, ChannelObserver channelobserver)
    {
        fragmentReference = new WeakReference(departmentfragment);
        dispatcher = channelobserver;
    }
}
