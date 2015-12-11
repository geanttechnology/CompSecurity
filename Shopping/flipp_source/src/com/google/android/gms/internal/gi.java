// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;

// Referenced classes of package com.google.android.gms.internal:
//            gj, gb

public final class gi
    implements android.os.Handler.Callback
{

    private static final Object a = new Object();
    private static gi b;
    private final Context c;
    private final HashMap d = new HashMap();
    private final Handler e;

    private gi(Context context)
    {
        e = new Handler(context.getMainLooper(), this);
        c = context.getApplicationContext();
    }

    public static gi a(Context context)
    {
        synchronized (a)
        {
            if (b == null)
            {
                b = new gi(context.getApplicationContext());
            }
        }
        return b;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static HashMap a(gi gi1)
    {
        return gi1.d;
    }

    public final boolean a(String s, gb gb1)
    {
        HashMap hashmap = d;
        hashmap;
        JVM INSTR monitorenter ;
        gj gj1 = (gj)d.get(s);
        if (gj1 != null) goto _L2; else goto _L1
_L1:
        gj1 = new gj(this, s);
        gj1.a(gb1);
        gb1 = (new Intent(s)).setPackage("com.google.android.gms");
        gj1.e = c.bindService(gb1, gj1.b, 129);
        d.put(s, gj1);
        s = gj1;
_L7:
        boolean flag = ((gj) (s)).e;
        hashmap;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        e.removeMessages(0, gj1);
        if (gj1.b(gb1))
        {
            throw new IllegalStateException((new StringBuilder("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=")).append(s).toString());
        }
        break MISSING_BLOCK_LABEL_144;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
        gj1.a(gb1);
        gj1.d;
        JVM INSTR tableswitch 1 2: default 231
    //                   1 176
    //                   2 193;
           goto _L3 _L4 _L5
_L4:
        gb1.onServiceConnected(gj1.g, gj1.f);
        s = gj1;
        continue; /* Loop/switch isn't completed */
_L5:
        s = (new Intent(s)).setPackage("com.google.android.gms");
        gj1.e = c.bindService(s, gj1.b, 129);
        s = gj1;
        continue; /* Loop/switch isn't completed */
_L3:
        s = gj1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final void b(String s, gb gb1)
    {
        HashMap hashmap = d;
        hashmap;
        JVM INSTR monitorenter ;
        gj gj1 = (gj)d.get(s);
        if (gj1 != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        throw new IllegalStateException((new StringBuilder("Nonexistent connection status for service action: ")).append(s).toString());
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
        if (!gj1.b(gb1))
        {
            throw new IllegalStateException((new StringBuilder("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=")).append(s).toString());
        }
        gj1.c.remove(gb1);
        if (gj1.c.isEmpty())
        {
            s = e.obtainMessage(0, gj1);
            e.sendMessageDelayed(s, 5000L);
        }
        hashmap;
        JVM INSTR monitorexit ;
    }

    public final boolean handleMessage(Message message)
    {
        gj gj1;
        switch (message.what)
        {
        default:
            return false;

        case 0: // '\0'
            gj1 = (gj)message.obj;
            break;
        }
        synchronized (d)
        {
            if (gj1.c.isEmpty())
            {
                c.unbindService(gj1.b);
                d.remove(gj1.a);
            }
        }
        return true;
        exception;
        message;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
