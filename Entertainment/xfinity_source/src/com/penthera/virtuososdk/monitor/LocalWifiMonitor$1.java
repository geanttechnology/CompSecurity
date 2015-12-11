// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.monitor;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.penthera.virtuososdk.monitor:
//            LocalWifiMonitor

class this._cls0 extends Handler
{

    final LocalWifiMonitor this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            com.penthera.virtuososdk.utility.this._mth0(LocalWifiMonitor.access$1(), (new StringBuilder("c[] Wrong message ")).append(message.what).toString());
            return;

        case 1: // '\001'
            LocalWifiMonitor.access$0(LocalWifiMonitor.this);
            break;
        }
    }

    _cls9()
    {
        this$0 = LocalWifiMonitor.this;
        super();
    }
}
