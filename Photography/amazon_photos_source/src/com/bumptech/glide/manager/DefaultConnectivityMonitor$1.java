// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.bumptech.glide.manager:
//            DefaultConnectivityMonitor

class this._cls0 extends BroadcastReceiver
{

    final DefaultConnectivityMonitor this$0;

    public void onReceive(Context context, Intent intent)
    {
        boolean flag = DefaultConnectivityMonitor.access$000(DefaultConnectivityMonitor.this);
        DefaultConnectivityMonitor.access$002(DefaultConnectivityMonitor.this, DefaultConnectivityMonitor.access$100(DefaultConnectivityMonitor.this, context));
        if (flag != DefaultConnectivityMonitor.access$000(DefaultConnectivityMonitor.this))
        {
            DefaultConnectivityMonitor.access$200(DefaultConnectivityMonitor.this).onConnectivityChanged(DefaultConnectivityMonitor.access$000(DefaultConnectivityMonitor.this));
        }
    }

    ityListener()
    {
        this$0 = DefaultConnectivityMonitor.this;
        super();
    }
}
