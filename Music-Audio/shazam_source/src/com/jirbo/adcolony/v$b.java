// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.jirbo.adcolony:
//            v, e, ad

final class a extends Handler
{

    final v a;

    private void a()
    {
        sendMessageDelayed(obtainMessage(), 500L);
    }

    public final void handleMessage(Message message)
    {
        a();
        while (a.d.isFinishing() || a.d.B == null) 
        {
            return;
        }
        this;
        JVM INSTR monitorenter ;
        if (a.ac != null && a.ac.a() && !a.d.B.isPlaying())
        {
            a.ac = null;
            a.t = 0;
            if (a.d.B != null)
            {
                a.d.B.a();
            }
            a.d.m = true;
            a.c();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        message;
        this;
        JVM INSTR monitorexit ;
        throw message;
    }

    (v v1)
    {
        a = v1;
        super();
        a();
    }
}
