// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            InterstitialAd, MMLog

class ent.RequestState
    implements Runnable
{

    final InterstitialAd this$0;
    final com.millennialmedia.internal.stState val$localRequestState;

    public void run()
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(InterstitialAd.access$000(), "Play list load timed out");
        }
        InterstitialAd.access$300(InterstitialAd.this, val$localRequestState);
    }

    ent.RequestState()
    {
        this$0 = final_interstitialad;
        val$localRequestState = com.millennialmedia.internal.stState.this;
        super();
    }
}
