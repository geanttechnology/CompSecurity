// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import com.ebay.common.rtm.RtmHelper;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;
import com.ebay.nautilus.domain.data.UnifiedStream.Channel;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.lang.ref.WeakReference;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

static class fragmentReference
    implements com.ebay.common.content.dm.ntReference
{

    private final WeakReference fragmentReference;

    public void onAdsContextReady(List list, com.ebay.common.content.dm.ntReference ntreference)
    {
        ntreference = (StartFragment)fragmentReference.get();
        DataManagerContainer datamanagercontainer;
        if (ntreference != null)
        {
            if ((datamanagercontainer = StartFragment.access$000(ntreference)) != null)
            {
                StartFragment.access$102(ntreference, (UssContentsDataManager)datamanagercontainer.initialize(UssContentsDataManager.getChannelKeyParams(StartFragment.access$200(ntreference).name, null, list), ntreference));
                return;
            }
        }
    }

    public void onAdsReady(RtmHelper rtmhelper, com.ebay.common.content.dm..getChannelKeyParams getchannelkeyparams)
    {
    }

    tType(StartFragment startfragment)
    {
        fragmentReference = new WeakReference(startfragment);
    }
}
