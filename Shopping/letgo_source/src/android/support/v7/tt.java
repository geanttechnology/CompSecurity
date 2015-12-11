// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            lr, vg, ud, ve, 
//            tv, yj, vw, xs, 
//            ua, lq, lo

public class tt
{
    public static interface a
    {

        public abstract Object b();

        public abstract Object b(InputStream inputstream);
    }

    private static class b extends ve
    {

        private final a a;
        private final vw.b b;

        protected vw a(tv tv1)
        {
            return vw.a(new ByteArrayInputStream(tv1.b), yj.a(tv1));
        }

        protected void a(InputStream inputstream)
        {
            b.a(a.b(inputstream));
        }

        protected void a(Object obj)
        {
            a((InputStream)obj);
        }

        public b(String s, a a1, vw.b b1)
        {
            super(0, s, new _cls1(b1, a1));
            a = a1;
            b = b1;
        }
    }

    private class c extends ua
        implements vw.b
    {

        final tt a;

        public void a(Object obj)
        {
            super.b(obj);
        }

        private c()
        {
            a = tt.this;
            super();
        }

    }


    public static final a a = new a() {

        public Void a()
        {
            return null;
        }

        public Void a(InputStream inputstream)
        {
            return null;
        }

        public Object b()
        {
            return a();
        }

        public Object b(InputStream inputstream)
        {
            return a(inputstream);
        }

    };
    private static vg b;
    private static final Object c = new Object();

    public tt(Context context)
    {
        b = a(context);
    }

    private static vg a(Context context)
    {
        synchronized (c)
        {
            if (b == null)
            {
                b = lr.a(context.getApplicationContext());
            }
            context = b;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public ud a(String s, a a1)
    {
        c c1 = new c();
        b.a(new b(s, a1, c1));
        return c1;
    }

    public ud a(String s, Map map)
    {
        c c1 = new c();
        s = new lq(s, c1, new vw.a(s, c1) {

            final String a;
            final c b;
            final tt c;

            public void a(xs xs1)
            {
                zzb.zzaE((new StringBuilder()).append("Failed to load URL: ").append(a).append("\n").append(xs1.toString()).toString());
                b.a(null);
            }

            
            {
                c = tt.this;
                a = s;
                b = c1;
                super();
            }
        }, map) {

            final Map a;
            final tt b;

            public Map a()
                throws lo
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
                b = tt.this;
                a = map;
                super(s, b1, a1);
            }
        };
        b.a(s);
        return c1;
    }


    // Unreferenced inner class android/support/v7/tt$b$1

/* anonymous class */
    class b._cls1
        implements vw.a
    {

        final vw.b a;
        final a b;

        public void a(xs xs)
        {
            a.a(b.b());
        }

            
            {
                a = b1;
                b = a1;
                super();
            }
    }

}
