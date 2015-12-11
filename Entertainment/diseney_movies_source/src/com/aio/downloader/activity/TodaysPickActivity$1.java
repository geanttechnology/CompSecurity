// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.aio.downloader.utils.SharedPreferencesConfig;

// Referenced classes of package com.aio.downloader.activity:
//            TodaysPickActivity

class this._cls0 extends Handler
{

    final TodaysPickActivity this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        if (message.what == 30000 && System.currentTimeMillis() > SharedPreferencesConfig.GetClickTime(getApplicationContext()))
        {
            TodaysPickActivity.access$0(TodaysPickActivity.this).setImageResource(0x7f0200d8);
            message = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f04001e);
            TodaysPickActivity.access$0(TodaysPickActivity.this).startAnimation(message);
        }
    }

    ()
    {
        this$0 = TodaysPickActivity.this;
        super();
    }
}
