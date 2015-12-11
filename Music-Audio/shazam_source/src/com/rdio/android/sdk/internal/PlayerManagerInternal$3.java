// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import com.rdio.android.sdk.RdioListener;

// Referenced classes of package com.rdio.android.sdk.internal:
//            PlayerManagerInternal

class val.msg
    implements Runnable
{

    final PlayerManagerInternal this$0;
    final com.rdio.android.sdk.ternal val$error;
    final String val$msg;

    public void run()
    {
        PlayerManagerInternal.access$1000(PlayerManagerInternal.this).onError(val$error, val$msg);
    }

    ()
    {
        this$0 = final_playermanagerinternal;
        val$error = ternal;
        val$msg = String.this;
        super();
    }
}
