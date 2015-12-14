// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.os.Handler;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

// Referenced classes of package com.inmobi.ads:
//            t, o, s

class m
{
    class a
        implements Runnable
    {

        final m a;
        private final ArrayList b = new ArrayList();

        public void run()
        {
            Iterator iterator = m.b(a).entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (java.util.Map.Entry)iterator.next();
                View view = (View)((java.util.Map.Entry) (obj)).getKey();
                obj = (s)((java.util.Map.Entry) (obj)).getValue();
                if (m.d(a).a(((s) (obj)).b, m.c(a).b()))
                {
                    ((o)((s) (obj)).a).A();
                    b.add(view);
                }
            } while (true);
            View view1;
            for (Iterator iterator1 = b.iterator(); iterator1.hasNext(); a.a(view1))
            {
                view1 = (View)iterator1.next();
            }

            b.clear();
            if (!m.b(a).isEmpty())
            {
                a.c();
            }
        }

        a()
        {
            a = m.this;
            super();
        }
    }


    private static final String a = com/inmobi/ads/m.getSimpleName();
    private final t b;
    private final Map c;
    private final Map d;
    private final Handler e;
    private final a f;
    private final t.b g;
    private t.d h = new t.d() {

        final m a;

        public void a(List list, List list1)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                View view = (View)list.next();
                o o1 = (o)m.a(a).get(view);
                if (o1 == null)
                {
                    a.a(view);
                } else
                {
                    s s1 = (s)m.b(a).get(view);
                    if (s1 == null || !o1.equals(s1.a))
                    {
                        m.b(a).put(view, new s(o1));
                    }
                }
            } while (true);
            for (list = list1.iterator(); list.hasNext(); m.b(a).remove(list1))
            {
                list1 = (View)list.next();
            }

            a.c();
        }

            
            {
                a = m.this;
                super();
            }
    };
    private b.f i;

    m(b.f f1)
    {
        this(((Map) (new WeakHashMap())), ((Map) (new WeakHashMap())), new t.b(), new t(f1), new Handler(), f1);
    }

    m(Map map, Map map1, t.b b1, t t1, Handler handler, b.f f1)
    {
        c = map;
        d = map1;
        g = b1;
        b = t1;
        i = f1;
        b.a(h);
        e = handler;
        f = new a();
    }

    static Map a(m m1)
    {
        return m1.c;
    }

    static Map b(m m1)
    {
        return m1.d;
    }

    private void b(View view)
    {
        d.remove(view);
    }

    static b.f c(m m1)
    {
        return m1.i;
    }

    static t.b d(m m1)
    {
        return m1.g;
    }

    void a()
    {
        c.clear();
        d.clear();
        b.a();
        e.removeMessages(0);
    }

    void a(View view)
    {
        c.remove(view);
        b(view);
        b.a(view);
    }

    void a(View view, o o1)
    {
        if (c.get(view) != o1)
        {
            a(view);
            if (AdUnit.AdState.STATE_RENDERED != o1.g())
            {
                c.put(view, o1);
                b.a(view, i.a());
                return;
            }
        }
    }

    void b()
    {
        a();
        b.b();
        h = null;
    }

    void c()
    {
        if (e.hasMessages(0))
        {
            return;
        } else
        {
            e.postDelayed(f, i.d());
            return;
        }
    }

}
