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
//            dj, cl, cm, cn, 
//            cq, ay, aw, be, 
//            cf, cs, dk, cz, 
//            cy, dh, dg, bw, 
//            cg, db, cu, de

public class bd
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, bd bd1)
            throws cf
        {
            cy1.j();
_L10:
            Object obj;
            obj = cy1.l();
            if (((ct) (obj)).b == 0)
            {
                cy1.k();
                if (!bd1.i())
                {
                    throw new cz((new StringBuilder("Required field 'start_time' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                }
                break MISSING_BLOCK_LABEL_506;
            }
            ((ct) (obj)).c;
            JVM INSTR tableswitch 1 7: default 100
        //                       1 115
        //                       2 151
        //                       3 187
        //                       4 223
        //                       5 259
        //                       6 359
        //                       7 459;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L2:
            break; /* Loop/switch isn't completed */
_L8:
            break MISSING_BLOCK_LABEL_459;
_L1:
            db.a(cy1, ((ct) (obj)).b);
_L11:
            cy1.m();
            if (true) goto _L10; else goto _L9
_L9:
            if (((ct) (obj)).b == 11)
            {
                bd1.a = cy1.z();
                bd1.a(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L11
_L3:
            if (((ct) (obj)).b == 10)
            {
                bd1.b = cy1.x();
                bd1.b(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L11
_L4:
            if (((ct) (obj)).b == 10)
            {
                bd1.c = cy1.x();
                bd1.c(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L11
_L5:
            if (((ct) (obj)).b == 10)
            {
                bd1.d = cy1.x();
                bd1.d(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L11
_L6:
            int i1;
            if (((ct) (obj)).b != 15)
            {
                break MISSING_BLOCK_LABEL_348;
            }
            obj = cy1.p();
            bd1.e = new ArrayList(((cu) (obj)).b);
            i1 = 0;
_L12:
label0:
            {
                if (i1 < ((cu) (obj)).b)
                {
                    break label0;
                }
                cy1.q();
                bd1.e(true);
            }
              goto _L11
            ay ay1 = new ay();
            ay1.a(cy1);
            bd1.e.add(ay1);
            i1++;
              goto _L12
            db.a(cy1, ((ct) (obj)).b);
              goto _L11
_L7:
            if (((ct) (obj)).b != 15)
            {
                break MISSING_BLOCK_LABEL_448;
            }
            obj = cy1.p();
            bd1.f = new ArrayList(((cu) (obj)).b);
            i1 = 0;
_L13:
label1:
            {
                if (i1 < ((cu) (obj)).b)
                {
                    break label1;
                }
                cy1.q();
                bd1.f(true);
            }
              goto _L11
            aw aw1 = new aw();
            aw1.a(cy1);
            bd1.f.add(aw1);
            i1++;
              goto _L13
            db.a(cy1, ((ct) (obj)).b);
              goto _L11
            if (((ct) (obj)).b == 12)
            {
                bd1.g = new be();
                bd1.g.a(cy1);
                bd1.g(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L11
            if (!bd1.l())
            {
                throw new cz((new StringBuilder("Required field 'end_time' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
            }
            if (!bd1.o())
            {
                throw new cz((new StringBuilder("Required field 'duration' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
            } else
            {
                bd1.C();
                return;
            }
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (bd)bz1);
        }

        public void b(cy cy1, bd bd1)
            throws cf
        {
            bd1.C();
            cy1.a(bd.D());
            if (bd1.a != null)
            {
                cy1.a(bd.E());
                cy1.a(bd1.a);
                cy1.c();
            }
            cy1.a(bd.F());
            cy1.a(bd1.b);
            cy1.c();
            cy1.a(bd.G());
            cy1.a(bd1.c);
            cy1.c();
            cy1.a(bd.H());
            cy1.a(bd1.d);
            cy1.c();
            if (bd1.e == null || !bd1.t()) goto _L2; else goto _L1
_L1:
            Iterator iterator;
            cy1.a(bd.I());
            cy1.a(new cu((byte)12, bd1.e.size()));
            iterator = bd1.e.iterator();
_L6:
            if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
            cy1.f();
            cy1.c();
_L2:
            if (bd1.f != null && bd1.y())
            {
                cy1.a(bd.J());
                cy1.a(new cu((byte)12, bd1.f.size()));
                for (iterator = bd1.f.iterator(); iterator.hasNext(); ((aw)iterator.next()).b(cy1))
                {
                    break MISSING_BLOCK_LABEL_292;
                }

                cy1.f();
                cy1.c();
            }
            if (bd1.g != null && bd1.B())
            {
                cy1.a(bd.K());
                bd1.g.b(cy1);
                cy1.c();
            }
            cy1.d();
            cy1.b();
            return;
_L4:
            ((ay)iterator.next()).b(cy1);
            if (true) goto _L6; else goto _L5
_L5:
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (bd)bz1);
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

        public void a(cy cy1, bd bd1)
            throws cf
        {
            cy1 = (de)cy1;
            cy1.a(bd1.a);
            cy1.a(bd1.b);
            cy1.a(bd1.c);
            cy1.a(bd1.d);
            BitSet bitset = new BitSet();
            if (bd1.t())
            {
                bitset.set(0);
            }
            if (bd1.y())
            {
                bitset.set(1);
            }
            if (bd1.B())
            {
                bitset.set(2);
            }
            cy1.a(bitset, 3);
            if (!bd1.t()) goto _L2; else goto _L1
_L1:
            Iterator iterator;
            cy1.a(bd1.e.size());
            iterator = bd1.e.iterator();
_L5:
            if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
            if (bd1.y())
            {
                cy1.a(bd1.f.size());
                for (iterator = bd1.f.iterator(); iterator.hasNext(); ((aw)iterator.next()).b(cy1))
                {
                    break MISSING_BLOCK_LABEL_197;
                }

            }
            if (bd1.B())
            {
                bd1.g.b(cy1);
            }
            return;
_L3:
            ((ay)iterator.next()).b(cy1);
            if (true) goto _L5; else goto _L4
_L4:
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (bd)bz1);
        }

        public void b(cy cy1, bd bd1)
            throws cf
        {
            BitSet bitset;
            boolean flag;
            flag = false;
            cy1 = (de)cy1;
            bd1.a = cy1.z();
            bd1.a(true);
            bd1.b = cy1.x();
            bd1.b(true);
            bd1.c = cy1.x();
            bd1.c(true);
            bd1.d = cy1.x();
            bd1.d(true);
            bitset = cy1.b(3);
            if (!bitset.get(0)) goto _L2; else goto _L1
_L1:
            cu cu1;
            int i1;
            cu1 = new cu((byte)12, cy1.w());
            bd1.e = new ArrayList(cu1.b);
            i1 = 0;
_L7:
            if (i1 < cu1.b) goto _L4; else goto _L3
_L3:
            bd1.e(true);
_L2:
            if (!bitset.get(1)) goto _L6; else goto _L5
_L5:
            cu1 = new cu((byte)12, cy1.w());
            bd1.f = new ArrayList(cu1.b);
            i1 = ((flag) ? 1 : 0);
_L8:
            if (i1 < cu1.b)
            {
                break MISSING_BLOCK_LABEL_250;
            }
            bd1.f(true);
_L6:
            if (bitset.get(2))
            {
                bd1.g = new be();
                bd1.g.a(cy1);
                bd1.g(true);
            }
            return;
_L4:
            ay ay1 = new ay();
            ay1.a(cy1);
            bd1.e.add(ay1);
            i1++;
              goto _L7
            aw aw1 = new aw();
            aw1.a(cy1);
            bd1.f.add(aw1);
            i1++;
              goto _L8
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (bd)bz1);
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
        private static final Map h;
        private static final e k[];
        private final short i;
        private final String j;

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
            }
        }

        public static e a(String s1)
        {
            return (e)h.get(s1);
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
            return (e)Enum.valueOf(u/aly/bd$e, s1);
        }

        public static e[] values()
        {
            e ae[] = k;
            int i1 = ae.length;
            e ae1[] = new e[i1];
            System.arraycopy(ae, 0, ae1, 0, i1);
            return ae1;
        }

        public short a()
        {
            return i;
        }

        public String b()
        {
            return j;
        }

        static 
        {
            a = new e("ID", 0, (short)1, "id");
            b = new e("START_TIME", 1, (short)2, "start_time");
            c = new e("END_TIME", 2, (short)3, "end_time");
            d = new e("DURATION", 3, (short)4, "duration");
            e = new e("PAGES", 4, (short)5, "pages");
            f = new e("LOCATIONS", 5, (short)6, "locations");
            g = new e("TRAFFIC", 6, (short)7, "traffic");
            k = (new e[] {
                a, b, c, d, e, f, g
            });
            h = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/bd$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                h.put(e1.b(), e1);
            } while (true);
        }

        private e(String s1, int i1, short word0, String s2)
        {
            super(s1, i1);
            i = word0;
            j = s2;
        }
    }


    public static final Map h;
    private static final dd i = new dd("Session");
    private static final ct j = new ct("id", (byte)11, (short)1);
    private static final ct k = new ct("start_time", (byte)10, (short)2);
    private static final ct l = new ct("end_time", (byte)10, (short)3);
    private static final ct m = new ct("duration", (byte)10, (short)4);
    private static final ct n = new ct("pages", (byte)15, (short)5);
    private static final ct o = new ct("locations", (byte)15, (short)6);
    private static final ct p = new ct("traffic", (byte)12, (short)7);
    private static final Map q;
    private static final int r = 0;
    private static final int s = 1;
    private static final int t = 2;
    public String a;
    public long b;
    public long c;
    public long d;
    public List e;
    public List f;
    public be g;
    private byte u;
    private e v[];

    public bd()
    {
        u = 0;
        v = (new e[] {
            e.e, e.f, e.g
        });
    }

    public bd(String s1, long l1, long l2, long l3)
    {
        this();
        a = s1;
        b = l1;
        b(true);
        c = l2;
        c(true);
        d = l3;
        d(true);
    }

    public bd(bd bd1)
    {
        u = 0;
        v = (new e[] {
            e.e, e.f, e.g
        });
        u = bd1.u;
        if (bd1.e())
        {
            a = bd1.a;
        }
        b = bd1.b;
        c = bd1.c;
        d = bd1.d;
        if (!bd1.t()) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = bd1.e.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        e = arraylist;
_L2:
        if (bd1.y())
        {
            arraylist = new ArrayList();
            for (iterator = bd1.f.iterator(); iterator.hasNext(); arraylist.add(new aw((aw)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_209;
            }

            f = arraylist;
        }
        if (bd1.B())
        {
            g = new be(bd1.g);
        }
        return;
_L4:
        arraylist.add(new ay((ay)iterator.next()));
        if (true) goto _L6; else goto _L5
_L5:
    }

    static dd D()
    {
        return i;
    }

    static ct E()
    {
        return j;
    }

    static ct F()
    {
        return k;
    }

    static ct G()
    {
        return l;
    }

    static ct H()
    {
        return m;
    }

    static ct I()
    {
        return n;
    }

    static ct J()
    {
        return o;
    }

    static ct K()
    {
        return p;
    }

    private void a(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        try
        {
            u = 0;
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

    public void C()
        throws cf
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'id' was not present! Struct: ")).append(toString()).toString());
        }
        if (g != null)
        {
            g.j();
        }
    }

    public e a(int i1)
    {
        return e.a(i1);
    }

    public bd a()
    {
        return new bd(this);
    }

    public bd a(long l1)
    {
        b = l1;
        b(true);
        return this;
    }

    public bd a(String s1)
    {
        a = s1;
        return this;
    }

    public bd a(List list)
    {
        e = list;
        return this;
    }

    public bd a(be be1)
    {
        g = be1;
        return this;
    }

    public void a(aw aw1)
    {
        if (f == null)
        {
            f = new ArrayList();
        }
        f.add(aw1);
    }

    public void a(ay ay1)
    {
        if (e == null)
        {
            e = new ArrayList();
        }
        e.add(ay1);
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)q.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        if (!flag)
        {
            a = null;
        }
    }

    public bd b(long l1)
    {
        c = l1;
        c(true);
        return this;
    }

    public bd b(List list)
    {
        f = list;
        return this;
    }

    public cg b(int i1)
    {
        return a(i1);
    }

    public void b()
    {
        a = null;
        b(false);
        b = 0L;
        c(false);
        c = 0L;
        d(false);
        d = 0L;
        e = null;
        f = null;
        g = null;
    }

    public void b(cy cy1)
        throws cf
    {
        ((dh)q.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        u = bw.a(u, 0, flag);
    }

    public String c()
    {
        return a;
    }

    public bd c(long l1)
    {
        d = l1;
        d(true);
        return this;
    }

    public void c(boolean flag)
    {
        u = bw.a(u, 1, flag);
    }

    public void d()
    {
        a = null;
    }

    public void d(boolean flag)
    {
        u = bw.a(u, 2, flag);
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

    public long f()
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
        u = bw.b(u, 0);
    }

    public boolean i()
    {
        return bw.a(u, 0);
    }

    public long j()
    {
        return c;
    }

    public void k()
    {
        u = bw.b(u, 1);
    }

    public boolean l()
    {
        return bw.a(u, 1);
    }

    public long m()
    {
        return d;
    }

    public void n()
    {
        u = bw.b(u, 2);
    }

    public boolean o()
    {
        return bw.a(u, 2);
    }

    public int p()
    {
        if (e == null)
        {
            return 0;
        } else
        {
            return e.size();
        }
    }

    public Iterator q()
    {
        if (e == null)
        {
            return null;
        } else
        {
            return e.iterator();
        }
    }

    public List r()
    {
        return e;
    }

    public void s()
    {
        e = null;
    }

    public boolean t()
    {
        return e != null;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Session(");
        stringbuilder.append("id:");
        if (a == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(a);
        }
        stringbuilder.append(", ");
        stringbuilder.append("start_time:");
        stringbuilder.append(b);
        stringbuilder.append(", ");
        stringbuilder.append("end_time:");
        stringbuilder.append(c);
        stringbuilder.append(", ");
        stringbuilder.append("duration:");
        stringbuilder.append(d);
        if (t())
        {
            stringbuilder.append(", ");
            stringbuilder.append("pages:");
            if (e == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(e);
            }
        }
        if (y())
        {
            stringbuilder.append(", ");
            stringbuilder.append("locations:");
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
            stringbuilder.append("traffic:");
            if (g == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(g);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public int u()
    {
        if (f == null)
        {
            return 0;
        } else
        {
            return f.size();
        }
    }

    public Iterator v()
    {
        if (f == null)
        {
            return null;
        } else
        {
            return f.iterator();
        }
    }

    public List w()
    {
        return f;
    }

    public void x()
    {
        f = null;
    }

    public boolean y()
    {
        return f != null;
    }

    public be z()
    {
        return g;
    }

    static 
    {
        q = new HashMap();
        q.put(u/aly/di, new b(null));
        q.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/bd$e);
        enummap.put(e.a, new cl("id", (byte)1, new cm((byte)11)));
        enummap.put(e.b, new cl("start_time", (byte)1, new cm((byte)10)));
        enummap.put(e.c, new cl("end_time", (byte)1, new cm((byte)10)));
        enummap.put(e.d, new cl("duration", (byte)1, new cm((byte)10)));
        enummap.put(e.e, new cl("pages", (byte)2, new cn((byte)15, new cq((byte)12, u/aly/ay))));
        enummap.put(e.f, new cl("locations", (byte)2, new cn((byte)15, new cq((byte)12, u/aly/aw))));
        enummap.put(e.g, new cl("traffic", (byte)2, new cq((byte)12, u/aly/be)));
        h = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/bd, h);
    }
}
