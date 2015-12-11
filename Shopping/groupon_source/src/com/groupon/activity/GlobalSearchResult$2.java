// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.Channel;
import com.groupon.tracking.mobile.sdk.Logger;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

// Referenced classes of package com.groupon.activity:
//            GlobalSearchResult

class this._cls0
    implements android.view.esult._cls2
{

    final GlobalSearchResult this$0;

    public void onClick(View view)
    {
        logger.logClick("", "filtersheet_dimmed_click", searchSourceChannel.toString(), Logger.NULL_NST_FIELD, Logger.NULL_NST_FIELD);
        GlobalSearchResult.access$000(GlobalSearchResult.this).setPanelState(com.sothree.slidinguppanel.PanelState.COLLAPSED);
    }

    ayout()
    {
        this$0 = GlobalSearchResult.this;
        super();
    }
}
