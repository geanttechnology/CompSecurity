// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            SeriesEntityActivity

class this._cls0 extends BroadcastReceiver
{

    final SeriesEntityActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        boolean flag = intent.getBooleanExtra("noConnectivity", false);
        SeriesEntityActivity.access$200().debug("Network change, isNetworkDown {}", Boolean.valueOf(flag));
        if (SeriesEntityActivity.access$300(SeriesEntityActivity.this) && !flag)
        {
            SeriesEntityActivity.access$200().debug("Internet connect reestablished, triggering loading");
            SeriesEntityActivity.access$302(SeriesEntityActivity.this, false);
            SeriesEntityActivity.access$400(SeriesEntityActivity.this);
        }
    }

    ()
    {
        this$0 = SeriesEntityActivity.this;
        super();
    }
}
