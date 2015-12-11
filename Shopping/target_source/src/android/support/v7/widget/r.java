// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.ba;
import android.support.v4.view.be;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class r extends RecyclerView.d
{
    private static class a
    {

        public RecyclerView.t a;
        public RecyclerView.t b;
        public int c;
        public int d;
        public int e;
        public int f;

        public String toString()
        {
            return (new StringBuilder()).append("ChangeInfo{oldHolder=").append(a).append(", newHolder=").append(b).append(", fromX=").append(c).append(", fromY=").append(d).append(", toX=").append(e).append(", toY=").append(f).append('}').toString();
        }

        private a(RecyclerView.t t, RecyclerView.t t1)
        {
            a = t;
            b = t1;
        }

        private a(RecyclerView.t t, RecyclerView.t t1, int l, int i1, int j1, int k1)
        {
            this(t, t1);
            c = l;
            d = i1;
            e = j1;
            f = k1;
        }

    }

    private static class b
    {

        public RecyclerView.t a;
        public int b;
        public int c;
        public int d;
        public int e;

        private b(RecyclerView.t t, int l, int i1, int j1, int k1)
        {
            a = t;
            b = l;
            c = i1;
            d = j1;
            e = k1;
        }

    }

    private static class c
        implements be
    {

        public void a(View view)
        {
        }

        public void b(View view)
        {
        }

        public void c(View view)
        {
        }

        private c()
        {
        }

    }


    private ArrayList a;
    private ArrayList b;
    private ArrayList c;
    private ArrayList d;
    private ArrayList e;
    private ArrayList f;
    private ArrayList g;
    private ArrayList h;
    private ArrayList i;
    private ArrayList j;
    private ArrayList k;

    public r()
    {
        a = new ArrayList();
        b = new ArrayList();
        c = new ArrayList();
        d = new ArrayList();
        e = new ArrayList();
        f = new ArrayList();
        g = new ArrayList();
        h = new ArrayList();
        i = new ArrayList();
        j = new ArrayList();
        k = new ArrayList();
    }

    static ArrayList a(r r1)
    {
        return r1.f;
    }

    private void a(a a1)
    {
        View view = null;
        Object obj = a1.a;
        RecyclerView.t t;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((RecyclerView.t) (obj)).itemView;
        }
        t = a1.b;
        if (t != null)
        {
            view = t.itemView;
        }
        if (obj != null)
        {
            k.add(a1.a);
            obj = ai.s(((View) (obj))).a(g());
            ((ba) (obj)).b(a1.e - a1.c);
            ((ba) (obj)).c(a1.f - a1.d);
            ((ba) (obj)).a(0.0F).a(new c(a1, ((ba) (obj))) {

                final a a;
                final ba b;
                final r c;

                public void a(View view1)
                {
                    c.b(a.a, true);
                }

                public void b(View view1)
                {
                    b.a(null);
                    ai.c(view1, 1.0F);
                    ai.a(view1, 0.0F);
                    ai.b(view1, 0.0F);
                    c.a(a.a, true);
                    r.h(c).remove(a.a);
                    r.e(c);
                }

            
            {
                c = r.this;
                a = a1;
                b = ba1;
                super();
            }
            }).b();
        }
        if (view != null)
        {
            k.add(a1.b);
            obj = ai.s(view);
            ((ba) (obj)).b(0.0F).c(0.0F).a(g()).a(1.0F).a(new c(a1, ((ba) (obj)), view) {

                final a a;
                final ba b;
                final View c;
                final r d;

                public void a(View view1)
                {
                    d.b(a.b, false);
                }

                public void b(View view1)
                {
                    b.a(null);
                    ai.c(c, 1.0F);
                    ai.a(c, 0.0F);
                    ai.b(c, 0.0F);
                    d.a(a.b, false);
                    r.h(d).remove(a.b);
                    r.e(d);
                }

            
            {
                d = r.this;
                a = a1;
                b = ba1;
                c = view;
                super();
            }
            }).b();
        }
    }

    static void a(r r1, RecyclerView.t t)
    {
        r1.q(t);
    }

    static void a(r r1, RecyclerView.t t, int l, int i1, int j1, int k1)
    {
        r1.b(t, l, i1, j1, k1);
    }

    static void a(r r1, a a1)
    {
        r1.a(a1);
    }

    private void a(List list, RecyclerView.t t)
    {
        for (int l = list.size() - 1; l >= 0; l--)
        {
            a a1 = (a)list.get(l);
            if (a(a1, t) && a1.a == null && a1.b == null)
            {
                list.remove(a1);
            }
        }

    }

    private boolean a(a a1, RecyclerView.t t)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        if (a1.b != t) goto _L2; else goto _L1
_L1:
        a1.b = null;
_L6:
        ai.c(t.itemView, 1.0F);
        ai.a(t.itemView, 0.0F);
        ai.b(t.itemView, 0.0F);
        a(t, flag);
        flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (a1.a != t) goto _L4; else goto _L3
_L3:
        a1.a = null;
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static ArrayList b(r r1)
    {
        return r1.g;
    }

    private void b(RecyclerView.t t, int l, int i1, int j1, int k1)
    {
        Object obj = t.itemView;
        l = j1 - l;
        i1 = k1 - i1;
        if (l != 0)
        {
            ai.s(((View) (obj))).b(0.0F);
        }
        if (i1 != 0)
        {
            ai.s(((View) (obj))).c(0.0F);
        }
        i.add(t);
        obj = ai.s(((View) (obj)));
        ((ba) (obj)).a(d()).a(new c(t, l, i1, ((ba) (obj))) {

            final RecyclerView.t a;
            final int b;
            final int c;
            final ba d;
            final r e;

            public void a(View view)
            {
                e.h(a);
            }

            public void b(View view)
            {
                d.a(null);
                e.e(a);
                r.g(e).remove(a);
                r.e(e);
            }

            public void c(View view)
            {
                if (b != 0)
                {
                    ai.a(view, 0.0F);
                }
                if (c != 0)
                {
                    ai.b(view, 0.0F);
                }
            }

            
            {
                e = r.this;
                a = t;
                b = l;
                c = i1;
                d = ba1;
                super();
            }
        }).b();
    }

    private void b(a a1)
    {
        if (a1.a != null)
        {
            a(a1, a1.a);
        }
        if (a1.b != null)
        {
            a(a1, a1.b);
        }
    }

    static ArrayList c(r r1)
    {
        return r1.e;
    }

    static ArrayList d(r r1)
    {
        return r1.j;
    }

    static void e(r r1)
    {
        r1.j();
    }

    static ArrayList f(r r1)
    {
        return r1.h;
    }

    static ArrayList g(r r1)
    {
        return r1.i;
    }

    static ArrayList h(r r1)
    {
        return r1.k;
    }

    private void j()
    {
        if (!b())
        {
            i();
        }
    }

    private void p(RecyclerView.t t)
    {
        ba ba1 = ai.s(t.itemView);
        ba1.a(f()).a(0.0F).a(new c(t, ba1) {

            final RecyclerView.t a;
            final ba b;
            final r c;

            public void a(View view)
            {
                c.g(a);
            }

            public void b(View view)
            {
                b.a(null);
                ai.c(view, 1.0F);
                c.d(a);
                r.d(c).remove(a);
                r.e(c);
            }

            
            {
                c = r.this;
                a = t;
                b = ba1;
                super();
            }
        }).b();
        j.add(t);
    }

    private void q(RecyclerView.t t)
    {
        Object obj = t.itemView;
        h.add(t);
        obj = ai.s(((View) (obj)));
        ((ba) (obj)).a(1.0F).a(e()).a(new c(t, ((ba) (obj))) {

            final RecyclerView.t a;
            final ba b;
            final r c;

            public void a(View view)
            {
                c.i(a);
            }

            public void b(View view)
            {
                b.a(null);
                c.f(a);
                r.f(c).remove(a);
                r.e(c);
            }

            public void c(View view)
            {
                ai.c(view, 1.0F);
            }

            
            {
                c = r.this;
                a = t;
                b = ba1;
                super();
            }
        }).b();
    }

    public void a()
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (!a.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!c.isEmpty())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!d.isEmpty())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!b.isEmpty())
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag || flag1 || flag3 || flag2)
        {
            for (Iterator iterator = a.iterator(); iterator.hasNext(); p((RecyclerView.t)iterator.next())) { }
            a.clear();
            Runnable runnable;
            if (flag1)
            {
                ArrayList arraylist = new ArrayList();
                arraylist.addAll(c);
                f.add(arraylist);
                c.clear();
                runnable = new Runnable(arraylist) {

                    final ArrayList a;
                    final r b;

                    public void run()
                    {
                        b b1;
                        for (Iterator iterator1 = a.iterator(); iterator1.hasNext(); r.a(b, b1.a, b1.b, b1.c, b1.d, b1.e))
                        {
                            b1 = (b)iterator1.next();
                        }

                        a.clear();
                        r.a(b).remove(a);
                    }

            
            {
                b = r.this;
                a = arraylist;
                super();
            }
                };
                if (flag)
                {
                    ai.a(((b)arraylist.get(0)).a.itemView, runnable, f());
                } else
                {
                    runnable.run();
                }
            }
            if (flag2)
            {
                arraylist = new ArrayList();
                arraylist.addAll(d);
                g.add(arraylist);
                d.clear();
                runnable = new Runnable(arraylist) {

                    final ArrayList a;
                    final r b;

                    public void run()
                    {
                        a a1;
                        for (Iterator iterator1 = a.iterator(); iterator1.hasNext(); r.a(b, a1))
                        {
                            a1 = (a)iterator1.next();
                        }

                        a.clear();
                        r.b(b).remove(a);
                    }

            
            {
                b = r.this;
                a = arraylist;
                super();
            }
                };
                if (flag)
                {
                    ai.a(((a)arraylist.get(0)).a.itemView, runnable, f());
                } else
                {
                    runnable.run();
                }
            }
            if (flag3)
            {
                arraylist = new ArrayList();
                arraylist.addAll(b);
                e.add(arraylist);
                b.clear();
                runnable = new Runnable(arraylist) {

                    final ArrayList a;
                    final r b;

                    public void run()
                    {
                        RecyclerView.t t;
                        for (Iterator iterator1 = a.iterator(); iterator1.hasNext(); r.a(b, t))
                        {
                            t = (RecyclerView.t)iterator1.next();
                        }

                        a.clear();
                        r.c(b).remove(a);
                    }

            
            {
                b = r.this;
                a = arraylist;
                super();
            }
                };
                if (flag || flag1 || flag2)
                {
                    long l;
                    long l1;
                    long l2;
                    if (flag)
                    {
                        l = f();
                    } else
                    {
                        l = 0L;
                    }
                    if (flag1)
                    {
                        l1 = d();
                    } else
                    {
                        l1 = 0L;
                    }
                    if (flag2)
                    {
                        l2 = g();
                    } else
                    {
                        l2 = 0L;
                    }
                    l1 = Math.max(l1, l2);
                    ai.a(((RecyclerView.t)arraylist.get(0)).itemView, runnable, l + l1);
                    return;
                } else
                {
                    runnable.run();
                    return;
                }
            }
        }
    }

    void a(List list)
    {
        for (int l = list.size() - 1; l >= 0; l--)
        {
            ai.s(((RecyclerView.t)list.get(l)).itemView).a();
        }

    }

    public boolean a(RecyclerView.t t)
    {
        c(t);
        a.add(t);
        return true;
    }

    public boolean a(RecyclerView.t t, int l, int i1, int j1, int k1)
    {
        View view = t.itemView;
        l = (int)((float)l + ai.o(t.itemView));
        i1 = (int)((float)i1 + ai.p(t.itemView));
        c(t);
        int l1 = j1 - l;
        int i2 = k1 - i1;
        if (l1 == 0 && i2 == 0)
        {
            e(t);
            return false;
        }
        if (l1 != 0)
        {
            ai.a(view, -l1);
        }
        if (i2 != 0)
        {
            ai.b(view, -i2);
        }
        c.add(new b(t, l, i1, j1, k1));
        return true;
    }

    public boolean a(RecyclerView.t t, RecyclerView.t t1, int l, int i1, int j1, int k1)
    {
        float f1 = ai.o(t.itemView);
        float f2 = ai.p(t.itemView);
        float f3 = ai.f(t.itemView);
        c(t);
        int l1 = (int)((float)(j1 - l) - f1);
        int i2 = (int)((float)(k1 - i1) - f2);
        ai.a(t.itemView, f1);
        ai.b(t.itemView, f2);
        ai.c(t.itemView, f3);
        if (t1 != null && t1.itemView != null)
        {
            c(t1);
            ai.a(t1.itemView, -l1);
            ai.b(t1.itemView, -i2);
            ai.c(t1.itemView, 0.0F);
        }
        d.add(new a(t, t1, l, i1, j1, k1));
        return true;
    }

    public boolean b()
    {
        return !b.isEmpty() || !d.isEmpty() || !c.isEmpty() || !a.isEmpty() || !i.isEmpty() || !j.isEmpty() || !h.isEmpty() || !k.isEmpty() || !f.isEmpty() || !e.isEmpty() || !g.isEmpty();
    }

    public boolean b(RecyclerView.t t)
    {
        c(t);
        ai.c(t.itemView, 0.0F);
        b.add(t);
        return true;
    }

    public void c()
    {
        for (int l = c.size() - 1; l >= 0; l--)
        {
            b b1 = (b)c.get(l);
            View view = b1.a.itemView;
            ai.b(view, 0.0F);
            ai.a(view, 0.0F);
            e(b1.a);
            c.remove(l);
        }

        for (int i1 = a.size() - 1; i1 >= 0; i1--)
        {
            d((RecyclerView.t)a.get(i1));
            a.remove(i1);
        }

        for (int j1 = b.size() - 1; j1 >= 0; j1--)
        {
            RecyclerView.t t = (RecyclerView.t)b.get(j1);
            ai.c(t.itemView, 1.0F);
            f(t);
            b.remove(j1);
        }

        for (int k1 = d.size() - 1; k1 >= 0; k1--)
        {
            b((a)d.get(k1));
        }

        d.clear();
        if (!b())
        {
            return;
        }
        for (int l1 = f.size() - 1; l1 >= 0; l1--)
        {
            ArrayList arraylist = (ArrayList)f.get(l1);
            for (int k2 = arraylist.size() - 1; k2 >= 0; k2--)
            {
                b b2 = (b)arraylist.get(k2);
                View view1 = b2.a.itemView;
                ai.b(view1, 0.0F);
                ai.a(view1, 0.0F);
                e(b2.a);
                arraylist.remove(k2);
                if (arraylist.isEmpty())
                {
                    f.remove(arraylist);
                }
            }

        }

        for (int i2 = e.size() - 1; i2 >= 0; i2--)
        {
            ArrayList arraylist1 = (ArrayList)e.get(i2);
            for (int l2 = arraylist1.size() - 1; l2 >= 0; l2--)
            {
                RecyclerView.t t1 = (RecyclerView.t)arraylist1.get(l2);
                ai.c(t1.itemView, 1.0F);
                f(t1);
                arraylist1.remove(l2);
                if (arraylist1.isEmpty())
                {
                    e.remove(arraylist1);
                }
            }

        }

        for (int j2 = g.size() - 1; j2 >= 0; j2--)
        {
            ArrayList arraylist2 = (ArrayList)g.get(j2);
            for (int i3 = arraylist2.size() - 1; i3 >= 0; i3--)
            {
                b((a)arraylist2.get(i3));
                if (arraylist2.isEmpty())
                {
                    g.remove(arraylist2);
                }
            }

        }

        a(j);
        a(i);
        a(h);
        a(k);
        i();
    }

    public void c(RecyclerView.t t)
    {
        View view = t.itemView;
        ai.s(view).a();
        for (int l = c.size() - 1; l >= 0; l--)
        {
            if (((b)c.get(l)).a == t)
            {
                ai.b(view, 0.0F);
                ai.a(view, 0.0F);
                e(t);
                c.remove(l);
            }
        }

        a(d, t);
        if (a.remove(t))
        {
            ai.c(view, 1.0F);
            d(t);
        }
        if (b.remove(t))
        {
            ai.c(view, 1.0F);
            f(t);
        }
        for (int i1 = g.size() - 1; i1 >= 0; i1--)
        {
            ArrayList arraylist = (ArrayList)g.get(i1);
            a(arraylist, t);
            if (arraylist.isEmpty())
            {
                g.remove(i1);
            }
        }

        int j1 = f.size() - 1;
label0:
        do
        {
            if (j1 >= 0)
            {
                ArrayList arraylist1 = (ArrayList)f.get(j1);
                int l1 = arraylist1.size() - 1;
                do
                {
label1:
                    {
                        if (l1 >= 0)
                        {
                            if (((b)arraylist1.get(l1)).a != t)
                            {
                                break label1;
                            }
                            ai.b(view, 0.0F);
                            ai.a(view, 0.0F);
                            e(t);
                            arraylist1.remove(l1);
                            if (arraylist1.isEmpty())
                            {
                                f.remove(j1);
                            }
                        }
                        j1--;
                        continue label0;
                    }
                    l1--;
                } while (true);
            }
            for (int k1 = e.size() - 1; k1 >= 0; k1--)
            {
                ArrayList arraylist2 = (ArrayList)e.get(k1);
                if (!arraylist2.remove(t))
                {
                    continue;
                }
                ai.c(view, 1.0F);
                f(t);
                if (arraylist2.isEmpty())
                {
                    e.remove(k1);
                }
            }

            if (!j.remove(t));
            if (!h.remove(t));
            if (!k.remove(t));
            if (!i.remove(t));
            j();
            return;
        } while (true);
    }
}
