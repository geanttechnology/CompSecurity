// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import com.millennialmedia.internal.AdPlacementReporter;

// Referenced classes of package com.millennialmedia:
//            InterstitialAd, MMLog

class istItemReporter
    implements Runnable
{

    final InterstitialAd this$0;
    final com.millennialmedia.internal.stState val$localRequestState;
    final com.millennialmedia.internal.er.PlayListItemReporter val$playListItemReporter;

    public void run()
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(InterstitialAd.access$000(), "Ad adapter load timed out");
        }
        AdPlacementReporter.reportPlayListItem(val$localRequestState.getAdPlacementReporter(), val$playListItemReporter, -2);
        InterstitialAd.access$900(InterstitialAd.this, val$localRequestState);
    }

    istItemReporter()
    {
        this$0 = final_interstitialad;
        val$localRequestState = ststate;
        val$playListItemReporter = com.millennialmedia.internal.er.PlayListItemReporter.this;
        super();
    }
}
