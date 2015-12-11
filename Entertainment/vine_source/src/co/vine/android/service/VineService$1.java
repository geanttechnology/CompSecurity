// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import co.vine.android.client.AppController;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.service:
//            VineService

class t> extends BroadcastReceiver
{

    final VineService this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (intent != null && "co.vine.android.service.mergePost".equals(intent.getAction()))
        {
            SLog.d("Received broadcasted intent to merge a single post.");
            AppController.getInstance(VineService.this).mergeSinglePost(intent.getExtras());
        }
    }

    ()
    {
        this$0 = VineService.this;
        super();
    }
}
