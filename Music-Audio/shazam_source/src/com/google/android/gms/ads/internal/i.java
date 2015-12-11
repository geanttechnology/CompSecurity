// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.p;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.d.bs;
import com.google.android.gms.d.bt;
import com.google.android.gms.d.dg;
import com.google.android.gms.d.gm;
import com.google.android.gms.d.id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal:
//            n

public final class i extends com.google.android.gms.ads.internal.client.q.a
{

    final Context a;
    final dg b;
    final String c;
    final VersionInfoParcel d;
    private final p e;
    private final bs f;
    private final bt g;
    private final id h;
    private final id i;
    private final NativeAdOptionsParcel j;
    private final List k = c();
    private WeakReference l;
    private Object m;

    i(Context context, String s, dg dg, VersionInfoParcel versioninfoparcel, p p, bs bs, bt bt, 
            id id1, id id2, NativeAdOptionsParcel nativeadoptionsparcel)
    {
        m = new Object();
        a = context;
        c = s;
        b = dg;
        d = versioninfoparcel;
        e = p;
        g = bt;
        f = bs;
        h = id1;
        i = id2;
        j = nativeadoptionsparcel;
    }

    static Object a(i i1)
    {
        return i1.m;
    }

    static WeakReference a(i i1, WeakReference weakreference)
    {
        i1.l = weakreference;
        return weakreference;
    }

    static bs b(i i1)
    {
        return i1.f;
    }

    static bt c(i i1)
    {
        return i1.g;
    }

    private List c()
    {
        ArrayList arraylist = new ArrayList();
        if (g != null)
        {
            arraylist.add("1");
        }
        if (f != null)
        {
            arraylist.add("2");
        }
        if (h.size() > 0)
        {
            arraylist.add("3");
        }
        return arraylist;
    }

    static id d(i i1)
    {
        return i1.h;
    }

    static p e(i i1)
    {
        return i1.e;
    }

    static id f(i i1)
    {
        return i1.i;
    }

    static List g(i i1)
    {
        return i1.c();
    }

    static NativeAdOptionsParcel h(i i1)
    {
        return i1.j;
    }

    public final String a()
    {
        Object obj1 = m;
        obj1;
        JVM INSTR monitorenter ;
        if (l == null) goto _L2; else goto _L1
_L1:
        Object obj = (n)l.get();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        obj = ((n) (obj)).j();
_L3:
        obj1;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L2:
        obj1;
        JVM INSTR monitorexit ;
        return null;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        obj = null;
          goto _L3
    }

    public final void a(AdRequestParcel adrequestparcel)
    {
        adrequestparcel = new Runnable(adrequestparcel) {

            final AdRequestParcel a;
            final i b;

            public final void run()
            {
                synchronized (i.a(b))
                {
                    Object obj1 = b;
                    obj1 = new n(((i) (obj1)).a, AdSizeParcel.a(), ((i) (obj1)).c, ((i) (obj1)).b, ((i) (obj1)).d);
                    i.a(b, new WeakReference(obj1));
                    ((n) (obj1)).a(i.b(b));
                    ((n) (obj1)).a(i.c(b));
                    ((n) (obj1)).a(i.d(b));
                    ((n) (obj1)).a(i.e(b));
                    ((n) (obj1)).b(i.f(b));
                    ((n) (obj1)).a(i.g(b));
                    ((n) (obj1)).a(i.h(b));
                    ((n) (obj1)).a(a);
                }
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = i.this;
                a = adrequestparcel;
                super();
            }
        };
        gm.a.post(adrequestparcel);
    }

    public final boolean b()
    {
        Object obj = m;
        obj;
        JVM INSTR monitorenter ;
        if (l == null) goto _L2; else goto _L1
_L1:
        n n1 = (n)l.get();
        if (n1 == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        boolean flag = n1.k();
_L3:
        obj;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        obj;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        flag = false;
          goto _L3
    }
}
