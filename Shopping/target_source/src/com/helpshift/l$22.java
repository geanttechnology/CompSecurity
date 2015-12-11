// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import com.helpshift.h.a;

// Referenced classes of package com.helpshift:
//            l

class <init> extends Handler
{

    final String a;
    final Boolean b;
    final Handler c;
    final l d;

    public void handleMessage(Message message)
    {
        l.d(d).a(a, b);
        Message message1 = c.obtainMessage();
        message1.obj = message.obj;
        c.sendMessage(message1);
    }

    (l l1, String s, Boolean boolean1, Handler handler)
    {
        d = l1;
        a = s;
        b = boolean1;
        c = handler;
        super();
    }
}
