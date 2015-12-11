// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import java.util.Timer;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity

class this._cls0
    implements android.view.ilsActivity._cls20
{

    final AppDetailsActivity this$0;

    public void onClick(View view)
    {
        AppDetailsActivity.access$3(AppDetailsActivity.this).setVisibility(8);
        AppDetailsActivity.access$8(AppDetailsActivity.this).setVisibility(0);
        if (AppDetailsActivity.access$7(AppDetailsActivity.this) != null)
        {
            AppDetailsActivity.access$7(AppDetailsActivity.this).cancel();
        }
        view = new Intent("pdtpause");
        view.putExtra("type", "pause");
        sendBroadcast(view);
    }

    ()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
