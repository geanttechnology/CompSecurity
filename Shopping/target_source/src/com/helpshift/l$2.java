// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.helpshift:
//            l, s

class  extends Handler
{

    final Handler a;
    final l b;

    public void handleMessage(Message message)
    {
        message = b.a.d(b.B());
        Message message1 = a.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putInt("value", message.intValue());
        bundle.putBoolean("cache", false);
        message1.obj = bundle;
        a.sendMessage(message1);
    }

    (l l1, Handler handler)
    {
        b = l1;
        a = handler;
        super();
    }
}
