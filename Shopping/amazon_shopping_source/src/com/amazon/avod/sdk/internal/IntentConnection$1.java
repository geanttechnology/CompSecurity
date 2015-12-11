// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import com.amazon.avod.sdk.PlaybackSupportResponse;

// Referenced classes of package com.amazon.avod.sdk.internal:
//            IntentConnection

class backSupport
    implements Runnable
{

    final IntentConnection this$0;
    final PlaybackSupportResponse val$callback;
    final com.amazon.avod.sdk.onse.PlaybackSupport val$support;

    public void run()
    {
        val$callback.onPlaybackSupport(val$support);
    }

    backSupport()
    {
        this$0 = final_intentconnection;
        val$callback = playbacksupportresponse;
        val$support = com.amazon.avod.sdk.onse.PlaybackSupport.this;
        super();
    }
}
