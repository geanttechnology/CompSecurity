// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;

// Referenced classes of package com.google.android.a.a.a:
//            s

final class a extends Handler
{

    final s a;

    public final void handleMessage(Message message)
    {
        if (message.what != 3) goto _L2; else goto _L1
_L1:
        s s1 = a;
        message = ((Message) (message.obj));
        s1.i();
_L4:
        return;
_L2:
        if (message.what == 4)
        {
            synchronized (a.c)
            {
                if (a.g && a.f() && a.c.contains(message.obj))
                {
                    ((a)message.obj).a();
                }
            }
            return;
        }
        continue; /* Loop/switch isn't completed */
        message;
        arraylist;
        JVM INSTR monitorexit ;
        throw message;
        if (message.what == 2 && !a.f() || message.what != 2 && message.what != 1) goto _L4; else goto _L3
_L3:
        ((a)message.obj).a();
        return;
    }

    (s s1)
    {
        a = s1;
        super();
    }
}
