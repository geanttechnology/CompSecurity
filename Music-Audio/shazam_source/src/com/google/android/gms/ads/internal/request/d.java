// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ar;
import com.google.android.gms.d.as;
import com.google.android.gms.d.ax;
import com.google.android.gms.d.ay;
import com.google.android.gms.d.cv;
import com.google.android.gms.d.eg;
import com.google.android.gms.d.fm;
import com.google.android.gms.d.fn;
import com.google.android.gms.d.fv;
import com.google.android.gms.d.fy;
import com.google.android.gms.d.fz;
import com.google.android.gms.d.gd;
import com.google.android.gms.d.gi;
import com.google.android.gms.d.gl;
import com.google.android.gms.d.gm;
import com.google.android.gms.d.gr;
import com.google.android.gms.d.ii;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            g, j, AdResponseParcel, AdRequestInfoParcel, 
//            e

public abstract class d extends gi
    implements c.a
{
    public static final class a extends d
    {

        private final Context a;

        public final void c()
        {
        }

        public final j d()
        {
            Object obj = ay.b;
            obj = new ar((String)p.n().a(((com.google.android.gms.d.au) (obj))));
            return fn.a(a, ((ar) (obj)), new fm(new fy(), new as(), new cv(), new eg(), new fz(), new fv()));
        }

        public a(Context context, AdRequestInfoParcel adrequestinfoparcel, c.a a1)
        {
            super(adrequestinfoparcel, a1);
            a = context;
        }
    }

    public static final class b extends d
        implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.c
    {

        protected e a;
        private Context b;
        private AdRequestInfoParcel c;
        private final c.a d;
        private final Object e = new Object();
        private boolean f;

        public final void a(int i)
        {
            com.google.android.gms.ads.internal.util.client.b.a(3);
        }

        public final void a(Bundle bundle)
        {
            gl.a(super.i);
        }

        public final void a(ConnectionResult connectionresult)
        {
            com.google.android.gms.ads.internal.util.client.b.a(3);
            gl.a(((gi) (new a(b, c, d))).i);
            connectionresult = new Bundle();
            connectionresult.putString("action", "gms_connection_failed_fallback_to_local");
            p.e();
            gm.b(b, c.k.b, "gmob-apps", connectionresult, true);
        }

        public final void c()
        {
            boolean flag = false;
            Object obj = e;
            obj;
            JVM INSTR monitorenter ;
            gr gr1;
            if (a.e() || a.j())
            {
                a.d();
            }
            Binder.flushPendingCommands();
            if (!f)
            {
                break MISSING_BLOCK_LABEL_119;
            }
            gr1 = p.p();
            Object obj1 = gr1.c;
            obj1;
            JVM INSTR monitorenter ;
            if (gr1.b > 0)
            {
                flag = true;
            }
            int i;
            w.b(flag, "Invalid state: release() called more times than expected.");
            i = gr1.b - 1;
            gr1.b = i;
            if (i != 0)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            com.google.android.gms.ads.internal.util.client.b.a(2);
            gr1.a.quit();
            gr1.a = null;
            obj1;
            JVM INSTR monitorexit ;
            f = false;
            obj;
            JVM INSTR monitorexit ;
            return;
            Exception exception1;
            exception1;
            obj1;
            JVM INSTR monitorexit ;
            throw exception1;
            Exception exception;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final j d()
        {
            obj;
            JVM INSTR monitorenter ;
            j j1;
            synchronized (e)
            {
                j1 = a.c();
            }
            return j1;
_L2:
            obj;
            JVM INSTR monitorexit ;
            return null;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
            Object obj1;
            obj1;
            continue; /* Loop/switch isn't completed */
            obj1;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public b(Context context, AdRequestInfoParcel adrequestinfoparcel, c.a a1)
        {
            super(adrequestinfoparcel, a1);
            b = context;
            c = adrequestinfoparcel;
            d = a1;
            a1 = ay.A;
            if (((Boolean)p.n().a(a1)).booleanValue())
            {
                f = true;
                a1 = p.p().a();
            } else
            {
                a1 = context.getMainLooper();
            }
            a = new e(context, a1, this, this, adrequestinfoparcel.k.d);
            a.i();
        }
    }


    private final AdRequestInfoParcel a;
    private final c.a b;
    private final Object c = new Object();
    private AdResponseParcel d;

    public d(AdRequestInfoParcel adrequestinfoparcel, c.a a1)
    {
        a = adrequestinfoparcel;
        b = a1;
    }

    private boolean a(long l)
    {
        l = 60000L - (p.i().b() - l);
        if (l <= 0L)
        {
            return false;
        }
        try
        {
            c.wait(l);
        }
        catch (InterruptedException interruptedexception)
        {
            return false;
        }
        return true;
    }

    private boolean a(j j1, AdRequestInfoParcel adrequestinfoparcel)
    {
        j1.a(adrequestinfoparcel, new g(this));
        return true;
        j1;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        p.h().a(j1, true);
_L2:
        b.a(new AdResponseParcel(0));
        return false;
        j1;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        p.h().a(j1, true);
        continue; /* Loop/switch isn't completed */
        j1;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        p.h().a(j1, true);
        continue; /* Loop/switch isn't completed */
        j1;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        p.h().a(j1, true);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void a()
    {
        Object obj = d();
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = new AdResponseParcel(0);
        b.a(((AdResponseParcel) (obj)));
_L4:
        c();
        return;
_L2:
        if (!a(((j) (obj)), a)) goto _L4; else goto _L3
_L3:
        long l = p.i().b();
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        JVM INSTR monitorenter ;
_L6:
        synchronized (c)
        {
            if (d == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            b.a(d);
        }
          goto _L4
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
        obj1;
        c();
        throw obj1;
        if (a(l)) goto _L6; else goto _L7
_L7:
        if (d == null) goto _L9; else goto _L8
_L8:
        b.a(d);
_L10:
        obj1;
        JVM INSTR monitorexit ;
          goto _L4
_L9:
        b.a(new AdResponseParcel(0));
          goto _L10
    }

    public final void a(AdResponseParcel adresponseparcel)
    {
        synchronized (c)
        {
            d = adresponseparcel;
            c.notify();
        }
        return;
        adresponseparcel;
        obj;
        JVM INSTR monitorexit ;
        throw adresponseparcel;
    }

    public final void b()
    {
        c();
    }

    public abstract void c();

    public abstract j d();
}
