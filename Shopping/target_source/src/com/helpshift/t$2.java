// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.helpshift:
//            t

static final class  extends Handler
{

    final Handler a;

    public void handleMessage(Message message)
    {
        if (a != null)
        {
            Message message1 = a.obtainMessage();
            message1.obj = message.obj;
            a.sendMessage(message1);
        }
    }

    (Handler handler)
    {
        a = handler;
        super();
    }
}
