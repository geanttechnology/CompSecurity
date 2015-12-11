// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;

import android.content.Intent;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.igexin.sdk:
//            SdkService, Consts

static class intent extends Thread
{

    private Intent intent;

    public void run()
    {
        Looper.prepare();
        SdkService.access$300(SdkService.getInstance());
        if (Consts.VPUSH_APPID != null && Consts.VPUSH_APPKEY != null && Consts.VPUSH_APPSECRET != null)
        {
            SdkService.msgLooperHandler = new ();
            byte _tmp = SdkService.access$402((byte)1);
            if (intent != null)
            {
                Message message = new Message();
                message.what = 11000;
                message.obj = intent;
                SdkService.sendMessage(message);
            }
        }
        Looper.loop();
    }

    public (Intent intent1)
    {
        intent = intent1;
    }
}
