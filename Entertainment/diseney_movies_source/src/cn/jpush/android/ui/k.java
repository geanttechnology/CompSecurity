// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.ui;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.a;

// Referenced classes of package cn.jpush.android.ui:
//            PushActivity

final class k extends Handler
{

    final PushActivity a;

    k(PushActivity pushactivity)
    {
        a = pushactivity;
        super();
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 0 6: default 48
    //                   0 49
    //                   1 48
    //                   2 89
    //                   3 48
    //                   4 129
    //                   5 169
    //                   6 177;
           goto _L1 _L2 _L1 _L3 _L1 _L4 _L5 _L6
_L1:
        return;
_L2:
        a.setRequestedOrientation(0);
        PushActivity.c(a).removeMessages(0);
        PushActivity.c(a).removeMessages(1);
        sendEmptyMessageDelayed(1, 1000L);
        return;
_L3:
        a.setRequestedOrientation(1);
        PushActivity.c(a).removeMessages(2);
        PushActivity.c(a).removeMessages(3);
        sendEmptyMessageDelayed(3, 1000L);
        return;
_L4:
        a.setRequestedOrientation(1);
        PushActivity.c(a).removeMessages(4);
        PushActivity.c(a).removeMessages(5);
        sendEmptyMessageDelayed(5, 1000L);
        return;
_L5:
        PushActivity.d(a);
        return;
_L6:
        if (PushActivity.e(a) != null)
        {
            PushActivity.e(a).dismiss();
            cn.jpush.android.util.a.e(a.getApplicationContext(), (String)message.obj);
            ServiceInterface.a(cn.jpush.android.ui.PushActivity.a(a), 1007, a);
            a.finish();
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }
}
