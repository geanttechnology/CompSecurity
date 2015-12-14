// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            m, aj

public class f
{

    private static final int k = 1;
    private static final int l = 2;
    private static final int m = 3;
    private static final int n = 4;
    private HandlerThread a;
    private a b;
    private WeakReference c;
    private String d;
    private long e;
    private String f;
    private Context g;
    private volatile boolean h;
    private c i;
    private b j;

    public f()
    {
        h = false;
        j = new b();
        a = new HandlerThread("Thread[NdFileDownloader]", 10);
        a.start();
        b = new a(new Handler(a.getLooper()) {

            final f a;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                if (!f.a(a))
                {
                    f.b(a).a(message);
                }
            }

            
            {
                a = f.this;
                super(looper);
            }
        });
    }

    private void a()
    {
        c = (new m()).a(g, d, b);
    }

    private void a(Context context, String s, String s1, long l1, c c1)
    {
        g = context;
        d = s;
        e = l1;
        f = s1;
        if (e <= 0L)
        {
            e = 0x7fffffffL;
        }
        i = c1;
        b.a(s1);
    }

    static boolean a(f f1)
    {
        return f1.h;
    }

    static a b(f f1)
    {
        return f1.b;
    }

    private void b()
    {
        if (c != null)
        {
            Object obj = (Future)c.get();
            if (obj != null)
            {
                boolean flag = ((Future) (obj)).cancel(true);
                StringBuilder stringbuilder = (new StringBuilder()).append("NdFileDownloader:stop ");
                if (flag)
                {
                    obj = "1";
                } else
                {
                    obj = "0";
                }
                aj.a("BDAutoUpdateSDK", stringbuilder.append(((String) (obj))).toString());
            }
            c = null;
        }
    }

    static b c(f f1)
    {
        return f1.j;
    }

    private void c()
    {
        if (a != null)
        {
            a.interrupt();
            a = null;
        }
        if (b != null)
        {
            b.j();
            b = null;
        }
    }

    static void d(f f1)
    {
        f1.b();
    }

    static c e(f f1)
    {
        return f1.i;
    }

    static String f(f f1)
    {
        return f1.f;
    }

    public void a(boolean flag)
    {
        h = true;
        b();
        c();
    }

    public boolean a(Context context, String s, long l1, String s1, c c1)
    {
        while (a == null || c != null) 
        {
            return false;
        }
        a(context, s1, s, l1, c1);
        if (i != null)
        {
            i.a();
        }
        a();
        return true;
    }

    private class b extends Handler
    {

        final f a;

        public void a()
        {
            sendMessage(obtainMessage(2, null));
        }

        public void a(int i1, long l1, long l2)
        {
            sendMessage(obtainMessage(3, ((Object) (new Object[] {
                Integer.valueOf(i1), Long.valueOf(l1), Long.valueOf(l2)
            }))));
        }

        public void a(Throwable throwable, String s)
        {
            sendMessage(obtainMessage(1, ((Object) (new Object[] {
                throwable, s
            }))));
        }

        public void b()
        {
            sendMessage(obtainMessage(4, null));
        }

        public void handleMessage(Message message)
        {
            super.handleMessage(message);
            message.what;
            JVM INSTR tableswitch 1 4: default 40
        //                       1 125
        //                       2 41
        //                       3 64
        //                       4 171;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            return;
_L3:
            if (f.e(a) != null)
            {
                f.e(a).a();
                return;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            message = ((Message) ((Object[])(Object[])message.obj));
            if (f.e(a) != null)
            {
                f.e(a).a(((Integer)message[0]).intValue(), ((Long)message[1]).longValue(), ((Long)message[2]).longValue());
                return;
            }
            if (true) goto _L1; else goto _L2
_L2:
            message = ((Message) ((Object[])(Object[])message.obj));
            if (f.e(a) != null)
            {
                f.e(a).a((Throwable)message[0], (String)message[1]);
                return;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (f.e(a) != null)
            {
                f.e(a).a(f.f(a));
                return;
            }
            if (true) goto _L1; else goto _L6
_L6:
        }

        b()
        {
            a = f.this;
            super();
        }
    }


    private class a extends q
    {

        final f a;
        private boolean b;

        public void a()
        {
            super.a();
            f.c(a).a();
        }

        public void a(int i1, long l1, long l2)
        {
            super.a(i1, l1, l2);
            f.c(a).a(i1, l1, l2);
        }

        public void a(int i1, String s)
        {
            super.a(i1, s);
        }

        public void a(Message message)
        {
            super.a(message);
        }

        public void a(Throwable throwable, String s)
        {
            super.a(throwable, s);
            f.c(a).a(throwable, s);
        }

        public void a(byte abyte0[], int i1)
        {
            super.a(abyte0, i1);
            if (f.e(a) != null)
            {
                f.e(a).c();
            }
        }

        public void b()
        {
            super.b();
            f.c(a).b();
            b = true;
        }

        public void b(Throwable throwable, String s)
        {
            super.b(throwable, s);
            f.d(a);
        }

        public void c()
        {
            super.c();
            if (b)
            {
                a.a(true);
            }
        }

        public a(Handler handler)
        {
            a = f.this;
            super(handler);
            b = false;
        }
    }


    private class c
    {

        public abstract void a();

        public abstract void a(int i1, long l1, long l2);

        public abstract void a(String s);

        public abstract void a(Throwable throwable, String s);

        public abstract void b();

        public abstract void c();
    }

}
