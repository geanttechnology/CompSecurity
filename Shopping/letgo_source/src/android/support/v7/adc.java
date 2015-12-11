// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package android.support.v7:
//            adb, abt, abo, abb, 
//            acg, abd, abe

class adc extends adb
{

    private static final Object a = new Object();
    private static adc n;
    private Context b;
    private abd c;
    private volatile abb d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private abe j;
    private Handler k;
    private abt l;
    private boolean m;

    private adc()
    {
        e = 0x1b7740;
        f = true;
        g = false;
        h = true;
        i = true;
        j = new abe() {

            final adc a;

            public void a(boolean flag)
            {
                a.a(flag, adc.a(a));
            }

            
            {
                a = adc.this;
                super();
            }
        };
        m = false;
    }

    static boolean a(adc adc1)
    {
        return adc1.h;
    }

    static int b(adc adc1)
    {
        return adc1.e;
    }

    public static adc c()
    {
        if (n == null)
        {
            n = new adc();
        }
        return n;
    }

    static boolean c(adc adc1)
    {
        return adc1.m;
    }

    static Handler d(adc adc1)
    {
        return adc1.k;
    }

    static abd e(adc adc1)
    {
        return adc1.c;
    }

    static Object e()
    {
        return a;
    }

    private void f()
    {
        l = new abt(this);
        l.a(b);
    }

    private void g()
    {
        k = new Handler(b.getMainLooper(), new android.os.Handler.Callback() {

            final adc a;

            public boolean handleMessage(Message message)
            {
                if (1 == message.what && adc.e().equals(message.obj))
                {
                    a.a();
                    if (adc.b(a) > 0 && !adc.c(a))
                    {
                        adc.d(a).sendMessageDelayed(adc.d(a).obtainMessage(1, adc.e()), adc.b(a));
                    }
                }
                return true;
            }

            
            {
                a = adc.this;
                super();
            }
        });
        if (e > 0)
        {
            k.sendMessageDelayed(k.obtainMessage(1, a), e);
        }
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (g) goto _L2; else goto _L1
_L1:
        abo.d("Dispatch call queued. Dispatch will run once initialization is complete.");
        f = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        d.a(new Runnable() {

            final adc a;

            public void run()
            {
                adc.e(a).a();
            }

            
            {
                a = adc.this;
                super();
            }
        });
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    void a(Context context, abb abb1)
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
            d = abb1;
        }
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    void a(boolean flag)
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

    void a(boolean flag, boolean flag1)
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
        StringBuilder stringbuilder = (new StringBuilder()).append("PowerSaveMode ");
        Object obj;
        if (!flag && flag1)
        {
            obj = "terminated.";
        } else
        {
            obj = "initiated.";
        }
        abo.d(stringbuilder.append(((String) (obj))).toString());
        m = flag;
        h = flag1;
        if (true) goto _L3; else goto _L4
_L4:
        obj;
        throw obj;
    }

    void b()
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

    abd d()
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
        c = new acg(j, b);
        abd abd;
        if (k == null)
        {
            g();
        }
        g = true;
        if (f)
        {
            a();
            f = false;
        }
        if (l == null && i)
        {
            f();
        }
        abd = c;
        this;
        JVM INSTR monitorexit ;
        return abd;
    }

}
