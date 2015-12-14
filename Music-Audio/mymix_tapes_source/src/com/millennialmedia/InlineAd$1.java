// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            InlineAd, MMLog

class equestState
    implements Runnable
{

    final InlineAd this$0;
    final com.millennialmedia.internal..RequestState val$localRequestState;

    public void run()
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(InlineAd.access$000(), "Play list load timed out");
        }
        InlineAd.access$800(InlineAd.this, val$localRequestState);
    }

    equestState()
    {
        this$0 = final_inlinead;
        val$localRequestState = com.millennialmedia.internal..RequestState.this;
        super();
    }
}
