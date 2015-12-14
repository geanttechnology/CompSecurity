// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Looper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public final class eq
{

    public static String a;
    public static String b;
    public static int c;
    private static final bm d = d.a(eo);
    private Context e;
    private boolean f;
    private ep g;
    private boolean h;
    private boolean i;
    private Object j;
    private final er k;
    private Object l;

    public eq(Context context)
    {
        Object obj;
        g = null;
        h = false;
        i = false;
        j = null;
        l = new Object();
        e = context;
        k = new er();
        if (em.a > 10)
        {
            break MISSING_BLOCK_LABEL_249;
        }
        f = true;
        a = ep.a;
        b = ep.b;
        c = ep.c;
        obj = new ep.a(this);
        context = ((Context) (l));
        context;
        JVM INSTR monitorenter ;
        long l1;
        l1 = System.currentTimeMillis();
        g = new ep(e, ((ep.a) (obj)));
        l.wait(1000L);
_L4:
        if (i) goto _L2; else goto _L1
_L1:
        if (d.e())
        {
            d.e("BluetoothHeadsetOEM reflected service NOT connected in time. Gave up!!!");
        }
        h = true;
        f();
_L6:
        return;
        Object obj1;
        obj1;
        if (!d.e()) goto _L4; else goto _L3
_L3:
        d.e((new StringBuilder("BluetoothHeadsetOEM reflected mHeadsetSyncObj.wait() threw exception:")).append(obj1).toString());
          goto _L4
        obj1;
        throw obj1;
_L2:
        if (!d.c()) goto _L6; else goto _L5
_L5:
        d.c((new StringBuilder("BluetoothHeadsetOEM reflected service connection took ")).append(System.currentTimeMillis() - l1).append("ms").toString());
          goto _L6
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        f = false;
        obj1 = k;
        obj1 = er.a("android.bluetooth.BluetoothHeadset");
        obj2 = k;
        a = (String)er.a(((Class) (obj1)), "ACTION_AUDIO_STATE_CHANGED");
        obj2 = k;
        b = (String)er.a(((Class) (obj1)), "EXTRA_STATE");
        obj2 = k;
        c = ((Integer)er.a(((Class) (obj1)), "STATE_AUDIO_CONNECTED")).intValue();
        er er2;
        boolean flag;
        if (em.a == 11 || em.a == 12 || em.a == 13)
        {
            Object aobj[] = new Object[2];
            (new Thread(new Runnable(aobj) {

                private Object a[];

                public final void run()
                {
                    Looper.prepare();
                    a[1] = BluetoothAdapter.getDefaultAdapter();
                    a[0] = new Boolean(true);
                    Looper.loop();
                }

            
            {
                a = aobj;
                super();
            }
            })).start();
            while (aobj[0] == null) 
            {
                try
                {
                    Thread.sleep(10L);
                }
                catch (Exception exception) { }
            }
            aobj = (BluetoothAdapter)aobj[1];
        } else
        {
            aobj = BluetoothAdapter.getDefaultAdapter();
        }
        exception = k;
        obj3 = er.a("android.bluetooth.BluetoothProfile$ServiceListener");
        exception = getClass().getClassLoader();
        obj4 = new InvocationHandler() {

            private eq a;

            public final Object invoke(Object obj7, Method method, Object aobj1[])
                throws Throwable
            {
                if (!method.getName().equals("onServiceConnected"))
                {
                    break MISSING_BLOCK_LABEL_101;
                }
                if (eq.e().c())
                {
                    eq.e().c("BluetoothHeadsetOEM native onServiceConnected()");
                }
                obj7 = eq.a(a);
                obj7;
                JVM INSTR monitorenter ;
                if (eq.b(a))
                {
                    break MISSING_BLOCK_LABEL_83;
                }
                eq.c(a);
                eq.a(a, aobj1[1]);
                eq.a(a).notify();
_L2:
                break MISSING_BLOCK_LABEL_178;
                eq.b(a, aobj1[1]);
                if (true) goto _L2; else goto _L1
_L1:
                method;
                throw method;
                if (method.getName().equals("onServiceDisconnected"))
                {
                    if (eq.e().c())
                    {
                        eq.e().c("BluetoothHeadsetOEM native onServiceDisconnected()");
                    }
                    synchronized (eq.a(a))
                    {
                        if (!eq.b(a))
                        {
                            eq.c(a);
                            eq.a(a).notify();
                        }
                    }
                }
                return null;
            }

            
            {
                a = eq.this;
                super();
            }
        };
        obj4 = Proxy.newProxyInstance(exception, new Class[] {
            obj3
        }, ((InvocationHandler) (obj4)));
        exception = ((Exception) (l));
        exception;
        JVM INSTR monitorenter ;
        l1 = System.currentTimeMillis();
        obj5 = k;
        obj5 = er.a("android.bluetooth.BluetoothProfile");
        obj6 = k;
        obj6 = er.a("android.bluetooth.BluetoothAdapter");
        er2 = k;
        flag = ((Boolean)er.a(((Class) (obj6)), "isEnabled", new Class[0]).invoke(((Object) (aobj)), new Object[0])).booleanValue();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_537;
        }
        exception;
        JVM INSTR monitorexit ;
        return;
        context;
        exception;
        JVM INSTR monitorexit ;
        throw context;
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        er er3 = k;
        obj3 = er.a(((Class) (obj6)), "getProfileProxy", new Class[] {
            android/content/Context, obj3, Integer.TYPE
        });
        er er1 = k;
        ((Method) (obj3)).invoke(((Object) (aobj)), new Object[] {
            context, obj4, er.a(((Class) (obj5)), "HEADSET")
        });
_L9:
        l.wait(1000L);
_L11:
        if (i) goto _L8; else goto _L7
_L7:
        if (d.e())
        {
            d.e("BluetoothHeadsetOEM native service NOT connected in time. Gave up!!!");
        }
        h = true;
_L13:
        exception;
        JVM INSTR monitorexit ;
        return;
        context;
        context.printStackTrace();
          goto _L9
        context;
        if (!d.e()) goto _L11; else goto _L10
_L10:
        d.e((new StringBuilder("BluetoothHeadsetOEM native mHeadsetSyncObj.wait() threw exception:")).append(context).toString());
          goto _L11
_L8:
        if (!d.c()) goto _L13; else goto _L12
_L12:
        d.c((new StringBuilder("BluetoothHeadsetOEM native service connection took ")).append(System.currentTimeMillis() - l1).append("ms").toString());
          goto _L13
    }

    static Object a(eq eq1)
    {
        return eq1.l;
    }

    static Object a(eq eq1, Object obj)
    {
        eq1.j = obj;
        return obj;
    }

    private void a(Object obj)
    {
        Object obj1 = k;
        obj1 = er.a("android.bluetooth.BluetoothProfile");
        Object obj2 = k;
        obj2 = er.a("android.bluetooth.BluetoothAdapter");
        Object obj3 = k;
        obj2 = er.b(((Class) (obj2)), "closeProfileProxy", new Class[] {
            Integer.TYPE, obj1
        });
        obj3 = BluetoothAdapter.getDefaultAdapter();
        try
        {
            er er1 = k;
            ((Method) (obj2)).invoke(obj3, new Object[] {
                (Integer)er.a(((Class) (obj1)), "HEADSET"), obj
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
    }

    static void b(eq eq1, Object obj)
    {
        eq1.a(obj);
    }

    static boolean b(eq eq1)
    {
        return eq1.h;
    }

    static boolean c(eq eq1)
    {
        eq1.i = true;
        return true;
    }

    static void d(eq eq1)
    {
        eq1.f();
    }

    static bm e()
    {
        return d;
    }

    private void f()
    {
        if (g != null)
        {
            g.d();
            g = null;
        }
    }

    public final BluetoothDevice a()
    {
        if (f && g != null)
        {
            return g.a();
        }
        if (!f && j != null)
        {
            Object obj = k;
            obj = er.a("android.bluetooth.BluetoothProfile");
            er er1 = k;
            obj = er.b(((Class) (obj)), "getConnectedDevices", new Class[0]);
            try
            {
                obj = (List)((Method) (obj)).invoke(j, new Object[0]);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                exception = null;
            }
            if (obj != null && ((List) (obj)).size() > 0)
            {
                return (BluetoothDevice)((List) (obj)).get(0);
            } else
            {
                return null;
            }
        } else
        {
            return null;
        }
    }

    public final boolean b()
    {
        if (!f) goto _L2; else goto _L1
_L1:
        if (g != null) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        return g.b();
_L2:
        if (d.e())
        {
            d.e("BluetoothHeadsetOEM startVoiceRecognition() called on native headset!!!");
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public final boolean c()
    {
        if (!f) goto _L2; else goto _L1
_L1:
        if (g != null) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        return g.c();
_L2:
        if (d.e())
        {
            d.e("BluetoothHeadsetOEM stopVoiceRecognition() called on native headset!!!");
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public final void d()
    {
        if (f)
        {
            f();
        } else
        if (j != null)
        {
            a(j);
            j = null;
            return;
        }
    }

}
