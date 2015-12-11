// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.a.a.a;
import com.google.android.a.a.b;
import java.util.ArrayList;

// Referenced classes of package com.google.android.a.a.a:
//            u, b, z, k

public abstract class s
    implements u
{
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
                        ((u.a)message.obj).a();
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
            ((b)message.obj).a();
            return;
        }

        a()
        {
            a = s.this;
            super();
        }
    }

    protected abstract class b
    {

        Object a;
        final s b;

        public final void a()
        {
            this;
            JVM INSTR monitorenter ;
            Object obj = a;
            this;
            JVM INSTR monitorexit ;
            a(obj);
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected abstract void a(Object obj);

        public b(Object obj)
        {
            b = s.this;
            super();
            a = Object.this;
            synchronized (f)
            {
                f.add(this);
            }
            return;
            s1;
            Object.this;
            JVM INSTR monitorexit ;
            throw s.this;
        }
    }

    protected final class c extends b
    {

        public final com.google.android.a.a.b c;
        public final IBinder d;
        final s e;

        protected final void a(Object obj)
        {
            boolean flag1;
label0:
            {
                flag1 = true;
                static final class _cls1
                {

                    static final int a[];

                    static 
                    {
                        a = new int[com.google.android.a.a.b.values().length];
                        try
                        {
                            a[com.google.android.a.a.b.a.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror) { }
                    }
                }

                if ((Boolean)obj != null)
                {
                    switch (com.google.android.a.a.a._cls1.a[c.ordinal()])
                    {
                    default:
                        e.i();
                        break;

                    case 1: // '\001'
                        break label0;
                    }
                }
                return;
            }
            obj = d.getInterfaceDescriptor();
            if (!e.b().equals(obj)) goto _L2; else goto _L1
_L1:
            e.b = e.a(d);
            if (e.b == null) goto _L2; else goto _L3
_L3:
            s s1 = e;
            obj = s1.c;
            obj;
            JVM INSTR monitorenter ;
            Exception exception;
            ArrayList arraylist;
            int l;
            int i1;
            boolean flag;
            if (!s1.e)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            com.google.android.a.a.a.b.a(flag);
            s1.a.removeMessages(4);
            s1.e = true;
            if (s1.d.size() == 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            com.google.android.a.a.a.b.a(flag);
            arraylist = s1.c;
            i1 = arraylist.size();
            l = 0;
_L9:
            if (l >= i1) goto _L5; else goto _L4
_L4:
            if (!s1.g || !s1.f()) goto _L5; else goto _L6
_L6:
            if (!s1.d.contains(arraylist.get(l)))
            {
                ((u.a)arraylist.get(l)).a();
            }
              goto _L7
_L5:
            s1.d.clear();
            s1.e = false;
            obj;
            JVM INSTR monitorexit ;
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            try
            {
                throw exception;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
_L2:
            e.g();
            obj = e;
            com.google.android.a.a.b b1 = com.google.android.a.a.b.b;
            ((s) (obj)).i();
            return;
_L7:
            l++;
            if (true) goto _L9; else goto _L8
_L8:
        }

        public c(String s2, IBinder ibinder)
        {
            e = s.this;
            super(Boolean.valueOf(true));
            c = com.google.android.a.a.a.s.a(s2);
            d = ibinder;
        }
    }

    protected final class d extends e.a
    {

        final s a;

        public final void a(String s1, IBinder ibinder)
        {
            a.a.sendMessage(a.a.obtainMessage(1, a. new c(s1, ibinder)));
        }

        protected d()
        {
            a = s.this;
            super();
        }
    }

    final class e
        implements ServiceConnection
    {

        final s a;

        public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            a.b(ibinder);
        }

        public final void onServiceDisconnected(ComponentName componentname)
        {
            a.b = null;
            a.h();
        }

        e()
        {
            a = s.this;
            super();
        }
    }


    final Handler a;
    IInterface b;
    ArrayList c;
    final ArrayList d = new ArrayList();
    boolean e;
    final ArrayList f = new ArrayList();
    boolean g;
    private final Context h;
    private ArrayList i;
    private boolean j;
    private ServiceConnection k;

    protected s(Context context, u.a a1, u.b b1)
    {
        e = false;
        j = false;
        g = false;
        if (Looper.getMainLooper().getThread() != Thread.currentThread())
        {
            throw new IllegalStateException("Clients must be created on the UI thread.");
        } else
        {
            h = (Context)com.google.android.a.a.a.b.a(context);
            c = new ArrayList();
            c.add(com.google.android.a.a.a.b.a(a1));
            i = new ArrayList();
            i.add(com.google.android.a.a.a.b.a(b1));
            a = new a();
            return;
        }
    }

    static com.google.android.a.a.b a(String s1)
    {
        try
        {
            s1 = com.google.android.a.a.b.valueOf(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return com.google.android.a.a.b.c;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return com.google.android.a.a.b.c;
        }
        return s1;
    }

    protected abstract IInterface a(IBinder ibinder);

    protected abstract void a(k k1, d d1);

    protected abstract String b();

    protected final void b(IBinder ibinder)
    {
        try
        {
            a(com.google.android.a.a.a.k.a.a(ibinder), new d());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            return;
        }
    }

    protected abstract String c();

    public void d()
    {
        h();
        g = false;
        ArrayList arraylist = f;
        arraylist;
        JVM INSTR monitorenter ;
        int i1 = f.size();
        int l = 0;
_L2:
        if (l >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        synchronized ((b)f.get(l))
        {
            b1.a = null;
        }
        l++;
        if (true) goto _L2; else goto _L1
        exception1;
        b1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        f.clear();
        arraylist;
        JVM INSTR monitorexit ;
        g();
        return;
    }

    public final void e()
    {
        g = true;
        com.google.android.a.a.b b1 = com.google.android.a.a.a.a(h);
        if (b1 != com.google.android.a.a.b.a)
        {
            a.sendMessage(a.obtainMessage(3, b1));
        } else
        {
            Intent intent = (new Intent(c())).setPackage(com.google.android.a.a.a.z.a(h));
            if (k != null)
            {
                Log.e("YouTubeClient", "Calling connect() while still connected, missing disconnect().");
                g();
            }
            k = new e();
            if (!h.bindService(intent, k, 129))
            {
                a.sendMessage(a.obtainMessage(3, com.google.android.a.a.b.h));
                return;
            }
        }
    }

    public final boolean f()
    {
        return b != null;
    }

    final void g()
    {
        if (k != null)
        {
            try
            {
                h.unbindService(k);
            }
            catch (IllegalArgumentException illegalargumentexception) { }
        }
        b = null;
        k = null;
    }

    protected final void h()
    {
        a.removeMessages(4);
        ArrayList arraylist = c;
        arraylist;
        JVM INSTR monitorenter ;
        ArrayList arraylist1;
        int i1;
        e = true;
        arraylist1 = c;
        i1 = arraylist1.size();
        int l = 0;
_L2:
        if (l >= i1)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        if (g)
        {
            if (c.contains(arraylist1.get(l)))
            {
                ((u.a)arraylist1.get(l)).b();
            }
            break MISSING_BLOCK_LABEL_90;
        }
        e = false;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
        l++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected final void i()
    {
        a.removeMessages(4);
        ArrayList arraylist = i;
        arraylist;
        JVM INSTR monitorenter ;
        ArrayList arraylist1;
        int i1;
        j = true;
        arraylist1 = i;
        i1 = arraylist1.size();
        int l = 0;
_L2:
        if (l >= i1)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        if (g)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        arraylist;
        JVM INSTR monitorexit ;
        return;
        if (i.contains(arraylist1.get(l)))
        {
            ((u.b)arraylist1.get(l)).a();
        }
        break MISSING_BLOCK_LABEL_93;
        j = false;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
        l++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected final void j()
    {
        if (!f())
        {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        } else
        {
            return;
        }
    }

    protected final IInterface k()
    {
        j();
        return b;
    }
}
