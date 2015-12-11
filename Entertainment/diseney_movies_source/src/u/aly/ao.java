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
import java.util.Set;

// Referenced classes of package u.aly:
//            bz, dd, ct, di, 
//            dj, cl, cm, co, 
//            cq, az, cf, cs, 
//            dk, cy, dh, dg, 
//            bw, cz, cg, db, 
//            cv, de

public class ao
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, ao ao1)
            throws cf
        {
            cy1.j();
_L7:
            Object obj = cy1.l();
            if (((ct) (obj)).b == 0)
            {
                cy1.k();
                String s1;
                az az1;
                int i1;
                if (!ao1.s())
                {
                    throw new cz((new StringBuilder("Required field 'ts' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                } else
                {
                    ao1.t();
                    return;
                }
            }
            ((ct) (obj)).c;
            JVM INSTR tableswitch 1 5: default 92
        //                       1 107
        //                       2 143
        //                       3 253
        //                       4 289
        //                       5 325;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
            break MISSING_BLOCK_LABEL_325;
_L1:
            db.a(cy1, ((ct) (obj)).b);
_L8:
            cy1.m();
              goto _L7
_L2:
            if (((ct) (obj)).b == 11)
            {
                ao1.a = cy1.z();
                ao1.a(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L8
_L3:
            if (((ct) (obj)).b != 13)
            {
                break MISSING_BLOCK_LABEL_242;
            }
            obj = cy1.n();
            ao1.b = new HashMap(((cv) (obj)).c * 2);
            i1 = 0;
_L9:
label0:
            {
                if (i1 < ((cv) (obj)).c)
                {
                    break label0;
                }
                cy1.o();
                ao1.b(true);
            }
              goto _L8
            s1 = cy1.z();
            az1 = new az();
            az1.a(cy1);
            ao1.b.put(s1, az1);
            i1++;
              goto _L9
            db.a(cy1, ((ct) (obj)).b);
              goto _L8
_L4:
            if (((ct) (obj)).b == 10)
            {
                ao1.c = cy1.x();
                ao1.c(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L8
_L5:
            if (((ct) (obj)).b == 8)
            {
                ao1.d = cy1.w();
                ao1.d(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L8
            if (((ct) (obj)).b == 10)
            {
                ao1.e = cy1.x();
                ao1.e(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L8
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (ao)bz1);
        }

        public void b(cy cy1, ao ao1)
            throws cf
        {
            ao1.t();
            cy1.a(ao.u());
            if (ao1.a != null)
            {
                cy1.a(ao.v());
                cy1.a(ao1.a);
                cy1.c();
            }
            if (ao1.b == null) goto _L2; else goto _L1
_L1:
            Iterator iterator;
            cy1.a(ao.w());
            cy1.a(new cv((byte)11, (byte)12, ao1.b.size()));
            iterator = ao1.b.entrySet().iterator();
_L6:
            if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
            cy1.e();
            cy1.c();
_L2:
            if (ao1.m())
            {
                cy1.a(ao.x());
                cy1.a(ao1.c);
                cy1.c();
            }
            if (ao1.p())
            {
                cy1.a(ao.y());
                cy1.a(ao1.d);
                cy1.c();
            }
            cy1.a(ao.z());
            cy1.a(ao1.e);
            cy1.c();
            cy1.d();
            cy1.b();
            return;
_L4:
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            cy1.a((String)entry.getKey());
            ((az)entry.getValue()).b(cy1);
            if (true) goto _L6; else goto _L5
_L5:
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (ao)bz1);
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

        public void a(cy cy1, ao ao1)
            throws cf
        {
            cy1 = (de)cy1;
            cy1.a(ao1.a);
            cy1.a(ao1.b.size());
            Object obj = ao1.b.entrySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    cy1.a(ao1.e);
                    obj = new BitSet();
                    if (ao1.m())
                    {
                        ((BitSet) (obj)).set(0);
                    }
                    if (ao1.p())
                    {
                        ((BitSet) (obj)).set(1);
                    }
                    cy1.a(((BitSet) (obj)), 2);
                    if (ao1.m())
                    {
                        cy1.a(ao1.c);
                    }
                    if (ao1.p())
                    {
                        cy1.a(ao1.d);
                    }
                    return;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                cy1.a((String)entry.getKey());
                ((az)entry.getValue()).b(cy1);
            } while (true);
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (ao)bz1);
        }

        public void b(cy cy1, ao ao1)
            throws cf
        {
            cy1 = (de)cy1;
            ao1.a = cy1.z();
            ao1.a(true);
            cv cv1 = new cv((byte)11, (byte)12, cy1.w());
            ao1.b = new HashMap(cv1.c * 2);
            int i1 = 0;
            do
            {
                if (i1 >= cv1.c)
                {
                    ao1.b(true);
                    ao1.e = cy1.x();
                    ao1.e(true);
                    BitSet bitset = cy1.b(2);
                    if (bitset.get(0))
                    {
                        ao1.c = cy1.x();
                        ao1.c(true);
                    }
                    if (bitset.get(1))
                    {
                        ao1.d = cy1.w();
                        ao1.d(true);
                    }
                    return;
                }
                String s1 = cy1.z();
                az az1 = new az();
                az1.a(cy1);
                ao1.b.put(s1, az1);
                i1++;
            } while (true);
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (ao)bz1);
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
        private static final Map f;
        private static final e i[];
        private final short g;
        private final String h;

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
            }
        }

        public static e a(String s1)
        {
            return (e)f.get(s1);
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
            return (e)Enum.valueOf(u/aly/ao$e, s1);
        }

        public static e[] values()
        {
            e ae[] = i;
            int i1 = ae.length;
            e ae1[] = new e[i1];
            System.arraycopy(ae, 0, ae1, 0, i1);
            return ae1;
        }

        public short a()
        {
            return g;
        }

        public String b()
        {
            return h;
        }

        static 
        {
            a = new e("NAME", 0, (short)1, "name");
            b = new e("PROPERTIES", 1, (short)2, "properties");
            c = new e("DURATION", 2, (short)3, "duration");
            d = new e("ACC", 3, (short)4, "acc");
            e = new e("TS", 4, (short)5, "ts");
            i = (new e[] {
                a, b, c, d, e
            });
            f = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/ao$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                f.put(e1.b(), e1);
            } while (true);
        }

        private e(String s1, int i1, short word0, String s2)
        {
            super(s1, i1);
            g = word0;
            h = s2;
        }
    }


    public static final Map f;
    private static final dd g = new dd("Event");
    private static final ct h = new ct("name", (byte)11, (short)1);
    private static final ct i = new ct("properties", (byte)13, (short)2);
    private static final ct j = new ct("duration", (byte)10, (short)3);
    private static final ct k = new ct("acc", (byte)8, (short)4);
    private static final ct l = new ct("ts", (byte)10, (short)5);
    private static final Map m;
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 2;
    public String a;
    public Map b;
    public long c;
    public int d;
    public long e;
    private byte q;
    private e r[];

    public ao()
    {
        q = 0;
        r = (new e[] {
            e.c, e.d
        });
    }

    public ao(String s1, Map map, long l1)
    {
        this();
        a = s1;
        b = map;
        e = l1;
        e(true);
    }

    public ao(ao ao1)
    {
        q = 0;
        r = (new e[] {
            e.c, e.d
        });
        q = ao1.q;
        if (ao1.e())
        {
            a = ao1.a;
        }
        if (!ao1.j()) goto _L2; else goto _L1
_L1:
        HashMap hashmap;
        Iterator iterator;
        hashmap = new HashMap();
        iterator = ao1.b.entrySet().iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        b = hashmap;
_L2:
        c = ao1.c;
        d = ao1.d;
        e = ao1.e;
        return;
_L4:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        hashmap.put((String)entry.getKey(), new az((az)entry.getValue()));
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void a(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        try
        {
            q = 0;
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

    static dd u()
    {
        return g;
    }

    static ct v()
    {
        return h;
    }

    static ct w()
    {
        return i;
    }

    static ct x()
    {
        return j;
    }

    static ct y()
    {
        return k;
    }

    static ct z()
    {
        return l;
    }

    public ao a()
    {
        return new ao(this);
    }

    public ao a(int i1)
    {
        d = i1;
        d(true);
        return this;
    }

    public ao a(long l1)
    {
        c = l1;
        c(true);
        return this;
    }

    public ao a(String s1)
    {
        a = s1;
        return this;
    }

    public ao a(Map map)
    {
        b = map;
        return this;
    }

    public void a(String s1, az az1)
    {
        if (b == null)
        {
            b = new HashMap();
        }
        b.put(s1, az1);
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)m.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        if (!flag)
        {
            a = null;
        }
    }

    public ao b(long l1)
    {
        e = l1;
        e(true);
        return this;
    }

    public cg b(int i1)
    {
        return c(i1);
    }

    public void b()
    {
        a = null;
        b = null;
        c(false);
        c = 0L;
        d(false);
        d = 0;
        e(false);
        e = 0L;
    }

    public void b(cy cy1)
        throws cf
    {
        ((dh)m.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        if (!flag)
        {
            b = null;
        }
    }

    public String c()
    {
        return a;
    }

    public e c(int i1)
    {
        return e.a(i1);
    }

    public void c(boolean flag)
    {
        q = bw.a(q, 0, flag);
    }

    public void d()
    {
        a = null;
    }

    public void d(boolean flag)
    {
        q = bw.a(q, 1, flag);
    }

    public void e(boolean flag)
    {
        q = bw.a(q, 2, flag);
    }

    public boolean e()
    {
        return a != null;
    }

    public int f()
    {
        if (b == null)
        {
            return 0;
        } else
        {
            return b.size();
        }
    }

    public bz g()
    {
        return a();
    }

    public Map h()
    {
        return b;
    }

    public void i()
    {
        b = null;
    }

    public boolean j()
    {
        return b != null;
    }

    public long k()
    {
        return c;
    }

    public void l()
    {
        q = bw.b(q, 0);
    }

    public boolean m()
    {
        return bw.a(q, 0);
    }

    public int n()
    {
        return d;
    }

    public void o()
    {
        q = bw.b(q, 1);
    }

    public boolean p()
    {
        return bw.a(q, 1);
    }

    public long q()
    {
        return e;
    }

    public void r()
    {
        q = bw.b(q, 2);
    }

    public boolean s()
    {
        return bw.a(q, 2);
    }

    public void t()
        throws cf
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'name' was not present! Struct: ")).append(toString()).toString());
        }
        if (b == null)
        {
            throw new cz((new StringBuilder("Required field 'properties' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Event(");
        stringbuilder.append("name:");
        if (a == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(a);
        }
        stringbuilder.append(", ");
        stringbuilder.append("properties:");
        if (b == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(b);
        }
        if (m())
        {
            stringbuilder.append(", ");
            stringbuilder.append("duration:");
            stringbuilder.append(c);
        }
        if (p())
        {
            stringbuilder.append(", ");
            stringbuilder.append("acc:");
            stringbuilder.append(d);
        }
        stringbuilder.append(", ");
        stringbuilder.append("ts:");
        stringbuilder.append(e);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    static 
    {
        m = new HashMap();
        m.put(u/aly/di, new b(null));
        m.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/ao$e);
        enummap.put(e.a, new cl("name", (byte)1, new cm((byte)11)));
        enummap.put(e.b, new cl("properties", (byte)1, new co((byte)13, new cm((byte)11), new cq((byte)12, u/aly/az))));
        enummap.put(e.c, new cl("duration", (byte)2, new cm((byte)10)));
        enummap.put(e.d, new cl("acc", (byte)2, new cm((byte)8)));
        enummap.put(e.e, new cl("ts", (byte)1, new cm((byte)10)));
        f = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/ao, f);
    }
}
