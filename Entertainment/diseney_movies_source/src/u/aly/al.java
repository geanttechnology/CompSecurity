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
//            cf, cs, dk, cy, 
//            dh, dg, bw, cz, 
//            cg, db, cv, de

public class al
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, al al1)
            throws cf
        {
            cy1.j();
_L7:
            Object obj = cy1.l();
            if (((ct) (obj)).b == 0)
            {
                cy1.k();
                String s1;
                String s2;
                int i1;
                if (!al1.e())
                {
                    throw new cz((new StringBuilder("Required field 'ts' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                } else
                {
                    al1.t();
                    return;
                }
            }
            ((ct) (obj)).c;
            JVM INSTR tableswitch 1 5: default 92
        //                       1 107
        //                       2 143
        //                       3 179
        //                       4 280
        //                       5 316;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
            break MISSING_BLOCK_LABEL_316;
_L1:
            db.a(cy1, ((ct) (obj)).b);
_L8:
            cy1.m();
              goto _L7
_L2:
            if (((ct) (obj)).b == 10)
            {
                al1.a = cy1.x();
                al1.a(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L8
_L3:
            if (((ct) (obj)).b == 11)
            {
                al1.b = cy1.z();
                al1.b(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L8
_L4:
            if (((ct) (obj)).b != 13)
            {
                break MISSING_BLOCK_LABEL_269;
            }
            obj = cy1.n();
            al1.c = new HashMap(((cv) (obj)).c * 2);
            i1 = 0;
_L9:
label0:
            {
                if (i1 < ((cv) (obj)).c)
                {
                    break label0;
                }
                cy1.o();
                al1.c(true);
            }
              goto _L8
            s1 = cy1.z();
            s2 = cy1.z();
            al1.c.put(s1, s2);
            i1++;
              goto _L9
            db.a(cy1, ((ct) (obj)).b);
              goto _L8
_L5:
            if (((ct) (obj)).b == 10)
            {
                al1.d = cy1.x();
                al1.d(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L8
            if (((ct) (obj)).b == 8)
            {
                al1.e = cy1.w();
                al1.e(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L8
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (al)bz1);
        }

        public void b(cy cy1, al al1)
            throws cf
        {
            al1.t();
            cy1.a(al.u());
            cy1.a(al.v());
            cy1.a(al1.a);
            cy1.c();
            if (al1.b != null)
            {
                cy1.a(al.w());
                cy1.a(al1.b);
                cy1.c();
            }
            if (al1.c == null) goto _L2; else goto _L1
_L1:
            Iterator iterator;
            cy1.a(al.x());
            cy1.a(new cv((byte)11, (byte)11, al1.c.size()));
            iterator = al1.c.entrySet().iterator();
_L6:
            if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
            cy1.e();
            cy1.c();
_L2:
            if (al1.p())
            {
                cy1.a(al.y());
                cy1.a(al1.d);
                cy1.c();
            }
            if (al1.s())
            {
                cy1.a(al.z());
                cy1.a(al1.e);
                cy1.c();
            }
            cy1.d();
            cy1.b();
            return;
_L4:
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            cy1.a((String)entry.getKey());
            cy1.a((String)entry.getValue());
            if (true) goto _L6; else goto _L5
_L5:
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (al)bz1);
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

        public void a(cy cy1, al al1)
            throws cf
        {
            cy1 = (de)cy1;
            cy1.a(al1.a);
            cy1.a(al1.b);
            cy1.a(al1.c.size());
            Object obj = al1.c.entrySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    obj = new BitSet();
                    if (al1.p())
                    {
                        ((BitSet) (obj)).set(0);
                    }
                    if (al1.s())
                    {
                        ((BitSet) (obj)).set(1);
                    }
                    cy1.a(((BitSet) (obj)), 2);
                    if (al1.p())
                    {
                        cy1.a(al1.d);
                    }
                    if (al1.s())
                    {
                        cy1.a(al1.e);
                    }
                    return;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                cy1.a((String)entry.getKey());
                cy1.a((String)entry.getValue());
            } while (true);
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (al)bz1);
        }

        public void b(cy cy1, al al1)
            throws cf
        {
            cy1 = (de)cy1;
            al1.a = cy1.x();
            al1.a(true);
            al1.b = cy1.z();
            al1.b(true);
            cv cv1 = new cv((byte)11, (byte)11, cy1.w());
            al1.c = new HashMap(cv1.c * 2);
            int i1 = 0;
            do
            {
                if (i1 >= cv1.c)
                {
                    al1.c(true);
                    BitSet bitset = cy1.b(2);
                    if (bitset.get(0))
                    {
                        al1.d = cy1.x();
                        al1.d(true);
                    }
                    if (bitset.get(1))
                    {
                        al1.e = cy1.w();
                        al1.e(true);
                    }
                    return;
                }
                String s1 = cy1.z();
                String s2 = cy1.z();
                al1.c.put(s1, s2);
                i1++;
            } while (true);
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (al)bz1);
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
            return (e)Enum.valueOf(u/aly/al$e, s1);
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
            a = new e("TS", 0, (short)1, "ts");
            b = new e("NAME", 1, (short)2, "name");
            c = new e("CKV", 2, (short)3, "ckv");
            d = new e("DURATION", 3, (short)4, "duration");
            e = new e("ACC", 4, (short)5, "acc");
            i = (new e[] {
                a, b, c, d, e
            });
            f = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/al$e).iterator();
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
    private static final dd g = new dd("Ekv");
    private static final ct h = new ct("ts", (byte)10, (short)1);
    private static final ct i = new ct("name", (byte)11, (short)2);
    private static final ct j = new ct("ckv", (byte)13, (short)3);
    private static final ct k = new ct("duration", (byte)10, (short)4);
    private static final ct l = new ct("acc", (byte)8, (short)5);
    private static final Map m;
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 2;
    public long a;
    public String b;
    public Map c;
    public long d;
    public int e;
    private byte q;
    private e r[];

    public al()
    {
        q = 0;
        r = (new e[] {
            e.d, e.e
        });
    }

    public al(long l1, String s1, Map map)
    {
        this();
        a = l1;
        a(true);
        b = s1;
        c = map;
    }

    public al(al al1)
    {
        q = 0;
        r = (new e[] {
            e.d, e.e
        });
        q = al1.q;
        a = al1.a;
        if (al1.i())
        {
            b = al1.b;
        }
        if (!al1.m()) goto _L2; else goto _L1
_L1:
        HashMap hashmap;
        Iterator iterator;
        hashmap = new HashMap();
        iterator = al1.c.entrySet().iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        c = hashmap;
_L2:
        d = al1.d;
        e = al1.e;
        return;
_L4:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        hashmap.put((String)entry.getKey(), (String)entry.getValue());
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

    public al a()
    {
        return new al(this);
    }

    public al a(int i1)
    {
        e = i1;
        e(true);
        return this;
    }

    public al a(long l1)
    {
        a = l1;
        a(true);
        return this;
    }

    public al a(String s1)
    {
        b = s1;
        return this;
    }

    public al a(Map map)
    {
        c = map;
        return this;
    }

    public void a(String s1, String s2)
    {
        if (c == null)
        {
            c = new HashMap();
        }
        c.put(s1, s2);
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)m.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        q = bw.a(q, 0, flag);
    }

    public al b(long l1)
    {
        d = l1;
        d(true);
        return this;
    }

    public cg b(int i1)
    {
        return c(i1);
    }

    public void b()
    {
        a(false);
        a = 0L;
        b = null;
        c = null;
        d(false);
        d = 0L;
        e(false);
        e = 0;
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

    public long c()
    {
        return a;
    }

    public e c(int i1)
    {
        return e.a(i1);
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
        q = bw.b(q, 0);
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
        return bw.a(q, 0);
    }

    public String f()
    {
        return b;
    }

    public bz g()
    {
        return a();
    }

    public void h()
    {
        b = null;
    }

    public boolean i()
    {
        return b != null;
    }

    public int j()
    {
        if (c == null)
        {
            return 0;
        } else
        {
            return c.size();
        }
    }

    public Map k()
    {
        return c;
    }

    public void l()
    {
        c = null;
    }

    public boolean m()
    {
        return c != null;
    }

    public long n()
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

    public int q()
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
        if (b == null)
        {
            throw new cz((new StringBuilder("Required field 'name' was not present! Struct: ")).append(toString()).toString());
        }
        if (c == null)
        {
            throw new cz((new StringBuilder("Required field 'ckv' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Ekv(");
        stringbuilder.append("ts:");
        stringbuilder.append(a);
        stringbuilder.append(", ");
        stringbuilder.append("name:");
        if (b == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(b);
        }
        stringbuilder.append(", ");
        stringbuilder.append("ckv:");
        if (c == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(c);
        }
        if (p())
        {
            stringbuilder.append(", ");
            stringbuilder.append("duration:");
            stringbuilder.append(d);
        }
        if (s())
        {
            stringbuilder.append(", ");
            stringbuilder.append("acc:");
            stringbuilder.append(e);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    static 
    {
        m = new HashMap();
        m.put(u/aly/di, new b(null));
        m.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/al$e);
        enummap.put(e.a, new cl("ts", (byte)1, new cm((byte)10)));
        enummap.put(e.b, new cl("name", (byte)1, new cm((byte)11)));
        enummap.put(e.c, new cl("ckv", (byte)1, new co((byte)13, new cm((byte)11), new cm((byte)11))));
        enummap.put(e.d, new cl("duration", (byte)2, new cm((byte)10)));
        enummap.put(e.e, new cl("acc", (byte)2, new cm((byte)8)));
        f = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/al, f);
    }
}
