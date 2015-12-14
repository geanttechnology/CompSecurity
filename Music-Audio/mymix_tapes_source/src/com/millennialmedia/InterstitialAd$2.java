// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import com.millennialmedia.internal.AdPlacementReporter;
import com.millennialmedia.internal.PlayList;

// Referenced classes of package com.millennialmedia:
//            InterstitialAd, MMLog

class ent.RequestState
    implements com.millennialmedia.internal.playlistserver.ayListLoadListener
{

    final InterstitialAd this$0;
    final com.millennialmedia.internal.stState val$localRequestState;

    public void onLoadFailed(Throwable throwable)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(InterstitialAd.access$000(), "Play list load failed");
        }
        InterstitialAd.access$300(InterstitialAd.this, val$localRequestState);
    }

    public void onLoaded(PlayList playlist)
    {
        this;
        JVM INSTR monitorenter ;
        if (InterstitialAd.access$400(InterstitialAd.this).compareRequest(val$localRequestState))
        {
            break MISSING_BLOCK_LABEL_22;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        InterstitialAd.access$502(InterstitialAd.this, "play_list_loaded");
        this;
        JVM INSTR monitorexit ;
        InterstitialAd.access$602(InterstitialAd.this, playlist);
        val$localRequestState.setAdPlacementReporter(AdPlacementReporter.getPlayListReporter(playlist));
        InterstitialAd.access$702(InterstitialAd.this, val$localRequestState);
        InterstitialAd.access$800(InterstitialAd.this, val$localRequestState);
        return;
        playlist;
        this;
        JVM INSTR monitorexit ;
        throw playlist;
    }

    ent.RequestState()
    {
        this$0 = final_interstitialad;
        val$localRequestState = com.millennialmedia.internal.stState.this;
        super();
    }
}
