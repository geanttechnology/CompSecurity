// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.helpshift:
//            l

class  extends Handler
{

    final Handler a;
    final l b;

    public void handleMessage(Message message)
    {
        Message message1 = a.obtainMessage();
        message1.obj = message.obj;
        a.sendMessage(message1);
    }

    (l l1, Handler handler)
    {
        b = l1;
        a = handler;
        super();
    }
}
