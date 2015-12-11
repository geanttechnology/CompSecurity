// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.SharedPreferencesConfig;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity

class this._cls0 extends Handler
{

    final AppDetailsActivity this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        message.what;
        JVM INSTR lookupswitch 4: default 52
    //                   1: 53
    //                   2: 67
    //                   3: 75
    //                   30000: 191;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        Toast.makeText(AppDetailsActivity.this, "Failed to connect server.", 0).show();
        return;
_L3:
        AppDetailsActivity.access$16(AppDetailsActivity.this);
        return;
_L4:
        if (AppDetailsActivity.access$17(AppDetailsActivity.this) == 0)
        {
            Toast.makeText(AppDetailsActivity.this, (new StringBuilder("'")).append(AppDetailsActivity.access$18(AppDetailsActivity.this).getTitle()).append("' is added to download queue.").toString(), 0).show();
        } else
        {
            Toast.makeText(AppDetailsActivity.this, (new StringBuilder("'")).append(AppDetailsActivity.access$19(AppDetailsActivity.this)).append("' is added to download queue.").toString(), 0).show();
        }
        message = new Intent();
        message.setAction("appdetail");
        sendBroadcast(message);
        return;
_L5:
        if (System.currentTimeMillis() > SharedPreferencesConfig.GetClickTime(getApplicationContext()))
        {
            AppDetailsActivity.access$20(AppDetailsActivity.this).setImageResource(0x7f0200d8);
            message = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f04001e);
            AppDetailsActivity.access$20(AppDetailsActivity.this).startAnimation(message);
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    ()
    {
        this$0 = AppDetailsActivity.this;
        super();
    }
}
