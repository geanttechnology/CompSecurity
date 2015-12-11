// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.aio.downloader.jpush:
//            JpushMainActivity

public class this._cls0 extends BroadcastReceiver
{

    final JpushMainActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        if ("com.example.jpushdemo.MESSAGE_RECEIVED_ACTION".equals(intent.getAction()))
        {
            context = intent.getStringExtra("message");
            intent.getStringExtra("extras");
            (new StringBuilder()).append((new StringBuilder("message : ")).append(context).append("\n").toString());
        }
    }

    public ()
    {
        this$0 = JpushMainActivity.this;
        super();
    }
}
