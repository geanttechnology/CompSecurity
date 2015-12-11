// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.c.p;
import com.mopub.common.c.a;
import java.util.EnumSet;
import java.util.Iterator;

// Referenced classes of package com.mopub.common:
//            m, n, p

public final class o
{
    public static final class a
    {

        public c a;
        public b b;
        public boolean c;
        private EnumSet d;

        public final transient a a(n n1, n an[])
        {
            d = EnumSet.of(n1, an);
            return this;
        }

        public final a a(EnumSet enumset)
        {
            d = EnumSet.copyOf(enumset);
            return this;
        }

        public final o a()
        {
            return new o(d, a, b, c, (byte)0);
        }

        public a()
        {
            d = EnumSet.of(n.j);
            a = com.mopub.common.o.a();
            b = o.b();
            c = false;
        }
    }

    public static interface b
    {

        public abstract void a();

        public abstract void b();
    }

    public static interface c
    {

        public abstract void a(String s, n n1);
    }


    private static final c c = new c() {

        public final void a(String s, n n1)
        {
        }

    };
    private static final b d = new b() {

        public final void a()
        {
        }

        public final void b()
        {
        }

    };
    b a;
    boolean b;
    private EnumSet e;
    private c f;
    private boolean g;
    private boolean h;

    private o(EnumSet enumset, c c1, b b1, boolean flag)
    {
        e = EnumSet.copyOf(enumset);
        f = c1;
        a = b1;
        b = flag;
        g = false;
        h = false;
    }

    o(EnumSet enumset, c c1, b b1, boolean flag, byte byte0)
    {
        this(enumset, c1, b1, flag);
    }

    static c a()
    {
        return c;
    }

    private static void a(n n1, String s, Throwable throwable)
    {
        com.mopub.common.m.a(s);
        if (n1 == null)
        {
            n1 = n.j;
        }
        com.mopub.common.c.a.b(s, throwable);
    }

    static void a(String s, Throwable throwable)
    {
        a(((n) (null)), s, throwable);
    }

    static boolean a(o o1)
    {
        o1.h = false;
        return false;
    }

    static b b()
    {
        return d;
    }

    public final void a(Context context, String s)
    {
        com.mopub.common.m.a(context);
        a(context, s, true);
    }

    public final void a(Context context, String s, boolean flag)
    {
        com.mopub.common.m.a(context);
        a(context, s, flag, null);
    }

    public final void a(Context context, String s, boolean flag, Iterable iterable)
    {
        com.mopub.common.m.a(context);
        if (TextUtils.isEmpty(s))
        {
            a(((n) (null)), "Attempted to handle empty url.", ((Throwable) (null)));
            return;
        } else
        {
            com.mopub.common.p.a(s, new p.a(context, flag, iterable, s) {

                final Context a;
                final boolean b;
                final Iterable c;
                final String d;
                final o e;

                public final void a(String s1)
                {
                    com.mopub.common.o.a(e);
                    e.b(a, s1, b, c);
                }

                public final void a(String s1, Throwable throwable)
                {
                    com.mopub.common.o.a(e);
                    com.mopub.common.o.a(s1, throwable);
                }

            
            {
                e = o.this;
                a = context;
                b = flag;
                c = iterable;
                d = s;
                super();
            }
            });
            h = true;
            return;
        }
    }

    public final boolean b(Context context, String s, boolean flag, Iterable iterable)
    {
        Object obj;
        Uri uri;
        Iterator iterator;
        if (TextUtils.isEmpty(s))
        {
            a(((n) (null)), "Attempted to handle empty url.", ((Throwable) (null)));
            return false;
        }
        obj = n.j;
        uri = Uri.parse(s);
        iterator = e.iterator();
_L2:
        n n1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        n1 = (n)iterator.next();
        if (!n1.a(uri))
        {
            continue; /* Loop/switch isn't completed */
        }
        n1.a(this, context, uri, flag);
        if (!g && !h && !n.b.equals(n1) && !com.mopub.common.n.a.equals(n1))
        {
            obj = com.mopub.common.a.a.d.c;
            p.b(iterable, context);
            f.a(uri.toString(), n1);
            g = true;
        }
        return true;
        obj;
        com.mopub.common.c.a.b(((com.mopub.a.a) (obj)).getMessage(), ((Throwable) (obj)));
        obj = n1;
        if (true) goto _L2; else goto _L1
_L1:
        a(((n) (obj)), (new StringBuilder("Link ignored. Unable to handle url: ")).append(s).toString(), ((Throwable) (null)));
        return false;
    }

}
