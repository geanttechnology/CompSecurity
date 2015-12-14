// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class ep
{
    public static final class a
    {

        private eq a;

        public final void a()
        {
            if (eq.e().c())
            {
                eq.e().c("BluetoothHeadsetOEM reflected onServiceConnected()");
            }
            Object obj = eq.a(a);
            obj;
            JVM INSTR monitorenter ;
            if (eq.b(a))
            {
                break MISSING_BLOCK_LABEL_58;
            }
            eq.c(a);
            eq.a(a).notify();
_L2:
            return;
            eq.d(a);
            if (true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            throw exception;
        }

        public final void b()
        {
            if (eq.e().c())
            {
                eq.e().c("BluetoothHeadsetOEM reflected onServiceDisconnected()");
            }
            synchronized (eq.a(a))
            {
                eq.d(a);
                if (!eq.b(a))
                {
                    eq.c(a);
                    eq.a(a).notify();
                }
            }
        }

        a(eq eq1)
        {
            a = eq1;
            super();
        }
    }


    public static final String a;
    public static final String b;
    public static final int c;
    private static final Constructor d;
    private static final Method e;
    private static final Method f;
    private static final Method g;
    private static final Method h;
    private static final Class i;
    private Object j;
    private a k;

    public ep(Context context, a a1)
    {
        k = a1;
        a1 = getClass().getClassLoader();
        Class class1 = i;
        InvocationHandler invocationhandler = new InvocationHandler() {

            private ep a;

            public final Object invoke(Object obj, Method method, Object aobj[])
                throws Throwable
            {
                if (!method.getName().equals("onServiceConnected")) goto _L2; else goto _L1
_L1:
                if (ep.a(a) != null)
                {
                    ep.a(a).a();
                }
_L4:
                return null;
_L2:
                if (method.getName().equals("onServiceDisconnected") && ep.a(a) != null)
                {
                    ep.a(a).b();
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = ep.this;
                super();
            }
        };
        a1 = ((a) (Proxy.newProxyInstance(a1, new Class[] {
            class1
        }, invocationhandler)));
        try
        {
            j = d.newInstance(new Object[] {
                context, a1
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    static a a(ep ep1)
    {
        return ep1.k;
    }

    public final BluetoothDevice a()
    {
        BluetoothDevice bluetoothdevice;
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        bluetoothdevice = (BluetoothDevice)g.invoke(j, new Object[0]);
        return bluetoothdevice;
        Exception exception;
        exception;
        exception.printStackTrace();
        return null;
    }

    public final boolean b()
    {
        boolean flag;
        try
        {
            flag = ((Boolean)e.invoke(j, new Object[0])).booleanValue();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        return flag;
    }

    public final boolean c()
    {
        boolean flag;
        try
        {
            flag = ((Boolean)f.invoke(j, new Object[0])).booleanValue();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        return flag;
    }

    public final void d()
    {
        try
        {
            h.invoke(j, new Object[0]);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    static 
    {
        new er();
        Class class1 = er.a("android.bluetooth.BluetoothHeadset");
        Class class2 = er.a("android.bluetooth.BluetoothHeadset$ServiceListener");
        d = er.a(class1, new Class[] {
            android/content/Context, class2
        });
        if (er.b(class1, "getState", new Class[0]) == null)
        {
            er.a(class1, "getState", new Class[] {
                android/bluetooth/BluetoothDevice
            });
        }
        g = er.a(class1, "getCurrentHeadset", new Class[0]);
        er.a(class1, "connectHeadset", new Class[] {
            android/bluetooth/BluetoothDevice
        });
        if (er.b(class1, "disconnectHeadset", new Class[0]) == null)
        {
            er.a(class1, "disconnectHeadset", new Class[] {
                android/bluetooth/BluetoothDevice
            });
        }
        e = er.a(class1, "startVoiceRecognition", new Class[0]);
        f = er.a(class1, "stopVoiceRecognition", new Class[0]);
        h = er.a(class1, "close", new Class[0]);
        er.a(class1, "getPriority", new Class[] {
            android/bluetooth/BluetoothDevice
        });
        er.a(class1, "setPriority", new Class[] {
            android/bluetooth/BluetoothDevice, Integer.TYPE
        });
        i = class2;
        er.a(class1, "ACTION_STATE_CHANGED");
        a = (String)er.a(class1, "ACTION_AUDIO_STATE_CHANGED");
        er.a(class1, "EXTRA_STATE");
        b = (String)er.a(class1, "EXTRA_AUDIO_STATE");
        er.a(class1, "STATE_ERROR");
        er.a(class1, "STATE_DISCONNECTED");
        er.a(class1, "STATE_CONNECTING");
        er.a(class1, "STATE_CONNECTED");
        er.a(class1, "AUDIO_STATE_DISCONNECTED");
        c = ((Integer)er.a(class1, "AUDIO_STATE_CONNECTED")).intValue();
        er.a(class1, "PRIORITY_OFF");
        er.a(class1, "PRIORITY_UNDEFINED", Integer.valueOf(-1));
    }
}
