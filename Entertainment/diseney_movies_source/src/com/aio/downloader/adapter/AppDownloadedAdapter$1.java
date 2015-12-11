// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

// Referenced classes of package com.aio.downloader.adapter:
//            AppDownloadedAdapter

class this._cls0 extends BroadcastReceiver
{

    final AppDownloadedAdapter this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        intent.getIntExtra("MyUpver", 0);
        if (context.equals("wocaonima"))
        {
            ewHolder.access._mth0(holder).setText("Open");
        }
    }

    ewHolder()
    {
        this$0 = AppDownloadedAdapter.this;
        super();
    }
}
