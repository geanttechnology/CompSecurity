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

    final String a;
    final Handler b;
    final Handler c;
    final l d;

    public void handleMessage(Message message)
    {
        if (message.obj != null)
        {
            d.a(a, );
            message = b.obtainMessage();
            HashMap hashmap = new HashMap();
            hashmap.put("status", Integer.valueOf(0));
            hashmap.put("id", a);
            message.obj = hashmap;
            c.sendMessage(message);
        }
    }

    (l l1, String s, Handler handler, Handler handler1)
    {
        d = l1;
        a = s;
        b = handler;
        c = handler1;
        super();
    }
}
