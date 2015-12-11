// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ad;
import android.support.v4.view.ah;
import android.support.v4.view.w;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class n extends RecyclerView.e
{
    private static final class a
    {

        public RecyclerView.u a;
        public RecyclerView.u b;
        public int c;
        public int d;
        public int e;
        public int f;

        public final String toString()
        {
            return (new StringBuilder("ChangeInfo{oldHolder=")).append(a).append(", newHolder=").append(b).append(", fromX=").append(c).append(", fromY=").append(d).append(", toX=").append(e).append(", toY=").append(f).append('}').toString();
        }

        private a(RecyclerView.u u, RecyclerView.u u1)
        {
            a = u;
            b = u1;
        }

        private a(RecyclerView.u u, RecyclerView.u u1, int i, int j, int k, int l)
        {
            this(u, u1);
            c = i;
            d = j;
            e = k;
            f = l;
        }

        a(RecyclerView.u u, RecyclerView.u u1, int i, int j, int k, int l, byte byte0)
        {
            this(u, u1, i, j, k, l);
        }
    }

    private static final class b
    {

        public RecyclerView.u a;
        public int b;
        public int c;
        public int d;
        public int e;

        private b(RecyclerView.u u, int i, int j, int k, int l)
        {
            a = u;
            b = i;
            c = j;
            d = k;
            e = l;
        }

        b(RecyclerView.u u, int i, int j, int k, int l, byte byte0)
        {
            this(u, i, j, k, l);
        }
    }

    private static class c
        implements ah
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

        c(byte byte0)
        {
            this();
        }
    }


    ArrayList a;
    ArrayList b;
    ArrayList c;
    ArrayList d;
    ArrayList e;
    ArrayList f;
    ArrayList g;
    private ArrayList n;
    private ArrayList o;
    private ArrayList p;
    private ArrayList q;

    public n()
    {
        n = new ArrayList();
        o = new ArrayList();
        p = new ArrayList();
        q = new ArrayList();
        a = new ArrayList();
        b = new ArrayList();
        c = new ArrayList();
        d = new ArrayList();
        e = new ArrayList();
        f = new ArrayList();
        g = new ArrayList();
    }

    private void a(a a1)
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

    private static void a(List list)
    {
        for (int i = list.size() - 1; i >= 0; i--)
        {
            w.n(((RecyclerView.u)list.get(i)).a).a();
        }

    }

    private void a(List list, RecyclerView.u u)
    {
        for (int i = list.size() - 1; i >= 0; i--)
        {
            a a1 = (a)list.get(i);
            if (a(a1, u) && a1.a == null && a1.b == null)
            {
                list.remove(a1);
            }
        }

    }

    private boolean a(a a1, RecyclerView.u u)
    {
        if (a1.b == u)
        {
            a1.b = null;
        } else
        if (a1.a == u)
        {
            a1.a = null;
        } else
        {
            return false;
        }
        w.c(u.a, 1.0F);
        w.a(u.a, 0.0F);
        w.b(u.a, 0.0F);
        g(u);
        return true;
    }

    public final void a()
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (!n.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!p.isEmpty())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!q.isEmpty())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!o.isEmpty())
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag || flag1 || flag3 || flag2)
        {
            RecyclerView.u u;
            ad ad1;
            for (Iterator iterator = n.iterator(); iterator.hasNext(); ad1.a(super.j).a(0.0F).a(new c(u, ad1) {

        final RecyclerView.u a;
        final ad b;
        final n c;

        public final void a(View view)
        {
        }

        public final void b(View view)
        {
            b.a(null);
            w.c(view, 1.0F);
            c.d(a);
            c.f.remove(a);
            c.c();
        }

            
            {
                c = n.this;
                a = u;
                b = ad1;
                super((byte)0);
            }
    }).b())
            {
                u = (RecyclerView.u)iterator.next();
                ad1 = w.n(u.a);
                f.add(u);
            }

            n.clear();
            Runnable runnable;
            if (flag1)
            {
                ArrayList arraylist = new ArrayList();
                arraylist.addAll(p);
                b.add(arraylist);
                p.clear();
                runnable = new Runnable(arraylist) {

                    final ArrayList a;
                    final n b;

                    public final void run()
                    {
                        n n1;
                        RecyclerView.u u1;
                        Object obj;
                        int i;
                        int k;
                        for (Iterator iterator1 = a.iterator(); iterator1.hasNext(); ((ad) (obj)).a(((RecyclerView.e) (n1)).k).a(n1. new c(u1, k, i, ((ad) (obj))) {

                    final RecyclerView.u a;
                    final int b;
                    final int c;
                    final ad d;
                    final n e;

                    public final void a(View view)
                    {
                    }

                    public final void b(View view)
                    {
                        d.a(null);
                        e.e(a);
                        e.e.remove(a);
                        e.c();
                    }

                    public final void c(View view)
                    {
                        if (b != 0)
                        {
                            w.a(view, 0.0F);
                        }
                        if (c != 0)
                        {
                            w.b(view, 0.0F);
                        }
                    }

            
            {
                e = n.this;
                a = u;
                b = i;
                c = j;
                d = ad1;
                super((byte)0);
            }
                }).b())
                        {
                            obj = (b)iterator1.next();
                            n1 = b;
                            u1 = ((b) (obj)).a;
                            k = ((b) (obj)).b;
                            i = ((b) (obj)).c;
                            int i1 = ((b) (obj)).d;
                            int j = ((b) (obj)).e;
                            obj = u1.a;
                            k = i1 - k;
                            i = j - i;
                            if (k != 0)
                            {
                                w.n(((View) (obj))).b(0.0F);
                            }
                            if (i != 0)
                            {
                                w.n(((View) (obj))).c(0.0F);
                            }
                            obj = w.n(((View) (obj)));
                            n1.e.add(u1);
                        }

                        a.clear();
                        b.b.remove(a);
                    }

            
            {
                b = n.this;
                a = arraylist;
                super();
            }
                };
                if (flag)
                {
                    w.a(((b)arraylist.get(0)).a.a, runnable, super.j);
                } else
                {
                    runnable.run();
                }
            }
            if (flag2)
            {
                arraylist = new ArrayList();
                arraylist.addAll(q);
                c.add(arraylist);
                q.clear();
                runnable = new Runnable(arraylist) {

                    final ArrayList a;
                    final n b;

                    public final void run()
                    {
                        Iterator iterator1 = a.iterator();
                        do
                        {
                            if (!iterator1.hasNext())
                            {
                                break;
                            }
                            a a1 = (a)iterator1.next();
                            n n1 = b;
                            Object obj = a1.a;
                            Object obj1;
                            if (obj == null)
                            {
                                obj = null;
                            } else
                            {
                                obj = ((RecyclerView.u) (obj)).a;
                            }
                            obj1 = a1.b;
                            if (obj1 != null)
                            {
                                obj1 = ((RecyclerView.u) (obj1)).a;
                            } else
                            {
                                obj1 = null;
                            }
                            if (obj != null)
                            {
                                obj = w.n(((View) (obj))).a(((RecyclerView.e) (n1)).l);
                                n1.g.add(a1.a);
                                ((ad) (obj)).b(a1.e - a1.c);
                                ((ad) (obj)).c(a1.f - a1.d);
                                ((ad) (obj)).a(0.0F).a(n1. new c(a1, ((ad) (obj))) {

                                    final a a;
                                    final ad b;
                                    final n c;

                                    public final void a(View view)
                                    {
                                    }

                                    public final void b(View view)
                                    {
                                        b.a(null);
                                        w.c(view, 1.0F);
                                        w.a(view, 0.0F);
                                        w.b(view, 0.0F);
                                        c.g(a.a);
                                        c.g.remove(a.a);
                                        c.c();
                                    }

            
            {
                c = n.this;
                a = a1;
                b = ad1;
                super((byte)0);
            }
                                }).b();
                            }
                            if (obj1 != null)
                            {
                                obj = w.n(((View) (obj1)));
                                n1.g.add(a1.b);
                                ((ad) (obj)).b(0.0F).c(0.0F).a(((RecyclerView.e) (n1)).l).a(1.0F).a(n1. new c(a1, ((ad) (obj)), ((View) (obj1))) {

                                    final a a;
                                    final ad b;
                                    final View c;
                                    final n d;

                                    public final void a(View view)
                                    {
                                    }

                                    public final void b(View view)
                                    {
                                        b.a(null);
                                        w.c(c, 1.0F);
                                        w.a(c, 0.0F);
                                        w.b(c, 0.0F);
                                        d.g(a.b);
                                        d.g.remove(a.b);
                                        d.c();
                                    }

            
            {
                d = n.this;
                a = a1;
                b = ad1;
                c = view;
                super((byte)0);
            }
                                }).b();
                            }
                        } while (true);
                        a.clear();
                        b.c.remove(a);
                    }

            
            {
                b = n.this;
                a = arraylist;
                super();
            }
                };
                if (flag)
                {
                    w.a(((a)arraylist.get(0)).a.a, runnable, super.j);
                } else
                {
                    runnable.run();
                }
            }
            if (flag3)
            {
                arraylist = new ArrayList();
                arraylist.addAll(o);
                a.add(arraylist);
                o.clear();
                runnable = new Runnable(arraylist) {

                    final ArrayList a;
                    final n b;

                    public final void run()
                    {
                        RecyclerView.u u1;
                        n n1;
                        ad ad2;
                        for (Iterator iterator1 = a.iterator(); iterator1.hasNext(); ad2.a(1.0F).a(((RecyclerView.e) (n1)).i).a(n1. new c(u1, ad2) {

                    final RecyclerView.u a;
                    final ad b;
                    final n c;

                    public final void a(View view)
                    {
                    }

                    public final void b(View view)
                    {
                        b.a(null);
                        c.f(a);
                        c.d.remove(a);
                        c.c();
                    }

                    public final void c(View view)
                    {
                        w.c(view, 1.0F);
                    }

            
            {
                c = n.this;
                a = u;
                b = ad1;
                super((byte)0);
            }
                }).b())
                        {
                            u1 = (RecyclerView.u)iterator1.next();
                            n1 = b;
                            ad2 = w.n(u1.a);
                            n1.d.add(u1);
                        }

                        a.clear();
                        b.a.remove(a);
                    }

            
            {
                b = n.this;
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
                        l = super.j;
                    } else
                    {
                        l = 0L;
                    }
                    if (flag1)
                    {
                        l1 = super.k;
                    } else
                    {
                        l1 = 0L;
                    }
                    if (flag2)
                    {
                        l2 = super.l;
                    } else
                    {
                        l2 = 0L;
                    }
                    l1 = Math.max(l1, l2);
                    w.a(((RecyclerView.u)arraylist.get(0)).a, runnable, l + l1);
                    return;
                } else
                {
                    runnable.run();
                    return;
                }
            }
        }
    }

    public final boolean a(RecyclerView.u u)
    {
        c(u);
        n.add(u);
        return true;
    }

    public final boolean a(RecyclerView.u u, int i, int j, int k, int l)
    {
        View view = u.a;
        i = (int)((float)i + w.j(u.a));
        j = (int)((float)j + w.k(u.a));
        c(u);
        int i1 = k - i;
        int j1 = l - j;
        if (i1 == 0 && j1 == 0)
        {
            e(u);
            return false;
        }
        if (i1 != 0)
        {
            w.a(view, -i1);
        }
        if (j1 != 0)
        {
            w.b(view, -j1);
        }
        p.add(new b(u, i, j, k, l, (byte)0));
        return true;
    }

    public final boolean a(RecyclerView.u u, RecyclerView.u u1, int i, int j, int k, int l)
    {
        float f1 = w.j(u.a);
        float f2 = w.k(u.a);
        float f3 = w.g(u.a);
        c(u);
        int i1 = (int)((float)(k - i) - f1);
        int j1 = (int)((float)(l - j) - f2);
        w.a(u.a, f1);
        w.b(u.a, f2);
        w.c(u.a, f3);
        if (u1 != null && u1.a != null)
        {
            c(u1);
            w.a(u1.a, -i1);
            w.b(u1.a, -j1);
            w.c(u1.a, 0.0F);
        }
        q.add(new a(u, u1, i, j, k, l, (byte)0));
        return true;
    }

    public final boolean b()
    {
        return !o.isEmpty() || !q.isEmpty() || !p.isEmpty() || !n.isEmpty() || !e.isEmpty() || !f.isEmpty() || !d.isEmpty() || !g.isEmpty() || !b.isEmpty() || !a.isEmpty() || !c.isEmpty();
    }

    public final boolean b(RecyclerView.u u)
    {
        c(u);
        w.c(u.a, 0.0F);
        o.add(u);
        return true;
    }

    final void c()
    {
        if (!b())
        {
            e();
        }
    }

    public final void c(RecyclerView.u u)
    {
        View view = u.a;
        w.n(view).a();
        for (int i = p.size() - 1; i >= 0; i--)
        {
            if (((b)p.get(i)).a == u)
            {
                w.b(view, 0.0F);
                w.a(view, 0.0F);
                e(u);
                p.remove(i);
            }
        }

        a(q, u);
        if (n.remove(u))
        {
            w.c(view, 1.0F);
            d(u);
        }
        if (o.remove(u))
        {
            w.c(view, 1.0F);
            f(u);
        }
        for (int j = c.size() - 1; j >= 0; j--)
        {
            ArrayList arraylist = (ArrayList)c.get(j);
            a(arraylist, u);
            if (arraylist.isEmpty())
            {
                c.remove(j);
            }
        }

        int k = b.size() - 1;
label0:
        do
        {
            if (k >= 0)
            {
                ArrayList arraylist1 = (ArrayList)b.get(k);
                int i1 = arraylist1.size() - 1;
                do
                {
label1:
                    {
                        if (i1 >= 0)
                        {
                            if (((b)arraylist1.get(i1)).a != u)
                            {
                                break label1;
                            }
                            w.b(view, 0.0F);
                            w.a(view, 0.0F);
                            e(u);
                            arraylist1.remove(i1);
                            if (arraylist1.isEmpty())
                            {
                                b.remove(k);
                            }
                        }
                        k--;
                        continue label0;
                    }
                    i1--;
                } while (true);
            }
            for (int l = a.size() - 1; l >= 0; l--)
            {
                ArrayList arraylist2 = (ArrayList)a.get(l);
                if (!arraylist2.remove(u))
                {
                    continue;
                }
                w.c(view, 1.0F);
                f(u);
                if (arraylist2.isEmpty())
                {
                    a.remove(l);
                }
            }

            f.remove(u);
            d.remove(u);
            g.remove(u);
            e.remove(u);
            c();
            return;
        } while (true);
    }

    public final void d()
    {
        for (int i = p.size() - 1; i >= 0; i--)
        {
            b b1 = (b)p.get(i);
            View view = b1.a.a;
            w.b(view, 0.0F);
            w.a(view, 0.0F);
            e(b1.a);
            p.remove(i);
        }

        for (int j = n.size() - 1; j >= 0; j--)
        {
            d((RecyclerView.u)n.get(j));
            n.remove(j);
        }

        for (int k = o.size() - 1; k >= 0; k--)
        {
            RecyclerView.u u = (RecyclerView.u)o.get(k);
            w.c(u.a, 1.0F);
            f(u);
            o.remove(k);
        }

        for (int l = q.size() - 1; l >= 0; l--)
        {
            a((a)q.get(l));
        }

        q.clear();
        if (!b())
        {
            return;
        }
        for (int i1 = b.size() - 1; i1 >= 0; i1--)
        {
            ArrayList arraylist = (ArrayList)b.get(i1);
            for (int l1 = arraylist.size() - 1; l1 >= 0; l1--)
            {
                b b2 = (b)arraylist.get(l1);
                View view1 = b2.a.a;
                w.b(view1, 0.0F);
                w.a(view1, 0.0F);
                e(b2.a);
                arraylist.remove(l1);
                if (arraylist.isEmpty())
                {
                    b.remove(arraylist);
                }
            }

        }

        for (int j1 = a.size() - 1; j1 >= 0; j1--)
        {
            ArrayList arraylist1 = (ArrayList)a.get(j1);
            for (int i2 = arraylist1.size() - 1; i2 >= 0; i2--)
            {
                RecyclerView.u u1 = (RecyclerView.u)arraylist1.get(i2);
                w.c(u1.a, 1.0F);
                f(u1);
                arraylist1.remove(i2);
                if (arraylist1.isEmpty())
                {
                    a.remove(arraylist1);
                }
            }

        }

        for (int k1 = c.size() - 1; k1 >= 0; k1--)
        {
            ArrayList arraylist2 = (ArrayList)c.get(k1);
            for (int j2 = arraylist2.size() - 1; j2 >= 0; j2--)
            {
                a((a)arraylist2.get(j2));
                if (arraylist2.isEmpty())
                {
                    c.remove(arraylist2);
                }
            }

        }

        a(f);
        a(e);
        a(d);
        a(g);
        e();
    }
}
