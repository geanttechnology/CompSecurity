// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.cleaner:
//            RubActivity

class this._cls0 extends Handler
{

    final RubActivity this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            Toast.makeText(RubActivity.this, "Failed to connect server.", 0).show();
            return;

        case 2: // '\002'
            RubActivity.access$16(RubActivity.this);
            return;

        case 3: // '\003'
            Toast.makeText(RubActivity.this, "'AIO Cleaner' is added to download queue.", 0).show();
            break;
        }
        message = new Intent(RubActivity.this, com/aio/downloader/activity/AppDetailsActivity);
        message.putExtra("myid", "com.evzapp.cleanmaster");
        message.putExtra("widgetdetailfan", true);
        startActivity(message);
        publicTools.cleanertag = false;
        finish();
    }

    ivity()
    {
        this$0 = RubActivity.this;
        super();
    }
}
