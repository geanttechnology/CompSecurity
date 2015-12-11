// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package u.aly:
//            bz, dd, ct, di, 
//            dj, cl, cm, ck, 
//            ag, cq, bg, cf, 
//            cs, dk, cy, dh, 
//            dg, bw, cg, db, 
//            de

public class ax
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, ax ax1)
            throws cf
        {
            cy1.j();
_L14:
            ct ct1;
            ct1 = cy1.l();
            if (ct1.b == 0)
            {
                cy1.k();
                ax1.K();
                return;
            }
            ct1.c;
            JVM INSTR tableswitch 1 11: default 88
        //                       1 103
        //                       2 139
        //                       3 175
        //                       4 211
        //                       5 246
        //                       6 281
        //                       7 317
        //                       8 353
        //                       9 389
        //                       10 428
        //                       11 464;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L12:
            break MISSING_BLOCK_LABEL_464;
_L2:
            break; /* Loop/switch isn't completed */
_L1:
            db.a(cy1, ct1.b);
_L15:
            cy1.m();
            if (true) goto _L14; else goto _L13
_L13:
            if (ct1.b == 8)
            {
                ax1.a = cy1.w();
                ax1.a(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L15
_L3:
            if (ct1.b == 11)
            {
                ax1.b = cy1.z();
                ax1.b(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L15
_L4:
            if (ct1.b == 11)
            {
                ax1.c = cy1.z();
                ax1.c(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L15
_L5:
            if (ct1.b == 4)
            {
                ax1.d = cy1.y();
                ax1.d(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L15
_L6:
            if (ct1.b == 4)
            {
                ax1.e = cy1.y();
                ax1.e(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L15
_L7:
            if (ct1.b == 11)
            {
                ax1.f = cy1.z();
                ax1.f(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L15
_L8:
            if (ct1.b == 8)
            {
                ax1.g = cy1.w();
                ax1.g(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L15
_L9:
            if (ct1.b == 11)
            {
                ax1.h = cy1.z();
                ax1.h(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L15
_L10:
            if (ct1.b == 8)
            {
                ax1.i = ag.a(cy1.w());
                ax1.i(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L15
_L11:
            if (ct1.b == 11)
            {
                ax1.j = cy1.z();
                ax1.j(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L15
            if (ct1.b == 12)
            {
                ax1.k = new bg();
                ax1.k.a(cy1);
                ax1.k(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L15
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (ax)bz1);
        }

        public void b(cy cy1, ax ax1)
            throws cf
        {
            ax1.K();
            cy1.a(ax.L());
            if (ax1.e())
            {
                cy1.a(ax.M());
                cy1.a(ax1.a);
                cy1.c();
            }
            if (ax1.b != null && ax1.i())
            {
                cy1.a(ax.N());
                cy1.a(ax1.b);
                cy1.c();
            }
            if (ax1.c != null && ax1.l())
            {
                cy1.a(ax.O());
                cy1.a(ax1.c);
                cy1.c();
            }
            if (ax1.o())
            {
                cy1.a(ax.P());
                cy1.a(ax1.d);
                cy1.c();
            }
            if (ax1.r())
            {
                cy1.a(ax.Q());
                cy1.a(ax1.e);
                cy1.c();
            }
            if (ax1.f != null && ax1.u())
            {
                cy1.a(ax.R());
                cy1.a(ax1.f);
                cy1.c();
            }
            if (ax1.x())
            {
                cy1.a(ax.S());
                cy1.a(ax1.g);
                cy1.c();
            }
            if (ax1.h != null && ax1.A())
            {
                cy1.a(ax.T());
                cy1.a(ax1.h);
                cy1.c();
            }
            if (ax1.i != null && ax1.D())
            {
                cy1.a(ax.U());
                cy1.a(ax1.i.a());
                cy1.c();
            }
            if (ax1.j != null && ax1.G())
            {
                cy1.a(ax.V());
                cy1.a(ax1.j);
                cy1.c();
            }
            if (ax1.k != null && ax1.J())
            {
                cy1.a(ax.W());
                ax1.k.b(cy1);
                cy1.c();
            }
            cy1.d();
            cy1.b();
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (ax)bz1);
        }

        private a()
        {
        }

        a(a a1)
        {
            this();
        }
    }

    private static class b
        implements dh
    {

        public a a()
        {
            return new a(null);
        }

        public dg b()
        {
            return a();
        }

        private b()
        {
        }

        b(b b1)
        {
            this();
        }
    }

    private static class c extends dj
    {

        public void a(cy cy1, ax ax1)
            throws cf
        {
            cy1 = (de)cy1;
            BitSet bitset = new BitSet();
            if (ax1.e())
            {
                bitset.set(0);
            }
            if (ax1.i())
            {
                bitset.set(1);
            }
            if (ax1.l())
            {
                bitset.set(2);
            }
            if (ax1.o())
            {
                bitset.set(3);
            }
            if (ax1.r())
            {
                bitset.set(4);
            }
            if (ax1.u())
            {
                bitset.set(5);
            }
            if (ax1.x())
            {
                bitset.set(6);
            }
            if (ax1.A())
            {
                bitset.set(7);
            }
            if (ax1.D())
            {
                bitset.set(8);
            }
            if (ax1.G())
            {
                bitset.set(9);
            }
            if (ax1.J())
            {
                bitset.set(10);
            }
            cy1.a(bitset, 11);
            if (ax1.e())
            {
                cy1.a(ax1.a);
            }
            if (ax1.i())
            {
                cy1.a(ax1.b);
            }
            if (ax1.l())
            {
                cy1.a(ax1.c);
            }
            if (ax1.o())
            {
                cy1.a(ax1.d);
            }
            if (ax1.r())
            {
                cy1.a(ax1.e);
            }
            if (ax1.u())
            {
                cy1.a(ax1.f);
            }
            if (ax1.x())
            {
                cy1.a(ax1.g);
            }
            if (ax1.A())
            {
                cy1.a(ax1.h);
            }
            if (ax1.D())
            {
                cy1.a(ax1.i.a());
            }
            if (ax1.G())
            {
                cy1.a(ax1.j);
            }
            if (ax1.J())
            {
                ax1.k.b(cy1);
            }
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (ax)bz1);
        }

        public void b(cy cy1, ax ax1)
            throws cf
        {
            cy1 = (de)cy1;
            BitSet bitset = cy1.b(11);
            if (bitset.get(0))
            {
                ax1.a = cy1.w();
                ax1.a(true);
            }
            if (bitset.get(1))
            {
                ax1.b = cy1.z();
                ax1.b(true);
            }
            if (bitset.get(2))
            {
                ax1.c = cy1.z();
                ax1.c(true);
            }
            if (bitset.get(3))
            {
                ax1.d = cy1.y();
                ax1.d(true);
            }
            if (bitset.get(4))
            {
                ax1.e = cy1.y();
                ax1.e(true);
            }
            if (bitset.get(5))
            {
                ax1.f = cy1.z();
                ax1.f(true);
            }
            if (bitset.get(6))
            {
                ax1.g = cy1.w();
                ax1.g(true);
            }
            if (bitset.get(7))
            {
                ax1.h = cy1.z();
                ax1.h(true);
            }
            if (bitset.get(8))
            {
                ax1.i = ag.a(cy1.w());
                ax1.i(true);
            }
            if (bitset.get(9))
            {
                ax1.j = cy1.z();
                ax1.j(true);
            }
            if (bitset.get(10))
            {
                ax1.k = new bg();
                ax1.k.a(cy1);
                ax1.k(true);
            }
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (ax)bz1);
        }

        private c()
        {
        }

        c(c c1)
        {
            this();
        }
    }

    private static class d
        implements dh
    {

        public c a()
        {
            return new c(null);
        }

        public dg b()
        {
            return a();
        }

        private d()
        {
        }

        d(d d1)
        {
            this();
        }
    }

    public static final class e extends Enum
        implements cg
    {

        public static final e a;
        public static final e b;
        public static final e c;
        public static final e d;
        public static final e e;
        public static final e f;
        public static final e g;
        public static final e h;
        public static final e i;
        public static final e j;
        public static final e k;
        private static final Map l;
        private static final e o[];
        private final short m;
        private final String n;

        public static e a(int i1)
        {
            switch (i1)
            {
            default:
                return null;

            case 1: // '\001'
                return a;

            case 2: // '\002'
                return b;

            case 3: // '\003'
                return c;

            case 4: // '\004'
                return d;

            case 5: // '\005'
                return e;

            case 6: // '\006'
                return f;

            case 7: // '\007'
                return g;

            case 8: // '\b'
                return h;

            case 9: // '\t'
                return i;

            case 10: // '\n'
                return j;

            case 11: // '\013'
                return k;
            }
        }

        public static e a(String s1)
        {
            return (e)l.get(s1);
        }

        public static e b(int i1)
        {
            e e1 = a(i1);
            if (e1 == null)
            {
                throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());
            } else
            {
                return e1;
            }
        }

        public static e valueOf(String s1)
        {
            return (e)Enum.valueOf(u/aly/ax$e, s1);
        }

        public static e[] values()
        {
            e ae[] = o;
            int i1 = ae.length;
            e ae1[] = new e[i1];
            System.arraycopy(ae, 0, ae1, 0, i1);
            return ae1;
        }

        public short a()
        {
            return m;
        }

        public String b()
        {
            return n;
        }

        static 
        {
            a = new e("TIME_ZONE", 0, (short)1, "time_zone");
            b = new e("LANGUAGE", 1, (short)2, "language");
            c = new e("COUNTRY", 2, (short)3, "country");
            d = new e("LATITUDE", 3, (short)4, "latitude");
            e = new e("LONGITUDE", 4, (short)5, "longitude");
            f = new e("CARRIER", 5, (short)6, "carrier");
            g = new e("LATENCY", 6, (short)7, "latency");
            h = new e("DISPLAY_NAME", 7, (short)8, "display_name");
            i = new e("ACCESS_TYPE", 8, (short)9, "access_type");
            j = new e("ACCESS_SUBTYPE", 9, (short)10, "access_subtype");
            k = new e("USER_INFO", 10, (short)11, "user_info");
            o = (new e[] {
                a, b, c, d, e, f, g, h, i, j, 
                k
            });
            l = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/ax$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                l.put(e1.b(), e1);
            } while (true);
        }

        private e(String s1, int i1, short word0, String s2)
        {
            super(s1, i1);
            m = word0;
            n = s2;
        }
    }


    private static final int A = 1;
    private static final int B = 2;
    private static final int C = 3;
    public static final Map l;
    private static final dd m = new dd("MiscInfo");
    private static final ct n = new ct("time_zone", (byte)8, (short)1);
    private static final ct o = new ct("language", (byte)11, (short)2);
    private static final ct p = new ct("country", (byte)11, (short)3);
    private static final ct q = new ct("latitude", (byte)4, (short)4);
    private static final ct r = new ct("longitude", (byte)4, (short)5);
    private static final ct s = new ct("carrier", (byte)11, (short)6);
    private static final ct t = new ct("latency", (byte)8, (short)7);
    private static final ct u = new ct("display_name", (byte)11, (short)8);
    private static final ct v = new ct("access_type", (byte)8, (short)9);
    private static final ct w = new ct("access_subtype", (byte)11, (short)10);
    private static final ct x = new ct("user_info", (byte)12, (short)11);
    private static final Map y;
    private static final int z = 0;
    private byte D;
    private e E[];
    public int a;
    public String b;
    public String c;
    public double d;
    public double e;
    public String f;
    public int g;
    public String h;
    public ag i;
    public String j;
    public bg k;

    public ax()
    {
        D = 0;
        E = (new e[] {
            e.a, e.b, e.c, e.d, e.e, e.f, e.g, e.h, e.i, e.j, 
            e.k
        });
    }

    public ax(ax ax1)
    {
        D = 0;
        E = (new e[] {
            e.a, e.b, e.c, e.d, e.e, e.f, e.g, e.h, e.i, e.j, 
            e.k
        });
        D = ax1.D;
        a = ax1.a;
        if (ax1.i())
        {
            b = ax1.b;
        }
        if (ax1.l())
        {
            c = ax1.c;
        }
        d = ax1.d;
        e = ax1.e;
        if (ax1.u())
        {
            f = ax1.f;
        }
        g = ax1.g;
        if (ax1.A())
        {
            h = ax1.h;
        }
        if (ax1.D())
        {
            i = ax1.i;
        }
        if (ax1.G())
        {
            j = ax1.j;
        }
        if (ax1.J())
        {
            k = new bg(ax1.k);
        }
    }

    static dd L()
    {
        return m;
    }

    static ct M()
    {
        return n;
    }

    static ct N()
    {
        return o;
    }

    static ct O()
    {
        return p;
    }

    static ct P()
    {
        return q;
    }

    static ct Q()
    {
        return r;
    }

    static ct R()
    {
        return s;
    }

    static ct S()
    {
        return t;
    }

    static ct T()
    {
        return u;
    }

    static ct U()
    {
        return v;
    }

    static ct V()
    {
        return w;
    }

    static ct W()
    {
        return x;
    }

    private void a(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        try
        {
            D = 0;
            a(((cy) (new cs(new dk(objectinputstream)))));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream)
        {
            throw new IOException(objectinputstream.getMessage());
        }
    }

    private void a(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        try
        {
            b(new cs(new dk(objectoutputstream)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOutputStream objectoutputstream)
        {
            throw new IOException(objectoutputstream.getMessage());
        }
    }

    public boolean A()
    {
        return h != null;
    }

    public ag B()
    {
        return i;
    }

    public void C()
    {
        i = null;
    }

    public boolean D()
    {
        return i != null;
    }

    public String E()
    {
        return j;
    }

    public void F()
    {
        j = null;
    }

    public boolean G()
    {
        return j != null;
    }

    public bg H()
    {
        return k;
    }

    public void I()
    {
        k = null;
    }

    public boolean J()
    {
        return k != null;
    }

    public void K()
        throws cf
    {
        if (k != null)
        {
            k.p();
        }
    }

    public ax a()
    {
        return new ax(this);
    }

    public ax a(double d1)
    {
        d = d1;
        d(true);
        return this;
    }

    public ax a(int i1)
    {
        a = i1;
        a(true);
        return this;
    }

    public ax a(String s1)
    {
        b = s1;
        return this;
    }

    public ax a(ag ag1)
    {
        i = ag1;
        return this;
    }

    public ax a(bg bg1)
    {
        k = bg1;
        return this;
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)y.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        D = bw.a(D, 0, flag);
    }

    public ax b(double d1)
    {
        e = d1;
        e(true);
        return this;
    }

    public ax b(String s1)
    {
        c = s1;
        return this;
    }

    public cg b(int i1)
    {
        return d(i1);
    }

    public void b()
    {
        a(false);
        a = 0;
        b = null;
        c = null;
        d(false);
        d = 0.0D;
        e(false);
        e = 0.0D;
        f = null;
        g(false);
        g = 0;
        h = null;
        i = null;
        j = null;
        k = null;
    }

    public void b(cy cy1)
        throws cf
    {
        ((dh)y.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        if (!flag)
        {
            b = null;
        }
    }

    public int c()
    {
        return a;
    }

    public ax c(int i1)
    {
        g = i1;
        g(true);
        return this;
    }

    public ax c(String s1)
    {
        f = s1;
        return this;
    }

    public void c(boolean flag)
    {
        if (!flag)
        {
            c = null;
        }
    }

    public e d(int i1)
    {
        return e.a(i1);
    }

    public ax d(String s1)
    {
        h = s1;
        return this;
    }

    public void d()
    {
        D = bw.b(D, 0);
    }

    public void d(boolean flag)
    {
        D = bw.a(D, 1, flag);
    }

    public ax e(String s1)
    {
        j = s1;
        return this;
    }

    public void e(boolean flag)
    {
        D = bw.a(D, 2, flag);
    }

    public boolean e()
    {
        return bw.a(D, 0);
    }

    public String f()
    {
        return b;
    }

    public void f(boolean flag)
    {
        if (!flag)
        {
            f = null;
        }
    }

    public bz g()
    {
        return a();
    }

    public void g(boolean flag)
    {
        D = bw.a(D, 3, flag);
    }

    public void h()
    {
        b = null;
    }

    public void h(boolean flag)
    {
        if (!flag)
        {
            h = null;
        }
    }

    public void i(boolean flag)
    {
        if (!flag)
        {
            i = null;
        }
    }

    public boolean i()
    {
        return b != null;
    }

    public String j()
    {
        return c;
    }

    public void j(boolean flag)
    {
        if (!flag)
        {
            j = null;
        }
    }

    public void k()
    {
        c = null;
    }

    public void k(boolean flag)
    {
        if (!flag)
        {
            k = null;
        }
    }

    public boolean l()
    {
        return c != null;
    }

    public double m()
    {
        return d;
    }

    public void n()
    {
        D = bw.b(D, 1);
    }

    public boolean o()
    {
        return bw.a(D, 1);
    }

    public double p()
    {
        return e;
    }

    public void q()
    {
        D = bw.b(D, 2);
    }

    public boolean r()
    {
        return bw.a(D, 2);
    }

    public String s()
    {
        return f;
    }

    public void t()
    {
        f = null;
    }

    public String toString()
    {
        boolean flag2 = false;
        StringBuilder stringbuilder = new StringBuilder("MiscInfo(");
        boolean flag1 = true;
        if (e())
        {
            stringbuilder.append("time_zone:");
            stringbuilder.append(a);
            flag1 = false;
        }
        boolean flag = flag1;
        if (i())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("language:");
            if (b == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(b);
            }
            flag = false;
        }
        flag1 = flag;
        if (l())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("country:");
            if (c == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(c);
            }
            flag1 = false;
        }
        flag = flag1;
        if (o())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("latitude:");
            stringbuilder.append(d);
            flag = false;
        }
        flag1 = flag;
        if (r())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("longitude:");
            stringbuilder.append(e);
            flag1 = false;
        }
        flag = flag1;
        if (u())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("carrier:");
            if (f == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(f);
            }
            flag = false;
        }
        flag1 = flag;
        if (x())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("latency:");
            stringbuilder.append(g);
            flag1 = false;
        }
        flag = flag1;
        if (A())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("display_name:");
            if (h == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(h);
            }
            flag = false;
        }
        flag1 = flag;
        if (D())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("access_type:");
            if (i == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(i);
            }
            flag1 = false;
        }
        if (G())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("access_subtype:");
            if (j == null)
            {
                stringbuilder.append("null");
                flag = flag2;
            } else
            {
                stringbuilder.append(j);
                flag = flag2;
            }
        } else
        {
            flag = flag1;
        }
        if (J())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("user_info:");
            if (k == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(k);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public boolean u()
    {
        return f != null;
    }

    public int v()
    {
        return g;
    }

    public void w()
    {
        D = bw.b(D, 3);
    }

    public boolean x()
    {
        return bw.a(D, 3);
    }

    public String y()
    {
        return h;
    }

    public void z()
    {
        h = null;
    }

    static 
    {
        y = new HashMap();
        y.put(u/aly/di, new b(null));
        y.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/ax$e);
        enummap.put(e.a, new cl("time_zone", (byte)2, new cm((byte)8)));
        enummap.put(e.b, new cl("language", (byte)2, new cm((byte)11)));
        enummap.put(e.c, new cl("country", (byte)2, new cm((byte)11)));
        enummap.put(e.d, new cl("latitude", (byte)2, new cm((byte)4)));
        enummap.put(e.e, new cl("longitude", (byte)2, new cm((byte)4)));
        enummap.put(e.f, new cl("carrier", (byte)2, new cm((byte)11)));
        enummap.put(e.g, new cl("latency", (byte)2, new cm((byte)8)));
        enummap.put(e.h, new cl("display_name", (byte)2, new cm((byte)11)));
        enummap.put(e.i, new cl("access_type", (byte)2, new ck((byte)16, u/aly/ag)));
        enummap.put(e.j, new cl("access_subtype", (byte)2, new cm((byte)11)));
        enummap.put(e.k, new cl("user_info", (byte)2, new cq((byte)12, u/aly/bg)));
        l = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/ax, l);
    }
}
