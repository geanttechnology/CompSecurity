// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.viewitem.ItemViewActivity;

// Referenced classes of package com.ebay.mobile.following:
//            BrowseFollowingFragment

private class <init>
    implements android.view.lickListener
{

    final BrowseFollowingFragment this$0;

    public void onClick(View view)
    {
        view = (com.ebay.nautilus.domain.data.UnifiedStream.)view.getTag();
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        long l = Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.) (view)).istingId).longValue();
        ItemViewActivity.StartActivity(getActivity(), l, com.ebay.common., addSourceIdTracking(new Intent(), "feed"));
        return;
        view;
    }

    private ntRecord.Listing()
    {
        this$0 = BrowseFollowingFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
