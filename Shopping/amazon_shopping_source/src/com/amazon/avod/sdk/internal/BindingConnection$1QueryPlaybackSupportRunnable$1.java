// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import com.amazon.avod.sdk.PlaybackSupportResponse;

// Referenced classes of package com.amazon.avod.sdk.internal:
//            BindingConnection

class val.support
    implements Runnable
{

    final val.support this$1;
    final com.amazon.avod.sdk.nnable val$support;

    public void run()
    {
        callback.onPlaybackSupport(val$support);
    }

    ()
    {
        this$1 = final_;
        val$support = com.amazon.avod.sdk.nnable._cls1.val.support.this;
        super();
    }
}
