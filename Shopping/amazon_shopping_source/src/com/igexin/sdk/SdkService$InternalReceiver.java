// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;

// Referenced classes of package com.igexin.sdk:
//            SdkService, Consts

class this._cls0 extends BroadcastReceiver
{

    final SdkService this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = new Message();
        context.what = Consts.MESSAGE_RECEIVER_INTERNAL;
        context.obj = intent;
        SdkService.sendMessage(context);
    }

    ()
    {
        this$0 = SdkService.this;
        super();
    }
}
