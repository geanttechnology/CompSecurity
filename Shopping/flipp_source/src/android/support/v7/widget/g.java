// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ap;
import android.support.v4.view.cj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            aq, p, bi, k, 
//            h, q, i, j

public final class g extends aq
{

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

    public g()
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

    private void a(p p1)
    {
        if (p1.a != null)
        {
            a(p1, p1.a);
        }
        if (p1.b != null)
        {
            a(p1, p1.b);
        }
    }

    private static void a(List list)
    {
        for (int l = list.size() - 1; l >= 0; l--)
        {
            ap.o(((bi)list.get(l)).a).a();
        }

    }

    private void a(List list, bi bi1)
    {
        for (int l = list.size() - 1; l >= 0; l--)
        {
            p p1 = (p)list.get(l);
            if (a(p1, bi1) && p1.a == null && p1.b == null)
            {
                list.remove(p1);
            }
        }

    }

    private boolean a(p p1, bi bi1)
    {
        if (p1.b == bi1)
        {
            p1.b = null;
        } else
        if (p1.a == bi1)
        {
            p1.a = null;
        } else
        {
            return false;
        }
        ap.c(bi1.a, 1.0F);
        ap.a(bi1.a, 0.0F);
        ap.b(bi1.a, 0.0F);
        g(bi1);
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
            bi bi1;
            for (Iterator iterator = n.iterator(); iterator.hasNext(); f.add(bi1))
            {
                bi1 = (bi)iterator.next();
                cj cj1 = ap.o(bi1.a);
                cj1.a(super.j).a(0.0F).a(new k(this, bi1, cj1)).b();
            }

            n.clear();
            Object obj;
            if (flag1)
            {
                ArrayList arraylist = new ArrayList();
                arraylist.addAll(p);
                b.add(arraylist);
                p.clear();
                obj = new h(this, arraylist);
                if (flag)
                {
                    ap.a(((q)arraylist.get(0)).a.a, ((Runnable) (obj)), super.j);
                } else
                {
                    ((Runnable) (obj)).run();
                }
            }
            if (flag2)
            {
                arraylist = new ArrayList();
                arraylist.addAll(q);
                c.add(arraylist);
                q.clear();
                obj = new i(this, arraylist);
                if (flag)
                {
                    ap.a(((p)arraylist.get(0)).a.a, ((Runnable) (obj)), super.j);
                } else
                {
                    ((Runnable) (obj)).run();
                }
            }
            if (flag3)
            {
                arraylist = new ArrayList();
                arraylist.addAll(o);
                a.add(arraylist);
                o.clear();
                obj = new j(this, arraylist);
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
                    ap.a(((bi)arraylist.get(0)).a, ((Runnable) (obj)), l + l1);
                    return;
                } else
                {
                    ((Runnable) (obj)).run();
                    return;
                }
            }
        }
    }

    public final boolean a(bi bi1)
    {
        c(bi1);
        n.add(bi1);
        return true;
    }

    public final boolean a(bi bi1, int l, int i1, int j1, int k1)
    {
        android.view.View view = bi1.a;
        l = (int)((float)l + ap.k(bi1.a));
        i1 = (int)((float)i1 + ap.l(bi1.a));
        c(bi1);
        int l1 = j1 - l;
        int i2 = k1 - i1;
        if (l1 == 0 && i2 == 0)
        {
            e(bi1);
            return false;
        }
        if (l1 != 0)
        {
            ap.a(view, -l1);
        }
        if (i2 != 0)
        {
            ap.b(view, -i2);
        }
        p.add(new q(bi1, l, i1, j1, k1, (byte)0));
        return true;
    }

    public final boolean a(bi bi1, bi bi2, int l, int i1, int j1, int k1)
    {
        float f1 = ap.k(bi1.a);
        float f2 = ap.l(bi1.a);
        float f3 = ap.f(bi1.a);
        c(bi1);
        int l1 = (int)((float)(j1 - l) - f1);
        int i2 = (int)((float)(k1 - i1) - f2);
        ap.a(bi1.a, f1);
        ap.b(bi1.a, f2);
        ap.c(bi1.a, f3);
        if (bi2 != null && bi2.a != null)
        {
            c(bi2);
            ap.a(bi2.a, -l1);
            ap.b(bi2.a, -i2);
            ap.c(bi2.a, 0.0F);
        }
        q.add(new p(bi1, bi2, l, i1, j1, k1, (byte)0));
        return true;
    }

    public final boolean b()
    {
        return !o.isEmpty() || !q.isEmpty() || !p.isEmpty() || !n.isEmpty() || !e.isEmpty() || !f.isEmpty() || !d.isEmpty() || !g.isEmpty() || !b.isEmpty() || !a.isEmpty() || !c.isEmpty();
    }

    public final boolean b(bi bi1)
    {
        c(bi1);
        ap.c(bi1.a, 0.0F);
        o.add(bi1);
        return true;
    }

    final void c()
    {
        if (!b())
        {
            e();
        }
    }

    public final void c(bi bi1)
    {
        android.view.View view = bi1.a;
        ap.o(view).a();
        for (int l = p.size() - 1; l >= 0; l--)
        {
            if (((q)p.get(l)).a == bi1)
            {
                ap.b(view, 0.0F);
                ap.a(view, 0.0F);
                e(bi1);
                p.remove(l);
            }
        }

        a(q, bi1);
        if (n.remove(bi1))
        {
            ap.c(view, 1.0F);
            d(bi1);
        }
        if (o.remove(bi1))
        {
            ap.c(view, 1.0F);
            f(bi1);
        }
        for (int i1 = c.size() - 1; i1 >= 0; i1--)
        {
            ArrayList arraylist = (ArrayList)c.get(i1);
            a(arraylist, bi1);
            if (arraylist.isEmpty())
            {
                c.remove(i1);
            }
        }

        int j1 = b.size() - 1;
label0:
        do
        {
            if (j1 >= 0)
            {
                ArrayList arraylist1 = (ArrayList)b.get(j1);
                int l1 = arraylist1.size() - 1;
                do
                {
label1:
                    {
                        if (l1 >= 0)
                        {
                            if (((q)arraylist1.get(l1)).a != bi1)
                            {
                                break label1;
                            }
                            ap.b(view, 0.0F);
                            ap.a(view, 0.0F);
                            e(bi1);
                            arraylist1.remove(l1);
                            if (arraylist1.isEmpty())
                            {
                                b.remove(j1);
                            }
                        }
                        j1--;
                        continue label0;
                    }
                    l1--;
                } while (true);
            }
            for (int k1 = a.size() - 1; k1 >= 0; k1--)
            {
                ArrayList arraylist2 = (ArrayList)a.get(k1);
                if (!arraylist2.remove(bi1))
                {
                    continue;
                }
                ap.c(view, 1.0F);
                f(bi1);
                if (arraylist2.isEmpty())
                {
                    a.remove(k1);
                }
            }

            f.remove(bi1);
            d.remove(bi1);
            g.remove(bi1);
            e.remove(bi1);
            c();
            return;
        } while (true);
    }

    public final void d()
    {
        for (int l = p.size() - 1; l >= 0; l--)
        {
            q q1 = (q)p.get(l);
            android.view.View view = q1.a.a;
            ap.b(view, 0.0F);
            ap.a(view, 0.0F);
            e(q1.a);
            p.remove(l);
        }

        for (int i1 = n.size() - 1; i1 >= 0; i1--)
        {
            d((bi)n.get(i1));
            n.remove(i1);
        }

        for (int j1 = o.size() - 1; j1 >= 0; j1--)
        {
            bi bi1 = (bi)o.get(j1);
            ap.c(bi1.a, 1.0F);
            f(bi1);
            o.remove(j1);
        }

        for (int k1 = q.size() - 1; k1 >= 0; k1--)
        {
            a((p)q.get(k1));
        }

        q.clear();
        if (!b())
        {
            return;
        }
        for (int l1 = b.size() - 1; l1 >= 0; l1--)
        {
            ArrayList arraylist = (ArrayList)b.get(l1);
            for (int k2 = arraylist.size() - 1; k2 >= 0; k2--)
            {
                q q2 = (q)arraylist.get(k2);
                android.view.View view1 = q2.a.a;
                ap.b(view1, 0.0F);
                ap.a(view1, 0.0F);
                e(q2.a);
                arraylist.remove(k2);
                if (arraylist.isEmpty())
                {
                    b.remove(arraylist);
                }
            }

        }

        for (int i2 = a.size() - 1; i2 >= 0; i2--)
        {
            ArrayList arraylist1 = (ArrayList)a.get(i2);
            for (int l2 = arraylist1.size() - 1; l2 >= 0; l2--)
            {
                bi bi2 = (bi)arraylist1.get(l2);
                ap.c(bi2.a, 1.0F);
                f(bi2);
                arraylist1.remove(l2);
                if (arraylist1.isEmpty())
                {
                    a.remove(arraylist1);
                }
            }

        }

        for (int j2 = c.size() - 1; j2 >= 0; j2--)
        {
            ArrayList arraylist2 = (ArrayList)c.get(j2);
            for (int i3 = arraylist2.size() - 1; i3 >= 0; i3--)
            {
                a((p)arraylist2.get(i3));
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
