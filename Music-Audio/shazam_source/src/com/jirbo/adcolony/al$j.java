// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            al, aj, q, ac, 
//            am

public static final class e
{

    boolean a;
    boolean b;
    String c;
    String d;
    boolean e;
    boolean f;
    double g;
    String h;
    String i;
    String j;
    a k;
     l;
    ArrayList m;
    public  n;
     o;

    final void a()
    {
        aj.a.b("Caching media");
        if (a)
        {
            int i1 = 0;
            while (i1 < n.a.size()) 
            {
                e e1 = n.a(i1);
                if (e1.e && e1.f)
                {
                    int j1 = 0;
                    while (j1 < e1.i.a.size()) 
                    {
                        Object obj = e1.i.a(j1);
                        Object obj1 = ((a) (obj)).r;
                        if (((r) (obj1)).a)
                        {
                            Object obj2 = ((a) (obj1)).b;
                            q.c.c.a(((b) (obj2)).a, ((a) (obj2)).b);
                            ((b) (obj2)).c.b();
                            obj2 = ((b) (obj2)).d;
                            q.c.c.a(((d) (obj2)).e, ((e) (obj2)).f);
                            ((f) (obj2)).l.b();
                            ((b) (obj2)).m.b();
                            ((b) (obj2)).n.b();
                            obj1 = ((b) (obj1)).c;
                            q.c.c.a(((c) (obj1)).a, ((a) (obj1)).b);
                            obj1 = ((b) (obj1)).d;
                            q.c.c.a(((d) (obj1)).e, ((e) (obj1)).f);
                            ((f) (obj1)).l.b();
                            ((b) (obj1)).m.b();
                        }
                        obj1 = ((b) (obj)).q;
                        q.c.c.a(((q) (obj1)).a, ((a) (obj1)).b);
                        q.c.c.a(((b) (obj1)).c, ((c) (obj1)).d);
                        q.c.c.a(((d) (obj1)).e, ((e) (obj1)).f);
                        ((f) (obj1)).h.b();
                        ((b) (obj1)).i.b();
                        ((b) (obj1)).j.b();
                        ((b) (obj1)).k.b();
                        ((b) (obj1)).l.b();
                        ((b) (obj1)).m.b();
                        obj1 = ((b) (obj)).v;
                        q.c.c.a(((v) (obj1)).c, ((c) (obj1)).h);
                        q.c.c.a(((h) (obj1)).g, ((g) (obj1)).i);
                        ((i) (obj1)).k.b();
                        ((b) (obj1)).l.b();
                        obj1 = ((b) (obj)).t;
                        if (((t) (obj1)).d)
                        {
                              = ((d) (obj1)).h;
                            if (.a)
                            {
                                q.c.c.a(.d, .e);
                                .h.b();
                                .i.b();
                                .g.b();
                                .f.b();
                            }
                            obj1 = ((b) (obj1)).i;
                            if (((i) (obj1)).a)
                            {
                                if (((a) (obj1)).f != null)
                                {
                                     1 = ((f) (obj1)).f;
                                    q.c.c.a(1.b, 1.c);
                                }
                                if (((c) (obj1)).h != null)
                                {
                                    ((h) (obj1)).h.b();
                                }
                                if (((b) (obj1)).i != null)
                                {
                                    ((i) (obj1)).i.b();
                                }
                                if (((b) (obj1)).j != null)
                                {
                                    ((j) (obj1)).j.b();
                                }
                            }
                        }
                        obj = ((b) (obj)).u;
                        q.c.c.a(((u) (obj)).d, ((d) (obj)).e);
                        ((e) (obj)).m.b();
                        ((b) (obj)).l.b();
                        obj1 = ((b) (obj)).o;
                        q.c.c.a(((o) (obj1)).b, ((b) (obj1)).c);
                        ((c) (obj)).n.b();
                        j1++;
                    }
                }
                i1++;
            }
        }
    }

    final boolean a(String s, boolean flag, boolean flag1)
    {
        if (a)
        {
            if ((s = n.a(s)) != null)
            {
                return s.a(flag, flag1);
            }
        }
        return false;
    }

    ()
    {
        e = false;
    }
}
