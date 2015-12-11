// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.Timer;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity

class this._cls0 extends BroadcastReceiver
{

    final AppDetailsActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        AppDetailsActivity.access$5(AppDetailsActivity.this).setVisibility(8);
        AppDetailsActivity.access$6(AppDetailsActivity.this).setVisibility(0);
        if (AppDetailsActivity.access$7(AppDetailsActivity.this) != null)
        {
            AppDetailsActivity.access$7(AppDetailsActivity.this).cancel();
        }
        AppDetailsActivity.access$4(AppDetailsActivity.this).setProgress(0);
    }

    ()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
