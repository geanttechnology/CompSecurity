// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Future;

// Referenced classes of package com.google.android.gms.d:
//            gm, ge, gg, gc, 
//            gf, ay, ax, io, 
//            aj, ai, ak, fk, 
//            gi, gl, x, ct, 
//            az, bb

public final class gd
    implements gk.b
{

    public final Object a = new Object();
    public final String b = gm.a();
    public x c;
    public final HashSet d = new HashSet();
    public final HashMap e = new HashMap();
    public boolean f;
    Boolean g;
    public boolean h;
    private final ge i;
    private BigInteger j;
    private boolean k;
    private boolean l;
    private int m;
    private boolean n;
    private Context o;
    private VersionInfoParcel p;
    private bb q;
    private aj r;
    private ak s;
    private ai t;
    private final LinkedList u = new LinkedList();
    private final fk v = null;
    private String w;

    public gd()
    {
        j = BigInteger.ONE;
        k = false;
        l = true;
        m = 0;
        n = false;
        q = null;
        f = true;
        r = null;
        s = null;
        t = null;
        g = null;
        h = false;
        i = new ge(b);
    }

    private boolean j()
    {
        boolean flag;
        synchronized (a)
        {
            flag = f;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Bundle a(Context context, gf gf1, String s1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        Bundle bundle;
        bundle = new Bundle();
        bundle.putBundle("app", i.a(context, s1));
        context = new Bundle();
        String s2;
        for (s1 = e.keySet().iterator(); s1.hasNext(); context.putBundle(s2, ((gg)e.get(s2)).a()))
        {
            s2 = (String)s1.next();
        }

        break MISSING_BLOCK_LABEL_105;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        bundle.putBundle("slots", context);
        context = new ArrayList();
        for (s1 = d.iterator(); s1.hasNext(); context.add(((gc)s1.next()).a())) { }
        bundle.putParcelableArrayList("ads", context);
        gf1.a(d);
        d.clear();
        obj;
        JVM INSTR monitorexit ;
        return bundle;
    }

    public final ak a(Context context)
    {
label0:
        {
            au au = ay.J;
            if (!((Boolean)com.google.android.gms.ads.internal.p.n().a(au)).booleanValue() || !io.a(14) || j())
            {
                return null;
            }
            synchronized (a)
            {
                if (r != null)
                {
                    break MISSING_BLOCK_LABEL_84;
                }
                if (context instanceof Activity)
                {
                    break label0;
                }
            }
            return null;
        }
        r = new aj((Application)context.getApplicationContext(), (Activity)context);
        if (t == null)
        {
            t = new ai();
        }
        if (s == null)
        {
            s = new ak(r, t, new fk(o, p, null, null));
        }
        s.a();
        context = s;
        obj;
        JVM INSTR monitorexit ;
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public final String a()
    {
        String s1;
        synchronized (a)
        {
            s1 = j.toString();
            j = j.add(BigInteger.ONE);
        }
        return s1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final String a(int i1, String s1)
    {
        Resources resources;
        if (p.e)
        {
            resources = o.getResources();
        } else
        {
            resources = GooglePlayServicesUtil.getRemoteResource(o);
        }
        if (resources == null)
        {
            return s1;
        } else
        {
            return resources.getString(i1);
        }
    }

    public final Future a(Context context, boolean flag)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (flag == l)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        l = flag;
        context = gl.a(((gi) (new gk._cls1(context, flag))).i);
        return context;
        obj;
        JVM INSTR monitorexit ;
        return null;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public final void a(Context context, VersionInfoParcel versioninfoparcel)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (n) goto _L2; else goto _L1
_L1:
        o = context.getApplicationContext();
        p = versioninfoparcel;
        gl.a(((gi) (new gk._cls2(context, this))).i);
        gl.a(((gi) (new gk._cls4(context, this))).i);
        Object obj1 = Thread.currentThread();
        fk.a(o, ((Thread) (obj1)), p);
        w = com.google.android.gms.ads.internal.p.e().a(context, versioninfoparcel.b);
        versioninfoparcel = context.getApplicationContext();
        obj1 = p;
        context = context.getApplicationContext();
        VersionInfoParcel versioninfoparcel1 = p;
        au au = com.google.android.gms.d.ay.b;
        c = new x(versioninfoparcel, ((VersionInfoParcel) (obj1)), new ct(context, versioninfoparcel1, (String)com.google.android.gms.ads.internal.p.n().a(au)));
        context = new az(o, p.b);
        com.google.android.gms.ads.internal.p.j();
        if (((az) (context)).a) goto _L4; else goto _L3
_L3:
        com.google.android.gms.ads.internal.util.client.b.a(2);
        context = null;
_L6:
        q = context;
_L5:
        versioninfoparcel = com.google.android.gms.ads.internal.p.o();
        context = o;
        versioninfoparcel = new com.google.android.gms.ads.internal.purchase.i._cls1(versioninfoparcel, context);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        context.bindService(intent, versioninfoparcel, 1);
        n = true;
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
_L4:
        try
        {
            if (((az) (context)).d == null)
            {
                throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
            }
            break MISSING_BLOCK_LABEL_286;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        finally { }
        com.google.android.gms.ads.internal.util.client.b.a(5);
          goto _L5
        obj;
        JVM INSTR monitorexit ;
        throw context;
        if (TextUtils.isEmpty(((az) (context)).e))
        {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        context = new bb(((az) (context)).d, ((az) (context)).e, ((az) (context)).b, ((az) (context)).c);
          goto _L6
    }

    public final void a(Bundle bundle)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (!bundle.containsKey("use_https")) goto _L2; else goto _L1
_L1:
        boolean flag = bundle.getBoolean("use_https");
_L5:
        l = flag;
        if (!bundle.containsKey("webview_cache_version")) goto _L4; else goto _L3
_L3:
        int i1 = bundle.getInt("webview_cache_version");
_L6:
        m = i1;
        return;
_L2:
        flag = l;
          goto _L5
_L4:
        i1 = m;
          goto _L6
        bundle;
        obj;
        JVM INSTR monitorexit ;
        throw bundle;
          goto _L5
    }

    public final void a(gc gc1)
    {
        synchronized (a)
        {
            d.add(gc1);
        }
        return;
        gc1;
        obj;
        JVM INSTR monitorexit ;
        throw gc1;
    }

    public final void a(Throwable throwable, boolean flag)
    {
        (new fk(o, p, null, null)).a(throwable, flag);
    }

    public final ge b()
    {
        ge ge1;
        synchronized (a)
        {
            ge1 = i;
        }
        return ge1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final bb c()
    {
        bb bb1;
        synchronized (a)
        {
            bb1 = q;
        }
        return bb1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean d()
    {
        boolean flag;
        synchronized (a)
        {
            flag = k;
            k = true;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean e()
    {
        boolean flag;
        synchronized (a)
        {
            flag = l;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final String f()
    {
        String s1;
        synchronized (a)
        {
            s1 = w;
        }
        return s1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Boolean g()
    {
        Boolean boolean1;
        synchronized (a)
        {
            boolean1 = g;
        }
        return boolean1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean h()
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        int i1 = m;
        au au = ay.X;
        if (i1 >= ((Integer)com.google.android.gms.ads.internal.p.n().a(au)).intValue())
        {
            break MISSING_BLOCK_LABEL_80;
        }
        au = ay.X;
        m = ((Integer)com.google.android.gms.ads.internal.p.n().a(au)).intValue();
        gl.a(((gi) (new gk._cls3(o, m))).i);
        return true;
        obj;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean i()
    {
        boolean flag;
        synchronized (a)
        {
            flag = h;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
