// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import com.rdio.android.sdk.PlayerListener;

// Referenced classes of package com.rdio.android.sdk.internal:
//            PlayerManagerInternal

class val.mSec
    implements Runnable
{

    final PlayerManagerInternal this$0;
    final PlayerListener val$listener;
    final int val$mSec;

    public void run()
    {
        val$listener.onPositionUpdate(val$mSec);
    }

    ()
    {
        this$0 = final_playermanagerinternal;
        val$listener = playerlistener;
        val$mSec = I.this;
        super();
    }
}
