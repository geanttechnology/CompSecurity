// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.activity.SnapOfferGridActivity;
import com.groupon.adapter.listener.OnCategoryItemClickListener;
import com.groupon.models.category.Category;
import com.groupon.service.gdt.GdtService;
import com.groupon.util.LoggingUtils;
import java.util.List;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            NearbyDealsFragment

private class <init>
    implements OnCategoryItemClickListener
{

    final NearbyDealsFragment this$0;

    public void onItemClick(View view, int i)
    {
        view = (Category)NearbyDealsFragment.access$300(NearbyDealsFragment.this).get(i);
        if (view == null)
        {
            return;
        }
        loggingUtils.logCategoryCarouselClick("category_click", nstChannel, Channel.NEARBY.toString(), view);
        if (isGTGOnNearby && Strings.equals(((Category) (view)).id, "gtg_mock_category_id"))
        {
            startActivity(((IntentFactory)NearbyDealsFragment.access$1600(NearbyDealsFragment.this).get()).newGrouponWebViewIntent(NearbyDealsFragment.access$1500(NearbyDealsFragment.this).getGtgEntryUrl(), false, true, true, true, false));
            return;
        }
        if (((Category) (view)).id.equals(NearbyDealsFragment.access$500()))
        {
            startActivity(((IntentFactory)NearbyDealsFragment.access$1600(NearbyDealsFragment.this).get()).newSnapOfferGridIntent((new StringBuilder()).append(Channel.SNAP_GROCERY).append(com/groupon/activity/SnapOfferGridActivity.getSimpleName()).toString(), Channel.SNAP_GROCERY));
            return;
        } else
        {
            startActivity(((IntentFactory)NearbyDealsFragment.access$1600(NearbyDealsFragment.this).get()).newCategoryCarouselGlobalSearchResultIntent(channel, view, 1, true, false));
            return;
        }
    }

    private ()
    {
        this$0 = NearbyDealsFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
