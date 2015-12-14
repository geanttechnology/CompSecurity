// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public abstract class eo
{

    private static final bm c = d.a(eo);
    protected Context a;
    protected eq b;
    private Object d;

    protected eo(Context context)
    {
        d = new Object();
        a = context;
        b = new eq(a);
    }

    public static eo a(Context context)
    {
        int i = em.a;
        if (i < 8 || em.b)
        {
            return new et(context);
        }
        if (i < 9)
        {
            return new eu(context);
        } else
        {
            return new es(context);
        }
    }

    static Object a(eo eo1)
    {
        return eo1.d;
    }

    static bm h()
    {
        return c;
    }

    public final void a()
    {
        BroadcastReceiver broadcastreceiver;
        IntentFilter intentfilter;
        intentfilter = new IntentFilter(eq.a);
        broadcastreceiver = new BroadcastReceiver() {

            private eo a;

            public final void onReceive(Context context, Intent intent)
            {
                int i = intent.getIntExtra(eq.b, -1);
                if (eo.h().c())
                {
                    eo.h().c((new StringBuilder("BluetoothHeadset BroadcastReceiver ")).append(i).toString());
                }
                synchronized (eo.a(a))
                {
                    if (i == eq.c)
                    {
                        if (eo.h().c())
                        {
                            eo.h().c("BluetoothHeadset SCO connected. Notify wait lock.");
                        }
                        eo.a(a).notify();
                    }
                }
            }

            
            {
                a = eo.this;
                super();
            }
        };
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        long l;
        a.registerReceiver(broadcastreceiver, intentfilter);
        l = System.currentTimeMillis();
        d();
        d.wait(3000L);
_L2:
        if (c.c())
        {
            c.c((new StringBuilder("BluetoothHeadset ")).append(System.currentTimeMillis() - l).append("ms to wait for SCO").toString());
        }
        a.unregisterReceiver(broadcastreceiver);
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        if (!c.e()) goto _L2; else goto _L1
_L1:
        c.e((new StringBuilder("BluetoothHeadset mHeadsetScoSyncObj.wait() threw exception:")).append(interruptedexception).toString());
          goto _L2
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean b()
    {
        return b.a() != null;
    }

    public final void c()
    {
        if (b != null)
        {
            try
            {
                b.d();
            }
            catch (Throwable throwable) { }
            b = null;
        }
    }

    public abstract void d();

    public abstract void e();

    public abstract int f();

    public abstract int g();

}
