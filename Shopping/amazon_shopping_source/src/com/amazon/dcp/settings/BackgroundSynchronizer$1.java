// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.dcp.settings:
//            BackgroundSynchronizer

class this._cls0 extends BroadcastReceiver
{

    final BackgroundSynchronizer this$0;

    public void onReceive(Context context, Intent intent)
    {
        startSync();
    }

    ()
    {
        this$0 = BackgroundSynchronizer.this;
        super();
    }
}
