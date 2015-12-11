// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.jirbo.adcolony:
//            ak, cv

class cw extends Handler
{

    cw()
    {
        sendMessageDelayed(obtainMessage(), 1000L);
    }

    public void handleMessage(Message message)
    {
        if (ak.x == null || ak.b().isFinishing())
        {
            ak.b("Monitor pinger exiting.");
            return;
        }
        if (ak.b().hasWindowFocus())
        {
            cv.a();
        }
        sendMessageDelayed(obtainMessage(), 1000L);
    }
}
