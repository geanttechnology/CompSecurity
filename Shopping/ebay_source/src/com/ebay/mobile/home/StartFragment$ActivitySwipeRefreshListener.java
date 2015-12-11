// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.shell.app.FwActivity;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

static class fragmentReference
    implements android.support.v4.widget.entReference
{

    private final WeakReference fragmentReference;

    public void onRefresh()
    {
        StartFragment startfragment = (StartFragment)fragmentReference.get();
        if (startfragment == null || startfragment.getView() == null)
        {
            return;
        }
        SwipeRefreshLayout swiperefreshlayout = (SwipeRefreshLayout)startfragment.getView().findViewById(0x7f1002e1);
        if (swiperefreshlayout != null)
        {
            swiperefreshlayout.setRefreshing(true);
        }
        if (StartFragment.access$100(startfragment) != null)
        {
            StartFragment.access$100(startfragment).invalidateAndForceReloadData();
            return;
        } else
        {
            UssContentsDataManager.invalidateActivityChannelData(startfragment.getFwActivity().getEbayContext(), new ContentSourceEnum[0]);
            return;
        }
    }

    (StartFragment startfragment)
    {
        fragmentReference = new WeakReference(startfragment);
    }
}
