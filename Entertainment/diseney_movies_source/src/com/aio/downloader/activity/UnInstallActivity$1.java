// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

// Referenced classes of package com.aio.downloader.activity:
//            UnInstallActivity, DownloadAppManager

class this._cls0 extends Handler
{

    final UnInstallActivity this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            Toast.makeText(UnInstallActivity.this, "Failed to connect server.", 0).show();
            return;

        case 2: // '\002'
            UnInstallActivity.access$0(UnInstallActivity.this);
            return;

        case 3: // '\003'
            Toast.makeText(UnInstallActivity.this, "'AIO Cleaner' is added to download queue.", 0).show();
            break;
        }
        finish();
        message = new Intent(UnInstallActivity.this, com/aio/downloader/activity/DownloadAppManager);
        message.setFlags(0x10000000);
        startActivity(message);
    }

    ()
    {
        this$0 = UnInstallActivity.this;
        super();
    }
}
