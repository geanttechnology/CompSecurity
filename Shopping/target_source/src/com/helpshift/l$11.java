// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import java.util.HashMap;

// Referenced classes of package com.helpshift:
//            l

class <init> extends Handler
{

    final Handler a;
    final l b;

    public void handleMessage(Message message)
    {
        message = (HashMap)message.obj;
        l.e = false;
        Message message1 = a.obtainMessage();
        message1.obj = message;
        a.sendMessage(message1);
    }

    (l l1, Handler handler)
    {
        b = l1;
        a = handler;
        super();
    }
}
