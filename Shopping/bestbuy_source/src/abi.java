// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.internal.gs;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class abi
    implements vm
{

    public static final String a;
    private static final abi c;
    public final String b = abq.e();
    private final Object d = new Object();
    private final abj e;
    private aef f;
    private BigInteger g;
    private final HashSet h = new HashSet();
    private final HashMap i = new HashMap();
    private boolean j;
    private boolean k;
    private boolean l;
    private Context m;
    private gs n;
    private boolean o;
    private sx p;
    private sy q;
    private sw r;
    private LinkedList s;
    private boolean t;
    private Bundle u;
    private ze v;
    private String w;

    private abi()
    {
        g = BigInteger.ONE;
        j = false;
        k = true;
        l = false;
        o = true;
        p = null;
        q = null;
        r = null;
        s = new LinkedList();
        t = false;
        u = ug.a();
        v = null;
        e = new abj(b);
    }

    public static abi a()
    {
        return c;
    }

    public static Bundle a(Context context, abk abk1, String s1)
    {
        return c.b(context, abk1, s1);
    }

    public static String a(int i1, String s1)
    {
        return c.b(i1, s1);
    }

    public static void a(Context context, gs gs1)
    {
        c.b(context, gs1);
    }

    public static void a(Context context, boolean flag)
    {
        c.b(context, flag);
    }

    public static void a(Throwable throwable)
    {
        c.b(throwable);
    }

    public static void a(HashSet hashset)
    {
        c.b(hashset);
    }

    public static String d()
    {
        return c.e();
    }

    public static abj f()
    {
        return c.g();
    }

    public static boolean h()
    {
        return c.i();
    }

    public static boolean j()
    {
        return c.k();
    }

    public static String l()
    {
        return c.m();
    }

    public static Bundle n()
    {
        return c.o();
    }

    public sy a(Context context)
    {
        if (!n().getBoolean(ug.i.a(), false) || !aej.c() || c())
        {
            return null;
        }
        synchronized (d)
        {
            if (p != null)
            {
                break MISSING_BLOCK_LABEL_83;
            }
            if (context instanceof Activity)
            {
                break MISSING_BLOCK_LABEL_61;
            }
        }
        return null;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        p = new sx((Application)context.getApplicationContext(), (Activity)context);
        if (r == null)
        {
            r = new sw();
        }
        if (q == null)
        {
            q = new sy(p, r, u, new ze(m, n, null, null));
        }
        q.a();
        context = q;
        obj;
        JVM INSTR monitorexit ;
        return context;
    }

    public void a(abf abf1)
    {
        synchronized (d)
        {
            h.add(abf1);
        }
        return;
        abf1;
        obj;
        JVM INSTR monitorexit ;
        throw abf1;
    }

    public void a(Bundle bundle)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        t = true;
        u = bundle;
        for (; !s.isEmpty(); ze.a(m, (Thread)s.remove(0), n)) { }
        break MISSING_BLOCK_LABEL_58;
        bundle;
        obj;
        JVM INSTR monitorexit ;
        throw bundle;
        obj;
        JVM INSTR monitorexit ;
    }

    public void a(String s1, abl abl1)
    {
        synchronized (d)
        {
            i.put(s1, abl1);
        }
        return;
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public void a(Thread thread)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        if (!t)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        ze.a(m, thread, n);
_L2:
        return;
        s.add(thread);
        if (true) goto _L2; else goto _L1
_L1:
        thread;
        obj;
        JVM INSTR monitorexit ;
        throw thread;
    }

    public void a(boolean flag)
    {
        synchronized (d)
        {
            o = flag;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public aef b()
    {
        aef aef;
        synchronized (d)
        {
            aef = f;
        }
        return aef;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Bundle b(Context context, abk abk1, String s1)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        Bundle bundle;
        bundle = new Bundle();
        bundle.putBundle("app", e.a(context, s1));
        context = new Bundle();
        String s2;
        for (s1 = i.keySet().iterator(); s1.hasNext(); context.putBundle(s2, ((abl)i.get(s2)).a()))
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
        for (s1 = h.iterator(); s1.hasNext(); context.add(((abf)s1.next()).d())) { }
        bundle.putParcelableArrayList("ads", context);
        abk1.a(h);
        h.clear();
        obj;
        JVM INSTR monitorexit ;
        return bundle;
    }

    public String b(int i1, String s1)
    {
        Resources resources;
        if (n.e)
        {
            resources = m.getResources();
        } else
        {
            resources = pu.c(m);
        }
        if (resources == null)
        {
            return s1;
        } else
        {
            return resources.getString(i1);
        }
    }

    public void b(Context context, gs gs1)
    {
        synchronized (d)
        {
            if (!l)
            {
                m = context.getApplicationContext();
                n = gs1;
                k = abo.a(context);
                aco.a(context);
                vk.a(context, this);
                a(Thread.currentThread());
                w = abq.a(context, gs1.b);
                f = new aeg();
                l = true;
            }
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void b(Context context, boolean flag)
    {
        synchronized (d)
        {
            if (flag != k)
            {
                k = flag;
                abo.a(context, flag);
            }
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void b(Throwable throwable)
    {
        if (l)
        {
            (new ze(m, n, null, null)).b(throwable);
        }
    }

    public void b(HashSet hashset)
    {
        synchronized (d)
        {
            h.addAll(hashset);
        }
        return;
        hashset;
        obj;
        JVM INSTR monitorexit ;
        throw hashset;
    }

    public boolean c()
    {
        boolean flag;
        synchronized (d)
        {
            flag = o;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String e()
    {
        String s1;
        synchronized (d)
        {
            s1 = g.toString();
            g = g.add(BigInteger.ONE);
        }
        return s1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public abj g()
    {
        abj abj1;
        synchronized (d)
        {
            abj1 = e;
        }
        return abj1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean i()
    {
        boolean flag;
        synchronized (d)
        {
            flag = j;
            j = true;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean k()
    {
        boolean flag;
        synchronized (d)
        {
            flag = k;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String m()
    {
        String s1;
        synchronized (d)
        {
            s1 = w;
        }
        return s1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Bundle o()
    {
        Bundle bundle;
        synchronized (d)
        {
            bundle = u;
        }
        return bundle;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        c = new abi();
        a = c.b;
    }
}
