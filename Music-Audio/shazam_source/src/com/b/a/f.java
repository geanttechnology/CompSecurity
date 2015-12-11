// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import android.content.Context;
import android.content.IntentFilter;
import com.b.b.e;
import com.b.e.c;
import com.b.e.d;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.b.a:
//            b, p, a, d

final class f extends TimerTask
{

    final a a;
    final a b;
    final com.b.a.d c;
    final com.b.a.d d;
    final b e;

    f(b b1, a a1, a a2, com.b.a.d d1, com.b.a.d d2)
    {
        e = b1;
        a = a1;
        b = a2;
        c = d1;
        d = d2;
        super();
    }

    public final void run()
    {
        b b1 = e;
        b1;
        JVM INSTR monitorenter ;
        if (e.j != null)
        {
            e.j.cancel();
            e.k = null;
            e.j = null;
        }
        boolean flag = false;
        if (a == b) goto _L2; else goto _L1
_L1:
        Object obj;
        a a1;
        obj = e;
        a1 = e.y;
        (new StringBuilder("Leaving application state: ")).append(a1);
        com.b.e.c.a(obj);
        p.a[a1.ordinal()];
        JVM INSTR tableswitch 1 3: default 304
    //                   1 232
    //                   2 285
    //                   3 292;
           goto _L3 _L4 _L5 _L6
_L3:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_292;
_L7:
        e.b(b);
        e.g();
        e.y = b;
        flag = true;
_L2:
        if (c != d)
        {
            e.a(e.L);
            e.b(d);
            e.h();
            e.L = d;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        e.a(e.y);
        b1;
        JVM INSTR monitorexit ;
        return;
_L4:
        ((b) (obj)).h.a();
        ((b) (obj)).c.a(3000);
        ((b) (obj)).ab.registerReceiver(((b) (obj)).h, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        ((b) (obj)).d.a();
          goto _L7
        obj;
        b1;
        JVM INSTR monitorexit ;
        throw obj;
_L5:
        ((b) (obj)).C();
          goto _L7
        obj.x = null;
        ((b) (obj)).C();
          goto _L7
    }
}
