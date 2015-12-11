// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            q, ac, am, aa, 
//            ao, aj, aq, x

final class al
{
    static final class a
    {

        String a;
        String b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        boolean n;
        s o;
        ac p;
        r q;
        h r;
        g s;
        m t;
        b u;
        u v;
        ad w;

        final boolean a()
        {
            r r1 = q;
            boolean flag;
            if (!com.jirbo.adcolony.q.c.c.a(r1.a))
            {
                flag = false;
            } else
            if (!com.jirbo.adcolony.q.c.c.a(r1.c))
            {
                flag = false;
            } else
            if (!com.jirbo.adcolony.q.c.c.a(r1.e))
            {
                flag = false;
            } else
            if (!r1.h.a())
            {
                flag = false;
            } else
            if (!r1.i.a())
            {
                flag = false;
            } else
            if (!r1.j.a())
            {
                flag = false;
            } else
            if (!r1.k.a())
            {
                flag = false;
            } else
            if (!r1.l.a())
            {
                flag = false;
            } else
            if (!r1.m.a())
            {
                flag = false;
            } else
            {
                flag = true;
            }
            if (flag) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            Object obj;
            boolean flag1;
            boolean flag3;
            if (!r.a)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = r;
            Object obj1 = ((h) (obj)).b;
            if (!com.jirbo.adcolony.q.c.c.a(((z) (obj1)).a))
            {
                flag1 = false;
            } else
            if (!((z) (obj1)).c.a())
            {
                flag1 = false;
            } else
            {
                obj1 = ((z) (obj1)).d;
                if (!com.jirbo.adcolony.q.c.c.a(((y) (obj1)).e))
                {
                    flag1 = false;
                } else
                if (!((y) (obj1)).l.a())
                {
                    flag1 = false;
                } else
                if (!((y) (obj1)).m.a())
                {
                    flag1 = false;
                } else
                {
                    flag1 = true;
                }
                if (!flag1)
                {
                    flag1 = false;
                } else
                {
                    flag1 = true;
                }
            }
            if (!flag1)
            {
                flag1 = false;
            } else
            {
                obj = ((h) (obj)).c;
                if (!com.jirbo.adcolony.q.c.c.a(((x) (obj)).a))
                {
                    flag1 = false;
                } else
                if (!((x) (obj)).c.a())
                {
                    flag1 = false;
                } else
                {
                    obj = ((x) (obj)).d;
                    if (!com.jirbo.adcolony.q.c.c.a(((w) (obj)).e))
                    {
                        flag1 = false;
                    } else
                    if (!((w) (obj)).l.a())
                    {
                        flag1 = false;
                    } else
                    if (!((w) (obj)).m.a())
                    {
                        flag1 = false;
                    } else
                    {
                        flag1 = true;
                    }
                    if (!flag1)
                    {
                        flag1 = false;
                    } else
                    {
                        flag1 = true;
                    }
                }
                if (!flag1)
                {
                    flag1 = false;
                } else
                {
                    flag1 = true;
                }
            }
            if (!flag1) goto _L1; else goto _L3
_L3:
            if (!v.a)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = v;
            if (!((u) (obj)).a)
            {
                flag1 = false;
            } else
            if (!com.jirbo.adcolony.q.c.c.a(((u) (obj)).c))
            {
                flag1 = false;
            } else
            if (!com.jirbo.adcolony.q.c.c.a(((u) (obj)).g))
            {
                flag1 = false;
            } else
            if (!((u) (obj)).k.a())
            {
                flag1 = false;
            } else
            if (!((u) (obj)).l.a())
            {
                flag1 = false;
            } else
            {
                flag1 = true;
            }
            if (!flag1) goto _L1; else goto _L4
_L4:
            if (!t.d)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = t;
            if (!((m) (obj)).i.a || ((m) (obj)).i.a()) goto _L6; else goto _L5
_L5:
            flag1 = false;
_L8:
            if (!flag1) goto _L1; else goto _L7
_L7:
            obj = u;
            if (!((b) (obj)).a)
            {
                break MISSING_BLOCK_LABEL_1004;
            }
            aa aa1;
            if (!com.jirbo.adcolony.q.c.c.a(((b) (obj)).d))
            {
                flag3 = false;
            } else
            if (!((b) (obj)).l.a())
            {
                flag3 = false;
            } else
            if (!((b) (obj)).m.a())
            {
                flag3 = false;
            } else
            {
                p p1 = ((b) (obj)).o;
                boolean flag2;
                if (p1.a && !com.jirbo.adcolony.q.c.c.a(p1.b))
                {
                    flag2 = false;
                } else
                {
                    flag2 = true;
                }
                if (!flag2)
                {
                    flag3 = false;
                } else
                if (!((b) (obj)).n.a())
                {
                    flag3 = false;
                } else
                if (com.jirbo.adcolony.q.c.b.j.i.equals("online") && !ao.c())
                {
                    com.jirbo.adcolony.q.T = 9;
                    flag3 = aj.c.b("Video not ready due to VIEW_FILTER_ONLINE");
                } else
                if (com.jirbo.adcolony.q.c.b.j.i.equals("wifi") && !ao.a())
                {
                    com.jirbo.adcolony.q.T = 9;
                    flag3 = aj.c.b("Video not ready due to VIEW_FILTER_WIFI");
                } else
                if (com.jirbo.adcolony.q.c.b.j.i.equals("cell") && !ao.b())
                {
                    com.jirbo.adcolony.q.T = 9;
                    flag3 = aj.c.b("Video not ready due to VIEW_FILTER_CELL");
                } else
                {
                    if (!com.jirbo.adcolony.q.c.b.j.i.equals("offline") || !ao.c())
                    {
                        break MISSING_BLOCK_LABEL_1004;
                    }
                    com.jirbo.adcolony.q.T = 9;
                    flag3 = aj.c.b("Video not ready due to VIEW_FILTER_OFFLINE");
                }
            }
_L10:
            if (flag3)
            {
                return true;
            }
              goto _L1
_L6:
label0:
            {
                if (!((m) (obj)).d)
                {
                    break MISSING_BLOCK_LABEL_730;
                }
                aa1 = ((m) (obj)).h;
                if (!aa1.a)
                {
                    break label0;
                }
                if (!com.jirbo.adcolony.q.c.c.a(aa1.d))
                {
                    flag1 = false;
                } else
                if (!aa1.h.a())
                {
                    flag1 = false;
                } else
                if (!aa1.i.a())
                {
                    flag1 = false;
                } else
                if (!aa1.g.a())
                {
                    flag1 = false;
                } else
                {
                    if (aa1.f.a())
                    {
                        break label0;
                    }
                    flag1 = false;
                }
            }
_L9:
            if (flag1 || ((m) (obj)).i.a())
            {
                break MISSING_BLOCK_LABEL_730;
            }
            flag1 = false;
              goto _L8
            flag1 = true;
              goto _L9
            flag1 = true;
              goto _L8
            flag3 = true;
              goto _L10
        }

        a()
        {
        }
    }

    static final class aa
    {

        boolean a;
        int b;
        int c;
        String d;
        String e;
        l f;
        l g;
        l h;
        l i;

        aa()
        {
        }
    }

    static final class ab
    {

        ArrayList a;
        ArrayList b;
        ArrayList c;
        HashMap d;

        ab()
        {
            a = new ArrayList();
            b = new ArrayList();
            c = new ArrayList();
            d = new HashMap();
        }
    }

    static final class ac
    {

        ArrayList A;
        ArrayList B;
        HashMap C;
        ArrayList a;
        ArrayList b;
        ArrayList c;
        ArrayList d;
        ArrayList e;
        ArrayList f;
        ArrayList g;
        ArrayList h;
        ArrayList i;
        ArrayList j;
        ArrayList k;
        ArrayList l;
        ArrayList m;
        ArrayList n;
        ArrayList o;
        ArrayList p;
        ArrayList q;
        ArrayList r;
        ArrayList s;
        ArrayList t;
        ArrayList u;
        ArrayList v;
        ArrayList w;
        ArrayList x;
        ArrayList y;
        ArrayList z;

        ac()
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
            l = new ArrayList();
            m = new ArrayList();
            n = new ArrayList();
            o = new ArrayList();
            p = new ArrayList();
            q = new ArrayList();
            r = new ArrayList();
            s = new ArrayList();
            t = new ArrayList();
            u = new ArrayList();
            v = new ArrayList();
            w = new ArrayList();
            x = new ArrayList();
            y = new ArrayList();
            z = new ArrayList();
            A = new ArrayList();
            B = new ArrayList();
            C = new HashMap();
        }
    }

    static final class ad
    {

        String a;
        String b;
        boolean c;

        ad()
        {
        }
    }

    static final class ae
    {

        int a;
        int b;
        int c;

        ae()
        {
        }
    }

    static final class b
    {

        boolean a;
        int b;
        int c;
        String d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        double k;
        l l;
        l m;
        l n;
        p o;

        final String a()
        {
            return com.jirbo.adcolony.q.c.c.b(d);
        }

        b()
        {
        }
    }

    public static final class c
    {

        String a;
        int b;
        int c;
        int d;
        public boolean e;
        public boolean f;
        ArrayList g;
        d h;
        i i;
        e j;
        com.jirbo.adcolony.x k;

        private static int a(int i1, int j1)
        {
            int k1;
            if (j1 <= 0)
            {
                k1 = 0;
            } else
            {
                k1 = j1;
                if (i1 != -1)
                {
                    k1 = j1;
                    if (i1 < j1)
                    {
                        return i1;
                    }
                }
            }
            return k1;
        }

        private int a(a a1)
        {
            int i1 = -1;
            this;
            JVM INSTR monitorenter ;
            int j1;
            int k1;
            k1 = com.jirbo.adcolony.q.c.h.a(a, 86400D);
            j1 = a1.o.g;
            if (j1 == 0) goto _L2; else goto _L1
_L1:
            if (com.jirbo.adcolony.q.S == 0L || (System.currentTimeMillis() - com.jirbo.adcolony.q.S) / 1000L < (long)j1) goto _L2; else goto _L3
_L3:
            c();
            com.jirbo.adcolony.q.T = 7;
            i1 = aj.c.c("The volatile expiration for this ad has been hit.");
_L5:
            this;
            JVM INSTR monitorexit ;
            return i1;
_L2:
            j1 = a1.o.h;
            if (j1 <= 0)
            {
                break MISSING_BLOCK_LABEL_124;
            }
            i1 = a(-1, j1 - com.jirbo.adcolony.q.c.h.a(a1.d, (System.currentTimeMillis() - com.jirbo.adcolony.q.S) / 1000L));
            if (i1 != 0 || j1 == 0)
            {
                break MISSING_BLOCK_LABEL_152;
            }
            c();
            com.jirbo.adcolony.q.T = 7;
            i1 = aj.c.c("Ad is not ready to be played due to the volatile play cap.");
            continue; /* Loop/switch isn't completed */
            int l1 = c;
            j1 = i1;
            if (l1 <= 0)
            {
                break MISSING_BLOCK_LABEL_175;
            }
            j1 = a(i1, l1 - k1);
            if (j1 != 0)
            {
                break MISSING_BLOCK_LABEL_212;
            }
            com.jirbo.adcolony.q.T = 5;
            i1 = aj.c.c((new StringBuilder("Ad is not ready to be played due to the daily play cap for zone ")).append(a).toString());
            continue; /* Loop/switch isn't completed */
            l1 = d;
            i1 = j1;
            if (l1 <= 0)
            {
                break MISSING_BLOCK_LABEL_246;
            }
            i1 = a(j1, l1 - com.jirbo.adcolony.q.c.h.a(a));
            if (i1 != 0)
            {
                break MISSING_BLOCK_LABEL_283;
            }
            com.jirbo.adcolony.q.T = 3;
            i1 = aj.c.c((new StringBuilder("Ad is not ready to be played due to the session play cap for zone ")).append(a).toString());
            continue; /* Loop/switch isn't completed */
            j1 = i1;
            if (!j.a)
            {
                break MISSING_BLOCK_LABEL_421;
            }
            l1 = j.b.a;
            j1 = i1;
            if (l1 <= 0)
            {
                break MISSING_BLOCK_LABEL_324;
            }
            j1 = a(i1, l1 - k1);
            if (j1 != 0)
            {
                break MISSING_BLOCK_LABEL_344;
            }
            com.jirbo.adcolony.q.T = 4;
            i1 = aj.c.c("Ad is not ready to be played due to the V4VC daily play cap.");
            continue; /* Loop/switch isn't completed */
            k1 = j.b.c;
            l1 = j.b.b;
            i1 = j1;
            if (l1 <= 0)
            {
                break MISSING_BLOCK_LABEL_399;
            }
            i1 = a(j1, l1 - com.jirbo.adcolony.q.c.h.a(a, k1));
            j1 = i1;
            if (i1 != 0)
            {
                break MISSING_BLOCK_LABEL_421;
            }
            com.jirbo.adcolony.q.T = 4;
            i1 = aj.c.c("Ad is not ready to be played due to the V4VC custom play cap.");
            continue; /* Loop/switch isn't completed */
            k1 = a1.d;
            l1 = a1.o.a;
            i1 = j1;
            if (l1 <= 0)
            {
                break MISSING_BLOCK_LABEL_465;
            }
            i1 = a(j1, l1 - com.jirbo.adcolony.q.c.h.a(k1, 86400D));
            if (i1 != 0)
            {
                break MISSING_BLOCK_LABEL_489;
            }
            com.jirbo.adcolony.q.T = 7;
            c();
            i1 = aj.c.c("Ad is not ready to be played due to the daily play cap.");
            continue; /* Loop/switch isn't completed */
            l1 = a1.o.f;
            j1 = i1;
            if (l1 <= 0)
            {
                break MISSING_BLOCK_LABEL_527;
            }
            j1 = a(i1, l1 - com.jirbo.adcolony.q.c.h.a(k1, 604800D));
            if (j1 != 0)
            {
                break MISSING_BLOCK_LABEL_551;
            }
            com.jirbo.adcolony.q.T = 7;
            c();
            i1 = aj.c.c("Ad is not ready to be played due to the weekly play cap.");
            continue; /* Loop/switch isn't completed */
            l1 = a1.o.e;
            i1 = j1;
            if (l1 <= 0)
            {
                break MISSING_BLOCK_LABEL_589;
            }
            i1 = a(j1, l1 - com.jirbo.adcolony.q.c.h.a(k1, 2628000D));
            if (i1 != 0)
            {
                break MISSING_BLOCK_LABEL_613;
            }
            com.jirbo.adcolony.q.T = 7;
            c();
            i1 = aj.c.c("Ad is not ready to be played due to the monthly play cap.");
            continue; /* Loop/switch isn't completed */
            l1 = a1.o.d;
            j1 = i1;
            if (l1 <= 0)
            {
                break MISSING_BLOCK_LABEL_651;
            }
            j1 = a(i1, l1 - com.jirbo.adcolony.q.c.h.a(k1, 15768000D));
            if (j1 != 0)
            {
                break MISSING_BLOCK_LABEL_675;
            }
            com.jirbo.adcolony.q.T = 7;
            c();
            i1 = aj.c.c("Ad is not ready to be played due to the half-year play cap.");
            continue; /* Loop/switch isn't completed */
            int i2;
            l1 = a1.o.c;
            i2 = a1.o.b;
            i1 = j1;
            if (i2 <= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            i1 = a(j1, i2 - com.jirbo.adcolony.q.c.h.a(k1, l1));
            if (true) goto _L5; else goto _L4
_L4:
            a1;
            throw a1;
        }

        private static void c()
        {
            com.jirbo.adcolony.q.c.b.a();
        }

        final a a()
        {
            if (g.size() > 0)
            {
                i i1 = i;
                String s1 = (String)g.get(k.c % g.size());
                for (int j1 = 0; j1 < i1.a.size(); j1++)
                {
                    a a1 = (a)i1.a.get(j1);
                    if (a1.a.equals(s1))
                    {
                        return a1;
                    }
                }

                return null;
            } else
            {
                return null;
            }
        }

        final boolean a(boolean flag)
        {
            if (!flag)
            {
                while (!e || !f || i.a.size() == 0 || i.a().r.a) 
                {
                    return false;
                }
                return true;
            }
            if (!e || !f)
            {
                com.jirbo.adcolony.q.T = 1;
                return aj.c.b((new StringBuilder("Ad is not ready, as zone ")).append(a).append(" is disabled or inactive.").toString());
            }
            if (i.a.size() == 0)
            {
                com.jirbo.adcolony.q.T = 5;
                return aj.c.b((new StringBuilder("Ad is not ready, as there are currently no ads to play in zone ")).append(a).append(".").toString());
            }
            if (i.a().r.a)
            {
                com.jirbo.adcolony.q.T = 14;
                return aj.c.b((new StringBuilder("Ad is not ready, as zone ")).append(a).append(" is V4VC enabled and must be played using an AdColonyV4VCAd object.").toString());
            } else
            {
                return true;
            }
        }

        final boolean a(boolean flag, boolean flag1)
        {
_L2:
            int i1;
            int j1;
            do
            {
                return false;
            } while (!e || !f || i.a.size() == 0 || g.size() == 0);
            j1 = g.size();
            i1 = 0;
_L4:
            a1 = obj;
            if (i1 >= j1)
            {
                continue; /* Loop/switch isn't completed */
            }
            a1 = a();
            if (a1 == null) goto _L2; else goto _L1
_L1:
            if (!a1.a())
            {
                break MISSING_BLOCK_LABEL_105;
            }
            if (a1 == null || a(a1) == 0) goto _L2; else goto _L3
_L3:
            return true;
            b();
            i1++;
              goto _L4
            Object obj = null;
            a a1;
            if (!flag1)
            {
                if (!flag)
                {
                    com.jirbo.adcolony.q.f();
                }
                break MISSING_BLOCK_LABEL_14;
            }
            if (!e || !f)
            {
                com.jirbo.adcolony.q.T = 1;
                return aj.c.b((new StringBuilder("Ad is not ready to be played, as zone ")).append(a).append(" is disabled or inactive.").toString());
            }
            if (i.a.size() == 0 || g.size() == 0)
            {
                com.jirbo.adcolony.q.T = 5;
                return aj.c.b((new StringBuilder("Ad is not ready to be played, as AdColony currently has no videos available to be played in zone ")).append(a).append(".").toString());
            }
            j1 = g.size();
            i1 = 0;
_L7:
            a a2;
            if (i1 >= j1)
            {
                break MISSING_BLOCK_LABEL_310;
            }
            a2 = a();
            if (a2 == null)
            {
                return aj.c.b("Ad is not ready to be played due to an unknown error.");
            }
            if (!a2.a()) goto _L6; else goto _L5
_L5:
            if (a2 == null)
            {
                com.jirbo.adcolony.q.T = 6;
                return aj.c.b("Ad is not ready to be played as required assets are still downloading or otherwise missing.");
            }
            continue; /* Loop/switch isn't completed */
_L6:
            b();
            i1++;
              goto _L7
            if (a(a2) == 0) goto _L2; else goto _L8
_L8:
            return true;
            a2 = null;
              goto _L5
        }

        final void b()
        {
            if (g.size() > 0)
            {
                k.c = (k.c + 1) % g.size();
            }
        }

        final boolean b(boolean flag)
        {
            boolean flag1 = true;
            if (flag) goto _L2; else goto _L1
_L1:
            if (e && f) goto _L4; else goto _L3
_L3:
            flag = false;
_L6:
            return flag;
_L4:
            if (i.a.size() == 0)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (i.a().r.a) goto _L6; else goto _L5
_L5:
            return false;
_L2:
            if (!e || !f)
            {
                com.jirbo.adcolony.q.T = 1;
                return aj.c.b((new StringBuilder("Ad is not ready, as zone ")).append(a).append(" is disabled or inactive.").toString());
            }
            if (i.a.size() == 0)
            {
                com.jirbo.adcolony.q.T = 5;
                return aj.c.b((new StringBuilder("Ad is not ready, as there are currently no ads to play in zone ")).append(a).append(".").toString());
            }
            flag = flag1;
            if (!i.a().r.a)
            {
                com.jirbo.adcolony.q.T = 15;
                return aj.c.b((new StringBuilder("Ad is not ready, as zone ")).append(a).append(" is not V4VC enabled and must be played using an AdColonyVideoAd object.").toString());
            }
            if (true) goto _L6; else goto _L7
_L7:
        }

        c()
        {
        }
    }

    static final class d
    {

        String a;

        d()
        {
        }
    }

    static final class e
    {

        boolean a;
        ae b;
        int c;
        String d;
        boolean e;
        int f;

        e()
        {
        }
    }

    public static final class f
    {

        ArrayList a;

        final c a(int i1)
        {
            return (c)a.get(i1);
        }

        public final c a(String s1)
        {
            for (int i1 = 0; i1 < a.size(); i1++)
            {
                c c1 = (c)a.get(i1);
                if (c1.a.equals(s1))
                {
                    return c1;
                }
            }

            aj.a.a("No such zone: ").b(s1);
            return null;
        }

        f()
        {
        }
    }

    static final class g
    {

        String A;
        String B;
        String C;
        a.g D;
        String a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        String l;
        String m;
        String n;
        String o;
        String p;
        String q;
        String r;
        String s;
        String t;
        String u;
        String v;
        String w;
        String x;
        String y;
        String z;

        g()
        {
            D = new a.g();
        }
    }

    static final class h
    {

        boolean a;
        z b;
        x c;

        h()
        {
        }
    }

    static final class i
    {

        ArrayList a;

        final a a()
        {
            return (a)a.get(0);
        }

        final a a(int i1)
        {
            return (a)a.get(i1);
        }

        final boolean a(a.c c1)
        {
            if (c1 != null) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            a a1;
            a.g g1;
            boolean flag;
            int i1;
            for (i1 = 0; i1 >= c1.a.size();)
            {
                break MISSING_BLOCK_LABEL_5117;
            }

            a1 = new a();
            g1 = c1.a(i1);
            if (g1 == null)
            {
                flag = false;
            } else
            {
                a1.a = g1.a("uuid", "");
                a1.b = g1.a("title", "");
                a1.c = g1.e("ad_campaign_id");
                a1.d = g1.e("ad_id");
                a1.e = g1.e("ad_group_id");
                a1.f = g1.e("cpcv_bid");
                a1.g = g1.e("net_earnings");
                a1.h = g1.e("expires");
                a1.i = g1.a("enable_in_app_store", false);
                a1.j = g1.a("video_events_on_replays", false);
                a1.k = g1.a("test_ad", false);
                a1.l = g1.a("fullscreen", false);
                a1.m = g1.a("house_ad", false);
                a1.n = g1.a("contracted", false);
                a1.o = new s();
                s s1 = a1.o;
                a.g g4 = g1.a("limits");
                if (g4 == null)
                {
                    flag = false;
                } else
                {
                    s1.a = g4.e("daily_play_cap");
                    s1.b = g4.e("custom_play_cap");
                    s1.c = g4.e("custom_play_cap_period");
                    s1.d = g4.e("total_play_cap");
                    s1.e = g4.e("monthly_play_cap");
                    s1.f = g4.e("weekly_play_cap");
                    s1.g = g4.e("volatile_expiration");
                    s1.h = g4.e("volatile_play_cap");
                    flag = true;
                }
                if (!flag)
                {
                    flag = false;
                } else
                {
                    a1.p = new ac();
                    ac ac1 = a1.p;
                    a.g g5 = g1.a("third_party_tracking");
                    if (g5 == null)
                    {
                        flag = false;
                    } else
                    {
                        ac1.a = g5.c("replay");
                        ac1.b = g5.c("card_shown");
                        ac1.c = g5.c("html5_interaction");
                        ac1.d = g5.c("cancel");
                        ac1.e = g5.c("download");
                        ac1.f = g5.c("skip");
                        ac1.g = g5.c("info");
                        ac1.h = g5.c("midpoint");
                        ac1.i = g5.c("card_dissolved");
                        ac1.j = g5.c("start");
                        ac1.k = g5.c("third_quartile");
                        ac1.l = g5.c("complete");
                        ac1.m = g5.c("continue");
                        ac1.n = g5.c("in_video_engagement");
                        ac1.o = g5.c("reward_v4vc");
                        ac1.p = g5.c("first_quartile");
                        ac1.q = g5.c("v4iap");
                        ac1.r = g5.c("video_expanded");
                        ac1.s = g5.c("sound_mute");
                        ac1.t = g5.c("sound_unmute");
                        ac1.u = g5.c("video_paused");
                        ac1.v = g5.c("video_resumed");
                        ac1.w = g5.c("native_start");
                        ac1.x = g5.c("native_first_quartile");
                        ac1.y = g5.c("native_midpoint");
                        ac1.z = g5.c("native_third_quartile");
                        ac1.A = g5.c("native_complete");
                        ac1.B = g5.c("native_overlay_click");
                        ac1.C.put("replay", ac1.a);
                        ac1.C.put("card_shown", ac1.b);
                        ac1.C.put("html5_interaction", ac1.c);
                        ac1.C.put("cancel", ac1.d);
                        ac1.C.put("download", ac1.e);
                        ac1.C.put("skip", ac1.f);
                        ac1.C.put("info", ac1.g);
                        ac1.C.put("midpoint", ac1.h);
                        ac1.C.put("card_dissolved", ac1.i);
                        ac1.C.put("start", ac1.j);
                        ac1.C.put("third_quartile", ac1.k);
                        ac1.C.put("complete", ac1.l);
                        ac1.C.put("continue", ac1.m);
                        ac1.C.put("in_video_engagement", ac1.n);
                        ac1.C.put("reward_v4vc", ac1.o);
                        ac1.C.put("first_quartile", ac1.p);
                        ac1.C.put("v4iap", ac1.q);
                        ac1.C.put("video_expanded", ac1.r);
                        ac1.C.put("sound_mute", ac1.s);
                        ac1.C.put("sound_unmute", ac1.t);
                        ac1.C.put("video_paused", ac1.u);
                        ac1.C.put("video_resumed", ac1.v);
                        ac1.C.put("native_start", ac1.w);
                        ac1.C.put("native_first_quartile", ac1.x);
                        ac1.C.put("native_midpoint", ac1.y);
                        ac1.C.put("native_third_quartile", ac1.z);
                        ac1.C.put("native_complete", ac1.A);
                        ac1.C.put("native_overlay_click", ac1.B);
                        flag = true;
                    }
                    if (!flag)
                    {
                        flag = false;
                    } else
                    {
                        a1.q = new r();
                        r r1 = a1.q;
                        a.g g6 = g1.a("in_app_browser");
                        if (g6 == null)
                        {
                            flag = false;
                        } else
                        {
                            r1.a = g6.a("tiny_glow_image", "");
                            r1.b = g6.a("tiny_glow_image_last_modified;", "");
                            r1.c = g6.a("background_bar_image", "");
                            r1.d = g6.a("background_bar_image_last_modified", "");
                            r1.e = g6.a("background_tile_image", "");
                            r1.f = g6.a("background_tile_image_last_modified", "");
                            r1.g = g6.a("background_color", "");
                            r1.h = new q();
                            if (!r1.h.a(g6.a("logo")))
                            {
                                flag = false;
                            } else
                            {
                                r1.h = new q();
                                if (!r1.h.a(g6.a("logo")))
                                {
                                    flag = false;
                                } else
                                {
                                    r1.i = new l();
                                    if (!r1.i.a(g6.a("stop")))
                                    {
                                        flag = false;
                                    } else
                                    {
                                        r1.j = new l();
                                        if (!r1.j.a(g6.a("back")))
                                        {
                                            flag = false;
                                        } else
                                        {
                                            r1.k = new l();
                                            if (!r1.k.a(g6.a("close")))
                                            {
                                                flag = false;
                                            } else
                                            {
                                                r1.l = new l();
                                                if (!r1.l.a(g6.a("forward")))
                                                {
                                                    flag = false;
                                                } else
                                                {
                                                    r1.m = new l();
                                                    if (!r1.m.a(g6.a("reload")))
                                                    {
                                                        flag = false;
                                                    } else
                                                    {
                                                        flag = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (!flag)
                        {
                            flag = false;
                        } else
                        {
label0:
                            {
                                a1.v = new u();
                                Object obj1 = a1.v;
                                a.g g2 = g1.a("native");
                                if (g2 == null)
                                {
                                    flag = false;
                                } else
                                {
                                    obj1.a = g2.a("enabled", false);
                                    obj1.c = g2.a("poster_image", "");
                                    obj1.d = g2.a("advertiser_name", "");
                                    obj1.e = g2.a("description", "");
                                    obj1.f = g2.a("title", "");
                                    obj1.g = g2.a("thumb_image", "");
                                    obj1.h = g2.a("poster_image_last_modified", "");
                                    obj1.i = g2.a("thumb_image_last_modified", "");
                                    obj1.k = new q();
                                    if (!((u) (obj1)).k.a(g2.a("mute")))
                                    {
                                        flag = false;
                                    } else
                                    {
                                        obj1.b = ((u) (obj1)).k.f;
                                        obj1.l = new q();
                                        if (!((u) (obj1)).l.a(g2.a("unmute")))
                                        {
                                            flag = false;
                                        } else
                                        {
                                            obj1.j = new v();
                                            obj1 = ((u) (obj1)).j;
                                            g2 = g2.a("overlay");
                                            if (g2 == null)
                                            {
                                                flag = false;
                                            } else
                                            {
                                                obj1.a = g2.a("enabled", false);
                                                if (!((v) (obj1)).a)
                                                {
                                                    flag = true;
                                                } else
                                                {
                                                    obj1.b = g2.a("in_app", false);
                                                    obj1.c = g2.a("click_action_type", "");
                                                    obj1.e = g2.a("click_action", "");
                                                    obj1.d = g2.a("label", "");
                                                    flag = true;
                                                }
                                            }
                                            if (!flag)
                                            {
                                                flag = false;
                                            } else
                                            {
                                                flag = true;
                                            }
                                        }
                                    }
                                }
                                if (flag)
                                {
                                    break label0;
                                }
                                flag = false;
                            }
                        }
                    }
                }
            }
_L4:
            if (!flag) goto _L1; else goto _L3
_L3:
            a.add(a1);
            i1++;
              goto _L2
            a1.r = new h();
            Object obj2 = a1.r;
            a.g g3 = g1.a("v4vc");
            if (g3 == null)
            {
                flag = false;
            } else
            {
                obj2.a = g3.a("enabled", false);
                if (!((h) (obj2)).a)
                {
                    break MISSING_BLOCK_LABEL_2902;
                }
                obj2.b = new z();
                Object obj4 = ((h) (obj2)).b;
                a.g g8 = g3.a("pre_popup");
                obj4.a = g8.a("background_image", "");
                obj4.b = g8.a("background_image_last_modified", "");
                obj4.c = new q();
                if (!((z) (obj4)).c.a(g8.a("background_logo")))
                {
                    flag = false;
                } else
                {
                    obj4.d = new y();
                    obj4 = ((z) (obj4)).d;
                    g8 = g8.a("dialog");
                    obj4.a = g8.e("scale");
                    obj4.b = g8.a("label_reward", "");
                    obj4.c = g8.e("width");
                    obj4.d = g8.e("height");
                    obj4.e = g8.a("image", "");
                    obj4.f = g8.a("image_last_modified", "");
                    obj4.g = g8.a("label", "");
                    obj4.h = g8.a("label_rgba", "");
                    obj4.i = g8.a("label_shadow_rgba", "");
                    obj4.j = g8.a("label_fraction", "");
                    obj4.k = g8.a("label_html", "");
                    obj4.l = new q();
                    if (!((y) (obj4)).l.a(g8.a("logo")))
                    {
                        flag = false;
                    } else
                    {
                        obj4.m = new l();
                        if (!((y) (obj4)).m.a(g8.a("option_yes")))
                        {
                            flag = false;
                        } else
                        {
                            obj4.n = new l();
                            if (!((y) (obj4)).n.a(g8.a("option_no")))
                            {
                                flag = false;
                            } else
                            {
                                flag = true;
                            }
                        }
                    }
                    if (!flag)
                    {
                        flag = false;
                    } else
                    {
                        flag = true;
                    }
                }
                if (!flag)
                {
                    flag = false;
                } else
                {
                    obj2.c = new x();
                    obj2 = ((h) (obj2)).c;
                    g3 = g3.a("post_popup");
                    obj2.a = g3.a("background_image", "");
                    obj2.b = g3.a("background_image_last_modified", "");
                    obj2.c = new q();
                    if (!((x) (obj2)).c.a(g3.a("background_logo")))
                    {
                        flag = false;
                    } else
                    {
                        obj2.d = new w();
                        obj2 = ((x) (obj2)).d;
                        g3 = g3.a("dialog");
                        obj2.a = g3.e("scale");
                        obj2.b = g3.a("label_reward", "");
                        obj2.c = g3.e("width");
                        obj2.d = g3.e("height");
                        obj2.e = g3.a("image", "");
                        obj2.f = g3.a("image_last_modified", "");
                        obj2.g = g3.a("label", "");
                        obj2.h = g3.a("label_rgba", "");
                        obj2.i = g3.a("label_shadow_rgba", "");
                        obj2.j = g3.a("label_fraction", "");
                        obj2.k = g3.a("label_html", "");
                        obj2.l = new q();
                        if (!((w) (obj2)).l.a(g3.a("logo")))
                        {
                            flag = false;
                        } else
                        {
                            obj2.m = new l();
                            if (!((w) (obj2)).m.a(g3.a("option_done")))
                            {
                                flag = false;
                            } else
                            {
                                flag = true;
                            }
                        }
                        if (!flag)
                        {
                            flag = false;
                        } else
                        {
                            flag = true;
                        }
                    }
                    if (flag)
                    {
                        break MISSING_BLOCK_LABEL_2902;
                    }
                    flag = false;
                }
            }
_L5:
            if (flag)
            {
                break MISSING_BLOCK_LABEL_2908;
            }
            flag = false;
              goto _L4
            flag = true;
              goto _L5
            Object obj;
            Object obj3;
            a1.s = new g();
            obj = a1.s;
            obj3 = g1.a("ad_tracking");
            if (obj3 != null)
            {
                obj.a = ((a.g) (obj3)).a("replay", null);
                obj.b = ((a.g) (obj3)).a("card_shown", null);
                obj.c = ((a.g) (obj3)).a("html5_interaction", null);
                obj.d = ((a.g) (obj3)).a("cancel", null);
                obj.e = ((a.g) (obj3)).a("download", null);
                obj.f = ((a.g) (obj3)).a("skip", null);
                obj.g = ((a.g) (obj3)).a("info", null);
                obj.h = ((a.g) (obj3)).a("custom_event", null);
                obj.i = ((a.g) (obj3)).a("midpoint", null);
                obj.j = ((a.g) (obj3)).a("card_dissolved", null);
                obj.k = ((a.g) (obj3)).a("start", null);
                obj.l = ((a.g) (obj3)).a("third_quartile", null);
                obj.m = ((a.g) (obj3)).a("complete", null);
                obj.n = ((a.g) (obj3)).a("continue", null);
                obj.o = ((a.g) (obj3)).a("in_video_engagement", null);
                obj.p = ((a.g) (obj3)).a("reward_v4vc", null);
                obj.r = ((a.g) (obj3)).a("first_quartile", null);
                obj.q = ((a.g) (obj3)).a("v4iap", null);
                obj.s = ((a.g) (obj3)).a("video_expanded", null);
                obj.t = ((a.g) (obj3)).a("sound_mute", null);
                obj.u = ((a.g) (obj3)).a("sound_unmute", null);
                obj.v = ((a.g) (obj3)).a("video_paused", null);
                obj.w = ((a.g) (obj3)).a("video_resumed", null);
                obj.x = ((a.g) (obj3)).a("native_start", null);
                obj.y = ((a.g) (obj3)).a("native_first_quartile", null);
                obj.z = ((a.g) (obj3)).a("native_midpoint", null);
                obj.A = ((a.g) (obj3)).a("native_third_quartile", null);
                obj.B = ((a.g) (obj3)).a("native_complete", null);
                obj.C = ((a.g) (obj3)).a("native_overlay_click", null);
                ((g) (obj)).D.b("replay", ((g) (obj)).a);
                ((g) (obj)).D.b("card_shown", ((g) (obj)).b);
                ((g) (obj)).D.b("html5_interaction", ((g) (obj)).c);
                ((g) (obj)).D.b("cancel", ((g) (obj)).d);
                ((g) (obj)).D.b("download", ((g) (obj)).e);
                ((g) (obj)).D.b("skip", ((g) (obj)).f);
                ((g) (obj)).D.b("info", ((g) (obj)).g);
                ((g) (obj)).D.b("custom_event", ((g) (obj)).h);
                ((g) (obj)).D.b("midpoint", ((g) (obj)).i);
                ((g) (obj)).D.b("card_dissolved", ((g) (obj)).j);
                ((g) (obj)).D.b("start", ((g) (obj)).k);
                ((g) (obj)).D.b("third_quartile", ((g) (obj)).l);
                ((g) (obj)).D.b("complete", ((g) (obj)).m);
                ((g) (obj)).D.b("continue", ((g) (obj)).n);
                ((g) (obj)).D.b("in_video_engagement", ((g) (obj)).o);
                ((g) (obj)).D.b("reward_v4vc", ((g) (obj)).p);
                ((g) (obj)).D.b("first_quartile", ((g) (obj)).r);
                ((g) (obj)).D.b("v4iap", ((g) (obj)).q);
                ((g) (obj)).D.b("video_expanded", ((g) (obj)).s);
                ((g) (obj)).D.b("sound_mute", ((g) (obj)).t);
                ((g) (obj)).D.b("sound_unmute", ((g) (obj)).u);
                ((g) (obj)).D.b("video_paused", ((g) (obj)).v);
                ((g) (obj)).D.b("video_resumed", ((g) (obj)).w);
                ((g) (obj)).D.b("native_start", ((g) (obj)).x);
                ((g) (obj)).D.b("native_first_quartile", ((g) (obj)).y);
                ((g) (obj)).D.b("native_midpoint", ((g) (obj)).z);
                ((g) (obj)).D.b("native_third_quartile", ((g) (obj)).A);
                ((g) (obj)).D.b("native_complete", ((g) (obj)).B);
                ((g) (obj)).D.b("native_overlay_click", ((g) (obj)).C);
            }
            a1.t = new m();
            obj3 = a1.t;
            obj = g1.a("companion_ad");
            if (obj != null) goto _L7; else goto _L6
_L6:
            flag = false;
_L8:
            if (flag)
            {
                break MISSING_BLOCK_LABEL_4573;
            }
            flag = false;
              goto _L4
_L7:
            obj3.d = ((a.g) (obj)).a("enabled", false);
            if (!((m) (obj3)).d)
            {
                break MISSING_BLOCK_LABEL_4567;
            }
            obj3.a = ((a.g) (obj)).a("uuid", "");
            obj3.b = ((a.g) (obj)).e("ad_id");
            obj3.c = ((a.g) (obj)).e("ad_campaign_id");
            obj3.e = ((a.g) (obj)).a("dissolve", false);
            obj3.f = ((a.g) (obj)).a("enable_in_app_store", false);
            obj3.g = ((a.g) (obj)).d("dissolve_delay");
            obj3.h = new aa();
            aa aa1 = ((m) (obj3)).h;
            a.g g9 = ((a.g) (obj)).a("static");
            if (g9 == null)
            {
                flag = false;
            } else
            {
label1:
                {
                    aa1.a = g9.a("enabled", false);
                    if (!aa1.a)
                    {
                        break label1;
                    }
                    aa1.b = g9.e("width");
                    aa1.c = g9.e("height");
                    aa1.d = g9.a("background_image", "");
                    aa1.e = g9.a("background_image_last_modified", "");
                    if (com.jirbo.adcolony.q.b != null)
                    {
                        aa1.d = com.jirbo.adcolony.q.b;
                    }
                    aa1.h = new l();
                    if (!aa1.h.a(g9.a("replay")))
                    {
                        flag = false;
                    } else
                    {
                        aa1.i = new l();
                        if (!aa1.i.a(g9.a("continue")))
                        {
                            flag = false;
                        } else
                        {
                            aa1.g = new l();
                            if (!aa1.g.a(g9.a("download")))
                            {
                                flag = false;
                            } else
                            {
                                aa1.f = new l();
                                if (aa1.f.a(g9.a("info")))
                                {
                                    break label1;
                                }
                                flag = false;
                            }
                        }
                    }
                }
            }
_L9:
            if (!flag)
            {
                flag = false;
            } else
            {
                obj3.i = new o();
                obj3 = ((m) (obj3)).i;
                obj = ((a.g) (obj)).a("html5");
                if (obj == null)
                {
                    flag = false;
                } else
                {
                    obj3.a = ((a.g) (obj)).a("enabled", false);
                    obj3.b = ((a.g) (obj)).d("load_timeout");
                    obj3.c = ((a.g) (obj)).a("load_timeout_enabled", false);
                    obj3.d = ((a.g) (obj)).a("load_spinner_enabled", false);
                    obj3.e = ((a.g) (obj)).a("background_color", "");
                    obj3.g = ((a.g) (obj)).a("html5_tag", "");
                    obj3.f = new t();
                    t t1 = ((o) (obj3)).f;
                    a.g g10 = ((a.g) (obj)).a("mraid_js");
                    if (g10 == null)
                    {
                        flag = false;
                    } else
                    {
                        t1.a = g10.a("enabled", false);
                        if (!t1.a)
                        {
                            flag = true;
                        } else
                        {
                            t1.b = g10.a("url", "");
                            t1.c = g10.a("last_modified", "");
                            flag = true;
                        }
                    }
                    if (!flag)
                    {
                        flag = false;
                    } else
                    {
                        obj3.h = new q();
                        if (!((o) (obj3)).h.a(((a.g) (obj)).a("background_logo")))
                        {
                            flag = false;
                        } else
                        {
                            obj3.i = new l();
                            if (!((o) (obj3)).i.a(((a.g) (obj)).a("replay")))
                            {
                                flag = false;
                            } else
                            {
                                obj3.j = new l();
                                if (!((o) (obj3)).j.a(((a.g) (obj)).a("close")))
                                {
                                    flag = false;
                                } else
                                {
                                    flag = true;
                                }
                            }
                        }
                    }
                }
                if (flag)
                {
                    break MISSING_BLOCK_LABEL_4567;
                }
                flag = false;
            }
              goto _L8
            flag = true;
              goto _L9
            flag = true;
              goto _L8
            a1.u = new b();
            b b1 = a1.u;
            a.g g7 = g1.a("video");
            if (g7 == null)
            {
                flag = false;
            } else
            {
label2:
                {
                    b1.a = g7.a("enabled", false);
                    if (!b1.a)
                    {
                        break label2;
                    }
                    b1.b = g7.e("width");
                    b1.c = g7.e("height");
                    b1.d = g7.a("url", "");
                    b1.e = g7.a("last_modified", "");
                    b1.f = g7.a("video_frame_rate", "");
                    b1.g = g7.a("audio_channels", "");
                    b1.h = g7.a("audio_codec", "");
                    b1.i = g7.a("audio_sample_rate", "");
                    b1.j = g7.a("video_codec", "");
                    b1.k = g7.d("duration");
                    b1.l = new l();
                    if (!b1.l.a(g7.a("skip_video")))
                    {
                        flag = false;
                    } else
                    {
                        b1.m = new l();
                        if (!b1.m.a(g7.a("in_video_engagement")))
                        {
                            flag = false;
                        } else
                        {
                            b1.o = new p();
                            p p1 = b1.o;
                            a.g g11 = g7.a("haptic");
                            if (g11 == null)
                            {
                                flag = false;
                            } else
                            {
                                p1.a = g11.a("enabled", false);
                                p1.b = g11.a("file_url", "");
                                p1.c = g11.a("last_modified", "");
                                flag = true;
                            }
                            if (!flag)
                            {
                                flag = false;
                            } else
                            {
                                b1.n = new l();
                                if (b1.n.a(g7.a("in_video_engagement").a("image_overlay")))
                                {
                                    break label2;
                                }
                                flag = false;
                            }
                        }
                    }
                }
            }
_L10:
            if (!flag)
            {
                flag = false;
            } else
            {
                a1.w = new ad();
                ad ad1 = a1.w;
                g1 = g1.a("v4iap");
                if (g1 == null)
                {
                    flag = false;
                } else
                {
                    ad1.c = g1.a("enabled", false);
                    if (!ad1.c)
                    {
                        flag = true;
                    } else
                    {
                        ad1.a = (String)g1.c("product_ids").get(0);
                        ad1.b = g1.a("in_progress", "");
                        flag = true;
                    }
                }
                if (!flag)
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
            }
              goto _L4
            flag = true;
              goto _L10
            return true;
              goto _L2
        }

        i()
        {
            a = new ArrayList();
        }
    }

    public static final class j
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
        k k;
        ab l;
        ArrayList m;
        public f n;
        n o;

        final void a()
        {
            aj.a.b("Caching media");
            if (a)
            {
                int i1 = 0;
                while (i1 < n.a.size()) 
                {
                    c c1 = n.a(i1);
                    if (c1.e && c1.f)
                    {
                        int j1 = 0;
                        while (j1 < c1.i.a.size()) 
                        {
                            Object obj = c1.i.a(j1);
                            Object obj1 = ((a) (obj)).r;
                            if (((h) (obj1)).a)
                            {
                                Object obj2 = ((h) (obj1)).b;
                                com.jirbo.adcolony.q.c.c.a(((z) (obj2)).a, ((z) (obj2)).b);
                                ((z) (obj2)).c.b();
                                obj2 = ((z) (obj2)).d;
                                com.jirbo.adcolony.q.c.c.a(((y) (obj2)).e, ((y) (obj2)).f);
                                ((y) (obj2)).l.b();
                                ((y) (obj2)).m.b();
                                ((y) (obj2)).n.b();
                                obj1 = ((h) (obj1)).c;
                                com.jirbo.adcolony.q.c.c.a(((x) (obj1)).a, ((x) (obj1)).b);
                                obj1 = ((x) (obj1)).d;
                                com.jirbo.adcolony.q.c.c.a(((w) (obj1)).e, ((w) (obj1)).f);
                                ((w) (obj1)).l.b();
                                ((w) (obj1)).m.b();
                            }
                            obj1 = ((a) (obj)).q;
                            com.jirbo.adcolony.q.c.c.a(((r) (obj1)).a, ((r) (obj1)).b);
                            com.jirbo.adcolony.q.c.c.a(((r) (obj1)).c, ((r) (obj1)).d);
                            com.jirbo.adcolony.q.c.c.a(((r) (obj1)).e, ((r) (obj1)).f);
                            ((r) (obj1)).h.b();
                            ((r) (obj1)).i.b();
                            ((r) (obj1)).j.b();
                            ((r) (obj1)).k.b();
                            ((r) (obj1)).l.b();
                            ((r) (obj1)).m.b();
                            obj1 = ((a) (obj)).v;
                            com.jirbo.adcolony.q.c.c.a(((u) (obj1)).c, ((u) (obj1)).h);
                            com.jirbo.adcolony.q.c.c.a(((u) (obj1)).g, ((u) (obj1)).i);
                            ((u) (obj1)).k.b();
                            ((u) (obj1)).l.b();
                            obj1 = ((a) (obj)).t;
                            if (((m) (obj1)).d)
                            {
                                aa aa1 = ((m) (obj1)).h;
                                if (aa1.a)
                                {
                                    com.jirbo.adcolony.q.c.c.a(aa1.d, aa1.e);
                                    aa1.h.b();
                                    aa1.i.b();
                                    aa1.g.b();
                                    aa1.f.b();
                                }
                                obj1 = ((m) (obj1)).i;
                                if (((o) (obj1)).a)
                                {
                                    if (((o) (obj1)).f != null)
                                    {
                                        t t1 = ((o) (obj1)).f;
                                        com.jirbo.adcolony.q.c.c.a(t1.b, t1.c);
                                    }
                                    if (((o) (obj1)).h != null)
                                    {
                                        ((o) (obj1)).h.b();
                                    }
                                    if (((o) (obj1)).i != null)
                                    {
                                        ((o) (obj1)).i.b();
                                    }
                                    if (((o) (obj1)).j != null)
                                    {
                                        ((o) (obj1)).j.b();
                                    }
                                }
                            }
                            obj = ((a) (obj)).u;
                            com.jirbo.adcolony.q.c.c.a(((b) (obj)).d, ((b) (obj)).e);
                            ((b) (obj)).m.b();
                            ((b) (obj)).l.b();
                            obj1 = ((b) (obj)).o;
                            com.jirbo.adcolony.q.c.c.a(((p) (obj1)).b, ((p) (obj1)).c);
                            ((b) (obj)).n.b();
                            j1++;
                        }
                    }
                    i1++;
                }
            }
        }

        final boolean a(String s1, boolean flag, boolean flag1)
        {
            if (a)
            {
                if ((s1 = n.a(s1)) != null)
                {
                    return s1.a(flag, flag1);
                }
            }
            return false;
        }

        j()
        {
            e = false;
        }
    }

    static final class k
    {

        String a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;
        a.g h;

        k()
        {
        }
    }

    static final class l
    {

        boolean a;
        int b;
        int c;
        int d;
        int e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        String l;
        String m;
        String n;
        String o;
        String p;

        final boolean a()
        {
            if (a)
            {
                if (!com.jirbo.adcolony.q.c.c.a(f))
                {
                    return false;
                }
                if (!com.jirbo.adcolony.q.c.c.a(h))
                {
                    return false;
                }
            }
            return true;
        }

        final boolean a(a.g g1)
        {
            if (g1 == null)
            {
                return false;
            } else
            {
                a = g1.a("enabled", true);
                e = g1.e("delay");
                b = g1.e("width");
                c = g1.e("height");
                d = g1.e("scale");
                f = g1.a("image_normal", "");
                g = g1.a("image_normal_last_modified", "");
                h = g1.a("image_down", "");
                i = g1.a("image_down_last_modified", "");
                j = g1.a("click_action", "");
                k = g1.a("click_action_type", "");
                l = g1.a("label", "");
                m = g1.a("label_rgba", "");
                n = g1.a("label_shadow_rgba", "");
                o = g1.a("label_html", "");
                p = g1.a("event", "");
                return true;
            }
        }

        final void b()
        {
            com.jirbo.adcolony.q.c.c.a(f, g);
            com.jirbo.adcolony.q.c.c.a(h, i);
        }

        l()
        {
        }
    }

    static final class m
    {

        String a;
        int b;
        int c;
        boolean d;
        boolean e;
        boolean f;
        double g;
        aa h;
        o i;

        m()
        {
        }
    }

    static final class n
    {

        String a;

        n()
        {
        }
    }

    static final class o
    {

        boolean a;
        double b;
        boolean c;
        boolean d;
        String e;
        t f;
        String g;
        q h;
        l i;
        l j;

        final boolean a()
        {
            boolean flag2 = false;
            boolean flag1;
            if (!ao.c())
            {
                com.jirbo.adcolony.q.T = 8;
                flag1 = aj.c.b("Ad not ready due to no network connection.");
            } else
            {
                flag1 = flag2;
                if (a)
                {
                    t t1 = f;
                    boolean flag;
                    if (t1.a && !com.jirbo.adcolony.q.c.c.a(t1.b))
                    {
                        flag = false;
                    } else
                    {
                        flag = true;
                    }
                    flag1 = flag2;
                    if (flag)
                    {
                        flag1 = flag2;
                        if (h.a())
                        {
                            flag1 = flag2;
                            if (i.a())
                            {
                                flag1 = flag2;
                                if (j.a())
                                {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return flag1;
        }

        o()
        {
        }
    }

    static final class p
    {

        boolean a;
        String b;
        String c;

        p()
        {
        }
    }

    static final class q
    {

        int a;
        int b;
        int c;
        String d;
        String e;
        boolean f;

        final boolean a()
        {
            if (!f)
            {
                return true;
            } else
            {
                return com.jirbo.adcolony.q.c.c.a(d);
            }
        }

        final boolean a(a.g g1)
        {
            boolean flag = true;
            if (g1 == null)
            {
                flag = false;
            } else
            {
                f = g1.a("enabled", true);
                a = g1.e("width");
                b = g1.e("height");
                c = g1.e("scale");
                d = g1.a("image", "");
                e = g1.a("image_last_modified", "");
                if (e.equals(""))
                {
                    e = g1.a("last_modified", "");
                    return true;
                }
            }
            return flag;
        }

        final void b()
        {
            com.jirbo.adcolony.q.c.c.a(d, e);
        }

        q()
        {
        }
    }

    static final class r
    {

        String a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;
        q h;
        l i;
        l j;
        l k;
        l l;
        l m;

        r()
        {
        }
    }

    static final class s
    {

        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;

        s()
        {
        }
    }

    static final class t
    {

        boolean a;
        String b;
        String c;

        t()
        {
        }
    }

    static final class u
    {

        boolean a;
        boolean b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;
        String i;
        v j;
        q k;
        q l;

        u()
        {
        }
    }

    static final class v
    {

        boolean a;
        boolean b;
        String c;
        String d;
        String e;

        v()
        {
        }
    }

    static final class w
    {

        int a;
        String b;
        int c;
        int d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        q l;
        l m;

        w()
        {
        }
    }

    static final class x
    {

        String a;
        String b;
        q c;
        w d;

        x()
        {
        }
    }

    static final class y
    {

        int a;
        String b;
        int c;
        int d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        q l;
        l m;
        l n;

        y()
        {
        }
    }

    static final class z
    {

        String a;
        String b;
        q c;
        y d;

        z()
        {
        }
    }

}
