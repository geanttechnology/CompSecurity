// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.e.b;
import com.google.android.gms.e.d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.d:
//            jw, jv

public class jx
{
    public static interface a
    {

        public abstract void b();
    }


    private static jx e;
    public jw a;
    public final Set b = new HashSet();
    public d c;
    public boolean d;
    private Context f;

    private jx(Context context, d d1)
    {
        c = null;
        f = context;
        c = d1;
    }

    static Context a(jx jx1)
    {
        return jx1.f;
    }

    static jw a(jx jx1, jw jw)
    {
        jx1.a = jw;
        return jw;
    }

    public static jx a(Context context)
    {
        w.a(context);
        if (e != null) goto _L2; else goto _L1
_L1:
        com/google/android/gms/d/jx;
        JVM INSTR monitorenter ;
        if (e == null)
        {
            e = new jx(context, com.google.android.gms.e.d.a(context.getApplicationContext()));
        }
        com/google/android/gms/d/jx;
        JVM INSTR monitorexit ;
_L2:
        return e;
        context;
        com/google/android/gms/d/jx;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void b(jx jx1)
    {
        jx1;
        JVM INSTR monitorenter ;
        for (Iterator iterator = jx1.b.iterator(); iterator.hasNext(); ((a)iterator.next()).b()) { }
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        jx1;
        JVM INSTR monitorexit ;
        throw exception;
        jx1;
        JVM INSTR monitorexit ;
    }

    public final jw a()
    {
        this;
        JVM INSTR monitorenter ;
        jw jw = a;
        this;
        JVM INSTR monitorexit ;
        return jw;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    // Unreferenced inner class com/google/android/gms/d/jx$1

/* anonymous class */
    public final class _cls1
        implements h
    {

        final jx a;

        public final void a(g g)
        {
            g = (b)g;
            if (g.a().b())
            {
                g = g.c();
            } else
            {
                g = null;
            }
            g = new jv(jx.a(a), g, a.a());
            jx.a(a, ((jv) (g)).a);
            com.google.android.gms.d.jx.b(a);
        }

            public 
            {
                a = jx.this;
                super();
            }
    }

}
