// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            NativeAd, MMLog

class equestState
    implements Runnable
{

    final NativeAd this$0;
    final com.millennialmedia.internal..RequestState val$localRequestState;

    public void run()
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(NativeAd.access$100(), "Play list load timed out");
        }
        NativeAd.access$400(NativeAd.this, val$localRequestState);
    }

    equestState()
    {
        this$0 = final_nativead;
        val$localRequestState = com.millennialmedia.internal..RequestState.this;
        super();
    }
}
