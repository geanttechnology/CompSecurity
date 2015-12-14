// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

// Referenced classes of package com.aviary.android.feather.library:
//            MonitoredActivity

class this._cls0 extends BroadcastReceiver
{

    final MonitoredActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        Log.i("MonitoredActivity", (new StringBuilder()).append("onReceive: ").append(intent).toString());
        if (intent != null && context != null)
        {
            context = intent.getAction();
            if ("aviary.intent.action.KILL".equals(context))
            {
                MonitoredActivity.access$200(MonitoredActivity.this);
            } else
            if ("aviary.intent.action.ALERT".equals(context))
            {
                MonitoredActivity.access$300(MonitoredActivity.this, intent);
                return;
            }
        }
    }

    ()
    {
        this$0 = MonitoredActivity.this;
        super();
    }
}
