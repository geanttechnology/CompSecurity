// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.jirbo.adcolony:
//            au, o

class > extends Handler
{

    final au a;

    public void handleMessage(Message message)
    {
        while (a.d.isFinishing() || a.d.B == null) 
        {
            return;
        }
        a.a(message.what);
    }

    (au au1)
    {
        a = au1;
        super();
    }
}
