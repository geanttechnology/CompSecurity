// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Intent;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.util.LoggingUtils;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            NearbyDealsFragment

private class <init>
    implements android.view.istener
{

    final NearbyDealsFragment this$0;

    public void onClick(View view)
    {
        loggingUtils.logCategoryBarClick("browse_by_category", nstChannel, Channel.NEARBY.toString());
        view = ((IntentFactory)NearbyDealsFragment.access$1600(NearbyDealsFragment.this).get()).newGlobalSearchIntent(getChannel());
        view.putExtra("browse_by_category", NearbyDealsFragment.access$2800(NearbyDealsFragment.this));
        startActivity(view);
    }

    private I()
    {
        this$0 = NearbyDealsFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
