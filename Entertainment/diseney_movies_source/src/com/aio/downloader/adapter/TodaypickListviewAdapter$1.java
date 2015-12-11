// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

// Referenced classes of package com.aio.downloader.adapter:
//            TodaypickListviewAdapter

class this._cls0 extends Handler
{

    final TodaypickListviewAdapter this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            Toast.makeText(TodaypickListviewAdapter.access$0(TodaypickListviewAdapter.this), "Failed to connect server.", 0).show();
            return;

        case 2: // '\002'
            TodaypickListviewAdapter.access$1(TodaypickListviewAdapter.this);
            return;

        case 3: // '\003'
            TodaypickListviewAdapter.access$2(TodaypickListviewAdapter.this, Boolean.valueOf(true));
            break;
        }
        Toast.makeText(TodaypickListviewAdapter.access$0(TodaypickListviewAdapter.this), (new StringBuilder("'")).append(TodaypickListviewAdapter.access$3(TodaypickListviewAdapter.this).getString("todayname", "this app")).append("' is added to download queue.").toString(), 0).show();
    }

    ()
    {
        this$0 = TodaypickListviewAdapter.this;
        super();
    }
}
