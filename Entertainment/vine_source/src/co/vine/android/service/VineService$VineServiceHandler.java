// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.concurrent.ExecutorService;

// Referenced classes of package co.vine.android.service:
//            VineService

class this._cls0 extends Handler
{

    final VineService this$0;

    public void handleMessage(Message message)
    {
        message.getData().setClassLoader(getClassLoader());
        VineService.access$000(VineService.this).execute(new init>(VineService.this, 0, message.arg1, message.getData(), null, message.replyTo));
    }

    ()
    {
        this$0 = VineService.this;
        super();
    }
}
