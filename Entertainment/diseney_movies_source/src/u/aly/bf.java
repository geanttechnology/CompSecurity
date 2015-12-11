// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package u.aly:
//            bz, dd, ct, di, 
//            dj, cl, cq, aj, 
//            ai, ak, ax, ah, 
//            cn, av, bd, at, 
//            as, cf, cs, dk, 
//            cz, cy, dh, dg, 
//            cg, db, cu, de

public class bf
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, bf bf1)
            throws cf
        {
            cy1.j();
_L12:
            Object obj;
            obj = cy1.l();
            if (((ct) (obj)).b == 0)
            {
                cy1.k();
                bf1.I();
                return;
            }
            ((ct) (obj)).c;
            JVM INSTR tableswitch 1 9: default 80
        //                       1 95
        //                       2 142
        //                       3 189
        //                       4 236
        //                       5 283
        //                       6 330
        //                       7 430
        //                       8 530
        //                       9 577;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L2:
            break; /* Loop/switch isn't completed */
_L10:
            break MISSING_BLOCK_LABEL_577;
_L1:
            db.a(cy1, ((ct) (obj)).b);
_L13:
            cy1.m();
            if (true) goto _L12; else goto _L11
_L11:
            if (((ct) (obj)).b == 12)
            {
                bf1.a = new aj();
                bf1.a.a(cy1);
                bf1.a(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L13
_L3:
            if (((ct) (obj)).b == 12)
            {
                bf1.b = new ai();
                bf1.b.a(cy1);
                bf1.b(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L13
_L4:
            if (((ct) (obj)).b == 12)
            {
                bf1.c = new ak();
                bf1.c.a(cy1);
                bf1.c(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L13
_L5:
            if (((ct) (obj)).b == 12)
            {
                bf1.d = new ax();
                bf1.d.a(cy1);
                bf1.d(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L13
_L6:
            if (((ct) (obj)).b == 12)
            {
                bf1.e = new ah();
                bf1.e.a(cy1);
                bf1.e(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L13
_L7:
            int i1;
            if (((ct) (obj)).b != 15)
            {
                break MISSING_BLOCK_LABEL_419;
            }
            obj = cy1.p();
            bf1.f = new ArrayList(((cu) (obj)).b);
            i1 = 0;
_L14:
label0:
            {
                if (i1 < ((cu) (obj)).b)
                {
                    break label0;
                }
                cy1.q();
                bf1.f(true);
            }
              goto _L13
            av av1 = new av();
            av1.a(cy1);
            bf1.f.add(av1);
            i1++;
              goto _L14
            db.a(cy1, ((ct) (obj)).b);
              goto _L13
_L8:
            if (((ct) (obj)).b != 15)
            {
                break MISSING_BLOCK_LABEL_519;
            }
            obj = cy1.p();
            bf1.g = new ArrayList(((cu) (obj)).b);
            i1 = 0;
_L15:
label1:
            {
                if (i1 < ((cu) (obj)).b)
                {
                    break label1;
                }
                cy1.q();
                bf1.g(true);
            }
              goto _L13
            bd bd1 = new bd();
            bd1.a(cy1);
            bf1.g.add(bd1);
            i1++;
              goto _L15
            db.a(cy1, ((ct) (obj)).b);
              goto _L13
_L9:
            if (((ct) (obj)).b == 12)
            {
                bf1.h = new at();
                bf1.h.a(cy1);
                bf1.h(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L13
            if (((ct) (obj)).b == 12)
            {
                bf1.i = new as();
                bf1.i.a(cy1);
                bf1.i(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L13
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (bf)bz1);
        }

        public void b(cy cy1, bf bf1)
            throws cf
        {
            bf1.I();
            cy1.a(bf.J());
            if (bf1.a != null)
            {
                cy1.a(bf.K());
                bf1.a.b(cy1);
                cy1.c();
            }
            if (bf1.b != null)
            {
                cy1.a(bf.L());
                bf1.b.b(cy1);
                cy1.c();
            }
            if (bf1.c != null)
            {
                cy1.a(bf.M());
                bf1.c.b(cy1);
                cy1.c();
            }
            if (bf1.d != null)
            {
                cy1.a(bf.N());
                bf1.d.b(cy1);
                cy1.c();
            }
            if (bf1.e != null && bf1.r())
            {
                cy1.a(bf.O());
                bf1.e.b(cy1);
                cy1.c();
            }
            if (bf1.f == null || !bf1.w()) goto _L2; else goto _L1
_L1:
            Iterator iterator;
            cy1.a(bf.P());
            cy1.a(new cu((byte)12, bf1.f.size()));
            iterator = bf1.f.iterator();
_L6:
            if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
            cy1.f();
            cy1.c();
_L2:
            if (bf1.g != null && bf1.B())
            {
                cy1.a(bf.Q());
                cy1.a(new cu((byte)12, bf1.g.size()));
                for (iterator = bf1.g.iterator(); iterator.hasNext(); ((bd)iterator.next()).b(cy1))
                {
                    break MISSING_BLOCK_LABEL_379;
                }

                cy1.f();
                cy1.c();
            }
            if (bf1.h != null && bf1.E())
            {
                cy1.a(bf.R());
                bf1.h.b(cy1);
                cy1.c();
            }
            if (bf1.i != null && bf1.H())
            {
                cy1.a(bf.S());
                bf1.i.b(cy1);
                cy1.c();
            }
            cy1.d();
            cy1.b();
            return;
_L4:
            ((av)iterator.next()).b(cy1);
            if (true) goto _L6; else goto _L5
_L5:
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (bf)bz1);
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

        public void a(cy cy1, bf bf1)
            throws cf
        {
            cy1 = (de)cy1;
            bf1.a.b(cy1);
            bf1.b.b(cy1);
            bf1.c.b(cy1);
            bf1.d.b(cy1);
            BitSet bitset = new BitSet();
            if (bf1.r())
            {
                bitset.set(0);
            }
            if (bf1.w())
            {
                bitset.set(1);
            }
            if (bf1.B())
            {
                bitset.set(2);
            }
            if (bf1.E())
            {
                bitset.set(3);
            }
            if (bf1.H())
            {
                bitset.set(4);
            }
            cy1.a(bitset, 5);
            if (bf1.r())
            {
                bf1.e.b(cy1);
            }
            if (!bf1.w()) goto _L2; else goto _L1
_L1:
            Iterator iterator;
            cy1.a(bf1.f.size());
            iterator = bf1.f.iterator();
_L5:
            if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
            if (bf1.B())
            {
                cy1.a(bf1.g.size());
                for (iterator = bf1.g.iterator(); iterator.hasNext(); ((bd)iterator.next()).b(cy1))
                {
                    break MISSING_BLOCK_LABEL_251;
                }

            }
            if (bf1.E())
            {
                bf1.h.b(cy1);
            }
            if (bf1.H())
            {
                bf1.i.b(cy1);
            }
            return;
_L3:
            ((av)iterator.next()).b(cy1);
            if (true) goto _L5; else goto _L4
_L4:
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (bf)bz1);
        }

        public void b(cy cy1, bf bf1)
            throws cf
        {
            BitSet bitset;
            boolean flag;
            flag = false;
            cy1 = (de)cy1;
            bf1.a = new aj();
            bf1.a.a(cy1);
            bf1.a(true);
            bf1.b = new ai();
            bf1.b.a(cy1);
            bf1.b(true);
            bf1.c = new ak();
            bf1.c.a(cy1);
            bf1.c(true);
            bf1.d = new ax();
            bf1.d.a(cy1);
            bf1.d(true);
            bitset = cy1.b(5);
            if (bitset.get(0))
            {
                bf1.e = new ah();
                bf1.e.a(cy1);
                bf1.e(true);
            }
            if (!bitset.get(1)) goto _L2; else goto _L1
_L1:
            cu cu1;
            int i1;
            cu1 = new cu((byte)12, cy1.w());
            bf1.f = new ArrayList(cu1.b);
            i1 = 0;
_L7:
            if (i1 < cu1.b) goto _L4; else goto _L3
_L3:
            bf1.f(true);
_L2:
            if (!bitset.get(2)) goto _L6; else goto _L5
_L5:
            cu1 = new cu((byte)12, cy1.w());
            bf1.g = new ArrayList(cu1.b);
            i1 = ((flag) ? 1 : 0);
_L8:
            if (i1 < cu1.b)
            {
                break MISSING_BLOCK_LABEL_358;
            }
            bf1.g(true);
_L6:
            if (bitset.get(3))
            {
                bf1.h = new at();
                bf1.h.a(cy1);
                bf1.h(true);
            }
            if (bitset.get(4))
            {
                bf1.i = new as();
                bf1.i.a(cy1);
                bf1.i(true);
            }
            return;
_L4:
            av av1 = new av();
            av1.a(cy1);
            bf1.f.add(av1);
            i1++;
              goto _L7
            bd bd1 = new bd();
            bd1.a(cy1);
            bf1.g.add(bd1);
            i1++;
              goto _L8
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (bf)bz1);
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
        private static final Map j;
        private static final e m[];
        private final short k;
        private final String l;

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
            }
        }

        public static e a(String s1)
        {
            return (e)j.get(s1);
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
            return (e)Enum.valueOf(u/aly/bf$e, s1);
        }

        public static e[] values()
        {
            e ae[] = m;
            int i1 = ae.length;
            e ae1[] = new e[i1];
            System.arraycopy(ae, 0, ae1, 0, i1);
            return ae1;
        }

        public short a()
        {
            return k;
        }

        public String b()
        {
            return l;
        }

        static 
        {
            a = new e("CLIENT_STATS", 0, (short)1, "client_stats");
            b = new e("APP_INFO", 1, (short)2, "app_info");
            c = new e("DEVICE_INFO", 2, (short)3, "device_info");
            d = new e("MISC_INFO", 3, (short)4, "misc_info");
            e = new e("ACTIVATE_MSG", 4, (short)5, "activate_msg");
            f = new e("INSTANT_MSGS", 5, (short)6, "instant_msgs");
            g = new e("SESSIONS", 6, (short)7, "sessions");
            h = new e("IMPRINT", 7, (short)8, "imprint");
            i = new e("ID_TRACKING", 8, (short)9, "id_tracking");
            m = (new e[] {
                a, b, c, d, e, f, g, h, i
            });
            j = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/bf$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                j.put(e1.b(), e1);
            } while (true);
        }

        private e(String s1, int i1, short word0, String s2)
        {
            super(s1, i1);
            k = word0;
            l = s2;
        }
    }


    public static final Map j;
    private static final dd k = new dd("UALogEntry");
    private static final ct l = new ct("client_stats", (byte)12, (short)1);
    private static final ct m = new ct("app_info", (byte)12, (short)2);
    private static final ct n = new ct("device_info", (byte)12, (short)3);
    private static final ct o = new ct("misc_info", (byte)12, (short)4);
    private static final ct p = new ct("activate_msg", (byte)12, (short)5);
    private static final ct q = new ct("instant_msgs", (byte)15, (short)6);
    private static final ct r = new ct("sessions", (byte)15, (short)7);
    private static final ct s = new ct("imprint", (byte)12, (short)8);
    private static final ct t = new ct("id_tracking", (byte)12, (short)9);
    private static final Map u;
    public aj a;
    public ai b;
    public ak c;
    public ax d;
    public ah e;
    public List f;
    public List g;
    public at h;
    public as i;
    private e v[];

    public bf()
    {
        v = (new e[] {
            e.e, e.f, e.g, e.h, e.i
        });
    }

    public bf(aj aj1, ai ai1, ak ak1, ax ax1)
    {
        this();
        a = aj1;
        b = ai1;
        c = ak1;
        d = ax1;
    }

    public bf(bf bf1)
    {
        v = (new e[] {
            e.e, e.f, e.g, e.h, e.i
        });
        if (bf1.e())
        {
            a = new aj(bf1.a);
        }
        if (bf1.i())
        {
            b = new ai(bf1.b);
        }
        if (bf1.l())
        {
            c = new ak(bf1.c);
        }
        if (bf1.o())
        {
            d = new ax(bf1.d);
        }
        if (bf1.r())
        {
            e = new ah(bf1.e);
        }
        if (!bf1.w()) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = bf1.f.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        f = arraylist;
_L2:
        if (bf1.B())
        {
            arraylist = new ArrayList();
            for (iterator = bf1.g.iterator(); iterator.hasNext(); arraylist.add(new bd((bd)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_301;
            }

            g = arraylist;
        }
        if (bf1.E())
        {
            h = new at(bf1.h);
        }
        if (bf1.H())
        {
            i = new as(bf1.i);
        }
        return;
_L4:
        arraylist.add(new av((av)iterator.next()));
        if (true) goto _L6; else goto _L5
_L5:
    }

    static dd J()
    {
        return k;
    }

    static ct K()
    {
        return l;
    }

    static ct L()
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

    private void a(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        try
        {
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

    public void A()
    {
        g = null;
    }

    public boolean B()
    {
        return g != null;
    }

    public at C()
    {
        return h;
    }

    public void D()
    {
        h = null;
    }

    public boolean E()
    {
        return h != null;
    }

    public as F()
    {
        return i;
    }

    public void G()
    {
        i = null;
    }

    public boolean H()
    {
        return i != null;
    }

    public void I()
        throws cf
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'client_stats' was not present! Struct: ")).append(toString()).toString());
        }
        if (b == null)
        {
            throw new cz((new StringBuilder("Required field 'app_info' was not present! Struct: ")).append(toString()).toString());
        }
        if (c == null)
        {
            throw new cz((new StringBuilder("Required field 'device_info' was not present! Struct: ")).append(toString()).toString());
        }
        if (d == null)
        {
            throw new cz((new StringBuilder("Required field 'misc_info' was not present! Struct: ")).append(toString()).toString());
        }
        if (a != null)
        {
            a.m();
        }
        if (b != null)
        {
            b.H();
        }
        if (c != null)
        {
            c.ac();
        }
        if (d != null)
        {
            d.K();
        }
        if (e != null)
        {
            e.f();
        }
        if (h != null)
        {
            h.n();
        }
        if (i != null)
        {
            i.p();
        }
    }

    public e a(int i1)
    {
        return e.a(i1);
    }

    public bf a()
    {
        return new bf(this);
    }

    public bf a(List list)
    {
        f = list;
        return this;
    }

    public bf a(ah ah1)
    {
        e = ah1;
        return this;
    }

    public bf a(ai ai1)
    {
        b = ai1;
        return this;
    }

    public bf a(aj aj1)
    {
        a = aj1;
        return this;
    }

    public bf a(ak ak1)
    {
        c = ak1;
        return this;
    }

    public bf a(as as1)
    {
        i = as1;
        return this;
    }

    public bf a(at at1)
    {
        h = at1;
        return this;
    }

    public bf a(ax ax1)
    {
        d = ax1;
        return this;
    }

    public void a(av av1)
    {
        if (f == null)
        {
            f = new ArrayList();
        }
        f.add(av1);
    }

    public void a(bd bd1)
    {
        if (g == null)
        {
            g = new ArrayList();
        }
        g.add(bd1);
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)u.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        if (!flag)
        {
            a = null;
        }
    }

    public bf b(List list)
    {
        g = list;
        return this;
    }

    public cg b(int i1)
    {
        return a(i1);
    }

    public void b()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
    }

    public void b(cy cy1)
        throws cf
    {
        ((dh)u.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        if (!flag)
        {
            b = null;
        }
    }

    public aj c()
    {
        return a;
    }

    public void c(boolean flag)
    {
        if (!flag)
        {
            c = null;
        }
    }

    public void d()
    {
        a = null;
    }

    public void d(boolean flag)
    {
        if (!flag)
        {
            d = null;
        }
    }

    public void e(boolean flag)
    {
        if (!flag)
        {
            e = null;
        }
    }

    public boolean e()
    {
        return a != null;
    }

    public ai f()
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
        if (!flag)
        {
            g = null;
        }
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

    public ak j()
    {
        return c;
    }

    public void k()
    {
        c = null;
    }

    public boolean l()
    {
        return c != null;
    }

    public ax m()
    {
        return d;
    }

    public void n()
    {
        d = null;
    }

    public boolean o()
    {
        return d != null;
    }

    public ah p()
    {
        return e;
    }

    public void q()
    {
        e = null;
    }

    public boolean r()
    {
        return e != null;
    }

    public int s()
    {
        if (f == null)
        {
            return 0;
        } else
        {
            return f.size();
        }
    }

    public Iterator t()
    {
        if (f == null)
        {
            return null;
        } else
        {
            return f.iterator();
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("UALogEntry(");
        stringbuilder.append("client_stats:");
        if (a == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(a);
        }
        stringbuilder.append(", ");
        stringbuilder.append("app_info:");
        if (b == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(b);
        }
        stringbuilder.append(", ");
        stringbuilder.append("device_info:");
        if (c == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(c);
        }
        stringbuilder.append(", ");
        stringbuilder.append("misc_info:");
        if (d == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(d);
        }
        if (r())
        {
            stringbuilder.append(", ");
            stringbuilder.append("activate_msg:");
            if (e == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(e);
            }
        }
        if (w())
        {
            stringbuilder.append(", ");
            stringbuilder.append("instant_msgs:");
            if (f == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(f);
            }
        }
        if (B())
        {
            stringbuilder.append(", ");
            stringbuilder.append("sessions:");
            if (g == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(g);
            }
        }
        if (E())
        {
            stringbuilder.append(", ");
            stringbuilder.append("imprint:");
            if (h == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(h);
            }
        }
        if (H())
        {
            stringbuilder.append(", ");
            stringbuilder.append("id_tracking:");
            if (i == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(i);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public List u()
    {
        return f;
    }

    public void v()
    {
        f = null;
    }

    public boolean w()
    {
        return f != null;
    }

    public int x()
    {
        if (g == null)
        {
            return 0;
        } else
        {
            return g.size();
        }
    }

    public Iterator y()
    {
        if (g == null)
        {
            return null;
        } else
        {
            return g.iterator();
        }
    }

    public List z()
    {
        return g;
    }

    static 
    {
        u = new HashMap();
        u.put(u/aly/di, new b(null));
        u.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/bf$e);
        enummap.put(e.a, new cl("client_stats", (byte)1, new cq((byte)12, u/aly/aj)));
        enummap.put(e.b, new cl("app_info", (byte)1, new cq((byte)12, u/aly/ai)));
        enummap.put(e.c, new cl("device_info", (byte)1, new cq((byte)12, u/aly/ak)));
        enummap.put(e.d, new cl("misc_info", (byte)1, new cq((byte)12, u/aly/ax)));
        enummap.put(e.e, new cl("activate_msg", (byte)2, new cq((byte)12, u/aly/ah)));
        enummap.put(e.f, new cl("instant_msgs", (byte)2, new cn((byte)15, new cq((byte)12, u/aly/av))));
        enummap.put(e.g, new cl("sessions", (byte)2, new cn((byte)15, new cq((byte)12, u/aly/bd))));
        enummap.put(e.h, new cl("imprint", (byte)2, new cq((byte)12, u/aly/at)));
        enummap.put(e.i, new cl("id_tracking", (byte)2, new cq((byte)12, u/aly/as)));
        j = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/bf, j);
    }
}
