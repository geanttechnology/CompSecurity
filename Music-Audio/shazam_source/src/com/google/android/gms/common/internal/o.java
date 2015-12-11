// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.internal:
//            n, w, v

final class o extends n
    implements android.os.Handler.Callback
{
    private static final class a
    {

        private final String a;
        private final ComponentName b = null;

        public final Intent a()
        {
            if (a != null)
            {
                return (new Intent(a)).setPackage("com.google.android.gms");
            } else
            {
                return (new Intent()).setComponent(b);
            }
        }

        public final boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof a))
                {
                    return false;
                }
                obj = (a)obj;
                if (!v.a(a, ((a) (obj)).a) || !v.a(b, ((a) (obj)).b))
                {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode()
        {
            return Arrays.hashCode(new Object[] {
                a, b
            });
        }

        public final String toString()
        {
            if (a == null)
            {
                return b.flattenToString();
            } else
            {
                return a;
            }
        }

        public a(String s)
        {
            a = w.a(s);
        }
    }

    private final class b
    {

        final a a = new a(this);
        final Set b = new HashSet();
        int c;
        boolean d;
        IBinder e;
        final a f;
        ComponentName g;
        final o h;

        public final void a(ServiceConnection serviceconnection, String s)
        {
            o.c(h).a(com.google.android.gms.common.internal.o.b(h), serviceconnection, s, f.a(), 3);
            b.add(serviceconnection);
        }

        public final void a(String s)
        {
            d = o.c(h).a(com.google.android.gms.common.internal.o.b(h), s, f.a(), a, 129);
            if (d)
            {
                c = 3;
                return;
            }
            try
            {
                o.c(h).a(com.google.android.gms.common.internal.o.b(h), a);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return;
            }
        }

        public final boolean a()
        {
            return b.isEmpty();
        }

        public final boolean a(ServiceConnection serviceconnection)
        {
            return b.contains(serviceconnection);
        }

        public b(a a1)
        {
            h = o.this;
            super();
            f = a1;
            c = 2;
        }
    }

    public final class b.a
        implements ServiceConnection
    {

        final b a;

        public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            HashMap hashmap = o.a(a.h);
            hashmap;
            JVM INSTR monitorenter ;
            a.e = ibinder;
            a.g = componentname;
            for (Iterator iterator = a.b.iterator(); iterator.hasNext(); ((ServiceConnection)iterator.next()).onServiceConnected(componentname, ibinder)) { }
            break MISSING_BLOCK_LABEL_78;
            componentname;
            hashmap;
            JVM INSTR monitorexit ;
            throw componentname;
            a.c = 1;
            hashmap;
            JVM INSTR monitorexit ;
        }

        public final void onServiceDisconnected(ComponentName componentname)
        {
            HashMap hashmap = o.a(a.h);
            hashmap;
            JVM INSTR monitorenter ;
            a.e = null;
            a.g = componentname;
            for (Iterator iterator = a.b.iterator(); iterator.hasNext(); ((ServiceConnection)iterator.next()).onServiceDisconnected(componentname)) { }
            break MISSING_BLOCK_LABEL_74;
            componentname;
            hashmap;
            JVM INSTR monitorexit ;
            throw componentname;
            a.c = 2;
            hashmap;
            JVM INSTR monitorexit ;
        }

        public b.a(b b1)
        {
            a = b1;
            super();
        }
    }


    private final HashMap a = new HashMap();
    private final Context b;
    private final Handler c;
    private final com.google.android.gms.common.stats.b d = com.google.android.gms.common.stats.b.a();
    private final long e = 5000L;

    o(Context context)
    {
        b = context.getApplicationContext();
        c = new Handler(context.getMainLooper(), this);
    }

    static HashMap a(o o1)
    {
        return o1.a;
    }

    private boolean a(a a1, ServiceConnection serviceconnection, String s)
    {
        w.a(serviceconnection, "ServiceConnection must not be null");
        HashMap hashmap = a;
        hashmap;
        JVM INSTR monitorenter ;
        b b1 = (b)a.get(a1);
        if (b1 != null) goto _L2; else goto _L1
_L1:
        b1 = new b(a1);
        b1.a(serviceconnection, s);
        b1.a(s);
        a.put(a1, b1);
        a1 = b1;
_L7:
        boolean flag = ((b) (a1)).d;
        hashmap;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        c.removeMessages(0, b1);
        if (b1.a(serviceconnection))
        {
            throw new IllegalStateException((new StringBuilder("Trying to bind a GmsServiceConnection that was already connected before.  config=")).append(a1).toString());
        }
        break MISSING_BLOCK_LABEL_133;
        a1;
        hashmap;
        JVM INSTR monitorexit ;
        throw a1;
        b1.a(serviceconnection, s);
        b1.c;
        JVM INSTR tableswitch 1 2: default 202
    //                   1 168
    //                   2 190;
           goto _L3 _L4 _L5
_L4:
        serviceconnection.onServiceConnected(b1.g, b1.e);
        a1 = b1;
        continue; /* Loop/switch isn't completed */
_L5:
        b1.a(s);
        a1 = b1;
        continue; /* Loop/switch isn't completed */
_L3:
        a1 = b1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static Context b(o o1)
    {
        return o1.b;
    }

    static com.google.android.gms.common.stats.b c(o o1)
    {
        return o1.d;
    }

    public final void a(String s, ServiceConnection serviceconnection)
    {
        a a1;
        a1 = new a(s);
        w.a(serviceconnection, "ServiceConnection must not be null");
        s = a;
        s;
        JVM INSTR monitorenter ;
        b b1 = (b)a.get(a1);
        if (b1 != null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        throw new IllegalStateException((new StringBuilder("Nonexistent connection status for service config: ")).append(a1).toString());
        serviceconnection;
        s;
        JVM INSTR monitorexit ;
        throw serviceconnection;
        if (!b1.a(serviceconnection))
        {
            throw new IllegalStateException((new StringBuilder("Trying to unbind a GmsServiceConnection  that was not bound before.  config=")).append(a1).toString());
        }
        b1.h.d.a(b1.h.b, serviceconnection, null, null, 4);
        b1.b.remove(serviceconnection);
        if (b1.a())
        {
            serviceconnection = c.obtainMessage(0, b1);
            c.sendMessageDelayed(serviceconnection, e);
        }
        s;
        JVM INSTR monitorexit ;
    }

    public final boolean a(String s, ServiceConnection serviceconnection, String s1)
    {
        return a(new a(s), serviceconnection, s1);
    }

    public final boolean handleMessage(Message message)
    {
        b b1;
        switch (message.what)
        {
        default:
            return false;

        case 0: // '\0'
            b1 = (b)message.obj;
            break;
        }
        synchronized (a)
        {
            if (b1.a())
            {
                if (b1.d)
                {
                    b1.h.d.a(b1.h.b, b1.a);
                    b1.d = false;
                    b1.c = 2;
                }
                a.remove(b1.f);
            }
        }
        return true;
        exception;
        message;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
