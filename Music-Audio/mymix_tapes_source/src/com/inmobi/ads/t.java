// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

class t
{
    static class a
    {

        int a;
        long b;

        a()
        {
        }
    }

    static class b
    {

        private final Rect a = new Rect();

        boolean a(long l, int k)
        {
            return SystemClock.uptimeMillis() - l >= (long)k;
        }

        boolean a(View view, int k)
        {
            if (view != null && view.getVisibility() == 0 && view.getParent() != null && view.getGlobalVisibleRect(a))
            {
                long l = a.height();
                long l1 = a.width();
                long l2 = (long)view.getHeight() * (long)view.getWidth();
                if (l2 > 0L && l * l1 * 100L >= l2 * (long)k)
                {
                    return true;
                }
            }
            return false;
        }

        b()
        {
        }
    }

    class c
        implements Runnable
    {

        final t a;
        private final ArrayList b = new ArrayList();
        private final ArrayList c = new ArrayList();

        public void run()
        {
            t.a(a, false);
            for (Iterator iterator = t.a(a).entrySet().iterator(); iterator.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                View view = (View)entry.getKey();
                int k = ((a)entry.getValue()).a;
                if (t.b(a).a(view, k))
                {
                    b.add(view);
                } else
                {
                    c.add(view);
                }
            }

            if (t.c(a) != null)
            {
                t.c(a).a(b, c);
            }
            b.clear();
            c.clear();
            a.c();
        }

        c()
        {
            a = t.this;
            super();
        }
    }

    static interface d
    {

        public abstract void a(List list, List list1);
    }


    private static final String a = com/inmobi/ads/t.getSimpleName();
    private final ArrayList b;
    private long c;
    private final Map d;
    private final b e;
    private d f;
    private final c g;
    private final Handler h;
    private boolean i;
    private b.f j;

    public t(b.f f1)
    {
        this(((Map) (new WeakHashMap(10))), new b(), new Handler(), f1);
    }

    t(Map map, b b1, Handler handler, b.f f1)
    {
        c = 0L;
        d = map;
        e = b1;
        h = handler;
        g = new c();
        j = f1;
        b = new ArrayList(50);
    }

    static Map a(t t1)
    {
        return t1.d;
    }

    private void a(long l)
    {
        Iterator iterator = d.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((a)entry.getValue()).b < l)
            {
                b.add(entry.getKey());
            }
        } while (true);
        for (Iterator iterator1 = b.iterator(); iterator1.hasNext(); a((View)iterator1.next())) { }
        b.clear();
    }

    static boolean a(t t1, boolean flag)
    {
        t1.i = flag;
        return flag;
    }

    static b b(t t1)
    {
        return t1.e;
    }

    static d c(t t1)
    {
        return t1.f;
    }

    void a()
    {
        d.clear();
        h.removeMessages(0);
        i = false;
    }

    void a(View view)
    {
        d.remove(view);
    }

    void a(View view, int k)
    {
        a a2 = (a)d.get(view);
        a a1 = a2;
        if (a2 == null)
        {
            a1 = new a();
            d.put(view, a1);
            c();
        }
        a1.a = k;
        a1.b = c;
        c = c + 1L;
        if (c % 50L == 0L)
        {
            a(c - 50L);
        }
    }

    void a(d d1)
    {
        f = d1;
    }

    void b()
    {
        a();
        f = null;
    }

    void c()
    {
        if (i)
        {
            return;
        } else
        {
            i = true;
            h.postDelayed(g, j.c());
            return;
        }
    }

}
