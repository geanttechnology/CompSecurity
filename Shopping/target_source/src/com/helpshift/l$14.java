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
    final String b;
    final l c;

    public void handleMessage(Message message)
    {
        if (message.obj != null)
        {
            message = a.obtainMessage();
            HashMap hashmap = new HashMap();
            hashmap.put("status", Integer.valueOf(200));
            hashmap.put("id", b);
            message.obj = hashmap;
            a.sendMessage(message);
        }
    }

    (l l1, Handler handler, String s)
    {
        c = l1;
        a = handler;
        b = s;
        super();
    }
}
