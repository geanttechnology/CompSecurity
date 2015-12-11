// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity

class this._cls0 extends BroadcastReceiver
{

    final AppDetailsActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        AppDetailsActivity.access$5(AppDetailsActivity.this).performClick();
        AppDetailsActivity.access$5(AppDetailsActivity.this).setVisibility(8);
        AppDetailsActivity.access$8(AppDetailsActivity.this).setVisibility(0);
        AppDetailsActivity.access$8(AppDetailsActivity.this).setText("Retry");
    }

    ()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
