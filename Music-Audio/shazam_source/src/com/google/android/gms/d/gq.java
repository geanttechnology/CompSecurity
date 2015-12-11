// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            d, hz, hx, gs, 
//            ll, is, kq, gx, 
//            c

public final class gq
{
    public static interface a
    {

        public abstract Object a();

        public abstract Object a(InputStream inputstream);
    }

    private static final class b extends hx
    {

        private final a a;
        private final is.b b;

        protected final is a(gs gs1)
        {
            return is.a(new ByteArrayInputStream(gs1.b), ll.a(gs1));
        }

        protected final void a(Object obj)
        {
            obj = (InputStream)obj;
            b.a(a.a(((InputStream) (obj))));
        }

        public b(String s, a a1, is.b b1)
        {
            super(s, new _cls1(b1, a1));
            a = a1;
            b = b1;
        }
    }

    private final class c extends gx
        implements is.b
    {

        final gq a;

        public final void a(Object obj)
        {
            super.b(obj);
        }

        private c()
        {
            a = gq.this;
            super();
        }

        c(byte byte0)
        {
            this();
        }
    }


    static hz a;
    public static final a b = new a() {

        public final Object a()
        {
            return null;
        }

        public final Object a(InputStream inputstream)
        {
            return null;
        }

    };
    private static final Object c = new Object();

    public gq(Context context)
    {
        a = a(context);
    }

    private static hz a(Context context)
    {
        synchronized (c)
        {
            if (a == null)
            {
                a = d.a(context.getApplicationContext());
            }
            context = a;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }


    // Unreferenced inner class com/google/android/gms/d/gq$2

/* anonymous class */
    final class _cls2
        implements is.a
    {

        final String a;
        final c b;
        final gq c;

        public final void a(kq kq1)
        {
            (new StringBuilder("Failed to load URL: ")).append(a).append("\n").append(kq1.toString());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            b.a(null);
        }

            
            {
                c = gq.this;
                a = s;
                b = c1;
                super();
            }
    }


    // Unreferenced inner class com/google/android/gms/d/gq$3

/* anonymous class */
    final class _cls3 extends com.google.android.gms.d.c
    {

        final Map a;
        final gq b;

        public final Map a()
        {
            if (a == null)
            {
                return super.a();
            } else
            {
                return a;
            }
        }

            
            {
                b = gq.this;
                a = map;
                super(s, b1, a1, (byte)0);
            }
    }


    // Unreferenced inner class com/google/android/gms/d/gq$b$1

/* anonymous class */
    final class b._cls1
        implements is.a
    {

        final is.b a;
        final a b;

        public final void a(kq kq)
        {
            a.a(b.a());
        }

            
            {
                a = b1;
                b = a1;
                super();
            }
    }

}
