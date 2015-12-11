// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.google.android.gms.e:
//            bw, aj, w, bb, 
//            ao, y, z

final class bx extends bw
{

    private static final Object a = new Object();
    private static bx n;
    private Context b;
    private y c;
    private volatile w d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private z j;
    private Handler k;
    private ao l;
    private boolean m;

    private bx()
    {
        e = 0x1b7740;
        f = true;
        g = false;
        h = true;
        i = true;
        j = new z() {

            final bx a;

            public final void a(boolean flag)
            {
                a.a(flag, bx.a(a));
            }

            
            {
                a = bx.this;
                super();
            }
        };
        m = false;
    }

    static boolean a(bx bx1)
    {
        return bx1.h;
    }

    static int b(bx bx1)
    {
        return bx1.e;
    }

    public static bx c()
    {
        if (n == null)
        {
            n = new bx();
        }
        return n;
    }

    static boolean c(bx bx1)
    {
        return bx1.m;
    }

    static Handler d(bx bx1)
    {
        return bx1.k;
    }

    static y e(bx bx1)
    {
        return bx1.c;
    }

    static Object e()
    {
        return a;
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (g) goto _L2; else goto _L1
_L1:
        aj.d();
        f = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        d.a(new Runnable() {

            final bx a;

            public final void run()
            {
                bx.e(a).a();
            }

            
            {
                a = bx.this;
                super();
            }
        });
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    final void a(Context context, w w1)
    {
        this;
        JVM INSTR monitorenter ;
        Context context1 = b;
        if (context1 == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        b = context.getApplicationContext();
        if (d == null)
        {
            d = w1;
        }
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    final void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        a(m, flag);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final void a(boolean flag, boolean flag1)
    {
        this;
        JVM INSTR monitorenter ;
        if (m != flag) goto _L2; else goto _L1
_L1:
        boolean flag2 = h;
        if (flag2 != flag1) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!flag && flag1)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        if (e > 0)
        {
            k.removeMessages(1, a);
        }
        if (flag || !flag1)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (e > 0)
        {
            k.sendMessageDelayed(k.obtainMessage(1, a), e);
        }
        StringBuilder stringbuilder = new StringBuilder("PowerSaveMode ");
        Object obj;
        if (!flag && flag1)
        {
            obj = "terminated.";
        } else
        {
            obj = "initiated.";
        }
        stringbuilder.append(((String) (obj)));
        aj.d();
        m = flag;
        h = flag1;
        if (true) goto _L3; else goto _L4
_L4:
        obj;
        throw obj;
    }

    final void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (!m && h && e > 0)
        {
            k.removeMessages(1, a);
            k.sendMessage(k.obtainMessage(1, a));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final y d()
    {
        this;
        JVM INSTR monitorenter ;
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        if (b == null)
        {
            throw new IllegalStateException("Cant get a store unless we have a context");
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        c = new bb(j, b);
        y y;
        if (k == null)
        {
            k = new Handler(b.getMainLooper(), new android.os.Handler.Callback() {

                final bx a;

                public final boolean handleMessage(Message message)
                {
                    if (1 == message.what && bx.e().equals(message.obj))
                    {
                        a.a();
                        if (bx.b(a) > 0 && !bx.c(a))
                        {
                            bx.d(a).sendMessageDelayed(bx.d(a).obtainMessage(1, bx.e()), bx.b(a));
                        }
                    }
                    return true;
                }

            
            {
                a = bx.this;
                super();
            }
            });
            if (e > 0)
            {
                k.sendMessageDelayed(k.obtainMessage(1, a), e);
            }
        }
        g = true;
        if (f)
        {
            a();
            f = false;
        }
        if (l == null && i)
        {
            l = new ao(this);
            ao ao1 = l;
            Context context = b;
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(ao1, intentfilter);
            intentfilter = new IntentFilter();
            intentfilter.addAction("com.google.analytics.RADIO_POWERED");
            intentfilter.addCategory(context.getPackageName());
            context.registerReceiver(ao1, intentfilter);
        }
        y = c;
        this;
        JVM INSTR monitorexit ;
        return y;
    }

}
