// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.socialin.android.apiv3.util.Inventory;

// Referenced classes of package com.picsart.studio.ads:
//            MoPubRecyclerAdapter

final class e extends BroadcastReceiver
{

    private MoPubRecyclerAdapter a;

    private e(MoPubRecyclerAdapter mopubrecycleradapter)
    {
        a = mopubrecycleradapter;
        super();
    }

    e(MoPubRecyclerAdapter mopubrecycleradapter, byte byte0)
    {
        this(mopubrecycleradapter);
    }

    public final void onReceive(Context context, Intent intent)
    {
        if (!Inventory.isAdsEnabled())
        {
            MoPubRecyclerAdapter.access$302(a, false);
            a.clearAds();
            MoPubRecyclerAdapter.access$400();
            (new StringBuilder("MHandler: ")).append(MoPubRecyclerAdapter.access$500(a).toString()).append(" clear");
        }
    }
}
