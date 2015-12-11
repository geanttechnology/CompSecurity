// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.mopub.d.l;
import com.mopub.d.m;
import com.mopub.d.s;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.mopub.d.a:
//            h

public class g
{
    private final class a
    {

        Bitmap a;
        s b;
        final LinkedList c = new LinkedList();
        final g d;
        private final l e;

        public a(l l, c c1)
        {
            d = g.this;
            super();
            e = l;
            c.add(c1);
        }
    }

    public static interface b
    {

        public abstract Bitmap a(String s);

        public abstract void a(String s, Bitmap bitmap);
    }

    public final class c
    {

        public Bitmap a;
        final d b;
        final g c;
        private final String d;
        private final String e;

        public c(Bitmap bitmap, String s, String s1, d d1)
        {
            c = g.this;
            super();
            a = bitmap;
            e = s;
            d = s1;
            b = d1;
        }
    }

    public static interface d
        extends com.mopub.d.n.a
    {

        public abstract void a(c c1);
    }


    final b a;
    final HashMap b = new HashMap();
    final HashMap c = new HashMap();
    Runnable d;
    private final m e;
    private int f;
    private final Handler g = new Handler(Looper.getMainLooper());

    public g(m m1, b b1)
    {
        f = 100;
        e = m1;
        a = b1;
    }

    public c a(String s, d d1)
    {
        return a(s, d1, 0);
    }

    public final c a(String s, d d1, int i)
    {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
        String s1 = (new StringBuilder(s.length() + 12)).append("#W").append(i).append("#H0").append(s).toString();
        Object obj = a.a(s1);
        if (obj != null)
        {
            s = new c(((Bitmap) (obj)), s, null, null);
            d1.a(s);
            return s;
        }
        obj = new c(null, s, s1, d1);
        d1.a(((c) (obj)));
        d1 = (a)b.get(s1);
        if (d1 != null)
        {
            ((a) (d1)).c.add(obj);
            return ((c) (obj));
        } else
        {
            s = new h(s, new com.mopub.d.n.b(s1) {

                final String a;
                final g b;

                public final void a(Object obj1)
                {
                    obj1 = (Bitmap)obj1;
                    g g1 = b;
                    String s2 = a;
                    g1.a.a(s2, ((Bitmap) (obj1)));
                    a a1 = (a)g1.b.remove(s2);
                    if (a1 != null)
                    {
                        a1.a = ((Bitmap) (obj1));
                        g1.a(s2, a1);
                    }
                }

            
            {
                b = g.this;
                a = s;
                super();
            }
            }, i, android.graphics.Bitmap.Config.RGB_565, new com.mopub.d.n.a(s1) {

                final String a;
                final g b;

                public final void a(s s2)
                {
                    g g1 = b;
                    String s3 = a;
                    a a1 = (a)g1.b.remove(s3);
                    if (a1 != null)
                    {
                        a1.b = s2;
                        g1.a(s3, a1);
                    }
                }

            
            {
                b = g.this;
                a = s;
                super();
            }
            });
            e.b(s);
            b.put(s1, new a(s, ((c) (obj))));
            return ((c) (obj));
        }
    }

    final void a(String s, a a1)
    {
        c.put(s, a1);
        if (d == null)
        {
            d = new Runnable() {

                final g a;

                public final void run()
                {
                    for (Iterator iterator = a.c.values().iterator(); iterator.hasNext();)
                    {
                        a a2 = (a)iterator.next();
                        Iterator iterator1 = a2.c.iterator();
                        while (iterator1.hasNext()) 
                        {
                            c c1 = (c)iterator1.next();
                            if (c1.b != null)
                            {
                                if (a2.b == null)
                                {
                                    c1.a = a2.a;
                                    c1.b.a(c1);
                                } else
                                {
                                    c1.b.a(a2.b);
                                }
                            }
                        }
                    }

                    a.c.clear();
                    a.d = null;
                }

            
            {
                a = g.this;
                super();
            }
            };
            g.postDelayed(d, f);
        }
    }
}
